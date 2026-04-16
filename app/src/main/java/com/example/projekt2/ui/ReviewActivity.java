package com.example.projekt2.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.projekt2.R;
import com.example.projekt2.ResultHolder;
import com.example.projekt2.adapter.ReviewAdapter;

public class ReviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        RecyclerView recycler = findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        recycler.setAdapter(
                new ReviewAdapter(ResultHolder.questions, ResultHolder.answers)
        );
    }
}