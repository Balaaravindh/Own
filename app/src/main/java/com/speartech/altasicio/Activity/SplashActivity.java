package com.speartech.altasicio.Activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import com.speartech.altasicio.R;

public class SplashActivity extends AppCompatActivity {

    ActionBar actionBar;
    private static int SPLASH_TIME_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //Hide Status Bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Hide Action Bar
        actionBar = getSupportActionBar();
        actionBar.hide();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                //open activity
                Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(i);

                SplashActivity.this.finish();
            }
        }, SPLASH_TIME_OUT);

    }
}
