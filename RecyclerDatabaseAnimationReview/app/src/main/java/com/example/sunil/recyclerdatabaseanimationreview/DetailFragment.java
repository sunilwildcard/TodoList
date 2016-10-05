package com.example.sunil.recyclerdatabaseanimationreview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * Created by sunil on 10/4/16.
 */

public class DetailFragment extends Fragment {

    private View view;
    private EditText titletext, desctext;
    private Toolbar toolbar;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        String title = getArguments().getString("TITLE");
        String desc = getArguments().getString("DESC");
        int position = getArguments().getInt("POSITION");
        view = inflater.inflate(R.layout.detaillayout,container,false);

        toolbar = (Toolbar) view.findViewById(R.id.detail_toolbar);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        toolbar.setTitle(title);
        setHasOptionsMenu(true);

        titletext = (EditText) view.findViewById(R.id.detailfragment_title_edittext);
        desctext = (EditText) view.findViewById(R.id.detailfragment_desc_edittext);
        titletext.setText(title);
        desctext.setText(desc);

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.toolbar,menu);
    }
}
