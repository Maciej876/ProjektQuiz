package com.example.projekt2.adapter;

import android.graphics.Color;
import android.view.*;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.projekt2.R;
import com.example.projekt2.model.Question;

import java.util.List;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.VH> {

    List<Question> questions;
    List<Integer> answers;

    public ReviewAdapter(List<Question> q, List<Integer> a) {
        this.questions = q;
        this.answers = a;
    }

    static class VH extends RecyclerView.ViewHolder {
        TextView q, a;

        VH(View v) {
            super(v);
            q = v.findViewById(R.id.qText);
            a = v.findViewById(R.id.aText);
        }
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_review, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(VH h, int i) {

        Question q = questions.get(i);
        int user = answers.get(i);

        String userAns = q.answers.get(user);
        String correctAns = q.answers.get(q.correctIndex);

        h.q.setText(q.question);
        h.a.setText("Twoja: " + userAns + "\nPoprawna: " + correctAns);

        if (user == q.correctIndex) {
            h.a.setTextColor(Color.GREEN);
        } else {
            h.a.setTextColor(Color.RED);
        }
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }
}