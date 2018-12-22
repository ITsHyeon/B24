package kr.developer.co.b24.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;

import kr.developer.co.b24.R;
import kr.developer.co.b24.adapter.TypePagerAdapter;
import kr.developer.co.b24.database.DatabaseHelper;
import kr.developer.co.b24.model.Advice;
import kr.developer.co.b24.network.retrofit.interfaces.GetAdviceByAge;
import kr.developer.co.b24.network.retrofit.response.advice.Response;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AdviceListActivity extends AppCompatActivity {

    List<Advice> adviceList;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_advice_list);

    Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
    setSupportActionBar(myToolbar);

    final TabLayout tabLayout = findViewById(R.id.tab_layout);
    tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.sprout_selected));
    tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.tree));
    tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

//    Retrofit retrofit =
//        new Retrofit.Builder()
//            .baseUrl("127.0.0.1")
//            .addConverterFactory(GsonConverterFactory.create())
//            .callbackExecutor(Executors.newSingleThreadExecutor())
//            .build();
//
//    GetAdviceByAge getAdviceByAge = retrofit.create(GetAdviceByAge.class);
//    getAdviceByAge.GetAdviceByAge(DatabaseHelper.getDatabaseHelper().getMemberData().getAge());
//
//    Call<Response> deleteBoardRequest =
//        getAdviceByAge.GetAdviceByAge(DatabaseHelper.getDatabaseHelper().getMemberData().getAge());
//
//    deleteBoardRequest.enqueue(new Callback<Response>() {
//        @Override
//        public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
//           if (response.errorBody() != null){
//               adviceList = Arrays.asList(response.body().getAdvice());
//           }else{
//               runOnUiThread(()->{
//                   Toast.makeText(AdviceListActivity.this, "오류",Toast.LENGTH_LONG);
//               });
//           }
//        }
//
//        @Override
//        public void onFailure(Call<Response> call, Throwable t) {
//            Toast.makeText(AdviceListActivity.this, "오류",Toast.LENGTH_LONG);
//        }
//    });

    final ViewPager viewPager = findViewById(R.id.pager);
    final TypePagerAdapter adapter =
        new TypePagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
    viewPager.setAdapter(adapter);
    viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    tabLayout.setOnTabSelectedListener(
        new TabLayout.OnTabSelectedListener() {
          @Override
          public void onTabSelected(TabLayout.Tab tab) {
            viewPager.setCurrentItem(tab.getPosition());
            if (tab.getPosition() == 0) {
                tab.setIcon(R.drawable.sprout_selected);
            } else {
                tab.setIcon(R.drawable.tree_selected);
            }
          }

          @Override
          public void onTabUnselected(TabLayout.Tab tab) {
            if (tab.getPosition() == 0) {
                tab.setIcon(R.drawable.sprout);
            } else {
                tab.setIcon(R.drawable.tree);
            }
          }

          @Override
          public void onTabReselected(TabLayout.Tab tab) {}
        });
  }
}
