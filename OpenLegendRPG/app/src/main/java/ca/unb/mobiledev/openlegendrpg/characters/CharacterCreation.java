package ca.unb.mobiledev.openlegendrpg.characters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
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
            resolveOtherET, toughnessOtherET, currentHPET, lethalHPET, initADVET, legendET, wealthET, speedET,
            equipmentET, additionalET, agilityET, fortitudeET, mightET, deceptionET, persuasionET,
            presenceET, learningET, logicET, perceptionET, willET, alterationET, creationET,
            energyET, entropyET, influenceET, movementET, prescienceET, protectionET;
    private TextView attributesTotalTV, featsTotalTV, guardTV, toughnessTV, resolveTV, maxHPTV,
            initTV, guard_agilityTV, guard_mightTV, toughness_fortitudeTV, toughness_willTV,
            resolve_presenceTV, resolve_willTV, agility_costTV, agility_diceTV, fortitude_costTV,
            fortitude_diceTV, might_costTV, might_diceTV, learning_costTV, learning_diceTV,
            logic_costTV, logic_diceTV, perception_costTV, perception_diceTV, will_costTV,
            will_diceTV, deception_costTV, deception_diceTV, persuasion_costTV, persuasion_diceTV,
            presence_costTV, presence_diceTV, alteration_costTV, alteration_diceTV, creation_costTV,
            creation_diceTV, energy_costTV, energy_diceTV, entropy_costTV, entropy_diceTV,
            influence_costTV, influence_diceTV, movement_costTV, movement_diceTV, prescience_costTV,
            prescience_diceTV, protection_costTV, protection_diceTV;
    private AutoCompleteTextView mPerk1AT, mFlaw1AT, mPerk2AT, mFlaw2AT;
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
        initADVET = findViewById(R.id.advantageET);
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
        initTV = findViewById(R.id.d20TV);
        guard_agilityTV = findViewById(R.id.guard_agilityTV);
        guard_mightTV = findViewById(R.id.guard_mightTV);
        toughness_fortitudeTV = findViewById(R.id.toughness_fortitudeTV);
        toughness_willTV = findViewById(R.id.toughness_willTV);
        resolve_presenceTV = findViewById(R.id.resolve_presenceTV);
        resolve_willTV = findViewById(R.id.resolve_willTV);
        agility_costTV = findViewById(R.id.agilityCost);
        agility_diceTV = findViewById(R.id.agilityDice);
        fortitude_costTV = findViewById(R.id.fortitudeCost);
        fortitude_diceTV = findViewById(R.id.fortitudeDice);
        might_costTV = findViewById(R.id.mightCost);
        might_diceTV = findViewById(R.id.mightDice);
        learning_costTV = findViewById(R.id.learningCost);
        learning_diceTV = findViewById(R.id.leaningDice);
        logic_costTV = findViewById(R.id.logicCost);
        logic_diceTV = findViewById(R.id.logicDice);
        perception_costTV = findViewById(R.id.perceptionCost);
        perception_diceTV = findViewById(R.id.perceptionDice);
        will_costTV = findViewById(R.id.willCost);
        will_diceTV = findViewById(R.id.willDice);
        deception_costTV = findViewById(R.id.deceptionCost);
        deception_diceTV = findViewById(R.id.deceptionDice);
        persuasion_costTV = findViewById(R.id.persuasionCostTV);
        persuasion_diceTV = findViewById(R.id.persuasionDiceTV);
        presence_costTV = findViewById(R.id.presenceCostTV);
        presence_diceTV = findViewById(R.id.presenceDiceTV);
        alteration_costTV = findViewById(R.id.alterationCostTV);
        alteration_diceTV = findViewById(R.id.alterationDiceTV);
        creation_costTV = findViewById(R.id.creationCostTV);
        creation_diceTV = findViewById(R.id.creationDiceTV);
        energy_costTV = findViewById(R.id.energyCostTV);
        energy_diceTV = findViewById(R.id.energyDiceTV);
        entropy_costTV = findViewById(R.id.entropyCostTV);
        entropy_diceTV = findViewById(R.id.entropyDiceTV);
        influence_costTV = findViewById(R.id.infleuenceCostTV);
        influence_diceTV = findViewById(R.id.influenceDiceTV);
        movement_costTV = findViewById(R.id.movementCostTV);
        movement_diceTV = findViewById(R.id.movementDiceTV);
        prescience_costTV = findViewById(R.id.prescienceCostTV);
        prescience_diceTV = findViewById(R.id.prescienceDiceTV);
        protection_costTV = findViewById(R.id.protectionCostTV);
        protection_diceTV = findViewById(R.id.protectionDiceTV);


        mPerk1AT = findViewById(R.id.perk1);
        mPerk2AT = findViewById(R.id.perk2);
        mFlaw1AT = findViewById(R.id.flaw1);
        mFlaw2AT = findViewById(R.id.flaw2);


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
                agility_costTV.setText(getCost(agility).toString());
                agility_diceTV.setText(getDice(agility));
                int fortitude =  getInt(fortitudeET.getText().toString());
                fortitude_costTV.setText(getCost(fortitude).toString());
                fortitude_diceTV.setText(getDice(fortitude));
                int might =  getInt(mightET.getText().toString());
                might_costTV.setText(getCost(might).toString());
                might_diceTV.setText(getDice(might));
                int deception =  getInt(deceptionET.getText().toString());
                deception_costTV.setText(getCost(deception).toString());
                deception_diceTV.setText(getDice(deception));
                int persuasion =  getInt(persuasionET.getText().toString());
                persuasion_costTV.setText(getCost(persuasion).toString());
                persuasion_diceTV.setText(getDice(persuasion));
                int presence =  getInt(presenceET.getText().toString());
                presence_costTV.setText(getCost(presence).toString());
                presence_diceTV.setText(getDice(presence));
                int learning =  getInt(learningET.getText().toString());
                learning_costTV.setText(getCost(learning).toString());
                learning_diceTV.setText(getDice(learning));
                int logic =  getInt(logicET.getText().toString());
                logic_costTV.setText(getCost(logic).toString());
                logic_diceTV.setText(getDice(logic));
                int perception =  getInt(perceptionET.getText().toString());
                perception_costTV.setText(getCost(perception).toString());
                perception_diceTV.setText(getDice(perception));
                int will =  getInt(willET.getText().toString());
                will_costTV.setText(getCost(will).toString());
                will_diceTV.setText(getDice(will));
                int alteration =  getInt(alterationET.getText().toString());
                alteration_costTV.setText(getCost(alteration).toString());
                alteration_diceTV.setText(getDice(alteration));
                int creation =  getInt(creationET.getText().toString());
                creation_costTV.setText(getCost(creation).toString());
                creation_diceTV.setText(getDice(creation));
                int energy =  getInt(energyET.getText().toString());
                energy_costTV.setText(getCost(energy).toString());
                energy_diceTV.setText(getDice(energy));
                int entropy =  getInt(entropyET.getText().toString());
                entropy_costTV.setText(getCost(entropy).toString());
                entropy_diceTV.setText(getDice(entropy));
                int influence =  getInt(influenceET.getText().toString());
                influence_costTV.setText(getCost(influence).toString());
                influence_diceTV.setText(getDice(influence));
                int movement =  getInt(movementET.getText().toString());
                movement_costTV.setText(getCost(movement).toString());
                movement_diceTV.setText(getDice(movement));
                int prescience =  getInt(prescienceET.getText().toString());
                prescience_costTV.setText(getCost(prescience).toString());
                prescience_diceTV.setText(getDice(prescience));
                int protection =  getInt(protectionET.getText().toString());
                protection_costTV.setText(getCost(protection).toString());
                protection_diceTV.setText(getDice(protection));
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
                initTV.setText(agility);
                int initADV = getInt(initADVET.getText().toString());
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

                        boolean isUnique = createCharacter(charName, playerName, level, exp, desc, lethalHP, currentHP,
                                initADV, legend, wealth, speed, guardOther, toughnessOther,
                                resolveOther, armor, equipment, additional, agility, fortitude,
                                might, deception, persuasion, presence, learning, logic, perception,
                                will, alteration, creation, energy, entropy, influence, movement,
                                prescience, protection);
                        if(isUnique){
                            Context context = getApplicationContext();
                            String text = "Please enter a unique character name";
                            int duration = Toast.LENGTH_SHORT;
                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();
                        }
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
        String[] perks= getResources().getStringArray(R.array.perks);
        String[] flaws= getResources().getStringArray(R.array.flaws);
        ArrayAdapter<String> perkAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, perks);
        ArrayAdapter<String> flawAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, flaws);
        mPerk1AT.setAdapter(perkAdapter);
        mPerk2AT.setAdapter(perkAdapter);
        mFlaw1AT.setAdapter(flawAdapter);
        mFlaw2AT.setAdapter(flawAdapter);
    }

    private boolean createCharacter(String charName, String playerName,
                                 int level, int exp, String desc, int lethalHP, int currentHP,
                                 int initADV, int legend, int wealth, int speed,
                                 int guardOther, int toughnessOther, int resolveOther, int armor,
                                 String equipment, String additional, int agility, int fortitude,
                                 int might, int deception, int persuasion, int presence, int learning,
                                 int logic, int perception, int will, int alteration, int creation,
                                 int energy, int entropy, int influence, int movement,
                                 int prescience, int protection)
            throws ExecutionException, InterruptedException{
        charView = new ViewModelProvider(this).get(characterViewModel.class);
        String userId = MainActivity.getUser().getName();
        boolean isUnique = false;
        Character character = new Character(charName, playerName, level, exp, desc,
                lethalHP, currentHP, initADV, legend, wealth, speed, guardOther,
                toughnessOther, resolveOther, armor , equipment,
                additional, userId, agility, fortitude, might, deception, persuasion , presence,
                learning, logic, perception, will, alteration, creation, energy,
                entropy,influence,movement, prescience ,protection);
        isUnique = charView.insert(character);
        return isUnique;
    }

    private static Integer getInt(String s){
        if(s.isEmpty()) return 0;
        return Integer.parseInt(s);
    }

    public Integer getCost(int attribute){
        Integer cost = 0;
        for(int temp = attribute; temp > 0; temp--){
            cost += temp;
        }
        return cost;
    }
    public String getDice(int attribute){
        String Dice = "";
        switch(attribute){
            case 1:
                Dice = "d4";
                break;
            case 2:
                Dice = "d6";
                break;
            case 3:
                Dice = "d8";
                break;
            case 4:
                Dice = "d10";
                break;
            case 5:
                Dice = "2d6";
                break;
            case 6:
                Dice = "2d8";
                break;
            case 7:
                Dice = "2d10";
                break;
            case 8:
                Dice = "3d8";
                break;
            case 9:
                Dice = "3d10";
                break;

        }
        return Dice;
    }
}