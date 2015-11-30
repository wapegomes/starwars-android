package com.frameworksystem.starwars.ui.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.frameworksystem.starwars.Mock;
import com.frameworksystem.starwars.R;
import com.frameworksystem.starwars.model.User;
import com.frameworksystem.starwars.ui.fragment.DroidFragment;
import com.frameworksystem.starwars.ui.fragment.DroidsFragment;
import com.frameworksystem.starwars.ui.fragment.FilmsFragment;
import com.frameworksystem.starwars.ui.fragment.HighlightsFragments;
import com.frameworksystem.starwars.ui.fragment.LoginFragment;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, LoginFragment.OnLoginListener {

    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_main, DroidsFragment.newInstance())
                .commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        Fragment fragment = null;

        if (id == R.id.nav_characteres) {
            // Handle the camera action
        } else if (id == R.id.nav_droids) {
            fragment = DroidsFragment.newInstance();
        } else if (id == R.id.nav_vehicles) {

        } else if (id == R.id.nav_films) {
            fragment = FilmsFragment.newInstance();
        }
        else if (id == R.id.nav_login) {
            LoginFragment loginFragment = LoginFragment.newInstance();
            loginFragment.setOnLoginListener(this);
            beginTransaction.addToBackStack(LoginFragment.class.getName());
        }
        else if (id == R.id.nav_logout) {
            hideMenuLogin(false);
        }

        if (fragment == null) {
            fragment = HighlightsFragments.newInstance();
        }

        beginTransaction
                .replace(R.id.content_main, fragment)
                .commit();


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    public void onLogin(User user) {
        getSupportFragmentManager().popBackStack();
        hideMenuLogin(true);
    }

    private void hideMenuLogin(boolean hide) {
        Menu menu = navigationView.getMenu();

        MenuItem itemLogin = menu.findItem(R.id.nav_login);
        MenuItem itemLogout = menu.findItem(R.id.nav_logout);
        MenuItem itemProfile = menu.findItem(R.id.nav_profile);

        itemLogin.setVisible(hide);
        itemLogout.setVisible(!hide);
        itemProfile.setVisible(!hide);
    }
}
