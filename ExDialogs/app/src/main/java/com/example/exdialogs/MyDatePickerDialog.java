package com.example.exdialogs;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Locale;

public class MyDatePickerDialog extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return new DatePickerDialog(getActivity(), this,
                2024, 7, 30);
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        String msg = String.format(new Locale("pt","BR"),
                "%02d/%02d/%d", i2, i1+1, i);
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }
}
