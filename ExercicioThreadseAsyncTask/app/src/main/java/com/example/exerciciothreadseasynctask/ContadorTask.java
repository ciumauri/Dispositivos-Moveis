package com.example.exerciciothreadseasynctask;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.widget.Button;
import android.widget.TextView;

public class ContadorTask extends AsyncTask<Void, Integer, Void> {
    private Button btnIniciar;
    private TextView txtContador;

    public ContadorTask(Button btnIniciar, TextView txtContador) {
        this.btnIniciar = btnIniciar;
        this.txtContador = txtContador;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        btnIniciar.setEnabled(false); // Desabilita o botão ao iniciar
    }

    @Override
    protected Void doInBackground(Void... voids) {
        for (int i = 10; i >= 0; i--) {
            SystemClock.sleep(1000); // Pausa de 1 segundo
            publishProgress(i); // Atualiza o progresso
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        txtContador.setText(String.valueOf(values[0])); // Atualiza o TextView com o valor atual
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        btnIniciar.setEnabled(true); // Reabilita o botão após a conclusão
    }
}