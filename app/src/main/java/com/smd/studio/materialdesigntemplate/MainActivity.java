package com.smd.studio.materialdesigntemplate;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    // Original tutorial can be found here - http://inthecheesefactory.com/blog/android-design-support-library-codelab/en
    // Further customization of Tabs using TabLayout - https://github.com/codepath/android_guides/wiki/Google-Play-Style-Tabs-using-TabLayout

    @Bind(R.id.fab)
    FloatingActionButton fab;
    @Bind(R.id.rootLayout)
    CoordinatorLayout rootLayout;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.collapsingToolbarLayout)
    CollapsingToolbarLayout collapsingToolbarLayout;
    //@Bind(R.id.tabLayout)
    //TabLayout tabLayout;
    @Bind(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @Bind(R.id.navigation)
    NavigationView navigation;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @OnClick(R.id.fab)
    public void clickFabButton() {
        Snackbar.make(rootLayout, "FAB button clicked", Snackbar.LENGTH_LONG)
                .setAction("SNACKBAR ACTION", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.d("FAB", "Snackbar action clicked!");
                    }
                })
                .show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initLayout();
    }

    private void initLayout() {
        setSupportActionBar(toolbar);
        collapsingToolbarLayout.setTitle(getResources().getString(R.string.toolbar_title));

        //tabLayout.addTab(tabLayout.newTab().setText("Tab 1"));
        //tabLayout.addTab(tabLayout.newTab().setText("Tab 2"));
        //tabLayout.addTab(tabLayout.newTab().setText("Tab 3"));

        //Set up the hamburger icon to open and close the drawer
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_navigation, R.string.close_navigation);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                int id = menuItem.getItemId();
                switch (id) {
                    case R.id.drawerItemOne:
                        Log.d("DRAWER", "Drawer Item One clicked!");
                        break;
                    case R.id.drawerItemTwo:
                        Log.d("DRAWER", "Drawer Item Two clicked!");
                        break;
                    case R.id.drawerItemThree:
                        Log.d("DRAWER", "Drawer Item Three clicked!");
                        break;
                    case R.id.drawerItemFour:
                        Log.d("DRAWER", "Drawer Item Four clicked!");
                        break;
                }
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
