package be.thomasmore.voetbalapp2.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;

import be.thomasmore.voetbalapp2.MainActivity;
import be.thomasmore.voetbalapp2.R;

public class NotificationsFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        ActionBar actionBar = ((MainActivity)getActivity()).getSupportActionBar();
    }
}