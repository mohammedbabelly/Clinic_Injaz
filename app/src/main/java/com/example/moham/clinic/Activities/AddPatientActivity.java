package com.example.moham.clinic.Activities;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.util.Log;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.moham.clinic.Adapters.DayAdapter;
import com.example.moham.clinic.Adapters.WeakAdapter2;
import com.example.moham.clinic.Extra.URL;
import com.example.moham.clinic.Fragments.DatePickerFrag;
import com.example.moham.clinic.Fragments.DayFragment;
import com.example.moham.clinic.Lists.ListDay;
import com.example.moham.clinic.Lists.ListWeak2;
import com.example.moham.clinic.R;
import com.example.moham.clinic.Fragments.TimePickerFrag;
import com.example.moham.clinic.SQLite.DataBaseHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import es.dmoral.toasty.Toasty;
import maes.tech.intentanim.CustomIntent;
import me.anwarshahriar.calligrapher.Calligrapher;

public class AddPatientActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener, DatePickerDialog.OnDateSetListener {
    TextView tvTime, tvDate;
    EditText etId;
    RadioGroup radioGroup;
    RadioButton radioButton;
    String kindOfSession = "", id, firstName,lastName, day, date, time;
    boolean done=false;
    DataBaseHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_patient);
        getSupportActionBar().setTitle("إضافة موعد");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tvTime = findViewById(R.id.tvTime);
        tvDate = findViewById(R.id.tvDate);
        etId = findViewById(R.id.etid);
        radioGroup = findViewById(R.id.radioGroup);
        Bundle b = getIntent().getExtras();
        id = b.getString("id");
        time=b.getString("time");
        firstName=b.getString("firstName");

        etId.setText(id);
        tvTime.setText(time);
        Calligrapher calligrapher = new Calligrapher(getApplicationContext());
        calligrapher.setFont(this, "Tajawal-Regular.ttf", true);
    }

    @Override
    public void finish() {
        super.finish();
        CustomIntent.customType(AddPatientActivity.this, "left-to-right");
    }

    public void cvDatePicker(View view) {
        DialogFragment datePicker = new DatePickerFrag();
        datePicker.show(getSupportFragmentManager(), "date picker");

    }

    public void cvTimePicker(View view) {
        DialogFragment timePicker = new TimePickerFrag();
        timePicker.show(getSupportFragmentManager(), "time picker");
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

        tvTime.setText(hourOfDay + ":" + minute);
        time=tvTime.getText().toString();
        //Toast.makeText(this, "الساعة " + hourOfDay + ":" + minute, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDateSet(DatePicker view, int year1, int month1, int dayOfMonth) {

        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year1);
        c.set(Calendar.MONTH, month1);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);

        tvDate.setText(String.valueOf(year1) + '-' + String.valueOf(month1 + 1) + '-' + String.valueOf(dayOfMonth));
        getTheNameOfTheDay(c.get(Calendar.DAY_OF_WEEK));
       // Toast.makeText(this, day, Toast.LENGTH_SHORT).show();

    }

    public void buAdd(View view) {
        id = etId.getText().toString();
        date = tvDate.getText().toString();
        //time = tvTime.getText().toString();
        if (tvTime.getText().toString() == "" || tvDate.getText().equals("") ||id.equals("") || kindOfSession.equals(""))
            Toasty.error(this, "الرجاء إدخال جميع المعلومات!", Toast.LENGTH_SHORT).show();

         else {
            OnLoad(view);
        }


    }

    public void checkButton(View view) {
        int radioId = radioGroup.getCheckedRadioButtonId();

        radioButton = findViewById(radioId);

        kindOfSession = radioButton.getText().toString();

    }

    public void getTheNameOfTheDay(int num) {
        if (num == 1) {
            day = "الأحد";
        } else if (num == 2) {
            day = "الاثنين";
        } else if (num == 3) {
            day = "الثلاثاء";
        } else if (num == 4) {
            day = "الأربعاء";
        } else if (num == 5) {
            day = "الخميس";
        } else if (num == 7) {
            day = "السبت";
        } else if (num == 6) {
            day = "الجمعة";
        }
    }

    public void OnLoad(View view) {
        URL e=new URL();
        String _URL = e.getURL1()+"read_detail.php/";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, _URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String success = jsonObject.getString("success");
                    if (success.equals("1"))
                    {
                        Toasty.success(getApplicationContext(), "تم تسجيل موعد المريض "  + " بنجاح", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    }

                    else {
                        Toasty.error(AddPatientActivity.this, "الوقت محجوز!", Toast.LENGTH_SHORT).show();

                        done = false;
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    Toasty.error(AddPatientActivity.this, "الوقت خطأ!", Toast.LENGTH_SHORT).show();
                    done = false;
                }

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toasty.error(getApplicationContext(), "لايوجد اتصال بالانترنت!!! " , Toast.LENGTH_LONG).show();
                        myDB = new DataBaseHelper(getApplicationContext());
                        myDB.insertAdded(firstName+" "+lastName,kindOfSession,time) ;
                        Toast.makeText(AddPatientActivity.this, firstName+" "+lastName, Toast.LENGTH_SHORT).show();
                        Toast.makeText(AddPatientActivity.this, "kind: "+kindOfSession, Toast.LENGTH_SHORT).show();
                        Toast.makeText(AddPatientActivity.this, "time: "+time, Toast.LENGTH_SHORT).show();



                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parms = new HashMap<>();
                parms.put("date", date);
                parms.put("day", day);
                parms.put("time", time);
                parms.put("kind", kindOfSession);
                parms.put("id", id);
                return parms;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);


    }

    public void ivSearch(View view) {
        this.finish();
        startActivity(new Intent(getApplicationContext(), SearchingActivity.class));
        CustomIntent.customType(AddPatientActivity.this, "left-to-right");
    }

    @Override
    public void onBackPressed() {
        this.finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.back_arrow, menu);
        return true; }

    public void search(MenuItem item) {
        super.startActivity(new Intent(this,SearchingActivity.class));
    }

    public void showFraqment(Class fragmentClass) {
        Fragment fragment = null;
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.day, fragment).commit();

    }


    public void buTest(View view) {
        id = etId.getText().toString();
        date = tvDate.getText().toString();
        OnLoad1(view);

    }
    public void OnLoad1(final View view) {
        URL e=new URL();
        //String _URL = e.getURL1()+"login.php/";
        //String _URL="http://192.168.1.4:81/test/insert.php/";
        String _URL="http://injazmediagroups.com/clinicApi/test.php";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, _URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String success = jsonObject.getString("success");
                    Toast.makeText(AddPatientActivity.this, jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                    JSONArray jsonArray = jsonObject.getJSONArray("read");
                    if (success.equals("1")) {
//                        for (int i = 0; i < jsonArray.length(); i++) {
//                            JSONObject object = jsonArray.getJSONObject(i);
//                            Toast.makeText(AddPatientActivity.this, object.getString("name"), Toast.LENGTH_SHORT).show();
//                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    //Toasty.success(getApplicationContext(), "لا يوجد مواعيد اليوم", Toast.LENGTH_SHORT).show();
                    Toasty.error(getApplicationContext(), "!!!"+ e.toString(), Toast.LENGTH_SHORT).show();

                }

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(AddPatientActivity.this, error.toString(), Toast.LENGTH_LONG).show();
                        Toasty.error(getApplicationContext(), "لايوجد اتصال بالانترنت!!! " , Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parms = new HashMap<>();
                parms.put("name", "محمد");
                parms.put("age","22");

                return parms;
            }
        };


        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);


    }
}
