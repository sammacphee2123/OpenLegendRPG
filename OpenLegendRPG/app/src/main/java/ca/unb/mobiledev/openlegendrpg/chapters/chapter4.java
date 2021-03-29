package ca.unb.mobiledev.openlegendrpg.chapters;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import ca.unb.mobiledev.openlegendrpg.R;

public class chapter4  extends android.app.Activity{

    private Button ContentsButton;
    private Button NextButton;
    private Button PreviousButton;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragement_ch4);
        ScrollView sv = (ScrollView)findViewById(R.id.scrl);
        Button Button1 = findViewById(R.id.Button1);
        Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView text = findViewById(R.id.SubTitle1);
                sv.scrollTo(0, text.getTop());
            }
        });
        Button Button2 = findViewById(R.id.Button2);
        Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView text = findViewById(R.id.SubTitle2);
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
                Intent intent = new Intent(chapter4.this, chapter5.class);
                startActivity(intent);
                finish();
            }
        });

        PreviousButton = findViewById(R.id.PreviousButton);
        PreviousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(chapter4.this, chapter3.class);
                startActivity(intent);
                finish();
            }
        });
    }
}

