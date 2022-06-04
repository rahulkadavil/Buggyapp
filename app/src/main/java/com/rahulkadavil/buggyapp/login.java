package com.rahulkadavil.buggyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//Login Screen
public class login extends AppCompatActivity {

    //Initialzie Varibales
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
        // Hint button display messages on click
        hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(),"Decompile the app using apktool or Jadx-gui and search for hardcoded credentials", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        // Login button click actions
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            // Logs user credentials entered by user
            public void onClick(View v) {
                Log.v("buggyapp","Username: "+username.getText());
                Log.v("buggyapp","Password: "+password.getText());
                // User credentials compared to hardcoded credentials
                if(username.getText().toString().equals("admin") && password.getText().toString().equals("@dm1n")){
                    // Start Vulnerability activity if credentials are valid
                    Intent startmain = new Intent(v.getContext(),Vulnerability.class);
                    startActivity(startmain);
                    //Create and store sensitive information unencrypted in Shared preferences
                    SharedPreferences logindata = getSharedPreferences("login", Context.MODE_PRIVATE);
                    SharedPreferences.Editor addlogin = logindata.edit();
                    addlogin.putString("Username",username.getText().toString());
                    addlogin.putString("Password",password.getText().toString());
                    addlogin.putString("Flag","Flag{e13cb9214a2ec0fc0fe6f734758d370e}");
                    addlogin.commit();

                }
                // secret credentials that logs flag
                else if(username.getText().toString().equals("admin") && password.getText().toString().equals("p@55w0rd")){
                    Log.v("buggyapp","flag 2: flag{1be1f0f821e030c4c8e315a06bd8cd35)");
                    Intent startvul = new Intent(v.getContext(),Vulnerability.class);
                    startActivity(startvul);
                }
                //Invalid credentials code
                else{
                    Toast toast = Toast.makeText(getApplicationContext(),"Wrong redentials", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
    }
}