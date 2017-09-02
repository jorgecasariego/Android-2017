package jorgecasariego.materialdesign.fragments;


import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TimePicker;

import jorgecasariego.materialdesign.R;
import jorgecasariego.materialdesign.util.DatePickerFragment;
import jorgecasariego.materialdesign.util.TimePickerFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment3 extends Fragment
        implements View.OnClickListener, DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    Context context;
    ProgressBar progressBar;
    Button obtenerDatos;
    Button elegirFecha;
    Button elegirHora;
    TextView fechaElegida;
    TextView horaElegida;

    public Fragment3() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment3, container, false);

        progressBar = view.findViewById(R.id.progress_bar);

        elegirFecha = view.findViewById(R.id.definir_fecha);
        elegirHora = view.findViewById(R.id.definir_hora);

        elegirFecha.setOnClickListener(this);
        elegirHora.setOnClickListener(this);

        fechaElegida = view.findViewById(R.id.fecha_elegida);
        horaElegida = view.findViewById(R.id.hora_elegida);

        obtenerDatos = view.findViewById(R.id.obtener_datos);
        obtenerDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                obtenerDatosServidor();
            }


        });

        return view;
    }

    /**
     Why we use handlers with thread :

     When we install an application in android then it create a thread  for that application
     called MAIN UI Thread, All activities run inside that thread , By the android single thread
     model rule we can not access UI elements (bitmap , textview etc..) directly for another thread
     defined inside that activity.

     So if want to access Main UI Thread elements by another thread then we will use  handlers.

     URL: http://androidexample.com/Thread_With_Handlers_-_Android_Example/index.php?view=article_discription&aid=58
     */
    private void obtenerDatosServidor() {
        progressBar.setVisibility(View.VISIBLE);

        final Handler handler = new Handler();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setVisibility(View.INVISIBLE);
                    }
                });
            }
        }).start();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.definir_fecha:
                definirFecha();
                break;
            case R.id.definir_hora:
                definirHora();
                break;
        }
    }

    private void definirFecha() {
        DatePickerFragment calendarioDialog = new DatePickerFragment();
        calendarioDialog.setTargetFragment(Fragment3.this, 1111);
        calendarioDialog.show(getFragmentManager(), "FechaElegida");
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        fechaElegida.setText("Fecha elegida:" + day + "/" + month + "/" + year);
    }

    private void definirHora() {
        TimePickerFragment horaMinuto  = new TimePickerFragment();
        horaMinuto.setTargetFragment(Fragment3.this, 222);
        horaMinuto.show(getFragmentManager(), "horaElegida");
    }


    @Override
    public void onTimeSet(TimePicker timePicker, int hora, int minuto) {
        horaElegida.setText("Hora elegida: " + hora + ":" + minuto);
    }
}
