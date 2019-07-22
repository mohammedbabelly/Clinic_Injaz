package com.example.moham.clinic.Activities;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.moham.clinic.Adapters.PatientAdapter;
import com.example.moham.clinic.Adapters.WeakAdapter;
import com.example.moham.clinic.Adapters.WeakAdapter2;
import com.example.moham.clinic.Extra.URL;
import com.example.moham.clinic.Lists.ListPatient;
import com.example.moham.clinic.Lists.ListWeak;
import com.example.moham.clinic.Lists.ListWeak2;
import com.example.moham.clinic.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.dmoral.toasty.Toasty;
import me.anwarshahriar.calligrapher.Calligrapher;

public class Weak2Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    public RecyclerView recyclerView;
    public RecyclerView.Adapter adapter1;
    public List<ListWeak2> listItems;
    TextView tvName;
    String day;
    ProgressBar progressBar;
    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weak2);
        getSupportActionBar().setTitle("مواعيد الاسبوع");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Spinner spinner = findViewById(R.id.spDatOfWeak);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.dayOfWeak, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        recyclerView = findViewById(R.id.rvWeak2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        listItems = new ArrayList<>();
        tvName = findViewById(R.id.nameWeak);
        progressBar=findViewById(R.id.ProgressBar1);
        progressBar.setVisibility(View.INVISIBLE);
        //tvName.setBackgroundColor(getResources().getColor(R.color.black));
        Calligrapher calligrapher = new Calligrapher(getApplicationContext());
        calligrapher.setFont(this, "Tajawal-Regular.ttf", true);

    }

    public void OnLoad(final View view) {
        progressBar.setVisibility(View.VISIBLE);
        URL e = new URL();
        String _URL = e.getURL1() + "weak.php/";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, _URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {

                    JSONObject jsonObject = new JSONObject(response);

                    String success = jsonObject.getString("success");
                    JSONArray jsonArray = jsonObject.getJSONArray("data");
                    if (success.equals("1")) {
                        progressBar.setVisibility(View.INVISIBLE);
                        listItems.clear();

                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject object = jsonArray.getJSONObject(i);
                            String time = getCorrectTime(object.getString("time"));
                            if (object.getString("firstName").equals("null")) {
                                ListWeak2 listWeak2 = new ListWeak2("________________ ", time);
                                listItems.add(listWeak2);
                                //tvName.setBackgroundColor(getResources().getColor(R.color.black));
                            } else {
                                ListWeak2 listWeak2 = new ListWeak2(object.getString("firstName") + " " + object.getString("lastName"), time);
                                listItems.add(listWeak2);

                            }


                        }
                        adapter1 = new WeakAdapter2(listItems, getApplicationContext());
                        recyclerView.setAdapter(adapter1);
                        // llhead.setVisibility(View.VISIBLE);
                        // recyclerView.setVisibility(View.VISIBLE);
                        // progressBar.setVisibility(View.INVISIBLE);
                        //Toast.makeText(getApplicationContext(), "done", Toast.LENGTH_SHORT).show();
                        //progressBar.setVisibility(View.INVISIBLE);


                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toasty.error(getApplicationContext(), "!!! ", Toast.LENGTH_LONG).show();
                    Toast.makeText(Weak2Activity.this, e.toString(), Toast.LENGTH_SHORT).show();

                    //Toast.makeText(getApplicationContext(), "h!!! " + e.toString(), Toast.LENGTH_LONG).show();
                    // llhead.setVisibility(View.INVISIBLE);
                    // recyclerView.setVisibility(View.INVISIBLE);
                    // progressBar.setVisibility(View.INVISIBLE);

                    // Toast.makeText(getContext(), "الرجاء التحقق من الإتصال بالانترنت...!", Toast.LENGTH_SHORT).show();
                    //tvNoInternet.setVisibility(View.VISIBLE);
                    //showOtherItems();
                    //progressBar.setVisibility(View.INVISIBLE);

                }

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
//                        Toasty.error(getApplicationContext(), "لايوجد اتصال بالانترنت!!! " , Toast.LENGTH_LONG).show();

                        Toast.makeText(getApplicationContext(), "failed!!! " + error.toString(), Toast.LENGTH_LONG).show();

                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parms = new HashMap<>();
                parms.put("day", day);
//                Toast.makeText(Weak2Activity.this, "the day is: "+day.toString(), Toast.LENGTH_SHORT).show();

                return parms;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);


    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
//        Toast.makeText(this, "day: "+text, Toast.LENGTH_SHORT).show();
        day = String.valueOf(position - 1);
        if (position != 0) OnLoad(view);
//        Toast.makeText(this, String.valueOf(position-1), Toast.LENGTH_SHORT).show();

        //number 1 refers to the sunday by (position-1)cuz it's 0 and so on...
        //1 -> saturday
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void times() {
        int min = 00, ho = 10;
        for (int i = 0; i < 48; i++) {
            if (min == 60) {
                min = 00;
                ho++;
            }
            if (min == 0)
                // time[i] = String.valueOf(ho) + ":" + String.valueOf(min) + "0";
                //  else
                //  time[i] = String.valueOf(ho) + ":" + String.valueOf(min);

                min += 15;
        }

    }

    public String getCorrectTime(String t) {
        String time = "";
        for (int i = 0; i < 5; i++) {
            time += t.charAt(i);
        }
        return time;
    }
}
