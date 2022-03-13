package com.example.covid_vaccien.models;

public class CustomerModel {
    private int sex;
    private String Firstname;
    private String Lastname;
    private String nationalid;
    private String Password;
    private int Diabetes_ill;
    private int Pressure_ill;
    private int heart_ill;
    private int poliomyelitis_ill;
    private int cancer_ill;
    private String address;
    private String Phonenumber;
    private int vaccien_count;

    public CustomerModel(String firstname, String lastname, String nationalid, String password, int diabetes_ill, int pressure_ill, int heart_ill, int poliomyelitis_ill, int cancer_ill, String address, String phonenumber, int vaccien_count) {
        Firstname = firstname;
        Lastname = lastname;
        this.nationalid = nationalid;
        Password = password;
        Diabetes_ill = diabetes_ill;
        Pressure_ill = pressure_ill;
        this.heart_ill = heart_ill;
        this.poliomyelitis_ill = poliomyelitis_ill;
        this.cancer_ill = cancer_ill;
        this.address = address;
        Phonenumber = phonenumber;
        this.vaccien_count = vaccien_count;

    }



    public String getFirstname() {
        return Firstname;
    }
    public CustomerModel(){}
    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
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

    public int getDiabetes_ill() {
        return Diabetes_ill;
    }

    public void setDiabetes_ill(int diabetes_ill) {
        Diabetes_ill = diabetes_ill;
    }

    public int getPressure_ill() {
        return Pressure_ill;
    }

    public void setPressure_ill(int pressure_ill) {
        Pressure_ill = pressure_ill;
    }

    public int getHeart_ill() {
        return heart_ill;
    }

    public void setHeart_ill(int heart_ill) {
        this.heart_ill = heart_ill;
    }

    public int getPoliomyelitis_ill() {
        return poliomyelitis_ill;
    }

    public void setPoliomyelitis_ill(int poliomyelitis_ill) {
        this.poliomyelitis_ill = poliomyelitis_ill;
    }

    public int getCancer_ill() {
        return cancer_ill;
    }

    public void setCancer_ill(int cancer_ill) {
        this.cancer_ill = cancer_ill;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhonenumber() {
        return Phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        Phonenumber = phonenumber;
    }

    public int getVaccien_count() {
        return vaccien_count;
    }

    public void setVaccien_count(int vaccien_count) {
        this.vaccien_count = vaccien_count;
    }
}
