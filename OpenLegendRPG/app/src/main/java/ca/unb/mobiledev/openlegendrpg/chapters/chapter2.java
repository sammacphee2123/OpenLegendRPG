package ca.unb.mobiledev.openlegendrpg.chapters;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import ca.unb.mobiledev.openlegendrpg.R;

public class chapter2 extends android.app.Activity {

    private Button ContentsButton;
    private Button NextButton;
    private Button PreviousButton;

    private Button whenToRollButton;
    private Button everyRollMattersButton;
    private Button actionRollsButton;
    private Button challengeRatingButton;
    private Button advantageDisadvantageButton;
    private Button legendPointsButton;

    ScrollView sv;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragement_ch2);

        ContentsButton = findViewById(R.id.TableButton);
        ContentsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        NextButton = findViewById(R.id.NextButton);
        NextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(chapter2.this, chapter3.class);
                startActivity(intent);
                finish();
            }
        });

        PreviousButton = findViewById(R.id.PreviousButton);
        PreviousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(chapter2.this, chapter1.class);
                startActivity(intent);
                finish();
            }
        });

        whenToRollButton = findViewById(R.id.whenToRollButton);
        whenToRollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView text = findViewById(R.id.ch2_title1);
                sv = findViewById(R.id.scrl_ch2);
                sv.scrollTo(0, text.getTop());
            }
        });

        everyRollMattersButton = findViewById(R.id.everyRollMattersButton);
        everyRollMattersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView text = findViewById(R.id.ch2_title2);
                sv = findViewById(R.id.scrl_ch2);
                sv.scrollTo(0, text.getTop());
            }
        });

        actionRollsButton = findViewById(R.id.actionRollsButton);
        actionRollsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView text = findViewById(R.id.ch2_title3);
                sv = findViewById(R.id.scrl_ch2);
                sv.scrollTo(0, text.getTop());
            }
        });

        challengeRatingButton = findViewById(R.id.challengeRatingButton);
        challengeRatingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView text = findViewById(R.id.ch2_title4);
                sv = findViewById(R.id.scrl_ch2);
                sv.scrollTo(0, text.getTop());
            }
        });

        advantageDisadvantageButton = findViewById(R.id.advantageDisadvantageButton);
        advantageDisadvantageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView text = findViewById(R.id.ch2_title5);
                sv = findViewById(R.id.scrl_ch2);
                sv.scrollTo(0, text.getTop());
            }
        });

        legendPointsButton = findViewById(R.id.legendPointsButton);
        legendPointsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView text = findViewById(R.id.ch2_title6);
                sv = findViewById(R.id.scrl_ch2);
                sv.scrollTo(0, text.getTop());
            }
        });


    }
}
