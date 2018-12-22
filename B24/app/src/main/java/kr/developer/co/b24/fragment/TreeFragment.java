package kr.developer.co.b24.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;

import kr.developer.co.b24.R;
import kr.developer.co.b24.adapter.QuestionPagerAdapter;

public class TreeFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_tree, container, false);

        final ViewPager questionViewPager = view.findViewById(R.id.question_view_pager_tree);

        QuestionPagerAdapter questionPagerAdapter =
                new QuestionPagerAdapter(
                        getActivity().getSupportFragmentManager(),
                        Arrays.asList(getResources().getStringArray(R.array.question_list)));

        questionViewPager.setAdapter(questionPagerAdapter);

        return view;
    }

}
