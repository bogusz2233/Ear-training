package com.example.bogusz.eartraining;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class KartaZadan extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        // ta metoda wystarczy by utworzyć fragment
        return inflater.inflate(R.layout.fragment_karta_zadan, container,false);
    }
}
