package com.journaldev.navigationdrawer.feats;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

import ca.unb.mobiledev.openlegendrpg.R;


public class FeatsFragment extends Fragment {

    RecyclerView recyclerView;
    List<Feat> featsList;

    public FeatsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_feats, container, false);

        featsList = new ArrayList<>();
        recyclerView = rootView.findViewById(R.id.recyclerView);

        initData();
        initRecyclerView();

        return rootView;
    }

    private void initRecyclerView() {
        FeatAdapter featAdapter = new FeatAdapter(featsList);
        recyclerView.setAdapter(featAdapter);
    }

    private void initData() {
        featsList = new ArrayList<>();
        featsList.add(new Feat("cost: 3 points", "Alternate Form (I - II)", "Prerequisites:\n\n\t - Tier I-II: none", "Description:\n\tYou have the ability to transform from one persona to another, whether that be through bodily transformation like a werewolf or through exterior mechanisms, such as a cybernetically enhanced soldier who can call forth a symbiotic mech suit.", "Effect:\n\tUpon taking this feat, you build a single alternate form using the normal character creation rules, though your attribute and feat points are determined by your tier in this feat:\n\n\t - Tier 1: Half of your primary form's attribute points (rounded up), and 3 feat points.\n\n\t - Tier 2: Same attribute points as your primary form, and 3 feat points less than your primary form.\n\n\tWhenever your primary form gains new attribute points or levels up, your alternate form also gains points according to the above formulas.\n\n\tAs a focus action, you may change between any two forms (including your primary form or any alternate form). You maintain this capability in all of your forms. Each form is treated as a completely different character for mechanical purposes - possessing different attributes, feats, perks, flaws, and other defining characteristics. Your alternate form does, however, retain the ability to transform back into your primary form.\n\n\tIn order to keep track of hit points, you should always record the total damage that your character has suffered. When transforming, your damage remains with you even if your maximum hit points change. For example, Dr. Jekyll has a max HP of 15 and Mr. Hyde has a max HP of 30. During combat, Mr. Hyde suffers 10 damage. When he later transforms back into Dr. Jekyll, the 10 damage remains and is subtracted from his new maximum, leaving the doctor with 5 out of 15 hit points. Additionally, when changing forms, if your hit points would be reduced to less than 1, your hit point total becomes 1 instead.", "Special:\n\tWhen selecting feats for your alternate form, you may not select the Alternate Form feat.\nWith GM approval, you may take this feat multiple times. If you do, you get access to an additional form. Multiple Alternate Forms can be a powerful way of accumulating new feat points and attributes. The GM should prevent players from exploiting the feat to create an overly powerful character.\n"));
        featsList.add(new Feat(null,"Area Manipulation (I-V)", null, null,null,null));
         featsList.add(new Feat(null,"Armor Mastery (I-II)", null, null,null,null));
         featsList.add(new Feat(null,"Attack Redirection", null, null,null,null));
         featsList.add(new Feat(null,"Attack Specialization (I-IX)", null, null,null,null));
         featsList.add(new Feat(null,"Attribute Substitution (I-II)", null, null,null,null));
         featsList.add(new Feat(null,"Bane Focus", null, null,null,null));
         featsList.add(new Feat(null,"Battle Trance", null, null,null,null));
         featsList.add(new Feat(null,"Battlefield Opportunist (I-V)", null, null,null,null));
         featsList.add(new Feat(null,"Battlefield Punisher", null, null,null,null));
         featsList.add(new Feat(null,"Battlefield Retribution", null, null,null,null));
         featsList.add(new Feat(null,"Boon Access", null, null,null,null));
         featsList.add(new Feat(null,"Boon Focus (I-III)", null, null,null,null));
         featsList.add(new Feat(null,"Breakfall", null, null,null,null));
         featsList.add(new Feat(null,"Brutal Intimidation", null, null,null,null));
         featsList.add(new Feat(null,"Climbing", null, null,null,null));
         featsList.add(new Feat(null,"Combat Follow-Through", null, null,null,null));
         featsList.add(new Feat(null,"Combat Momentum", null, null,null,null));
         featsList.add(new Feat(null,"Companion (I-III)", null, null,null,null));
         featsList.add(new Feat(null,"Craft Mundane Item", null, null,null,null));
         featsList.add(new Feat(null,"Craft Extraordinary Item (I-III)", null, null,null,null));
         featsList.add(new Feat(null,"Crushing Blow", null, null,null,null));
         featsList.add(new Feat(null,"Death Blow", null, null,null,null));
         featsList.add(new Feat(null,"Deathless Trance", null, null,null,null));
         featsList.add(new Feat(null,"Defensive Mastery", null, null,null,null));
         featsList.add(new Feat(null,"Defensive Reflexes (I-IX)", null, null,null,null));
         featsList.add(new Feat(null,"Destructive Trance", null, null,null,null));
         featsList.add(new Feat(null,"Diehard", null, null,null,null));
         featsList.add(new Feat(null,"Energy Resistance (I-IV)", null, null,null,null));
         featsList.add(new Feat(null,"Evasive Footwork", null, null,null,null));
         featsList.add(new Feat(null,"Extraordinary Defense (I-III)", null, null,null,null));
         featsList.add(new Feat(null,"Extraordinary Focus", null, null,null,null));
         featsList.add(new Feat(null,"Extraordinary Healing", null, null,null,null));
         featsList.add(new Feat(null,"Fast Draw", null, null,null,null));
         featsList.add(new Feat(null,"Fast Tracker", null, null,null,null));
         featsList.add(new Feat(null,"Ferocious Minions (I-III)", null, null,null,null));
         featsList.add(new Feat(null,"Fleet of Foot (I-III)", null, null,null,null));
         featsList.add(new Feat(null,"Flying", null, null,null,null));
         featsList.add(new Feat(null,"Great Leap", null, null,null,null));
         featsList.add(new Feat(null,"Hallucination (I-II)", null, null,null,null));
         featsList.add(new Feat(null,"Heightened Invocation (I-III)", null, null,null,null));
         featsList.add(new Feat(null,"Hospitaler", null, null,null,null));
         featsList.add(new Feat(null,"Impervious Trance", null, null,null,null));
         featsList.add(new Feat(null,"Indomitabe Endurance (I-V)", null, null,null,null));
         featsList.add(new Feat(null,"Indomitable Resolve (I-III)", null, null,null,null));
         featsList.add(new Feat(null,"Inspiring Champion (I-III)", null, null,null,null));
         featsList.add(new Feat(null,"Knowledge (I-III)", null, null,null,null));
         featsList.add(new Feat(null,"Lethal Strike (I-IX)", null, null,null,null));
         featsList.add(new Feat(null,"Lightning Reflexes (I-V)", null, null,null,null));
         featsList.add(new Feat(null,"Longshot", null, null,null,null));
         featsList.add(new Feat(null,"Silencing Strike", null, null,null,null));
         featsList.add(new Feat(null,"Martial Focus", null, null,null,null));
         featsList.add(new Feat(null,"Master Tracker", null, null,null,null));
         featsList.add(new Feat(null,"Mimic", null, null,null,null));
         featsList.add(new Feat(null,"Multi-Attack Specialist (I-VI)", null, null,null,null));
         featsList.add(new Feat(null,"Multi-Bane Specialist", null, null,null,null));
         featsList.add(new Feat(null,"Multi-Target Attack Specialist (I-V)", null, null,null,null));
         featsList.add(new Feat(null,"Multi-Target Boon Expert", null, null,null,null));
         featsList.add(new Feat(null,"Multi-Target Boon Specialist (I-IX)", null, null,null,null));
         featsList.add(new Feat(null,"Natural Defense (I-III)", null, null,null,null));
         featsList.add(new Feat(null,"Overpowering Strike", null, null,null,null));
         featsList.add(new Feat(null,"Potent Bane", null, null,null,null));
         featsList.add(new Feat(null,"Reactionary Trance", null, null,null,null));
         featsList.add(new Feat(null,"Reckless Attack", null, null,null,null));
         featsList.add(new Feat(null,"Resilient", null, null,null,null));
         featsList.add(new Feat(null,"Sentinal (I-III)", null, null,null,null));
         featsList.add(new Feat(null,"Skill Specialization (I-V)", null, null,null,null));
         featsList.add(new Feat(null,"Superior Concentration (I-III)", null, null,null,null));
         featsList.add(new Feat(null,"Swimming", null, null,null,null));
         featsList.add(new Feat(null,"Sworn Enemy (I-IX)", null, null,null,null));
         featsList.add(new Feat(null,"Tough as Nails (I-II)", null, null,null,null));
         featsList.add(new Feat(null,"Two Weapon Brute", null, null,null,null));
         featsList.add(new Feat(null,"Two Weapon Defense", null, null,null,null));
         featsList.add(new Feat(null,"Unending Charm", null, null,null,null));
         featsList.add(new Feat(null,"Untrackable", null, null,null,null));
         featsList.add(new Feat(null,"Vicious Strike", null, null,null,null));
         featsList.add(new Feat(null,"Wealthy", null, null,null,null));
         featsList.add(new Feat(null,"Well-Rounded", null, null,null,null));
    }

}
