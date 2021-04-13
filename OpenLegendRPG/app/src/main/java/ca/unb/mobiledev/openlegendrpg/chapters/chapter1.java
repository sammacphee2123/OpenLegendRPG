package ca.unb.mobiledev.openlegendrpg.chapters;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import ca.unb.mobiledev.openlegendrpg.R;

public class chapter1 extends android.app.Activity {

    private Button ContentsButton;
    private Button NextButton;
    private Button PreviousButton;

    private Button title1;
    private Button title2;
    private Button title3;
    private Button title4;
    private Button title5;
    private Button title6;
    private Button title7;
    private Button title8;
    private Button title9;
    private Button title10;

    private Button preGenCharacters;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragement_ch1);

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
                Intent intent = new Intent(chapter1.this, chapter2.class);
                startActivity(intent);
                finish();
            }
        });

        PreviousButton = findViewById(R.id.PreviousButton);
        PreviousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(chapter1.this, introduction.class);
                startActivity(intent);
                finish();
            }
        });

        title1 = findViewById(R.id.ch1_title1Button);
        title1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView text = findViewById(R.id.ch1_title1);
                ScrollView sv = findViewById(R.id.scrl_ch1);
                sv.scrollTo(0, text.getTop());
            }
        });

        title2 = findViewById(R.id.ch1_title2Button);
        title2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView text = findViewById(R.id.ch1_title2);
                ScrollView sv = findViewById(R.id.scrl_ch1);
                sv.scrollTo(0, text.getTop());
            }
        });

        title3 = findViewById(R.id.ch1_title3Button);
        title3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView text = findViewById(R.id.ch1_title3);
                ScrollView sv = findViewById(R.id.scrl_ch1);
                sv.scrollTo(0, text.getTop());
            }
        });

        title4 = findViewById(R.id.ch1_title4Button);
        title4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView text = findViewById(R.id.ch1_title4);
                ScrollView sv = findViewById(R.id.scrl_ch1);
                sv.scrollTo(0, text.getTop());
            }
        });

        title5 = findViewById(R.id.ch1_title5Button);
        title5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView text = findViewById(R.id.ch1_title5);
                ScrollView sv = findViewById(R.id.scrl_ch1);
                sv.scrollTo(0, text.getTop());
            }
        });

        title6 = findViewById(R.id.ch1_title6Button);
        title6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView text = findViewById(R.id.ch1_title6);
                ScrollView sv = findViewById(R.id.scrl_ch1);
                sv.scrollTo(0, text.getTop());
            }
        });

        title7 = findViewById(R.id.ch1_title7Button);
        title7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView text = findViewById(R.id.ch1_title7);
                ScrollView sv = findViewById(R.id.scrl_ch1);
                sv.scrollTo(0, text.getTop());
            }
        });

        title8 = findViewById(R.id.ch1_title8Button);
        title8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView text = findViewById(R.id.ch1_title8);
                ScrollView sv = findViewById(R.id.scrl_ch1);
                sv.scrollTo(0, text.getTop());
            }
        });

        title9 = findViewById(R.id.ch1_title9Button);
        title9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView text = findViewById(R.id.ch1_title9);
                ScrollView sv = findViewById(R.id.scrl_ch1);
                sv.scrollTo(0, text.getTop());
            }
        });

        title10 = findViewById(R.id.ch1_title10Button);
        title10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView text = findViewById(R.id.ch1_title10);
                ScrollView sv = findViewById(R.id.scrl_ch1);
                sv.scrollTo(0, text.getTop());
            }
        });

        preGenCharacters = findViewById(R.id.ch1_preGenCharactersButton);
        preGenCharacters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String preGenCharactersURL = "https://drive.google.com/drive/u/0/folders/0Bx_UrXHMi3wmUlJjbDZiaGtIX00";
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setData(Uri.parse(preGenCharactersURL));
                startActivity(browserIntent);
            }
        });

    }
}
