package com.smhrd.j.android;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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

public class ID_PW_FIND3 extends AppCompatActivity {

    private ImageView back1;
    private Button btn_find_id2, btn_find_pw2, btn_check2;
    private EditText edt_find_i, edt_find_e2, edt_find_h2;

    private RequestQueue queue;
    private StringRequest stringRequest;

    private String mem_pw = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_id_pw_find3);

        back1=findViewById(R.id.back1);

        edt_find_i = findViewById(R.id.edt_find_i);
        edt_find_e2 = findViewById(R.id.edt_find_e2);
        edt_find_h2 = findViewById(R.id.edt_find_h2);

        btn_check2 = findViewById(R.id.btn_check2);

        Intent newIntent = getIntent();
        String id = newIntent.getStringExtra("id");
        String user = newIntent.getStringExtra("name");
        String tel = newIntent.getStringExtra("tel");
        String address = newIntent.getStringExtra("address");
        String email = newIntent.getStringExtra("email");
        String status = newIntent.getStringExtra("status");

        //뒤로가기
        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        btn_find_id2 = findViewById(R.id.btn_find_id2);
        btn_find_id2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ID_PW_FIND.class);
                intent.putExtra("id", id);
                intent.putExtra("name", user);
                intent.putExtra("tel", tel);
                intent.putExtra("address", address);
                intent.putExtra("email", email);
                intent.putExtra("status", status);
                startActivity(intent);
            }
        });

        btn_find_pw2 = findViewById(R.id.btn_find_pw2);
        btn_find_pw2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                edt_find_i.setText(" ");
                edt_find_e2.setText(" ");
                edt_find_h2.setText(" ");

            }
        });

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
                AlertDialog.Builder myAlerBuilder = new AlertDialog.Builder(ID_PW_FIND3.this);
                mem_pw = response;
                myAlerBuilder.setTitle("당신의 PW");
                myAlerBuilder.setMessage(mem_pw);

                myAlerBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getApplicationContext(), Login.class);
                        startActivity(intent);
                    }
                });
                myAlerBuilder.setNegativeButton("cancle", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

                myAlerBuilder.show();
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
                params.put("id", edt_find_i.getText().toString());
                params.put("email",edt_find_e2.getText().toString());
                params.put("tel",edt_find_h2.getText().toString());

                return params;
            }
        };
        queue.add(stringRequest);
    }
    @Override
    public void onBackPressed() {
        Log.v("Back","확인");
        super.onBackPressed();
    }

}