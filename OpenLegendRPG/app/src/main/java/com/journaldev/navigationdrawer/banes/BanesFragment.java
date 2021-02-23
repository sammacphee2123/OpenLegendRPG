package com.journaldev.navigationdrawer.banes;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ca.unb.mobiledev.openlegendrpg.R;

public class BanesFragment extends Fragment
{
    RecyclerView recyclerView;
    List<Bane> banesList;

    public BanesFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_banes, container, false);

        banesList = new ArrayList<>();
        recyclerView = rootView.findViewById(R.id.recyclerView);

        initData();
        initRecyclerView();

        return rootView;
    }

    private void initRecyclerView()
    {
        BaneAdapter baneAdapter = new BaneAdapter(banesList);
        recyclerView.setAdapter(baneAdapter);
    }

    private void initData()
    {
        banesList = new ArrayList<>();
        banesList.add(new Bane("Blinded", "Power Level: 5", "You blind your foe with anything from a massive explosion, to a handful of sand, to an arctic blast, to a dazzling flash of light. Pirates, snipers, rogues, and necromancers often make use of this bane in combat.",
            "Duration: Resist ends (Fail x 3 = 1 minute)", "Attack attributes: agility, creation, energy, entropy.", "Attack: Agility vs. Guard, Creation vs. Guard,\nEnergy vs. Guard, Entropy vs. Toughness.",
                "Effect: The target cannot see as long as the effect persists. The target automatically fails any Perception rolls based solely on normal sight. Attack rolls and Perception rolls based partially on sight that can be supplemented by another sense suffer disadvantage 5. The target's Guard defense is reduced by 3.", "No special"));
        banesList.add(new Bane("Charmed", null, null, null, null, null, null, null));
        banesList.add(new Bane("Deafened", null, null, null, null, null, null, null));
        banesList.add(new Bane("Death", null, null, null, null, null, null, null));
        banesList.add(new Bane("Demoralized", null, null, null, null, null, null, null));
        banesList.add(new Bane("Disarmed", null, null, null, null, null, null, null));
        banesList.add(new Bane("Dominated", null, null, null, null, null, null, null));
        banesList.add(new Bane("Fatigued", null, null, null, null, null, null, null));
        banesList.add(new Bane("Fear", null, null, null, null, null, null, null));
        banesList.add(new Bane("Forced Move", null, null, null, null, null, null, null));
        banesList.add(new Bane("Immobile", null, null, null, null, null, null, null));
        banesList.add(new Bane("Incapacitated", null, null, null, null, null, null, null));
        banesList.add(new Bane("Knockdown", null, null, null, null, null, null, null));
        banesList.add(new Bane("Memory Alteration", null, null, null, null, null, null, null));
        banesList.add(new Bane("Mind Dredge", null, null, null, null, null, null, null));
        banesList.add(new Bane("Nullify", null, null, null, null, null, null, null));
        banesList.add(new Bane("Persistent Damage", null, null, null, null, null, null, null));
        banesList.add(new Bane("Phantasm", null, null, null, null, null, null, null));
        banesList.add(new Bane("Polymorph", null, null, null, null, null, null, null));
        banesList.add(new Bane("Provoked", null, null, null, null, null, null, null));
        banesList.add(new Bane("Spying", null, null, null, null, null, null, null));
        banesList.add(new Bane("Sickened", null, null, null, null, null, null, null));
        banesList.add(new Bane("Silenced", null, null, null, null, null, null, null));
        banesList.add(new Bane("Slowed", null, null, null, null, null, null, null));
        banesList.add(new Bane("Stunned", null, null, null, null, null, null, null));
        banesList.add(new Bane("Stupefied", null, null, null, null, null, null, null));
        banesList.add(new Bane("Truthfulness", null, null, null, null, null, null, null));
    }

}
