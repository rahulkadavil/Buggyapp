package com.rahulkadavil.buggyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button proceed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        proceed = findViewById(R.id.proceed);
        //Special flag1 flag{644feb4ff0f8e4b3290d9d36a4e326e7}
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startlogin = new Intent(v.getContext(),login.class);
                startActivity(startlogin);
            }
        });
    }
}