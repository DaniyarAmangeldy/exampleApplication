package method.exampleapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by daniyaramangeldy on 30.06.17.
 */

public class BottomNavigationAdapter extends FragmentPagerAdapter {
    InstaListFragment fragment1;
    InstaFragment2 fragment2;

    public BottomNavigationAdapter(FragmentManager fm) {
        super(fm);
        fragment1 = new InstaListFragment();
        fragment2 = new InstaFragment2();
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return fragment1;
            case 1:
                return fragment2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
