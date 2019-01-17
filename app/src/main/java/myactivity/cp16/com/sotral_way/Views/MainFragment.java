package myactivity.cp16.com.sotral_way.Views;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;

import myactivity.cp16.com.sotral_way.Adapter.SlideAdapter;
import myactivity.cp16.com.sotral_way.R;

public class MainFragment extends Fragment {

    ViewPager viewPager;

    public MainFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        SlideAdapter slideAdapter = new SlideAdapter(getContext());
        viewPager.setAdapter(slideAdapter);
        MyTimerTask myTimerTask=new MyTimerTask();
        Timer timer=new Timer();
        timer.scheduleAtFixedRate(myTimerTask,2000,3000);


        return view;

    }

    public class MyTimerTask extends TimerTask {


        @Override
        public void run() {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                        viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                        if (viewPager.getCurrentItem()==8){
                            viewPager.setCurrentItem(0);
                        }

                }
            });


        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;
        try {
        } catch (ClassCastException E) {
            throw new ClassCastException(activity.toString() + "must implement onButton...");

        }


    }

    public void OnResume() {
        super.onResume();
    }
}
