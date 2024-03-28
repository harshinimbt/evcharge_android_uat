package com.example.evcharge.Fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.evcharge.Activity.LoginActivity;
import com.example.evcharge.R;

import java.util.ArrayList;

public class AccountFragment extends Fragment implements View.OnClickListener {
    View view;
    ImageButton ibBack;

    AppCompatButton btnLogout;
    LinearLayout llProfile,llMyChargers,llSettings,llFaq,llTerms,llPrivacyPolicy;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_account, container, false);
        llProfile = view.findViewById(R.id.llProfile);
        llProfile.setOnClickListener(this);
        llMyChargers = view.findViewById(R.id.llMyChargers);
        llMyChargers.setOnClickListener(this);
        llSettings = view.findViewById(R.id.llSettings);
        llSettings.setOnClickListener(this);
        llFaq = view.findViewById(R.id.llFaq);
        llFaq.setOnClickListener(this);
        llTerms = view.findViewById(R.id.llTerms);
        llTerms.setOnClickListener(this);
        llPrivacyPolicy = view.findViewById(R.id.llPrivacyPolicy);
        llPrivacyPolicy.setOnClickListener(this);
        btnLogout = view.findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(this);
        ibBack = view.findViewById(R.id.ibBack);
        ibBack.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ibBack:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new DashboardFragment()).commit();
                break;
            case R.id.btnLogout:
                ShowLogoutPopup();
                break;
            case R.id.llProfile:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new ProfileFragment()).commit();
                break;
            case R.id.llMyChargers:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new MyChargersFragment()).commit();
                break;
            case R.id.llSettings:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new SettingsFragment()).commit();
                break;
            case R.id.llFaq:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new FAQFragment()).commit();
                break;
            case R.id.llTerms:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new TermsOfUseFragment()).commit();
                break;
            case R.id.llPrivacyPolicy:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new PrivacyPolicyFragment()).commit();
                break;
        }
    }

    private void ShowLogoutPopup() {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getContext());
        android.app.AlertDialog alertDialog;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layoutView = inflater.inflate(R.layout.logout_popup, null);
        builder.setView(layoutView);
        alertDialog = builder.create();
        alertDialog.getWindow().getAttributes().windowAnimations = R.style.PopupAnimation;
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.show();
        AppCompatButton btnConfirm = alertDialog.findViewById(R.id.btnConfirm) , btnCancel = alertDialog.findViewById(R.id.btnCancel);
        ImageButton cancel = alertDialog.findViewById(R.id.cancel);
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), LoginActivity.class));
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
                alertDialog.hide();
                alertDialog.cancel();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
                alertDialog.hide();
                alertDialog.cancel();
            }
        });

    }
}
