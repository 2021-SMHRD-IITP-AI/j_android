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

    private EditText id, pw1,  name,  h_p;
//            add, birth;
    private Button  contract;

    private RequestQueue queue;
    private StringRequest stringRequest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_contract);

        id=findViewById(R.id.id);
        pw1=findViewById(R.id.pw1);
        name=findViewById(R.id.name);
        h_p=findViewById(R.id.h_p);

//        add=findViewById(R.id.add);
//        birth=findViewById(R.id.birth);



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
                        Toast.makeText(getApplicationContext(),"회원가입성공",Toast.LENGTH_SHORT).show();
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

                error.printStackTrace();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<String, String>();
                params.put("id",id.getText().toString());
                params.put("pw",pw1.getText().toString());
                params.put("name",name.getText().toString());
                params.put("n",h_p.getText().toString());

//                params.put("add",add.getText().toString());
//                params.put("birth",birth.getText().toString());


                return params;


            }
        };
        queue.add(stringRequest);
    }
    }



