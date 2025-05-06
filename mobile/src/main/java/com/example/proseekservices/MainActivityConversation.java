package com.example.proseekservices;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.ImageView;



import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivityConversation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_conversation);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageButton btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> onBackPressed());

        ScrollView scrollView = findViewById(R.id.conversation_scroll);
        scrollView.post(() -> scrollView.fullScroll(View.FOCUS_DOWN));

        // Get passed data
        String username = getIntent().getStringExtra("username");
        int profileResId = getIntent().getIntExtra("profilePic", R.drawable.profileremovebg);

        // Set username and profile pictures
        TextView chatHeader = findViewById(R.id.chatHeader);
        TextView usernameBig = findViewById(R.id.username_big);
        chatHeader.setText(username);
        usernameBig.setText(username);

        ImageView profilePicSmall = findViewById(R.id.profile_pic_small);
        ImageView profilePicBig = findViewById(R.id.profile_pic_big);
        profilePicSmall.setImageResource(profileResId);
        profilePicBig.setImageResource(profileResId);

        ImageView messageProfilePic = findViewById(R.id.message_profile_pic);
        messageProfilePic.setImageResource(profileResId);
    }


}