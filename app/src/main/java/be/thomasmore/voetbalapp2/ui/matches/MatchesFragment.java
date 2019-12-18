package be.thomasmore.voetbalapp2.ui.matches;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import be.thomasmore.voetbalapp2.MainActivity;
import be.thomasmore.voetbalapp2.R;
import be.thomasmore.voetbalapp2.helpers.HttpReader;
import be.thomasmore.voetbalapp2.models.Fixture;

public class MatchesFragment extends Fragment {

    List<Fixture> fixtures = new ArrayList<Fixture>();
    private String key = "w96akkqAu7YdVZDp";
    private String secret = "b6Rw4fIz6TBOmwqTFw30RuAlByzwxcVJ";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new
                    StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        View rootView = inflater.inflate(R.layout.fragment_matches,
                container, false);
        ((MainActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String compid = Integer.toString(getArguments().getInt("compId"));
        leesMatches(compid);

        ArrayAdapter<Fixture> adapter = new ArrayAdapter<Fixture>(rootView.getContext(),
                android.R.layout.simple_list_item_1, fixtures);

        final ListView listViewPlatforms =
                (ListView) rootView.findViewById(R.id.listViewPlatforms);
        // Assign adapter to ListView
        listViewPlatforms.setAdapter(adapter);

        return rootView;

    }

    private void leesMatches(String id)
    {
        HttpReader httpReader = new HttpReader();
        httpReader.setOnResultReadyListener(new HttpReader.OnResultReadyListener() {
            @Override
            public void resultReady(String result) {
                System.out.print(result);
//                JsonHelper jsonHelper = new JsonHelper();
//                fixtures = jsonHelper.getFixtures(result);
            }
        });
        httpReader.execute("http://livescore-api.com/api-client/fixtures/matches.json?key=" + key +"&secret=" + secret +"&competition_id=" + id);
    }

}
