package com.example.spaclinic;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.spaclinic.helpers.DBHelper;
import com.example.spaclinic.models.Table;
import com.example.spaclinic.models.Column;

import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class DAO {
    private static SQLiteDatabase db;

    public DAO(Context context) {
        if (db == null) {
            DAO.db = new DBHelper(context).getDatabase();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void create(Class<?> _class){
        String tableName  = _class.getDeclaredAnnotation(Table.class).table_name();
        Column[] columns = _class.getAnnotationsByType(Column.class);
        Field[] fields = _class.getDeclaredFields();

        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS " + tableName);
        String prefix = " (";

        for (Field field: fields){
            Column column = field.getAnnotation(Column.class);
            sb.append(prefix);
            prefix = ",";
            String nameprops = column.column_name() + " " + column.column_props();
            sb.append(nameprops);
        }
        sb.append(")");
        db.execSQL(sb.toString());
        System.out.println(sb.toString());
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public long insert(Object model) {
        String tableName  = model.getClass().getDeclaredAnnotation(Table.class).table_name();
        this.create(model.getClass());
        ContentValues values = new ContentValues();
        Field[] fields = model.getClass().getDeclaredFields();
        for (Field field : fields) {
            Column column = field.getAnnotation(Column.class);
            field.setAccessible(true);
            try{ // Try se solicita por JAVA reflector al obtener el nombre de las clases.
                if (!column.column_name().equals("ID")) {
                    if (field.getType().equals(String.class)) {
                        values.put(column.column_name(), field.get(model).toString());
                    } else if (field.getType().equals(int.class)) {
                        values.put(column.column_name(),
                                Integer.parseInt(field.get(model).toString()));
                    } else if (field.getType().equals(Date.class)) {
                        values.put(
                                column.column_name(),
                                DateFormat.getDateInstance(DateFormat.MEDIUM,
                                        new Locale("es", "CL")).format(
                                        field.get(model)));
                    } else if (field.getType().equals(double.class)) {
                        values.put(column.column_name(),
                                Double.parseDouble(field.get(model).toString()));
                    }
                }
            }catch (IllegalAccessException e){

            }

        }
        return db.insert(tableName, null, values);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public int update(Object model, String where){
        String tableName  = model.getClass().getDeclaredAnnotation(Table.class).table_name();
        this.create(model.getClass());
        ContentValues values = new ContentValues();
        Field[] fields = model.getClass().getDeclaredFields();
        for (Field field : fields) {
            Column column = field.getAnnotation(Column.class);
            try {
                field.setAccessible(true);
                if (!column.column_name().equals("ID")) {
                    if (field.getType().equals(String.class)) {
                        values.put(column.column_name(), field.get(model).toString());
                    } else if (field.getType().equals(int.class)) {
                        values.put(column.column_name(),
                                Integer.parseInt(field.get(model).toString()));
                    } else if (field.getType().equals(Date.class)) {
                        values.put(
                                column.column_name(),
                                DateFormat.getDateInstance(DateFormat.MEDIUM,
                                        new Locale("es", "CL")).format(
                                        field.get(model)));
                    } else if (field.getType().equals(double.class)) {
                        values.put(column.column_name(),
                                Double.parseDouble(field.get(model).toString()));
                    }
                }else{
                    where = where.isEmpty() ? "ID = " + field.get(model) : where;
                }
            } catch (IllegalArgumentException | IllegalAccessException e){

            }
        }
        return db.update(tableName, values, where, null);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public int delete(Class<?> modelClass, String where) {
        String tableName  = modelClass.getDeclaredAnnotation(Table.class).table_name();
        int result = db.delete(tableName, where, null);
        if(where.isEmpty()){
            db.execSQL("DELETE FROM SQLITE_SEQUENCE WHERE NAME = '" + tableName + "'");
        }
        return result;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Object Get(Class<?> modelClass, String where) {
        String orderBy = "";
        this.create(modelClass);
        String tableName  = modelClass.getDeclaredAnnotation(Table.class).table_name();
        Cursor c = db.query(tableName,
                getColumns(modelClass.getDeclaredFields()), where, null, null,
                null, orderBy);
        c.moveToFirst();
        if (c.getCount() > 0) {
            try {
                Object object = modelClass.newInstance();
                int cont = 0;
                for (Field field : modelClass.getDeclaredFields()) {
                    field.setAccessible(true);
                    if (field.getType().equals(String.class)) {
                        field.set(object, c.getString(cont));
                    } else if (field.getType().equals(int.class)) {
                        field.set(object, c.getInt(cont));
                    } else if (field.getType().equals(Date.class)) {
                        field.set(
                                object,
                                DateFormat.getDateInstance(DateFormat.MEDIUM,
                                        new Locale("es", "CL")).parse(
                                        c.getString(cont)));
                    } else if (field.getType().equals(double.class)) {
                        field.set(object, c.getDouble(cont));
                    }
                    cont++;
                }
                c.close();
                return object;
            } catch (Exception e) {
            }
        }
        c.close();
        return null;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public List<?> GetAll(Class<?> modelClass, String where) {
        this.create(modelClass);
        String tableName  = modelClass.getDeclaredAnnotation(Table.class).table_name();
        Cursor c = db.query(tableName,
                getColumns(modelClass.getDeclaredFields()), where, null, null,
                null, null);
        c.moveToFirst();
        List<Object> entities = new ArrayList<Object>();
        if (c.getCount() > 0) {
            do {
                try {
                    Object object = modelClass.newInstance();
                    int cont = 0;
                    for (Field field : object.getClass().getDeclaredFields()) {
                        field.setAccessible(true);
                        if (field.getType().equals(String.class)) {
                            field.set(object, c.getString(cont));
                        } else if (field.getType().equals(int.class)) {
                            field.set(object, c.getInt(cont));
                        } else if (field.getType().equals(Date.class)) {
                            field.set(
                                    object,
                                    DateFormat.getDateInstance(
                                            DateFormat.MEDIUM,
                                            new Locale("es", "CL")).parse(
                                            c.getString(cont)));
                        } else if (field.getType().equals(double.class)) {
                            field.set(object, c.getDouble(cont));
                        }
                        cont++;
                    }
                    entities.add(object);
                } catch (InstantiationException | IllegalAccessException | ParseException e) {
                }
            } while (c.moveToNext());
        }
        c.close();
        return entities;
    }

    private String[] getColumns(Field[] fields) {
        String[] columns = new String[fields.length];
        int column = 0;
        for (Field field : fields) {
            columns[column] = field.getName();
            column++;
        }
        return columns;
    }
}
