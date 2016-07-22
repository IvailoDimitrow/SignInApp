package com.example.acer.signinapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    public static final String DEFAULT = "N/A";
    Button signUp;
    EditText usernameAcc;
    EditText passwordAcc;
    String name;
    String pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signUp = (Button)findViewById(R.id.sign_up);
        usernameAcc = (EditText) findViewById(R.id.username_acc);
        passwordAcc = (EditText) findViewById(R.id.password_acc);
        SharedPreferences sp = getSharedPreferences("MyData" , Context.MODE_PRIVATE);
         name = sp.getString("Username",DEFAULT);
         pass = sp.getString("Password",DEFAULT);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pass == passwordAcc.toString() && name == usernameAcc.toString()) {
                    Intent intent1 = new Intent(Main2Activity.this, Main3Activity.class);
                    startActivity(intent1);
                } else
                    Toast.makeText(Main2Activity.this, "Username or password is wrong", Toast.LENGTH_SHORT).show();

                }

        });
    }

}
