package com.example.covid_vaccien.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.covid_vaccien.R;
import com.example.covid_vaccien.models.CustomerModel;
import com.example.covid_vaccien.utils.Databasehandlecustomer;

import java.util.ArrayList;

public class Signup_customer extends AppCompatActivity {

    Button disease;
    String[] namesList;
    Button signup;
    private Databasehandlecustomer db;
    EditText firstname,lastname,address,password,phone,id;


        @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_customer);
        disease=findViewById(R.id.button5);
//        textView=findViewById(R.id.textView13);
        signup=findViewById(R.id.button7);
        firstname=findViewById(R.id.firstname);
        lastname=findViewById(R.id.lastname);
        address=findViewById(R.id.address);
        password=findViewById(R.id.password);
        phone=findViewById(R.id.phone);
        id=findViewById(R.id.id);
            db = new Databasehandlecustomer(this.getApplicationContext());
            db.opendatabase();

        boolean [] selected_illness;
        ArrayList<Integer> disease_list=new ArrayList<Integer>();
        String [] disease_array={"Diabetes","Pressure disease","heart disease","poliomyelitis","cancer"};

        selected_illness=new boolean[disease_array.length];
        disease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(Signup_customer.this);
                builder.setTitle("Select illness History");
                builder.setCancelable(false);
                builder.setMultiChoiceItems(disease_array, selected_illness, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        if(b) {
                            disease_list.add(i);
                        }
                        else{
                            int index=0;
                            for(int j=0;j<disease_list.size();j++)
                            {
                                if(disease_list.get(j)==i)
                                {
                                    index=j;
                                    break;
                                }
                            }

                            disease_list.remove(index);

                        }
                    }
                });
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        StringBuilder stringBuilder=new StringBuilder();
                        for(int j=0;j<disease_list.size();j++)
                        {

                            stringBuilder.append(disease_array[disease_list.get(j)]);
//                            stringBuilder.append(selected_illness[j]);
                            if(j!=disease_list.size()-1)
                            {
                                stringBuilder.append(", ");
                            }
                        }
                        String names = stringBuilder.toString();
                        namesList = names.split(",");

//                        disease.setText(stringBuilder.toString());
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                builder.show();
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                 String Firstname=firstname.getText().toString();
                 String Lastname=lastname.getText().toString();
                 String nationalid=id.getText().toString();
                String Password=password.getText().toString();
                 String addressss=address.getText().toString();
                 String Phonenumber=phone.getText().toString();
                int vaccien_count=0;
                int Diabetes_ill=0;
                int Pressure_ill=0;
                int heart_ill=0;
                int poliomyelitis_ill=0;
                int cancer_ill=0;
//                {"Diabetes","Pressure disease","heart disease","poliomyelitis","cancer"};
                for(int i=0;i<namesList.length;i++)
                {
                    if(namesList[i].equals("Diabetes"))
                    {
                        Diabetes_ill=1;
                    }
                    else if(namesList[i].equals("Pressure disease"))
                    {
                        Pressure_ill=1;
                    }
                    else if (namesList[i].equals("heart disease"))
                    {
                        heart_ill=1;
                    }
                    else if (namesList[i].equals("poliomyelitis"))
                    {
                        poliomyelitis_ill=1;
                    }
                    else if (namesList[i].equals("cancer"))
                    {
                        cancer_ill=1;
                    }

                }
                CustomerModel model=new CustomerModel(Firstname,Lastname,nationalid,Password,Diabetes_ill,Pressure_ill,heart_ill,poliomyelitis_ill,cancer_ill,addressss,Phonenumber,vaccien_count);

                db.insertcustomer(model);
                Intent intent=new Intent(Signup_customer.this, LOGIN.class);
                intent.putExtra("type","customer");
                startActivity(intent);
            }
        });


    }


}
