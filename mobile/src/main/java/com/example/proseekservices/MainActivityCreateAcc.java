package com.example.proseekservices;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivityCreateAcc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_create_acc);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText etEmail, etPwd = findViewById(R.id.entpassword), etRepwd = findViewById(R.id.confirmpass);
        Button create = findViewById(R.id.create);
        ProseekDB dbHelper = new ProseekDB(this);

        
        etEmail = findViewById(R.id.email);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email,pwd,repwd;
                email = etEmail.getText().toString();
                pwd = etPwd.getText().toString();
                repwd = etRepwd.getText().toString();
                if(email.equals("") || pwd.equals("") || repwd.equals("")) {
                    Toast.makeText(MainActivityCreateAcc.this, "Please fill all the fields",Toast.LENGTH_LONG).show();

                }else{
                    if(pwd.equals(repwd)) {
                        if(dbHelper.checkEmail(email)) {
                            Toast.makeText(MainActivityCreateAcc.this, "User Already Exists!",Toast.LENGTH_LONG).show();
                        }
                        boolean registeredSuccess = dbHelper.insertData(email,pwd);
                        if(registeredSuccess) {
                            Toast.makeText(MainActivityCreateAcc.this, "User Registered Successfully!",Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(MainActivityCreateAcc.this,MainActivity.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(MainActivityCreateAcc.this, "User Registration Failed!",Toast.LENGTH_LONG).show();
                        }
                    }else{
                        Toast.makeText(MainActivityCreateAcc.this, "Passwords do not matched.",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });




//        Button create = (Button) findViewById(R.id.create);
//        create.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivityCreateAcc.this,MainActivity.class);
//                startActivity(intent);
//
//            }
//        });
    }
}