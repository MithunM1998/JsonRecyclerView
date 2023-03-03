package com.example.jsonrecyclerview;

public class Model {
    private String name;
    private  String dob;
    private String designation;
    private String companyName;
public Model(){

}
    public Model(String name, String dob, String designation, String companyName) {
        this.name = name;
        this.dob = dob;
        this.designation = designation;
        this.companyName = companyName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
