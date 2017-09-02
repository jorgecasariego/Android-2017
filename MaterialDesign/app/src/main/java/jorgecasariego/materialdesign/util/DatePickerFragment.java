package jorgecasariego.materialdesign.util;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

import java.util.Calendar;

/**
 * Created by jorgecasariego on 2/9/17.
 */

public class DatePickerFragment extends DialogFragment {

    Context context;
    DatePickerDialog.OnDateSetListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        //Obtenemos la instancia  del calendario
        Calendar calendario = Calendar.getInstance();

        int year = calendario.get(Calendar.YEAR);
        int month = calendario.get(Calendar.MONTH);
        int day = calendario.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(context, (DatePickerDialog.OnDateSetListener) getTargetFragment(), year, month, day);
    }

}
