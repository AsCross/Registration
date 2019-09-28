package com.ascrossgams.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.ascrossgams.myapplication.ui.fullArticle.FullArticleFragment;
import com.ascrossgams.myapplication.ui.sources.SourcesFragment;
import com.ascrossgams.myapplication.ui.news.NewsFragment;
import com.ascrossgams.myapplication.ui.exit.ExitFragment;
import com.ascrossgams.myapplication.ui.weather.WeatherFragment;
import com.ascrossgams.myapplication.ui.profile.ProfileFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    NewsFragment newsFragment;
    SourcesFragment sourcesFragment;
    WeatherFragment weatherFragment;
    ProfileFragment profileFragment;
    ExitFragment exitFragment;
    FullArticleFragment fullArticleFragment;
    private DrawerLayout mDrawer;
    private AppBarConfiguration mAppBarConfiguration;
    private Toolbar toolbar;
    private NavigationView nvDrawer;

    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        nvDrawer = (NavigationView) findViewById(R.id.nav_view);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        newsFragment = new NewsFragment();
        sourcesFragment = new SourcesFragment();
        weatherFragment = new WeatherFragment();
        profileFragment = new ProfileFragment();
        exitFragment = new ExitFragment();
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_news, R.id.nav_sources, R.id.nav_weather,
                R.id.nav_profile, R.id.nav_exit)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawer.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        FragmentTransaction ftrans = getSupportFragmentManager().beginTransaction();

        if (id == R.id.nav_news) {
            ftrans.replace(R.id.nav_host_fragment, newsFragment);
        } else if (id == R.id.nav_sources) {
            ftrans.replace(R.id.nav_host_fragment, sourcesFragment);

        } else if (id == R.id.nav_weather) {
            ftrans.replace(R.id.nav_host_fragment, weatherFragment);

        } else if (id == R.id.nav_exit) {
            ftrans.replace(R.id.nav_host_fragment, exitFragment);


        } else if (id == R.id.nav_profile) {
            ftrans.replace(R.id.nav_host_fragment, profileFragment);

        } ftrans.commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
