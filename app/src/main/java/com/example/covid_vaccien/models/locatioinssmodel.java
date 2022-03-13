package com.example.covid_vaccien.models;

 public class locatioinssmodel {
    private int location_id;
    private String location_name;
    private int capicity;
    public locatioinssmodel()
    {

    }

    public locatioinssmodel(String location_name, int capicity) {
        this.location_name = location_name;
        if(location_name.equals("Ain Shams hospital"))
        {
            this.location_id=0;
        }
        else if (location_name.equals("El Maddie hospital"))
        {
            this.location_id=1;
        }
        this.capicity = capicity;
    }

    public int getLocation_id() {
        return location_id;
    }

    public void setLocation_id(int location_id) {
        this.location_id = location_id;
    }

    public String getLocation_name() {
        return location_name;
    }

    public void setLocation_name(String location_name) {
        this.location_name = location_name;
    }

    public int getCapicity() {
        return capicity;
    }

    public void setCapicity(int capicity) {
        this.capicity = capicity;
    }
}
