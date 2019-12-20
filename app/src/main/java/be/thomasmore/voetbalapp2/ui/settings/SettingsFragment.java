package be.thomasmore.voetbalapp2.ui.settings;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;

import be.thomasmore.voetbalapp2.MainActivity;
import be.thomasmore.voetbalapp2.R;

public class SettingsFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        
        View root = inflater.inflate(R.layout.fragment_settings, container, false);
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        ActionBar actionBar = ((MainActivity)getActivity()).getSupportActionBar();
    }

    public void reportMail(View view){
        Intent sendintent = new Intent(Intent.ACTION_SEND);
        sendintent.setType("text/plain");
        sendintent.putExtra(Intent.EXTRA_EMAIL, "r0676862@student.thomasmore.be");
        sendintent.putExtra(Intent.EXTRA_SUBJECT, "Email subject");
        sendintent.putExtra(Intent.EXTRA_TEXT, "body of Email");
        startActivity(sendintent);
    }
}