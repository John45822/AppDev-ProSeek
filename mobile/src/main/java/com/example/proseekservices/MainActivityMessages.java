package com.example.proseekservices;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton; // <-- ADD THIS!
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

        LinearLayout chat1 = findViewById(R.id.first);
        chat1.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivityMessages.this, MainActivityConversation.class);
            startActivity(intent);
        });

        ImageButton btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> onBackPressed());

        LinearLayout chatEmily_01 = findViewById(R.id.chat_emily_01);
        chatEmily_01.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivityMessages.this, MainActivityConversation.class);
            intent.putExtra("username", "emily_01");  // Optional data to pass
            startActivity(intent);
        });

        LinearLayout chatJohnduskin = findViewById(R.id.chat_johnduskin);
        chatJohnduskin.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivityMessages.this, MainActivityConversation.class);
            intent.putExtra("username", "johnduskin");  // Optional data to pass
            startActivity(intent);
        });

        LinearLayout chatAlexa99 = findViewById(R.id.chat_alexa99);
        chatAlexa99.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivityMessages.this, MainActivityConversation.class);
            intent.putExtra("username", "alexa99");  // Optional data to pass
            startActivity(intent);
        });

        LinearLayout chatMikee_02 = findViewById(R.id.chat_mikee_02);
        chatMikee_02.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivityMessages.this, MainActivityConversation.class);
            intent.putExtra("username", "mikee_02");  // Optional data to pass
            startActivity(intent);
        });

        LinearLayout chatDavee = findViewById(R.id.chat_davee);
        chatDavee.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivityMessages.this, MainActivityConversation.class);
            intent.putExtra("username", "davee");  // Optional data to pass
            startActivity(intent);
        });

        LinearLayout chatNanayluz = findViewById(R.id.chat_nanayluz);
        chatNanayluz.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivityMessages.this, MainActivityConversation.class);
            intent.putExtra("username", "nanayluz");  // Optional data to pass
            startActivity(intent);
        });

        LinearLayout chatMa_santos = findViewById(R.id.chat_ma_santos);
        chatMa_santos.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivityMessages.this, MainActivityConversation.class);
            intent.putExtra("username", "ma_santos");  // Optional data to pass
            startActivity(intent);
        });
    }
}
