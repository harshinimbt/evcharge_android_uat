package com.example.evcharge.Fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.evcharge.Activity.AddVehicleActivity;
import com.example.evcharge.R;

public class VehicleFragment extends Fragment implements View.OnClickListener {
    View view;
    ImageButton ibAdd,ibBack;
    public ImageView ivHome;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_vehicle_profile, container, false);
        ibAdd = view.findViewById(R.id.ibAdd);
        ibAdd.setOnClickListener(this);
        ibBack = view.findViewById(R.id.ibBack);
        ibBack.setOnClickListener(this);
//        ivHome = view.findViewById(R.id.ivHome);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ibAdd:
                startActivity(new Intent(getActivity(), AddVehicleActivity.class));
                break;
            case R.id.ibBack:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new DashboardFragment()).commit();
//                ivHome.setBackgroundTintList(ContextCompat.getColorStateList(getActivity(),R.color.green));
                break;
        }
    }
}