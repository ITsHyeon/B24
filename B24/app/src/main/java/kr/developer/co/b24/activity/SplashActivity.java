package kr.developer.co.b24.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;

import kr.developer.co.b24.R;

public class SplashActivity extends AppCompatActivity {

    ImageView mImageWave;
    Drawable mWaveDrawble;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        mImageWave = findViewById(R.id.splashWave);

//        mWaveDrawble = new WaveDrawable();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, SignUpActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }
}