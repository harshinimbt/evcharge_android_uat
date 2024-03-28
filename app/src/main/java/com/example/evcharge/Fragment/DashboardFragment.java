package com.example.evcharge.Fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.evcharge.R;

public class DashboardFragment extends Fragment implements View.OnClickListener {
    View view;
    ImageButton ivProfile;
    ImageButton ibSavedStations,ibReachableArea,ibRecentRecharges,ibSocialMedia;
    AppCompatButton btnLocate;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        ibSavedStations = view.findViewById(R.id.ibSavedStations);
        ibSavedStations.setOnClickListener(this);
        ibReachableArea = view.findViewById(R.id.ibReachableArea);
        ibReachableArea.setOnClickListener(this);
        ibRecentRecharges = view.findViewById(R.id.ibRecentRecharges);
        ibRecentRecharges.setOnClickListener(this);
        ibSocialMedia = view.findViewById(R.id.ibSocialMedia);
        ibSocialMedia.setOnClickListener(this);
        ivProfile = view.findViewById(R.id.ivProfile);
        ivProfile.setOnClickListener(this);
        btnLocate = view.findViewById(R.id.btnLocate);
        btnLocate.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnLocate:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new NearbyStationFragment()).commit();
                break;
            case R.id.ibSavedStations:

                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new SavedEVStationFragment()).commit();
                break;
            case R.id.ibReachableArea:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new ReachableAreaFragment()).commit();
                break;
            case R.id.ibRecentRecharges:

                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new RecentRechargeFragment()).commit();
                break;
            case R.id.ibSocialMedia:

                break;
            case R.id.ivProfile:

                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new AccountFragment()).commit();
                break;
        }
    }
}