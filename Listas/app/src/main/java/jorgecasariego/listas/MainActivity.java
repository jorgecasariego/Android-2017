package jorgecasariego.listas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    String [] elementos = new String[] {
            "Elemento 1",
            "Elemento 2",
            "Elemento 3",
            "Elemento 4",
            "Elemento 5"
    };

    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, elementos);


        lista = (ListView) findViewById(R.id.list);
        lista.setAdapter(adapter);
    }
}
