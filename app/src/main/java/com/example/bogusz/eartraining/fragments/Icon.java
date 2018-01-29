package com.example.bogusz.eartraining.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bogusz.eartraining.R;

public class Icon extends Fragment {

    private TextView textIcon;
    private ImageView imageIcon;
    public Icon() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_icon, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        textIcon = getView().findViewById(R.id.textIcon);
        imageIcon = getView().findViewById(R.id.imageIcon);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public void changeText(String text){
        textIcon.setText(text);
    }
    public void changeText(int idText){
        textIcon.setText(idText);
    }
    public void changeImage(int idImage){
        imageIcon.setImageResource(idImage);
    }
}
