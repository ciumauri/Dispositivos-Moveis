package com.example.exbd;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.exbd.databinding.ActivityAddParMoedaBinding;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AddParMoedaActivity extends AppCompatActivity {

    private AppDatabase db;
    private ExecutorService executorService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        ActivityAddParMoedaBinding binding = ActivityAddParMoedaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Inicializar a base de dados
        db = AppDatabase.getDatabase(getApplicationContext());


        // Inicializar o ExecutorService
        executorService = Executors.newSingleThreadExecutor();


       binding.btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String codigo = binding.editCodigo.getText().toString();
                final String descricao = binding.editDescricao.getText().toString();
                final double valor;

                try {
                    valor = Double.parseDouble(binding.editValor.getText().toString());
                } catch (NumberFormatException e) {
                    Toast.makeText(AddParMoedaActivity.this, "Valor inválido!", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Executar a inserção em background
                executorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        db.ParMoedaDao().inserir(new ParMoeda(codigo, descricao, valor));

                        // Retornar à thread principal para atualizar a UI
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(AddParMoedaActivity.this, "ParMoeda salvo!", Toast.LENGTH_SHORT).show();
                                finish(); // Volta para a MainActivity
                            }
                        });
                    }
                });

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        executorService.shutdown();
    }
}