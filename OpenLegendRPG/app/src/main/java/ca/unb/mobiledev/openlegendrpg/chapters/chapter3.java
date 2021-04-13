package ca.unb.mobiledev.openlegendrpg.chapters;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import ca.unb.mobiledev.openlegendrpg.R;

public class chapter3 extends android.app.Activity{
    private Button ContentsButton;
    private Button NextButton;
    private Button PreviousButton;

    private Button title1;
    private Button title2;
    private Button title3;
    private Button title4;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragement_ch3);
        ScrollView sv = (ScrollView)findViewById(R.id.scrl_ch3);

        title1 = findViewById(R.id.Button1_ch3);
        title1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView text = findViewById(R.id.ch3_title1);
                sv.scrollTo(0, text.getTop());
            }
        });
        title2 = findViewById(R.id.Button2_ch3);
        title2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView text = findViewById(R.id.ch3_title2);
                sv.scrollTo(0, text.getTop());
            }
        });
        title3 = findViewById(R.id.Button3_ch3);
        title3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView text = findViewById(R.id.ch3_title3);
                sv.scrollTo(0, text.getTop());
            }
        });
        title4 = findViewById(R.id.Button4_ch3);
        title4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView text = findViewById(R.id.ch3_title4);
                sv.scrollTo(0, text.getTop());
            }
        });


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
                Intent intent = new Intent(chapter3.this, chapter4.class);
                startActivity(intent);
                finish();
            }
        });

        PreviousButton = findViewById(R.id.PreviousButton);
        PreviousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(chapter3.this, chapter2.class);
                startActivity(intent);
                finish();
            }
        });
    }
}

