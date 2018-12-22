package kr.developer.co.b24.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

import kr.developer.co.b24.fragment.AdviceFragment;
import kr.developer.co.b24.fragment.QuestionFragment;
import kr.developer.co.b24.model.Advice;

public class QuestionPagerAdapter extends FragmentStatePagerAdapter {

    private List<String> questionList;

    public QuestionPagerAdapter(FragmentManager fm, List<String> questionList) {
        super(fm);
        this.questionList = questionList;
    }

    @Override
    public Fragment getItem(int position) {
        return QuestionFragment.create(questionList.get(position),position,questionList.size());
    }

    @Override
    public int getCount() {
        return questionList.size();
    }

}