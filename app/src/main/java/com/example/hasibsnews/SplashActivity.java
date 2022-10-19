package com.example.hasibsnews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {
Animation topanimation,bottomanimation;
ImageView iconimage;
TextView appname,developername;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();

        iconimage = findViewById(R.id.newsicon);
        appname = findViewById(R.id.newsname);
        developername = findViewById(R.id.developer);

        topanimation = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomanimation =AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        iconimage.setAnimation(topanimation);
        appname.setAnimation(bottomanimation);
        developername.setAnimation(bottomanimation);

       Thread thread =  new Thread(){
            public void run(){
                try {
                    sleep(3000);
                    startActivity(new Intent(SplashActivity.this,MainActivity.class));
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();

    }
}