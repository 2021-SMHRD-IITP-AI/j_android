package com.smhrd.j.android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class HealthDaily extends AppCompatActivity {

    Spinner spinner;
   private EditText health_edt;
   private CalendarView health_cal;
   private CheckBox health_ck;
   private Button health_add;
   private LinearLayout layout1;
   int state_cnt ;
   String sp_health,ck_check,sp_cnt;


    private RequestQueue queue;
    private StringRequest stringRequest;

    Calendar myCalendar = Calendar.getInstance();
  //  DatePickerDialog.OnDateSetListener myDatePicker = new DatePickerDialog.OnDateSetListener() {
      //  @Override
//        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//            myCalendar.set(Calendar.YEAR, year);
//            myCalendar.set(Calendar.MONTH, month);
//            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
//            updateLabel();
//        }
//
//    };
//


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_daily);

        health_edt=findViewById(R.id.health_edt);
        health_cal =findViewById(R.id.health_cal);
        health_add = findViewById(R.id.health_add);
        layout1 = (LinearLayout) findViewById(R.id.layout1);
        health_ck = findViewById(R.id.health_ck);


//        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
//        {
//            view = inflater.inflate(R.layout.frag2, container, false);
//
//            mCalendarView = (CalendarView) view.findViewById(R.id.calendarView);
//
//            health_cal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() // 날짜 선택 이벤트
//            {
//                @Override
//                public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth)
//                {
//                    String date = year + "/" + (month + 1) + "/" + dayOfMonth;
//                    Log.v("date",date); // 선택한 날짜로 설정
//
//                }
//            });
//        }

        health_cal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                month += 1;
                //health_edt.setText(String.format("%d년 %d월 %d일" ,year,month,dayOfMonth));
                if (state_cnt % 2 == 0) {
                    layout1.setVisibility((View.VISIBLE));
                    state_cnt++;

                } else {
                    layout1.setVisibility((View.INVISIBLE));
                    state_cnt++;
                }

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
                //Log.v("health",""+spinner1.getItemAtPosition(position));
                if (spinner1.getItemAtPosition(position).toString() =="감기"){
                    sp_cnt = "0";
                }else if (spinner1.getItemAtPosition(position).toString() =="근육통"){
                    sp_cnt = "1";
                }

                ((TextView)parent.getChildAt(0)).setTextColor(Color.BLACK);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




        health_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                daily = health_edt.getText().toString();
//                Log.v("a", daily);
//                health_edt.setText(daily);
//                Log.v("a", sp_health);
                if (health_ck.isChecked()){
                    ck_check = "true";
                    health_ck.setChecked(true);
                }else{
                    ck_check = "false";
                    health_ck.setChecked(false);
                }
//                health_add.setVisibility(View.INVISIBLE);
                sendRequest();
            }
        });

    }



    public void sendRequest() {
        queue = Volley.newRequestQueue(this);
        String url = "http://222.102.104.135:3000/Join";
        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override//응답을 받아왔으 때
            public void onResponse(String response) { //server로 부터 데이터를 받아오는 곳
                Log.v("resultValue", response);

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String value = jsonObject.getString("check");
                    Log.v("resultValue", value);
                    if (value.equals("true")){
//                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
//                        startActivity(intent);
                        health_edt.setText("daily");
                        if (response.equals("ck")== true ) {
                            health_ck.setChecked(true);
                        }else{
                            health_ck.setChecked(false);
                        }

                       // if (response. == "0")





                    }else {
                        health_edt.setText("");
                        health_edt.setText("");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {//server 통신 시 Error발생하면 오는 곳
                error.printStackTrace();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError { //server로 데이터를 보낼 시 넣어주는 곳
                Map<String,String> params = new HashMap<String, String>();
                //한번에 바꾸기 alt+shift+r
                params.put("daily", health_edt.getText().toString());
                params.put("ck",health_ck.getText().toString());
                params.put("sp",sp_cnt);
                return params;
            }
        };

        queue.add(stringRequest);
    }


}