package be.thomasmore.voetbalapp2.ui.match;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import be.thomasmore.voetbalapp2.JsonHelper;
import be.thomasmore.voetbalapp2.MainActivity;
import be.thomasmore.voetbalapp2.R;
import be.thomasmore.voetbalapp2.ViewPagerAdapter;
import be.thomasmore.voetbalapp2.helpers.HttpReader;
import be.thomasmore.voetbalapp2.models.Fixture;

public class MatchFragment extends Fragment {

    private Fixture fixture = new Fixture();
    private TabLayout tabLayout;
    private ViewPager viewPager;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        final String fixid = getArguments().getString("fixId");
        leesFixture(fixid);
        Log.d("Fixture id:", fixid);
        //setSupportActionBar(toolbar);
        // Remove default title text
        //getSupportActionBar().setDisplayShowTitleEnabled(false);
        // Get access to the custom title view
        //TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);


        //BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        //bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        View rootView = inflater.inflate(R.layout.fragment_match,
                container, false);
        ((MainActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tabLayout = (TabLayout) rootView.findViewById(R.id.tablayout_id);
        viewPager = (ViewPager) rootView.findViewById(R.id.viewpager_id);

        final ViewPagerAdapter adapter = new ViewPagerAdapter(getFragmentManager());
        final TextView textviewThuis = (TextView) rootView.findViewById(R.id.home_team2);
        final TextView textviewUit = (TextView) rootView.findViewById(R.id.away_team2);

        adapter.AddFragment(new FragmentLineup(), "Lineup");
        adapter.AddFragment(new FragmentStats(), "Stats");
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                textviewThuis.setText(fixture.getHome_name());
                textviewUit.setText(fixture.getAway_name());
                viewPager.setAdapter(adapter);
                tabLayout.setupWithViewPager(viewPager);
            }
        }, 300);

        return rootView;

    }


    private void leesFixture(String id)
    {
        HttpReader httpReader = new HttpReader();
        httpReader.execute("http://10.0.2.2:5000/api/fixture/" + id);
        httpReader.setOnResultReadyListener(new HttpReader.OnResultReadyListener() {
            @Override
            public void resultReady(String result) {
                JsonHelper jsonHelper = new JsonHelper();
                fixture = jsonHelper.getJsonFixture(result);
            }
        });
    }
}
