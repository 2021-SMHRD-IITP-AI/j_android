package com.smhrd.j.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

public class Today_health extends AppCompatActivity {

    private ImageView back1, search1, shp1;
    private Button btn_nv1,btn_nv2,btn_nv3;
    private VideoView video_1,video_2,video_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today_health);

        back1=findViewById(R.id.back1);
        search1 =findViewById(R.id.search1);
        shp1 =findViewById(R.id.shp1);

        btn_nv1 =findViewById(R.id.btn_nv1);
        btn_nv2 =findViewById(R.id.btn_nv2);
        btn_nv3 =findViewById(R.id.btn_nv3);

        video_1=findViewById(R.id.video_1);
        video_2=findViewById(R.id.video_2);
        video_3=findViewById(R.id.video_3);

        Uri videourl=Uri.parse("https://www.youtube.com/watch?v=3VouSaW_LPw");


        //비디오뷰 재생,일시정지 등을 할수 있는 컨트롤바
        video_1.setMediaController(new MediaController(this));
        //비디오뷰가 보여줄 동영상으ㅏ 경로 설정
        video_1.setVideoURI(videourl);

        video_1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                video_1.start();
            Log.v("야","나와라 얍");
            }
        });



        //뒤로가기
        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        //장바구니
        shp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Cart.class);
                startActivity(intent);
            }
        });


        //헬스케어
        btn_nv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HealthCare.class);
                startActivity(intent);
            }
        });

        //메인
        btn_nv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Main.class);
                startActivity(intent);
            }
        });

        //마이페이지
        btn_nv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MyPage.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onPause(){
        super.onPause();

        //비디오 일시정지
        if (video_1!=null && video_1.isPlaying())video_1.pause();

    }
    @Override
    protected void onDestroy(){
        super.onDestroy();

        //액티비티가 메모리에서 사라질때..?
        if (video_1!=null)video_1.stopPlayback();
    }

    //뒤로가기
    @Override
    public void onBackPressed() {
        Log.v("Back","확인");
        super.onBackPressed();
    }

}