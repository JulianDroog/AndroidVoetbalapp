package be.thomasmore.voetbalapp2.ui.matches;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import be.thomasmore.voetbalapp2.MainActivity;
import be.thomasmore.voetbalapp2.R;

public class MatchesFragment extends Fragment {
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

        //setSupportActionBar(toolbar);
        // Remove default title text
        //getSupportActionBar().setDisplayShowTitleEnabled(false);
        // Get access to the custom title view
        //TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);


        //BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        //bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        View rootView = inflater.inflate(R.layout.fragment_matches,
                container, false);
        ((MainActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        return rootView;

    }
}
