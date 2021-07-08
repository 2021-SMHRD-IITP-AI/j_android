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

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;


import org.json.JSONException;
import org.json.JSONObject;

public class Login extends AppCompatActivity {

    private EditText id_login, pw_login;
    private Button btn_contract, btn_login;
    private CheckBox cb_login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        id_login=findViewById(R.id.id_login);
        pw_login=findViewById(R.id.pw_login);
        btn_login=findViewById(R.id.btn_login);
        btn_contract=findViewById(R.id.btn_contract);
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


        btn_contract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Login_contract.class);
                startActivity(intent);
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),Main.class);
                startActivity(intent);

                String userId = id_login.getText().toString();
                String userPw = pw_login.getText().toString();

                String info = PreferenceManager.getString(getApplicationContext(),"info");
                try {
                    JSONObject jsonObject = new JSONObject(info);
                    String id1 = jsonObject.getString("id1");
                    String pw1 = jsonObject.getString("pw1");

                    if(userId.equals(id1)&&userPw.equals(pw1)){
                        if(cb_login.isChecked()){
                            LoginDTO dto = new LoginDTO(id1,pw1);
                            Gson gson = new Gson();
                            String value = gson.toJson(dto);
                            PreferenceManager.setString(getApplicationContext(),"login",value);

                            Intent intent2 = new Intent(Login.this, Login_contract.class);
                            intent.putExtra("userId", (Parcelable) id_login);
                            intent.putExtra("userPw", (Parcelable) pw_login);
                            startActivity(intent2);

                        }else {
                            PreferenceManager.removeKey(getApplicationContext(),"login");
                        }

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        });

    }
}