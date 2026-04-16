package com.example.projekt2.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import com.example.projekt2.R;
import com.example.projekt2.ResultHolder;
import com.example.projekt2.adapter.ReviewAdapter;
import com.example.projekt2.model.Question;
import com.google.android.gms.common.api.internal.BaseImplementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    List<Integer> userAnswers = new ArrayList<>();
    TextView progressText;
    TextView questionText;
    Button[] buttons = new Button[4];

    List<Question> questions;
    int current = 0;
    int score = 0;
    String playerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        playerName = getIntent().getStringExtra("NAME");

        questionText = findViewById(R.id.questionText);
        progressText = findViewById(R.id.progressText);

        buttons[0] = findViewById(R.id.btn1);
        buttons[1] = findViewById(R.id.btn2);
        buttons[2] = findViewById(R.id.btn3);
        buttons[3] = findViewById(R.id.btn4);

        loadQuestions();
    }


    private void loadQuestions() {
        questions = new ArrayList<>();

        addQuestion("Ile to 5 × 6?",
                Arrays.asList("30", "25", "20", "35"),
                0);

        addQuestion("Który język programowania używany jest w Androidzie?",
                Arrays.asList("Java", "Python", "C++", "PHP"),
                0);

        addQuestion("Kto napisał 'Pana Tadeusza'?",
                Arrays.asList("Adam Mickiewicz", "Sienkiewicz", "Tuwim", "Reymont"),
                0);

        addQuestion("Ile bitów ma 1 bajt?",
                Arrays.asList("8", "16", "4", "32"),
                0);
        addQuestion("Jaka jest stolica Polski?",
                Arrays.asList("Warszawa", "Kraków", "Gdańsk", "Poznań"), 0);

        addQuestion("Ile to 5 × 6?",
                Arrays.asList("30", "25", "20", "35"), 0);

        addQuestion("Który język programowania używany jest w Androidzie?",
                Arrays.asList("Java", "Python", "C++", "PHP"), 0);

        addQuestion("Kto napisał 'Pana Tadeusza'?",
                Arrays.asList("Adam Mickiewicz", "Sienkiewicz", "Tuwim", "Reymont"), 0);

        addQuestion("Ile bitów ma 1 bajt?",
                Arrays.asList("8", "16", "4", "32"), 0);

        addQuestion("Największa planeta Układu Słonecznego to:",
                Arrays.asList("Jowisz", "Ziemia", "Mars", "Saturn"), 0);

        addQuestion("Który kontynent jest największy?",
                Arrays.asList("Azja", "Europa", "Afryka", "Ameryka"), 0);

        addQuestion("HTML to język do:",
                Arrays.asList("Tworzenia stron WWW", "Programowania aplikacji", "Baz danych", "Grafiki"), 0);

        addQuestion("CSS służy do:",
                Arrays.asList("Stylowania stron", "Logiki programu", "Baz danych", "Sieci"), 0);

        addQuestion("Który ocean jest największy?",
                Arrays.asList("Spokojny", "Atlantycki", "Indyjski", "Arktyczny"), 0);

        addQuestion("Ile to 7 × 8?",
                Arrays.asList("56", "54", "48", "64"), 0);

        addQuestion("Windows to system od firmy:",
                Arrays.asList("Microsoft", "Apple", "Google", "IBM"), 0);

        addQuestion("Który język NIE jest obiektowy?",
                Arrays.asList("C", "Java", "Python", "C#"), 0);

        addQuestion("Ile dni ma rok przestępny?",
                Arrays.asList("366", "365", "364", "360"), 0);

        addQuestion("Najdłuższa rzeka świata to:",
                Arrays.asList("Nil", "Amazonka", "Missisipi", "Jangcy"), 0);

        addQuestion("Który kraj ma największą populację?",
                Arrays.asList("Chiny", "USA", "Rosja", "Polska"), 0);

        addQuestion("Który język jest używany do baz danych?",
                Arrays.asList("SQL", "Java", "Python", "C++"), 0);

        addQuestion("Git służy do:",
                Arrays.asList("Kontroli wersji", "Grafiki", "Muzyki", "Gier"), 0);

        addQuestion("Android bazuje na systemie:",
                Arrays.asList("Linux", "Windows", "macOS", "DOS"), 0);

        addQuestion("Który skrót oznacza sztuczną inteligencję?",
                Arrays.asList("AI", "CPU", "RAM", "GPU"), 0);

        addQuestion("Ile to 15 - 7?",
                Arrays.asList("8", "7", "6", "9"), 0);

        addQuestion("Procesor odpowiada za:",
                Arrays.asList("Obliczenia", "Wyświetlanie", "Dźwięk", "Internet"), 0);

        addQuestion("RAM to pamięć:",
                Arrays.asList("Operacyjna", "Stała", "Zewnętrzna", "Graficzna"), 0);

        addQuestion("Który język jest najczęściej używany w web?",
                Arrays.asList("JavaScript", "C", "Java", "Python"), 0);

        addQuestion("Ile to 3²?",
                Arrays.asList("9", "6", "3", "12"), 0);

        addQuestion("Który program to przeglądarka?",
                Arrays.asList("Chrome", "Photoshop", "Excel", "Word"), 0);

        addQuestion("Plik .jpg to:",
                Arrays.asList("Obraz", "Program", "Muzyka", "Tekst"), 0);

        Collections.shuffle(questions);

        questions = new ArrayList<>(questions.subList(0, 10));

        showQuestion();
    }

    private void addQuestion(String q, List<String> answers, int correctIndex) {
        List<String> shuffled = new ArrayList<>(answers);
        Collections.shuffle(shuffled);
        int newCorrect = shuffled.indexOf(answers.get(correctIndex));

        questions.add(new Question(q, shuffled, newCorrect));
    }

    private void showQuestion() {
        if (current >= questions.size()) {
            finishQuiz();
            return;
        }

        progressText.setText((current + 1) + "/" + questions.size());

        Question q = questions.get(current);
        questionText.setText(q.question);

        for (int i = 0; i < 4; i++) {
            buttons[i].setText(q.answers.get(i));

            int finalI = i;
            buttons[i].setOnClickListener(v -> checkAnswer(finalI));
        }
    }

    private void checkAnswer(int index) {

        userAnswers.add(index);

        if (index == questions.get(current).correctIndex) {
            score++;
        }

        current++;
        showQuestion();
    }

    private void finishQuiz() {
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("SCORE", score);
        intent.putExtra("NAME", playerName);

        ResultHolder.questions = questions;
        ResultHolder.answers = userAnswers;

        startActivity(intent);
        finish();
    }
}