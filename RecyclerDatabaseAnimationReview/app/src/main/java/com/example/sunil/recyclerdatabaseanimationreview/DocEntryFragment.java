package com.example.sunil.recyclerdatabaseanimationreview;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DocEntryFragment extends DialogFragment {

    EditText mTitleEntry, mDescEntry;

    private static onDialogClicked dialogClickListener;

    // TodoFragment calls newInstance, allowing dialogClickListener to point to TodoFragment
    public static DocEntryFragment newInstance(onDialogClicked d){
        dialogClickListener = d;
        return new DocEntryFragment();
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // return super.onCreateDialog(savedInstanceState);
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        builder.setView(inflater.inflate(R.layout.add_fragment,null)) // avoid passing null... figure out why and come back to this
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO: what is the alternative to declaring the references here?
                        mTitleEntry = (EditText) getDialog().findViewById(R.id.edittext_title);
                        mDescEntry = (EditText) getDialog().findViewById(R.id.edittext_description);
                        dialogClickListener.onSaveClicked(mTitleEntry.getText().toString(),mDescEntry.getText().toString());
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        return builder.create();
    }

    public interface onDialogClicked{
        public void onSaveClicked(String title, String desc);
    }
}
