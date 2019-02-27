package myactivity.cp16.com.sotral_way.Views.Etudiant;


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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

import myactivity.cp16.com.sotral_way.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class EtudiantRecord extends Fragment {

    Button registerEtu;
    EditText nom;
    EditText prenom;
    EditText numcard;
    EditText email;
    EditText password;

    FirebaseAuth auth;
    FirebaseDatabase mdatabase;
    DatabaseReference mreference;

    public static final String TAG = "AdministrateurFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_etudiant_record, container, false);

        registerEtu = (Button) view.findViewById(R.id.idBntRegisterEtu);
        password =  view.findViewById(R.id.input8);
        email = view.findViewById(R.id.input7);
        numcard= view.findViewById(R.id.input6);
        nom= view.findViewById(R.id.input4);
        prenom = view.findViewById(R.id.input5);



        View.OnClickListener registerEtuOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String textpassword =  password.getText().toString();
                String  textemail = email.getText().toString();
                String  textnumcard= numcard.getText().toString();
                String  textnom= nom.getText().toString();
                String  textprenom = prenom.getText().toString();

                SendtoFirebase(textnom , textprenom,textemail ,textpassword ,textnumcard );


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
    private void SendtoFirebase(final String nom , final String prenom , final String email , final String password, final String numcard  )
    {
       if(TextUtils.isEmpty(nom) ||  TextUtils.isEmpty(prenom) || TextUtils.isEmpty(email) || TextUtils.isEmpty(password) || TextUtils.isEmpty(numcard) )
       {
           Toast.makeText(getContext(),"champs non rensegné",Toast.LENGTH_SHORT).show();
       }
       else if(password.length()<6)
       {
           Toast.makeText(getContext(),"mot de passe doit contenir plus de 6 caractere",Toast.LENGTH_SHORT).show();
       }
       else{
           auth = FirebaseAuth.getInstance();
           auth.createUserWithEmailAndPassword(email , password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
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

                               RegisterEtuOnClick();
                           }
                       });


                   }

               }
           });

       }
    }
}