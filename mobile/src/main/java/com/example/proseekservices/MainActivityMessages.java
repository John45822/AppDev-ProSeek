package com.example.proseekservices;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivityMessages extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_messages);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageButton btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> onBackPressed());

        LinearLayout first = findViewById(R.id.first);
        first.setOnClickListener(v -> openChatWith("@emily_01"));

        LinearLayout second = findViewById(R.id.second);
        second.setOnClickListener(v -> openChatWith("@johnduskin"));

        LinearLayout third = findViewById(R.id.third);
        third.setOnClickListener(v -> openChatWith("@alexa99"));

        LinearLayout fourth = findViewById(R.id.fourth);
        fourth.setOnClickListener(v -> openChatWith("@mikee_02"));

        LinearLayout fifth = findViewById(R.id.fifth);
        fifth.setOnClickListener(v -> openChatWith("@davee"));

        LinearLayout sixth = findViewById(R.id.sixth);
        sixth.setOnClickListener(v -> openChatWith("@nanayluz"));

        LinearLayout seventh = findViewById(R.id.seventh);
        seventh.setOnClickListener(v -> openChatWith("@ma.santos"));
    }

    private void openChatWith(String username) {
        // Choose the correct profile picture based on username
        int profilePicResId = R.drawable.profileremovebg; // fallback/default pic

        switch (username) {
            case "@emily_01":
                profilePicResId = R.drawable.progirl1;
                break;
            case "@johnduskin":
                profilePicResId = R.drawable.proboy2;
                break;
            case "@alexa99":
                profilePicResId = R.drawable.progirl2;
                break;
            case "@mikee_02":
                profilePicResId = R.drawable.proboy1;
                break;
            case "@davee":
                profilePicResId = R.drawable.proboy3;
                break;
            case "@nanayluz":
                profilePicResId = R.drawable.progirl4;
                break;
            case "@ma.santos":
                profilePicResId = R.drawable.progirl3;
                break;
        }

        // Only create the intent ONCE (not twice!)
        Intent intent = new Intent(MainActivityMessages.this, MainActivityConversation.class);
        intent.putExtra("username", username);
        intent.putExtra("profilePic", profilePicResId);
        startActivity(intent);
    }

}

