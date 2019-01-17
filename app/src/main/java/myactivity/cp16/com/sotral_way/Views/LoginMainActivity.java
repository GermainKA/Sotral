package myactivity.cp16.com.sotral_way.Views;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import myactivity.cp16.com.sotral_way.R;
import myactivity.cp16.com.sotral_way.Views.Admin.AdminAuthentification;
import myactivity.cp16.com.sotral_way.Views.Autre.AnonymeAuthentification;
import myactivity.cp16.com.sotral_way.Views.Etudiant.EtudiantAuthentification;

import static java.lang.System.exit;

public class LoginMainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;

    RadioGroup radioGroup;
    RadioButton radioButtonAdmin, radioButtonEtudiant, radioButtonAnonyme;
    public final static String loggedUSER = "myactivity.cp16.com.sotral_way.Views.LoginMainActivity.loggedUser";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_drawer);

        Toolbar toolbar=findViewById(R.id.toolbaronloi);
        setSupportActionBar(toolbar);
        drawer=findViewById(R.id.drawer_layout_loi);

        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawer,toolbar,
                R.string.navigation_drawer_open,R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);
        toggle.syncState();


        radioGroup = (RadioGroup) findViewById(R.id.idRadioGroup);
        radioButtonAdmin = (RadioButton) findViewById(R.id.radioBtnAdmin);
        radioButtonEtudiant = (RadioButton) findViewById(R.id.radioBtnEtudiant);
        radioButtonAnonyme = (RadioButton) findViewById(R.id.radioBtnAnonyme);






       // AdminAuthentification mainFragment=new AdminAuthentification();
       // getSupportFragmentManager().beginTransaction().add(R.id.fragmentcontenair,mainFragment,null).commit();

        Intent i = getIntent();
        int selectId = i.getIntExtra(HomeActivity.nav_choix, R.id.nav_etudiants);
        if (selectId == R.id.nav_etudiants) {
            actionEtudiantClicked();
            radioButtonEtudiant.setChecked(true);
        } else if (selectId == R.id.nav_administration) {
            actionAdminClicked();
            radioButtonAdmin.setChecked(true);
        } else if (selectId == R.id.nav_Autres) {
            actionAnonymeClicked();
            radioButtonAnonyme.setChecked(true);
        } else if (selectId == R.id.nav_share) {
            //TODO
        } else if (selectId == R.id.nav_exit) {
            exit(0);
        }



        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch (checkedId) {
                    case R.id.radioBtnAdmin:
                        actionAdminClicked();
                        break;
                    case R.id.radioBtnEtudiant:
                        actionEtudiantClicked();
                        break;
                    case R.id.radioBtnAnonyme:
                        actionAnonymeClicked();

                        break;
                }

            }
        });

    }
    public void OnBackPressed(){
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }

    }

    public void actionAdminClicked(){
        AdminAuthentification fragment = new AdminAuthentification();
        if (fragment != null){
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragmentcontenairloi, fragment);
            fragmentTransaction.commit();
            Toast.makeText(getApplicationContext(), "Administration", Toast.LENGTH_SHORT).show();
        }
    }

    public void actionEtudiantClicked(){
        EtudiantAuthentification fragment = new EtudiantAuthentification();
        if (fragment != null){
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragmentcontenairloi, fragment);
            fragmentTransaction.commit();
            Toast.makeText(getApplicationContext(), "Edutiant", Toast.LENGTH_SHORT).show();
        }
    }

    public void actionAnonymeClicked(){
         AnonymeAuthentification fragment = new AnonymeAuthentification();
        if (fragment != null){
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragmentcontenairloi, fragment);
            fragmentTransaction.commit();
            Toast.makeText(getApplicationContext(), "Anonyme", Toast.LENGTH_LONG).show();
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}