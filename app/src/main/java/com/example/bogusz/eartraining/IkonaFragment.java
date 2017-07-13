package com.example.bogusz.eartraining;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class IkonaFragment extends Fragment {

    private String tagLog = "logAplikacji";

    private ImageView imageIkona;
    private TextView tekstIkona;

    @Override
    public void onAttach(Context context) {
        Log.i(tagLog,"onAttach fragment");
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.i(tagLog,"onCreate fragment");
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Log.i(tagLog,"onCreateView fragment");

        // ta metoda wystarczy by utworzyć fragment
        return inflater.inflate(R.layout.fragment_ikona, container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.i(tagLog,"onActivityCreated fragment");
        super.onActivityCreated(savedInstanceState);

        imageIkona = getView().findViewById(R.id.imageIkona);
        tekstIkona = getView().findViewById(R.id.tekstIkona);

    }

    public void zmianaObrazu(int obrazId){

        imageIkona.setImageResource(obrazId);
    }

    public void zmianaNapisu(String napisPodObrazem){

        tekstIkona.setText(napisPodObrazem);
    }

    public void zmianaNapisu(int napisId){
        tekstIkona.setText(napisId);
    }




}
