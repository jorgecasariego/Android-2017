package jorgecasariego.fragments.combos;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import jorgecasariego.fragments.R;

public class CombosActivity extends AppCompatActivity implements View.OnClickListener {

    Button mCombo1;
    Button mCombo2;
    Button mCombo3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combos);

        mCombo1 = (Button) findViewById(R.id.combo1);
        mCombo2 = (Button) findViewById(R.id.combo2);
        mCombo3 = (Button) findViewById(R.id.combo3);

        mCombo1.setOnClickListener(this);
        mCombo2.setOnClickListener(this);
        mCombo3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Fragment fragment = null;

        switch (view.getId()){
            case R.id.combo1:
                fragment = new Combo1Fragment();
                break;
            case R.id.combo2:
                fragment = new Combo2Fragment();
                break;
            case R.id.combo3:
                fragment = new Combo3Fragment();
                break;
        }

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.contenedor_combos, fragment);
        transaction.commit();

    }
}
