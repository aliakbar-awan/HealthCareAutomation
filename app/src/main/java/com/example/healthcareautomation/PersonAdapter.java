package com.example.healthcareautomation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;


public class PersonAdapter extends ArrayAdapter <Person> {
    private Context context;
    private List<Person> personList;

    public PersonAdapter(@NonNull Context context1, ArrayList<Person>list) {
        super(context1,0,list);
        context = context1;
        personList = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;

        if(listItem == null)
            listItem = LayoutInflater.from(context).inflate(R.layout.person_view,parent,false);

        Person p = personList.get(position);
        TextView name = listItem.findViewById(R.id.personName);
        name.setText(p.name);

        TextView fname = listItem.findViewById(R.id.personFather);
        fname.setText("S/0 "+p.fatherName);

        TextView gender = listItem.findViewById(R.id.personGender);
        gender.setText(p.gender);

        TextView dob = listItem.findViewById(R.id.personDob);
        dob.setText(p.dob);

        TextView relation = listItem.findViewById(R.id.personRelation);
        relation.setText(p.relation);

        return listItem;
    }

}
