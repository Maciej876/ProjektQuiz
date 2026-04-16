package com.example.projekt2.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.projekt2.R;

public class MainActivity extends AppCompatActivity {

    EditText nameInput;
    Button startBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameInput = findViewById(R.id.nameInput);
        startBtn = findViewById(R.id.startButton);

        startBtn.setOnClickListener(v -> {
            String name = nameInput.getText().toString();

            Intent intent = new Intent(MainActivity.this, QuizActivity.class);
            intent.putExtra("NAME", name);

            startActivity(intent);
        });
    }
}