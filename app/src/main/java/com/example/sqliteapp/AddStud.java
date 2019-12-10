package com.example.sqliteapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;



public class AddStud  extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addstud);
    }
    public void Store(View v){
        TextView temp = findViewById(R.id.editText);
        String fName = temp.getText().toString();
        temp = findViewById(R.id.editText2);
        String lName = temp.getText().toString();
        temp = findViewById(R.id.editText3);
        String cwid = temp.getText().toString();
        temp = findViewById(R.id.editText4);
        String courseID = temp.getText().toString();
        temp = findViewById(R.id.editText5);
        String grade= temp.getText().toString();
        String arg = "textPersonName";
        if((fName != arg) &&
                (lName!= arg)&&
                (cwid != arg) &&
                (courseID != arg) &&
                (grade != arg)){
            MainActivity.myDb.insertData(fName,lName,grade,courseID,cwid);
            Students.firstName.add(fName);
            Students.lastName.add(lName);
            Students.ID.add(cwid);
            super.finish();
        }
    }
}