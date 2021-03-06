package com.example.bogusz.eartraining;


import android.app.Activity;
import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


public class KartaZadan extends Fragment {

    //GUI

    private Button kartaZadanButton;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        // ta metoda wystarczy by utworzyć fragment
        return inflater.inflate(R.layout.fragment_karta_zadan, container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        kartaZadanButton = getView().findViewById(R.id.kartaZadanButton);
    }

    public void zmienTytul(String trescTytul){

        TextView tytul = (TextView) getView().findViewById(R.id.tytulTrescZadania);
        tytul.setText(trescTytul);
    }

    public Button getKartaZadanButton() {
        return kartaZadanButton;
    }
}
