package com.example.covid_vaccien.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.covid_vaccien.R;

public class empvscustomer extends AppCompatActivity {
    public Button b_emp,b_customer;
        public Intent intent;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.empvspatient);
        b_emp=findViewById(R.id.waitlist);
        b_customer=findViewById(R.id.scan);

        b_emp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            intent=new Intent(empvscustomer.this, LOGIN.class);
            intent.putExtra("type","Employee");
            startActivity(intent);

            }
        });

        b_customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent=new Intent(empvscustomer.this,LOGIN.class);
                intent.putExtra("type","customer");
                startActivity(intent);
            }
        });
    }
}
