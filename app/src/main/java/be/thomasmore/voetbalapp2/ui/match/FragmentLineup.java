package be.thomasmore.voetbalapp2.ui.match;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import be.thomasmore.voetbalapp2.R;

public class FragmentLineup extends Fragment {
    View view;
    public FragmentLineup(){

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_lineup,container,false);
        return view;
    }

}
