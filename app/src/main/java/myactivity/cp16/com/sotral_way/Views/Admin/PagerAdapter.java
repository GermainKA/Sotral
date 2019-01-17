package myactivity.cp16.com.sotral_way.Views.Admin;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNoOfTabs;

    public PagerAdapter(FragmentManager fm,int numOfTabs){
        super(fm);
        this.mNoOfTabs=numOfTabs;
    }
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                TabHoraire tabHoraire=new TabHoraire();
                return tabHoraire;
            case 1:
                TabMap tabMap=new TabMap();
                return tabMap;
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return mNoOfTabs;
    }
}
