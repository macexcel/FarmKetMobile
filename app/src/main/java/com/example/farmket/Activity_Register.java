package com.example.farmket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Activity_Register extends AppCompatActivity {

    private Button Register;
    private ImageView btncon, btnprod, btnhub;
    private TextView Login;
    private EditText Fullname, Address, Email, Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_register);

        Register = (Button)findViewById(R.id.btnRegister);
        btncon = (ImageView)findViewById(R.id.imgcons);
        btnprod = (ImageView)findViewById(R.id.imgprod);
        btnhub = (ImageView)findViewById(R.id.imghub);
        Login = (TextView)findViewById(R.id.txtlogin);
        Fullname = (EditText) findViewById(R.id.inpName);
        Address = (EditText)findViewById(R.id.inpAddr);
        Email = (EditText)findViewById(R.id.inpEmail);
        Password = (EditText)findViewById(R.id.inpPass);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_Register.this, SecondActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnprod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnprod.setBackgroundColor(getResources().getColor(R.color.BlueDBG));
                btncon.setBackgroundColor(Color.TRANSPARENT);
                btnhub.setBackgroundColor(Color.TRANSPARENT);
            }
        });

        btncon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnprod.setBackgroundColor(Color.TRANSPARENT);
                btncon.setBackgroundColor(getResources().getColor(R.color.BlueDBG));
                btnhub.setBackgroundColor(Color.TRANSPARENT);
            }
        });

        btnhub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnprod.setBackgroundColor(Color.TRANSPARENT);
                btncon.setBackgroundColor(Color.TRANSPARENT);
                btnhub.setBackgroundColor(getResources().getColor(R.color.BlueDBG));
            }
        });

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_Register.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
