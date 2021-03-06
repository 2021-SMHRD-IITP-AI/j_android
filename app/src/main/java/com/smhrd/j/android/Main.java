package com.smhrd.j.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Main extends AppCompatActivity {
    private Button btn_mu1,btn_mu2,btn_mu3,btn_mu4,btn_mu5,btn_mu6,btn_mu7,btn_mu8, btn_more1, btn_j, btn_nv1, btn_nv2,btn_nv3;
    private ImageView ctgr,search1, shp1,img1,img2,img3,cir1,cir2,cir3,cir4,cir5,cir6;
    private TextView menu1,menu2,menu3,menu4,tv_lu_name1,tv_lu_name2,tv_lu_name3,tv_pa1,tv_pa2,tv_pa3,tv_login_s;
    private ImageView imageView;

    String cnt1 = "1";

    private RequestQueue queue;
    private StringRequest stringRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //button
        setContentView(R.layout.activity_main);
        btn_mu1=findViewById(R.id.btn_mu1);
        btn_mu2=findViewById(R.id.btn_mu2);
        btn_mu3=findViewById(R.id.btn_mu3);
        btn_mu4=findViewById(R.id.btn_mu4);
        btn_mu5=findViewById(R.id.btn_mu5);
        btn_mu6=findViewById(R.id.btn_mu6);
        btn_mu7=findViewById(R.id.btn_mu7);
        btn_mu8=findViewById(R.id.btn_mu8);
        btn_more1=findViewById(R.id.btn_more1);
        btn_j=findViewById(R.id.btn_j);
        btn_nv1=findViewById(R.id.btn_nv1);
        btn_nv2=findViewById(R.id.btn_nv2);
        btn_nv3=findViewById(R.id.btn_nv3);

        //img
        ctgr=findViewById(R.id.ctgr);
        search1=findViewById(R.id.search1);
        shp1=findViewById(R.id.shp1);
        img1=findViewById(R.id.img1);
        img2=findViewById(R.id.img2);
        img3=findViewById(R.id.img3);
        cir1=findViewById(R.id.cir1);
        cir2=findViewById(R.id.cir2);
        cir3=findViewById(R.id.cir3);
        cir4=findViewById(R.id.cir4);
        cir5=findViewById(R.id.cir5);
        cir6=findViewById(R.id.cir6);

        //text
        menu1=findViewById(R.id.menu1);
        menu2=findViewById(R.id.menu2);
        menu3=findViewById(R.id.menu3);
        menu4=findViewById(R.id.menu4);
        tv_lu_name1=findViewById(R.id.tv_lu_name1);
        tv_lu_name2=findViewById(R.id.tv_lu_name2);
        tv_lu_name3=findViewById(R.id.tv_lu_name3);
        tv_pa1=findViewById(R.id.tv_pa1);
        tv_pa2=findViewById(R.id.tv_pa2);
        tv_pa3=findViewById(R.id.tv_pa3);
        tv_login_s=findViewById(R.id.tv_login_s);

        Intent newIntent = getIntent();
        String id = newIntent.getStringExtra("id");
        String user = newIntent.getStringExtra("name");
        String tel = newIntent.getStringExtra("tel");
        String address = newIntent.getStringExtra("address");
        String email = newIntent.getStringExtra("email");
        String status = newIntent.getStringExtra("status");


        //????????? ????????? ?????? / ???????????? ?????????????????? ??????
        tv_login_s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String cnt = "1";


                Intent intent = new Intent(getApplicationContext(),Login_contract.class);
                intent.putExtra("logout","????????????");

                intent.putExtra("cnt", cnt);
                startActivity(intent);

            }
        });



        Intent intent = getIntent();
        String logout = intent.getStringExtra("logout");
        String cnt = intent.getStringExtra("cnt");

        if (cnt1.equals(cnt)) {
            tv_login_s.setText(logout);
        }else {
            tv_login_s.setText("?????????");
        }

        //???????????? ????????? ??????
        shp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Cart.class);
                intent.putExtra("id", id);
                intent.putExtra("name", user);
                intent.putExtra("tel", tel);
                intent.putExtra("address", address);
                intent.putExtra("email", email);
                intent.putExtra("status", status);
                startActivity(intent);
            }
        });

        //????????????
        menu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Hot_item.class);
                intent.putExtra("id", id);
                intent.putExtra("name", user);
                intent.putExtra("tel", tel);
                intent.putExtra("address", address);
                intent.putExtra("email", email);
                intent.putExtra("status", status);
                startActivity(intent);
            }
        });

        //????????? ??????
        menu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Sale.class);
                intent.putExtra("id", id);
                intent.putExtra("name", user);
                intent.putExtra("tel", tel);
                intent.putExtra("address", address);
                intent.putExtra("email", email);
                intent.putExtra("status", status);
                startActivity(intent);
            }
        });

        //????????????
        menu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendRequest();
            }
        });

        // ?????????
        btn_mu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://222.102.104.135:3000/imgs/9chan.png";
                String url2 = "http://222.102.104.135:3000/imgs/bibim.png";
                String url3 = "http://222.102.104.135:3000/imgs/bul.png";
                String url4 = "http://222.102.104.135:3000/imgs/galic.png";
                String url5 = "http://222.102.104.135:3000/imgs/kimchi.png";
                String url6 = "http://222.102.104.135:3000/imgs/pork.png";
                String url7 = "http://222.102.104.135:3000/imgs/hotnuddle.png";
                String url8 = "http://222.102.104.135:3000/imgs/nuddle.png";

                String[] value = {url, url2, url3, url4, url5, url6, url7, url8};

                String url_name = "9?????? ?????? ?????????";
                String url2_name = "?????? ?????????";
                String url3_name = "?????? ????????? ?????? ?????????";
                String url4_name = "?????? ????????? ?????????";
                String url5_name = "???????????????";
                String url6_name = "????????? ?????? ?????????";
                String url7_name = "?????? ?????????";
                String url8_name = "?????? ?????????";

                String[] name = {url_name, url2_name, url3_name, url4_name, url5_name, url6_name, url7_name, url8_name};

                String url_price = "6000";
                String url2_price = "4900";
                String url3_price = "5500";
                String url4_price = "5200";
                String url5_price = "5000";
                String url6_price = "5700";
                String url7_price = "4500";
                String url8_price = "4500";

                String[] price = {url_price, url2_price, url3_price, url4_price, url5_price, url6_price, url7_price, url8_price};

                Intent intent = new Intent(getApplicationContext(), Recommend_lunch_box.class);
                intent.putExtra("imageUrl", value);
                intent.putExtra("imgName", name);
                intent.putExtra("imgPrice", price);

                intent.putExtra("id", id);
                intent.putExtra("name", user);
                intent.putExtra("tel", tel);
                intent.putExtra("address", address);
                intent.putExtra("email", email);
                intent.putExtra("status", status);
                startActivity(intent);
            }
        });

        //?????????
        btn_mu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Salad.class);
                intent.putExtra("id", id);
                intent.putExtra("name", user);
                intent.putExtra("tel", tel);
                intent.putExtra("address", address);
                intent.putExtra("email", email);
                intent.putExtra("status", status);
                startActivity(intent);
            }
        });

        //???????????????
        btn_mu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Lunch_box_main.class);
                intent.putExtra("id", id);
                intent.putExtra("name", user);
                intent.putExtra("tel", tel);
                intent.putExtra("address", address);
                intent.putExtra("email", email);
                intent.putExtra("status", status);
                startActivity(intent);
            }
        });

        //?????????
        btn_mu4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Proteen.class);
                intent.putExtra("id", id);
                intent.putExtra("name", user);
                intent.putExtra("tel", tel);
                intent.putExtra("address", address);
                intent.putExtra("email", email);
                intent.putExtra("status", status);
                startActivity(intent);
            }
        });

        //????????????
        btn_mu5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Bar.class);
                intent.putExtra("id", id);
                intent.putExtra("name", user);
                intent.putExtra("tel", tel);
                intent.putExtra("address", address);
                intent.putExtra("email", email);
                intent.putExtra("status", status);
                startActivity(intent);
            }
        });

        //?????????
        btn_mu6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Snack.class);
                intent.putExtra("id", id);
                intent.putExtra("name", user);
                intent.putExtra("tel", tel);
                intent.putExtra("address", address);
                intent.putExtra("email", email);
                intent.putExtra("status", status);
                startActivity(intent);
            }
        });

        //????????????
        btn_mu7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendRequest();
            }
        });

        btn_mu8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(),Today_health.class);
                startActivity(intent1);
            }
        });

        //?????? ?????? ?????????
        btn_more1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Today_lunch_box.class);
                intent.putExtra("id", id);
                intent.putExtra("name", user);
                intent.putExtra("tel", tel);
                intent.putExtra("address", address);
                intent.putExtra("email", email);
                intent.putExtra("status", status);
                startActivity(intent);
            }
        });

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Drawable drawable =getResources().getDrawable(R.drawable.main_img4);
                //Log.v("?????? ????????????",drawable.toString());
                // ?????? ?????????, ?????????, ?????? ?????????
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                Bitmap bitmap = ((BitmapDrawable) img1.getDrawable()).getBitmap();
                float scale = (float) (1024/(float)bitmap.getWidth());
                int image_w = (int) (bitmap.getWidth() * scale);
                int image_h = (int) (bitmap.getHeight() * scale);
                Bitmap resize = Bitmap.createScaledBitmap(bitmap, image_w, image_h, true);
                resize.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] byteArray = stream.toByteArray();


                Intent intent = new Intent(getApplicationContext(),Purchase.class);
                intent.putExtra("main_name1",tv_lu_name1.getText().toString());
                intent.putExtra("main_pr1",tv_pa1.getText().toString());
                intent.putExtra("main_img1", byteArray);

                intent.putExtra("id", id);
                intent.putExtra("name", user);
                intent.putExtra("tel", tel);
                intent.putExtra("address", address);
                intent.putExtra("email", email);
                intent.putExtra("status", status);

                //intent.putExtra("main_img1",R.drawable.main_img4);//?????????

                startActivity(intent);
            }
        });

        // ????????????
        btn_nv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HealthDaily.class);
                intent.putExtra("id",id);
                intent.putExtra("name", user);
                intent.putExtra("tel", tel);
                intent.putExtra("address", address);
                intent.putExtra("email", email);
                intent.putExtra("status", status);
                startActivity(intent);
            }
        });

        // ???????????????
        btn_nv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MyPage_Main.class);
                intent.putExtra("id", id);
                intent.putExtra("name", user);
                intent.putExtra("tel", tel);
                intent.putExtra("address", address);
                intent.putExtra("email", email);
                startActivity(intent);
            }
        });
    }

    private void sendRequest() {
        queue = Volley.newRequestQueue(this);
        String url = "http://222.102.104.135:3000/Dise";
        stringRequest = new StringRequest(Request.Method.POST,
                url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.v("result", response);
                if (response != null) {

                    try {
                        JSONObject jsonObject = new JSONObject(response);
                        Intent newIntent = getIntent();
                        String id = newIntent.getStringExtra("id");
                        String user = newIntent.getStringExtra("name");
                        String tel = newIntent.getStringExtra("tel");
                        String address = newIntent.getStringExtra("address");
                        String email = newIntent.getStringExtra("email");
                        String status = newIntent.getStringExtra("status");

                        Intent intent = new Intent(getApplicationContext(), HealthCare.class);

                        intent.putExtra("diseData", response);
                        intent.putExtra("id", id);
                        intent.putExtra("name", user);
                        intent.putExtra("tel", tel);
                        intent.putExtra("address", address);
                        intent.putExtra("email", email);
                        intent.putExtra("status", status);

                        startActivity(intent);

                        Log.v("test", "??????");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                } else {
                    Log.v("result", "??????");
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
                Intent intent = getIntent();
                String status = intent.getStringExtra("status");
                params.put("status", status);
                return params;
            }
        };
        queue.add(stringRequest);
    }
}