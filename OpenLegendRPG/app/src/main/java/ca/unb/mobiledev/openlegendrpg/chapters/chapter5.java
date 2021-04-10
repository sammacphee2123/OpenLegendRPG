package ca.unb.mobiledev.openlegendrpg.chapters;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import ca.unb.mobiledev.openlegendrpg.R;

public class chapter5 extends android.app.Activity{
    private Button ContentsButton;
    private Button NextButton;
    private Button PreviousButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragement_ch5);

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
                Intent intent = new Intent(chapter5.this, chapter6.class);
                startActivity(intent);
                finish();
            }
        });

        PreviousButton = findViewById(R.id.PreviousButton);
        PreviousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(chapter5.this, chapter4.class);
                startActivity(intent);
                finish();
            }
        });


        //Scroll buttons
        Button button1 = findViewById(R.id.Button1_ch5);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView text = findViewById(R.id.ch5_subTitle1);
                ScrollView sv = findViewById(R.id.scrl_ch5);
                sv.scrollTo(0, text.getTop());
            }
        });

        Button button2 = findViewById(R.id.Button2_ch5);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView text = findViewById(R.id.ch5_subTitle2);
                ScrollView sv = findViewById(R.id.scrl_ch5);
                sv.scrollTo(0, text.getTop());
            }
        });

        Button button3 = findViewById(R.id.Button3_ch5);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView text = findViewById(R.id.ch5_subTitle3);
                ScrollView sv = findViewById(R.id.scrl_ch5);
                sv.scrollTo(0, text.getTop());
            }
        });

        Button button4 = findViewById(R.id.Button4_ch5);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView text = findViewById(R.id.ch5_subTitle4);
                ScrollView sv = findViewById(R.id.scrl_ch5);
                sv.scrollTo(0, text.getTop());
            }
        });

        Button button5 = findViewById(R.id.Button5_ch5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView text = findViewById(R.id.ch5_subTitle5);
                ScrollView sv = findViewById(R.id.scrl_ch5);
                sv.scrollTo(0, text.getTop());
            }
        });
    }
}

