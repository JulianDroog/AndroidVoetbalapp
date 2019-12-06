package be.thomasmore.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import be.thomasmore.myapplication.models.Competitie;

public class CompetitieAdapter extends ArrayAdapter<Competitie> {

    private final Context context;
    private final List<Competitie> values;

    public CompetitieAdapter(Context context, List<Competitie> values) {
        super(context, R.layout.competitielistviewitem, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.competitielistviewitem, parent, false);

        final TextView textViewName = (TextView) rowView.findViewById(R.id.name);
        final ImageView imageViewCountry = (ImageView) rowView.findViewById(R.id.imagecountry);
        textViewName.setText(values.get(position).getName());
        imageViewCountry.setImageResource(parent.getResources().getIdentifier(values.get(position).getImg_name(), "drawable", context.getPackageName()));

        return rowView;
    }

}
