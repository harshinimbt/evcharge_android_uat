package com.example.evcharge.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.evcharge.Model.RecentRecharge;
import com.example.evcharge.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class RecentRechargeAdapter extends RecyclerView.Adapter<RecentRechargeAdapter.ViewHolder> {
    Context context;
    ArrayList<RecentRecharge> recentRecharge = new ArrayList<>();
    public RecentRechargeAdapter(Context context, ArrayList<RecentRecharge> recentRecharge) {
        this.context = context;
        this.recentRecharge = recentRecharge;
    }

    @NonNull
    @Override
    public RecentRechargeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);
        View Photoview=inflater.inflate(R.layout.recent_recharge_item,parent,false);
        RecentRechargeAdapter.ViewHolder viewHolder = new ViewHolder(Photoview);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecentRechargeAdapter.ViewHolder holder, int position) {
        holder.tvDate.setText(recentRecharge.get(position).getDate());
        holder.tvStationName.setText(recentRecharge.get(position).getStationName());
        holder.tvAddress.setText(recentRecharge.get(position).getAddress());
        holder.tvPrice.setText(recentRecharge.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return recentRecharge.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvDate,tvStationName,tvAddress,tvPrice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDate = itemView.findViewById(R.id.tvDate);
            tvStationName = itemView.findViewById(R.id.tvStationName);
            tvAddress = itemView.findViewById(R.id.tvAddress);
            tvPrice = itemView.findViewById(R.id.tvPrice);
        }
    }
}
