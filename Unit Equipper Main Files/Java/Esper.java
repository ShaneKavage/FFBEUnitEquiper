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
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class Esper extends AppCompatActivity {

    // Spin Number for calculate.java
    static int SesperSpin = 0;

    // declaring my scene and spinner to select espers
    private Scene esperScene;
    private Spinner spinnerEsp;
    private ArrayAdapter<CharSequence> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esper);

        // setting up the scene to reference an area
        esperScene = Scene.getSceneForLayout((ViewGroup) findViewById(R.id.StatLayout), R.layout.esper_scene, this);

        //loading up the spinner and its adapter with its files and drop down style
        spinnerEsp = findViewById(R.id.esperSelect);
        adapter = ArrayAdapter.createFromResource(this,R.array.Esper, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEsp.setAdapter(adapter);

        //setting up the on click function
        spinnerEsp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
                //spinner number to get the value from the Value.xml file
                int spinner_pos = spinnerEsp.getSelectedItemPosition();
                //sets the value for the calculate page depending on the esper chosen
                SesperSpin = spinner_pos;

                //ready to change the background depending on switch choice
                ImageView background = findViewById(R.id.ImgEsper);

                switch (spinner_pos) {
                    case 0: background.setBackgroundResource(R.drawable.e0);
                        break;
                    case 1:background.setBackgroundResource(R.drawable.e1);
                        break;
                    case 2:background.setBackgroundResource(R.drawable.e2);
                        break;
                    case 3:background.setBackgroundResource(R.drawable.e3);
                        break;
                    case 4:background.setBackgroundResource(R.drawable.e4);
                        break;
                    case 5:background.setBackgroundResource(R.drawable.e5);
                        break;
                    case 6:background.setBackgroundResource(R.drawable.e6);
                        break;
                    case 7:background.setBackgroundResource(R.drawable.e7);
                        break;
                    case 8:background.setBackgroundResource(R.drawable.e8);
                        break;
                    case 9:background.setBackgroundResource(R.drawable.e9);
                        break;
                    case 10:background.setBackgroundResource(R.drawable.e10);
                        break;
                    case 11:background.setBackgroundResource(R.drawable.e1);
                        break;
                    case 12:background.setBackgroundResource(R.drawable.e12);
                        break;

                }


                // String arrays of the value.xml
                String[] hp_values = getResources().getStringArray(R.array.Esper_hp);
                String[] mp_values = getResources().getStringArray(R.array.Esper_mp);
                String[] atk_values = getResources().getStringArray(R.array.Esper_atk);
                String[] def_values = getResources().getStringArray(R.array.Esper_def);
                String[] mag_values = getResources().getStringArray(R.array.Esper_mag);
                String[] spr_values = getResources().getStringArray(R.array.Esper_spr);

                //Ints for the value of the spinner based off of the value.xml
                int hp = Integer.valueOf(hp_values[spinner_pos]);
                int mp = Integer.valueOf(mp_values[spinner_pos]);
                int atk = Integer.valueOf(atk_values[spinner_pos]);
                int def = Integer.valueOf(def_values[spinner_pos]);
                int spr = Integer.valueOf(spr_values[spinner_pos]);
                int mag = Integer.valueOf(mag_values[spinner_pos]);

                //loading in the esper scene with the stats on it
                loadEsperScene(view);

                // changing the textvalue of the stats to the int's
                TextView EspHP = findViewById(R.id.TVhp);
                EspHP.setText(String.valueOf(hp));
                TextView EspMP = findViewById(R.id.TVmp);
                EspMP.setText(String.valueOf(mp));
                TextView EspAtk = findViewById(R.id.TVatk);
                EspAtk.setText(String.valueOf(atk));
                TextView EspDef = findViewById(R.id.TVdef);
                EspDef.setText(String.valueOf(def));
                TextView EspMag = findViewById(R.id.TVmag);
                EspMag.setText(String.valueOf(mag));
                TextView EspSpr = findViewById(R.id.TVspr);
                EspSpr.setText(String.valueOf(spr));


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }
        });
    }

    //creates or resumes ability Intent
    public void toAbility(View view) {
        Intent intent = new Intent(this, abilities.class);
        //checks to see if intent is already running
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivityIfNeeded(intent, 0);
    }

    //sTART A NEW INTENTE FOR ESPER
    public void toEsper(View view) {
        Intent intent = new Intent(this, Esper.class);
        //checks to see if intent is already running
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivityIfNeeded(intent, 0);
    }

    //creates or resumes equipment Intent
    public void toEquip(View view) {
        Intent intent = new Intent(this, equipment.class);
        //checks to see if intent is already running
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivityIfNeeded(intent, 0);
    }

    //creates or resumes character Intent
    public void toChar(View view) {
        Intent intent = new Intent(this, CharSelect.class);
        //checks to see if intent is already running
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivityIfNeeded(intent, 0);
    }

    //creates or resumes calculateIntent
    public void toCalculate(View view)
    {
        Intent intent = new Intent(this, Calculate.class);
        //checks to see if intent is already running
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivityIfNeeded(intent, 0);

    }

    //creates or resumes Epser Intent
    public void loadEsperScene(View view)
    {
        Transition slide = new Slide(Gravity.TOP);
        TransitionManager.go(esperScene, slide);

    }


}
