package com.example.projekt2.ui;

import static com.example.projekt2.ResultHolder.questions;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;


import com.example.projekt2.R;
import com.example.projekt2.adapter.ReviewAdapter;
import com.example.projekt2.adapter.ScoreAdapter;
import com.example.projekt2.database.AppDatabase;
import com.example.projekt2.model.Score;
import com.google.android.gms.common.api.internal.BaseImplementation;

import java.util.List;


public class ResultActivity extends AppCompatActivity {

    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        int score = getIntent().getIntExtra("SCORE", 0);
        String name = getIntent().getStringExtra("NAME");

        TextView resultText = findViewById(R.id.resultText);
        RecyclerView recycler = findViewById(R.id.recycler);

        if (score >= 8) {
            resultText.setText("Świetnie! Wynik: " + score + "/" + questions.size());
        } else if (score >= 5) {
            resultText.setText("Dobrze! Wynik: " + score + "/" + questions.size());
        } else {
            resultText.setText("Spróbuj ponownie! Wynik: " + score + "/" + questions.size());
        }

        db = Room.databaseBuilder(getApplicationContext(),
                        AppDatabase.class, "quiz-db")
                .allowMainThreadQueries()
                .build();

        db.scoreDao().insert(new Score(name, score));

        List<Score> scores = db.scoreDao().getTopScores();

        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(new ScoreAdapter(scores));

        Button checkBtn = findViewById(R.id.checkAnswersBtn);

        checkBtn.setOnClickListener(v -> {
            Intent intent = new Intent(this, ReviewActivity.class);
            startActivity(intent);
        });
    }
}