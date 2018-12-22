package kr.developer.co.b24.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.race604.drawable.wave.WaveDrawable;

import kr.developer.co.b24.R;
import me.itangqi.waveloadingview.WaveLoadingView;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        WaveLoadingView waveLoadingView = findViewById(R.id.waveLoadingView);

        waveLoadingView.setProgressValue(50);


        Handler handler = new Handler();
        handler.postDelayed(() -> {
            Intent intent = new Intent(SplashActivity.this, SignUpActivity.class);
            startActivity(intent);
            finish();
        },2000);


    }
}
