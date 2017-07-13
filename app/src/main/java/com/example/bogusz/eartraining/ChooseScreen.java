package com.example.bogusz.eartraining;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.DisplayMetrics;

import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;


public class ChooseScreen extends AppCompatActivity {

    //logic values
    private int liczba_okien = 0;                           //zlicza liczbe stworzonych fragmentów
    private int klikniete;
    private String[] podpisIkony;
    private DisplayMetrics daneEkran;
    private String tagLog = "logAplikacji";


    //GUI of ChoosenScreen
    private IkonaFragment ikonaFragment;
    private LinearLayout kontenerZadania;
    private LinearLayout.LayoutParams parametKarty;
    private KartaZadan[] kartaZadan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.i(tagLog,"onCreate ChooseScreen");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_screen);

        //iniatial object
        ikonaFragment = (IkonaFragment) getFragmentManager().findFragmentById(R.id.fragmentIkona);
        podpisIkony = getResources().getStringArray(R.array.podpisyIkon);
        kontenerZadania = (LinearLayout) findViewById(R.id.kontenerZadania);

        //download value of clicked window
        klikniete = MainActivity.getKlikniete();

        // first setup of activity, creating quest cards

        setUpScrollView();
        // For overlap between Exiting  MainActivity.java and Entering TransitionActivity.java
        getWindow().setAllowEnterTransitionOverlap(false);
    }


    @Override
    protected void onStart() {
        Log.i(tagLog,"onStart ChooseScreen");
        super.onStart();
        setUpScreen();
        setFragmentSize();
        setWordsWindows();
        setOnKartaZadanButton();
    }




    @Override
    protected void onResume() {
        Log.i(tagLog,"onResume ChooseScreen");
        super.onResume();
    }


    @Override
    protected void onStop() {
        Log.i(tagLog,"onStop ChooseScreen");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.i(tagLog,"onDestroy ChooseScreen");
        super.onDestroy();
    }



    private void setUpScreen() {
        //wczytanie odpowiedniej grafiki i tekstu do fragmentu w górnej części ekranu

        ikonaFragment.zmianaNapisu(podpisIkony[klikniete]);

        switch (klikniete) {
            case 0:
                ikonaFragment.zmianaObrazu(R.drawable.interwaly);
                break;

            case 1:
                ikonaFragment.zmianaObrazu(R.drawable.trojdzwieki);
                break;

            case 2:
                ikonaFragment.zmianaObrazu(R.drawable.akordy);
                break;

            case 3:
                ikonaFragment.zmianaObrazu(R.drawable.rytmiczne);
                break;

            case 4:
                ikonaFragment.zmianaObrazu(R.drawable.melodyczne);
                break;

            case 5:
                ikonaFragment.zmianaObrazu(R.drawable.solfez);
                break;
        }

    }


    private void setUpScrollView() {
        //stworzenie odpowiedniej liczby kart zadań
        switch (klikniete) {
            case 0:
                stworzFragmentow(1);
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

    private void stworzFragmentow(int liczba_fragmentow) {

        Log.i(tagLog,"stworzFragmentow początek ChooseScreen");

        // stworzenie tymczasowej listy żeby móc stworzyć określoną liczbe fragmentów
        List<KartaZadan> listaKartZadan = new ArrayList<KartaZadan>();

        for (int i = 0; i < liczba_fragmentow; i++) {
            listaKartZadan.add(new KartaZadan());

        }

        // przepisanie listy
        kartaZadan = listaKartZadan.toArray(new KartaZadan[listaKartZadan.size()]).clone();


        Log.i(tagLog,"stworzFragmentow po przepisaniu tablicy ChooseScreen");

        for (int i = 0; i < kartaZadan.length; i++) {
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.add(kontenerZadania.getId(), kartaZadan[i]);
            ft.commit();
        }

        Log.i(tagLog,"stworzFragmentow po stworzeniu ChooseScreen");



    }

    private void setFragmentSize() {

        // ta funckcja dopasowuje fragmenty do ekranu danego telefonu

        daneEkran = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(daneEkran);


        // dopasowanie pozostały kart

        for (int i = 0; i < kartaZadan.length; i++) {

            int normalnyMargines = (int) (daneEkran.widthPixels * 0.03);
            int wiekszyMargines = (int) (daneEkran.widthPixels * 0.1);


            parametKarty = (LinearLayout.LayoutParams) kartaZadan[i].getView().getLayoutParams();


            //ustawienie szerokości karty
            parametKarty.width = (int) (daneEkran.widthPixels * 0.8);

            //ustawienie poszczególnych akapitów

            if (i == 0) {

                // ustawienie dla pierwszej karty zadań
                parametKarty.setMargins(wiekszyMargines, parametKarty.topMargin, normalnyMargines, parametKarty.bottomMargin);

            } else if (i == (kartaZadan.length - 1)) {

                //ustawienia dla ostatniej karty zadań
                parametKarty.setMargins(normalnyMargines, parametKarty.topMargin, wiekszyMargines, parametKarty.bottomMargin);

            } else {

                //ustawienia marginesów dla kart w środku
                parametKarty.setMargins(normalnyMargines, parametKarty.topMargin, normalnyMargines, parametKarty.bottomMargin);

            }


        }


    }

    private void setWordsWindows(){
        // funkcja wypelnia teksty kart

        if(klikniete == 0){
            kartaZadan[0].zmienTytul("Cwiczenia Interwały");
        }

    }

    private void setOnKartaZadanButton(){

        switch (klikniete){
            case 0:
                initCwiczInterwal();
                break;

            case 1:
                // for 1 activity action onClick
                break;

            case 2:
                // for 2 activity action onClick
                break;

            case 3:
                // for 3 activity action onClick
                break;

            case 4:
                // for 4 activity action onClick
                break;

            case 5:
                // for 5 activity action onClick
                break;


        }

    }

    private void initCwiczInterwal(){
            kartaZadan[0].getKartaZadanButton().setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(ChooseScreen.this, InterwalyCwiczenie.class);
                            startActivity(intent);
                        }
                    }
            );
    }



}
