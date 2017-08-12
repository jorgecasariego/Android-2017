package jorgecasariego.ejerciciointents;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class DiaDeLaAmistadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dia_de_la_amistad);
    }

    public void onClick(View view){
        startActivity(new Intent(this, MainActivity.class));
    }
}
