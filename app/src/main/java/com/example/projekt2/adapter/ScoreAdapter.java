package com.example.projekt2.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.projekt.R;
import com.example.projekt.model.Score;

import java.util.List;

public class ScoreAdapter extends RecyclerView.Adapter<ScoreAdapter.ViewHolder> {

    List<Score> scores;

    public ScoreAdapter(List<Score> scores) {
        this.scores = scores;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, points;

        public ViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.nameText);
            points = view.findViewById(R.id.pointsText);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_score, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Score s = scores.get(position);
        holder.name.setText(s.playerName);
        holder.points.setText(String.valueOf(s.points));
    }

    @Override
    public int getItemCount() {
        return scores.size();
    }
}
