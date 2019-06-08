package myactivity.cp16.com.sotral_way.Views.Etudiant;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;


import myactivity.cp16.com.sotral_way.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class EtudiantRecord extends Fragment implements View.OnClickListener {

    Button registerEtuBtn;
    EditText name;
    EditText lastName;
    EditText numCard;
    EditText email;
    EditText password;
    private EtudiantClass etudiant;

    private ProgressBar progressBar;

    private FirebaseAuth mAuth;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference reference;



    public static final String TAG = "AdministrateurFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_etudiant_record, container, false);



        registerEtuBtn = (Button) view.findViewById(R.id.idBtnEtuRegister);
        password =  view.findViewById(R.id.idEditRgterEtuPass);
        email = view.findViewById(R.id.idEditEtuEmail);
        numCard = view.findViewById(R.id.idEditEtuRgterNumCarte);
        name = view.findViewById(R.id.idEditEtuName);
        lastName = view.findViewById(R.id.idEditEtulastName);
        progressBar = view.findViewById(R.id.idpBarEtuRegister);
        mAuth = FirebaseAuth.getInstance();
        etudiant = new EtudiantClass();

        firebaseDatabase=FirebaseDatabase.getInstance();
        reference=firebaseDatabase.getReference().child("Etudiant");



        registerEtuBtn.setOnClickListener(this);

        return view;
    }



    @Override
    public void onClick(View view) {

        if(view== registerEtuBtn){
            progressBar.setVisibility(View.GONE);
            registerEtudiant();

        }
    }
    private void registerEtudiant()
    {
        progressBar.setVisibility(View.VISIBLE);
        String textPassword =  password.getText().toString();
        String  textEmail = email.getText().toString();
        String  textNumcard= numCard.getText().toString();
        String  textName= name.getText().toString();
        String  textLastName = lastName.getText().toString();


        if (TextUtils.isEmpty(textEmail)) {
            Toast.makeText(getContext(), "S.V.P entrer l'email...", Toast.LENGTH_LONG).show();
            progressBar.setVisibility(View.GONE);
            return;
        }
        if (TextUtils.isEmpty(textPassword)) {
            Toast.makeText(getContext(), "S.V.P entrer le mot de passe!", Toast.LENGTH_LONG).show();
            progressBar.setVisibility(View.GONE);
            return;
        }
        etudiant.setNumCard(textNumcard);
        etudiant.setEmail(textEmail);
        etudiant.setName(textName);
        etudiant.setLastName(textLastName);
        etudiant.setPassword(textPassword);

        progressBar.setVisibility(View.VISIBLE);
        //reference.child(etudiant.getNumCard()).setValue(etudiant);
        reference.setValue("Hello, World!");
        progressBar.setVisibility(View.GONE);
        Toast.makeText(getContext(), "Registration successful!", Toast.LENGTH_LONG).show();
        /*mAuth.createUserWithEmailAndPassword(textEmail, textPassword)
                .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getContext(), "Registration successful!", Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);

                        }
                        else {
                            Toast.makeText(getContext(), "Registration failed! Please try again later", Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);

                        }
                    }
                });*/




    }
}

