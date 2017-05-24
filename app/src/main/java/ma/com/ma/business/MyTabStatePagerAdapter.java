package ma.com.ma.business;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Steph on 19/05/2017.
 */

public class MyTabStatePagerAdapter extends FragmentStatePagerAdapter{
    private final List<String> titles = new ArrayList<>();
    private final List<Fragment> fragments = new ArrayList<>();

    public MyTabStatePagerAdapter(FragmentManager manager) {
        super(manager);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    public void addFragment(Fragment fragment, String title) {
        fragments.add(fragment);
        titles.add(title);
    }
}
