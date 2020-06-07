package com.example.farmket;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.nio.Buffer;

public class SecondActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    public static final String PRODUCT_NAME = "com.example.farmket.PRODUCT_NAME";
    public static final String PRODUCT_IMAGE_PATH = "com.example.farmket.PRODUCT_IMAGE_PATH";

    private Button btnProdA, btnProdB, btnProdC, btnProdD, btnProdE;
    private ImageButton btnCart, btnMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        myDb = new DatabaseHelper(this);

        btnCart = (ImageButton)findViewById(R.id.btngoCart);
        btnMessage = (ImageButton)findViewById(R.id.btnMessages);
        btnProdA = (Button)findViewById(R.id.btnProdA);
        btnProdB = (Button)findViewById(R.id.btnProdB);
        btnProdC = (Button)findViewById(R.id.btnProdC);
        btnProdD = (Button)findViewById(R.id.btnProdD);
        btnProdE = (Button)findViewById(R.id.btnProdE);

        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SecondActivity.this, Activity_Cart.class);
                startActivity(i);
            }
        });

        btnMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SecondActivity.this, Activity_Messages.class);
                startActivity(i);
            }
        });



        btnProdA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SecondActivity.this, Activity_ProdA.class);
                i.putExtra(PRODUCT_NAME, "Avocado");
                i.putExtra(PRODUCT_IMAGE_PATH, R.drawable.prod_avocado);
                startActivity(i);
            }
        });

        btnProdB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SecondActivity.this, Activity_ProdA.class);
                i.putExtra(PRODUCT_NAME, "Cucumber");
                i.putExtra(PRODUCT_IMAGE_PATH, R.drawable.prod_cucumber);
                startActivity(i);
            }
        });

        btnProdC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SecondActivity.this, Activity_ProdA.class);
                i.putExtra(PRODUCT_NAME, "Grapes");
                i.putExtra(PRODUCT_IMAGE_PATH, R.drawable.prod_grapes);
                startActivity(i);
            }
        });

        btnProdD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SecondActivity.this, Activity_ProdA.class);
                i.putExtra(PRODUCT_NAME, "Dragon Fruit");
                i.putExtra(PRODUCT_IMAGE_PATH, R.drawable.prod_dragonfruit);
                startActivity(i);
            }
        });

        btnProdE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SecondActivity.this, Activity_ProdA.class);
                i.putExtra(PRODUCT_NAME, "Lemon");
                i.putExtra(PRODUCT_IMAGE_PATH, R.drawable.prod_lemon);
                startActivity(i);
            }
        });
    }

    public void showMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}
