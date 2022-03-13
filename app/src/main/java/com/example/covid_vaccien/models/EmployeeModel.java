package com.example.covid_vaccien.models;

public class EmployeeModel {
    private int  Employee_id;
    private String nationalid;
    private String Password;
    private  int location_id;
    public EmployeeModel()
    {

    }
    public EmployeeModel(String nationalid, String password ,int location_id) {
        this.nationalid = nationalid;
        Password = password;
        this.location_id=location_id;

    }

    public int getEmployee_id() {
        return Employee_id;
    }

    public void setEmployee_id(int employee_id) {
        Employee_id = employee_id;
    }

    public String getNationalid() {
        return nationalid;
    }

    public void setNationalid(String nationalid) {
        this.nationalid = nationalid;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public int getLocation_id() {
        return location_id;
    }

    public void setLocation_id(int location_id) {
        this.location_id = location_id;
    }


}
