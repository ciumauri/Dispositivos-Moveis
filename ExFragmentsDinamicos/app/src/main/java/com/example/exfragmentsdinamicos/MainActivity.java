package com.example.exfragmentsdinamicos;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FragmentManager fm;
    private FragmentTransaction ft;
    private UpFragment up;
    private DownFragment down;

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

        Button btnFrag1 = findViewById(R.id.btnFrag1);
        Button btnFrag2 = findViewById(R.id.btnFrag2);

        btnFrag1.setOnClickListener(this);
        btnFrag2.setOnClickListener(this);

        fm = getSupportFragmentManager();
        up = new UpFragment();
        down = new DownFragment();

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnFrag1) {
            ft = fm.beginTransaction();
            ft.setReorderingAllowed(true);
            ft.replace(R.id.fragment1, up, "Up");
            ft.commit();
        } else if (v.getId() == R.id.btnFrag2) {
            ft = fm.beginTransaction();
            ft.setReorderingAllowed(true);
            ft.replace(R.id.fragment2, down, "Down");
            ft.commit();
        }
    }
}