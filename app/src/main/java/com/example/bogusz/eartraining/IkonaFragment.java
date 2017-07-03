package com.example.bogusz.eartraining;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class IkonaFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        // ta metoda wystarczy by utworzyć fragment
        return inflater.inflate(R.layout.fragment_ikona, container,false);
    }

    public void zmianaObrazu(int obrazId){
        ImageView imageView = getView().findViewById(R.id.imageView);
        imageView.setImageResource(obrazId);
    }

    public void zmianaNapisu(String napisPodObrazem){
        TextView textView = getView().findViewById(R.id.tekstIkona);
        textView.setText(napisPodObrazem);
    }

    public void zmianaNapisu(int napisId){
        TextView textView = getView().findViewById(R.id.tekstIkona);
        textView.setText(napisId);
    }


}
