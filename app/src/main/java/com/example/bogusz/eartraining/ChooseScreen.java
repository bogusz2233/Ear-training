package com.example.bogusz.eartraining;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class ChooseScreen extends AppCompatActivity {
    private int klikniete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_screen);
        klikniete = MainActivity.getKlikniete();

        // ustawienie
        setUpScreen();
    }

    private void setUpScreen(){

        IkonaFragment ikonaFragment = (IkonaFragment) getFragmentManager().findFragmentById(R.id.fragmentIkona);

        switch (klikniete){
            case 0:
                ikonaFragment.zmianaObrazu(R.drawable.interwaly);
                ikonaFragment.zmianaNapisu(R.string.interwaly);
                break;

            case 1:
                ikonaFragment.zmianaObrazu(R.drawable.trojdzwieki);
                ikonaFragment.zmianaNapisu(R.string.trojDzwieki);
                break;

            case 2:
                ikonaFragment.zmianaObrazu(R.drawable.akordy);
                ikonaFragment.zmianaNapisu(R.string.akordy);
                break;

            case 3:
                ikonaFragment.zmianaObrazu(R.drawable.rytmiczne);
                ikonaFragment.zmianaNapisu(R.string.dyktandaRytmiczne);
                break;

            case 4:
                ikonaFragment.zmianaObrazu(R.drawable.melodyczne);
                ikonaFragment.zmianaNapisu(R.string.dyktandaMelodyczne);
                break;

            case 5:
                ikonaFragment.zmianaObrazu(R.drawable.solfez);
                ikonaFragment.zmianaNapisu(R.string.solfez);
                break;
        }

    }



    @Override
    public void finish() {
        super.finish();
    }
}
