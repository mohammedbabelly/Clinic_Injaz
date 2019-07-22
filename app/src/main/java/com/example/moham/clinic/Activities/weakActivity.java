package com.example.moham.clinic.Activities;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.example.moham.clinic.Adapters.WeakAdapter;
import com.example.moham.clinic.Lists.ListWeak;
import com.example.moham.clinic.R;
import com.example.moham.clinic.SQLite.DataBaseHelper;

import java.util.ArrayList;
import java.util.List;

import maes.tech.intentanim.CustomIntent;

public class weakActivity extends AppCompatActivity {
    public RecyclerView recyclerView;
    public RecyclerView.Adapter adapter;
    public List<ListWeak> listItems;
    DataBaseHelper myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weak);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        myDb = new DataBaseHelper(this);
        recyclerView =  findViewById(R.id.rvWeak);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        listItems = new ArrayList<>();

        /*for (int i=0;i<50;i++)
        {
            ListWeak listWeak = new ListWeak();
            listItems.add(listWeak);
        }

        adapter = new WeakAdapter(listItems, getApplicationContext());
        recyclerView.setAdapter(adapter);
*/




        myDb.insertData("Marwa Babelly","student","12:55");
        Cursor res = myDb.getAllData();
        while (res.moveToNext()) {
            Toast.makeText(this, res.getString(0), Toast.LENGTH_SHORT).show();
            Toast.makeText(this, res.getString(1), Toast.LENGTH_SHORT).show();
            Toast.makeText(this, res.getString(2), Toast.LENGTH_SHORT).show();
        }


    }
    public void finish() {
        super.finish();
        CustomIntent.customType(weakActivity.this, "bottom-to-up");
    }

    public void ivBack(View view) {
        this.finish();
    }
}
