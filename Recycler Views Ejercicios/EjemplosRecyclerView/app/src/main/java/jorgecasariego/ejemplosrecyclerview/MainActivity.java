package jorgecasariego.ejemplosrecyclerview;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import jorgecasariego.ejemplosrecyclerview.fragment.GridHorizontalFragment;
import jorgecasariego.ejemplosrecyclerview.fragment.GridSpanSizeVerticalFragment;
import jorgecasariego.ejemplosrecyclerview.fragment.GridVerticalFragment;
import jorgecasariego.ejemplosrecyclerview.fragment.ItemTypesVerticalFragment;
import jorgecasariego.ejemplosrecyclerview.fragment.LinearHorizontalFragment;
import jorgecasariego.ejemplosrecyclerview.fragment.LinearVerticalFragment;
import jorgecasariego.ejemplosrecyclerview.fragment.StaggeredHorizontalFragment;
import jorgecasariego.ejemplosrecyclerview.fragment.StaggeredVerticalFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        navigateTo(LinearVerticalFragment.newInstance());
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

        Fragment fragment = null;

        if (id == R.id.nav_linearlayout_vertical) {
            fragment = LinearVerticalFragment.newInstance();
        } else if (id == R.id.nav_linearlayout_horizontal) {
            fragment = LinearHorizontalFragment.newInstance();
        } else if (id == R.id.nav_grid_layout_vertical) {
            fragment = GridVerticalFragment.newInstance();
        } else if (id == R.id.nav_grid_layout_horizontal) {
            fragment = GridHorizontalFragment.newInstance();
        } else if (id == R.id.nav_grid_layout_span) {
            fragment = GridSpanSizeVerticalFragment.newInstance();
        } else if (id == R.id.nav_staggered_grid_vertical) {
            fragment = StaggeredVerticalFragment.newInstance();
        } else if (id == R.id.nav_staggered_grid_horizontal) {
            fragment = StaggeredHorizontalFragment.newInstance();
        } else if (id == R.id.nav_item_types) {
            fragment = ItemTypesVerticalFragment.newInstance();
        } else if (id == R.id.nav_recycler_responsive) {

        } else if (id == R.id.nav_recycler_responsive_qualifier) {

        }

        navigateTo(fragment);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void navigateTo(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }


}
