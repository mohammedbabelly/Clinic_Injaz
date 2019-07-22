package com.example.moham.clinic.Extra;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.moham.clinic.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class testActivity extends AppCompatActivity {
    ImageView noInternet;
    Button m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        noInternet =findViewById(R.id.ivNoInternet);
        m=findViewById(R.id.kkkkk);

    }

    public void ddd(View view) {
        showOtherItems();
    }
    public void OnLoad(View view) {
        final test t=new test();
        String _URL = "http://192.168.1.12:81/clinicApi/login.php/";

        //final String lastname = Lastname.getText().toString();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, _URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);

                    String success = jsonObject.getString("success");
                    JSONArray jsonArray=jsonObject.getJSONArray("data");
                    if (success.equals("1")) {
                        for (int i=0;i<jsonArray.length();i++)
                        {
                            JSONObject object=jsonArray.getJSONObject(i);
                            String firstName=object.getString("firstName").trim();
                            String lastName=object.getString("lastName".trim());
                            t.setData(object.getString("firstName"),object.getString("lastName"),object.getString("type"),object.getString("Time"));
                            //Toast.makeText(getApplicationContext(),firstName+" "+lastName+ " "+object.getString("Time")+" "+object.getString("type"), Toast.LENGTH_SHORT).show();
                        }

                        Toast.makeText(testActivity.this, "done", Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext() , "failed!!! " + e.toString(), Toast.LENGTH_LONG).show();
                }

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "failed!!! " + error.toString(), Toast.LENGTH_LONG).show();


                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parms = new HashMap<>();
                //parms.put("lastname", lastname);

                return parms;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);


    }

    public void fff(View view) {
        test t=new test();
        Toast.makeText(this, "tSize= "+String.valueOf(t.getSize()), Toast.LENGTH_SHORT).show();
    }
    public void showOtherItems() {
        float startXwelcome = 0 - noInternet.getWidth();
        float endXwelcome = noInternet.getX();

        ObjectAnimator animator = ObjectAnimator.ofFloat(noInternet, View.X, startXwelcome, endXwelcome);
        animator.setDuration(1500);
        noInternet.setVisibility(View.VISIBLE);
        animator.start();

        PropertyValuesHolder scaleXholder = PropertyValuesHolder.ofFloat(View.SCALE_X, 1f);
        PropertyValuesHolder scaleYholder = PropertyValuesHolder.ofFloat(View.SCALE_Y, 1f);




    }
}
