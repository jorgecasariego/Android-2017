package jorgecasariego.materialdesign;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import jorgecasariego.materialdesign.fragments.Fragment1;
import jorgecasariego.materialdesign.fragments.Fragment2;
import jorgecasariego.materialdesign.fragments.Fragment3;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    DrawerLayout mDrawerLayout;
    NavigationView mNavigationView;
    Toolbar mToolbar;
    FloatingActionButton mFloatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.nav_view);
        mNavigationView.setNavigationItemSelectedListener(this);

        mToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(mToolbar);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mFloatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
        mFloatingActionButton.setOnClickListener(this);

        if(savedInstanceState == null){
            cambiarFragment(new Fragment1());
        } else {
            String mensaje = savedInstanceState.getString("mensaje");
            Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("mensaje", "Este es un mensaje desde el mas alla");
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        boolean fragmentTransaction = false;

        switch (item.getItemId()){
            case R.id.menu_1:
                fragment = new Fragment1();
                fragmentTransaction = true;
                break;
            case R.id.menu_2:
                fragment = new Fragment2();
                fragmentTransaction = true;
                break;
            case R.id.menu_3:
                fragment = new Fragment3();
                fragmentTransaction = true;
                break;
        }

        if(fragmentTransaction){
            cambiarFragment(fragment);
            item.setChecked(true);
            getSupportActionBar().setTitle(item.getTitle());
        }

        mDrawerLayout.closeDrawers();
        return true;
    }

    private void cambiarFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame, fragment)
                .commit();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
        }

        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fab:
                Toast.makeText(this, "El floating Action button ha sido pulsado", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
