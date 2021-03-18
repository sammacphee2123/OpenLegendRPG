package com.journaldev.navigationdrawer;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import ca.unb.mobiledev.openlegendrpg.R;

public class CreateAccountFragment extends Fragment {

    public CreateAccountFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.create_account, container, false);

        Button button1 = rootView.findViewById(R.id.btn_register);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ///////////////////////////////////////////create
            }
        });
        return rootView;
    }
}