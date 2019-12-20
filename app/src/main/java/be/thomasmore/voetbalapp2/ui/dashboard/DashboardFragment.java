package be.thomasmore.voetbalapp2.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.List;

import be.thomasmore.voetbalapp2.FavoriteAdapter;
import be.thomasmore.voetbalapp2.R;
import be.thomasmore.voetbalapp2.helpers.DatabaseHelper;
import be.thomasmore.voetbalapp2.models.Fixture;

public class DashboardFragment extends Fragment {

    private DatabaseHelper db;
    FavoriteAdapter favoriteAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        db = new DatabaseHelper(getContext());

        //setSupportActionBar(toolbar);
        // Remove default title text
        //getSupportActionBar().setDisplayShowTitleEnabled(false);
        // Get access to the custom title view
        //TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);


        //BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        //bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
        View rootView = inflater.inflate(R.layout.fragment_dashboard,
                container, false);
       readFixtures(rootView);

        return rootView;

    }

    public void readFixtures(final View rootView) {
        final List<Fixture> fixtures = db.getFixtures();

        favoriteAdapter = new FavoriteAdapter(rootView.getContext(), fixtures);

        final ListView listViewFavorites =
                (ListView) rootView.findViewById(R.id.listViewFavorite);
        listViewFavorites.setAdapter(favoriteAdapter);

        listViewFavorites.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parentView,
                                            View childView, int position, long id) {
                        db.deleteFixture(fixtures.get(position).getId());
                        readFixtures(rootView);
                    }
                });
    }
}