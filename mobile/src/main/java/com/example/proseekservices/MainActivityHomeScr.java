package com.example.proseekservices;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivityHomeScr extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_home_scr);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText searchbar = findViewById(R.id.searchbar);
        searchbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivityHomeScr.this, MainActivitySearch.class);
                startActivity(intent);
            }
        });

        LinearLayout tutoring = findViewById(R.id.tutoring);
        tutoring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivityHomeScr.this, MainActivitySearch.class);
                intent.putExtra("category", "tutoring");
                startActivity(intent);
            }
        });

        LinearLayout housechores = findViewById(R.id.housechores);
        housechores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivityHomeScr.this, MainActivitySearch.class);
                intent.putExtra("category", "housechores");
                startActivity(intent);
            }
        });

        LinearLayout project = findViewById(R.id.project);
        project.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivityHomeScr.this, MainActivitySearch.class);
                intent.putExtra("category", "project");
                startActivity(intent);
            }
        });

        LinearLayout assistant = findViewById(R.id.assistant);
        assistant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivityHomeScr.this, MainActivitySearch.class);
                intent.putExtra("category", "assistant");
                startActivity(intent);
            }
        });

        LinearLayout healthcare = findViewById(R.id.healthcare);
        healthcare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivityHomeScr.this, MainActivitySearch.class);
                intent.putExtra("category", "healthcare");
                startActivity(intent);
            }
        });

        ImageView urprofile = findViewById(R.id.urprofile);
        urprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivityHomeScr.this, MainActivityProfile.class);
                startActivity(intent);
            }
        });

        ImageView messages = findViewById(R.id.messages);
        messages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivityHomeScr.this, MainActivityMessages.class);
                startActivity(intent);

            }
        });




    }
}