package com.example.covid_vaccien.models;

public class vacciened {

        private int vaccineId;
        private String nationalid;
        private int Johnson;
        private int sinopharm;
        private int astrazeneca;
        private int location_id;
        public vacciened()
        {

        }
        public vacciened( String nationalid, int johnson, int sinopharm, int astrazeneca, int loca) {
            this.nationalid = nationalid;
            Johnson = johnson;
            this.sinopharm = sinopharm;
            this.astrazeneca = astrazeneca;
            this.location_id = location_id;
        }

        public int getVaccineId() {
            return vaccineId;
        }

        public void setVaccineId(int vaccineId) {
            this.vaccineId = vaccineId;
        }

        public String getNationalid() {
            return nationalid;
        }

        public void setNationalid(String nationalid) {
            this.nationalid = nationalid;
        }

        public int getJohnson() {
            return Johnson;
        }

        public void setJohnson(int johnson) {
            Johnson = johnson;
        }

        public int getSinopharm() {
            return sinopharm;
        }

        public void setSinopharm(int sinopharm) {
            this.sinopharm = sinopharm;
        }

        public int getAstrazeneca() {
            return astrazeneca;
        }

        public void setAstrazeneca(int astrazeneca) {
            this.astrazeneca = astrazeneca;
        }

        public int getLocation_id() {
            return location_id;
        }

        public void setLocation_id(int location_id) {
            this.location_id = location_id;
        }
    }