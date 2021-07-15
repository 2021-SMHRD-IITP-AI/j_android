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
import android.widget.TextView;
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
//import com.google.gson.Gson;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {

    private EditText id_login, pw_login;
    private Button btn_contract, btn_login;
    private CheckBox cb_login;
    private TextView tv_find;


    private RequestQueue queue;
    private StringRequest stringRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        id_login = findViewById(R.id.id_login);
        pw_login = findViewById(R.id.pw_login);
        btn_login = findViewById(R.id.btn_login);
        btn_contract = findViewById(R.id.btn_contract1);
        cb_login = findViewById(R.id.cb_login);

        tv_find=findViewById(R.id.tv__find_id_pw);

        String login = PreferenceManager.getString(getApplicationContext(),"login");
        if(!cb_login.equals("")){
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

        //아이디비번찾기
        tv_find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ID_PW_FIND.class);
                startActivity(intent);
            }
        });

        //회원가입 버튼
        btn_contract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Login_contract.class);
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
    public void sendRequest() {
        queue = Volley.newRequestQueue(this);
        String url = "http://222.102.104.135:3000/Login";
        stringRequest = new StringRequest(Request.Method.POST,
                url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.v("test",response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String id = jsonObject.getString("id");
                    String pw = jsonObject.getString("pw");
                    String name = jsonObject.getString("name");
                    if(id_login.getText().toString().equals(id) && pw_login.getText().toString().equals(pw)){
                        Intent intent = new Intent(getApplicationContext(), Main.class);
                        intent.putExtra("id", id);
                        intent.putExtra("pw", pw);
                        intent.putExtra("name", name);
                        startActivity(intent);
                        Log.v("Login", "성공");
                    } else{
                        Log.v("Login", "실패");
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
            protected Response<String> parseNetworkResponse(NetworkResponse response) {

                try {
                    String utf8String = new String(response.data, "UTF-8");
                    return Response.success(utf8String, HttpHeaderParser.parseCacheHeaders(response));
                } catch (UnsupportedEncodingException e) {

                    e.printStackTrace();

                }
                return super.parseNetworkResponse(response);
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<String, String>();
                params.put("id", id_login.getText().toString());
                params.put("pw", pw_login.getText().toString());

                return params;

            }
        };
        queue.add(stringRequest);


    }
}