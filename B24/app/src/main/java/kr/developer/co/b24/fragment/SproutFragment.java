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
import kr.developer.co.b24.adapter.QuestionPagerAdpater;
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

    final ArrayList<Advice> adviceList = new ArrayList<>();

    adviceList.add(new Advice(new Member(17, true), "공부 열심히 하기", 100, 16, 0));
    adviceList.add(new Advice(new Member(16, false), "잠을 충분히 자라", 99, 17, 0));
    adviceList.add(new Advice(new Member(18, true), "신나게 놀기", 102, 16, 1));
    adviceList.add(new Advice(new Member(24, false), "공부하는 척 하지 않기", 103, 19, 2));
    adviceList.add(new Advice(new Member(24, false), "게임을 하지 말자", 70, 19, 2));
    adviceList.add(new Advice(new Member(24, false), "술을 먹지마라", 198, 20, 2));

    final ViewPager questionViewPager = view.findViewById(R.id.question_view_pager);
    final ViewPager adviceViewPager = view.findViewById(R.id.advice_view_pager);

    QuestionPagerAdpater questionPagerAdpater =
        new QuestionPagerAdpater(
            getActivity().getSupportFragmentManager(),
            Arrays.asList(getResources().getStringArray(R.array.question_list)));

    questionViewPager.setAdapter(questionPagerAdpater);

    questionViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
      public void onPageScrollStateChanged(int state) {}
      public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

      public void onPageSelected(int position) {
        AdvicePagerAdapter advicePagerAdapter =
                new AdvicePagerAdapter(getActivity().getSupportFragmentManager(), filterAdviceList(adviceList, position));

        adviceViewPager.setAdapter(advicePagerAdapter);
      }
    });

    AdvicePagerAdapter advicePagerAdapter =
            new AdvicePagerAdapter(getActivity().getSupportFragmentManager(), filterAdviceList(adviceList, 0));

    adviceViewPager.setAdapter(advicePagerAdapter);

    return view;
  }

  private List<Advice> filterAdviceList(ArrayList<Advice> adviceList, int category){
    return adviceList.stream().filter(advice -> advice.getCategory() == category).collect(Collectors.toList());
  }
}
