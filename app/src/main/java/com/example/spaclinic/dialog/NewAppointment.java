package com.example.spaclinic.dialog;

import static java.util.stream.Collectors.toList;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.spaclinic.DAO;
import com.example.spaclinic.MainActivity;
import com.example.spaclinic.Menu;
import com.example.spaclinic.R;
import com.example.spaclinic.models.Appointment;
import com.example.spaclinic.models.Patient;
import com.example.spaclinic.models.Service;
import com.example.spaclinic.models.User;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class NewAppointment extends AppCompatDialogFragment {

    private List<User> users = new ArrayList<User>();
    private List<Service> services = new ArrayList<Service>();
    private List<Patient> patients = new ArrayList<Patient>();

    private EditText id;

    private DatePickerDialog datePickerDialog;

    private TimePickerDialog timePickerDialog;

    private Spinner patientSpinner;
    private Spinner serviceSpinner;
    private Spinner userSpinner;

    private EditText dateEdit;
    private EditText timeEdit;
    private Date appointedDate;

    private long appointedTime;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.new_appointment, null);

        patientSpinner = view.findViewById(R.id.patientSpinner);
        serviceSpinner = view.findViewById(R.id.serviceSpinner);
        userSpinner = view.findViewById(R.id.userSpinner);
        dateEdit = view.findViewById(R.id.dateEdit);

        timeEdit = view.findViewById(R.id.timeEdit);

        try{
            initDatePicker();
            DAO dao = new DAO(getContext());
            users = (List<User>) dao.GetAll(User.class, "");
            services = (List<Service>) dao.GetAll(Service.class, "");
            patients = (List<Patient>) dao.GetAll(Patient.class, "");

        }catch (Exception e){
            e.printStackTrace();
        }

        User loggedUser = new MainActivity().getLoggedin();

        ArrayAdapter userAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, users);
        userAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        userSpinner.setAdapter(userAdapter);

        int spinnerPosition = userAdapter.getPosition(loggedUser);
        userSpinner.setSelection(spinnerPosition);

        ArrayAdapter serviceAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, services);
        serviceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        serviceSpinner.setAdapter(serviceAdapter);

        ArrayAdapter patientAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, patients);
        patientAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        patientSpinner.setAdapter(patientAdapter);

        System.out.println("Hello World!");
        builder.setView(view)
                .setTitle("Nueva Cita")
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("Crear", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        if(dateEdit.getText().toString().isEmpty()
                        || timeEdit.getText().toString().isEmpty()){
                            Toast.makeText(getContext(),"Favor llenar todos los campos.",Toast.LENGTH_SHORT).show();
                            return;
                        }

                        Appointment appointment = new Appointment();

                        appointment.setUserID(loggedUser.getID());
                        appointment.setCreationTime("'" + getDateString(new Date()) + "'");
                        appointment.setAppointedDate("'" + dateEdit.getText().toString() + "'");
                        appointment.setAppointedTime("'" + timeEdit.getText().toString() + "'");
                        appointment.setServiceID(((Service) serviceSpinner.getSelectedItem()).getId());
                        appointment.setPatientID(((Patient) patientSpinner.getSelectedItem()).getId());
                        appointment.setSucceeded(0);

                        DAO dao = new DAO(getContext());
                        if(dao.insert(appointment) == -1){
                            Toast.makeText(getContext(),"Ocurrio un error.",Toast.LENGTH_SHORT).show();
                            return;
                        }
                        Toast.makeText(getContext(),"Cita creada correctamente!",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getContext(), Menu.class);
                        getContext().startActivity(intent);
                    }
                });

        return builder.create();
    }

    private void initDatePicker(){

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                Calendar calendar = Calendar.getInstance();
                calendar.set(year, month, day);
                appointedDate = calendar.getTime();
                dateEdit.setText(getDateString(appointedDate));
            }
        };

        dateEdit.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                datePickerDialog = new DatePickerDialog(getContext(), dateSetListener,year,month,day );
                datePickerDialog.show();
            }
        });
        dateEdit.setText(getDateString(new Date()));

        int hour = calendar.get(Calendar.HOUR);
        int min = calendar.get(Calendar.MINUTE);

        TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                timeEdit.setText(getTimeString(timePicker));
            }
        };
        timeEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePickerDialog = new TimePickerDialog(getContext(), timeSetListener, hour, min, true);
                timePickerDialog.show();
            }
        });

    }

    private String getDateString(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(date);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private String getTimeString(TimePicker timePicker){
        return timePicker.getHour() + ":" + timePicker.getMinute();
    }

}
