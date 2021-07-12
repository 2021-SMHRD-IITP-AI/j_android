package com.smhrd.j.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.style.BackgroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

import java.util.HashMap;
import java.util.Map;

public class ID_PW_FIND extends AppCompatActivity {

    private Button btn_find_id, btn_find_pw, btn_check;
    private EditText edt_find_e, edt_find_h;


    private RequestQueue queue;
    private StringRequest stringRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_id_pw_find);

        edt_find_e=findViewById(R.id.edt_find_e);
        edt_find_h=findViewById(R.id.edt_find_h);

        btn_find_id=findViewById(R.id.btn_find_id);
        btn_find_pw=findViewById(R.id.btn_find_pw);
        btn_check=findViewById(R.id.btn_check);


        btn_find_pw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Color.rgb(103,4,1);

                Intent intent = new Intent(getApplicationContext(),ID_PW_FIND3.class);
                startActivity(intent);

                // 입력값 db로 전달 만들기

            }
        });

        //아이디 찾기 버튼 클릭시 입력값 초기화

        btn_find_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                edt_find_e.setText(" ");
                edt_find_h.setText(" ");


            }
        });

        btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sendRequest();
            }
        });
    }

    private void sendRequest() {
        queue = Volley.newRequestQueue(this);
        String url = "http://222.102.104.135:3000/FindID";
        stringRequest = new StringRequest(Request.Method.POST,
                url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.v("resultValue",response);

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String value = jsonObject.getString("check");
                    Log.v("result", value);

                    //★이메일과 휴대폰번호가 일치하면  아이디 찾아주기★

//                    if(value.equals("true")){
//                        Intent intent = new Intent(getApplicationContext(), Login.class);
//                        startActivity(intent);
//                        Log.v("test","찾았다!");
//                    }else{
//                        edt_find_e.setText("");
//                        edt_find_h.setText("");
//                        Log.v("test","실패...................");
//                    }

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
                params.put("email",edt_find_e.getText().toString());
                params.put("tel",edt_find_h.getText().toString());

                return params;
            }
        };
        queue.add(stringRequest);
    }

    }
