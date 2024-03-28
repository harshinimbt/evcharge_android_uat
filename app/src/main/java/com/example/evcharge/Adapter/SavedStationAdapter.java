package com.example.evcharge.Adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.evcharge.Model.SavedStation;
import com.example.evcharge.R;

import java.util.ArrayList;
public class SavedStationAdapter extends RecyclerView.Adapter<SavedStationAdapter.ViewHolder> {
    Context context;
    ArrayList<SavedStation> savedStation ;
    public SavedStationAdapter(Context context, ArrayList<SavedStation> savedStation) {
        this.context = context;
        this.savedStation = savedStation;
    }

    @NonNull
    @Override
    public SavedStationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context=parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);
        View Photoview=inflater.inflate(R.layout.saved_station_item,parent,false);
        SavedStationAdapter.ViewHolder viewHolder = new ViewHolder(Photoview);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SavedStationAdapter.ViewHolder holder, int position) {
        holder.tvStationName.setText(savedStation.get(position).getStationName());
        holder.tvAddress.setText(savedStation.get(position).getAddress());
        holder.ibSaved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.ibSaved.setVisibility(View.GONE);
                holder.ibUnsaved.setVisibility(View.VISIBLE);
            }
        });
        holder.ibUnsaved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.ibSaved.setVisibility(View.VISIBLE);
                holder.ibUnsaved.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return savedStation.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvStationName,tvAddress;
        ImageButton ibSaved,ibUnsaved;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvStationName = itemView.findViewById(R.id.tvStationName);
            tvAddress = itemView.findViewById(R.id.tvAddress);
            ibSaved = itemView.findViewById(R.id.ibSaved);
            ibUnsaved = itemView.findViewById(R.id.ibUnsaved);
        }
    }
}
