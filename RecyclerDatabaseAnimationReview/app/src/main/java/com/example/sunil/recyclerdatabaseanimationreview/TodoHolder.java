package com.example.sunil.recyclerdatabaseanimationreview;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by sunil on 9/16/16.
 */
public class TodoHolder extends RecyclerView.ViewHolder {

    CardView cardView;
    TextView titleText;
    TextView descriptionText;

    public TodoHolder(View itemView) {
        super(itemView);
        cardView = (CardView) itemView.findViewById(R.id.card_view);
        titleText = (TextView) itemView.findViewById(R.id.card_title);
        descriptionText = (TextView) itemView.findViewById(R.id.card_description);
    }
}
