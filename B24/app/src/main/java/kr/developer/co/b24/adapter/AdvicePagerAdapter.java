package kr.developer.co.b24.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

import kr.developer.co.b24.fragment.AdviceFragment;
import kr.developer.co.b24.model.Advice;

public class AdvicePagerAdapter extends FragmentStatePagerAdapter {

    private List<Advice> adviceList;

    public AdvicePagerAdapter(FragmentManager fm, List<Advice> adviceList) {
        super(fm);
        this.adviceList = adviceList;
    }

    @Override
    public Fragment getItem(int position) {
        return AdviceFragment.create(adviceList.get(position));
    }

    @Override
    public int getCount() {
        return adviceList.size();
    }



}