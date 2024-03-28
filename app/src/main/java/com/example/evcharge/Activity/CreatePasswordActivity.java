package com.example.evcharge.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.evcharge.R;

public class CreatePasswordActivity extends AppCompatActivity implements View.OnClickListener {
    AppCompatButton btnSave;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_password);
        btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnSave:
                startActivity(new Intent(CreatePasswordActivity.this, PanelActivity.class));
                break;
        }
    }
}
