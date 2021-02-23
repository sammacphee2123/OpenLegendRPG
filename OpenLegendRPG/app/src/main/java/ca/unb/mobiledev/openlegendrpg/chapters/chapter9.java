package ca.unb.mobiledev.openlegendrpg.chapters;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ca.unb.mobiledev.openlegendrpg.R;

public class chapter9  extends android.app.Activity{

    private Button ContentsButton;
    private Button PreviousButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragement_ch9);

        ContentsButton = findViewById(R.id.TableButton);
        ContentsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        PreviousButton = findViewById(R.id.PreviousButton);
        PreviousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(chapter9.this, chapter8.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
