package com.manager.spaclinic;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.spaclinic.R;
import com.manager.spaclinic.models.User;

public class MainActivity extends AppCompatActivity {


    private EditText userBox;
    private EditText passBox;

    private Button loginButton;
    private Button signupButton;

    private Button whatsthis;

    private DAO dao;

    private LoadingDialog loadingDialog;

    private static User loggedin;

    public User getLoggedin(){
        return this.loggedin;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        loadingDialog = new LoadingDialog(MainActivity.this);

        try{
            dao = new DAO(getApplicationContext());
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("Hello World!!");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        whatsthis = (Button) findViewById(R.id.HowToUse);
        whatsthis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), HowToUse.class);
                view.getContext().startActivity(i);
            }
        });

        userBox = (EditText) findViewById(R.id.user_box);
        passBox = (EditText) findViewById(R.id.pass_box);
        loginButton = (Button) findViewById(R.id.login_button);
        signupButton = (Button) findViewById(R.id.signup_button);

        Runnable r = new Runnable() {
            public void run() {
                openDialog();
            }
        };
        r.run();
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public void login(View v){
        loadingDialog.startLoadingDialog();
        if(userBox.getText().toString().isEmpty() || passBox.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(),"Favor llenar todos los campos.",Toast.LENGTH_SHORT).show();
            loadingDialog.dismissDialog();
            return;
        }
        if(! new User().setEmail(userBox.getText().toString())){
            Toast.makeText(getApplicationContext(),"Favor revisar formato email.",Toast.LENGTH_SHORT).show();
            loadingDialog.dismissDialog();
            return;
        }
        User login = (User) dao.Get(User.class, "email = '" + userBox.getText().toString() + "'");
        if(!login.isPassword(passBox.getText().toString())){
            Toast.makeText(getApplicationContext(),"Contraseña incorrecta!.",Toast.LENGTH_SHORT).show();
            loadingDialog.dismissDialog();
            return;
        }
        loggedin = login;
        loadingDialog.dismissDialog();
        Toast.makeText(getApplicationContext(),"Bienvenido!",Toast.LENGTH_SHORT).show();
        // TODO: Go to main application once logged in.
        Intent i = new Intent(this, Menu.class);
        this.startActivity(i);
    }

    public void goSignUp(View v){
        Intent i = new Intent(this, SignUp.class);
        startActivity(i);
    }

    public void openDialog(){
        DialogUse dialogUse = new DialogUse();
        dialogUse.show(this.getSupportFragmentManager(), "Instrucciones");
    }



}