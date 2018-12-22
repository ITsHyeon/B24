package kr.developer.co.b24.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import kr.developer.co.b24.R;
import kr.developer.co.b24.database.DatabaseHelper;
import kr.developer.co.b24.model.Member;

public class SignUpActivity extends AppCompatActivity {
  Spinner mSpinnerAge;
  Button mBtnWoman, mBtnMan, mBtnStart;
  Boolean gender = null;

  DatabaseHelper databaseHelper;

  int age;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_sign_up);

    databaseHelper = DatabaseHelper.getDatabaseHelper(this);

    mSpinnerAge = findViewById(R.id.spinnerAge);
    mBtnMan = findViewById(R.id.buttonMan);
    mBtnWoman = findViewById(R.id.buttonWoman);
    mBtnStart = findViewById(R.id.buttonStart);

    mSpinnerAge.setOnItemSelectedListener(spinnerHandler);
    mBtnMan.setOnClickListener(btnHandler);
    mBtnWoman.setOnClickListener(btnHandler);
    mBtnStart.setOnClickListener(
        view -> {
          Intent intent = new Intent(SignUpActivity.this, AdviceListActivity.class);

          Member member = new Member();

          member.setAge(Integer.parseInt((String) mSpinnerAge.getSelectedItem()));
          if (gender != null) {
            member.setGender(gender);
            databaseHelper.insertMemberData(member);
            startActivity(intent);
            finish();
          } else {
            Toast.makeText(SignUpActivity.this, "성별을 선택해주세요", Toast.LENGTH_LONG).show();
          }
        });
  }

  AdapterView.OnItemSelectedListener spinnerHandler =
      new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
          age = Integer.parseInt((String) adapterView.getItemAtPosition(i));
          Log.e("나이", String.valueOf(age));
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {}
      };
  View.OnClickListener btnHandler =
      new View.OnClickListener() {
        @Override
        public void onClick(View view) {
          if (view.getId() == R.id.buttonMan) {
            mBtnMan.setBackgroundResource(R.drawable.button_click_gender_man);
            mBtnWoman.setBackgroundResource(R.drawable.button_gender_woman);
            gender = true;
          } else if (view.getId() == R.id.buttonWoman) {
            mBtnMan.setBackgroundResource(R.drawable.button_gender_man);
            mBtnWoman.setBackgroundResource(R.drawable.button_click_gender_woman);
            gender = false;
          }
        }
      };
}
