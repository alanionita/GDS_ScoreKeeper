package com.example.android.scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreTeamA = 0;
    int scoreTeamB = 0;
    int yellowCardsTeamA = 0;
    int yellowCardsTeamB = 0;
    int redCardsTeamA = 0;
    int redCardsTeamB = 0;
    int cornersTeamA = 0;
    int cornersTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayScoreForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayScoreForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given log for Team A.
     */
    public void displayLogForTeamA(String log) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_log);
        scoreView.setText(log);
    }

    /**
     * Displays the given log for Team B.
     */
    public void displayLogForTeamB(String log) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_log);
        scoreView.setText(log);
    }


    /**
     * Resets the score for both teams.
     */
    public void resetScore(View view) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayScoreForTeamA(scoreTeamA);
        displayScoreForTeamB(scoreTeamB);
    }

    /**
     * Adds a goal - increase score by 1 for Team A.
     */
    public void addGoalTeamA(View view) {
        scoreTeamA = scoreTeamA + 1;
        displayScoreForTeamA(scoreTeamA);
        displayLogForTeamA("⚽ 3\", Messi");
    }

    /**
     * Adds a goal - increase score by 1 for Team B.
     */
    public void addGoalTeamB(View view) {
        scoreTeamB = scoreTeamB + 1;
        displayScoreForTeamB(scoreTeamB);
        displayLogForTeamB("⚽ 78\", Rooney");
    }

    /**
     * Adds yellow card = Increase yellowCardsTeamA by 1.
     */
    public void addYellowCardTeamA(View view) {
        yellowCardsTeamA = yellowCardsTeamA + 1;
        displayLogForTeamA("🔶 12\", Messi!");
    }

    /**
     * Adds yellow car = Increase yellowCardsTeamB by 1.
     */
    public void addYellowCardTeamB(View view) {
        yellowCardsTeamB = yellowCardsTeamB + 1;
        displayLogForTeamB("🔶 12\", Rooney!");
    }

    /**
     * Adds red card = Increase redCardsTeamA by 1.
     */
    public void addRedCardTeamA(View view) {
        redCardsTeamA = redCardsTeamA + 1;
        displayLogForTeamA("🔴 24\", Messi!");
    }

    /**
     * Adds red card = Increase redCardsTeamB by 1.
     */
    public void addRedCardTeamB(View view) {
        redCardsTeamB = redCardsTeamB + 1;
        displayLogForTeamB("🔴 32\", Evra!");
    }

    /**
     * Adds corner = Increase cornersTeamA by 1.
     */
    public void addCornerTeamA(View view) {
        cornersTeamA = cornersTeamA + 1;
        displayLogForTeamA("\uD83C\uDF7F 45\", Nani!");
    }

    /**
     * Adds corner = Increase cornersTeamB by 1.
     */
    public void addCornerTeamB(View view) {
        cornersTeamB = cornersTeamB + 1;
        displayLogForTeamB("\uD83C\uDF7F 56\", Evra!");
    }
}


