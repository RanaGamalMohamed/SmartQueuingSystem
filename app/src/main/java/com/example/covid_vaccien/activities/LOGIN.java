package com.example.covid_vaccien.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.covid_vaccien.utils.Databasehandlecustomer;
import com.example.covid_vaccien.R;
import com.example.covid_vaccien.models.CustomerModel;
import com.example.covid_vaccien.models.EmployeeModel;
import com.example.covid_vaccien.models.locatioinssmodel;

import java.util.List;

public class LOGIN extends AppCompatActivity {

    TextView signup;
    String type;
    Button login;
    private Databasehandlecustomer db;
    List<CustomerModel> customers;
    List<EmployeeModel>employees;
    EditText id,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in);
        signup=findViewById(R.id.textView6);
        id=findViewById(R.id.id_log);
        password=findViewById(R.id.pass_log);

        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        type=bundle.getString("type");
        login=findViewById(R.id.login_pass);

        db = new Databasehandlecustomer(this.getApplicationContext());
        db.opendatabase();
        generate(db);
        customers=db.d();
        employees=db.dE();
//        Log.d("logme","insert"+customers.size());
        if(type.equals("Employee"))
        {
            signup.setVisibility(View.INVISIBLE);

        }
//        Log.d("logme","insert"+customers.size());
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String idd=id.getText().toString();
                String passs=password.getText().toString();
                if(type.equals("Employee"))
                {
                    for(int i=0;i<employees.size();i++)
                    {
                        if (employees.get(i).getNationalid().equals(idd)) {
                            if (employees.get(i).getPassword().equals(passs)) {
                                Intent intent1 = new Intent(LOGIN.this, empchos.class);
                                startActivity(intent1);
                            }
                        }
                    }
                }
                else if (type.equals("customer")){
                    for (int i = 0; i < customers.size(); i++) {
                        Log.d("logme", "insert1" + customers.get(i).getNationalid());
                        Log.d("logme", "insert2" + idd);
                        Log.d("logme", "insert3" + customers.get(i).getPassword());
                        Log.d("logme", "insert4" + passs);
                        if (customers.get(i).getNationalid().equals(idd)) {
                            if (customers.get(i).getPassword().equals(passs)) {
                                Intent intent1 = new Intent(LOGIN.this, cusomerafterlogg.class);
                                intent1.putExtra("id",customers.get(i).getNationalid());
                                startActivity(intent1);
                            }
                        }
                    }
                }
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(type.equals("customer"))
                {
                    Intent intent1  = new Intent(getApplicationContext(), Signup_customer.class);
                    startActivity(intent1);
                }

            }
        });
    }
    public void generate(Databasehandlecustomer db)
    {
        EmployeeModel model1=new EmployeeModel("1234","1234",0);
        EmployeeModel model2=new EmployeeModel("20131300459","14225452",1);
        locatioinssmodel moder1=new locatioinssmodel("Ain shams hosiptal",250);
        locatioinssmodel moder2=new locatioinssmodel("el maddie hosiptal",150);
        db.insertlocation(moder1);
        db.insertlocation(moder2);
        db.insertemployee(model1);
        db.insertemployee(model2);
    }

}
