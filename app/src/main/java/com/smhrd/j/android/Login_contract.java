package com.smhrd.j.android;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
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

    private EditText id, pw1,  name,  h_p, email, address, birth;
    private Button  btn_contract;

    private RequestQueue queue;
    private StringRequest stringRequest;

    Spinner spinner;


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

        final String[] data = getResources().getStringArray(R.array.array);
        ArrayAdapter<String> adapter =new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,data);
        Spinner spinner1 = (Spinner) findViewById(R.id.spinner);
        spinner1.setAdapter(adapter);



        btn_contract=findViewById(R.id.btn_contract1);

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
                    Log.v("result", value);
                    if(value != null){
                        Intent intent = new Intent(getApplicationContext(), Login.class);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(),"회원가입성공",Toast.LENGTH_SHORT).show();
                        Log.v("test","가입성공");
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
    }



