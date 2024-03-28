package com.example.evcharge.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import com.example.evcharge.R;

public class UpdateRecentRechargeFragment extends Fragment implements View.OnClickListener {
    View view;
    ImageButton ibBack;
    AppCompatButton btnCancel,btnConfirm;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_update_recent_recharge, container, false);
        ibBack = view.findViewById(R.id.ibBack);
        btnCancel =view.findViewById(R.id.btnCancel);
        btnConfirm = view.findViewById(R.id.btnConfirm);
        ibBack.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
        btnConfirm.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ibBack:
            case R.id.btnCancel:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new DetailNearbyStationFragment()).commit();
                break;
        }
    }
}
