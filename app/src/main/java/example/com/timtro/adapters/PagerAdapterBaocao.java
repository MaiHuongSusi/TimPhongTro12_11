package example.com.timtro.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import example.com.timtro.views.Fragment5;
import example.com.timtro.views.Fragment6;
import example.com.timtro.views.Fragment7;

public class PagerAdapterBaocao extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapterBaocao(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                Fragment5 tab1 = new Fragment5();
                return tab1;
            case 1:
                Fragment6 tab2 = new Fragment6();
                return tab2;
            case 2:
                Fragment7 tab3 = new Fragment7();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}