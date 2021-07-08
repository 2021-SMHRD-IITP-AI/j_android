package com.smhrd.j.android;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
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



import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.HashMap;
import java.util.Map;


public class Login_contract extends AppCompatActivity {


    private EditText id, pw1,  name,  h_p, email, address, birth;
    private Button  btn_contract;

    private RequestQueue queue;
    private StringRequest stringRequest;

//    private  HashMap<String, Integer> map = new HashMap<>();

    Spinner spinner;

    Calendar myCalendar = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener myDatePicker = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, month);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_contract);

        id=findViewById(R.id.id);
        pw1=findViewById(R.id.pw);
        name=findViewById(R.id.name);
        h_p=findViewById(R.id.h_p);

        email=findViewById(R.id.email);
        address=findViewById(R.id.address);
        birth=findViewById(R.id.birth);



        //생년월일 달력구성
        birth.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                new DatePickerDialog(Login_contract.this,myDatePicker,myCalendar.get(Calendar.YEAR),
                        myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        //스피너 작동
        final String[] data = getResources().getStringArray(R.array.array);
        ArrayAdapter<String> adapter =new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,data);
        Spinner spinner1 = (Spinner) findViewById(R.id.spinner);
        spinner1.setAdapter(adapter);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),""+spinner1.getItemAtPosition(position),Toast.LENGTH_SHORT).show();
                ((TextView)parent.getChildAt(0)).setTextColor(Color.BLACK);



            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        btn_contract=findViewById(R.id.btn_contract);

        btn_contract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sendRequest();
            }
        });
    }
    private void sendRequest() {

        queue = Volley.newRequestQueue(this);
        String url = "http://222.102.104.135:3000/Join";

        stringRequest = new StringRequest(Request.Method.POST,
                url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.v("resultValue",response);

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String value = jsonObject.getString("check");
                    Log.v("resultValue", value);
//                    String resultId=jsonObject.getString("approve_id");
//                    String resultPassword = jsonObject.getString("approve_pw");
                    if(value.equals("true")){
                        Intent intent = new Intent(getApplicationContext(),Login.class);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(),"회원가입성공",Toast.LENGTH_SHORT).show();
                        Log.v("123","회원가입 성공");
                    }else{
                        Toast.makeText(getApplicationContext(),"회원가입에실패했습니다.",Toast.LENGTH_SHORT).show();
                            id.setText("");
                            pw1.setText("");
                            name.setText("");
                            h_p.setText("");
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                error.printStackTrace();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<String, String>();
                params.put("id",id.getText().toString());
                params.put("pw",pw1.getText().toString());
                params.put("name",name.getText().toString());
                params.put("tel",h_p.getText().toString());
                params.put("email",email.getText().toString());
                params.put("address",address.getText().toString());
                params.put("birth",birth.getText().toString());

                return params;

            }
        };
        queue.add(stringRequest);
    }

    private void updateLabel() {
        String myDate = "yyy/MM/dd";
        SimpleDateFormat dateFormat = new SimpleDateFormat(myDate, Locale.KOREA);
        birth.setText(dateFormat.format(myCalendar.getTime()));
    }
    }



