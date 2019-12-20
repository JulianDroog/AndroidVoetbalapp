package be.thomasmore.voetbalapp2.ui.match;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import be.thomasmore.voetbalapp2.JsonHelper;
import be.thomasmore.voetbalapp2.R;
import be.thomasmore.voetbalapp2.helpers.HttpReader;
import be.thomasmore.voetbalapp2.models.Stats;

public class FragmentStats extends Fragment {
    View view;
    private Stats stats = new Stats();

    public FragmentStats(){

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_stats,container,false);
        leesFixture();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                fillTable();
            }
        }, 300);

        return view;
    }

    private void fillTable() {
        final TextView textHomePossesion = (TextView) view.findViewById(R.id.text_homepossesion);
        final TextView textAwayPossesion = (TextView) view.findViewById(R.id.text_awaypossesion);
        final TextView textHomeAttempts = (TextView) view.findViewById(R.id.text_homeattempts);
        final TextView textAwayAttempts = (TextView) view.findViewById(R.id.text_awayattempts);
        final TextView textHomeOntarget = (TextView) view.findViewById(R.id.text_homeOntarget);
        final TextView textAwayOntarget = (TextView) view.findViewById(R.id.text_awayOntarget);
        final TextView textHomeYellowcard = (TextView) view.findViewById(R.id.text_homeyellowcard);
        final TextView textAwayYellowcard = (TextView) view.findViewById(R.id.text_awayyellowcard);
        final TextView textHomeRedcard = (TextView) view.findViewById(R.id.text_homeredcard);
        final TextView textAwayRedcard = (TextView) view.findViewById(R.id.text_awayredcard);

        textHomePossesion.setText(Integer.toString(stats.getHome_possesion()));
        textAwayPossesion.setText(Integer.toString(stats.getAway_possesion()));
        textHomeAttempts.setText(Integer.toString(stats.getHome_attempts()));
        textAwayAttempts.setText(Integer.toString(stats.getAway_attempts()));
        textHomeOntarget.setText(Integer.toString(stats.getHome_ontarget()));
        textAwayOntarget.setText(Integer.toString(stats.getHome_ontarget()));
        textAwayYellowcard.setText(Integer.toString(stats.getAway_yellowcard()));
        textHomeYellowcard.setText(Integer.toString(stats.getHome_yellowcard()));
        textHomeRedcard.setText(Integer.toString(stats.getHome_redcard()));
        textAwayRedcard.setText(Integer.toString(stats.getAway_redcard()));
    }

    private void leesFixture()
    {
        HttpReader httpReader = new HttpReader();
        httpReader.execute("http://10.0.2.2:5000/api/stats/5dfcf8ee8f996b55f03bb862");
        httpReader.setOnResultReadyListener(new HttpReader.OnResultReadyListener() {
            @Override
            public void resultReady(String result) {
                JsonHelper jsonHelper = new JsonHelper();
                stats = jsonHelper.getJsonStats(result);
                Log.d("stats:", Integer.toString(stats.getAway_attempts()));
            }
        });
    }
}
