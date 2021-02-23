package com.journaldev.navigationdrawer.boons;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ca.unb.mobiledev.openlegendrpg.R;


public class BoonsFragment extends Fragment
{
    RecyclerView recyclerView;
    List<Boon> boonsList;

    public BoonsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_boons, container, false);

        boonsList = new ArrayList<>();
        recyclerView = rootView.findViewById(R.id.recyclerView);

        initData();
        initRecyclerView();;

        return rootView;
    }

    private void initRecyclerView()
    {
        BoonAdapter boonAdapter = new BoonAdapter(boonsList);
        recyclerView.setAdapter(boonAdapter);
    }

    private void initData()
    {
        boonsList = new ArrayList<>();
        boonsList.add(new Boon("Absorb Object", "Power Level: 4", "By restructuring your bodily composition, creating an extradimensional space, utilizing a cybernetic storage implant, or similar means, you absorb an object into your body, leaving it completely hidden from others and ready for access at a moment's notice.",
                "Invocation time: 1 Major Action", "Duration: permanent", "Attributes: alteration, movement", "Effect: the object remains in place, completely hidden from the perception of others, until the target summons or recalls it (automatically) as a minor action. If anything happens to cancel this boon (such as the nullify bane), the object is immediately shunted out of the target's body as if the object had been withdrawn."));
        boonsList.add(new Boon("Animation", null, null, null, null, null, null));
        boonsList.add(new Boon("Aura", null ,null, null, null, null, null));
        boonsList.add(new Boon("Barrier", null ,null, null, null, null, null));
        boonsList.add(new Boon("Blindsight", null ,null, null, null, null, null));
        boonsList.add(new Boon("Bolster", null ,null, null, null, null, null));
        boonsList.add(new Boon("Darkness", null ,null, null, null, null, null));
        boonsList.add(new Boon("Detection", null ,null, null, null, null, null));
        boonsList.add(new Boon("Flight", null ,null, null, null, null, null));
        boonsList.add(new Boon("Genesis", null ,null, null, null, null, null));
        boonsList.add(new Boon("Haste", null ,null, null, null, null, null));
        boonsList.add(new Boon("Heal", null ,null, null, null, null, null));
        boonsList.add(new Boon("Insubstantial", null ,null, null, null, null, null));
        boonsList.add(new Boon("Invisible", null ,null, null, null, null, null));
        boonsList.add(new Boon("Life Drain", null ,null, null, null, null, null));
        boonsList.add(new Boon("Light", null ,null, null, null, null, null));
        boonsList.add(new Boon("Precognition", null ,null, null, null, null, null));
        boonsList.add(new Boon("Reading", null ,null, null, null, null, null));
        boonsList.add(new Boon("Regeneration", null ,null, null, null, null, null));
        boonsList.add(new Boon("Resistance", null ,null, null, null, null, null));
        boonsList.add(new Boon("Restoration", null ,null, null, null, null, null));
        boonsList.add(new Boon("Seeing", null ,null, null, null, null, null));
        boonsList.add(new Boon("Shapeshift", null ,null, null, null, null, null));
        boonsList.add(new Boon("Summon Creature", null ,null, null, null, null, null));
        boonsList.add(new Boon("Sustenance", null ,null, null, null, null, null));
        boonsList.add(new Boon("Telekinesis", null ,null, null, null, null, null));
        boonsList.add(new Boon("Telepathy", null ,null, null, null, null, null));
        boonsList.add(new Boon("Teleport", null ,null, null, null, null, null));
        boonsList.add(new Boon("Tongues", null ,null, null, null, null, null));
        boonsList.add(new Boon("Transmutation", null ,null, null, null, null, null));
        boonsList.add(new Boon("Truesight", null ,null, null, null, null, null));

    }

}
