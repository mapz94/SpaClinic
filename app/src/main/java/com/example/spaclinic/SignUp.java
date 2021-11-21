package com.example.spaclinic;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.spaclinic.models.User;

import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;

public class SignUp extends AppCompatActivity {

    private EditText signupEmail;
    private EditText signupFirstName;
    private EditText signupLastName;
    private EditText signupPassword;

    private DAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try{
            dao = new DAO(getApplicationContext());
        }catch(Exception e){
            e.printStackTrace();
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signupEmail = (EditText) findViewById(R.id.signupemail);
        signupFirstName = (EditText) findViewById(R.id.signupfirstname);
        signupLastName = (EditText) findViewById(R.id.signuplastname);
        signupPassword = (EditText) findViewById(R.id.singuppassword);

    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public void SignUp(View v){
        if(signupPassword.getText().toString().isEmpty() ||
           signupFirstName.getText().toString().isEmpty() ||
           signupLastName.getText().toString().isEmpty() ||
           signupEmail.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(),"Favor llenar todos los campos.",Toast.LENGTH_SHORT).show();
            return;
        }
        User signup = new User();
        signup.setFirstName(signupFirstName.getText().toString());
        signup.setLastName(signupLastName.getText().toString());
        if(!signup.setEmail(signupEmail.getText().toString())){
            Toast.makeText(getApplicationContext(),"Favor revisar formato email.",Toast.LENGTH_SHORT).show();
            return;
        }
        if(!signup.setPassword(signupPassword.getText().toString())){
            Toast.makeText(getApplicationContext(),"Contraseña debe ser igual o mayor a 8 caracteres.",Toast.LENGTH_SHORT).show();
            return;
        }
        List<User> users = (List<User>) dao.GetAll(User.class, "email = '" + signup.getEmail().toString() + "'") ;
        if(users.size() > 0){
            Toast.makeText(getApplicationContext(),"Este usuario ya existe!",Toast.LENGTH_SHORT).show();
            return;
        }
        if(dao.insert(signup) == -1){
            Toast.makeText(getApplicationContext(),"Hubo un error inesperado.",Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(getApplicationContext(),"Favor inciar sesión con su nueva cuenta.",Toast.LENGTH_SHORT).show();

        signUpBack(v);
    }

    public void signUpBack(View v){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}