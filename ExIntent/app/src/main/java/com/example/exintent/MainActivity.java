package com.example.exintent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.exintent.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String[] items = getResources().getStringArray(R.array.acoes);
        binding.lista.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items));
        binding.lista.setOnItemClickListener(this);


        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent;
        Uri uri;

        switch (position) {
            // Camera Foto
            case 0:
                intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent);
                break;
            // Camera Video
            case 1:
                intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                startActivity(intent);
                break;
            // Visualizar Todos os Contatos
            case 2:
                uri = Uri.parse("content://com.android.contacts/contacts");
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
            // Visualizar Contato 1
            case 3:
                uri = Uri.parse("content://com.android.contacts/contacts/1");
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
            // Selecionar Contato
            case 4:
                uri = Uri.parse("content://com.android.contacts/contacts");
                intent = new Intent(Intent.ACTION_PICK, uri);
                startActivity(intent);
                break;
            // Compartilhar
            case 5:
                intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, "Compartilhar");
                intent.putExtra(Intent.EXTRA_TEXT, "Mensagem");
                startActivity(intent);
                break;
            // Enviar SMS
            case 6:
                uri = Uri.parse("sms:12345");
                intent = new Intent(Intent.ACTION_SENDTO, uri);
                intent.putExtra("sms_body", "Mensagem");
                startActivity(intent);
                break;
            // Discar para Telefone
            case 7:
                uri = Uri.parse("tel:12345");
                intent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intent);
                break;
        }
    }
}