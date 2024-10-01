package com.example.exbd;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.exbd.databinding.ActivityAddParMoedaBinding;
import com.example.exbd.databinding.ActivityEditParMoedaBinding;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EditParMoedaActivity extends AppCompatActivity {

    private AppDatabase db;
    private ExecutorService executorService;
    private ParMoeda ParMoeda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        ActivityEditParMoedaBinding binding = ActivityEditParMoedaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obter a instância Singleton do banco de dados
        db = AppDatabase.getDatabase(getApplicationContext());

        executorService = Executors.newSingleThreadExecutor();

        // Obter o ID do ParMoeda a partir da Intent
        int ParMoedaId = getIntent().getIntExtra("ParMoeda_id", -1);

        if (ParMoedaId != -1) {
            // Carregar o ParMoeda do banco de dados
            executorService.execute(() -> {
                ParMoeda = db.ParMoedaDao().SelectId(ParMoedaId);
                runOnUiThread(() -> {
                    if (ParMoeda != null) {
                        // Preencher os campos com os dados do ParMoeda
                        binding.editCodigo.setText(ParMoeda.getCodigo());
                        binding.editDescricao.setText(ParMoeda.getDescricao());
                        binding.editValor.setText(String.valueOf(ParMoeda.getValor()));
                    }
                });
            });
        }

        binding.btnAtualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String codigo = binding.editCodigo.getText().toString();
                final String descricao = binding.editDescricao.getText().toString();
                final double valor;

                try {
                    valor = Double.parseDouble(binding.editValor.getText().toString());
                } catch (NumberFormatException e) {
                    Toast.makeText(EditParMoedaActivity.this, "Valor inválido!", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Atualizar o ParMoeda
                executorService.execute(() -> {
                    ParMoeda.setCodigo(codigo);
                    ParMoeda.setDescricao(descricao);
                    ParMoeda.setValor(valor);
                    db.ParMoedaDao().atualizar(ParMoeda);

                    // Voltar à thread principal para atualizar a UI
                    runOnUiThread(() -> {
                        Toast.makeText(EditParMoedaActivity.this, "ParMoeda atualizado!", Toast.LENGTH_SHORT).show();
                        finish();
                    });
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