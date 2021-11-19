package com.example.spaclinic;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.spaclinic.models.User;

public class MainActivity extends AppCompatActivity {


    private EditText userBox;
    private EditText passBox;

    private Button loginButton;
    private Button signupButton;

    private DAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try{
            dao = new DAO(getApplicationContext());
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("Hello World!!");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userBox = (EditText) findViewById(R.id.user_box);
        passBox = (EditText) findViewById(R.id.pass_box);
        loginButton = (Button) findViewById(R.id.login_button);
        signupButton = (Button) findViewById(R.id.signup_button);
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public void login(View v){
        if(userBox.getText().toString().isEmpty() || passBox.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(),"Favor llenar todos los campos.",Toast.LENGTH_SHORT).show();
            return;
        }
        if(! new User().setEmail(userBox.getText().toString())){
            Toast.makeText(getApplicationContext(),"Favor revisar formato email.",Toast.LENGTH_SHORT).show();
            return;
        }
        User login = (User) dao.Get(User.class, "email = " + userBox.getText().toString());
        if(!login.isPassword(passBox.getText().toString())){
            Toast.makeText(getApplicationContext(),"Contraseña incorrecta!.",Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(getApplicationContext(),"Bienvenido!",Toast.LENGTH_SHORT).show();
        // TODO: Go to main application once logged in.
    }

    public void goSignUp(View v){
        Intent i = new Intent(this, SignUp.class);
        startActivity(i);
    }

}