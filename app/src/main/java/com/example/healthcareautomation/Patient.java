package com.example.healthcareautomation;

import java.util.ArrayList;
import java.util.List;

public class Patient {
    int family_no;
    String name;
    String fatherName;
    String relation;
    String reason;
    String registered_on;
    ArrayList<Medicine>  medicines;

    public Patient(int family_no, String name, String fatherName, String relation, String reason, String registered_on,ArrayList<Medicine> med) {
        this.name = name;
        this.fatherName = fatherName;
        this.relation = relation;
        this.family_no = family_no;
        this.reason = reason;
        this.registered_on = registered_on;
        this.medicines = med;
    }

    public int getFamily_no() {
        return family_no;
    }

    public void setFamily_no(int family_no) {
        this.family_no = family_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getRegistered_on() {
        return registered_on;
    }

    public void setRegistered_on(String registered_on) {
        this.registered_on = registered_on;
    }

    public ArrayList<Medicine> getMedicines() {
        return medicines;
    }

    public void setMedicines(ArrayList<Medicine> medicines) {
        this.medicines = medicines;
    }
}
