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



        //?????? ??? ???????????? ?????????
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

        Intent newIntent = getIntent();
        String id = newIntent.getStringExtra("id");
        String user = newIntent.getStringExtra("name");
        String tel = newIntent.getStringExtra("tel");
        String address = newIntent.getStringExtra("address");
        String email = newIntent.getStringExtra("email");
        String status = newIntent.getStringExtra("status");



        //?????????
        health_cal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                month += 1;
                //health_edt.setText(String.format("%d??? %d??? %d???" ,year,month,dayOfMonth));  //??????????????? ??????
                String date = String.format("%04d-%02d-%02d", year,month,dayOfMonth);
                try{
                    String symptom = date_symptom.getString(date);//????????? ?????? ???????????????
                    String note = date_note.getString(date); //????????? ?????? ?????? ??????
                    Log.v("???4",note);
                    Log.v("???1",symptom);
                    String[] tmp = Arrays.copyOf(symptoms.toArray(), symptoms.toArray().length, String[].class);
                    //????????????
                    adapter =new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, tmp);


                    spinner1.setAdapter(adapter);

                    for(int i=0;i<adapter.getCount();i++){
                        if(adapter.getItem(i).equals(symptom)){// ????????? ????????????
                            Log.v("???1",adapter.getItem(i));
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
        //?????????
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
                //????????????
                result = (String)spinner1.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        //???????????? ???????????? ??? ????????? ??? ??????
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

        //????????????
        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        //????????????
        shp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Cart.class);
                intent.putExtra("id", id);
                intent.putExtra("name", user);
                intent.putExtra("tel", tel);
                intent.putExtra("address", address);
                intent.putExtra("email", email);
                intent.putExtra("status", status);
                startActivity(intent);
            }
        });


        // ????????????
        btn_nv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HealthDaily.class);
                intent.putExtra("id", id);
                intent.putExtra("name", user);
                intent.putExtra("tel", tel);
                intent.putExtra("address", address);
                intent.putExtra("email", email);
                intent.putExtra("status", status);
                startActivity(intent);
            }
        });

        //??????
        btn_nv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Main.class);
                intent.putExtra("id", id);
                intent.putExtra("name", user);
                intent.putExtra("tel", tel);
                intent.putExtra("address", address);
                intent.putExtra("email", email);
                intent.putExtra("status", status);
                startActivity(intent);
            }
        });

        //???????????????
        btn_nv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MyPage_Main.class);
                intent.putExtra("id", id);
                intent.putExtra("name", user);
                intent.putExtra("tel", tel);
                intent.putExtra("address", address);
                intent.putExtra("email", email);
                intent.putExtra("status", status);
                startActivity(intent);
            }
        });




    }


    //???????????? ????????? ????????????
    public void checkHealth() {
        queue = Volley.newRequestQueue(this);
        String url = "http://222.102.104.135:3000/NoteOut";
        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override//????????? ???????????? ???
            public void onResponse(String response) { //server??? ?????? ???????????? ???????????? ???
                Log.v("resultValue", response);

                if(response != null){
                    try {
//                        JSONObject jsonObject = new JSONObject(response);
                        JSONArray jsonArray = new JSONArray(response);
                        Log.v("???",jsonArray.toString());
                        for( int i=0; i<jsonArray.length();i++){
                            Log.v("???2","test");
                            JSONObject jo = (JSONObject)jsonArray.get(i);
                            String date =jo.getString("note_date");
                            String health_daily = jo.getString("note_text");
                            String id = jo.getString("mem_id");
                            String health_check = jo.getString("note_workout");
                            String health_spinner = jo.getString("note_health");
                            Log.v("???",date+"/"+health_daily+"/"+id+"/"+health_check+"/"+health_spinner);
                            date_symptom.put(date.substring(0,10),health_spinner);//????????? ??????
                            date_note.put(date.substring(0,10),health_daily);//?????? ??????
                            Log.v("???3",date_note.toString());
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
            public void onErrorResponse(VolleyError error) {//server ?????? ??? Error???????????? ?????? ???
                error.printStackTrace();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError { //server??? ???????????? ?????? ??? ???????????? ???
                Map<String,String> params = new HashMap<String, String>();
                return params;
            }
        };

        queue.add(stringRequest);
    }



    //????????? ????????? ?????????
    public void sendRequest() {
        queue = Volley.newRequestQueue(this);
        String url = "http://222.102.104.135:3000/NoteIn";
        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override//????????? ???????????? ???
            public void onResponse(String response) { //server??? ?????? ???????????? ???????????? ???
                Log.v("resultValue", response);

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String value = jsonObject.getString("check");
                    Log.v("resultValue", value);
                    if (value.equals("true")){
                        health_edt.setText("");
                        checkHealth();
                    }else {

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {//server ?????? ??? Error???????????? ?????? ???
                error.printStackTrace();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError { //server??? ???????????? ?????? ??? ???????????? ???
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


    //????????????
    @Override
    public void onBackPressed() {
        Log.v("?????? ????????????","??????");
        super.onBackPressed();
    }

}