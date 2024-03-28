package com.example.evcharge.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.evcharge.Adapter.ChargerAdapter;
import com.example.evcharge.Model.Chargers;
import com.example.evcharge.R;

import java.util.ArrayList;

public class DetailNearbyStationFragment extends Fragment implements View.OnClickListener {
    View view;
    RecyclerView rvChargers;
    ImageButton ibUpdateRecentRecharge,ibUnsaved,ibSaved;
    LinearLayout llChargers,llRecentRecharges,UpdateRecharges,ChargerBg,RecentRechargeBg;
    TextView tvSave;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_detail_nearby_station, container, false);
        rvChargers = view.findViewById(R.id.rvChargers);
        llChargers = view.findViewById(R.id.llChargers);
        llRecentRecharges = view.findViewById(R.id.llRecentRecharges);
        UpdateRecharges= view.findViewById(R.id.UpdateRecharges);
        ibUpdateRecentRecharge = view.findViewById(R.id.ibUpdateRecentRecharge);
        ibUnsaved = view.findViewById(R.id.ibUnsaved);
        ibSaved = view.findViewById(R.id.ibSaved);
        tvSave = view.findViewById(R.id.tvSave);
        ChargerBg = view.findViewById(R.id.ChargerBg);
        RecentRechargeBg = view.findViewById(R.id.RecentRechargeBg);
        tvSave.setOnClickListener(this);
        ibUnsaved.setOnClickListener(this);
        ibSaved.setOnClickListener(this);
        ibUpdateRecentRecharge.setOnClickListener(this);
        llChargers.setOnClickListener(this);
        llRecentRecharges.setOnClickListener(this);
        ArrayList<Chargers> chargers = new ArrayList<>();
        chargers.add(new Chargers("Connector Type 1","Socket  |  AC","15/unit","3.3 kW","Available"));
        chargers.add(new Chargers("Connector Type 2","Socket  |  AC","30/unit","5.5 kW","Available"));
        ChargerAdapter chargerAdapter = new ChargerAdapter(getActivity(),chargers);
        rvChargers.hasFixedSize();
        rvChargers.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvChargers.setAdapter(chargerAdapter);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.llChargers:
                rvChargers.setVisibility(View.VISIBLE);
                UpdateRecharges.setVisibility(View.GONE);
                ChargerBg.setBackground(getResources().getDrawable(R.drawable.line_green));
                RecentRechargeBg.setBackground(getResources().getDrawable(R.drawable.line));
                break;
            case R.id.llRecentRecharges:
                rvChargers.setVisibility(View.GONE);
                UpdateRecharges.setVisibility(View.VISIBLE);
                ChargerBg.setBackground(getResources().getDrawable(R.drawable.line));
                RecentRechargeBg.setBackground(getResources().getDrawable(R.drawable.line_green));
                break;
            case R.id.ibUpdateRecentRecharge:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new UpdateRecentRechargeFragment()).commit();
                break;
            case R.id.ibUnsaved:
                ibUnsaved.setVisibility(View.GONE);
                ibSaved.setVisibility(View.VISIBLE);
                break;
            case R.id.ibSaved:
                ibUnsaved.setVisibility(View.VISIBLE);
                ibSaved.setVisibility(View.GONE);
                break;

        }

    }
}
