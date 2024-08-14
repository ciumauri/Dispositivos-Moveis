package com.example.contextmenu;

import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.contextmenu.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements ActionMode.Callback, View.OnLongClickListener {

    private ActivityMainBinding binding;
    private boolean actionModeActive = false;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.txtContador.setText("0");
        binding.txtContador.setOnLongClickListener(this);
    }

    @Override
    public boolean onLongClick(View v) {
        if(!actionModeActive){
            startActionMode(this);
            actionModeActive = true;
        }
        return true;
    }

    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        getMenuInflater().inflate(R.menu.context_menu, menu);
        return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        return true;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        if(item.getItemId() == R.id.action_ant){
            count--;
            binding.txtContador.setText(String.valueOf(count));
            mode.finish();
        }
        else if(item.getItemId() == R.id.action_next){
            count++;
            binding.txtContador.setText(String.valueOf(count));
            mode.finish();
        }
        return true;
    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {
        actionModeActive = false;
    }
}