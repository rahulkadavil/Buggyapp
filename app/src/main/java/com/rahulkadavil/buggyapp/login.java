package com.rahulkadavil.buggyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    EditText username;
    EditText password;
    Button login;
    Button hint;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = findViewById(R.id.login_button);
        username = findViewById(R.id.email_edit);
        password = findViewById(R.id.password_edit);
        hint = findViewById(R.id.hint);

        hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(),"Decompile the app using apktool or Jadx-gui and search for hardcoded credentials", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("buggyapp","Username: "+username.getText());
                Log.v("buggyapp","Password: "+password.getText());
                if(username.getText().toString().equals("admin") && password.getText().toString().equals("@dm1n")){

                    Intent startmain = new Intent(v.getContext(),Flagchecker.class);
                    startActivity(startmain);
                }

                else if(username.getText().toString().equals("admin") && password.getText().toString().equals("p@55w0rd")){
                    Log.v("buggyapp","flag 2: flag{1be1f0f821e030c4c8e315a06bd8cd35)");
                    Intent startmain = new Intent(v.getContext(),Flagchecker.class);
                    startActivity(startmain);
                }
                else{
                    Toast toast = Toast.makeText(getApplicationContext(),"Wrong redentials", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
    }
}