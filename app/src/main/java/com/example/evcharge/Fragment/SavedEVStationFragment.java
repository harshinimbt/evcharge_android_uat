package com.example.evcharge.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.evcharge.Adapter.SavedStationAdapter;
import com.example.evcharge.Model.SavedStation;
import com.example.evcharge.R;

import java.util.ArrayList;

public class SavedEVStationFragment extends Fragment implements View.OnClickListener {
    ImageButton  ibBack;
    View view;
    TextView tvClearAll;
    RecyclerView rvSavedStation;
    ArrayList<SavedStation> savedStation = new ArrayList<>();
    SavedStationAdapter savedStationAdapter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_saved_ev_stations, container, false);
        ibBack = view.findViewById(R.id.ibBack);
        ibBack.setOnClickListener(this);
        tvClearAll = view.findViewById(R.id.tvClearAll);
        tvClearAll.setOnClickListener(this);
        rvSavedStation = view.findViewById(R.id.rvSavedStation);

        savedStation.add(new SavedStation("Brigade Gardenia JP Nagar","#3, 17th Main, 5th Block, Koramangala"));
        savedStation.add(new SavedStation("Kubera TVS","#3, 17th Main, 5th Block, Koramangala"));
        SavedStationAdapter savedStationAdapter  = new SavedStationAdapter(getActivity(),savedStation);
        rvSavedStation.setHasFixedSize(true);
        rvSavedStation.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvSavedStation.setAdapter(savedStationAdapter);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ibBack:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new DashboardFragment()).commit();
                break;
            case R.id.tvClearAll:
                savedStation.clear();
                rvSavedStation.setAdapter(savedStationAdapter);
                break;
        }
    }
}
