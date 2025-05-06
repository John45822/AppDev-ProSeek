package com.example.proseekservices;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivitySearch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_search);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageButton btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> onBackPressed());

        ImageView urprofile = findViewById(R.id.urprofile);
        urprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivitySearch.this, MainActivityProfile.class);
                startActivity(intent);
            }
        });

        ImageView messages = findViewById(R.id.messages);
        messages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivitySearch.this, MainActivityMessages.class);
                startActivity(intent);
            }
        });

        ImageView mess = findViewById(R.id.mess);
        mess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivitySearch.this, MainActivityConversation.class);
                startActivity(intent);
            }
        });

        // ======= Add these lines =======

        LinearLayout list = findViewById(R.id.list);
        LinearLayout list1 = findViewById(R.id.list1);
        LinearLayout list2 = findViewById(R.id.list2);
        LinearLayout list3 = findViewById(R.id.list3);
        LinearLayout list4 = findViewById(R.id.list4);
        LinearLayout list5 = findViewById(R.id.list5);

        list.setOnClickListener(v -> openProOp("emily_01"));
        list1.setOnClickListener(v -> openProOp("s.john"));
        list2.setOnClickListener(v -> openProOp("alexa99"));
        list3.setOnClickListener(v -> openProOp("ethan01"));
        list4.setOnClickListener(v -> openProOp("davesmith"));
        list5.setOnClickListener(v -> openProOp("nancyluz"));
    }

    private void openProOp(String username) {
        Intent intent = new Intent(MainActivitySearch.this, MainActivityProOp.class);

        switch (username) {
            case "emily_01":
                intent.putExtra("name", "EMILY SMITH");
                intent.putExtra("username", "@emily_01");
                intent.putExtra("email", "emilysmith@gmail.com");
                intent.putExtra("location", "MARAMAG");
                intent.putExtra("rating", 5f);
                intent.putExtra("imageResId", R.drawable.progirl1);
                break;

            case "s.john":
                intent.putExtra("name", "SARAH JOHNSON");
                intent.putExtra("username", "@s.john");
                intent.putExtra("email", "sarahjohn@gmail.com");
                intent.putExtra("location", "VALENCIA");
                intent.putExtra("rating", 4.5f);
                intent.putExtra("imageResId", R.drawable.progirl2);
                break;

            case "alexa99":
                intent.putExtra("name", "ALEXA RIVERA");
                intent.putExtra("username", "@alexa99");
                intent.putExtra("email", "alexariv@gmail.com");
                intent.putExtra("location", "MANOLO FORTICH");
                intent.putExtra("rating", 4.0f);
                intent.putExtra("imageResId", R.drawable.progirl3);
                break;

            case "ethan01":
                intent.putExtra("name", "ETHAN WALKER");
                intent.putExtra("username", "@ethan01");
                intent.putExtra("email", "ethanwalker@gmail.com");
                intent.putExtra("location", "DON CARLOS");
                intent.putExtra("rating", 4.2f);
                intent.putExtra("imageResId", R.drawable.proboy1);
                break;

            case "davesmith":
                intent.putExtra("name", "DAVE SMITH");
                intent.putExtra("username", "@davesmith");
                intent.putExtra("email", "dsmith88@gmail.com");
                intent.putExtra("location", "IMPASUGONG");
                intent.putExtra("rating", 4.8f);
                intent.putExtra("imageResId", R.drawable.proboy2);
                break;

            case "nanayluz":
                intent.putExtra("name", "NANCY LUZ");
                intent.putExtra("username", "@nancyluz");
                intent.putExtra("email", "nanayluz@gmail.com");
                intent.putExtra("location", "KIBAWE");
                intent.putExtra("rating", 4.3f);
                intent.putExtra("imageResId", R.drawable.progirl4);
                break;


            default:
                intent.putExtra("name", "Unknown");
                intent.putExtra("username", "@unknown");
                intent.putExtra("email", "unknown@example.com");
                intent.putExtra("location", "Unknown");
                intent.putExtra("rating", 0f);
                intent.putExtra("imageResId", R.drawable.profileremovebg);
                break;
        }

        startActivity(intent);
    }

}
