package kr.developer.co.b24.fragment;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import kr.developer.co.b24.R;
import kr.developer.co.b24.adapter.AdvicePagerAdapter;
import kr.developer.co.b24.adapter.QuestionPagerAdapter;
import kr.developer.co.b24.database.DatabaseHelper;
import kr.developer.co.b24.model.Advice;
import kr.developer.co.b24.model.Member;

public class SproutFragment extends Fragment {
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(
      LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_sprout, container, false);

    DatabaseHelper databaseHelper = DatabaseHelper.getDatabaseHelper(getContext());

    List<Advice> adviceList1 = databaseHelper.getAdviceList(databaseHelper.getMemberData().getAge());


    final ViewPager questionViewPager = view.findViewById(R.id.question_view_pager);
    final ViewPager adviceViewPager = view.findViewById(R.id.advice_view_pager);

    QuestionPagerAdapter questionPagerAdpater =
        new QuestionPagerAdapter(
            getActivity().getSupportFragmentManager(),
            Arrays.asList(getResources().getStringArray(R.array.question_list)));

    questionViewPager.setAdapter(questionPagerAdpater);

    questionViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
      public void onPageScrollStateChanged(int state) {}
      public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

      public void onPageSelected(int position) {
        AdvicePagerAdapter advicePagerAdapter =
                new AdvicePagerAdapter(getActivity().getSupportFragmentManager(), filterAdviceList(adviceList1, position));

        adviceViewPager.setAdapter(advicePagerAdapter);
      }
    });

    AdvicePagerAdapter advicePagerAdapter =
            new AdvicePagerAdapter(getActivity().getSupportFragmentManager(), filterAdviceList(adviceList1, 0));

    adviceViewPager.setAdapter(advicePagerAdapter);

    return view;
  }

  private List<Advice> filterAdviceList(List<Advice> adviceList, int category){
    return adviceList.stream().filter(advice -> advice.getCategory() == category).collect(Collectors.toList());
  }
}
