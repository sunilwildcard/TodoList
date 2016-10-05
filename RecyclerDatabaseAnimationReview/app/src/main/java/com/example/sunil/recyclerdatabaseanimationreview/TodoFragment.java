package com.example.sunil.recyclerdatabaseanimationreview;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TodoFragment extends Fragment implements DocEntryFragment.onDialogClicked {

    // reference to interface implementation in MainActivity
    private onRecyclerViewClicked mListener;

    // instance variables for RecyclerView
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private TodoAdapter mViewAdapter;

    // instance variables for fragment (non RecyclerView Views & Widgets)
    private View view;
    private Button mAddButton;
    private Toolbar toolbar;

    // Model List to pass to Adapter
    private List<Todo> mTodoList;


    private AppCompatActivity activity;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if(context instanceof Activity)
            mListener = (onRecyclerViewClicked) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.listlayout,container,false);

        // toolbar
        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        toolbar.setTitle("Things to Do");
        setHasOptionsMenu(true); // TODO: FIGURE OUT WHY THIS NEEDS TO BE HERE

        // create singleton, pass it to the adapter
        TodoSingleton singleton = TodoSingleton.getInstance();
        mTodoList = singleton.getTodoList();

        // create the RecyclerView
        mRecyclerView = (RecyclerView) view.findViewById(R.id.listlayout_recyclerview);
        mLayoutManager = new LinearLayoutManager(view.getContext(),LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mViewAdapter = new TodoAdapter(mListener, mTodoList);
        mRecyclerView.setAdapter(mViewAdapter);

        // is there another way to do this? there probably is, I'll have to figure out what that is later...
        final DocEntryFragment fragment = DocEntryFragment.newInstance(this);

        // Button setup
        mAddButton = (Button) view.findViewById(R.id.listlayout_add_button);
        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment.show(getFragmentManager(),"dialogz");
                // call the fragment, a callback from the fragment will handle adding to the list
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // figure out what to put here ...
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.toolbar,menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case(R.id.favorite):
                Toast.makeText(getActivity(),"clicked favorites",Toast.LENGTH_SHORT).show();
                return true;
            case(R.id.settings):
                Toast.makeText(getActivity(),"clicked settings",Toast.LENGTH_SHORT).show();
                return true;
            default:
            return super.onOptionsItemSelected(item);
        }
    }

    // >>>CALLBACKS BELOW<<<
    @Override
    public void onSaveClicked(String title, String desc) {
        // callback implementation from our dialog

        mTodoList.add(new Todo(title,desc));
        mViewAdapter.notifyDataSetChanged();

        //TODO: add database writes
        //get helper instance, and write title, desc, color, to the table
        //check for duplicates
    }


    // Callback interface declaration
    // TODO: PASS AN INDEX
    public interface onRecyclerViewClicked{
        public void onRecyclerViewClicked(String title, String desc, int position);
    }
}
