package com.example.evcharge.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.evcharge.R;

public class MyChargersFragment extends Fragment implements View.OnClickListener {
    View view;
    ImageButton ibBack;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_mychargers, container, false);
        ibBack = view.findViewById(R.id.ibBack);
        ibBack.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ibBack:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new AccountFragment()).commit();
                break;
        }
    }
}
