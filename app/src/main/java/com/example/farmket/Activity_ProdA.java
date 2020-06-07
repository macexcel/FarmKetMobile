package com.example.farmket;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.service.chooser.ChooserTargetService;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import org.w3c.dom.Text;

public class Activity_ProdA extends Activity {

    public static final String PRODUCT_NAME = "com.example.farmket.PRODUCT_NAME";
    public static final String PRODUCT_PRICE = "com.example.farmket.PRODUCT_PRICE";
    public static final String PRODUCT_WEIGHT = "com.example.farmket.PRODUCT_WEIGHT";
    public static final String PRODUCER = "com.example.farmket.PRODUCER";
    public static final String PRODUCER_IMAGE_PATH = "com.example.farmket.PRODUCER_IMAGE_PATH";
    public static final String PRODUCT_IMAGE_PATH = "com.example.farmket.PRODUCT_IMAGE_PATH";


    private Button btnFarmA, btnFarmB, btnFarmC;
    private TextView PriceA, PriceB, PriceC;
    private TextView NameA, NameB, NameC;
    private ImageView imgFarmA, imgFarmB, imgFarmC;

    private String FarmerName, Weight;
    private Integer resImg;
    private String Price;
    private String Temp[];
    private int ProductImg;
    private String ChosenProduct;



    private Button contactA, contactB, contactC;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.proda_layout);

        // Get info of Chosen Product from previous Actvity
        Intent intent = getIntent();
        ChosenProduct = intent.getStringExtra(SecondActivity.PRODUCT_NAME);
        ProductImg = intent.getIntExtra(SecondActivity.PRODUCT_IMAGE_PATH,0);

        //Get information from layout
        imgFarmA = (ImageView)findViewById(R.id.imgFarmA);
        imgFarmB = (ImageView)findViewById(R.id.imgFarmB);
        imgFarmC = (ImageView)findViewById(R.id.imgFarmC);

        btnFarmA = (Button)findViewById(R.id.btnPurchaseA);
        btnFarmB = (Button)findViewById(R.id.btnPurchaseB);
        btnFarmC = (Button)findViewById(R.id.btnPurchaseC);

        PriceA = (TextView)findViewById(R.id.txtFarmerAPrice);
        PriceB = (TextView)findViewById(R.id.txtFarmerBPrice);
        PriceC = (TextView)findViewById(R.id.txtFarmerCPrice);

        NameA = (TextView)findViewById(R.id.txtFarmerAName);
        NameB = (TextView)findViewById(R.id.txtFarmerBName);
        NameC = (TextView)findViewById(R.id.txtFarmerCName);

        contactA = (Button)findViewById(R.id.btnContactA);
        contactB = (Button)findViewById(R.id.btnContactB);
        contactC = (Button)findViewById(R.id.btnContactC);


        // Display on a smaller layout
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.9),(int)(height*.8));

        btnFarmA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resImg = R.drawable.farmera;
                FarmerName = NameA.getText().toString();
                Temp = PriceA.getText().toString().split("/");
                Price = Temp[0];
                Weight = Temp[1];
                Purchase(ChosenProduct, Price, Weight, FarmerName, resImg);
            }
        });

        contactA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resImg = R.drawable.farmera;
                FarmerName = NameA.getText().toString();
                Contact(FarmerName, resImg);
            }
        });

        btnFarmB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resImg = R.drawable.farmerb;
                FarmerName = NameB.getText().toString();
                Temp = PriceB.getText().toString().split("/");
                Price = Temp[0];
                Weight = Temp[1];
                Purchase(ChosenProduct, Price, Weight, FarmerName, resImg);
            }
        });

        contactB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resImg = R.drawable.farmerb;
                FarmerName = NameB.getText().toString();
                Contact(FarmerName, resImg);
            }
        });

        btnFarmC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resImg = R.drawable.farmerc;
                FarmerName = NameC.getText().toString();
                Temp = PriceC.getText().toString().split("/");
                Price = Temp[0];
                Weight = Temp[1];
                Purchase(ChosenProduct, Price, Weight, FarmerName, resImg);
            }
        });

        contactC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resImg = R.drawable.farmerc;
                FarmerName = NameC.getText().toString();
                Contact(FarmerName, resImg);
            }
        });

    }

    private void Purchase(String product, String Price, String Weight, String Farmername, Integer Farmerimg ){
        Intent i = new Intent(Activity_ProdA.this, Activity_Purchase.class);
        i.putExtra(PRODUCT_NAME, product);
        i.putExtra(PRODUCT_PRICE, Price);
        i.putExtra(PRODUCT_WEIGHT, Weight);
        i.putExtra(PRODUCER, Farmername);
        i.putExtra(PRODUCER_IMAGE_PATH, Farmerimg);
        i.putExtra(PRODUCT_IMAGE_PATH, ProductImg);
        startActivity(i);
    }

    private void Contact(String Farmername, Integer Farmerimg){
        Intent i = new Intent(Activity_ProdA.this, Activty_Contact.class);
        i.putExtra(PRODUCER, Farmername);
        i.putExtra(PRODUCER_IMAGE_PATH, Farmerimg);
        startActivity(i);
    }

}
