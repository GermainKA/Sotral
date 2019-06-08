package myactivity.cp16.com.sotral_way.Views;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import myactivity.cp16.com.sotral_way.R;
import myactivity.cp16.com.sotral_way.Views.Admin.AdminRecord;

import static java.lang.System.exit;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public final static String nav_choix = "myactivity.cp16.com.sotral_way.Views.HomeActivity.nav_choix";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbaronha);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_ha);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_viewha);
        navigationView.setNavigationItemSelectedListener(this);

        Button connexion =(Button) findViewById(R.id.idhomelogin);
        connexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_ha);
                drawer.closeDrawer(GravityCompat.START);
            }
        });


        MapFragment fragment = new MapFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.fragcontenairha, fragment);
            fragmentTransaction.commit();


    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_ha);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_activity_d, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_etudiants) {
            Intent loginIntent = new Intent(HomeActivity.this,
                    LoginMainActivity.class);
            loginIntent.putExtra(nav_choix,R.id.nav_etudiants);
            startActivity(loginIntent);

        } else if (id == R.id.nav_administration) {
            Intent loginIntent = new Intent(HomeActivity.this,
                    LoginMainActivity.class);
            loginIntent.putExtra(nav_choix,R.id.nav_administration);
            startActivity(loginIntent);

        } else if (id == R.id.nav_Autres) {
            Intent loginIntent = new Intent(HomeActivity.this,
                    LoginMainActivity.class);
            loginIntent.putExtra(nav_choix,R.id.nav_Autres);
            startActivity(loginIntent);

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_exit) {

            exit(0);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_ha);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
