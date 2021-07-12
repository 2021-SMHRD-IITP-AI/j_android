package com.smhrd.j.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

public class ID_PW_FIND3 extends AppCompatActivity {

    private Button btn_find_id2, btn_find_pw2, btn_check2;
    private EditText edt_find_i, edt_find_e2, edt_find_h2;

    private RequestQueue queue;
    private StringRequest stringRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_id_pw_find3);

        edt_find_i=findViewById(R.id.edt_find_i);
        edt_find_e2=findViewById(R.id.edt_find_e2);
        edt_find_h2=findViewById(R.id.edt_find_h2);

        btn_check2=findViewById(R.id.btn_check);

        btn_find_id2=findViewById(R.id.btn_find_id2);
        btn_find_id2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ID_PW_FIND.class);
                startActivity(intent);
            }
        });

        btn_find_pw2=findViewById(R.id.btn_find_pw2);
        btn_find_pw2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                edt_find_i.setText(" ");
                edt_find_e2.setText(" ");
                edt_find_h2.setText(" ");

            }
        });

        // 입력값 db로 전달 만들기

        btn_check2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendRequest();


            }
        });
    }
    private void sendRequest() {

        queue = Volley.newRequestQueue(this);
        String url = "http://222.102.104.135:3000/FindPW";
        stringRequest = new StringRequest(Request.Method.POST,
                url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.v("resultValue",response);

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String value = jsonObject.getString("check");
                    Log.v("result", value);

                    //★이메일과 휴대폰번호  아이디가 일치하면 비번 찾아주기★

//                    if(value.equals("true")){
//                        Intent intent = new Intent(getApplicationContext(), Login.class);
//                        startActivity(intent);
//                        Log.v("test","찾았다!");
//                    }else{
//                        edt_find_i.setText("");
//                        edt_find_e2.setText("");
//                        edt_find_h2.setText("");
//                        Log.v("test","실패.................");
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
                params.put("id",edt_find_i.getText().toString());
                params.put("email",edt_find_e2.getText().toString());
                params.put("tel",edt_find_h2.getText().toString());

                return params;
            }
        };
        queue.add(stringRequest);
    }

}