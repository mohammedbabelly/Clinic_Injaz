package com.example.moham.clinic.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;


import com.example.moham.clinic.Activities.AddPatientActivity;
import com.example.moham.clinic.Activities.MainActivity;
import com.example.moham.clinic.Activities.SearchingActivity;
import com.example.moham.clinic.Activities.weakActivity;
import com.example.moham.clinic.Lists.ListDay;
import com.example.moham.clinic.Lists.ListPatient;
import com.example.moham.clinic.R;

import java.util.List;

import maes.tech.intentanim.CustomIntent;


public class PatientAdapter extends RecyclerView.Adapter<PatientAdapter.ViewHolder> {
    String id="-1";
    int pos;


    private List<ListPatient> listItems;

    public PatientAdapter(List<ListPatient> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    private Context context;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_patient, parent, false);
        Animation animation = AnimationUtils.loadAnimation(context, R.anim.slide_left);
        v.startAnimation(animation);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final ListPatient listPatient = listItems.get(position);
        holder.firstName.setText(listPatient.getName1());
        holder.lastName.setText(listPatient.getName2());
        holder.fatherName.setText(listPatient.getName3());
        holder.id.setText(listPatient.getId());



        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pos=holder.getAdapterPosition();

              //  Toast.makeText(context, String.valueOf(pos), Toast.LENGTH_SHORT).show();
                Intent i=new Intent(context,AddPatientActivity.class);
                Bundle b=new Bundle();
                b.putInt("pos",pos);
                b.putString("id",holder.id.getText().toString());
                i.putExtras(b);

                v.getContext().startActivity(i);
                 //Toast.makeText(context, "hhhhh", Toast.LENGTH_SHORT).show();
                //startActivity(new Intent(context, weakActivity.class));
                //CustomIntent.customType(MainActivity.this, "left-to-right");


            }
        });


    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView firstName, lastName, fatherName, id;
        public CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            firstName = itemView.findViewById(R.id.tvfirstName);
            lastName = itemView.findViewById(R.id.tvlastName);
            fatherName = itemView.findViewById(R.id.tvfatherName);
            id=itemView.findViewById(R.id.tvid);
            cardView = itemView.findViewById(R.id.cvSearching);

        }
    }
}
