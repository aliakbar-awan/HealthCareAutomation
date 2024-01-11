package com.example.healthcareautomation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PatientAdapter extends BaseAdapter {
    Context context;
    List <Patient> patients;

    public PatientAdapter(Context context, ArrayList<Patient> patients) {
        this.context = context;
        this.patients = patients;
    }

    @Override
    public int getCount() {
        return patients.size();
    }

    @Override
    public Patient getItem(int position) {
        return patients.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.patient_item,parent,false);
        }
        Patient pt = patients.get(position);
        TextView pName = convertView.findViewById(R.id.patient_name);
        TextView pFname = convertView.findViewById(R.id.fathers_name);
        TextView relation = convertView.findViewById(R.id.relation);
        TextView reason = convertView.findViewById(R.id.reason_text);
        TextView date = convertView.findViewById(R.id.patient_date);
        TextView family = convertView.findViewById(R.id.patient_family);
        Button patient_details = convertView.findViewById(R.id.patient_details);

        pName.setText(pt.getName());
        pFname.setText(pt.getFatherName());

        if(pt.getRelation().equals("son")){
            relation.setText("S/O");
        }
        else if(pt.getRelation().equals("wife")){
            relation.setText("W/O");
        }
        else if(pt.getRelation().equals("daughter")){
            relation.setText("D/O");
        }

        reason.setText("Reason: "+pt.getReason());
        date.setText("Registered on: "+pt.getRegistered_on());
        family.setText("F#"+pt.getFamily_no());

        patient_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context,PatientDetails.class);
                Bundle b = new Bundle();
                b.putInt("family",pt.getFamily_no());
                b.putString("name",pt.getName());
                b.putString("fname",pt.getFatherName());

                if(pt.getRelation().equals("son")){
                    b.putString("relation","S/O");
                }
                else if(pt.getRelation().equals("daughter")){
                    b.putString("relation","D/O");
                }
                else if(pt.getRelation().equals("wife")){
                    b.putString("relation","W/O");
                }
                b.putString("reason",pt.getReason());
                b.putString("date",pt.getRegistered_on());
                b.putParcelableArrayList("medicine", pt.getMedicines());
                i.putExtra("patient",b);
                context.startActivity(i);
            }
        });


        return convertView;
    }
}
