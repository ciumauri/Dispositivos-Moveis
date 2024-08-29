package com.example.exercicio_lista_cripto;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CriptoAdapter extends RecyclerView.Adapter<CriptoAdapter.ViewHolder>
{
    private List<Criptos> localDataSet;

    public CriptoAdapter(List<Criptos> dataSet){
        localDataSet = dataSet;
    }

    @NonNull
    @Override
    public CriptoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cripto_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CriptoAdapter.ViewHolder holder, int position) {
        Criptos criptos = localDataSet.get(position);
        holder.getTextViewName().setText(criptos.name);
        holder.getTextViewCode().setText(criptos.cod);
        holder.getImageView().setImageResource(criptos.img);
    }

    @Override
    public int getItemCount(){
        return localDataSet.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewName;
        private final TextView textViewCode;
        private final ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = (TextView) itemView.findViewById(R.id.txtName);
            textViewCode = (TextView) itemView.findViewById(R.id.txtCode);
            imageView = (ImageView) itemView.findViewById(R.id.imgCripto);
        }

        public TextView getTextViewName() {
            return textViewName;
        }

        public TextView getTextViewCode() {
            return textViewCode;
        }

        public ImageView getImageView() {
            return imageView;
        }

    }
}
