package com.rahulkadavil.buggyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Flagchecker extends AppCompatActivity {
EditText flagedittext;
Button flagbutton;
String flag_value;
List<String> list_flag = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flagchecker);
        flagedittext = findViewById(R.id.flagedit);
        flagbutton = findViewById(R.id.flagcheck);
        list_flag.add(getString(R.string.f1));
        flagbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("buggyapp",""+list_flag);
                if(list_flag.contains(flagedittext.getText().toString())){
                    Toast toast = Toast.makeText(getApplicationContext(),"Correct Flag", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else{
                    Log.v("buggyapp","Error flag");
                }

            }
        });
    }
}