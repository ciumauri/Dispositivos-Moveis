package com.example.exbd;

import android.content.Intent;
import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.exbd.databinding.ActivityMainBinding;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity implements ParMoedaAdapter.OnItemClickListener {

    private AppDatabase db;
    private ParMoedaAdapter ParMoedaAdapter;
    private ExecutorService executorService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Inicializar a base de dados
        db = AppDatabase.getDatabase(getApplicationContext());

        // Inicializar o ExecutorService
        executorService = Executors.newSingleThreadExecutor();

        // Configurar o RecyclerView e o Adapter
        binding.recyclerViewParMoedas.setLayoutManager(new LinearLayoutManager(this));
        ParMoedaAdapter = new ParMoedaAdapter(this);
        ParMoedaAdapter.setOnItemClickListener(this); // Configurar o listener
        binding.recyclerViewParMoedas.setAdapter(ParMoedaAdapter);

        // Observar as mudanças na lista de ParMoedas
        db.ParMoedaDao().listar().observe(this, new Observer<List<ParMoeda>>() {
            @Override
            public void onChanged(List<ParMoeda> ParMoedas) {
                ParMoedaAdapter.setParMoedas(ParMoedas);
            }
        });


        // Configurar o FloatingActionButton
        binding.fabAdicionar.setOnClickListener(v -> {
            // Navegar para a atividade de adicionar ParMoeda
            Intent intent = new Intent(MainActivity.this, AddParMoedaActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public void onItemClick(ParMoeda ParMoeda) {
        // Navegar para a atividade de edição de ParMoeda
        Intent intent = new Intent(MainActivity.this, EditParMoedaActivity.class);
        intent.putExtra("ParMoeda_id", ParMoeda.getId());
        startActivity(intent);
    }

    public void deletarParMoeda(ParMoeda ParMoeda) {
        executorService.execute(() -> {
            db.ParMoedaDao().deletar(ParMoeda);
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        executorService.shutdown();
    }
}