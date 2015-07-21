package com.ninto.androiddesignlibexplore;

import android.content.res.Configuration;
import android.support.design.internal.NavigationMenuPresenter;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.FrameLayout;
import android.widget.SlidingDrawer;

public class MainActivity extends AppCompatActivity {



    private NavigationView _NNavigationView;
    private DrawerLayout _NDrawerLayOut;
    private Toolbar _NToolBar;
    private ActionBarDrawerToggle _NDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        _NToolBar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(_NToolBar);

        _NNavigationView = (NavigationView) findViewById(R.id.navigation_drawer);
        _NDrawerLayOut = (DrawerLayout) findViewById(R.id.drawer_layout);
        _NDrawerToggle = new ActionBarDrawerToggle(this,_NDrawerLayOut,R.string.drawer_open,R.string.drawer_close){

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(){

                //Do Something when closed

            }
            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(){
                //Do something when opened

            }
        };

        _NDrawerLayOut.setDrawerListener(_NDrawerToggle);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);




        _NNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){

            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                int _MenuId = menuItem.getItemId();
                switch (_MenuId){
                    case R.id.navigation_item1:
                        //do something
                        break;
                    case R.id.navigation_item2:
                        //do something
                        break;
                }
                menuItem.setChecked(true);
                _NDrawerLayOut.closeDrawers();

                return true;
            }
        });

        addNavigationItems(_NNavigationView);

    }

    public void addNavigationItems(NavigationView navigationView){

        MenuBuilder _NavMenu = (MenuBuilder)navigationView.getMenu();

        _NavMenu.add("nav_dynamic1");
        _NavMenu.add("nav_dynamic2");
        _NavMenu.add("nav_dynamic3");
        SubMenu _submenu  = _NavMenu.addSubMenu("subsection1");
        _submenu.add("subsetitem1");
        _submenu.add("subsectitem2");

        _NavMenu.onItemsChanged(true);
//        MenuBuilder yoyo = new MenuBuilder(getApplicationContext());
//
//        NavigationMenuPresenter _NavigationMenuPresenter = new NavigationMenuPresenter();
//        _NavigationMenuPresenter.updateMenuView(false);
//        navigationView.getChildAt()

    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        _NDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        _NDrawerToggle.onConfigurationChanged(newConfig);
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
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        if (_NDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle your other action bar items...

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
