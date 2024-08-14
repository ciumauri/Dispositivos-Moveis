package com.example.expmenus;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.expmenus.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets insets1 = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(insets1.left, insets1.top, insets1.right, insets1.bottom);
            return insets;
        });

        setSupportActionBar(binding.myToolbar);
        binding.imageButton.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_lef) {
            startActivity(new Intent(this, Tela1Activity.class));
        }
        else if (item.getItemId() == R.id.action_right) {
            startActivity(new Intent(this, Tela2Activity.class));
        }
        else if (item.getItemId() == R.id.action_settings) {
            Toast.makeText(this, R.string.action_settings, Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
            PopupMenu popupMenu = new PopupMenu(this, v);
            popupMenu.inflate(R.menu.popup);
            popupMenu.setOnMenuItemClickListener(this);

            popupMenu.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        if(item.getItemId() == R.id.action_edit){
            Toast.makeText(this, R.string.edit, Toast.LENGTH_SHORT).show();
            return true;
        }
        else if(item.getItemId() == R.id.action_delete){
            Toast.makeText(this, R.string.delete, Toast.LENGTH_SHORT).show();
            return true;
        }
        else{
            return false;
        }
    }
}