package com.example.spaclinic;

import android.content.Context;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

import com.example.spaclinic.models.Column;
import com.example.spaclinic.models.Table;
import com.example.spaclinic.models.User;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.spaclinic", appContext.getPackageName());
    }
    private Class getClass(String className, String packageName) {
        try {
            return Class.forName(packageName + "."
                    + className.substring(0, className.lastIndexOf('.')));
        } catch (ClassNotFoundException e) {
            // handle the exception
        }
        return null;
    }

    @Test
    public void update(){

        System.out.println("----update-----");
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        DAO dao = new DAO(appContext);

        /*
        User user = (User) dao.Get(User.class,"ID = 1", "");
        System.out.println(user.getEmail());
        user.setEmail("miguel.apg94@gmail.com");
        dao.update(user, "");

        List<User> users = (List<User>) dao.GetAll(User.class, "");
        System.out.println(users.size());
        for(User user1 : users){
            System.out.println("-------");
            System.out.println(user1.getID());
            System.out.println(user1.getFirstName());
            System.out.println(user1.getLastName());
            System.out.println(user1.getEmail());
            System.out.println(user1.getPassword());
        }*/


    }

    @Test
    public void insertAndGet(){

        System.out.println("---------insertAndGet----------");
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        DAO dao = new DAO(appContext);

        User user = new User();
        user.setFirstName("Miguel");
        user.setLastName("Pérez");
        user.setEmail("miguel.apg94@gmail.com");
        user.setPassword("Password1994*");

        System.out.println("-------Creating...");
        System.out.println(user.getFirstName());
        System.out.println(user.getLastName());
        System.out.println(user.getEmail());
        System.out.println(user.getPassword());
        System.out.println("-------");

        //dao.insert(user);

        List<User> users = (List<User>) dao.GetAll(User.class, "");
        System.out.println(users.size());
        for(User user1 : users){
            System.out.println("-------");
            System.out.println(user1.getID());
            System.out.println(user1.getFirstName());
            System.out.println(user1.getLastName());
            System.out.println(user1.getEmail());
            System.out.println(user1.getPassword());
        }

    }

    @Test
    public void get(){

        System.out.println("---------get----------");
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        DAO dao = new DAO(appContext);

        User user = (User) dao.Get(User.class, "email = 'miguel.apg94@gmail.com'");
        System.out.println("----Getting...---");
        System.out.println(user.getID());
        System.out.println(user.getFirstName());
        System.out.println(user.getLastName());
        System.out.println(user.getEmail());
        System.out.println(user.getPassword());


    }

    @Test
    public void delete(){

        System.out.println("---------delete----------");
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        DAO dao = new DAO(appContext);

        //dao.delete(User.class, "");


    }
}