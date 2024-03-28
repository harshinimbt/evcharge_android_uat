package com.example.evcharge.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.evcharge.Adapter.ReachableAreaAdapter;
import com.example.evcharge.Model.ReachableArea;
import com.example.evcharge.R;

import java.util.ArrayList;

public class ReachableAreaFragment extends Fragment {
    RecyclerView rvReachableArea;
    View view;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_reachable_area_new, container, false);
        rvReachableArea = view.findViewById(R.id.rvReachableArea);
        ArrayList<ReachableArea> reachableArea = new ArrayList<>();
        reachableArea.add(new ReachableArea("Yelahanka","Towards North","20 kms"));
        reachableArea.add(new ReachableArea("JP Nagar","Towards South","20 kms"));
        ReachableAreaAdapter reachableAreaAdapter = new ReachableAreaAdapter(getActivity(),reachableArea);
        rvReachableArea.hasFixedSize();
        rvReachableArea.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvReachableArea.setAdapter(reachableAreaAdapter);
        return view;
    }
}