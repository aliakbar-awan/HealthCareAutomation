package com.example.healthcareautomation;

import android.os.Parcel;
import android.os.Parcelable;

public class Child extends Person{
    Vaccine [] vaccines;
    boolean vaccination_completed;

    public Child(String name, String fname, String gender, String dob, String rel, int family) {
        super(name, fname, gender, dob, rel,family);
        vaccines = new Vaccine[6];
        vaccines[0] = new Vaccine("BCG");
        vaccines[1] = new Vaccine("Pentavalent-I");
        vaccines[2] = new Vaccine("Pentavalent-II");
        vaccines[3] = new Vaccine("Pentavalent-III");
        vaccines[4] = new Vaccine("Measles-I");
        vaccines[5] = new Vaccine("Measles-II");
        vaccination_completed = false;
    }

    public Child(Person person){
        super(person.getName(), person.getFatherName(), person.getGender(), person.getDob(), person.getRelation(),person.getFamily_no());
        vaccines = new Vaccine[6];
        vaccines[0] = new Vaccine("BCG");
        vaccines[1] = new Vaccine("Pentavalent-I");
        vaccines[2] = new Vaccine("Pentavalent-II");
        vaccines[3] = new Vaccine("Pentavalent-III");
        vaccines[4] = new Vaccine("Measles-I");
        vaccines[5] = new Vaccine("Measles-II");
        vaccination_completed = false;
    }

    public Vaccine[] getVaccines() {
        return vaccines;
    }

    public void setVaccines(Vaccine[] vaccines) {
        this.vaccines = vaccines;
    }

    public boolean isVaccinationCompleted(){
        for(int i=0;i<6;i++){
            if(vaccines[i].getStatus() != "done"){
                return false;
            }
        }
        return true;
    }

}

class Vaccine implements Parcelable{
    String name;
    String date;
    String status;
    public Vaccine(String name) {
        this.name = name;
        this.date = "pending";
        this.status = "pending";
    }

    public Vaccine(String name, String date) {
        this.name = name;
        this.date = date;
    }

    protected Vaccine(Parcel in) {
        name = in.readString();
        date = in.readString();
        status = in.readString();
    }

    public static final Creator<Vaccine> CREATOR = new Creator<Vaccine>() {
        @Override
        public Vaccine createFromParcel(Parcel in) {
            return new Vaccine(in);
        }

        @Override
        public Vaccine[] newArray(int size) {
            return new Vaccine[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(date);
        dest.writeString(status);
    }
}

