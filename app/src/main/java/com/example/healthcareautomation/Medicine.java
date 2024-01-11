package com.example.healthcareautomation;

import android.os.Parcel;
import android.os.Parcelable;

public class Medicine implements Parcelable {
    String name;
    int quantity;

    public Medicine(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    protected Medicine(Parcel in) {
        name = in.readString();
        quantity = in.readInt();
    }

    public static final Creator<Medicine> CREATOR = new Creator<Medicine>() {
        @Override
        public Medicine createFromParcel(Parcel in) {
            return new Medicine(in);
        }

        @Override
        public Medicine[] newArray(int size) {
            return new Medicine[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(name);
        dest.writeInt(quantity);
    }
}
