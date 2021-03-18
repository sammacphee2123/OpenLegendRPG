package com.journaldev.navigationdrawer.boons;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ca.unb.mobiledev.openlegendrpg.Adapters.boonListAdapter;
import ca.unb.mobiledev.openlegendrpg.R;
import ca.unb.mobiledev.openlegendrpg.UI.boonViewModel;


public class BoonsFragment extends Fragment
{
    private boonViewModel mBoonViewModel;

    public BoonsFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_boons, container, false);
        RecyclerView recyclerView = rootView.findViewById(R.id.recyclerView);

        final boonListAdapter adapter = new boonListAdapter(new boonListAdapter.boonDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));

        mBoonViewModel = new ViewModelProvider(requireActivity()).get(boonViewModel.class);
        mBoonViewModel.listAllRecords().observe(requireActivity(), adapter::submitList);

        return rootView;
    }
}
