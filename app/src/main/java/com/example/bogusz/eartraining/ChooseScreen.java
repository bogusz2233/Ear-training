package com.example.bogusz.eartraining;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;


public class ChooseScreen extends AppCompatActivity {

    private int liczba_okien = 0;
    private String[] tagOkno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int klikniete = MainActivity.getKlikniete();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_screen);
        MainActivity.getKlikniete();

        // ustawienie
        setUpScreen(klikniete);
        setUpScrollView(klikniete);

    }


    @Override
    protected void onStart() {
        super.onStart();

        KartaZadan kartaZadan =(KartaZadan) getFragmentManager().findFragmentByTag(tagOkno[0]);
        kartaZadan.zmienTytul("");

    }

    private void setUpScreen(int klikniete){

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


    public void setUpScrollView(int klikniete){
        switch (klikniete){
            case 0:
                stworzFragmentow(3);
                break;

            case 1:
                stworzFragmentow(3);
                break;

            case 2:
                stworzFragmentow(3);
                break;

            case 3:
                stworzFragmentow(3);
                break;

            case 4:
                stworzFragmentow(3);
                break;

            case 5:
                stworzFragmentow(3);
                break;
        }

    }

    public void stworzFragmentow(int liczba_fragmentow){

        List<String> listaTagow = new ArrayList<String>();

        LinearLayout linearLayout =(LinearLayout) findViewById(R.id.kontenerZadania);

        for (int i = 0; i<liczba_fragmentow; i++ ){
            liczba_okien++;

            listaTagow.add("oknoZadan" + liczba_okien);
            KartaZadan kartaZadan = new KartaZadan();

            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.add(linearLayout.getId(),kartaZadan,listaTagow.get(i));

            ft.commit();
        }

        tagOkno = new String[listaTagow.size()];
        listaTagow.toArray(tagOkno);
    }


}
