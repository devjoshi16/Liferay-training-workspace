package com.aixtor.employee.model;

import java.math.BigInteger;

public class BranchCustom {
        public BigInteger branchId;
        public String branchName;
        public String cityName;
        public String stateName;
        public String countryName;

        // Constructor
        public BranchCustom(BigInteger branchId, String branchName, String cityName, String stateName, String countryName) {
            this.branchId = branchId;
            this.branchName = branchName;
            this.cityName = cityName;
            this.stateName = stateName;
            this.countryName = countryName;
        }

        // Getters and Setters
        public BigInteger getBranchId() {
            return branchId;
        }

        public void setBranchId(BigInteger branchId) {
            this.branchId = branchId;
        }

        public String getBranchName() {
            return branchName;
        }

        public void setBranchName(String branchName) {
            this.branchName = branchName;
        }

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public String getStateName() {
            return stateName;
        }

        public void setStateName(String stateName) {
            this.stateName = stateName;
        }

        public String getCountryName() {
            return countryName;
        }

        public void setCountryName(String countryName) {
            this.countryName = countryName;
        }

        // toString method for easy printing
        @Override
        public String toString() {
            return "Branch{" +
                    "branchId=" + branchId +
                    ", branchName='" + branchName + '\'' +
                    ", cityName='" + cityName + '\'' +
                    ", stateName='" + stateName + '\'' +
                    ", countryName='" + countryName + '\'' +
                    '}';
        }


}
