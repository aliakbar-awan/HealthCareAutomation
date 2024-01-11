package com.example.healthcareautomation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class VaccinationAdapter extends BaseAdapter {
    Context context;
    Vaccine [] vaccine;

    public VaccinationAdapter(Context context, Vaccine[] vaccine) {
        this.context = context;
        this.vaccine = vaccine;
    }

    @Override
    public int getCount() {
        return vaccine.length;
    }

    @Override
    public Vaccine getItem(int position) {
        return vaccine[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.vaccine_item,parent,false);
        }
        TextView vaccine_name = convertView.findViewById(R.id.vaccine_name);
        TextView vaccine_date = convertView.findViewById(R.id.vaccine_date);
        ImageView vaccine_status = convertView.findViewById(R.id.vaccine_status);
        ImageView vaccine_image = convertView.findViewById(R.id.vaccine_image);
        Vaccine vaccine = getItem(position);
        vaccine_name.setText(vaccine.getName());
        vaccine_date.setText(vaccine.getDate());
        switch (position){
            case 0:
                vaccine_image.setImageResource(R.drawable.bcg);
                break;
            case 1:
                vaccine_image.setImageResource(R.drawable.p1);
                break;
            case 2:
                vaccine_image.setImageResource(R.drawable.p2);
                break;
            case 3:
                vaccine_image.setImageResource(R.drawable.p3);
                break;
            case 4:
                vaccine_image.setImageResource(R.drawable.m1);
                break;
            case 5:
                vaccine_image.setImageResource(R.drawable.m2);
        }

        switch (vaccine.getStatus()){
            case "done":
                vaccine_status.setImageResource(R.drawable.vaccine_applied);
                break;
            case "due":
                vaccine_status.setImageResource(R.drawable.thumb_up);
                break;
            default:
                vaccine_status.setImageResource(R.drawable.alert);
        }

        return convertView;
    }

}
