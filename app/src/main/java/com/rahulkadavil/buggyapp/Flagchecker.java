package com.rahulkadavil.buggyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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
String DB_Name = "score";
String table_name = "current_score";
String flag_col = "flag_col";
String user_flag;
List<String> list_flag = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flagchecker);
        flagedittext = findViewById(R.id.flagedit);
        flagbutton = findViewById(R.id.flagcheck);
        list_flag.add(getString(R.string.f1));

        flagbutton.setOnClickListener(new View.OnClickListener() {
            SQLiteDatabase score_db = openOrCreateDatabase("score",MODE_PRIVATE,null);
            @Override
            public void onClick(View v) {
                Log.v("buggyapp",""+list_flag);
                if(list_flag.contains(flagedittext.getText().toString())){
                    Toast toast = Toast.makeText(getApplicationContext(),"Correct Flag", Toast.LENGTH_SHORT);
                    toast.show();
                    Log.v("bugyapp","Hello");
                    user_flag =flagedittext.getText().toString();
                    score_db.execSQL("CREATE TABLE IF NOT EXISTS current_score(flag VARCHAR);");
                    Cursor resultSet = score_db.rawQuery("Select * from current_score",null);
                    if(resultSet.moveToFirst()){
                        while(!resultSet.isAfterLast()){
                            String found_flag = resultSet.getString(0);
                            if(user_flag.equals(found_flag)){

                            }
                            else{
                                score_db.execSQL("INSERT INTO current_score VALUES('"+user_flag+"')");
                            }
                            Log.v("bugyapp",""+found_flag);
                            resultSet.moveToNext();
                        }
                    }
                }
                else{
                    Log.v("buggyapp","Error flag");
                }

            }
        });
    }
}