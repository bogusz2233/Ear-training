package com.example.bogusz.eartraining;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;



import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IkonaFragment[] ikonaFragments = {
                (IkonaFragment) getFragmentManager().findFragmentById(R.id.fragment_1),
                (IkonaFragment) getFragmentManager().findFragmentById(R.id.fragment_2),
                (IkonaFragment) getFragmentManager().findFragmentById(R.id.fragment_3),
                (IkonaFragment) getFragmentManager().findFragmentById(R.id.fragment_4),
                (IkonaFragment) getFragmentManager().findFragmentById(R.id.fragment_5),
                (IkonaFragment) getFragmentManager().findFragmentById(R.id.fragment_6)

        };

        setUpFragmentow(ikonaFragments);
        setOnClickFragmentow(ikonaFragments);
    }


    private void setOnClickFragmentow(IkonaFragment[] ikonaFragments){
        for(int i = 0; i<6; i++) {

                    View view = ikonaFragments[i].getView();
                    view.setOnClickListener(
                            new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    TextView textView = view.findViewById(R.id.tekstIkona);
                                    textView.setText("klikniete");
                                }
                            });

        }

    }


    private void setUpFragmentow(IkonaFragment[] ikonaFragments){
        for(int i = 0; i<6; i++){
            switch (i){
                case 0:
                    ikonaFragments[i].zmianaObrazu(R.drawable.interwaly);
                    ikonaFragments[i].zmianaNapisu(R.string.interwaly);
                    break;

                case 1:
                    ikonaFragments[i].zmianaObrazu(R.drawable.trojdzwieki);
                    ikonaFragments[i].zmianaNapisu(R.string.trojDzwieki);
                    break;

                case 2:
                    ikonaFragments[i].zmianaObrazu(R.drawable.akordy);
                    ikonaFragments[i].zmianaNapisu(R.string.akordy);
                    break;

                case 3:
                    ikonaFragments[i].zmianaObrazu(R.drawable.rytmiczne);
                    ikonaFragments[i].zmianaNapisu(R.string.dyktandaRytmiczne);
                    break;

                case 4:
                    ikonaFragments[i].zmianaObrazu(R.drawable.melodyczne);
                    ikonaFragments[i].zmianaNapisu(R.string.dyktandaMelodyjne);
                    break;

                case 5:
                    ikonaFragments[i].zmianaObrazu(R.drawable.solfez);
                    ikonaFragments[i].zmianaNapisu(R.string.solfez);
                    break;
            }
        }

    }


}
