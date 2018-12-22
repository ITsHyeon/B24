package kr.developer.co.b24;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;

import com.race604.drawable.wave.WaveDrawable;

import static kr.developer.co.b24.R.drawable.splash_wave;

public class SplashActivity extends AppCompatActivity {

    ImageView mImageWave;
    Drawable mWaveDrawble;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 액션바 없애기
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_splash);

        mImageWave = findViewById(R.id.splashWave);

//        mWaveDrawble = new WaveDrawable();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        },2000);
    }
}
