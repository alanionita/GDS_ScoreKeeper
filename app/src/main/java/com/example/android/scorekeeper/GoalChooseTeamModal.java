package com.example.android.scorekeeper;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


/**
 * Created by alanionita on 28/01/2018.
 */

public class GoalChooseTeamModal extends DialogFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.team_choosing_modal, container, false);
        getDialog().setTitle("Rate us");
        LinearLayout teamA = view.findViewById(R.id.modal_team_a);
        LinearLayout teamB = view.findViewById(R.id.modal_team_b);
        teamA.setOnClickListener(new OnTeamAClickListener());
        teamB.setOnClickListener(new OnTeamBClickListener());
        return view;
    }

    private class OnTeamAClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
           // references MainActivity and gets addGoalTeamA method
           ((MainActivity)getActivity()).addGoalTeamA();
           dismiss();
        }
    }

    private class OnTeamBClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            // references MainActivity and gets addGoalTeamB method
            ((MainActivity)getActivity()).addGoalTeamB();
            dismiss();
        }
    }

}
