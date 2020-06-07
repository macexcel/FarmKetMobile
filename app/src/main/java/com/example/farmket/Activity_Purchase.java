package com.example.farmket;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;


public class Activity_Purchase extends Activity {

    DatabaseHelper myDb;

    private TextView PriceAmount, FarmerName, TotalAmt;
    private EditText Amount;
    private String Item, Name, Price, Weight;

    private Button Submit, btnadd, btnsubt;
    private int imgfarmPath, imgprodPath, Total;
    private ImageView imgProd, imgFarmer;
    private TextWatcher text = null;
    private int tempamt = 0;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.purchase_layout);
        myDb = new DatabaseHelper(this);

        // Get info of Chosen Product from previous Actvity
        Intent intent = getIntent();
        Item = intent.getStringExtra(Activity_ProdA.PRODUCT_NAME);
        Name = intent.getStringExtra(Activity_ProdA.PRODUCER);
        Price = intent.getStringExtra(Activity_ProdA.PRODUCT_PRICE);
        Weight = intent.getStringExtra(Activity_ProdA.PRODUCT_WEIGHT);
        imgfarmPath = intent.getIntExtra(Activity_ProdA.PRODUCER_IMAGE_PATH,0);
        imgprodPath = intent.getIntExtra(Activity_ProdA.PRODUCT_IMAGE_PATH,0);


        // Display on a smaller layout
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.8),(int)(height*.7));

        // getting Widgets
        FarmerName = (TextView)findViewById(R.id.txtFarmerName);
        PriceAmount = (TextView)findViewById(R.id.txtPriceAmount);
        Submit = (Button)findViewById(R.id.btnSubmit);
        btnadd = (Button)findViewById(R.id.btnadd);
        btnsubt = (Button)findViewById(R.id.btnsubt);
        Amount = (EditText)findViewById(R.id.inpAmt);
        TotalAmt = (TextView)findViewById(R.id.txtTotal);
        imgProd = (ImageView)findViewById(R.id.imgProduct);
        imgFarmer = (ImageView)findViewById(R.id.imgFarmer);


        // setting Widgets
        imgProd.setImageResource(imgprodPath);
        imgFarmer.setImageResource(imgfarmPath);
        FarmerName.setText("[Producer] " + Name + "'s Price:");
        PriceAmount.setText(Price +" / "+Weight);

        text = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                TotalAmt.setText("Total: Php "+ Integer.parseInt(Price.substring(4,6)) * Integer.parseInt(Amount.getText().toString()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };

        Amount.addTextChangedListener(text);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempamt = Integer.parseInt(Amount.getText().toString());
                tempamt += 1;
                Amount.setText(String.valueOf(tempamt));
            }
        });

        btnsubt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempamt = Integer.parseInt(Amount.getText().toString());
                if (tempamt > 0) {
                    tempamt -= 1;
                    Amount.setText(String.valueOf(tempamt));
                }else{
                    Amount.setText("0");
                }
            }
        });

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Total = Integer.parseInt(Price.substring(4,6)) * Integer.parseInt(Amount.getText().toString());
                Toast.makeText(getApplicationContext(), "Amount Added: Php"+Total, Toast.LENGTH_LONG).show();
                AddData(Item, Name, Integer.parseInt(Price.substring(4,6)), Weight, tempamt,Total);
                Log.d("DATABASE","DATABASE: " + myDb.getAllData().toString());
                Intent intent = new Intent(Activity_Purchase.this,SecondActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

    }


    public void AddData(String item, String name, Integer price, String weight, Integer amount, Integer total){
        boolean isInserted = myDb.insertData(item, name, price, weight, amount, total);
        if(isInserted==true) {
            System.out.println("DATABASE: " + myDb.getAllData().toString());
            Toast.makeText(Activity_Purchase.this, "Successfully added to Cart", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(Activity_Purchase.this, "Error added to Cart", Toast.LENGTH_SHORT).show();
    }
}
