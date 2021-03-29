package com.journaldev.navigationdrawer.banes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ca.unb.mobiledev.openlegendrpg.Adapters.baneListAdapter;
import ca.unb.mobiledev.openlegendrpg.R;
import ca.unb.mobiledev.openlegendrpg.UI.baneViewModel;


public class BanesFragment extends Fragment
{
    private baneViewModel mBaneViewModel;

    public BanesFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_banes, container, false);
        RecyclerView recyclerView = rootView.findViewById(R.id.recyclerView);

        final baneListAdapter adapter = new baneListAdapter(new baneListAdapter.baneDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));

        mBaneViewModel = new ViewModelProvider(requireActivity()).get(baneViewModel.class);
        mBaneViewModel.listAllRecords().observe(requireActivity(), adapter::submitList);

        return rootView;
    }
}
