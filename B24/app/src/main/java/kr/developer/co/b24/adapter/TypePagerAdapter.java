package kr.developer.co.b24.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import kr.developer.co.b24.fragment.SproutFragment;
import kr.developer.co.b24.fragment.TreeFragment;

public class TypePagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public TypePagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                SproutFragment tab1 = new SproutFragment();
                return tab1;

            case 1:
                TreeFragment tab2 = new TreeFragment();
                return tab2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}