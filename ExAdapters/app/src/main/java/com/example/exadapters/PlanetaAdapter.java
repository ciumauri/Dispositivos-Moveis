package com.example.exadapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PlanetaAdapter extends RecyclerView.Adapter<PlanetaAdapter.ViewHolder> {
    private List<Planeta> localDataSet;

    public PlanetaAdapter(List<Planeta> dataSet){
        localDataSet = dataSet;
    }

    @NonNull
    @Override
    public PlanetaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.text_row_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanetaAdapter.ViewHolder holder, int position) {
        Planeta planeta = localDataSet.get(position);
        holder.getTextView().setText(planeta.name);
        holder.getImageView().setImageResource(planeta.img);
    }

    @Override
    public int getItemCount(){
        return localDataSet.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;
        private final ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.txtPlaneta);
            imageView = (ImageView) itemView.findViewById(R.id.imgPlaneta);
        }

        public TextView getTextView() {
            return textView;
        }

        public ImageView getImageView() {
            return imageView;
        }

    }
}
