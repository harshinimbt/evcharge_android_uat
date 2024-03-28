package com.example.evcharge.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.evcharge.Fragment.DashboardFragment;
import com.example.evcharge.Fragment.VehicleFragment;
import com.example.evcharge.R;

public class PanelActivity extends AppCompatActivity implements View.OnClickListener {
    LinearLayout Home,vehicles,trips,history;
    public ImageView ivHome;
    public ImageView ivVehicles;
    public ImageView ivTrips;
    public ImageView ivHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panel);

        Home = findViewById(R.id.Home);
        Home.setOnClickListener(this);
        ivHome = findViewById(R.id.ivHome);

        vehicles = findViewById(R.id.vehicles);
        vehicles.setOnClickListener(this);
        ivVehicles= findViewById(R.id.ivVehicles);

        trips = findViewById(R.id.trips);
        trips.setOnClickListener(this);
        ivTrips = findViewById(R.id.ivTrips);

        history = findViewById(R.id.history);
        history.setOnClickListener(this);
        ivHistory = findViewById(R.id.ivHistory);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameLayout,new DashboardFragment())
                .commit();
        ivHome.setBackgroundTintList(ContextCompat.getColorStateList(PanelActivity.this, R.color.green));
        ivVehicles.setBackgroundTintList(ContextCompat.getColorStateList(PanelActivity.this, R.color.black));
        ivTrips.setBackgroundTintList(ContextCompat.getColorStateList(PanelActivity.this, R.color.black));
        ivHistory.setBackgroundTintList(ContextCompat.getColorStateList(PanelActivity.this, R.color.black));
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Home:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frameLayout,new DashboardFragment())
                        .commit();
                ivHome.setBackgroundTintList(ContextCompat.getColorStateList(PanelActivity.this, R.color.green));
                ivVehicles.setBackgroundTintList(ContextCompat.getColorStateList(PanelActivity.this, R.color.black));
                ivTrips.setBackgroundTintList(ContextCompat.getColorStateList(PanelActivity.this, R.color.black));
                ivHistory.setBackgroundTintList(ContextCompat.getColorStateList(PanelActivity.this, R.color.black));
                break;
            case R.id.vehicles:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frameLayout,new VehicleFragment())
                        .commit();
                ivHome.setBackgroundTintList(ContextCompat.getColorStateList(PanelActivity.this, R.color.black));
                ivVehicles.setBackgroundTintList(ContextCompat.getColorStateList(PanelActivity.this, R.color.green));
                ivTrips.setBackgroundTintList(ContextCompat.getColorStateList(PanelActivity.this, R.color.black));
                ivHistory.setBackgroundTintList(ContextCompat.getColorStateList(PanelActivity.this, R.color.black));
                break;
            case R.id.trips:
                ivHome.setBackgroundTintList(ContextCompat.getColorStateList(PanelActivity.this, R.color.black));
                ivVehicles.setBackgroundTintList(ContextCompat.getColorStateList(PanelActivity.this, R.color.black));
                ivTrips.setBackgroundTintList(ContextCompat.getColorStateList(PanelActivity.this, R.color.green));
                ivHistory.setBackgroundTintList(ContextCompat.getColorStateList(PanelActivity.this, R.color.black));
                break;
            case R.id.history:
                ivHome.setBackgroundTintList(ContextCompat.getColorStateList(PanelActivity.this, R.color.black));
                ivVehicles.setBackgroundTintList(ContextCompat.getColorStateList(PanelActivity.this, R.color.black));
                ivTrips.setBackgroundTintList(ContextCompat.getColorStateList(PanelActivity.this, R.color.black));
                ivHistory.setBackgroundTintList(ContextCompat.getColorStateList(PanelActivity.this, R.color.green));
                break;
        }
    }
}