package me.chenfuduo.moonnewsclient;

import android.app.ActionBar;
import android.app.Activity;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class TestActivity02 extends Activity {

    private DrawerLayout mDrawerLayout;

    private ListView mDrawer;

    private ActionBarDrawerToggle mDrawerToggle;

    private ActionBaHelper mActionBar;

    private String[] books = {"Math","Chinese","English","Beauty of math"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test02);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        mDrawer = (ListView) findViewById(R.id.start_drawer);

        mDrawerLayout.setDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                mDrawerToggle.onDrawerSlide(drawerView,slideOffset);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                mDrawerToggle.onDrawerOpened(drawerView);
                mActionBar.onDrawerOpened();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                mDrawerToggle.onDrawerClosed(drawerView);
                mActionBar.onDrawerClosed();
            }

            @Override
            public void onDrawerStateChanged(int newState) {
                mDrawerToggle.onDrawerStateChanged(newState);
            }
        });

        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);

        mDrawerLayout.setDrawerTitle(GravityCompat.START,"Navigation");

        mDrawer.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,books));

        mDrawer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mActionBar.setTitle(books[position]);
                mDrawerLayout.closeDrawer(mDrawer);
            }
        });

        mActionBar = createActionBarHelper();

        mActionBar.init();

        mDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.mipmap.ic_launcher,R.string.open,R.string.close);

    }

    @Override
    public void onPostCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }


    private ActionBaHelper createActionBarHelper(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH){
            return  new ActionBarHelperICS();
        }else{
            return new ActionBaHelper();
        }
    }


    private class ActionBaHelper{
        public void init(){}
        public void onDrawerClosed(){}
        public void onDrawerOpened(){}
        public void setTitle(CharSequence title){}
    }

    private class ActionBarHelperICS extends ActionBaHelper{


        private ActionBar mActionBar;

        private CharSequence mDrawerTitle;

        private CharSequence mTitle;

        public ActionBarHelperICS() {
            mActionBar = getActionBar();
        }

        @Override
        public void init() {
            super.init();
            mActionBar.setDisplayHomeAsUpEnabled(true);
            mActionBar.setHomeButtonEnabled(true);
            mTitle = mDrawerTitle = getTitle();
        }

        @Override
        public void onDrawerClosed() {
            super.onDrawerClosed();
            mActionBar.setTitle(mTitle);
        }

        @Override
        public void onDrawerOpened() {
            super.onDrawerOpened();
            mActionBar.setTitle(mTitle);
        }

        @Override
        public void setTitle(CharSequence title) {
            super.setTitle(title);
            mTitle = title;
        }
    }


}
