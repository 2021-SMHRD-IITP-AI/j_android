package com.smhrd.j.android;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.style.BackgroundColorSpan;
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

public class ID_PW_FIND extends AppCompatActivity {

    private ImageView back1;

    private Button btn_find_id, btn_find_pw, btn_check;
    private EditText edt_find_e, edt_find_h;


    private RequestQueue queue;
    private StringRequest stringRequest;

    private String mem_id = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_id_pw_find);

        back1=findViewById(R.id.back1);

        edt_find_e=findViewById(R.id.edt_find_e);
        edt_find_h=findViewById(R.id.edt_find_h);

        btn_find_id=findViewById(R.id.btn_find_id);
        btn_find_pw=findViewById(R.id.btn_find_pw);
        btn_check=findViewById(R.id.btn_check);

        btn_find_pw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),ID_PW_FIND3.class);
                startActivity(intent);


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
                AlertDialog.Builder myAlerBuilder = new AlertDialog.Builder(ID_PW_FIND.this);
                mem_id = response;
                myAlerBuilder.setTitle("당신의 ID");
                myAlerBuilder.setMessage(mem_id);

                myAlerBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Pressed OK", Toast.LENGTH_SHORT).show();
                    }
                });
                myAlerBuilder.setPositiveButton("cancle", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "pressed cancle", Toast.LENGTH_SHORT).show();
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
                params.put("email",edt_find_e.getText().toString());
                params.put("tel",edt_find_h.getText().toString());

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