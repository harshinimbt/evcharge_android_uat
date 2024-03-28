package com.example.evcharge.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import com.example.evcharge.R;

public class AddVehicleActivity extends AppCompatActivity implements View.OnClickListener {
    ImageButton ibBack;
    AppCompatButton btnCancel;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vehicle);
        ibBack = findViewById(R.id.ibBack);
        ibBack.setOnClickListener(this);
        btnCancel = findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ibBack:
            case R.id.btnCancel:
                Intent intent = new Intent(this, PanelActivity.class);
                startActivity(intent);
//                getSupportFragmentManager().beginTransaction().replace(R.id.activity_add_vehicle, new VehicleFragment()).commit();
                break;
        }
    }
}
