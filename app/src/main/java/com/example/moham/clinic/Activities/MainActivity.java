package com.example.moham.clinic.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.internal.NavigationMenu;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.moham.clinic.Activities.AddPatientActivity;
import com.example.moham.clinic.Activities.weakActivity;
import com.example.moham.clinic.Extra.test;
import com.example.moham.clinic.Extra.testActivity;
import com.example.moham.clinic.Fragments.DayFragment;
import com.example.moham.clinic.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import io.github.yavski.fabspeeddial.FabSpeedDial;
import io.github.yavski.fabspeeddial.SimpleMenuListenerAdapter;
import maes.tech.intentanim.CustomIntent;
import me.anwarshahriar.calligrapher.Calligrapher;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FabSpeedDial fabSpeedDial = (FabSpeedDial) findViewById(R.id.fabb);
        fabSpeedDial.setMenuListener(new SimpleMenuListenerAdapter() {
            @Override
            public boolean onPrepareMenu(NavigationMenu navigationMenu) {
                // TODO: Do something with yout menu items, or return false if you don't want to show them
                return true;
            }

            @Override
            public boolean onMenuItemSelected(MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.action_add) {
                    Intent i=new Intent(getApplicationContext(),AddPatientActivity.class);
                    Bundle b=new Bundle();
                     b.putString("id","");
                    i.putExtras(b);
                    startActivity(i);


                    CustomIntent.customType(MainActivity.this, "up-to-bottom");

                }
                else if (menuItem.getItemId() == R.id.action_refresh) {
                    showFraqment(DayFragment.class);

                    CustomIntent.customType(MainActivity.this, "up-to-bottom");


                }


                return false;
            }
        });
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        showFraqment(DayFragment.class);
        Calligrapher calligrapher = new Calligrapher(getApplicationContext());
        calligrapher.setFont(this, "Tajawal-Regular.ttf", true);
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
       /* if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_day) {
            Class fragment;
            fragment = DayFragment.class;
            showFraqment(fragment);
        } else if (id == R.id.nav_weak) {
            startActivity(new Intent(getApplicationContext(), Weak2Activity.class));
            CustomIntent.customType(MainActivity.this, "left-to-right");

        }
        else if(id==R.id.nav_search)
        {
            startActivity(new Intent(getApplicationContext(), SearchingActivity.class));
            CustomIntent.customType(MainActivity.this, "left-to-right");
        }
        else if(id==R.id.nav_exit)
        {
            System.exit(0);
        }
        else if(id==R.id.nav_add)
        {
            Intent i=new Intent(getApplicationContext(),AddPatientActivity.class);
            Bundle b=new Bundle();
            b.putString("id","");
            i.putExtras(b);
            startActivity(i);
            CustomIntent.customType(MainActivity.this, "left-to-right");
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void showFraqment(Class fragmentClass) {
        Fragment fragment = null;
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.day, fragment).commit();

    }

}
