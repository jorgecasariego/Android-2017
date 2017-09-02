package jorgecasariego.materialdesign.util;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.text.format.DateFormat;

import java.util.Calendar;

/**
 * Created by jorgecasariego on 2/9/17.
 */

public class TimePickerFragment extends DialogFragment{

    Context context;
    TimePickerDialog.OnTimeSetListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        this.context = context;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar calendario = Calendar.getInstance();

        int hora = calendario.get(Calendar.HOUR_OF_DAY);
        int minuto = calendario.get(Calendar.MINUTE);

        //Creamos una nueva instancia de TimePicker y retornamos
        return new TimePickerDialog(context, (TimePickerDialog.OnTimeSetListener) getTargetFragment(),
                hora, minuto, DateFormat.is24HourFormat(context));
    }
}
