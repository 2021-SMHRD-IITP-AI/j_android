package com.smhrd.j.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;


import org.json.JSONException;
import org.json.JSONObject;


import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {

    private EditText id_login, pw_login;
    private Button btn_contract1, btn_login;
    private CheckBox cb_login;

    private RequestQueue queue;
    private StringRequest stringRequest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        id_login=findViewById(R.id.id_login);
        pw_login=findViewById(R.id.pw_login);
        btn_login=findViewById(R.id.btn_login);
        btn_contract1=findViewById(R.id.btn_contract1);
        cb_login=findViewById(R.id.cb_login);

        String login = PreferenceManager.getString(getApplicationContext(),"login");
        if(!login.equals("")){
            try {
                JSONObject jsonObject = new JSONObject(login);
                String id = jsonObject.getString("id");
                String pw = jsonObject.getString("pw");

                id_login.setText(id);
                pw_login.setText(pw);
                cb_login.setChecked(true);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }


        btn_contract1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Login_contract.class);
                startActivity(intent);
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sendRequest();

            }
        });

    }

    private void sendRequest() {
        queue= Volley.newRequestQueue(this);
        String url = "http://222.102.104.135:3000/FindID";
        stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.v("test", response);

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String value = jsonObject.getString("check");

                    Log.v("test", value);
                    if (value.equals("true")) {
                        String id = jsonObject.getString("login_id");
                        String pw = jsonObject.getString("login_pw");

                        LoginDTO dto = new LoginDTO(id, pw);

                        Gson gson = new Gson();
                        String login = gson.toJson(dto);

                        PreferenceManager.setString(getApplicationContext(), "login", value);
                        Toast.makeText(getApplicationContext(), "로그인 성공", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(getApplicationContext(), Main.class);
                        startActivity(intent);

                    } else {
                        Toast.makeText(getApplicationContext(), "로그인에 실패", Toast.LENGTH_SHORT).show();

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Server 통신시 Error 발생하면 오는 곳
                error.printStackTrace();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                //Server로 데이터 보낼 시 넣어주는 곳
                Map<String, String> parmas = new HashMap<String, String>();
                parmas.put("member_id", id_login.getText().toString());
                parmas.put("member_pw", pw_login.getText().toString());

                return parmas;

            }
        };

        queue.add(stringRequest);


    }
    }
