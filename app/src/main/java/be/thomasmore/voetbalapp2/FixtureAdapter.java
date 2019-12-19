package be.thomasmore.voetbalapp2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import be.thomasmore.voetbalapp2.models.Fixture;

public class FixtureAdapter extends ArrayAdapter<Fixture> {

    private final Context context;
    private final List<Fixture> values;

    public FixtureAdapter(Context context, List<Fixture> values) {
        super(context, R.layout.platformlistviewitem, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.platformlistviewitem, parent, false);

        final TextView textViewHome = (TextView) rowView.findViewById(R.id.home_team);
        final TextView textViewAway = (TextView) rowView.findViewById(R.id.away_team);
        textViewHome.setText(values.get(position).getHome_name());
        textViewAway.setText(values.get(position).getAway_name());

        return rowView;
    }

}
