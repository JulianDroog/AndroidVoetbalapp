package be.thomasmore.voetbalapp2.ui.matches;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
import be.thomasmore.voetbalapp2.helpers.DatabaseHelper;
import be.thomasmore.voetbalapp2.helpers.HttpReader;
import be.thomasmore.voetbalapp2.models.Fixture;
import be.thomasmore.voetbalapp2.ui.match.MatchFragment;

public class MatchesFragment extends Fragment {

    FixtureAdapter fixtureAdapter;
    List<Fixture> lijstmatches = new ArrayList<>();
    private DatabaseHelper db;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        db = new DatabaseHelper(getContext());
        String compid = Integer.toString(getArguments().getInt("compId"));
        final View rootView = inflater.inflate(R.layout.fragment_matches,
                container, false);
        if (lijstmatches != null){
            lijstmatches.clear();
        }
        leesMatches(compid);

        final ListView listViewMatches =
                (ListView) rootView.findViewById(R.id.listViewMatches);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                fixtureAdapter = new FixtureAdapter(rootView.getContext(), lijstmatches);
                listViewMatches.setAdapter(fixtureAdapter);
            }
        }, 500);
        Log.d("Count: ", Integer.toString(lijstmatches.size()));
        ((MainActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        listViewMatches.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parentView, View childView, int position, long id) {
                Fragment matchFragment = new MatchFragment();
                Bundle bundle = new Bundle();
                Fixture fixture = lijstmatches.get(position);
                db.insertPresident(fixture);
                String fixId = fixture.getId();
                bundle.putString("fixId", fixId);
                matchFragment.setArguments(bundle);
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.nav_host_fragment, matchFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        return rootView;

    }


    private void leesMatches(String id)
    {
        Log.d("id: ", id);
        HttpReader httpReader = new HttpReader();
        httpReader.execute("http://10.0.2.2:5000/api/fixtures/" + id);
        httpReader.setOnResultReadyListener(new HttpReader.OnResultReadyListener() {
            @Override
            public void resultReady(String result) {
                JsonHelper jsonHelper = new JsonHelper();
                lijstmatches.addAll(jsonHelper.getFixtures(result));
                for (Fixture item: lijstmatches
                     ) {
                    Log.d("test", item.getAway_name());
                }
            }
        });
    }

}
