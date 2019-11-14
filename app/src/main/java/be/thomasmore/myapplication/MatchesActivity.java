package be.thomasmore.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MatchesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matches);

        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    switch (item.getItemId()){
                        case R.id.nav_home:
                            Intent intent0 = new Intent(MatchesActivity.this, MainActivity.class);
                            startActivity(intent0);
                            break;
                        case R.id.nav_favoritematches:
                            Intent intent1 = new Intent(MatchesActivity.this, FavoritematchesActivity.class);
                            startActivity(intent1);
                            break;
                        case R.id.nav_favoriteteams:
                            Intent intent2 = new Intent(MatchesActivity.this, FavoriteteamsActivity.class);
                            startActivity(intent2);
                            break;
                        case R.id.nav_settings:
                            Intent intent3 = new Intent(MatchesActivity.this, SettingsActivity.class);
                            startActivity(intent3);
                            break;
                    }

                    return true;
                }
            };

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_out_left, R.anim.slide_in_right);
    }
}
