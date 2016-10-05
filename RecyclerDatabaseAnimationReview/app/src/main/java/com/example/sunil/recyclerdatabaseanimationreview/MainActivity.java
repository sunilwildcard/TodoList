package com.example.sunil.recyclerdatabaseanimationreview;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements TodoFragment.onRecyclerViewClicked {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // add RecyclerView Fragment to layout
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, new TodoFragment())
                .commit();
    }

    @Override
    public void onRecyclerViewClicked(String title, String desc, int position) {
        Bundle bundle = new Bundle();
        bundle.putString("TITLE",title);
        bundle.putString("DESC",desc);
        bundle.putInt("POSITION",position);
        Fragment detailfragment = new DetailFragment();
        detailfragment.setArguments(bundle);
        Toast.makeText(this,"Title: "+title+" position: "+position+" ",Toast.LENGTH_SHORT).show();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,detailfragment).addToBackStack(null).commit();
        // getarguments from fragment and send em to the detail fragment
        // animate transition to detail fragment, DONT FORGET THE OFFSET FROM THE EXPAND ANIMATION

    }
}
