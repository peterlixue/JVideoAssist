package com.ai.jvideoassist.adapter;

import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.ai.jvideoassist.MainActivity;
import com.ai.jvideoassist.widget.FragSetting;
import com.ai.jvideoassist.widget.FragVideo;
import com.ai.jvideoassist.widget.FragVoice;


public class FragPagerAdapter extends FragmentPagerAdapter {

    private static final String TAG = "FragPagerAdapter";

    public final int PAGER_COUNT = 1;


    private FragVideo mVideoFrag = null;
    private FragVoice   mVoiceFrag = null;

    private FragSetting myFragment3 = null;


    public FragPagerAdapter(FragmentManager fm) {
        super(fm);
        mVideoFrag = new FragVideo();
        mVoiceFrag = new FragVoice();
        myFragment3 = new FragSetting();

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
                fragment = mVideoFrag;
                break;
            case MainActivity.PAGE_TWO:
                fragment = mVoiceFrag;
                break;
            case MainActivity.PAGE_THREE:
                fragment = myFragment3;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + position);
        }
        return fragment;
    }


}

