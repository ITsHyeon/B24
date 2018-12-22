package kr.developer.co.b24.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import kr.developer.co.b24.R;
import okhttp3.internal.http.RetryAndFollowUpInterceptor;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("60.0.12.226")
                .build();


    }
}
