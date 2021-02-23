package ca.unb.mobiledev.openlegendrpg.chapters;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ca.unb.mobiledev.openlegendrpg.R;

public class chapter6  extends android.app.Activity{

    private Button ContentsButton;
    private Button NextButton;
    private Button PreviousButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragement_ch6);

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
                Intent intent = new Intent(chapter6.this, chapter7.class);
                startActivity(intent);
                finish();
            }
        });

        PreviousButton = findViewById(R.id.PreviousButton);
        PreviousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(chapter6.this, chapter5.class);
                startActivity(intent);
                finish();
            }
        });
    }
}

