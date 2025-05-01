package com.example.proseekservices;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivityConversation extends AppCompatActivity {

    private static final String TAG = "MainActivityConversation";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_conversation);

        // Set up Edge-to-Edge system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Get the passed name and email from the Intent
        String name = getIntent().getStringExtra("name");
        String email = getIntent().getStringExtra("email");
        Log.d(TAG, "Received name: " + name + ", email: " + email);

        // Initialize TextViews
        TextView usernameTop = findViewById(R.id.username_top);
        TextView usernameBig = findViewById(R.id.username_big);

        // Check if the views exist and then update them
        if (usernameTop != null && usernameBig != null) {
            String displayName = (name != null && !name.isEmpty()) ? name : "Unknown User";
            usernameTop.setText("@" + displayName);
            usernameBig.setText("@" + displayName);
        } else {
            Log.e(TAG, "TextViews for usernameTop or usernameBig are missing in the layout.");
        }

        // Scroll to the bottom of the conversation
        ScrollView scrollView = findViewById(R.id.conversation_scroll);
        if (scrollView != null) {
            scrollView.post(() -> scrollView.fullScroll(View.FOCUS_DOWN));
        } else {
            Log.e(TAG, "ScrollView with ID conversation_scroll is missing in the layout.");
        }

        // Set up the Back button functionality
        ImageButton btnBack = findViewById(R.id.btnBack);
        if (btnBack != null) {
            btnBack.setOnClickListener(v -> {
                Log.d(TAG, "Back button clicked");
                finish();
            });
        } else {
            Log.e(TAG, "Back button with ID btnBack is missing in the layout.");
        }
    }
}