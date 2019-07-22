package com.example.moham.clinic.Fragments;


import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.moham.clinic.Adapters.DayAdapter;
import com.example.moham.clinic.Extra.URL;
import com.example.moham.clinic.Extra.test;
import com.example.moham.clinic.Lists.ListDay;
import com.example.moham.clinic.R;
import com.example.moham.clinic.SQLite.DataBaseHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.dmoral.toasty.Toasty;
import me.anwarshahriar.calligrapher.Calligrapher;


/**
 * A simple {@link Fragment} subclass.
 */
public class DayFragment extends Fragment {
    public RecyclerView recyclerView;
    public RecyclerView.Adapter adapter;
    public List<ListDay> listItems;
    ImageView noInternet;
    TextView tvNoInternet;
    ProgressBar progressBar;
    DataBaseHelper myDb;


    public DayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_day, container, false);
        recyclerView = v.findViewById(R.id.rvDay);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) v.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setSubtitle("مواعيد اليوم");

        listItems = new ArrayList<>();
        noInternet =v.findViewById(R.id.ivNoInternet);
        tvNoInternet=v.findViewById(R.id.tvNoInternet);
        progressBar=v.findViewById(R.id.ProgressBar);

        OnLoad(getView());
        Calligrapher calligrapher = new Calligrapher(getContext());
        calligrapher.setFont(getActivity(), "Tajawal-Regular.ttf", true);

        return v;
    }

    public void OnLoad(final View view) {
        URL e=new URL();
        String _URL = e.getURL1()+"login.php/";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, _URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {

                    JSONObject jsonObject = new JSONObject(response);

                    String success = jsonObject.getString("success");
                    JSONArray jsonArray = jsonObject.getJSONArray("data");
                    if (success.equals("1")) {
                        myDb = new DataBaseHelper(getContext());


                       Cursor res= myDb.getDeletedData();
                        while (res.moveToNext()) {
                            dropLoad(getView(),res.getString(2));
                            //Toast.makeText(getContext(), "deleteeeeeeeeed", Toast.LENGTH_SHORT).show();
                        }//until now all the data in deleted_records have deleted
                         myDb.emptyDeleted();
                        myDb.emptyTable();




                            listItems.clear();
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject object = jsonArray.getJSONObject(i);
                            String time="";
                            for (int j=0;j<5;j++) time+=object.getString("Time").charAt(j);

                            ListDay listDay = new ListDay(object.getString("firstName") + " " + object.getString("lastName"), object.getString("type"),time );
                            listItems.add(listDay);

                            myDb.insertData(object.getString("firstName")+" "+object.getString("lastName"),object.getString("type"),time);
                        }
                        adapter = new DayAdapter(listItems, getContext());
                        recyclerView.setAdapter(adapter);
                        Toasty.success(getContext(), "تم التحديث"  , Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.INVISIBLE);


                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    Toasty.success(getContext(), "لا يوجد مواعيد اليوم", Toast.LENGTH_SHORT).show();
                    //Toasty.error(getContext(), "!!!"+ e.toString(), Toast.LENGTH_SHORT).show();
                    //tvNoInternet.setVisibility(View.VISIBLE);
                    showOtherItems();
                    progressBar.setVisibility(View.INVISIBLE);

                }

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                          Toasty.error(getContext(), "لايوجد اتصال بالانترنت!!! " , Toast.LENGTH_LONG).show();
                        //tvNoInternet.setVisibility(View.VISIBLE);
                        //showOtherItems();
                        progressBar.setVisibility(View.INVISIBLE);
                        myDb = new DataBaseHelper(getContext());
                        Cursor res = myDb.getAllData();
                        while (res.moveToNext()) {
                            ListDay listDay = new ListDay(res.getString(0) ,res.getString(1),res.getString(2) );
                            listItems.add(listDay);
                         }
                        adapter = new DayAdapter(listItems, getContext());
                        recyclerView.setAdapter(adapter);


                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parms = new HashMap<>();
                //parms.put("lastname", lastname);

                return parms;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);


    }
    public void dropLoad(View view, final String time1) {
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
                       // Toasty.info(getContext(), "تم حذف موعد المريض "  + " بنجاح", Toast.LENGTH_SHORT).show();

                    }



                } catch (JSONException e) {
                    e.printStackTrace();
                    Toasty.error(getContext(), "1!", Toast.LENGTH_SHORT).show();
                }}},
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {


                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parms = new HashMap<>();
                    parms.put("time", time1);


                return parms;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);


    }

    public void showOtherItems() {
        float startXwelcome = 0 - noInternet.getWidth();
        float endXwelcome = noInternet.getX();

        ObjectAnimator animator = ObjectAnimator.ofFloat(noInternet, View.X, startXwelcome, endXwelcome);
        animator.setDuration(1500);
        noInternet.setVisibility(View.VISIBLE);
        animator.start();

    }
}
