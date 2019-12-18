package be.thomasmore.voetbalapp2.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.List;

import be.thomasmore.voetbalapp2.CompetitieAdapter;
import be.thomasmore.voetbalapp2.MainActivity;
import be.thomasmore.voetbalapp2.R;
import be.thomasmore.voetbalapp2.models.Competitie;
import be.thomasmore.voetbalapp2.ui.matches.MatchesFragment;

public class HomeFragment extends Fragment {

    List<Competitie> competities = new ArrayList<Competitie>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        // Remove default title text
        //getSupportActionBar().setDisplayShowTitleEnabled(false);
        // Get access to the custom title view
        //TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);


        //BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        //bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        vulPlatforms();

        View rootView = inflater.inflate(R.layout.fragment_home,
                container, false);
        ListView listViewCompetities;
        listViewCompetities = (ListView) rootView.findViewById(R.id.listViewPlatforms);
        CompetitieAdapter competitieAdapter = new CompetitieAdapter(rootView.getContext(), competities);
        listViewCompetities.setAdapter(competitieAdapter);
        listViewCompetities.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parentView, View childView, int position, long id) {
                Fragment matchesFragment = new MatchesFragment();
                Bundle bundle = new Bundle();
                Competitie competitie = competities.get(position);
                int compId = competitie.getId();
                bundle.putInt("compId", compId);
                matchesFragment.setArguments(bundle);
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.nav_host_fragment, matchesFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        return rootView;

    }

    @Override
    public void onResume() {
        super.onResume();
        ActionBar actionBar = ((MainActivity)getActivity()).getSupportActionBar();
    }


    private void vulPlatforms()
    {
        competities.add(new Competitie(68,"Jupiler Pro League", "be"));
        competities.add(new Competitie(196,"Eredivisie", "nl"));
        competities.add(new Competitie(5,"Ligue 1", "fr"));
        competities.add(new Competitie(2,"Premier League", "uk"));
        competities.add(new Competitie(4,"Serie A", "it"));
        competities.add(new Competitie(1,"Bundesliga", "de"));
        competities.add(new Competitie(3,"La liga", "es"));
        competities.add(new Competitie(8,"Primeira Liga", "pt"));
        competities.add(new Competitie(8,"Primeira Liga", "pt"));
        competities.add(new Competitie(8,"Primeira Liga", "pt"));
        competities.add(new Competitie(8,"Primeira Liga", "pt"));
    }
}