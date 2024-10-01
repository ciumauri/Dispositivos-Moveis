package com.example.exbd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ParMoedaAdapter extends RecyclerView.Adapter<ParMoedaAdapter.ParMoedaViewHolder> {
    private List<ParMoeda> ParMoedas = new ArrayList<>();
    private OnItemClickListener listener;
    private Context context;


    public interface OnItemClickListener {
        void onItemClick(ParMoeda ParMoeda);
    }

    public ParMoedaAdapter(Context context) {
        this.context = context;
    }

    public void setParMoedas(List<ParMoeda> ParMoedas) {
        this.ParMoedas.clear();
        this.ParMoedas.addAll(ParMoedas);
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public ParMoedaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ParMoeda, parent, false);
        return new ParMoedaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ParMoedaViewHolder holder, int position) {
        ParMoeda ParMoeda = ParMoedas.get(position);
        holder.textCodigo.setText("Código: " + ParMoeda.getCodigo());
        holder.textDescricao.setText("Descrição: " + ParMoeda.getDescricao());
        holder.textValor.setText(String.format("Valor: R$ %.2f", ParMoeda.getValor()));

        // Clique no item para editar
        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(ParMoeda);
            }
        });

        // Clique no botão de deletar
        holder.btnDelete.setOnClickListener(v -> {
            // Exibir um diálogo de confirmação
            new AlertDialog.Builder(context)
                    .setTitle("Excluir ParMoeda")
                    .setMessage("Tem certeza que deseja excluir este ParMoeda?")
                    .setPositiveButton("Sim", (dialog, which) -> {
                        if (context instanceof MainActivity) {
                            ((MainActivity) context).deletarParMoeda(ParMoeda);
                        }
                    })
                    .setNegativeButton("Não", null)
                    .show();
        });
    }

    @Override
    public int getItemCount() {
        return ParMoedas != null ? ParMoedas.size() : 0;
    }

    public static class ParMoedaViewHolder extends RecyclerView.ViewHolder {
        TextView textCodigo, textDescricao, textValor;
        ImageButton btnDelete;

        public ParMoedaViewHolder(View itemView) {
            super(itemView);
            textCodigo = itemView.findViewById(R.id.textCodigo);
            textDescricao = itemView.findViewById(R.id.textDescricao);
            textValor = itemView.findViewById(R.id.textValor);
            btnDelete = itemView.findViewById(R.id.btnDelete);
        }
    }
}
