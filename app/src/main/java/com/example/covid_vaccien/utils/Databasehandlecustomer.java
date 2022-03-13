package com.example.covid_vaccien.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.covid_vaccien.models.CustomerModel;
import com.example.covid_vaccien.models.EmployeeModel;
import com.example.covid_vaccien.models.locatioinssmodel;
import com.example.covid_vaccien.models.vacciened;

import java.util.ArrayList;
import java.util.List;

public class Databasehandlecustomer extends SQLiteOpenHelper {
    //DATABASE dETILS
    private static final int VERSION = 1;
    private static final String NAME = "covid-19";
    private static final String CustomerTABLE = "Customer";
    private static final String LoctionTABLE = "locations";
    private static final String EmployeeTABLE = "employees";
    private static final String vaccienedTABLE = "vacciened";

    //ATTRIBUTES
    private static final String sex="sex";
    private static final String nationalid = "nationalid";
    private static final String Firstname = "firstname";
    private static final String Lastname = "lastname";
    private static final String Password = "password";
    private static final String Diabetes_ill = "diabetes";
    private static final String Pressure_ill = "Pressure";
    private static final String heart_ill = "heart";
    private static final String poliomyelitis_ill = "poliomyelitis";
    private static final String cancer_ill = "cancer";
    private static final String address = "address";
    private static final String Phonenumber = "Phonenumber";
    private static final String vaccien_count = "vacciencount";
    //    //TABLE CREATAI
    private static final String CREATEcustomerTABLE =" CREATE TABLE "+ CustomerTABLE +
            "( "+ nationalid +" TEXT PRIMARY KEY , "+ Firstname +" TEXT, "+ Lastname +" TEXT, "+ Password +" TEXT, "+ address +" TEXT, "+ Phonenumber +" TEXT, "+ vaccien_count +" INTEGR, "+ Diabetes_ill +" INTEGR, "+ Pressure_ill +" INTEGR, "+ heart_ill +" INTEGR, "+ poliomyelitis_ill +" INTEGR, "+cancer_ill+" INTEGR ) ";

    //////////////////////////////////////////

    private static final String Employee_id = "employeeid";
    //    private  static final  int nationalid;
//    private  static final  String Password;
    private static final String location_id = "locationid";

    //    //TABLE CREATAI
    private static final String CREATEemployeeTABLE =" CREATE TABLE "+ EmployeeTABLE +
            "( "+ Employee_id +" INTEGER PRIMARY KEY AUTOINCREMENT, "+ nationalid +" TEXT, "+ location_id +" INTEGR, "+ Password +" TEXT ) ";

    ////////////////////////////////////////////////////
//    private int location_id;
    private static final String location_name = "locationname";
    private static final String capicity = "capcity";
    private static final String CREATElocationTABLE =" CREATE TABLE "+ LoctionTABLE +
            "( "+ location_id +" INTEGER PRIMARY KEY AUTOINCREMENT, "+ capicity +" INTEGR, "+ location_name +" TEXT ) ";
    //////////////////////////////////////////////////////////////
//VaccienedTable
    private static final String vaccineId= "vaccineId";
    private static final String Johnson= "Johnson";
    private static final String sinopharm = "sinopharm";
    private static final String astrazeneca = "astrazeneca";

    // Creation Of table
    private static final String CREATVaccienedTABLE =" CREATE TABLE "+ vaccienedTABLE +
            "( "+ vaccineId +" INTEGER PRIMARY KEY AUTOINCREMENT, "+ nationalid +" TEXT, "+ location_id +" INTEGR, "+ Johnson +" INTEGR, " + sinopharm +" INTEGR, "+ astrazeneca +" INTEGR ) ";

    ////////////////////////////////////////////////////////////
    private SQLiteDatabase dp;

    public Databasehandlecustomer(Context context)
    {
        super(context,NAME,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase dp) {
        dp.execSQL(CREATEcustomerTABLE);
        dp.execSQL(CREATElocationTABLE);
        dp.execSQL(CREATEemployeeTABLE);
        dp.execSQL(CREATVaccienedTABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase dp, int oldversion, int newversion) {
        dp.execSQL("DROP TABLE IF EXIST"+CustomerTABLE);
        dp.execSQL("DROP TABLE IF EXIST"+EmployeeTABLE);
        dp.execSQL("DROP TABLE IF EXIST"+LoctionTABLE);
        onCreate(dp);
    }

    public void opendatabase()
    {
        dp=this.getWritableDatabase();
    }

    public void insertVacciened(vacciened model)
    {
        ContentValues cv = new ContentValues();
        cv.put(nationalid,model.getNationalid());
        cv.put(location_id,model.getLocation_id());
        cv.put(sinopharm,model.getSinopharm());
        cv.put(astrazeneca,model.getAstrazeneca());
        cv.put(Johnson,model.getJohnson());
        dp.insert(LoctionTABLE,null,cv);
    }
    public List<vacciened> de(){
        List<vacciened> modelslist=new ArrayList<>();
        Cursor cur = null;
        dp.beginTransaction();
        try{
            cur = dp.query(vaccienedTABLE, null, null, null, null, null, null, null);
            if(cur != null){
                if(cur.moveToFirst()){
                    do{
                        vacciened model=new vacciened();
//                        model.setId(cur.getInt(cur.getColumnIndex(ID)));
                        model.setVaccineId(cur.getInt(cur.getColumnIndex(vaccineId)));
                        model.setNationalid(cur.getString(cur.getColumnIndex(nationalid)));
                        model.setAstrazeneca(cur.getInt(cur.getColumnIndex(astrazeneca)));
                        model.setJohnson(cur.getInt(cur.getColumnIndex(Johnson)));
                        model.setSinopharm(cur.getInt(cur.getColumnIndex(sinopharm)));
                        model.setLocation_id(cur.getInt(cur.getColumnIndex(location_id)));


                        modelslist.add(model);
                    } while(cur.moveToNext());
                }
            }
        }
        finally {
            dp.endTransaction();
            assert cur != null;
            cur.close();
        }
//        Log.d("logmee","insert"+modelslist.size());
        return modelslist;
    }

    public void insertcustomer(CustomerModel model)
    {
//        Log.d("logme","new alarm before adding");
        ContentValues cv = new ContentValues();
//        cv.put(ALARMNAME,model.getAlarmname());
        cv.put(nationalid,model.getNationalid());
        cv.put(Firstname,model.getFirstname());
        cv.put(Lastname,model.getLastname());
        cv.put(Password,model.getPassword());
        cv.put(address,model.getAddress());
        cv.put(vaccien_count,model.getVaccien_count());
        cv.put(Diabetes_ill,model.getDiabetes_ill());
        cv.put(Pressure_ill,model.getPressure_ill());
        cv.put(poliomyelitis_ill,model.getPoliomyelitis_ill());
        cv.put(cancer_ill,model.getCancer_ill());
        dp.insert(CustomerTABLE,null,cv);

        Log.d("logme","new alarm adding");
    }
    public void insertemployee(EmployeeModel model)
    {
        ContentValues cv = new ContentValues();
        cv.put(nationalid,model.getNationalid());
        cv.put(location_id,model.getLocation_id());
        cv.put(Password,model.getPassword());
        dp.insert(EmployeeTABLE,null,cv);
    }
    public void insertlocation(locatioinssmodel model)
    {
        ContentValues cv = new ContentValues();
        cv.put(location_name,model.getLocation_name());
        cv.put(capicity,model.getCapicity());
        dp.insert(LoctionTABLE,null,cv);
    }

    public List<CustomerModel> d(){
        List<CustomerModel> modelslist=new ArrayList<>();
        Cursor cur = null;
        dp.beginTransaction();
        try{
            cur = dp.query(CustomerTABLE, null, null, null, null, null, null, null);
            if(cur != null){
                if(cur.moveToFirst()){
                    do{
                        CustomerModel model=new CustomerModel();
//                        model.setId(cur.getInt(cur.getColumnIndex(ID)));
                        model.setNationalid(cur.getString(cur.getColumnIndex(nationalid)));
                        model.setAddress(cur.getString(cur.getColumnIndex(address)));
                        model.setCancer_ill(cur.getInt(cur.getColumnIndex(cancer_ill)));
                        model.setDiabetes_ill(cur.getInt(cur.getColumnIndex(Diabetes_ill)));
                        model.setFirstname(cur.getString(cur.getColumnIndex(Firstname)));
                        model.setPassword(cur.getString(cur.getColumnIndex(Password)));
                        model.setLastname(cur.getString(cur.getColumnIndex(Lastname)));
                        model.setHeart_ill(cur.getInt(cur.getColumnIndex(heart_ill)));
                        model.setPoliomyelitis_ill(cur.getInt(cur.getColumnIndex(poliomyelitis_ill)));
                        model.setPressure_ill(cur.getInt(cur.getColumnIndex(Pressure_ill)));
                        model.setPhonenumber(cur.getString(cur.getColumnIndex(Phonenumber)));
                        model.setVaccien_count(cur.getInt(cur.getColumnIndex(vaccien_count)));

                        modelslist.add(model);
                    } while(cur.moveToNext());
                }
            }
        }
        finally {
            dp.endTransaction();
            assert cur != null;
            cur.close();
        }
//        Log.d("logmee","insert"+modelslist.size());
        return modelslist;
    }

    public List<EmployeeModel> dE() {
        List<EmployeeModel> modelslist=new ArrayList<>();
        Cursor cur = null;
        dp.beginTransaction();
        try{
            cur = dp.query(EmployeeTABLE, null, null, null, null, null, null, null);
            if(cur != null){
                if(cur.moveToFirst()){
                    do{
                        EmployeeModel model=new EmployeeModel();
//                        model.setId(cur.getInt(cur.getColumnIndex(ID)));
                        model.setNationalid(cur.getString(cur.getColumnIndex(nationalid)));
                        model.setPassword(cur.getString(cur.getColumnIndex(Password)));
                        model.setLocation_id(cur.getInt(cur.getColumnIndex(location_id)));
                        model.setEmployee_id(cur.getInt(cur.getColumnIndex(Employee_id)));
                        modelslist.add(model);
                    } while(cur.moveToNext());
                }
            }
        }
        finally {
            dp.endTransaction();
            assert cur != null;
            cur.close();
        }
//        Log.d("logmee","insert"+modelslist.size());
        return modelslist;
    }

    public List<locatioinssmodel> dEE() {
        List<locatioinssmodel> modelslist=new ArrayList<locatioinssmodel>();
        Cursor cur = null;
        dp.beginTransaction();
        try{
            cur = dp.query(LoctionTABLE, null, null, null, null, null, null, null);
            if(cur != null){
                if(cur.moveToFirst()){
                    do{
                        locatioinssmodel model=new locatioinssmodel();
//                        model.setId(cur.getInt(cur.getColumnIndex(ID)));
                        model.setLocation_id(cur.getInt(cur.getColumnIndex(location_id)));
                        model.setLocation_name(cur.getString(cur.getColumnIndex(location_name)));
                        model.setCapicity(cur.getInt(cur.getColumnIndex(capicity)));
                        modelslist.add(model);
                    } while(cur.moveToNext());
                }
            }
        }
        finally {
            dp.endTransaction();
            assert cur != null;
            cur.close();
        }
//        Log.d("logmee","insert"+modelslist.size());
        return modelslist;
    }
}
//    public void updatestatues(int id, int statues, String alarmname,
//                                int vibrate,int snooze, int daytime,
//                                        int hour,int minues)
//    {
//        ContentValues cv =new ContentValues();
//        cv.put(STATUES,statues);
//        cv.put(ALARMNAME,alarmname);
//        cv.put(VIBRATE,vibrate);
//        cv.put(SNOOZE,snooze);
//        cv.put(DAYTIME,daytime);
//        cv.put(HOUR,hour);
//        cv.put(MINUTES,minues);
//        dp.update(ALARMTABLE,cv,ID+"=?",new String[]{String.valueOf(id)});
//    }
//    public void updatestats(int id,int statues)
//    {
//        ContentValues cv =new ContentValues();
//        cv.put(STATUES,statues);
//        dp.update(ALARMTABLE,cv,ID+"=?",new String[]{String.valueOf(id)});
//    }
//
//    public void deletealarm(int id)
//    {
//        dp.delete(ALARMTABLE,ID+"=?",new String[]{String.valueOf(id)});
//    }
//
//
//}
