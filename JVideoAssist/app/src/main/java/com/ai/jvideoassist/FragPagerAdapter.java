package com.ai.jvideoassist;

import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


public class FragPagerAdapter extends FragmentPagerAdapter {

    private static final String TAG = "FragPagerAdapter";

    public final int PAGER_COUNT = 4;

    private FragFirst mVideoDisplayFrag = null;
    private FragSecond myFragment2 = null;
    private FragThird myFragment3 = null;
    private FragFourth myFragment4 = null;

    public FragPagerAdapter(FragmentManager fm) {
        super(fm);
        mVideoDisplayFrag = new FragFirst();
        myFragment2 = new FragSecond();
        myFragment3 = new FragThird();
        myFragment4 = new FragFourth();
    }


    @Override
    public int getCount() {
        return PAGER_COUNT;
    }

    @Override
    public Object instantiateItem(ViewGroup vg, int position) {
        return super.instantiateItem(vg, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        System.out.println("position Destory" + position);
        super.destroyItem(container, position, object);
    }

    @Override
    public androidx.fragment.app.Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case MainActivity.PAGE_ONE:
                fragment = mVideoDisplayFrag;
                break;
            case MainActivity.PAGE_TWO:
                fragment = myFragment2;
                break;
            case MainActivity.PAGE_THREE:
                fragment = myFragment3;
                break;
            case MainActivity.PAGE_FOUR:
                fragment = myFragment4;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + position);
        }
        return fragment;
    }


}

