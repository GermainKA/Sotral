package myactivity.cp16.com.sotral_way.Views.Etudiant;


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
public class EtudiantRecord extends Fragment {

    Button registerEtu;

    public static final String TAG = "AdministrateurFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_etudiant_record, container, false);
        registerEtu = (Button) view.findViewById(R.id.idBntRegisterEtu);
        View.OnClickListener registerEtuOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegisterEtuOnClick();
            }
        };
       registerEtu.setOnClickListener(registerEtuOnClickListener);
        return view;
    }

    public void RegisterEtuOnClick() {
        EtudiantAuthentification fragment = new EtudiantAuthentification();
        if (fragment != null) {
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragmentcontenairloi, fragment);
            fragmentTransaction.commit();

        }

    }
}