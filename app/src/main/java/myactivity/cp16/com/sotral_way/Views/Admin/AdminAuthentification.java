package myactivity.cp16.com.sotral_way.Views.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import android.support.v4.app.Fragment;

import myactivity.cp16.com.sotral_way.R;


public class AdminAuthentification extends Fragment {

    TextInputEditText txtLineNumber, txtPassword;
    Button btnLoginAdmin;
    FloatingActionButton floatRegisterBtnAdmin;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_admin_authentification, container, false);

        txtLineNumber = (TextInputEditText) view.findViewById(R.id.idLineNumbers);
        txtPassword = (TextInputEditText) view.findViewById(R.id.idPassword);
        btnLoginAdmin = (Button) view.findViewById(R.id.idBtnLoginAdm);

        btnLoginAdmin.setOnClickListener(btnOnClickListener);

        floatRegisterBtnAdmin = (FloatingActionButton) view.findViewById(R.id.btnRecordAdmin);

        floatRegisterBtnAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdminRecord fragment = new AdminRecord();
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

    private View.OnClickListener btnOnClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            send();
        }
    };

    private void send(){
        if(TextUtils.isEmpty(txtLineNumber.getText().toString().trim()) || TextUtils.isEmpty(txtPassword.getText().toString().trim())){
            txtLineNumber.setError("Champs Vide !");
            txtPassword.setError("Champs Vide !");
        }else if(LineNumberIsValid(txtLineNumber.getText().toString())==false){
            txtLineNumber.setError("Numéro de ligne Invalide");
        }else{

            Intent intent = new Intent(getActivity(), AdminTabActivity.class);
             //intent.putExtra(loggedUSER,R.id.idBtnLoginAdm);
            startActivity(intent);
            Toast.makeText(getContext(), "Connexion établie avec succès", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean LineNumberIsValid(String lineNumber){
        boolean temp=false;
        int val=1;
            if(val == 1){
                //Correspondre le numero dans la table ligne de la base de données
                //
                temp = true;
            }
        return temp;
    }

}
