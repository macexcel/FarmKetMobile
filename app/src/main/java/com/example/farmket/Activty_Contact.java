package com.example.farmket;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class Activty_Contact extends Activity {

    private String fName;
    private int imgPath;
    private TextView FarmerName;
    private ImageView FarmerImg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_layout);

        // Get info of Chosen Product from previous Actvity
        Intent intent = getIntent();
        fName = intent.getStringExtra(Activity_ProdA.PRODUCER);
        imgPath = intent.getIntExtra(Activity_ProdA.PRODUCER_IMAGE_PATH,0);


        // Display on a smaller layout
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int)(width*.8),(int)(height*.7));

        // Set TextView to Farmer's Name
        FarmerName = (TextView)findViewById(R.id.txtFarmerName);
        FarmerName.setText(fName);

        FarmerImg = (ImageView)findViewById(R.id.imgFarmer);
        FarmerImg.setImageResource(imgPath);

    }
}