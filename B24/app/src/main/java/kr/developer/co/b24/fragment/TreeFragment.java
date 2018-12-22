package kr.developer.co.b24.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.BinderThread;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import kr.developer.co.b24.R;
import kr.developer.co.b24.adapter.QuestionPagerAdapter;
import kr.developer.co.b24.custom.LinedEditText;
import kr.developer.co.b24.database.DatabaseHelper;
import kr.developer.co.b24.model.Advice;
import kr.developer.co.b24.model.Member;

public class TreeFragment extends Fragment {

  @Override
  public View onCreateView(
      @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_tree, container, false);

    final ViewPager questionViewPager = view.findViewById(R.id.question_view_pager_tree);
    final LinedEditText linedEditText = view.findViewById(R.id.linedEditText);
    final Button adviceSubmitButton = view.findViewById(R.id.btn_advice_submit);
    final Spinner ageSpinner = view.findViewById(R.id.age_spinner);

    DatabaseHelper databaseHelper = DatabaseHelper.getDatabaseHelper(this.getContext());
    Member member = databaseHelper.getMemberData();

    List<?> spinnerArray = Arrays.asList(getActivity().getResources().getStringArray(R.array.age));
    List ageList =
        spinnerArray
            .stream()
            .filter(item -> Integer.valueOf((String) item) <= member.getAge())
            .collect(Collectors.toList());

    // (3) create an adapter from the list
    ArrayAdapter<?> adapter =
        new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, ageList);

    ageSpinner.setAdapter(adapter);

    QuestionPagerAdapter questionPagerAdapter =
        new QuestionPagerAdapter(
            getActivity().getSupportFragmentManager(),
            Arrays.asList(getResources().getStringArray(R.array.question_list)));

    questionViewPager.setAdapter(questionPagerAdapter);

    adviceSubmitButton.setOnClickListener(
        (v) -> {
          Advice advice = new Advice();
          advice.setIdx(databaseHelper.getLastAdviceIdx());
          advice.setAge(Integer.parseInt((String) ageSpinner.getSelectedItem()));
          advice.setComment(linedEditText.getText().toString());
          advice.setCategory(questionViewPager.getCurrentItem());
          advice.setMember(databaseHelper.getMemberData());
          advice.setLikeCount(0);

          databaseHelper.insertAdviceData(advice);
          Toast.makeText(getContext(), "새싹들에게 조언을 해주었습니다.", Toast.LENGTH_LONG).show();
          linedEditText.setText(null);
        });

    return view;
  }
}
