package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private LinearLayout mainLayout;
    private TextView txtMessage;

    // Remembers which button was last clicked so the colour/text
    // stays the same after rotating to landscape or portrait
    private String currentState = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Keep content away from status bar / navigation bar in both orientations
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        mainLayout = findViewById(R.id.main);
        txtMessage = findViewById(R.id.txtMessage);

        Button btnYellow = findViewById(R.id.btnYellow);
        Button btnRed = findViewById(R.id.btnRed);
        Button btnGreen = findViewById(R.id.btnGreen);

        btnYellow.setOnClickListener(v -> applyState("YELLOW"));
        btnRed.setOnClickListener(v -> applyState("RED"));
        btnGreen.setOnClickListener(v -> applyState("GREEN"));

        // Restore colour and text after screen rotation
        if (savedInstanceState != null) {
            applyState(savedInstanceState.getString("state", ""));
        }
    }

    private void applyState(String state) {
        currentState = state;
        switch (state) {
            case "YELLOW":
                mainLayout.setBackgroundColor(Color.YELLOW);
                txtMessage.setText("CAUTION!");
                break;
            case "RED":
                mainLayout.setBackgroundColor(Color.RED);
                txtMessage.setText("STOP!");
                break;
            case "GREEN":
                mainLayout.setBackgroundColor(Color.parseColor("#92D050"));
                txtMessage.setText("GO!");
                break;
            default:
                mainLayout.setBackgroundColor(Color.WHITE);
                txtMessage.setText("");
                break;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("state", currentState);
    }
}
