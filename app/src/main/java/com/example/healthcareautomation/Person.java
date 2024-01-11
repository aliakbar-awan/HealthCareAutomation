package com.example.healthcareautomation;

import android.os.Parcel;
import android.os.Parcelable;

public class Person implements Parcelable{

    String name;
    String fatherName;
    String gender;
    String dob;
    String relation;
    int family_no;

    public Person(String name, String fname, String gender, String dob, String rel,int family_no){
        this.name = name;
        this.fatherName = fname;
        this.gender = gender;
        this.dob = dob;
        this.relation = rel;
        this.family_no = family_no;
    }

    protected Person(Parcel in) {
        name = in.readString();
        fatherName = in.readString();
        gender = in.readString();
        dob = in.readString();
        relation = in.readString();
        family_no = in.readInt();
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public int getFamily_no() {
        return family_no;
    }

    public void setFamily_no(int family_no) {
        this.family_no = family_no;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(fatherName);
        dest.writeString(gender);
        dest.writeString(dob);
        dest.writeString(relation);
        dest.writeInt(family_no);
    }
}
