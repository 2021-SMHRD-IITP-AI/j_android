package com.smhrd.j.android;

import android.content.Intent;
import android.os.Bundle;
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



import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class Login_contract extends AppCompatActivity {

    private EditText id, pw1, pw2, name, n_name, h_p, email, add, year, month, day;
    private Button btn_overlap1, btn_overlap2, btn_m, btn_w, contract;

    private RequestQueue queue;
    private StringRequest stringRequest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        id=findViewById(R.id.id);
        pw1=findViewById(R.id.pw1);
        pw2=findViewById(R.id.pw2);
        name=findViewById(R.id.name);
        n_name=findViewById(R.id.n_name);
        h_p=findViewById(R.id.h_p);
        email=findViewById(R.id.email);
        add=findViewById(R.id.add);
        year=findViewById(R.id.year);
        month=findViewById(R.id.month);
        day=findViewById(R.id.day);

        contract=findViewById(R.id.contract);

        contract.setOnClickListener(new View.OnClickListener() {
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
                    if(value.equals("true")){
                        Intent intent = new Intent(getApplicationContext(),Login.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(getApplicationContext(),"회원가입에실패했습니다.",Toast.LENGTH_SHORT).show();

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //server 통신시 에러가 발생했을때 감지하는 녀석
                error.printStackTrace();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                //server로 데이터를 보낼때 넣어주는 곳 /네트워트끼리 주고받는거 파라미터방식
                Map<String, String> params = new HashMap<String, String>();
                params.put("id",id.getText().toString());
                params.put("pw",pw1.getText().toString());
                params.put("name",name.getText().toString());
                params.put("tel",n_name.getText().toString());
                params.put("n",h_p.getText().toString());
                params.put("e",email.getText().toString());
                params.put("add",add.getText().toString());
                params.put("year",year.getText().toString());
                params.put("month",month.getText().toString());
                params.put("day",day.getText().toString());

                //년 월 일 통합여부확인해주기
                return params;


            }
        };
        queue.add(stringRequest);
    }
    }



