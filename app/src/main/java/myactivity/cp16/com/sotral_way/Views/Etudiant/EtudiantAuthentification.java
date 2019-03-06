package myactivity.cp16.com.sotral_way.Views.Etudiant;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import myactivity.cp16.com.sotral_way.R;
import myactivity.cp16.com.sotral_way.Views.LoggedOnActivity;

import static myactivity.cp16.com.sotral_way.Views.LoginMainActivity.loggedUSER;


public class EtudiantAuthentification extends Fragment {

    TextView txtCreateEtudiant;
    Button loginEtudiant;
    TextInputEditText numcard,email;
    private FirebaseAuth auth;

    public EtudiantAuthentification() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_etudiant_authentification, container, false);
        numcard= view.findViewById ( R.id.idPasswordEtd );
        email =view.findViewById ( R.id.idCartNumber );
        auth = FirebaseAuth.getInstance ();
        txtCreateEtudiant = (TextView) view.findViewById(R.id.btnGotoRecordEtudiant);
        loginEtudiant =(Button)view.findViewById(R.id.idBtnLoginEtd);



        View.OnClickListener loginEtuClickListenner = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String memail = email.getText ().toString ();
                String mnumcard = numcard.getText ().toString ();
                if(TextUtils.isEmpty ( memail )|| TextUtils.isEmpty (mnumcard )){
                    Toast.makeText ( getActivity (),"tous les champs doivent etre rensegner ", Toast.LENGTH_SHORT ).show ();
                }
                else{
                    firebasecheck(memail,mnumcard);
                }

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
    public  void  firebasecheck(final String txt_email, final String txt_password) {
        auth.signInWithEmailAndPassword(txt_email, txt_password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {

                            Toast.makeText(getActivity(), "champs renseigner  ", Toast.LENGTH_SHORT).show();
                            loginEtuClick();
                            getActivity().finish();
                        } else {
                            //
                            Toast.makeText(getActivity(), "l Authetification a echouer", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
    public void loginEtuClick(){
        Intent intent = new Intent(getActivity(), LoggedOnActivity.class);
        intent.putExtra(loggedUSER,R.id.idBtnLoginEtd);
        startActivity(intent);
    }
}
