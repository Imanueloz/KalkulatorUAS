package com.example.kalkulatoruas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterHasil extends RecyclerView.Adapter<AdapterHasil.ViewHolder> {

    private ArrayList<itemhasil> listhasil;

    public AdapterHasil(){
        this.listhasil = this.listhasil;
    }

    @NonNull
    @Override
    public AdapterHasil.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        return new ViewHolder(inflater.inflate(R.layout.listhasil, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterHasil.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return listhasil.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView txthasil1, txthasil2, txthasil3, txthasil4, txthasil5, txthasil6;

        public ViewHolder(View itemview){
            super(itemview);

            txthasil1 = itemview.findViewById(R.id.txthasil1);
            txthasil2 = itemview.findViewById(R.id.txthasil2);
            txthasil3 = itemview.findViewById(R.id.txthasil3);
            txthasil4 = itemview.findViewById(R.id.txthasil4);
            txthasil5 = itemview.findViewById(R.id.txthasil5);
            txthasil6 = itemview.findViewById(R.id.txthasil6);
        }
    }
}
