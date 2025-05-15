package com.example.proseekservices;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivityConversation extends AppCompatActivity {
    private ScrollView scrollView;
    private LinearLayout messagesContainer;
    private EditText messageInput;
    private ImageButton sendButton;
    private ImageButton backButton;

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

        // Get views
        scrollView = findViewById(R.id.conversation_scroll);
        messagesContainer = findViewById(R.id.messages_container);
        messageInput = findViewById(R.id.message_input);
        sendButton = findViewById(R.id.send_button);
        backButton = findViewById(R.id.btnBack);

        TextView usernameTop = findViewById(R.id.username_top);
        TextView usernameBig = findViewById(R.id.username_big);
        ImageView profilePicSmall = findViewById(R.id.profile_pic_small);
        ImageView profilePicBig = findViewById(R.id.profile_pic_big);

        // Get data from Intent
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        int profilePicRes = intent.getIntExtra("profilePicRes", R.drawable.profileremovebg);

        // Set UI with data
        if (username != null) {
            usernameTop.setText(username);
            usernameBig.setText(username);
        }
        profilePicSmall.setImageResource(profilePicRes);
        profilePicBig.setImageResource(profilePicRes);

        // Back button action
        backButton.setOnClickListener(v -> finish());

        // Send button action
        sendButton.setOnClickListener(v -> {
            String messageText = messageInput.getText().toString().trim();
            if (!messageText.isEmpty()) {
                addMessageToConversation(messageText);
                messageInput.setText("");
            }
        });

        // Scroll to bottom
        scrollView.post(() -> scrollView.fullScroll(View.FOCUS_DOWN));
    }

    private void addMessageToConversation(String message) {
        LinearLayout messageLayout = new LinearLayout(this);
        messageLayout.setOrientation(LinearLayout.HORIZONTAL);
        messageLayout.setGravity(View.FOCUS_RIGHT);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        layoutParams.gravity = android.view.Gravity.END;
        layoutParams.setMargins(0, 0, 0, 16);
        messageLayout.setLayoutParams(layoutParams);

        TextView messageView = new TextView(this);
        messageView.setText(message);
        messageView.setTextSize(14);
        messageView.setTextColor(getResources().getColor(android.R.color.black));
        messageView.setBackgroundResource(R.drawable.message_rightbg);
        messageView.setPadding(16, 12, 16, 12);

        messageLayout.addView(messageView);
        messagesContainer.addView(messageLayout);

        scrollView.post(() -> scrollView.fullScroll(View.FOCUS_DOWN));
    }
}
