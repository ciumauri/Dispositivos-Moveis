package com.example.exdialogs;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class MyTimePickerDialog extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return new TimePickerDialog(getActivity(), this,
                21,30, true);
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
        String msg = String.format("%02d:%02d", i, i1);
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }
}
