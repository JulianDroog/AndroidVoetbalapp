package be.thomasmore.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Competitie> competities = new ArrayList<Competitie>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Remove default title text
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        // Get access to the custom title view
        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        vulPlatforms();

        useCustomAdapter();
    }

    private void useCustomAdapter()
    {
        CompetitieAdapter competitieAdapter =
                new CompetitieAdapter(getApplicationContext(), competities);

        final ListView listViewCompetities =
                (ListView) findViewById(R.id.listViewPlatforms);
        listViewCompetities.setAdapter(competitieAdapter);

        listViewCompetities.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parentView, View childView, int position, long id) {
//                toon(competities.get(position).getOs());
                startActivity(new Intent(MainActivity.this, MatchesActivity.class));
            }
        });
    }


    private void vulPlatforms()
    {
        competities.add(new Competitie("Jupiler Pro League", "be"));
        competities.add(new Competitie("Eredivisie", "nl"));
        competities.add(new Competitie("Ligue 1", "fr"));
        competities.add(new Competitie("Premier League", "uk"));
        competities.add(new Competitie("Serie A", "it"));
        competities.add(new Competitie("Bundesliga", "de"));
        competities.add(new Competitie("La liga", "es"));
        competities.add(new Competitie("Primeira Liga", "pt"));
    }


    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()){
                        case R.id.nav_home:
                            Toast.makeText(MainActivity.this, "home", Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.nav_favoritematches:
                            Intent intent1 = new Intent(MainActivity.this, FavoritematchesActivity.class);
                            startActivity(intent1);

                            break;
                        case R.id.nav_favoriteteams:
                            Intent intent2 = new Intent(MainActivity.this, FavoriteteamsActivity.class);
                            startActivity(intent2);
                            break;
                        case R.id.nav_settings:
                            Intent intent3 = new Intent(MainActivity.this, SettingsActivity.class);
                            startActivity(intent3);
                            break;
                    }

                    return true;
                }
            };
}
