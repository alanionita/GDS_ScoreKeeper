package com.example.android.scorekeeper;

import android.graphics.drawable.Animatable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

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

        final FloatingActionButton mainFab = findViewById(R.id.main_floating_button);
        final FloatingActionButton resetFab = findViewById(R.id.reset_button);
        final FloatingActionButton goalFab = findViewById(R.id.goal_button);
        final FloatingActionButton yellowCardFab = findViewById(R.id.yellow_card_button);
        final FloatingActionButton redCardFab = findViewById(R.id.red_card_button);
        final FloatingActionButton cornerFab = findViewById(R.id.corner_button);

        final LinearLayout secondaryFabsLayout = findViewById(R.id.secondary_fabs_layout);
        final LinearLayout dimLayout = findViewById(R.id.dim_layout);

        final Animation showButton = AnimationUtils.loadAnimation(MainActivity.this, R.anim.show_button);
        final Animation hideButton = AnimationUtils.loadAnimation(MainActivity.this, R.anim.hide_button);
        final Animation showLayout = AnimationUtils.loadAnimation(MainActivity.this, R.anim.show_layout);
        final Animation hideLayout = AnimationUtils.loadAnimation(MainActivity.this, R.anim.hide_layout);


        mainFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(secondaryFabsLayout.getVisibility() == View.VISIBLE){
                    secondaryFabsLayout.setVisibility(View.GONE);
                    dimLayout.setVisibility(View.GONE);
                    mainFab.startAnimation(hideButton);
                    secondaryFabsLayout.startAnimation(hideLayout);
                } else {
                    secondaryFabsLayout.setVisibility(View.VISIBLE);
                    dimLayout.setVisibility(View.VISIBLE);
                    mainFab.startAnimation(showButton);
                    secondaryFabsLayout.startAnimation(showLayout);
                }

            }
        });

        resetFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetFab.bringToFront();
                resetScore();
                secondaryFabsLayout.setVisibility(View.GONE);
                dimLayout.setVisibility(View.GONE);
                secondaryFabsLayout.startAnimation(hideLayout);
                mainFab.startAnimation(hideButton);
            }
        });

        goalFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goalFab.bringToFront();
                GoalChooseTeamModal teamModal = new GoalChooseTeamModal();
                teamModal.show(getFragmentManager(), "dialog");
                secondaryFabsLayout.setVisibility(View.GONE);
                dimLayout.setVisibility(View.GONE);
                secondaryFabsLayout.startAnimation(hideLayout);
                mainFab.startAnimation(hideButton);
            }
        });

        yellowCardFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yellowCardFab.bringToFront();
                YellowCardChooseTeamModal teamModal = new YellowCardChooseTeamModal();
                teamModal.show(getFragmentManager(), "dialog");
                secondaryFabsLayout.setVisibility(View.GONE);
                dimLayout.setVisibility(View.GONE);
                secondaryFabsLayout.startAnimation(hideLayout);
                mainFab.startAnimation(hideButton);
            }
        });

        redCardFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redCardFab.bringToFront();
                RedCardChooseTeamModal teamModal = new RedCardChooseTeamModal();
                teamModal.show(getFragmentManager(), "dialog");
                secondaryFabsLayout.setVisibility(View.GONE);
                dimLayout.setVisibility(View.GONE);
                secondaryFabsLayout.startAnimation(hideLayout);
                mainFab.startAnimation(hideButton);
            }
        });

        cornerFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cornerFab.bringToFront();
                CornerChooseTeamModal teamModal = new CornerChooseTeamModal();
                teamModal.show(getFragmentManager(), "dialog");
                secondaryFabsLayout.setVisibility(View.GONE);
                dimLayout.setVisibility(View.GONE);
                secondaryFabsLayout.startAnimation(hideLayout);
                mainFab.startAnimation(hideButton);
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
    private void resetScore() {
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
    public void addGoalTeamA() {
        scoreTeamA = scoreTeamA + 1;
        displayScoreForTeamA(scoreTeamA);
        displayLogForTeamA("3\" | ⚽ | Messi \n");
        displayLogForTeamB("\n");
    }

    /**
     * Adds a goal - increase score by 1 for Team B.
     */
    public void addGoalTeamB() {
        scoreTeamB = scoreTeamB + 1;
        displayScoreForTeamB(scoreTeamB);
        displayLogForTeamB("Rooney | ⚽ | 78\" \n");
        displayLogForTeamA("\n");
    }

    /**
     * Adds yellow card = Increase yellowCardsTeamA by 1.
     */
    public void addYellowCardTeamA() {
        yellowCardsTeamA = yellowCardsTeamA + 1;
        displayLogForTeamA("12\" | 🔶 | Messi\n");
        displayLogForTeamB("\n");
    }

    /**
     * Adds yellow car = Increase yellowCardsTeamB by 1.
     */
    public void addYellowCardTeamB() {
        yellowCardsTeamB = yellowCardsTeamB + 1;
        displayLogForTeamB("Rooney | 🔶 | 12\"\n");
        displayLogForTeamA("\n");
    }

    /**
     * Adds red card = Increase redCardsTeamA by 1.
     */
    public void addRedCardTeamA() {
        redCardsTeamA = redCardsTeamA + 1;
        displayLogForTeamA("24\" | 🔴 | Messi\n");
        displayLogForTeamB("\n");
    }

    /**
     * Adds red card = Increase redCardsTeamB by 1.
     */
    public void addRedCardTeamB() {
        redCardsTeamB = redCardsTeamB + 1;
        displayLogForTeamB("Evra | 🔴 | 32\"\n");
        displayLogForTeamA("\n");
    }

    /**
     * Adds corner = Increase cornersTeamA by 1.
     */
    public void addCornerTeamA() {
        cornersTeamA = cornersTeamA + 1;
        displayLogForTeamA("45\" | \uD83C\uDF7F | Nani\n");
        displayLogForTeamB("\n");
    }

    /**
     * Adds corner = Increase cornersTeamB by 1.
     */
    public void addCornerTeamB() {
        cornersTeamB = cornersTeamB + 1;
        displayLogForTeamB("Evra | \uD83C\uDF7F | 56\"\n");
        displayLogForTeamA("\n");

    }
}


