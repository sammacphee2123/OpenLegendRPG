package ca.unb.mobiledev.openlegendrpg.chapters;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import ca.unb.mobiledev.openlegendrpg.R;
public class introduction extends android.app.Activity {
    private Button ContentsButton;
    private Button NextButton;
/////////////////////////////////////////////////////////connect two buttons////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("please: ", "onCreate() called");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragement_intro);
        ScrollView sv = (ScrollView)findViewById(R.id.scrl);
        Button Button1 = findViewById(R.id.whatDefinesOpenLegend);
        Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView text = findViewById(R.id.whatDefinesOpenLegend_Title);
                sv.scrollTo(0, text.getTop());
            }
        });
        Button Button2 = findViewById(R.id.theActionRoll);
        Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView text = findViewById(R.id.theActionRoll_Title);
                sv.scrollTo(0, text.getTop());
            }
        });
        Button Button3 = findViewById(R.id.treasures);
        Button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView text = findViewById(R.id.treasures_Title);
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
                Intent intent = new Intent(introduction.this, chapter1.class);
                startActivity(intent);
                finish();
            }
        });
    }
}


