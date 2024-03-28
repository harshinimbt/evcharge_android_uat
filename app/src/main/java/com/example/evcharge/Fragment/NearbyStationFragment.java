package com.example.evcharge.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.evcharge.Adapter.NearbyStationAdapter;
import com.example.evcharge.Model.NearbyStation;
import com.example.evcharge.R;

import java.util.ArrayList;

public class NearbyStationFragment extends Fragment implements View.OnClickListener {
    View view;
    ImageButton ibBack;

    RecyclerView rvNearbyStation;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_nearby_ev_stations, container, false);
        ibBack = view.findViewById(R.id.ibBack);
        ibBack.setOnClickListener(this);
        rvNearbyStation = view.findViewById(R.id.rvNearbyStation);
        ArrayList<NearbyStation> nearbyStation = new ArrayList<>();
        nearbyStation.add(new NearbyStation("Tanishq, Koramangala","#3, 17th Main, 5th Block, Koramangala","3.83 kms away"));
        nearbyStation.add(new NearbyStation("TBrigade Millenium","#3, 17th Main, 5th Block, Koramangala","3.90 kms away"));
        NearbyStationAdapter nearbyStationAdapter =  new NearbyStationAdapter(getActivity(),nearbyStation);
        rvNearbyStation.hasFixedSize();
        rvNearbyStation.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvNearbyStation.setAdapter(nearbyStationAdapter);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ibBack:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new DashboardFragment()).commit();
                break;

        }
    }
}
