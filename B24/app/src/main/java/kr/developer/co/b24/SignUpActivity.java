package kr.developer.co.b24;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

import kr.developer.co.b24.activity.AdviceListActivity;
import kr.developer.co.b24.activity.MainActivity;

public class SignUpActivity extends AppCompatActivity {
    Spinner mSpinnerAge;
    Button mBtnWoman, mBtnMan, mBtnStart;
    String gender;
    int age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 액션바 없애기
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);

        setContentView(R.layout.activity_sign_up);

        mSpinnerAge = findViewById(R.id.spinnerAge);
        mBtnMan = findViewById(R.id.buttonMan);
        mBtnWoman = findViewById(R.id.buttonWoman);
        mBtnStart = findViewById(R.id.buttonStart);

        mSpinnerAge.setOnItemSelectedListener(spinnerHandler);
        mBtnMan.setOnClickListener(btnHandler);
        mBtnWoman.setOnClickListener(btnHandler);
        mBtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this,AdviceListActivity.class);
                startActivity(intent);
            }
        });
    }
    AdapterView.OnItemSelectedListener spinnerHandler = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            age =  Integer.parseInt((String) adapterView.getItemAtPosition(i));
            Log.e("나이",String.valueOf(age));
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };
    View.OnClickListener btnHandler = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.buttonMan){
               mBtnMan.setBackgroundResource(R.drawable.button_click_gender_man);
               mBtnWoman.setBackgroundResource(R.drawable.button_gender_woman);
               gender = "남자";
               Log.e("성별",gender);
            }
            else if (view.getId()==R.id.buttonWoman){
                mBtnMan.setBackgroundResource(R.drawable.button_gender_man);
                mBtnWoman.setBackgroundResource(R.drawable.button_click_gender_woman);
                gender = "여자";
                Log.e("성별",gender);
            }
        }
    };
}
