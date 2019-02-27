package myactivity.cp16.com.sotral_way.Views.Autre;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

import myactivity.cp16.com.sotral_way.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class AnonymeRecord extends Fragment {
    Button bntRegisterAnony;
    EditText numtelephone;
    EditText adresse;

    FirebaseAuth auth;
    FirebaseDatabase mdatabase;
    DatabaseReference mreference;



    public static final String TAG = "AdministrateurFragment";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view =inflater.inflate ( R.layout.fragment_anonyme_record, container, false );
            bntRegisterAnony =(Button)view.findViewById(R.id.idBntRegisterAnony);

        numtelephone= view.findViewById(R.id.input6);
        adresse = view.findViewById(R.id.input7);

            View.OnClickListener bntRegisterListener=new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String textnumtelephone=  numtelephone.getText().toString();
                    String  texttadresse = adresse.getText().toString();


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

    private void SendtoFirebase(final String numero, final String addresse )
    {
        if(TextUtils.isEmpty(numero) ||  TextUtils.isEmpty(addresse)  )
        {
            Toast.makeText(getContext(),"champs non rensegné",Toast.LENGTH_SHORT).show();
        }
        else if(numero.length()<8)
        {
            Toast.makeText(getContext(),"mot de passe doit contenir plus de 6 caractere",Toast.LENGTH_SHORT).show();
        }
        else{
            auth = FirebaseAuth.getInstance();

            PhoneAuthProvider.getInstance().verifyPhoneNumber(numero,60, TimeUnit.SECONDS, getActivity(),phoneAuthCallback);

            /*auth.createUserWithEmailAndPassword(email , password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful())
                    {
                        FirebaseUser user = auth.getCurrentUser();
                        String userid = user.getUid();
                        mreference = FirebaseDatabase.getInstance().getReference("Etudiants");
                        HashMap<String,  String> etudiant = new HashMap<>();
                        etudiant.put("nom", nom);
                        etudiant.put("prenom",prenom);
                        etudiant.put("email", email);
                        etudiant.put("password", password);
                        etudiant.put("numcard", numcard);
                        mreference.setValue(etudiant).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                Toast.makeText(getContext(),"donnees enregistrer avec succes ",Toast.LENGTH_SHORT).show();

                                bntRegisterAnonyOnClick();
                            }
                        });


                    }

                }
            })*/

        }
    }

    PhoneAuthProvider.OnVerificationStateChangedCallbacks phoneAuthCallback = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
            siginWithPhoneAuthCredencial(phoneAuthCredential);

        }

        @Override
        public void onVerificationFailed(FirebaseException e) {

        }
    };

    private  void siginWithPhoneAuthCredencial(PhoneAuthCredential phoneAuthCredential)
    {
        auth.signInWithCredential(
                phoneAuthCredential
        ).addOnCompleteListener( getActivity(),new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful())
                {
                    //sign in success message
                    FirebaseUser user = task.getResult().getUser();
                }
                else
                {
                    // toast
                            if(task.getException() instanceof FirebaseAuthInvalidCredentialsException)
                            {

                            }
                }
            }
        });
    }
}
