package com.example.moham.clinic.Adapters;

import android.content.Context;
import android.graphics.Color;
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


import com.example.moham.clinic.Extra.CurrentDate;
import com.example.moham.clinic.Lists.ListWeak;
import com.example.moham.clinic.R;

import java.util.List;




public class WeakAdapter extends RecyclerView.Adapter<WeakAdapter.ViewHolder> {


    private List<ListWeak> listItems;

    public WeakAdapter(List<ListWeak> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    private Context context;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.list_weak,parent,false);
        Animation animation=AnimationUtils.loadAnimation(context,R.anim.scale);
        v.startAnimation(animation);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final ListWeak listWeak=listItems.get(position);
        holder.time.setText("12:30");
        holder.t6.setText("معاينة محمد");
        CurrentDate currentDate=new CurrentDate();


         if(currentDate.getNumOfToday()==1) holder.t1.setBackgroundColor(Color.parseColor("#BABABA"));
        else if(currentDate.getNumOfToday()==2) holder.t2.setBackgroundColor(Color.parseColor("#BABABA"));
        else if(currentDate.getNumOfToday()==3) holder.t3.setBackgroundColor(Color.parseColor("#BABABA"));
        else if(currentDate.getNumOfToday()==4) holder.t4.setBackgroundColor(Color.parseColor("#BABABA"));
        else if(currentDate.getNumOfToday()==5) holder.t5.setBackgroundColor(Color.parseColor("#BABABA"));
        else if(currentDate.getNumOfToday()==7) holder.t6.setBackgroundColor(Color.parseColor("#BABABA"));





        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(context, "u clicked ", Toast.LENGTH_SHORT).show();
            }
        });




    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView time,t1,t2,t3,t4,t5,t6;
        public CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            time=itemView.findViewById(R.id.t0);//TIME
            t1=itemView.findViewById(R.id.t1);//SUNDAY
            t2=itemView.findViewById(R.id.t2);
            t3=itemView.findViewById(R.id.t3);
            t4=itemView.findViewById(R.id.t4);
            t5=itemView.findViewById(R.id.t5);
            t6=itemView.findViewById(R.id.t6);//SATURDAY

            cardView=itemView.findViewById(R.id.card);

        }
    }
}
