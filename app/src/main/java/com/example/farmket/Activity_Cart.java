package com.example.farmket;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Activity_Cart extends Activity {

    DatabaseHelper myDb;
    ListView l1;
    ArrayList<cart> arrayList;
    MyAdapter myAdapter;
    private TextView TotalAmt;
    private Integer TotalAmount = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_cart);

        //TotalAmt = (TextView)findViewById(R.id.txtTotalAmt);
        //getTotalAmt();
        //TotalAmt.setText("Total Amount: " + TotalAmount);

        // Display on a smaller layout
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int) (width * .9), (int) (height * .8));

        l1 = (ListView)findViewById(R.id.listview);
        myDb = new DatabaseHelper(this);
        arrayList = new ArrayList<>();
        loadDataInListView();
    }

    private void loadDataInListView(){
        arrayList = myDb.getAllData();
        myAdapter = new MyAdapter(this, arrayList);
        l1.setAdapter(myAdapter);
    }

    private void getTotalAmt(){
        int temp = 0;
        Cursor res = myDb.getData();
        while (res.moveToNext()){
            temp = temp + res.getInt(6);
        }
        TotalAmount = temp;
    }
}
