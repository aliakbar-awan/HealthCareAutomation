package com.example.healthcareautomation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MedicineAdapter extends BaseAdapter {

    Context context;
    List<Medicine> medicineList;
    boolean canDeleteItem;

    // I added a boolean variable check if each item can be deleted or not, this will help in re-usability of this adapter
    public MedicineAdapter(@NonNull Context context, ArrayList<Medicine> medicines, boolean canDeleteItem){
        this.context = context;
        this.medicineList = medicines;
        this.canDeleteItem = canDeleteItem;
    }

    public void addItem(Medicine medicine){
        boolean alreadyPresent = false;
        for(Medicine i : medicineList){
            if (i.getName().equals(medicine.getName())){
                alreadyPresent = true;
            }
        }
        if(!alreadyPresent && !medicine.getName().equals("-- select medicine --")){
            medicineList.add(medicine);
            notifyDataSetChanged();
        }

    }

    @Override
    public int getCount() {
        return medicineList.size();
    }

    @Override
    public Medicine getItem(int position) {
        return medicineList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView==null){
            if(canDeleteItem){
                convertView = LayoutInflater.from(context).inflate(R.layout.medicine_item,parent,false);
            }
            else{
                convertView = LayoutInflater.from(context).inflate(R.layout.patient_details_item,parent,false);
            }
        }

        Medicine medicine = getItem(position);
        TextView name = convertView.findViewById(R.id.medicine_name);
        TextView quantity = convertView.findViewById(R.id.med_quantity);
        name.setText(medicine.getName());
        quantity.setText(String.valueOf(medicine.getQuantity()));

        if(canDeleteItem){
            ImageView delMedicine = convertView.findViewById(R.id.deleteImage);
            delMedicine.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    medicineList.remove(position);
                    notifyDataSetChanged();
                }
            });
        }

        return convertView;
    }


}
