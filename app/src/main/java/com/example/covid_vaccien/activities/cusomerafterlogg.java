package com.example.covid_vaccien.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.covid_vaccien.utils.Databasehandlecustomer;
import com.example.covid_vaccien.R;
import com.example.covid_vaccien.models.vacciened;

public class cusomerafterlogg extends AppCompatActivity {

    private Spinner spinner;
    private Spinner spinner2;
    private String[] specialist;
    private ArrayAdapter<String> arrayAdapter;
    private String[] specialist2;
    private ArrayAdapter<String> arrayAdapter2;
    Button button;
    String national_id;
    String Location;
    String vaccine_name;
    private Databasehandlecustomer db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cusomerafterlog);
        spinner = findViewById(R.id.spinner2);
        spinner2 = findViewById(R.id.spinner3);
        button=findViewById(R.id.applybutton);
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        national_id=bundle.getString("id");

        db = new Databasehandlecustomer(this.getApplicationContext());
        db.opendatabase();

        specialist = getResources().getStringArray(R.array.spinner_items);
        specialist2 = getResources().getStringArray(R.array.spinner_locations);
        arrayAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, specialist);
        arrayAdapter2 = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, specialist2);
        spinner.setAdapter(arrayAdapter);
        spinner2.setAdapter(arrayAdapter2);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                              @Override
                                              public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                                  vaccine_name=specialist[i];
//                                                  Toast.makeText(cusomerafterlogg.this, "specialist:" + specialist[i], Toast.LENGTH_SHORT).show();
                                              }

                                              @Override
                                              public void onNothingSelected(AdapterView<?> adapterView) {

                                              }
                                          });
                spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        Location=specialist2[i];
//                        Toast.makeText(cusomerafterlogg.this, "specialist:" + specialist2[i], Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }

                });

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int jo=0;
                        int seno=0;
                        int ast=0;
                        int loc_id=0;
                        if(Location.equals("Ain Shams hospital"))
                        {
                            loc_id=0;
                        }
                        else if(Location.equals("El Maddie hospital"))
                        {
                            loc_id=1;
                        }
                        if(vaccine_name.equals("Johnson"))
                        {
                            jo=1;
                        }
                        else if(vaccine_name.equals("sinopharm"))
                        {
                            seno=1;
                        }
                        else if(vaccine_name.equals("astrazeneca"))
                        {
                            ast=1;
                        }


                        vacciened vac=new vacciened(national_id,jo,seno,ast,loc_id);
                        db.insertVacciened(vac);

                        StringBuilder stringBuilder=new StringBuilder();
                        stringBuilder.append(national_id);
                        stringBuilder.append(",");
                        stringBuilder.append(loc_id);
                        stringBuilder.append(",");
                        stringBuilder.append(vaccine_name);
                        String names = stringBuilder.toString();

                        Intent intent1=new Intent(cusomerafterlogg.this, generate.class);
                        intent1.putExtra("builder",names);
                        startActivity(intent1);

                    }
                });

    }
}
