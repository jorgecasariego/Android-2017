package jorgecasariego.materialdesign.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import jorgecasariego.materialdesign.R;

public class NoticiasActivity extends AppCompatActivity {

    Button cambiarDiario;
    WebView webView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticias);

        toolbar = (Toolbar) findViewById(R.id.my_toolbar_noticias);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Noticias");

        cambiarDiario = (Button) findViewById(R.id.cambiar_diario);
        webView = (WebView) findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);

        //Si abrimos una página Web en una vista WebView y hacemos clic sobre alguno de sus enlaces,
        //éste se abrirá en el navegador Web de nuestro dispositivo en vez de abrir la página en el WebView.
        //Este comportamiento puede sobrescribirse, permitiendo al usuario moverse hacia adelante
        //y atrás a través del historial almacenado en el WebView.
        //Para sobrescribir dicho comportamiento debemos de definir un WebViewClient
        webView.setWebViewClient(new WebViewClient());


        // 2. registramos el context menu
        registerForContextMenu(cambiarDiario);
    }

    //1. Creamos el context Menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.menu_diarios, menu);
        menu.setHeaderTitle("Seleccionar diario");
    }

    // 3. Manejamos el click del context menu

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.ultima_hora:
                webView.loadUrl("http://www.ultimahora.com");
                break;
            case R.id.abc:
                webView.loadUrl("http://www.abc.com.py");
                break;

            case R.id.la_nacion:
                webView.loadUrl("http://www.lanacion.com.py");
                break;

        }

        return super.onContextItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack();
        } else {
            super.onBackPressed();
        }

    }
}
