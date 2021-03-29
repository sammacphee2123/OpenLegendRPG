package com.journaldev.navigationdrawer.feats;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ca.unb.mobiledev.openlegendrpg.Adapters.featListAdapter;
import ca.unb.mobiledev.openlegendrpg.R;
import ca.unb.mobiledev.openlegendrpg.UI.featViewModel;


public class FeatsFragment extends Fragment
{
    private featViewModel mFeatViewModel;

    public FeatsFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_boons, container, false);
        RecyclerView recyclerView = rootView.findViewById(R.id.recyclerView);

        final featListAdapter adapter = new featListAdapter(new featListAdapter.featDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));

        mFeatViewModel = new ViewModelProvider(requireActivity()).get(featViewModel.class);
        mFeatViewModel.listAllRecords().observe(requireActivity(), adapter::submitList);

        return rootView;
    }
}
