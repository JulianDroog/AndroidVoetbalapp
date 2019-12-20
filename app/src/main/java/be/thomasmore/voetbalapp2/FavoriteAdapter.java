package be.thomasmore.voetbalapp2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import be.thomasmore.voetbalapp2.models.Fixture;

public class FavoriteAdapter extends ArrayAdapter<Fixture> {

    private final Context context;
    private final List<Fixture> values;

    public FavoriteAdapter(Context context, List<Fixture> values) {
        super(context, R.layout.favoritelistviewitem, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.favoritelistviewitem, parent, false);

        final TextView textViewHome = (TextView) rowView.findViewById(R.id.home_team);
        final TextView textViewAway = (TextView) rowView.findViewById(R.id.away_team);
        final TextView textViewTime = (TextView) rowView.findViewById(R.id.time);
        final TextView textViewHomeScore = (TextView) rowView.findViewById(R.id.home_score);
        final TextView textViewAwayScore = (TextView) rowView.findViewById(R.id.away_score);
        textViewHome.setText(values.get(position).getHome_name());
        textViewAway.setText(values.get(position).getAway_name());
        textViewTime.setText(values.get(position).getTime());
        textViewHomeScore.setText(Integer.toString(values.get(position).getHome_score()));
        textViewAwayScore.setText(Integer.toString(values.get(position).getAway_score()));

        return rowView;
    }

}
