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
import android.widget.ImageView;
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

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class HealthDaily extends AppCompatActivity {

    Spinner spinner;
    private ImageView shp1, back1;
   private EditText health_edt;
   private CalendarView health_cal;
   private CheckBox health_ck;
   private Button health_add, btn_nv1, btn_nv2, btn_nv3;
   private LinearLayout layout1;
   int state_cnt;
   private String ck_check;
    private String result = "";

    private RequestQueue queue;
    private StringRequest stringRequest;

    Calendar myCalendar = Calendar.getInstance();



    private ArrayList<HealthDTO> list = new ArrayList<HealthDTO>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_daily);

        //서버 값 가져오는 매소드
        checkHealth();


        health_edt=findViewById(R.id.health_edt);
        health_cal =findViewById(R.id.health_cal);
        health_add = findViewById(R.id.health_add);
        layout1 = (LinearLayout) findViewById(R.id.layout1);
        health_ck = findViewById(R.id.health_ck);
        shp1=findViewById(R.id.shp1);
        back1=findViewById(R.id.back1);
        btn_nv1 = findViewById(R.id.btn_nv1);
        btn_nv2 = findViewById(R.id.btn_nv2);
        btn_nv3 = findViewById(R.id.btn_nv3);

        //날짜 비교해서 캘린더보여주기
        for(int i = 0; i < list.size(); i++){
//            if(건강일지 날짜 가져오기 == list.get(i).getDate()){
//                layout1.setVisibility((View.VISIBLE));
//            }else{
//                layout1.setVisibility((View.INVISIBLE));
//            }
        }

        //캘린더
        health_cal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                month += 1;
                //health_edt.setText(String.format("%d년 %d월 %d일" ,year,month,dayOfMonth));  //캘린더날짜 출력
               // date_daily =

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
                Log.v("health",""+position+spinner1.getItemAtPosition(position));
                ((TextView)parent.getChildAt(0)).setTextColor(Color.BLACK);
                //스피너값
                result = (String)spinner1.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        //추가버튼 클릭했을 때 서버로 값 넘김
        health_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (health_ck.isChecked()){
                    ck_check = "true";
                    // health_ck.setChecked(true);
                }else{
                    ck_check = "false";
                    // health_ck.setChecked(false);
                }

                sendRequest();
            }
        });

        //뒤로가기
        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        //장바구니
        shp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Cart.class);
                startActivity(intent);
            }
        });


        //헬스케어
        btn_nv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HealthCare.class);
                startActivity(intent);
            }
        });

        //메인
        btn_nv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Main.class);
                startActivity(intent);
            }
        });

        //마이페이지
        btn_nv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MyPage.class);
                startActivity(intent);
            }
        });


    }

    //서버에서 데이터 받아오기
    public void checkHealth() {
        queue = Volley.newRequestQueue(this);
        String url = "http://222.102.104.135:3000/NoteOut";
        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override//응답을 받아왔으 때
            public void onResponse(String response) { //server로 부터 데이터를 받아오는 곳
                Log.v("resultValue", response);

                if(!response.equals("null")){
                    try {
                        JSONObject jsonObject = new JSONObject(response);
                        String date = jsonObject.getString("date");
                        String health_daily = jsonObject.getString("daily");
                        String id = jsonObject.getString("id");
                        String health_check = jsonObject.getString("ck");
                        String health_spinner = jsonObject.getString("sp");
                        //HealthDTO info = new HealthDTO(date, health_daily,id,health_check,health_spinner);

                    }catch (JSONException e) {
                        e.printStackTrace();
                    }
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
                return params;
            }
        };

        queue.add(stringRequest);
    }



    //서버로 데이터 보내기
    public void sendRequest() {
        queue = Volley.newRequestQueue(this);
        String url = "http://222.102.104.135:3000/NoteIn";
        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override//응답을 받아왔으 때
            public void onResponse(String response) { //server로 부터 데이터를 받아오는 곳
                Log.v("resultValue", response);

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String value = jsonObject.getString("check");
                    Log.v("resultValue", value);
                    if (value.equals("true")){



                    }else {
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
                params.put("daily", health_edt.getText().toString());
                params.put("ck",ck_check);
                params.put("sp",result);
                return params;
            }
        };

        queue.add(stringRequest);
    }


    //뒤로가기
    @Override
    public void onBackPressed() {
        Log.v("Back","확인");
        super.onBackPressed();
    }



}