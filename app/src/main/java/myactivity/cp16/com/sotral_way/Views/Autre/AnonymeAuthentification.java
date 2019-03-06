package myactivity.cp16.com.sotral_way.Views.Autre;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import myactivity.cp16.com.sotral_way.R;
import myactivity.cp16.com.sotral_way.Views.LoggedOnActivity;

import static myactivity.cp16.com.sotral_way.Views.LoginMainActivity.loggedUSER;


public class AnonymeAuthentification extends Fragment {

    TextView goToAnoyRecord;
    Button bntLoginAnonyme;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_anonyme_authentification, container, false);

        goToAnoyRecord = (TextView) view.findViewById(R.id.idGoToRecordAnony);
        bntLoginAnonyme =(Button)view.findViewById(R.id.idBtnLoginAnony);


        View.OnClickListener bntLoginListener= new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bntLoginAnonyOnClick();
            }
        };


        bntLoginAnonyme.setOnClickListener(bntLoginListener);

        goToAnoyRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnonymeRecord fragment = new AnonymeRecord();
                if (fragment != null){
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragmentcontenairloi, fragment);
                    fragmentTransaction.commit();
                    Toast.makeText(getContext(), "Admin action", Toast.LENGTH_LONG).show();
                    }
            }
        });

        return view;
    }

    public void bntLoginAnonyOnClick(){
        Intent intent = new Intent(getActivity(), LoggedOnActivity.class);
        intent.putExtra(loggedUSER,R.id.idBtnLoginAnony);
        startActivity(intent);
    }
    public void goToAnoyreOnClick(){
        Intent intent = new Intent(getActivity(), LoggedOnActivity.class);
        intent.putExtra(loggedUSER,R.id.idBtnLoginAnony);
        startActivity(intent);
    }

}
