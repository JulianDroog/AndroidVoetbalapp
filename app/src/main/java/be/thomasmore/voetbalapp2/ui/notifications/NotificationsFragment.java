package be.thomasmore.voetbalapp2.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import be.thomasmore.voetbalapp2.JsonHelper;
import be.thomasmore.voetbalapp2.MainActivity;
import be.thomasmore.voetbalapp2.R;
import be.thomasmore.voetbalapp2.helpers.HttpWriter;
import be.thomasmore.voetbalapp2.models.Fixture;
import be.thomasmore.voetbalapp2.ui.home.HomeFragment;

public class NotificationsFragment extends Fragment {


    Fixture fixture = new Fixture();


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_notifications, container, false);

        final Button button = (Button) root.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFixture(root);
                schrijfStudent();
                Toast.makeText(getContext(),"Fixture toegevoegd",Toast.LENGTH_SHORT).show();
                Fragment homeFragment = new HomeFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.nav_host_fragment, homeFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });


        return root;


    }

    private void setFixture(View view){
         Spinner spinner = (Spinner) view.findViewById(R.id.spinner1);
         EditText thuisploeg = (EditText) view.findViewById(R.id.editText3);
         EditText uitploeg = (EditText) view.findViewById(R.id.editText4);
         EditText datum = (EditText) view.findViewById(R.id.editText5);
         EditText tijd = (EditText) view.findViewById(R.id.editText6);
         EditText thuisScore = (EditText) view.findViewById(R.id.editText);
         EditText uitScore = (EditText) view.findViewById(R.id.editText2);
        fixture.setHome_name(thuisploeg.getText().toString());
        fixture.setAway_name(uitploeg.getText().toString());
        fixture.setDate(datum.getText().toString());
        fixture.setTime(tijd.getText().toString());
        fixture.setHome_score(Integer.parseInt(thuisScore.getText().toString()));
        fixture.setAway_score(Integer.parseInt(uitScore.getText().toString()));
        fixture.setStatus("afgelopen");
    }

    private void schrijfStudent()
    {
        JsonHelper jsonHelper = new JsonHelper();
        HttpWriter httpWriter = new HttpWriter();
        httpWriter.setJsonObject(jsonHelper.getJsonFixture(fixture));
        httpWriter.setOnResultReadyListener(new HttpWriter.OnResultReadyListener() {
            @Override
            public void resultReady(String result) {
                System.out.print(result);
            }
        });
        httpWriter.execute("http://10.0.2.2:5000/api/fixture");
    }



    @Override
    public void onResume() {
        super.onResume();
        ActionBar actionBar = ((MainActivity)getActivity()).getSupportActionBar();
    }
}