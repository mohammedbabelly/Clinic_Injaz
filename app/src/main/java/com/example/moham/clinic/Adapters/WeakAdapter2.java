package com.example.moham.clinic.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
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
import com.example.moham.clinic.Extra.CurrentDate;
import com.example.moham.clinic.Lists.ListWeak;
import com.example.moham.clinic.Lists.ListWeak2;
import com.example.moham.clinic.R;

import java.util.List;




public class WeakAdapter2 extends RecyclerView.Adapter<WeakAdapter2.ViewHolder> {


    private List<ListWeak2> listItems;

    public WeakAdapter2(List<ListWeak2> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    private Context context;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.list_weak2,parent,false);
        Animation animation=AnimationUtils.loadAnimation(context,R.anim.scale);
        v.startAnimation(animation);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final ListWeak2 listWeak2=listItems.get(position);
        holder.time.setText(listWeak2.getTime());
        holder.name.setText(listWeak2.getName());
       // holder.name.setBackgroundColor(Integer.parseInt("#fff"));
        CurrentDate currentDate=new CurrentDate();


        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.name.getText().equals("________________ "))
                {
                    Toast.makeText(context, "إصافة موعد بالساعة "+holder.time.getText().toString(), Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(context,AddPatientActivity.class);
                    Bundle b=new Bundle();
                    //b.putInt("pos",pos);
                    b.putString("time",holder.time.getText().toString());
                    i.putExtras(b);

                    v.getContext().startActivity(i);
                }

            }
        });




    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView time,name;
        public CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            time=itemView.findViewById(R.id.timeWeak);//TIME
            name=itemView.findViewById(R.id.nameWeak);


            cardView=itemView.findViewById(R.id.cardWeak);

        }
    }
}
