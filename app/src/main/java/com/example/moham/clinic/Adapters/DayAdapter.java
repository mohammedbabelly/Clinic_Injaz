package com.example.moham.clinic.Adapters;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.moham.clinic.Activities.AddPatientActivity;
import com.example.moham.clinic.Activities.MainActivity;
import com.example.moham.clinic.Extra.URL;
import com.example.moham.clinic.Lists.ListDay;
import com.example.moham.clinic.R;
import com.example.moham.clinic.SQLite.DataBaseHelper;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.dmoral.toasty.Toasty;


public class DayAdapter extends RecyclerView.Adapter<DayAdapter.ViewHolder> {


    private List<ListDay> listItems;
    public String clickedTime,clickedFullname,clickedStatus;
    DataBaseHelper myDB;

    public DayAdapter(List<ListDay> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    private Context context;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.list_day,parent,false);
        Animation animation=AnimationUtils.loadAnimation(context,R.anim.slide_left);
        v.startAnimation(animation);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final ListDay listDay=listItems.get(position);
       holder.patientName.setText(listDay.getPatientName());
        holder.patientStatus.setText(listDay.getPatientStatus());
        holder.time.setText(listDay.getTime());


        holder.cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickedTime=holder.time.getText().toString();
                clickedStatus=holder.patientStatus.getText().toString();
                clickedFullname=holder.patientName.getText().toString();

                OnLoad(v);


            }
        });

    }
    public void OnLoad(View view) {
        URL e=new URL();
        String _URL = e.getURL1()+"delete.php/";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, _URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String success = jsonObject.getString("success");
                    if (success.equals("1"))
                    {
                        Toasty.info(context, "تم حذف موعد المريض "  + " بنجاح", Toast.LENGTH_SHORT).show();

                    }



                } catch (JSONException e) {
                    e.printStackTrace();
                    Toasty.error(context, "1!", Toast.LENGTH_SHORT).show();
                }}},
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Toasty.error(context, "!!! " , Toast.LENGTH_LONG).show();
                        myDB = new DataBaseHelper(context);
                        myDB.insertDeleted(clickedFullname,clickedStatus,clickedTime) ;
                        myDB.deleteData(clickedTime);
                        Toasty.info(context, "تم حذف موعد المريض "  + " بنجاح", Toast.LENGTH_SHORT).show();




                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parms = new HashMap<>();
                parms.put("time", clickedTime);

                return parms;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);


    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView patientName,patientStatus,time;
        public CardView cardView;
        public ImageView cancel;

        public ViewHolder(View itemView) {
            super(itemView);
            patientName=(TextView) itemView.findViewById(R.id.patientName);
            patientStatus=(TextView) itemView.findViewById(R.id.patientStatus);
            time=(TextView) itemView.findViewById(R.id.time);
            cardView=(CardView) itemView.findViewById(R.id.cardDay);
            cancel=itemView.findViewById(R.id.cancel);

        }
    }
}
