package com.smhrd.j.android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class HealthDaily extends AppCompatActivity {
    Spinner spinner;
   private EditText health_edt;
   private CalendarView health_cal;
   private RadioButton health_rd;
   private Button health_add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_daily);

        health_edt=findViewById(R.id.health_edt);
        health_cal =findViewById(R.id.health_cal);
        health_add = findViewById(R.id.health_add);

        //달력
        health_cal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                health_edt.setVisibility(View.VISIBLE);
                health_add.setVisibility(View.VISIBLE);  //버튼
                health_rd.setVisibility(View.INVISIBLE);
            }
        });

        // 추가버튼
        health_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



       //스피너
        final String[] data = getResources().getStringArray(R.array.healtharray);
        ArrayAdapter<String> adapter =new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,data);
        Spinner spinner1 = (Spinner) findViewById(R.id.health_sp);
        spinner1.setAdapter(adapter);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.v("health",""+spinner1.getItemAtPosition(position));
                ((TextView)parent.getChildAt(0)).setTextColor(Color.BLACK);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

//    //radio button check
//    public void onRadioButtonClicked(View view) {
//        boolean checked = ((RadioButton) view).isChecked();
//
//        switch(view.getId()) {
//            case R.id.health_rd:
//                if (checked) {
//                    Log.v("check", "체크");
//                    break;
//                }
//        }
//    }


}