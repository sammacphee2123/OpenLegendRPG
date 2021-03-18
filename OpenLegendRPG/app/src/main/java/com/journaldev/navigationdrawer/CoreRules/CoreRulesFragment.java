package com.journaldev.navigationdrawer.CoreRules;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ca.unb.mobiledev.openlegendrpg.chapters.chapter1;
import ca.unb.mobiledev.openlegendrpg.chapters.chapter2;
import ca.unb.mobiledev.openlegendrpg.chapters.chapter3;
import ca.unb.mobiledev.openlegendrpg.chapters.chapter4;
import ca.unb.mobiledev.openlegendrpg.chapters.chapter5;
import ca.unb.mobiledev.openlegendrpg.chapters.chapter6;
import ca.unb.mobiledev.openlegendrpg.chapters.chapter7;
import ca.unb.mobiledev.openlegendrpg.chapters.chapter8;
import ca.unb.mobiledev.openlegendrpg.chapters.chapter9;
import ca.unb.mobiledev.openlegendrpg.chapters.introduction;

import ca.unb.mobiledev.openlegendrpg.R;

public class CoreRulesFragment extends Fragment {

    private Button IntroButton;
    private Button chapter1Button;
    private Button chapter2Button;
    private Button chapter3Button;
    private Button chapter4Button;

    private Button chapter5Button;
    private Button chapter6Button;
    private Button chapter7Button;
    private Button chapter8Button;
    private Button chapter9Button;

    public CoreRulesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_corerules, container, false);

        IntroButton = rootView.findViewById(R.id.contentsIntroButton);
        IntroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), introduction.class);
                startActivity(intent);
            }
        });

        chapter1Button = rootView.findViewById(R.id.contentsCH1Button);
        chapter1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), chapter1.class);
                startActivity(intent);
            }
        });
        chapter2Button = rootView.findViewById(R.id.contentsCH2Button);
        chapter2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), chapter2.class);
                startActivity(intent);
            }
        });
        chapter3Button = rootView.findViewById(R.id.contentsCH3Button);
        chapter3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), chapter3.class);
                startActivity(intent);
            }
        });
        chapter4Button = rootView.findViewById(R.id.contentsCH4Button);
        chapter4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), chapter4.class);
                startActivity(intent);
            }
        });
        chapter5Button = rootView.findViewById(R.id.contentsCH5Button);
        chapter5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), chapter5.class);
                startActivity(intent);
            }
        });
        chapter6Button = rootView.findViewById(R.id.contentsCH6Button);
        chapter6Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), chapter6.class);
                startActivity(intent);
            }
        });
        chapter7Button = rootView.findViewById(R.id.contentsCH7Button);
        chapter7Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), chapter7.class);
                startActivity(intent);
            }
        });
        chapter8Button = rootView.findViewById(R.id.contentsCH8Button);
        chapter8Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), chapter8.class);
                startActivity(intent);
            }
        });
        chapter9Button = rootView.findViewById(R.id.contentsCH9Button);
        chapter9Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), chapter9.class);
                startActivity(intent);
            }
        });
        return rootView;
    }

}
