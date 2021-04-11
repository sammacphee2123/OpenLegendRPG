package ca.unb.mobiledev.openlegendrpg.characters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import java.util.concurrent.ExecutionException;

import ca.unb.mobiledev.openlegendrpg.MainActivity;
import ca.unb.mobiledev.openlegendrpg.UI.characterViewModel;
import ca.unb.mobiledev.openlegendrpg.Items.Character;
import ca.unb.mobiledev.openlegendrpg.R;

public class CharacterCreation extends AppCompatActivity
{
    characterViewModel charView;
    private EditText charNameET, playerNameET, levelET, expET, descET, armorET, guardOtherET,
            resolveOtherET, toughnessOtherET, currentHPET, lethalHPET, legendET, wealthET, speedET,
            equipmentET, additionalET, agilityET, fortitudeET, mightET, deceptionET, persuasionET,
            presenceET, learningET, logicET, perceptionET, willET, alterationET, creationET,
            energyET, entropyET, influenceET, movementET, prescienceET, protectionET;
    private TextView attributesTotalTV, featsTotalTV, guardTV, toughnessTV, resolveTV, maxHPTV,
            guard_agilityTV, guard_mightTV, toughness_fortitudeTV, toughness_willTV,
            resolve_presenceTV, resolve_willTV;
    private Button saveButton; //use to save character
    private Button cancelButton; //use to exit activity without saving

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_character_creation);

        charNameET = findViewById(R.id.characterNameET);
        playerNameET = findViewById(R.id.playerNameET);
        levelET = findViewById(R.id.levelET);
        expET = findViewById(R.id.experienceET);
        descET = findViewById(R.id.descriptionET);
        armorET = findViewById(R.id.guard_armorET);
        guardOtherET = findViewById(R.id.guard_otherET);
        toughnessOtherET = findViewById(R.id.toughness_otherET);
        resolveOtherET = findViewById(R.id.resolve_otherET);
        currentHPET = findViewById(R.id.currentET);
        lethalHPET = findViewById(R.id.lethalET);
        legendET = findViewById(R.id.legendET);
        wealthET = findViewById(R.id.wealthET);
        speedET = findViewById(R.id.speedET);
        equipmentET = findViewById(R.id.equipmentET);
        additionalET = findViewById(R.id.additionalET);
        agilityET = findViewById(R.id.agilityScoreET);
        fortitudeET = findViewById(R.id.fortitudeScoreET);
        mightET = findViewById(R.id.mightScoreET);
        deceptionET = findViewById(R.id.deceptionScoreET);
        persuasionET = findViewById(R.id.persuasionScoreET);
        presenceET = findViewById(R.id.presenceScoreET);
        learningET = findViewById(R.id.learningScoreET);
        logicET = findViewById(R.id.logicScoreET);
        perceptionET = findViewById(R.id.perceptionScoreET);
        willET = findViewById(R.id.willScoreET);
        alterationET = findViewById(R.id.alterationScoreET);
        creationET = findViewById(R.id.creationScoreET);
        energyET = findViewById(R.id.energyScoreET);
        entropyET = findViewById(R.id.entropyScoreET);
        influenceET = findViewById(R.id.influenceScoreET);
        movementET = findViewById(R.id.movementScoreET);
        prescienceET = findViewById(R.id.prescienceScoreET);
        protectionET = findViewById(R.id.protectionScoreET);

        attributesTotalTV = findViewById(R.id.attributeTotalTV);
        featsTotalTV = findViewById(R.id.featsTotalTV);
        guardTV = findViewById(R.id.guardNumTV);
        toughnessTV = findViewById(R.id.ToughnessNumTV);
        resolveTV = findViewById(R.id.ResolveNumTV);
        maxHPTV = findViewById(R.id.maxhpTV);
        guard_agilityTV = findViewById(R.id.guard_agilityTV);
        guard_mightTV = findViewById(R.id.guard_mightTV);
        toughness_fortitudeTV = findViewById(R.id.toughness_fortitudeTV);
        toughness_willTV = findViewById(R.id.toughness_willTV);
        resolve_presenceTV = findViewById(R.id.resolve_presenceTV);
        resolve_willTV = findViewById(R.id.resolve_willTV);

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
                String charName = charNameET.getText().toString();
                String playerName = playerNameET.getText().toString();
                String desc = descET.getText().toString();

                int level, exp, armor, guardOther, toughnessOther, resolveOther, currentHP, lethalHP;
                //level and exp
                level =  getInt(levelET.getText().toString());
                exp = getInt(expET.getText().toString());
                Integer atotal = 40 + ((level - 1)*9 + (3 * exp));
                attributesTotalTV.setText(atotal.toString());
                Integer fTotal = 3 + (3 * level) + exp;
                featsTotalTV.setText(fTotal.toString());
                //Attributes
                int agility = getInt(agilityET.getText().toString());
                int fortitude =  getInt(fortitudeET.getText().toString());
                int might =  getInt(mightET.getText().toString());
                int deception =  getInt(deceptionET.getText().toString());
                int persuasion =  getInt(persuasionET.getText().toString());
                int presence =  getInt(presenceET.getText().toString());
                int learning =  getInt(learningET.getText().toString());
                int logic =  getInt(logicET.getText().toString());
                int perception =  getInt(perceptionET.getText().toString());
                int will =  getInt(willET.getText().toString());
                int alteration =  getInt(alterationET.getText().toString());
                int creation =  getInt(creationET.getText().toString());
                int energy =  getInt(energyET.getText().toString());
                int entropy =  getInt(entropyET.getText().toString());
                int influence =  getInt(influenceET.getText().toString());
                int movement =  getInt(movementET.getText().toString());
                int prescience =  getInt(prescienceET.getText().toString());
                int protection =  getInt(protectionET.getText().toString());
                //Guard
                System.out.println("test");
                System.out.println(armorET.getText().toString());
                armor = getInt(armorET.getText().toString());
                guardOther = getInt(guardOtherET.getText().toString());
                Integer guard = 10 + guardOther + armor + might + agility;
                guardTV.setText(guard.toString());
                guard_agilityTV.setText(String.valueOf(agility));
                guard_mightTV.setText(String.valueOf(might));
                //Toughness
                toughnessOther = getInt(toughnessOtherET.getText().toString());
                Integer toughness = 10 + toughnessOther + fortitude + will;
                toughnessTV.setText(toughness.toString());
                toughness_fortitudeTV.setText(String.valueOf(fortitude));
                toughness_willTV.setText(String.valueOf(will));
                //Resolve
                resolveOther = getInt(resolveOtherET.getText().toString());
                Integer resolve = 10 + resolveOther + presence + will;
                resolveTV.setText(resolve.toString());
                resolve_presenceTV.setText(String.valueOf(presence));
                resolve_willTV.setText(String.valueOf(will));
                //Hit points
                currentHP = getInt(currentHPET.getText().toString());
                lethalHP = getInt(lethalHPET.getText().toString());
                Integer maxHP = (2 * (fortitude + presence + will)) + 10;
                maxHPTV.setText(maxHP.toString());
                //Initiative

                //Legend, wealth, speed
                int legend = getInt(legendET.getText().toString());
                int wealth = getInt(wealthET.getText().toString());
                int speed = getInt(speedET.getText().toString());
                //Feats
                //Perks and flaws
                //Other details
                String equipment = equipmentET.getText().toString();
                String additional = additionalET.getText().toString();


                if(!TextUtils.isEmpty(charName)){
                    try {
                        createCharacter(charName, playerName, level, exp, desc, lethalHP, currentHP,
                                legend, wealth, speed, guardOther, toughnessOther, resolveOther, armor,
                                equipment, additional, agility, fortitude, might, deception,
                                persuasion, presence, learning, logic, perception, will,
                                alteration, creation, energy, entropy, influence, movement,
                                prescience, protection);
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                else{
                    Context context = getApplicationContext();
                    String text = "Please enter a character name";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });
    }

    private void createCharacter(String charName, String playerName,
                                 int level, int exp, String desc, int lethalHP, int currentHP,
                                 int legend, int wealth, int speed,
                                 int guardOther, int toughnessOther, int resolveOther, int armor,
                                 String equipment, String additional, int agility, int fortitude,
                                 int might, int deception, int persuasion, int presence, int learning,
                                 int logic, int perception, int will, int alteration, int creation,
                                 int energy, int entropy, int influence, int movement,
                                 int prescience, int protection)
            throws ExecutionException, InterruptedException{
        charView = new ViewModelProvider(this).get(characterViewModel.class);
        String userId = MainActivity.getUser().getName();
        Character character = new Character(charName, playerName, level, exp, desc,
                lethalHP, currentHP, legend, wealth, speed, guardOther,
                toughnessOther, resolveOther, armor , equipment,
                additional,  userId, agility, fortitude, might, deception, persuasion , presence,
                learning, logic, perception, will, alteration, creation, energy,
                entropy,influence,movement, prescience ,protection);
        charView.insert(character);
    }

    private static Integer getInt(String s){
        if(s.isEmpty()) return 0;
        return Integer.parseInt(s);
    }
}