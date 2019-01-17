package myactivity.cp16.com.sotral_way.Views.Etudiant;

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


public class EtudiantAuthentification extends Fragment {

    TextView txtCreateEtudiant;
    Button loginEtudiant;

    public EtudiantAuthentification() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_etudiant_authentification, container, false);

        txtCreateEtudiant = (TextView) view.findViewById(R.id.btnRecordEtudiant);
        loginEtudiant =(Button)view.findViewById(R.id.idBtnLoginEtd);



        View.OnClickListener loginEtuClickListenner = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginEtuClick();
            }
        };

        loginEtudiant.setOnClickListener(loginEtuClickListenner);

        txtCreateEtudiant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EtudiantRecord fragment = new EtudiantRecord();
                if (fragment != null){
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragmentcontenairloi, fragment);
                    fragmentTransaction.commit();
                    Toast.makeText(getContext(), "Admin action", Toast.LENGTH_LONG).show();
                }
            }
        });

        // Inflate the layout for this fragment
        return view;
    }
    public void loginEtuClick(){
        Intent intent = new Intent(getActivity(), LoggedOnActivity.class);
        intent.putExtra(loggedUSER,R.id.idBtnLoginEtd);
        startActivity(intent);

    }
}
