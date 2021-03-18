package ca.unb.mobiledev.openlegendrpg.chapters;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ca.unb.mobiledev.openlegendrpg.R;

public class chapter4  extends android.app.Activity{

    private Button ContentsButton;
    private Button NextButton;
    private Button PreviousButton;
    /////////////////////////////////////////////////////////////////////////////make this clickable in reading feats, send to feats page/////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////make this bold in reading feats Title. Cost. Perquisites. Description. Effect.//////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////create buttons for the two subjects/////////////////////////////////////////////////////////////
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragement_ch4);

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

