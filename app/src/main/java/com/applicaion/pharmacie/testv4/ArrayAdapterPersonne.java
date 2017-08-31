package com.applicaion.pharmacie.testv4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Carly Baja on 8/24/2017.
 */

public class ArrayAdapterPersonne extends ArrayAdapter<Personne> {

    //constructor
    public ArrayAdapterPersonne(Context context, ArrayList<Personne> tchalaList)
    {
        super(context, android.R.layout.simple_list_item_1, tchalaList);
    }

    //custom view to populate data
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Personne newPersonne = getItem(position);
        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_personne, parent, false);
        }

        //Find views

        TextView nom = (TextView) convertView.findViewById(R.id.tvNom);
        TextView prenom = (TextView) convertView.findViewById(R.id.tvPrenom);

        //populate data
        nom.setText(newPersonne.getNom());
        prenom.setText(newPersonne.getPrenom());

        return convertView;
    }
}
