package com.journaldev.navigationdrawer.characters;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import ca.unb.mobiledev.openlegendrpg.Adapters.characterListAdapter;
import ca.unb.mobiledev.openlegendrpg.Items.Character;
import ca.unb.mobiledev.openlegendrpg.R;
import ca.unb.mobiledev.openlegendrpg.UI.characterViewModel;
import ca.unb.mobiledev.openlegendrpg.characters.CharacterCreation;
import static android.app.Activity.RESULT_OK;

public class CharacterFragment extends Fragment implements characterListAdapter.EventListener
{
    public static final int NEW_CHARACTER_ACTIVITY_REQUEST_CODE = 1;

    private characterViewModel mCharacterViewModel;
    private Button addCharButton;

    public CharacterFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_character, container, false);
        RecyclerView recyclerView = rootView.findViewById(R.id.recyclerView);

        final characterListAdapter adapter = new characterListAdapter(new characterListAdapter.characterDiff(), this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));

        mCharacterViewModel = new ViewModelProvider(this).get(characterViewModel.class);
        mCharacterViewModel.listAllRecords().observe(requireActivity(), adapter::submitList);

        addCharButton = rootView.findViewById(R.id.addCharButton);
        addCharButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CharacterCreation.class);
                startActivityForResult(intent, NEW_CHARACTER_ACTIVITY_REQUEST_CODE);
                //this launches ca.unb.mobiledev.openlegendrpg.characters.CharacterCreation
            }
        });
        return rootView;
    }
    public void deleteCharacter(String charName){
        mCharacterViewModel = new ViewModelProvider(this).get(characterViewModel.class);
        mCharacterViewModel.deleteCharacter(charName);
    }
}
