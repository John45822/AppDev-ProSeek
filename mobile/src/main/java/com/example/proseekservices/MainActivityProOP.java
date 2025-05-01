package com.example.proseekservices;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivityProOP extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_pro_op);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        LinearLayout messageemily_01 = findViewById(R.id.mess_emily_01);
        LinearLayout messagejohnduskin = findViewById(R.id.mess_johnduskin);
        LinearLayout messagealexa99 = findViewById(R.id.mess_alexa99);
        LinearLayout messagemikee_02 = findViewById(R.id.mess_mikee_02);
        LinearLayout messagedavee = findViewById(R.id.mess_davee);
        LinearLayout messagenanayluz = findViewById(R.id.mess_nanayluz);
        LinearLayout messagema_santos = findViewById(R.id.mess_ma_santos);adf

        messageemily_01.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivityProOP.this, MainActivityConversation.class);
            intent.putExtra("name", "emily_01");
            startActivity(intent);
        });

        messagejohnduskin.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivityProOP.this, MainActivityConversation.class);
            intent.putExtra("name", "johnduskin");
            startActivity(intent);
        });

        messagealexa99.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivityProOP.this, MainActivityConversation.class);
            intent.putExtra("name", "alexa99");
            startActivity(intent);
        });

        messagemikee_02.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivityProOP.this, MainActivityConversation.class);
            intent.putExtra("name", "mikee_02");
            startActivity(intent);
        });

        messagedavee.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivityProOP.this, MainActivityConversation.class);
            intent.putExtra("name", "davee");
            startActivity(intent);
        });

        messagenanayluz.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivityProOP.this, MainActivityConversation.class);
            intent.putExtra("name", "nanayluz");
            startActivity(intent);
        });

        messagema_santos.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivityProOP.this, MainActivityConversation.class);
            intent.putExtra("name", "ma_santos");
            startActivity(intent);
        });

    }

}