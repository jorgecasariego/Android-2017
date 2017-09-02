package jorgecasariego.materialdesign.util;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import jorgecasariego.materialdesign.R;

public class AvisaPersonalizadoDialog extends Activity {

    Button cerrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avisa_personalizado_dialog);

        cerrar = (Button) findViewById(R.id.cerrar);
        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
