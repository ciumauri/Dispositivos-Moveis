package com.example.processosethreads;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.processosethreads.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        binding.btnProcessar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //binding.txtStatus.setText(R.string.processando);
        binding.btnProcessar.setEnabled(false);
        binding.pgbProcessando.setVisibility(View.VISIBLE);
        binding.pgbProcessando.setMax(15);
        binding.pgbProcessando.setProgress(0);
        executeProcess();
    }

    private void executeProcess() {
        new Thread(new Runnable() {
            int progress = 0;

            @Override
            public void run() {
               // código que deve ser executado em segundo plano
                while(progress < binding.pgbProcessando.getMax()){
                    SystemClock.sleep(1000);
                    progress++;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            // código que atualiza a barra de progresso
                            binding.pgbProcessando.setProgress(progress);
                        }
                    });
                }

                SystemClock.sleep(15000);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // código que atualiza a interface gráfica
                        binding.pgbProcessando.setVisibility(View.INVISIBLE);
                        binding.btnProcessar.setEnabled(true);
                        binding.txtStatus.setText(R.string.finalizado);
                    }
                });
            }
        }).start();
    }

}