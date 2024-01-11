package com.example.healthcareautomation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ChildAdapter extends BaseAdapter {
    Context context;
    ArrayList <Child> children;

    public ChildAdapter(Context context, ArrayList<Child> children) {
        this.context = context;
        this.children = children;
    }

    @Override
    public int getCount() {
        return children.size();
    }

    @Override
    public Child getItem(int position) {
        return children.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.child_item,parent,false);
        }
        TextView name = convertView.findViewById(R.id.childName);
        TextView fname = convertView.findViewById(R.id.childFname);
        TextView relation = convertView.findViewById(R.id.childRelation);
        TextView dob = convertView.findViewById(R.id.childDob);
        TextView gender = convertView.findViewById(R.id.childGender);
        TextView family = convertView.findViewById(R.id.childFamily);
        ImageView status = convertView.findViewById(R.id.child_vaccination_status);

        Child child = getItem(position);
        name.setText(child.getName());
        fname.setText(child.getFatherName());
        dob.setText(child.getDob());
        family.setText("F# "+child.getFamily_no());

        if(child.getRelation()=="son")
        {
            relation.setText("S/O");
        }
        else if(child.getRelation()=="daughter")
        {
            relation.setText("D/O");
        }

        if(child.getGender().equals("male")){
            gender.setText("M");
        }
        else{
            gender.setText("F");
        }

        if(child.isVaccinationCompleted() || position==1){
            status.setImageResource(R.drawable.verified);
        }
        else{
            status.setImageResource(R.drawable.progressing);
        }
        Vaccine[] vaccineSet = child.getVaccines();
        for(int i=0;i<6;i++){
            // setting views just to check views:
            int x = 2+ i*2;
            vaccineSet[i].setDate(x+"/"+(i+2)+"/2020");
            if(i==0){
                vaccineSet[i].setStatus("done");
            }
        }
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context,VaccinationDetails.class);
                Person p = (Person) child;
                i.putExtra("person",p);
                i.putExtra("vaccine",vaccineSet);
                context.startActivity(i);
            }
        });

        return convertView;
    }
}
