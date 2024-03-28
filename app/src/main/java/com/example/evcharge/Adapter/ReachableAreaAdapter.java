package com.example.evcharge.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.evcharge.Model.ReachableArea;
import com.example.evcharge.R;

import java.util.ArrayList;

public class ReachableAreaAdapter extends RecyclerView.Adapter<ReachableAreaAdapter.ViewHolder> {
    Context context;
    ArrayList<ReachableArea> reachableArea;

    public ReachableAreaAdapter(Context context, ArrayList<ReachableArea> reachableArea) {
        this.context = context;
        this.reachableArea = reachableArea;
    }

    @NonNull
    @Override
    public ReachableAreaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context=parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);
        View Photoview=inflater.inflate(R.layout.reachable_area_item,parent,false);
        ReachableAreaAdapter.ViewHolder viewHolder = new ReachableAreaAdapter.ViewHolder(Photoview);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ReachableAreaAdapter.ViewHolder holder, int position) {
        holder.tvPlace.setText(reachableArea.get(position).getPlace());
        holder.tvDirection.setText(reachableArea.get(position).getDirection());
        holder.tvKms.setText(reachableArea.get(position).getKm());
    }


    @Override
    public int getItemCount() {
        return reachableArea.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvPlace,tvDirection,tvKms;
        public ViewHolder(View itemView) {
            super(itemView);
            tvPlace = itemView.findViewById(R.id.tvPlace);
            tvDirection = itemView.findViewById(R.id.tvDirection);
            tvKms = itemView.findViewById(R.id.tvKms);
        }
    }
}
