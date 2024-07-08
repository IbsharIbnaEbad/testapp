package com.example.ibshar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class admin_helper extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_manage);

        Button btn_dlt, btn_up;

        btn_dlt = findViewById(R.id.btn_dlt);
        btn_up = findViewById(R.id.btn_up);

        btn_dlt.setOnClickListener(v -> {
            Intent intent = new Intent(admin_helper.this, stock_Delate.class);
            startActivity(intent);
        });

        btn_up.setOnClickListener(v -> {
            Intent intent = new Intent(admin_helper.this, stock_update.class);
            startActivity(intent);
        });
    }
}