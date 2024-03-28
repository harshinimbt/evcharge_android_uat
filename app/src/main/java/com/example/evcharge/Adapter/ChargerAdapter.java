package com.example.evcharge.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.evcharge.Model.Chargers;
import com.example.evcharge.R;
import java.util.ArrayList;

public class ChargerAdapter extends RecyclerView.Adapter<ChargerAdapter.ViewHolder> {
    ArrayList<Chargers> chargers;
    Context context;
    public ChargerAdapter(Context context, ArrayList<Chargers> chargers) {
        this.chargers = chargers;
        this.context = context;
    }

    @NonNull
    @Override
    public ChargerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);
        View Photoview=inflater.inflate(R.layout.charger_item,parent,false);
        ChargerAdapter.ViewHolder viewHolder = new ChargerAdapter.ViewHolder(Photoview);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ChargerAdapter.ViewHolder holder, int position) {
      holder.tvConnectorType.setText(chargers.get(position).getConnectorType());
      holder.tvType.setText(chargers.get(position).getType());
      holder.tvPrice.setText(chargers.get(position).getPrice());
      holder.tvKw.setText(chargers.get(position).getKw());
      holder.tvAvailability.setText(chargers.get(position).getAvailability());
    }
    @Override
    public int getItemCount() {
        return chargers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvConnectorType,tvType,tvPrice,tvKw,tvAvailability;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvConnectorType = itemView.findViewById(R.id.tvConnectorType);
            tvType = itemView.findViewById(R.id.tvType);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            tvKw = itemView.findViewById(R.id.tvKw);
            tvAvailability = itemView.findViewById(R.id.tvAvailability);


        }
    }
}
