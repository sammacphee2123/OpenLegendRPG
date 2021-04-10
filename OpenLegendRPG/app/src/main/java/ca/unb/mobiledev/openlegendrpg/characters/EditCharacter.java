package ca.unb.mobiledev.openlegendrpg.characters;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;

import ca.unb.mobiledev.openlegendrpg.Items.Character;
import ca.unb.mobiledev.openlegendrpg.MainActivity;
import ca.unb.mobiledev.openlegendrpg.R;

import static ca.unb.mobiledev.openlegendrpg.characters.CharacterCreation.EXTRA_REPLY;

public class EditCharacter extends android.app.Activity {
    private Button saveButton; //use to save character
    private Button cancelButton; //use to exit activity without saving
    private EditText charNameET;
    private EditText playerNameET;
    private EditText levelET;
    private EditText experienceET;
    private EditText descriptionET;
    private EditText lethalET;
    private EditText currentET;
    private EditText legendET;
    private EditText wealthET;
    private EditText speedET;
    private EditText guardOtherET;
    private EditText toughnessOtherET;
    private EditText resolveOtherET;
    private EditText armorET;
    private EditText equipmentET;
    private EditText additionalNotesET;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_character_creation);
        //SET ALL VALUES
        Intent intent = getIntent();
        String charName = intent.getStringExtra("charName");
        String playerName = intent.getStringExtra("playerName");
        int level = intent.getIntExtra("level", 0);
        int experience = intent.getIntExtra("experience", 0);
        String description = intent.getStringExtra("description");
        int lethal = intent.getIntExtra("lethal", 0);
        int current  = intent.getIntExtra("current", 0);
        int legend = intent.getIntExtra("legend", 0);
        int wealth = intent.getIntExtra("wealth", 0);
        int speed = intent.getIntExtra("speed", 0);
        int guardOther = intent.getIntExtra("guardOther", 0);
        int toughnessOther = intent.getIntExtra("toughnessOther", 0);
        int  resolveOther = intent.getIntExtra("resolveOther", 0);
        int armor = intent.getIntExtra("armor", 0);
        String equipment = intent.getStringExtra("equipment");
        String additionalNotes = intent.getStringExtra("additionalNotes");
        String userId = intent.getStringExtra("userId");
        charNameET= findViewById(R.id.characterNameET);
        charNameET.setText(charName);
        playerNameET= findViewById(R.id.playerNameET);
        playerNameET.setText(playerName);
        levelET= findViewById(R.id.levelET);
        levelET.setText(String.valueOf(level));
        experienceET= findViewById(R.id.experienceET);
        experienceET.setText(String.valueOf(experience));
        descriptionET= findViewById(R.id.descriptionET);
        descriptionET.setText(description);
        lethalET= findViewById(R.id.lethalET);
        lethalET.setText(String.valueOf(lethal));
        currentET= findViewById(R.id.currentET);
        currentET.setText(String.valueOf(current));
        legendET= findViewById(R.id.legendET);
        legendET.setText(String.valueOf(legend));
        wealthET= findViewById(R.id.wealthET);
        wealthET.setText(String.valueOf(wealth));
        speedET= findViewById(R.id.speedET);
        speedET.setText(String.valueOf(speed));
        guardOtherET= findViewById(R.id.guard_otherET);
        guardOtherET.setText(String.valueOf(guardOther));
        toughnessOtherET= findViewById(R.id.toughness_otherET);
        toughnessOtherET.setText(String.valueOf(toughnessOther));
        resolveOtherET= findViewById(R.id.resolve_otherET);
        resolveOtherET.setText(String.valueOf(resolveOther));
        armorET= findViewById(R.id.guard_armorET);
        armorET.setText(String.valueOf(armor));
        equipmentET= findViewById(R.id.equipmentET);
        additionalNotesET= findViewById(R.id.additionalET);


        cancelButton = findViewById(R.id.cancelCharCreationButton);
        cancelButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                finish();
            }
        });

        saveButton = findViewById(R.id.saveCharButton);
        saveButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //add character to database
                Intent replyIntent = new Intent();
                if(TextUtils.isEmpty(charNameET.getText()))
                {
                    setResult(RESULT_CANCELED, replyIntent);
                }
                else
                {
                    String name = charNameET.getText().toString();
                    replyIntent.putExtra(EXTRA_REPLY, name);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });
    }
}