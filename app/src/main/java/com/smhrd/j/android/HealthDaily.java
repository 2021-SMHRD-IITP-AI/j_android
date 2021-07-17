package com.smhrd.j.android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class HealthDaily extends AppCompatActivity{

    Spinner spinner;
    private ImageView shp1, back1;
    private EditText health_edt;
    private CalendarView health_cal;
    private CheckBox health_ck;
    private Button health_add, btn_nv1, btn_nv2, btn_nv3;
    private String ck_check;
    private String check_box;
    private String edt_ckeck;
    private String result = "";
    private RequestQueue queue;
    private StringRequest stringRequest;
    private JSONObject date_symptom=new JSONObject();
    private JSONObject date_note=new JSONObject();
    private HashSet<String> symptoms= new HashSet<String>();
    Spinner spinner1;
    Calendar myCalendar = Calendar.getInstance();
    ArrayAdapter<String> adapter;



//    private ArrayList<HealthDTO> list = new ArrayList<HealthDTO>();

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
        health_ck = findViewById(R.id.health_ck);
        shp1=findViewById(R.id.shp1);
        back1=findViewById(R.id.back1);
        btn_nv1 = findViewById(R.id.btn_nv1);
        btn_nv2 = findViewById(R.id.btn_nv2);
        btn_nv3 = findViewById(R.id.btn_nv3);



        //캘린더
        health_cal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                month += 1;
                //health_edt.setText(String.format("%d년 %d월 %d일" ,year,month,dayOfMonth));  //캘린더날짜 출력
                String date = String.format("%04d-%02d-%02d", year,month,dayOfMonth);
                try{
                    String symptom = date_symptom.getString(date);//날짜에 따른 스피너내용
                    String note = date_note.getString(date); //날짜에 따른 건강 내용
                    Log.v("야4",note);
                    Log.v("야1",symptom);
                    String[] tmp = Arrays.copyOf(symptoms.toArray(), symptoms.toArray().length, String[].class);
                    //스피너값
                    adapter =new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, tmp);


                    spinner1.setAdapter(adapter);

                    for(int i=0;i<adapter.getCount();i++){
                        if(adapter.getItem(i).equals(symptom)){// 날짜와 비교해서
                            Log.v("야1",adapter.getItem(i));
                            spinner1.setSelection(i);
                            break;
                        }
                    }
                    health_edt.setText(note);


                    if (check_box.equals("true")) {
                        health_ck.setChecked(true);
                    }else  if (check_box.equals("false")){
                        health_ck.setChecked(false);
                    }



                }catch (JSONException e){
                    spinner1.setSelection(0);
                    health_ck.setChecked(false);
                    health_edt.setText("");

                }


            }
        });



//        HashSet<String> total_data=new HashSet<>();
        //스피너
        final String[] data = getResources().getStringArray(R.array.healtharray);
        Collections.addAll(symptoms, data);


        adapter =new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,data);
        spinner1 = (Spinner) findViewById(R.id.health_sp);
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
                }else{
                    ck_check = "false";
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

                if(response != null){
                    try {
//                        JSONObject jsonObject = new JSONObject(response);
                        JSONArray jsonArray = new JSONArray(response);
                        Log.v("야",jsonArray.toString());
                        for( int i=0; i<jsonArray.length();i++){
                            Log.v("야2","test");
                            JSONObject jo = (JSONObject)jsonArray.get(i);
                            String date =jo.getString("note_date");
                            String health_daily = jo.getString("note_text");
                            String id = jo.getString("mem_id");
                            String health_check = jo.getString("note_workout");
                            String health_spinner = jo.getString("note_health");
                            Log.v("야",date+"/"+health_daily+"/"+id+"/"+health_check+"/"+health_spinner);
                            date_symptom.put(date.substring(0,10),health_spinner);//스피너 내용
                            date_note.put(date.substring(0,10),health_daily);//건강 내용
                            Log.v("야3",date_note.toString());
                            symptoms.add(health_spinner);
                            edt_ckeck=health_daily;
                            check_box = health_check;

                        }
//                        String date = ((JSONObject)jsonObject.get(0)).getString("note_date");
//                        String health_daily = ((JSONObject)jsonObject.get(0)).getString("note_text");
//                        String id = jsonObject.getString("id");
//                        String health_check = jsonObject.getString("note_workout");
//                        String health_spinner = jsonObject.getString("note_health");



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
                        checkHealth();
                    }else {

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
                Log.d("check>>", health_edt.getText().toString()+"/"+ck_check+"/"+result);
                Intent intent = getIntent();
                String id = intent.getStringExtra("id");
                Map<String,String> params = new HashMap<String, String>();
                Log.v("dddd", id);
                params.put("id",id);
                params.put("note_text", health_edt.getText().toString());
                params.put("note_workout",ck_check);
                params.put("note_health",result);
                return params;
            }
        };

        queue.add(stringRequest);
    }


    //뒤로가기
    @Override
    public void onBackPressed() {
        Log.v("그냥 알아들어","확인");
        super.onBackPressed();
    }

}