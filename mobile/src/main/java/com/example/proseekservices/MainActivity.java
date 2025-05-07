package com.example.proseekservices;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        ProseekDB dbHelper;
        Button loginbtn, createacc;
        EditText etEmail,etPwd;

        dbHelper = new ProseekDB(this);

        etEmail = findViewById(R.id.email);
        etPwd = findViewById(R.id.password);
        loginbtn = findViewById(R.id.loginbtn);
        createacc = findViewById(R.id.createacc);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isLoggedID = dbHelper.checkUser(etEmail.getText().toString(), etPwd.getText().toString());
                if (isLoggedID){
                    Intent intent = new Intent(MainActivity.this, MainActivityHomeScr.class);
                    startActivity(intent);

                }else{
                    Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_LONG).show();

                }
            }
        });


        createacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MainActivityCreateAcc.class);
                startActivity(intent);

            }
        });






        //Admin and Admin
//        loginbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (username.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
//                    //Correct
//                    Toast.makeText(MainActivity.this, "LOGIN SUCCESSFULL", Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(MainActivity.this, MainActivityHomeScr.class); // if login success, then go
//                    startActivity(intent);
//                }else {
//                    //Wrong
//                    Toast.makeText(MainActivity.this, "LOGIN FAILED", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//        createacc.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this,MainActivityCreateAcc.class);
//                startActivity(intent);
//
//            }
//        });
    }
}