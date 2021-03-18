package ca.unb.mobiledev.openlegendrpg.chapters;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import ca.unb.mobiledev.openlegendrpg.R;

public class introduction extends android.app.Activity {

    private Button ContentsButton;
    private Button NextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("please: ", "onCreate() called");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragement_intro);

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
                Intent intent = new Intent(introduction.this, chapter1.class);
                startActivity(intent);
                finish();
            }
        });
    }
}


