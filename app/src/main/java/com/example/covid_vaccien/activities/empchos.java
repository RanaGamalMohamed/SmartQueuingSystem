package com.example.covid_vaccien.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.covid_vaccien.R;

public class empchos extends AppCompatActivity {
    Button scan,wait;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.emplcho);
        scan=findViewById(R.id.scan);
        wait=findViewById(R.id.waitlist);
        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(empchos.this, MainActivity.class);
                startActivity(intent);
            }
        });

        wait.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
