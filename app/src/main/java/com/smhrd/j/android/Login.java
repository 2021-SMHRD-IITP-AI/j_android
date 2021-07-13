package com.smhrd.j.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;


import org.json.JSONException;
import org.json.JSONObject;

public class Login extends AppCompatActivity {

    private EditText id_login, pw_login;
    private Button btn_contract1, btn_login;
    private CheckBox cb_login;
    private TextView tv_find_id_pw;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        id_login=findViewById(R.id.id_login);
        pw_login=findViewById(R.id.pw_login);
        btn_login=findViewById(R.id.btn_login);
        btn_contract1=findViewById(R.id.btn_contract1);
        cb_login=findViewById(R.id.cb_login);
        tv_find_id_pw=findViewById(R.id.tv_find_id_pw);

//        String login = PreferenceManager.getString(getApplicationContext(),"login");
//        if(!login.equals("")){
//            try {
//                JSONObject jsonObject = new JSONObject(login);
//                String id = jsonObject.getString("id");
//                String pw = jsonObject.getString("pw");
//
//                id_login.setText(id);
//                pw_login.setText(pw);
//                cb_login.setChecked(true);
//
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//        }

        tv_find_id_pw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ID_PW_FIND.class);
                startActivity(intent);

            }
        });


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

                String userId = id_login.getText().toString();
                String userPw = pw_login.getText().toString();

                Response.Listener<String>listener=new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if (success) {

                                String userID = jsonObject.getString("id");
                                String userPW = jsonObject.getString("pw");


                                Toast.makeText(getApplicationContext(), "로그인성공", Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(Login.this, Login_contract.class);
                                intent.putExtra("userId", (Parcelable) id_login);
                                intent.putExtra("userPw", (Parcelable) pw_login);
                                startActivity(intent);
                            } else {
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };


            }
        });

    }
}