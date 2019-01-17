package myactivity.cp16.com.sotral_way.Views.Autre;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import myactivity.cp16.com.sotral_way.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class AnonymeRecord extends Fragment {
    Button bntRegisterAnony;


    public static final String TAG = "AdministrateurFragment";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view =inflater.inflate ( R.layout.fragment_anonyme_record, container, false );
            bntRegisterAnony =(Button)view.findViewById(R.id.idBntRegisterAnony);
            View.OnClickListener bntRegisterListener=new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    bntRegisterAnonyOnClick();

                }
            };
            bntRegisterAnony.setOnClickListener(bntRegisterListener);
        return view;
    }

    public void bntRegisterAnonyOnClick(){
        AnonymeAuthentification fragment = new AnonymeAuthentification();
        if (fragment != null) {
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragmentcontenairloi, fragment);
            fragmentTransaction.commit();

        }
    }

}
