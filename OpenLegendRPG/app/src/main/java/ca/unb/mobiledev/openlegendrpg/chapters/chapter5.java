package ca.unb.mobiledev.openlegendrpg.chapters;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
    }
}

