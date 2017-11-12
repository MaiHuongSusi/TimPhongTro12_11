package example.com.timtro.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 21/09/2017.
 */

public class FragmentAdapter extends FragmentPagerAdapter {
    private static final int PAGE_COUNT=2;
    ArrayList<Fragment> list = new ArrayList<>();
    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }
    public void insertFragment(Fragment fragment){
        list.add(fragment);
    }
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position){
            case 0:
                title = "Thông tin chung";
                break;
            case 1:
                title = "Chi tiết";
                break;
        }
        return title;
    }
}

