package myactivity.cp16.com.sotral_way.Views.Admin;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

;import myactivity.cp16.com.sotral_way.R;


public class AdminRecord extends Fragment {
    public static final String TAG = "AdministrateurFragment";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate ( R.layout.fragment_admin_record, container, false );
    }
}
