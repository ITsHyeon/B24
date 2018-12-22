package kr.developer.co.b24.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import kr.developer.co.b24.R;
import kr.developer.co.b24.adapter.TypePagerAdapter;

public class AdviceListActivity extends AppCompatActivity {

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
            if (tab.getPosition() == 0){
                tab.setIcon(R.drawable.tree_selected);
            }else {
                tab.setIcon(R.drawable.sprout_selected);
            }

          }

          @Override
          public void onTabUnselected(TabLayout.Tab tab) {
              if (tab.getPosition() == 0){
                  tab.setIcon(R.drawable.tree);
              }else{
                  tab.setIcon(R.drawable.sprout);
              }
          }

          @Override
          public void onTabReselected(TabLayout.Tab tab) {}
        });
  }
}
