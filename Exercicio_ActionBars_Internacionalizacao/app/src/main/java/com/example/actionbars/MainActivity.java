package com.example.actionbars;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_add){
            Toast.makeText(this, R.string.action_add_label, Toast.LENGTH_SHORT).show();
        }
        else if (item.getItemId() == R.id.action_edit){
            Toast.makeText(this, R.string.action_edit_label, Toast.LENGTH_SHORT).show();
        }
        else if (item.getItemId() == R.id.action_delete){
            Toast.makeText(this, R.string.action_delete_label, Toast.LENGTH_SHORT).show();
        }
        else if (item.getItemId() == R.id.action_help){
            Toast.makeText(this, R.string.action_help, Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

}