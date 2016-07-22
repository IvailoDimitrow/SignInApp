package com.example.acer.signinapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    EditText username;
    EditText password;
    EditText confirmPassword;
    Button create;
    Button cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondlayout);
        username = (EditText) findViewById(R.id.Username_Create);
        password = (EditText) findViewById(R.id.Password_Create);
        confirmPassword = (EditText) findViewById(R.id.ConfirmPassword_Create);
        create = (Button) findViewById(R.id.create_btn);
        cancel = (Button) findViewById(R.id.cancel_btn);
        SharedPreferences sp = getSharedPreferences("MyData", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("Username", username.getText().toString());
        editor.putString("Password", password.getText().toString());
        editor.commit();
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(password.getText().toString() != confirmPassword.getText().toString()) {
                    Toast.makeText(MainActivity.this, "Please enter your password correctly", Toast.LENGTH_SHORT).show();
                }
                if(password.getText().length() == 0 || username.getText().length() == 0){
                    Toast.makeText(MainActivity.this, "Please enter username and password", Toast.LENGTH_SHORT).show();

                } else {
                    Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                    startActivity(intent);
                }
            }



        });





    }




}
