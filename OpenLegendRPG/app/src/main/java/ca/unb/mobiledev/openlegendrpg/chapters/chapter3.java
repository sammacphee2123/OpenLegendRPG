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

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragement_ch3);
        ScrollView sv = (ScrollView)findViewById(R.id.scrl);
        Button Button1 = findViewById(R.id.Button1_ch3);
        Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView text = findViewById(R.id.SubTitle1_ch3);
                sv.scrollTo(0, text.getTop());
            }
        });
        Button Button2 = findViewById(R.id.Button2_ch3);
        Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView text = findViewById(R.id.SubTitle2_ch3);
                sv.scrollTo(0, text.getTop());
            }
        });
        Button Button3 = findViewById(R.id.Button3_ch3);
        Button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView text = findViewById(R.id.SubTitle3_ch3);
                sv.scrollTo(0, text.getTop());
            }
        });
        Button Button4 = findViewById(R.id.Button4_ch3);
        Button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView text = findViewById(R.id.SubTitle4_ch3);
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

