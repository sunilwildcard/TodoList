package com.example.sunil.recyclerdatabaseanimationreview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class TodoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {

    private List<Todo> mList;

    private TodoFragment.onRecyclerViewClicked mListener;
    private Context mContext; // TODO: Sort out the role of context in this guy...
    private RecyclerView.ViewHolder mViewHolder;
    private Todo todoreference;

    public TodoAdapter(TodoFragment.onRecyclerViewClicked listener, List<Todo>list){
        mListener = listener;
        mList = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.todo_card,parent,false);
        mViewHolder = new TodoHolder(view);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        todoreference = mList.get(position);
        TodoHolder todoHolder = (TodoHolder) holder;
        todoHolder.titleText.setText(todoreference.getTitle());
        todoHolder.descriptionText.setText(todoreference.getDescription());

        todoHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Todo ref = mList.get(position);
                mListener.onRecyclerViewClicked(ref.getTitle(),ref.getDescription(),mList.indexOf(ref));
            }
        });

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

}
