package com.example.evcharge.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.evcharge.Fragment.DetailNearbyStationFragment;
import com.example.evcharge.Model.NearbyStation;
import com.example.evcharge.R;

import java.util.ArrayList;

public class NearbyStationAdapter extends RecyclerView.Adapter<NearbyStationAdapter.ViewHolder> {
    Context context;
    ArrayList<NearbyStation> nearbyStation;
    public NearbyStationAdapter(Context context, ArrayList<NearbyStation> nearbyStation) {
        this.context = context;
        this.nearbyStation = nearbyStation;
    }

    @NonNull
    @Override
    public NearbyStationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context=parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);
        View Photoview=inflater.inflate(R.layout.nearby_station_item,parent,false);
        NearbyStationAdapter.ViewHolder viewHolder = new ViewHolder(Photoview);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NearbyStationAdapter.ViewHolder holder, int position) {
     holder.tvStationName.setText(nearbyStation.get(position).getStationName());
     holder.tvAddress.setText(nearbyStation.get(position).getAddress());
     holder.tvKms.setText(nearbyStation.get(position).getKms());
     holder.llNearbyStation.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             AppCompatActivity activity = (AppCompatActivity) view.getContext();
             activity.getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new DetailNearbyStationFragment()).commit();
         }
     });
     holder.ibUnsaved.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             holder.ibUnsaved.setVisibility(View.GONE);
             holder.ibSaved.setVisibility(View.VISIBLE);
         }
     });
     holder.ibSaved.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             holder.ibUnsaved.setVisibility(View.VISIBLE);
             holder.ibSaved.setVisibility(View.GONE);
         }
     });
    }


    @Override
    public int getItemCount() {
        return nearbyStation.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvStationName,tvAddress,tvKms;
        ImageButton ibUnsaved,ibSaved;
        LinearLayout llNearbyStation;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvStationName = itemView.findViewById(R.id.tvStationName);
            tvAddress = itemView.findViewById(R.id.tvAddress);
            tvKms = itemView.findViewById(R.id.tvKms);
            llNearbyStation = itemView.findViewById(R.id.llNearbyStation);
            ibUnsaved = itemView.findViewById(R.id.ibUnsaved);
            ibSaved = itemView.findViewById(R.id.ibSaved);
        }
    }
}
