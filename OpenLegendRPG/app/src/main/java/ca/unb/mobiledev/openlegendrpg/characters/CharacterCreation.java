package ca.unb.mobiledev.openlegendrpg.characters;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import ca.unb.mobiledev.openlegendrpg.Items.Character;
import ca.unb.mobiledev.openlegendrpg.R;

public class CharacterCreation extends android.app.Activity
{
    public static final String EXTRA_REPLY = "ca.unb.mobiledev.openlegendrpg.REPLY";

    private EditText charNameET;
    private Button saveButton; //use to save character
    private Button cancelButton; //use to exit activity without saving


    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_character_creation);

        charNameET = findViewById(R.id.characterNameET);

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