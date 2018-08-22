package com.example.shane.finalapps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.transition.Scene;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CharSelect extends AppCompatActivity {

    //creating my spinner and adapter for later
    private Spinner spinner;
    private ArrayAdapter<CharSequence> adapter;

    //loading in my scene
    private Scene loadCharScene;

    //static int for calculate page
    static int CcharSpin = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_char_select);

        //load in my scene directed at the statsScene section
        loadCharScene = Scene.getSceneForLayout((ViewGroup) findViewById(R.id.statScene), R.layout.scene1, this);

        //create and load my spinner with adapter content
        spinner = findViewById(R.id.charSpin);
        adapter = ArrayAdapter.createFromResource(this,R.array.Character_Names, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //sets spinner position to the static so Calculate can grab value
                int spinner_pos = spinner.getSelectedItemPosition();
                    CcharSpin = spinner_pos;

                    //Set of string arrays to grab values for characters
                    String[] char_rarity = getResources().getStringArray(R.array.rarity);
                    String[] char_numb = getResources().getStringArray(R.array.char_Number);

                    String[] hp_values = getResources().getStringArray(R.array.hp_values);
                    String[] mp_values = getResources().getStringArray(R.array.mp_values);
                    String[] atk_values = getResources().getStringArray(R.array.atk_values);
                    String[] def_values = getResources().getStringArray(R.array.def_values);
                    String[] mag_values = getResources().getStringArray(R.array.mag_values);
                    String[] spr_values = getResources().getStringArray(R.array.spr_values);

                    String[] Php_values = getResources().getStringArray(R.array.Php_values);
                    String[] Pmp_values = getResources().getStringArray(R.array.Pmp_values);
                    String[] Patk_values = getResources().getStringArray(R.array.Patk_values);
                    String[] Pdef_values = getResources().getStringArray(R.array.Pdef_values);
                    String[] Pmag_values = getResources().getStringArray(R.array.Pmag_values);
                    String[] Pspr_values = getResources().getStringArray(R.array.Pspr_values);

                    String[] DH_values = getResources().getStringArray(R.array.DH_values);

                    //characters stats based on spinner position loaded into ints
                    int rarityVal = Integer.valueOf(char_rarity[spinner_pos]);
                    int numb = Integer.valueOf(char_numb[spinner_pos]);

                    int hp = Integer.valueOf(hp_values[spinner_pos]);
                    int mp = Integer.valueOf(mp_values[spinner_pos]);
                    int atk = Integer.valueOf(atk_values[spinner_pos]);
                    int def = Integer.valueOf(def_values[spinner_pos]);
                    int spr = Integer.valueOf(spr_values[spinner_pos]);
                    int mag = Integer.valueOf(mag_values[spinner_pos]);

                    int Php = Integer.valueOf(Php_values[spinner_pos]);
                    int Pmp = Integer.valueOf(Pmp_values[spinner_pos]);
                    int Patk = Integer.valueOf(Patk_values[spinner_pos]);
                    int Pmag = Integer.valueOf(Pmag_values[spinner_pos]);
                    int Pdef = Integer.valueOf(Pdef_values[spinner_pos]);
                    int Pspr = Integer.valueOf(Pspr_values[spinner_pos]);

                    int DH = Integer.valueOf(DH_values[spinner_pos]);

                    //loads in the scene, adding the TV to the intent
                    loadCharScene(view);


                    //creating TV variables to edit the existing views with the characters stats
                    TextView charRare = findViewById(R.id.TVrarity);
                    charRare.setText(String.valueOf(rarityVal));
                    TextView charNumb = findViewById(R.id.TVnumber);
                    charNumb.setText(String.valueOf(numb));

                    TextView hpText = findViewById(R.id.TVhp);
                    hpText.setText(String.valueOf(hp));
                    TextView mpText = findViewById(R.id.TVmp);
                    mpText.setText(String.valueOf(mp));

                    TextView atkText = findViewById(R.id.TVatk);
                    atkText.setText(String.valueOf(atk));
                    TextView defText = findViewById(R.id.TVdef);
                    defText.setText(String.valueOf(def));
                    TextView magText = findViewById(R.id.TVmag);
                    magText.setText(String.valueOf(mag));
                    TextView sprText = findViewById(R.id.TVspr);
                    sprText.setText(String.valueOf(spr));

                    TextView PhpText = findViewById(R.id.TVphp);
                    PhpText.setText(String.valueOf(Php));
                    TextView PmpText = findViewById(R.id.TVpmp);
                    PmpText.setText(String.valueOf(Pmp));
                    TextView PatkText = findViewById(R.id.TVpatk);
                    PatkText.setText(String.valueOf(Patk));
                    TextView PdefText = findViewById(R.id.TVpdef);
                    PdefText.setText(String.valueOf(Pdef));
                    TextView PmagText = findViewById(R.id.TVpmag);
                    PmagText.setText(String.valueOf(Pmag));
                    TextView PsprText = findViewById(R.id.TVpspr);
                    PsprText.setText(String.valueOf(Pspr));

                    TextView DHText = findViewById(R.id.TVdh);
                    DHText.setText(String.valueOf(DH));
                }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {


            }
        });
    }

    // Scene transition
    public void loadCharScene(View view) {

        Transition slide = new Slide(Gravity.BOTTOM);
        TransitionManager.go(loadCharScene, slide);
    }

    //creates or resumes ability Intent
    public void toAbility(View view) {
        Intent intent = new Intent(this, abilities.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivityIfNeeded(intent, 0);
    }

    //creates or resumes Epser Intent
    public void toEsper(View view) {
        Intent intent = new Intent(this, Esper.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivityIfNeeded(intent, 0);
    }
    //creates or resumes equipment Intent
    public void toEquip(View view) {
        Intent intent = new Intent(this, equipment.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivityIfNeeded(intent, 0);
    }

    //creates or resumes character Intent
    public void toChar(View view) {
        Intent intent = new Intent(this, CharSelect.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivityIfNeeded(intent, 0);
    }

    //creates or resumes calculateIntent
    public void toCalculate(View view)
    {
        Intent intent = new Intent(this, Calculate.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivityIfNeeded(intent, 0);

    }

}
