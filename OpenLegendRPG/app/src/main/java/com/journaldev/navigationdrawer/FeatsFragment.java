package com.journaldev.navigationdrawer;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ca.unb.mobiledev.openlegendrpg.R;

public class FeatsFragment extends Fragment {

    public FeatsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_feats, container, false);

        return rootView;
    }

}
