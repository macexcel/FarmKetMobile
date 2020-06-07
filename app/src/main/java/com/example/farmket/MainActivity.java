package com.example.farmket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText User;
    private EditText Pass;
    private Button Login;
    private Button Register;

    String S_User = "user";
    String S_Pass = "user";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        User = (EditText)findViewById(R.id.txtUser);
        Pass = (EditText)findViewById(R.id.txtPass);
        Login = (Button)findViewById(R.id.btnLogin);
        Register = (Button)findViewById(R.id.btnRegister);



        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), User.getText().toString() +" "+Pass.getText().toString(), Toast.LENGTH_SHORT).show();
                validate(User.getText().toString(), Pass.getText().toString());
            }
        });

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Activity_Register.class);
                startActivity(intent);
            }
        });
    }

    private void validate(String userName, String password){
        if (userName.equals(S_User) && password.equals(S_Pass)){
            Toast.makeText(getApplicationContext(), "Logging in...", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(getApplicationContext(), "Wrong Username or Password", Toast.LENGTH_LONG).show();

        }
    }

}
