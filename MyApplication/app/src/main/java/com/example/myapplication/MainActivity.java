package com.example.myapplication.;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnLimpar.setOnClickListener(this);
        binding.btnExibir.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnLimpar){
            //Toast.makeText(this,"Limpar",Toast.LENGTH_SHORT).show();
            binding.edtNome.setText("");
            binding.edtEmail.setText("");
            binding.edtTelefone.setText("");
            binding.swtWhats.setChecked(false);
            binding.rdgPeriodo.clearCheck();
            binding.chkInternet.setChecked(false);
            binding.chkStreaming.setChecked(false);
            binding.chkTelefone.setChecked(false);
            binding.chkTv.setChecked(false);
        }
        else if (view.getId() == R.id.btnExibir){
            //Toast.makeText(this,"Exibir",Toast.LENGTH_LONG).show();
            binding.lblDados.setVisibility(View.VISIBLE);
            binding.txtNome.setText("Nome: "
                    + binding.edtNome.getText().toString());
            binding.txtEmail.setText("E-mail: "
                    + binding.edtEmail.getText().toString());
            binding.txtTelefone.setText("Telefone: "
                    + binding.edtTelefone.getText().toString());


        }
    }
}