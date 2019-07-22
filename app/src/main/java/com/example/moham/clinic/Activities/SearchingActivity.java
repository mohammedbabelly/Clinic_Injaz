package com.example.moham.clinic.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.moham.clinic.Adapters.DayAdapter;
import com.example.moham.clinic.Adapters.PatientAdapter;
import com.example.moham.clinic.Extra.URL;
import com.example.moham.clinic.Lists.ListDay;
import com.example.moham.clinic.Lists.ListPatient;
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

public class SearchingActivity extends AppCompatActivity {
    EditText etfirstName, etlastName, etfatherName;
    String firstName, lastName;
    LinearLayout llhead;
    ProgressBar progressBar;

    public RecyclerView recyclerView;
    public RecyclerView.Adapter adapter;
    public List<ListPatient> listPatients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searching);
        getSupportActionBar().setTitle("بحث عن مريض");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        etfirstName = findViewById(R.id.etfirstName);
        etlastName = findViewById(R.id.etlastName);
         llhead=findViewById(R.id.llhead);
         progressBar=findViewById(R.id.pbSearching);
        Calligrapher calligrapher = new Calligrapher(getApplicationContext());
        calligrapher.setFont(this, "Tajawal-Regular.ttf", true);
    }

    public void buSearch(View view) {
        progressBar.setVisibility(View.VISIBLE);
        recyclerView = findViewById(R.id.rvPatient);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        listPatients = new ArrayList<>();
        firstName = etfirstName.getText().toString();
        lastName = etlastName.getText().toString();
        //fatherName = etfatherName.getText().toString();
        if(firstName.equals("")&&lastName.equals("")) {
            Toasty.error(this, "الرجاء إدخال أي معلومة عن المريض!!!", Toast.LENGTH_SHORT).show();
            progressBar.setVisibility(View.INVISIBLE);
        }
        else OnLoad(view);
    }
    public void OnLoad(final View view) {
        URL e=new URL();
        String _URL = e.getURL1()+"search.php/";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, _URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {

                    JSONObject jsonObject = new JSONObject(response);

                    String success = jsonObject.getString("success");
                    JSONArray jsonArray = jsonObject.getJSONArray("data");
                    if (success.equals("1")) {

                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject object = jsonArray.getJSONObject(i);

                            ListPatient listPatient = new ListPatient(object.getString("firstName") , object.getString("lastName"), object.getString("fatherName"),object.getString("idPatient"));
                            listPatients.add(listPatient);
                        }
                        adapter = new PatientAdapter(listPatients, getApplicationContext());
                        recyclerView.setAdapter(adapter);
                        llhead.setVisibility(View.VISIBLE);
                        recyclerView.setVisibility(View.VISIBLE);
                        progressBar.setVisibility(View.INVISIBLE);
                        //Toast.makeText(getApplicationContext(), "done", Toast.LENGTH_SHORT).show();
                        //progressBar.setVisibility(View.INVISIBLE);


                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    //Toast.makeText(getApplicationContext(), "h!!! " + e.toString(), Toast.LENGTH_LONG).show();
                    Toasty.info(SearchingActivity.this, "لا يوجد مريض بهذا الإسم!", Toast.LENGTH_SHORT).show();
                    llhead.setVisibility(View.INVISIBLE);
                    recyclerView.setVisibility(View.INVISIBLE);
                    progressBar.setVisibility(View.INVISIBLE);

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
                        Toasty.error(getApplicationContext(), "لايوجد اتصال بالانترنت!!! " , Toast.LENGTH_LONG).show();

                        //Toast.makeText(getApplicationContext(), "failed!!! " + error.toString(), Toast.LENGTH_LONG).show();
                        llhead.setVisibility(View.INVISIBLE);
                        recyclerView.setVisibility(View.INVISIBLE);
                        progressBar.setVisibility(View.INVISIBLE);

                        // Toast.makeText(getContext(), "الرجاء التحقق من الإتصال بالانترنت...!", Toast.LENGTH_SHORT).show();
                        //tvNoInternet.setVisibility(View.VISIBLE);
                        //showOtherItems();
                        //progressBar.setVisibility(View.INVISIBLE);


                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parms = new HashMap<>();
                parms.put("firstName",firstName);
                parms.put("lastName", lastName);

                return parms;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);


    }
}
