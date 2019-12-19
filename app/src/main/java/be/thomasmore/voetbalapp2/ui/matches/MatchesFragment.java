package be.thomasmore.voetbalapp2.ui.matches;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.List;

import be.thomasmore.voetbalapp2.FixtureAdapter;
import be.thomasmore.voetbalapp2.JsonHelper;
import be.thomasmore.voetbalapp2.MainActivity;
import be.thomasmore.voetbalapp2.R;
import be.thomasmore.voetbalapp2.helpers.HttpReader;
import be.thomasmore.voetbalapp2.models.Fixture;
import be.thomasmore.voetbalapp2.ui.match.MatchFragment;

public class MatchesFragment extends Fragment {

    FixtureAdapter fixtureAdapter;
    private ArrayAdapter aAdapter;
    final List<Fixture> lijstmatches = new ArrayList<>();
    private String[] users = { "Suresh Dasari", "Rohini Alavala", "Trishika Dasari", "Praveen Alavala", "Madav Sai"};
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        String compid = Integer.toString(getArguments().getInt("compId"));
        View rootView = inflater.inflate(R.layout.fragment_matches,
                container, false);
        leesMatches();
        Log.d("Count: ", Integer.toString(lijstmatches.size()));
        ListView listViewMatches =
                (ListView) rootView.findViewById(R.id.listViewMatches);
//        fixtureAdapter = new FixtureAdapter(rootView.getContext(), lijstmatches);
        // Assign adapter to ListView
        aAdapter = new ArrayAdapter(rootView.getContext(), android.R.layout.simple_list_item_1, users);
        listViewMatches.setAdapter(aAdapter);
        ((MainActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        listViewMatches.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parentView, View childView, int position, long id) {
                Fragment matchFragment = new MatchFragment();
                Bundle bundle = new Bundle();
//                Competitie competitie = users.get(position);
//                int compId = competitie.getId();
//                bundle.putInt("compId", compId);
//                matchesFragment.setArguments(bundle);
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.nav_host_fragment, matchFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        return rootView;

    }


    private void leesMatches()
    {
        HttpReader httpReader = new HttpReader();
        httpReader.setOnResultReadyListener(new HttpReader.OnResultReadyListener() {
            @Override
            public void resultReady(String result) {
                JsonHelper jsonHelper = new JsonHelper();
                lijstmatches.addAll(jsonHelper.getFixtures(result));

            }
        });
        httpReader.execute("http://10.0.2.2:80/soccerapi/");
    }

}
