package com.example.android.scorekeeper;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.android.scorekeeper.ChooseTeamModal;

public class MainActivity extends AppCompatActivity {

    private int scoreTeamA = 0;
    private int scoreTeamB = 0;
    private int yellowCardsTeamA = 0;
    private int yellowCardsTeamB = 0;
    private int redCardsTeamA = 0;
    private int redCardsTeamB = 0;
    private int cornersTeamA = 0;
    private int cornersTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton mainFab = (FloatingActionButton) findViewById(R.id.main_floating_button);
        final FloatingActionButton resetFab = (FloatingActionButton) findViewById(R.id.reset_button);
        final FloatingActionButton goalFab = (FloatingActionButton) findViewById(R.id.goal_button);
        final LinearLayout resetLayout = (LinearLayout) findViewById(R.id.resetLayout);
        final LinearLayout goalLayout = (LinearLayout) findViewById(R.id.goalLayout);

        mainFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(resetLayout.getVisibility() == View.VISIBLE){
                    resetLayout.setVisibility(View.GONE);
                    goalLayout.setVisibility(View.GONE);
                } else {
                    resetLayout.setVisibility(View.VISIBLE);
                    goalLayout.setVisibility(View.VISIBLE);
                }

            }
        });

        resetFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetFab.bringToFront();
                resetScore(view);
            }
        });

        goalFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goalFab.bringToFront();
                ChooseTeamModal teamModal = new ChooseTeamModal();
                teamModal.show(getFragmentManager(), "dialog");
            }
        });


    }

    /**
     * Displays the given score for Team A.
     */
    private void displayScoreForTeamA(int score) {
        TextView scoreView = findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    private void displayScoreForTeamB(int score) {
        TextView scoreView = findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given log for Team A.
     */
    private void displayLogForTeamA(String log) {
        TextView scoreView = findViewById(R.id.team_a_log);
        scoreView.append(log);
    }

    private void resetLogs () {
        TextView scoreViewTeamA = findViewById(R.id.team_a_log);
        TextView scoreViewTeamB = findViewById(R.id.team_b_log);
        scoreViewTeamA.setText("");
        scoreViewTeamB.setText("");
    }

    /**
     * Displays the given log for Team B.
     */
    private void displayLogForTeamB(String log) {
        TextView scoreView = findViewById(R.id.team_b_log);
        scoreView.append(log);
    }


    /**
     * Resets the score for both teams.
     */
    public void resetScore(View view) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        yellowCardsTeamA = 0;
        yellowCardsTeamB = 0;
        redCardsTeamA = 0;
        redCardsTeamB = 0;
        cornersTeamA = 0;
        cornersTeamB = 0;
        displayScoreForTeamA(scoreTeamA);
        displayScoreForTeamB(scoreTeamB);
        resetLogs();
    }

    /**
     * Adds a goal - increase score by 1 for Team A.
     */
    public void addGoalTeamA(View view) {
        scoreTeamA = scoreTeamA + 1;
        displayScoreForTeamA(scoreTeamA);
        displayLogForTeamA("⚽ 3\", Messi\n");
    }

    /**
     * Adds a goal - increase score by 1 for Team B.
     */
    public void addGoalTeamB(View view) {
        scoreTeamB = scoreTeamB + 1;
        displayScoreForTeamB(scoreTeamB);
        displayLogForTeamB("⚽ 78\", Rooney\n");
    }

    /**
     * Adds yellow card = Increase yellowCardsTeamA by 1.
     */
    public void addYellowCardTeamA(View view) {
        yellowCardsTeamA = yellowCardsTeamA + 1;
        displayLogForTeamA("🔶 12\", Messi!\n");
    }

    /**
     * Adds yellow car = Increase yellowCardsTeamB by 1.
     */
    public void addYellowCardTeamB(View view) {
        yellowCardsTeamB = yellowCardsTeamB + 1;
        displayLogForTeamB("🔶 12\", Rooney!\n");
    }

    /**
     * Adds red card = Increase redCardsTeamA by 1.
     */
    public void addRedCardTeamA(View view) {
        redCardsTeamA = redCardsTeamA + 1;
        displayLogForTeamA("🔴 24\", Messi!\n");
    }

    /**
     * Adds red card = Increase redCardsTeamB by 1.
     */
    public void addRedCardTeamB(View view) {
        redCardsTeamB = redCardsTeamB + 1;
        displayLogForTeamB("🔴 32\", Evra!\n");
    }

    /**
     * Adds corner = Increase cornersTeamA by 1.
     */
    public void addCornerTeamA(View view) {
        cornersTeamA = cornersTeamA + 1;
        displayLogForTeamA("\uD83C\uDF7F 45\", Nani!\n");
    }

    /**
     * Adds corner = Increase cornersTeamB by 1.
     */
    public void addCornerTeamB(View view) {
        cornersTeamB = cornersTeamB + 1;
        displayLogForTeamB("\uD83C\uDF7F 56\", Evra!\n");
    }
}


