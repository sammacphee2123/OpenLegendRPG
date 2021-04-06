package ca.unb.mobiledev.openlegendrpg.chapters;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import ca.unb.mobiledev.openlegendrpg.R;

public class chapter6  extends android.app.Activity{

    private Button ContentsButton;
    private Button NextButton;
    private Button PreviousButton;
    private Button wealthTitle;
    private Button carryingCapacityTitle;
    private Button weaponsAndImplementsTitle;
    private Button armorTitle;
    private Button buildingWeaponsTitle;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_ch6);

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

        wealthTitle = findViewById(R.id.wealthButton);
        wealthTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView text = findViewById(R.id.ch6_wealth_title);
                ScrollView sv = findViewById(R.id.scrl_ch6);
                sv.scrollTo(0, text.getTop());
            }
        });

        carryingCapacityTitle = findViewById(R.id.carryingCapacityButton);
        carryingCapacityTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView text = findViewById(R.id.ch6_carrying_capacity_title);
                ScrollView sv = findViewById(R.id.scrl_ch6);
                sv.scrollTo(0, text.getTop());
            }
        });

        weaponsAndImplementsTitle = findViewById(R.id.weaponsAndImplementsButton);
        weaponsAndImplementsTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView text = findViewById(R.id.ch6_weapons_and_implements);
                ScrollView sv = findViewById(R.id.scrl_ch6);
                sv.scrollTo(0, text.getTop());
            }
        });

        armorTitle = findViewById(R.id.armorButton);
        armorTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView text = findViewById(R.id.ch6_armor_title);
                ScrollView sv = findViewById(R.id.scrl_ch6);
                sv.scrollTo(0, text.getTop());
            }
        });

        buildingWeaponsTitle = findViewById(R.id.buildWeaponsButton);
        buildingWeaponsTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView text = findViewById(R.id.ch6_building_weapons_title);
                ScrollView sv = findViewById(R.id.scrl_ch6);
                sv.scrollTo(0, text.getTop());
            }
        });

    }
}

