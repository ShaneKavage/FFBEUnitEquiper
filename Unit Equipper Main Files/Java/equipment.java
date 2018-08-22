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
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.*;


public class equipment extends AppCompatActivity {

    //Static ints that store and transfer values to calculate
    static int Eweap1Spin = 0;
    static int Eweap2Spin = 0;
    static int Eacc1Spin = 0;
    static int Eacc2Spin = 0;
    static int EhelmSpin = 0;
    static int EchestSpin = 0;

    // loads up the spinners
    private Spinner spinAcc1;
    private Spinner spinAcc2;
    private Spinner spinWeap1;
    private Spinner spinWeap2;
    private Spinner spinChest;
    private Spinner spinHelm;

    //Loads up 4 spererate adapters
    private ArrayAdapter<CharSequence> adapterAcc;
    private ArrayAdapter<CharSequence> adapterChest;
    private ArrayAdapter<CharSequence> adapterHelm;
    private ArrayAdapter<CharSequence> adapterWeap;

    // loads up
    private Scene loadWeap1;
    private Scene loadWeap2;
    private Scene loadHelm;
    private Scene loadChest;
    private Scene loadAcc1;
    private Scene loadAcc2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipment);

        //Sets up the 6 scenes to their respective layouts
        loadWeap1 = Scene.getSceneForLayout((ViewGroup) findViewById(R.id.Weap1), R.layout.weapon_scene, this);
        loadWeap2 = Scene.getSceneForLayout((ViewGroup) findViewById(R.id.Weap2), R.layout.weapon_scene2, this);
        loadHelm = Scene.getSceneForLayout((ViewGroup) findViewById(R.id.Helm), R.layout.helm_scene, this);
        loadChest = Scene.getSceneForLayout((ViewGroup) findViewById(R.id.Chest), R.layout.chest_scene, this);
        loadAcc1 = Scene.getSceneForLayout((ViewGroup) findViewById(R.id.Acc1), R.layout.acc1_scene, this);
        loadAcc2 = Scene.getSceneForLayout((ViewGroup) findViewById(R.id.Acc2), R.layout.acc2_scene, this);

        //loads up 2 spinners with the accessories adapter
        spinAcc1 = findViewById(R.id.Acc1Spin);
        adapterAcc = ArrayAdapter.createFromResource(this, R.array.Acc_names, android.R.layout.simple_spinner_item);
        adapterAcc.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinAcc1.setAdapter(adapterAcc);

        spinAcc2 = findViewById(R.id.Acc2Spin);
        adapterAcc = ArrayAdapter.createFromResource(this, R.array.Acc_names, android.R.layout.simple_spinner_item);
        adapterAcc.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinAcc2.setAdapter(adapterAcc);

        //loads up 2 spinners with the weapon adapter
        spinWeap1 = findViewById(R.id.Weap1Spin);
        adapterWeap = ArrayAdapter.createFromResource(this, R.array.Wep_names, android.R.layout.simple_spinner_item);
        adapterWeap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinWeap1.setAdapter(adapterWeap);

        spinWeap2 = findViewById(R.id.Weap2Spin);
        adapterWeap = ArrayAdapter.createFromResource(this, R.array.Wep_names, android.R.layout.simple_spinner_item);
        adapterWeap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinWeap2.setAdapter(adapterWeap);

        //loads up a spinner with the chest adapter
        spinChest = findViewById(R.id.ChestSpin);
        adapterChest = ArrayAdapter.createFromResource(this, R.array.Chest_names, android.R.layout.simple_spinner_item);
        adapterChest.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinChest.setAdapter(adapterChest);

        //loads up a spinner with the helm adapter
        spinHelm = findViewById(R.id.HelmSpin);
        adapterHelm = ArrayAdapter.createFromResource(this, R.array.Helm_names, android.R.layout.simple_spinner_item);
        adapterHelm.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinHelm.setAdapter(adapterHelm);

        spinWeap1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
                //Sets a static int = to the position of the first weapon spinner
                int spinner_pos1 = spinWeap1.getSelectedItemPosition();
                Eweap1Spin = spinner_pos1;

                //Creates string arrays that store the values of the weapons
                String[] hp_values = getResources().getStringArray(R.array.Wephp_values);
                String[] mp_values = getResources().getStringArray(R.array.Wepmp_values);
                String[] atk_values = getResources().getStringArray(R.array.Wepatk_values);
                String[] def_values = getResources().getStringArray(R.array.Wepdef_values);
                String[] mag_values = getResources().getStringArray(R.array.Wepmag_values);
                String[] spr_values = getResources().getStringArray(R.array.Wepspr_values);

                String[] Php_values = getResources().getStringArray(R.array.WepPhp_values);
                String[] Pmp_values = getResources().getStringArray(R.array.WepPmp_values);
                String[] Patk_values = getResources().getStringArray(R.array.WepPatk_values);
                String[] Pdef_values = getResources().getStringArray(R.array.WepPdef_values);
                String[] Pmag_values = getResources().getStringArray(R.array.WepPmag_values);
                String[] Pspr_values = getResources().getStringArray(R.array.WepPspr_values);

                //creates ints to store the value of the resource files for weapons at a specific spinner position
                int hp = Integer.valueOf(hp_values[spinner_pos1]);
                int mp = Integer.valueOf(mp_values[spinner_pos1]);
                int atk = Integer.valueOf(atk_values[spinner_pos1]);
                int def = Integer.valueOf(def_values[spinner_pos1]);
                int spr = Integer.valueOf(spr_values[spinner_pos1]);
                int mag = Integer.valueOf(mag_values[spinner_pos1]);

                int Php = Integer.valueOf(Php_values[spinner_pos1]);
                int Pmp = Integer.valueOf(Pmp_values[spinner_pos1]);
                int Patk = Integer.valueOf(Patk_values[spinner_pos1]);
                int Pmag = Integer.valueOf(Pmag_values[spinner_pos1]);
                int Pdef = Integer.valueOf(Pdef_values[spinner_pos1]);
                int Pspr = Integer.valueOf(Pspr_values[spinner_pos1]);


                //if spinner pos is anything but 0 (none)
                if (spinner_pos1 > 0)
                {

                    //loads the scene into the layout
                    loadWeap1Scene(view);

                    //changes all of thes TV's to the stats of the weapon
                    TextView Weap1hpText = findViewById(R.id.Weap1TVhp);
                    Weap1hpText.setText(String.valueOf(hp));
                    TextView Weap1mpText = findViewById(R.id.Weap1TVmp);
                    Weap1mpText.setText(String.valueOf(mp));

                    TextView Weap1atkText = findViewById(R.id.Weap1TVatk);
                    Weap1atkText.setText(String.valueOf(atk));
                    TextView Weap1defText = findViewById(R.id.Weap1TVdef);
                    Weap1defText.setText(String.valueOf(def));
                    TextView Weap1magText = findViewById(R.id.Weap1TVmag);
                    Weap1magText.setText(String.valueOf(mag));
                    TextView  Weap1sprText = findViewById(R.id.Weap1TVspr);
                    Weap1sprText.setText(String.valueOf(spr));

                    TextView Weap1PhpText = findViewById(R.id.Weap1TVPhp);
                    Weap1PhpText.setText(String.valueOf(Php));
                    TextView Weap1PmpText = findViewById(R.id.Weap1TVPmp);
                    Weap1PmpText.setText(String.valueOf(Pmp));
                    TextView Weap1PatkText = findViewById(R.id.Weap1TVPatk);
                    Weap1PatkText.setText(String.valueOf(Patk));
                    TextView Weap1PdefText = findViewById(R.id.Weap1TVPdef);
                    Weap1PdefText.setText(String.valueOf(Pdef));
                    TextView Weap1PmagText = findViewById(R.id.Weap1TVPmag);
                    Weap1PmagText.setText(String.valueOf(Pmag));
                    TextView Weap1PsprText = findViewById(R.id.Weap1TVPspr);
                    Weap1PsprText.setText(String.valueOf(Pspr));

                    //if any of the stats are 0, it makes the TV Gone
                    if (hp == 0)
                    {
                        Weap1hpText.setVisibility(View.GONE);
                    }
                    else
                    {
                        Weap1hpText.setText("HP: " + String.valueOf(hp));
                    }

                    if (mp == 0)
                    {
                        Weap1mpText.setVisibility(View.GONE);
                    }
                    else
                    {
                        Weap1mpText.setText("MP: " + String.valueOf(mp));
                    }

                    if (atk == 0)
                    {
                        Weap1atkText.setVisibility(View.GONE);
                    }
                    else
                    {
                        Weap1atkText.setText("Atk: " + String.valueOf(atk));
                    }

                    if (def == 0)
                    {
                        Weap1defText.setVisibility(View.GONE);
                    }
                    else
                    {
                        Weap1defText.setText("Def: " + String.valueOf(def));
                    }

                    if (mag == 0)
                    {
                        Weap1magText.setVisibility(View.GONE);
                    }
                    else
                    {
                        Weap1magText.setText("Mag: " + String.valueOf(mag));
                    }

                    if (spr == 0)
                    {
                        Weap1sprText.setVisibility(View.GONE);
                    }
                    else
                    {
                        Weap1sprText.setText("Spr: " + String.valueOf(spr));
                    }


                    if (Php == 0)
                    {
                        Weap1PhpText.setVisibility(View.GONE);
                    }
                    else
                    {
                        Weap1PhpText.setText("HP: " + String.valueOf(Php) + "% ");
                    }

                    if (Pmp == 0)
                    {
                        Weap1PmpText.setVisibility(View.GONE);
                    }
                    else
                    {
                        Weap1PmpText.setText("MP: " + String.valueOf(Pmp) + "% ");
                    }

                    if (Patk == 0)
                    {
                        Weap1PatkText.setVisibility(View.GONE);
                    }
                    else
                    {
                        Weap1PatkText.setText("Atk: " + String.valueOf(Patk) + "% ");
                    }

                    if (Pdef == 0)
                    {
                        Weap1PdefText.setVisibility(View.GONE);
                    }
                    else
                    {
                        Weap1PdefText.setText("Def: " + String.valueOf(Pdef) + "% ");
                    }

                    if (Pmag == 0)
                    {
                        Weap1PmagText.setVisibility(View.GONE);
                    }
                    else
                    {
                        Weap1PmagText.setText("Mag: " + String.valueOf(Pmag) + "% ");
                    }

                    if (Pspr == 0)
                    {
                        Weap1PsprText.setVisibility(View.GONE);
                    }
                    else
                    {
                        Weap1PsprText.setText("Spr: " + String.valueOf(Pspr) + "% ");
                    }
                }
                else
                {

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //spinner2-6 are the same as spinner1
        spinWeap2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int spinner_pos2 = spinWeap2.getSelectedItemPosition();
                Eweap2Spin = spinner_pos2;

                String[] hp_values = getResources().getStringArray(R.array.Wephp_values);
                String[] mp_values = getResources().getStringArray(R.array.Wepmp_values);
                String[] atk_values = getResources().getStringArray(R.array.Wepatk_values);
                String[] def_values = getResources().getStringArray(R.array.Wepdef_values);
                String[] mag_values = getResources().getStringArray(R.array.Wepmag_values);
                String[] spr_values = getResources().getStringArray(R.array.Wepspr_values);

                String[] Php_values = getResources().getStringArray(R.array.WepPhp_values);
                String[] Pmp_values = getResources().getStringArray(R.array.WepPmp_values);
                String[] Patk_values = getResources().getStringArray(R.array.WepPatk_values);
                String[] Pdef_values = getResources().getStringArray(R.array.WepPdef_values);
                String[] Pmag_values = getResources().getStringArray(R.array.WepPmag_values);
                String[] Pspr_values = getResources().getStringArray(R.array.WepPspr_values);

                int hp = Integer.valueOf(hp_values[spinner_pos2]);
                int mp = Integer.valueOf(mp_values[spinner_pos2]);
                int atk = Integer.valueOf(atk_values[spinner_pos2]);
                int def = Integer.valueOf(def_values[spinner_pos2]);
                int spr = Integer.valueOf(spr_values[spinner_pos2]);
                int mag = Integer.valueOf(mag_values[spinner_pos2]);

                int Php = Integer.valueOf(Php_values[spinner_pos2]);
                int Pmp = Integer.valueOf(Pmp_values[spinner_pos2]);
                int Patk = Integer.valueOf(Patk_values[spinner_pos2]);
                int Pmag = Integer.valueOf(Pmag_values[spinner_pos2]);
                int Pdef = Integer.valueOf(Pdef_values[spinner_pos2]);
                int Pspr = Integer.valueOf(Pspr_values[spinner_pos2]);

                if(spinner_pos2 > 0)
                {

                    loadWeap2Scene(view);

                    TextView Weap2hpText = findViewById(R.id.Weap2TVhp);
                    Weap2hpText.setText(String.valueOf(hp));
                    TextView Weap2mpText = findViewById(R.id.Weap2TVmp);
                    Weap2mpText.setText(String.valueOf(mp));

                    TextView Weap2atkText = findViewById(R.id.Weap2TVatk);
                    Weap2atkText.setText(String.valueOf(atk));
                    TextView Weap2defText = findViewById(R.id.Weap2TVdef);
                    Weap2defText.setText(String.valueOf(def));
                    TextView Weap2magText = findViewById(R.id.Weap2TVmag);
                    Weap2magText.setText(String.valueOf(mag));
                    TextView  Weap2sprText = findViewById(R.id.Weap2TVspr);
                    Weap2sprText.setText(String.valueOf(spr));

                    TextView Weap2PhpText = findViewById(R.id.Weap2TVPhp);
                    Weap2PhpText.setText(String.valueOf(Php));
                    TextView Weap2PmpText = findViewById(R.id.Weap2TVPmp);
                    Weap2PmpText.setText(String.valueOf(Pmp));
                    TextView Weap2PatkText = findViewById(R.id.Weap2TVPatk);
                    Weap2PatkText.setText(String.valueOf(Patk));
                    TextView Weap2PdefText = findViewById(R.id.Weap2TVPdef);
                    Weap2PdefText.setText(String.valueOf(Pdef));
                    TextView Weap2PmagText = findViewById(R.id.Weap2TVPmag);
                    Weap2PmagText.setText(String.valueOf(Pmag));
                    TextView Weap2PsprText = findViewById(R.id.Weap2TVPspr);
                    Weap2PsprText.setText(String.valueOf(Pspr));

                    if (hp == 0)
                    {
                        Weap2hpText.setVisibility(View.GONE);
                    }
                    else
                    {
                        Weap2hpText.setText("HP: " + String.valueOf(hp));
                    }

                    if (mp == 0)
                    {
                        Weap2mpText.setVisibility(View.GONE);
                    }
                    else
                    {
                        Weap2mpText.setText("MP: " + String.valueOf(mp));
                    }

                    if (atk == 0)
                    {
                        Weap2atkText.setVisibility(View.GONE);
                    }
                    else
                    {
                        Weap2atkText.setText("Atk: " + String.valueOf(atk));
                    }

                    if (def == 0)
                    {
                        Weap2defText.setVisibility(View.GONE);
                    }
                    else
                    {
                        Weap2defText.setText("Def: " + String.valueOf(def));
                    }

                    if (mag == 0)
                    {
                        Weap2magText.setVisibility(View.GONE);
                    }
                    else
                    {
                        Weap2magText.setText("Mag: " + String.valueOf(mag));
                    }

                    if (spr == 0)
                    {
                        Weap2sprText.setVisibility(View.GONE);
                    }
                    else
                    {
                        Weap2sprText.setText("Spr: " + String.valueOf(spr));
                    }


                    if (Php == 0)
                    {
                        Weap2PhpText.setVisibility(View.GONE);
                    }
                    else
                    {
                        Weap2PhpText.setText("HP: " + String.valueOf(Php) + "% ");
                    }

                    if (Pmp == 0)
                    {
                        Weap2PmpText.setVisibility(View.GONE);
                    }
                    else
                    {
                        Weap2PmpText.setText("MP: " + String.valueOf(Pmp) + "% ");
                    }

                    if (Patk == 0)
                    {
                        Weap2PatkText.setVisibility(View.GONE);
                    }
                    else
                    {
                        Weap2PatkText.setText("Atk: " + String.valueOf(Patk) + "% ");
                    }

                    if (Pdef == 0)
                    {
                        Weap2PdefText.setVisibility(View.GONE);
                    }
                    else
                    {
                        Weap2PdefText.setText("Def: " + String.valueOf(Pdef) + "% ");
                    }

                    if (Pmag == 0)
                    {
                        Weap2PmagText.setVisibility(View.GONE);
                    }
                    else
                    {
                        Weap2PmagText.setText("Mag: " + String.valueOf(Pmag) + "% ");
                    }

                    if (Pspr == 0)
                    {
                        Weap2PsprText.setVisibility(View.GONE);
                    }
                    else
                    {
                        Weap2PsprText.setText("Spr: " + String.valueOf(Pspr) + "% ");
                    }

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinHelm.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int spinner_pos3 = spinHelm.getSelectedItemPosition();
                EhelmSpin = spinner_pos3;

                String[] hp_values = getResources().getStringArray(R.array.Helmhp_values);
                String[] mp_values = getResources().getStringArray(R.array.Helmmp_values);
                String[] atk_values = getResources().getStringArray(R.array.Helmatk_values);
                String[] def_values = getResources().getStringArray(R.array.Helmdef_values);
                String[] mag_values = getResources().getStringArray(R.array.Helmmag_values);
                String[] spr_values = getResources().getStringArray(R.array.Helmspr_values);

                String[] Php_values = getResources().getStringArray(R.array.HelmPhp_values);
                String[] Pmp_values = getResources().getStringArray(R.array.HelmPmp_values);
                String[] Patk_values = getResources().getStringArray(R.array.HelmPatk_values);
                String[] Pdef_values = getResources().getStringArray(R.array.HelmPdef_values);
                String[] Pmag_values = getResources().getStringArray(R.array.HelmPmag_values);
                String[] Pspr_values = getResources().getStringArray(R.array.HelmPspr_values);

                int hp = Integer.valueOf(hp_values[spinner_pos3]);
                int mp = Integer.valueOf(mp_values[spinner_pos3]);
                int atk = Integer.valueOf(atk_values[spinner_pos3]);
                int def = Integer.valueOf(def_values[spinner_pos3]);
                int spr = Integer.valueOf(spr_values[spinner_pos3]);
                int mag = Integer.valueOf(mag_values[spinner_pos3]);

                int Php = Integer.valueOf(Php_values[spinner_pos3]);
                int Pmp = Integer.valueOf(Pmp_values[spinner_pos3]);
                int Patk = Integer.valueOf(Patk_values[spinner_pos3]);
                int Pmag = Integer.valueOf(Pmag_values[spinner_pos3]);
                int Pdef = Integer.valueOf(Pdef_values[spinner_pos3]);
                int Pspr = Integer.valueOf(Pspr_values[spinner_pos3]);

                if(spinner_pos3 > 0)
                {
                    loadHelmScene(view);

                    TextView HelmhpText = findViewById(R.id.HelmTVhp);
                    HelmhpText.setText(String.valueOf(hp));
                    TextView HelmmpText = findViewById(R.id.HelmTVmp);
                    HelmmpText.setText(String.valueOf(mp));

                    TextView HelmatkText = findViewById(R.id.HelmTVatk);
                    HelmatkText.setText(String.valueOf(atk));
                    TextView HelmdefText = findViewById(R.id.HelmTVdef);
                    HelmdefText.setText(String.valueOf(def));
                    TextView HelmmagText = findViewById(R.id.HelmTVmag);
                    HelmmagText.setText(String.valueOf(mag));
                    TextView  HelmsprText = findViewById(R.id.HelmTVspr);
                    HelmsprText.setText(String.valueOf(spr));

                    TextView HelmPhpText = findViewById(R.id.HelmTVPhp);
                    HelmPhpText.setText(String.valueOf(Php));
                    TextView HelmPmpText = findViewById(R.id.HelmTVPmp);
                    HelmPmpText.setText(String.valueOf(Pmp));
                    TextView HelmPatkText = findViewById(R.id.HelmTVPatk);
                    HelmPatkText.setText(String.valueOf(Patk));
                    TextView HelmPdefText = findViewById(R.id.HelmTVPdef);
                    HelmPdefText.setText(String.valueOf(Pdef));
                    TextView HelmPmagText = findViewById(R.id.HelmTVPmag);
                    HelmPmagText.setText(String.valueOf(Pmag));
                    TextView HelmPsprText = findViewById(R.id.HelmTVPspr);
                    HelmPsprText.setText(String.valueOf(Pspr));

                    if (hp == 0)
                    {
                        HelmhpText.setVisibility(View.GONE);
                    }
                    else
                    {
                        HelmhpText.setText("HP: " + String.valueOf(hp));
                    }

                    if (mp == 0)
                    {
                        HelmmpText.setVisibility(View.GONE);
                    }
                    else
                    {
                        HelmmpText.setText("MP: " + String.valueOf(mp));
                    }

                    if (atk == 0)
                    {
                        HelmatkText.setVisibility(View.GONE);
                    }
                    else
                    {
                        HelmatkText.setText("Atk: " + String.valueOf(atk));
                    }

                    if (def == 0)
                    {
                        HelmdefText.setVisibility(View.GONE);
                    }
                    else
                    {
                        HelmdefText.setText("Def: " + String.valueOf(def));
                    }

                    if (mag == 0)
                    {
                        HelmmagText.setVisibility(View.GONE);
                    }
                    else
                    {
                        HelmmagText.setText("Mag: " + String.valueOf(mag));
                    }

                    if (spr == 0)
                    {
                        HelmsprText.setVisibility(View.GONE);
                    }
                    else
                    {
                        HelmsprText.setText("Spr: " + String.valueOf(spr));
                    }


                    if (Php == 0)
                    {
                        HelmPhpText.setVisibility(View.GONE);
                    }
                    else
                    {
                        HelmPhpText.setText("HP: " + String.valueOf(Php) + "% ");
                    }

                    if (Pmp == 0)
                    {
                        HelmPmpText.setVisibility(View.GONE);
                    }
                    else
                    {
                        HelmPmpText.setText("MP: " + String.valueOf(Pmp) + "% ");
                    }

                    if (Patk == 0)
                    {
                        HelmPatkText.setVisibility(View.GONE);
                    }
                    else
                    {
                        HelmPatkText.setText("Atk: " + String.valueOf(Patk) + "% ");
                    }

                    if (Pdef == 0)
                    {
                        HelmPdefText.setVisibility(View.GONE);
                    }
                    else
                    {
                        HelmPdefText.setText("Def: " + String.valueOf(Pdef) + "% ");
                    }

                    if (Pmag == 0)
                    {
                        HelmPmagText.setVisibility(View.GONE);
                    }
                    else
                    {
                        HelmPmagText.setText("Mag: " + String.valueOf(Pmag) + "% ");
                    }

                    if (Pspr == 0)
                    {
                        HelmPsprText.setVisibility(View.GONE);
                    }
                    else
                    {
                        HelmPsprText.setText("Spr: " + String.valueOf(Pspr) + "% ");
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinChest.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int spinner_pos4 = spinChest.getSelectedItemPosition();
                EchestSpin = spinner_pos4;

                String[] hp_values = getResources().getStringArray(R.array.Chesthp_values);
                String[] mp_values = getResources().getStringArray(R.array.Chestmp_values);
                String[] atk_values = getResources().getStringArray(R.array.Chestatk_values);
                String[] def_values = getResources().getStringArray(R.array.Chestdef_values);
                String[] mag_values = getResources().getStringArray(R.array.Chestmag_values);
                String[] spr_values = getResources().getStringArray(R.array.Chestspr_values);

                String[] Php_values = getResources().getStringArray(R.array.ChestPhp_values);
                String[] Pmp_values = getResources().getStringArray(R.array.ChestPmp_values);
                String[] Patk_values = getResources().getStringArray(R.array.ChestPatk_values);
                String[] Pdef_values = getResources().getStringArray(R.array.ChestPdef_values);
                String[] Pmag_values = getResources().getStringArray(R.array.ChestPmag_values);
                String[] Pspr_values = getResources().getStringArray(R.array.ChestPspr_values);

                int hp = Integer.valueOf(hp_values[spinner_pos4]);
                int mp = Integer.valueOf(mp_values[spinner_pos4]);
                int atk = Integer.valueOf(atk_values[spinner_pos4]);
                int def = Integer.valueOf(def_values[spinner_pos4]);
                int spr = Integer.valueOf(spr_values[spinner_pos4]);
                int mag = Integer.valueOf(mag_values[spinner_pos4]);

                int Php = Integer.valueOf(Php_values[spinner_pos4]);
                int Pmp = Integer.valueOf(Pmp_values[spinner_pos4]);
                int Patk = Integer.valueOf(Patk_values[spinner_pos4]);
                int Pmag = Integer.valueOf(Pmag_values[spinner_pos4]);
                int Pdef = Integer.valueOf(Pdef_values[spinner_pos4]);
                int Pspr = Integer.valueOf(Pspr_values[spinner_pos4]);

                if(spinner_pos4 > 0)
                {
                    loadChestScene(view);

                    TextView ChesthpText = findViewById(R.id.ChestTVhp);
                    ChesthpText.setText(String.valueOf(hp));
                    TextView ChestmpText = findViewById(R.id.ChestTVmp);
                    ChestmpText.setText(String.valueOf(mp));

                    TextView ChestatkText = findViewById(R.id.ChestTVatk);
                    ChestatkText.setText(String.valueOf(atk));
                    TextView ChestdefText = findViewById(R.id.ChestTVdef);
                    ChestdefText.setText(String.valueOf(def));
                    TextView ChestmagText = findViewById(R.id.ChestTVmag);
                    ChestmagText.setText(String.valueOf(mag));
                    TextView ChestsprText = findViewById(R.id.ChestTVspr);
                    ChestsprText.setText(String.valueOf(spr));

                    TextView ChestPhpText = findViewById(R.id.ChestTVPhp);
                    ChestPhpText.setText(String.valueOf(Php));
                    TextView ChestPmpText = findViewById(R.id.ChestTVPmp);
                    ChestPmpText.setText(String.valueOf(Pmp));
                    TextView ChestPatkText = findViewById(R.id.ChestTVPatk);
                    ChestPatkText.setText(String.valueOf(Patk));
                    TextView ChestPdefText = findViewById(R.id.ChestTVPdef);
                    ChestPdefText.setText(String.valueOf(Pdef));
                    TextView ChestPmagText = findViewById(R.id.ChestTVPmag);
                    ChestPmagText.setText(String.valueOf(Pmag));
                    TextView ChestPsprText = findViewById(R.id.ChestTVPspr);
                    ChestPsprText.setText(String.valueOf(Pspr));

                    if (hp == 0)
                    {
                        ChesthpText.setVisibility(View.GONE);
                    }
                    else
                    {
                        ChesthpText.setText("HP: " + String.valueOf(hp));
                    }

                    if (mp == 0)
                    {
                        ChestmpText.setVisibility(View.GONE);
                    }
                    else
                    {
                        ChestmpText.setText("MP: " + String.valueOf(mp));
                    }

                    if (atk == 0)
                    {
                        ChestatkText.setVisibility(View.GONE);
                    }
                    else
                    {
                        ChestatkText.setText("Atk: " + String.valueOf(atk));
                    }

                    if (def == 0)
                    {
                        ChestdefText.setVisibility(View.GONE);
                    }
                    else
                    {
                        ChestdefText.setText("Def: " + String.valueOf(def));
                    }

                    if (mag == 0)
                    {
                        ChestmagText.setVisibility(View.GONE);
                    }
                    else
                    {
                        ChestmagText.setText("Mag: " + String.valueOf(mag));
                    }

                    if (spr == 0)
                    {
                        ChestsprText.setVisibility(View.GONE);
                    }
                    else
                    {
                        ChestsprText.setText("Spr: " + String.valueOf(spr));
                    }


                    if (Php == 0)
                    {
                        ChestPhpText.setVisibility(View.GONE);
                    }
                    else
                    {
                        ChestPhpText.setText("HP: " + String.valueOf(Php) + "% ");
                    }

                    if (Pmp == 0)
                    {
                        ChestPmpText.setVisibility(View.GONE);
                    }
                    else
                    {
                        ChestPmpText.setText("MP: " + String.valueOf(Pmp) + "% ");
                    }

                    if (Patk == 0)
                    {
                        ChestPatkText.setVisibility(View.GONE);
                    }
                    else
                    {
                        ChestPatkText.setText("Atk: " + String.valueOf(Patk) + "% ");
                    }

                    if (Pdef == 0)
                    {
                        ChestPdefText.setVisibility(View.GONE);
                    }
                    else
                    {
                        ChestPdefText.setText("Def: " + String.valueOf(Pdef) + "% ");
                    }

                    if (Pmag == 0)
                    {
                        ChestPmagText.setVisibility(View.GONE);
                    }
                    else
                    {
                        ChestPmagText.setText("Mag: " + String.valueOf(Pmag) + "% ");
                    }

                    if (Pspr == 0)
                    {
                        ChestPsprText.setVisibility(View.GONE);
                    }
                    else
                    {
                        ChestPsprText.setText("Spr: " + String.valueOf(Pspr) + "% ");
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinAcc1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int spinner_pos5 = spinAcc1.getSelectedItemPosition();
                Eacc1Spin = spinner_pos5;

                String[] hp_values = getResources().getStringArray(R.array.Acchp_values);
                String[] mp_values = getResources().getStringArray(R.array.Accmp_values);
                String[] atk_values = getResources().getStringArray(R.array.Accatk_values);
                String[] def_values = getResources().getStringArray(R.array.Accdef_values);
                String[] mag_values = getResources().getStringArray(R.array.Accmag_values);
                String[] spr_values = getResources().getStringArray(R.array.Accspr_values);

                String[] Php_values = getResources().getStringArray(R.array.AccPhp_values);
                String[] Pmp_values = getResources().getStringArray(R.array.AccPmp_values);
                String[] Patk_values = getResources().getStringArray(R.array.AccPatk_values);
                String[] Pdef_values = getResources().getStringArray(R.array.AccPdef_values);
                String[] Pmag_values = getResources().getStringArray(R.array.AccPmag_values);
                String[] Pspr_values = getResources().getStringArray(R.array.AccPspr_values);

                int hp = Integer.valueOf(hp_values[spinner_pos5]);
                int mp = Integer.valueOf(mp_values[spinner_pos5]);
                int atk = Integer.valueOf(atk_values[spinner_pos5]);
                int def = Integer.valueOf(def_values[spinner_pos5]);
                int spr = Integer.valueOf(spr_values[spinner_pos5]);
                int mag = Integer.valueOf(mag_values[spinner_pos5]);

                int Php = Integer.valueOf(Php_values[spinner_pos5]);
                int Pmp = Integer.valueOf(Pmp_values[spinner_pos5]);
                int Patk = Integer.valueOf(Patk_values[spinner_pos5]);
                int Pmag = Integer.valueOf(Pmag_values[spinner_pos5]);
                int Pdef = Integer.valueOf(Pdef_values[spinner_pos5]);
                int Pspr = Integer.valueOf(Pspr_values[spinner_pos5]);

                if(spinner_pos5 > 0)
                {
                    loadAcc1Scene(view);

                    TextView Acc1hpText = findViewById(R.id.Acc1TVhp);
                    Acc1hpText.setText(String.valueOf(hp));
                    TextView Acc1mpText = findViewById(R.id.Acc1TVmp);
                    Acc1mpText.setText(String.valueOf(mp));

                    TextView Acc1atkText = findViewById(R.id.Acc1TVatk);
                    Acc1atkText.setText(String.valueOf(atk));
                    TextView Acc1defText = findViewById(R.id.Acc1TVdef);
                    Acc1defText.setText(String.valueOf(def));
                    TextView Acc1magText = findViewById(R.id.Acc1TVmag);
                    Acc1magText.setText(String.valueOf(mag));
                    TextView  Acc1sprText = findViewById(R.id.Acc1TVspr);
                    Acc1sprText.setText(String.valueOf(spr));

                    TextView Acc1PhpText = findViewById(R.id.Acc1TVPhp);
                    Acc1PhpText.setText(String.valueOf(Php));
                    TextView Acc1PmpText = findViewById(R.id.Acc1TVPmp);
                    Acc1PmpText.setText(String.valueOf(Pmp));
                    TextView Acc1PatkText = findViewById(R.id.Acc1TVPatk);
                    Acc1PatkText.setText(String.valueOf(Patk));
                    TextView Acc1PdefText = findViewById(R.id.Acc1TVPdef);
                    Acc1PdefText.setText(String.valueOf(Pdef));
                    TextView Acc1PmagText = findViewById(R.id.Acc1TVPmag);
                    Acc1PmagText.setText(String.valueOf(Pmag));
                    TextView Acc1PsprText = findViewById(R.id.Acc1TVPspr);
                    Acc1PsprText.setText(String.valueOf(Pspr));

                    if (hp == 0)
                    {
                        Acc1hpText.setVisibility(View.GONE);
                    }
                    else
                    {
                        Acc1hpText.setText("HP: " + String.valueOf(hp));
                    }

                    if (mp == 0)
                    {
                        Acc1mpText.setVisibility(View.GONE);
                    }
                    else
                    {
                        Acc1mpText.setText("MP: " + String.valueOf(mp));
                    }

                    if (atk == 0)
                    {
                        Acc1atkText.setVisibility(View.GONE);
                    }
                    else
                    {
                        Acc1atkText.setText("Atk: " + String.valueOf(atk));
                    }

                    if (def == 0)
                    {
                        Acc1defText.setVisibility(View.GONE);
                    }
                    else
                    {
                        Acc1defText.setText("Def: " + String.valueOf(def));
                    }

                    if (mag == 0)
                    {
                        Acc1magText.setVisibility(View.GONE);
                    }
                    else
                    {
                        Acc1magText.setText("Mag: " + String.valueOf(mag));
                    }

                    if (spr == 0)
                    {
                        Acc1sprText.setVisibility(View.GONE);
                    }
                    else
                    {
                        Acc1sprText.setText("Spr: " + String.valueOf(spr));
                    }


                    if (Php == 0)
                    {
                        Acc1PhpText.setVisibility(View.GONE);
                    }
                    else
                    {
                        Acc1PhpText.setText("HP: " + String.valueOf(Php) + "% ");
                    }

                    if (Pmp == 0)
                    {
                        Acc1PmpText.setVisibility(View.GONE);
                    }
                    else
                    {
                        Acc1PmpText.setText("MP: " + String.valueOf(Pmp) + "% ");
                    }

                    if (Patk == 0)
                    {
                        Acc1PatkText.setVisibility(View.GONE);
                    }
                    else
                    {
                        Acc1PatkText.setText("Atk: " + String.valueOf(Patk) + "% ");
                    }

                    if (Pdef == 0)
                    {
                        Acc1PdefText.setVisibility(View.GONE);
                    }
                    else
                    {
                        Acc1PdefText.setText("Def: " + String.valueOf(Pdef) + "% ");
                    }

                    if (Pmag == 0)
                    {
                        Acc1PmagText.setVisibility(View.GONE);
                    }
                    else
                    {
                        Acc1PmagText.setText("Mag: " + String.valueOf(Pmag) + "% ");
                    }

                    if (Pspr == 0)
                    {
                        Acc1PsprText.setVisibility(View.GONE);
                    }
                    else
                    {
                        Acc1PsprText.setText("Spr: " + String.valueOf(Pspr) + "% ");
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinAcc2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int spinner_pos6 = spinAcc2.getSelectedItemPosition();
                Eacc2Spin = spinner_pos6;

                String[] hp_values = getResources().getStringArray(R.array.Acchp_values);
                String[] mp_values = getResources().getStringArray(R.array.Accmp_values);
                String[] atk_values = getResources().getStringArray(R.array.Accatk_values);
                String[] def_values = getResources().getStringArray(R.array.Accdef_values);
                String[] mag_values = getResources().getStringArray(R.array.Accmag_values);
                String[] spr_values = getResources().getStringArray(R.array.Accspr_values);

                String[] Php_values = getResources().getStringArray(R.array.AccPhp_values);
                String[] Pmp_values = getResources().getStringArray(R.array.AccPmp_values);
                String[] Patk_values = getResources().getStringArray(R.array.AccPatk_values);
                String[] Pdef_values = getResources().getStringArray(R.array.AccPdef_values);
                String[] Pmag_values = getResources().getStringArray(R.array.AccPmag_values);
                String[] Pspr_values = getResources().getStringArray(R.array.AccPspr_values);

                int hp = Integer.valueOf(hp_values[spinner_pos6]);
                int mp = Integer.valueOf(mp_values[spinner_pos6]);
                int atk = Integer.valueOf(atk_values[spinner_pos6]);
                int def = Integer.valueOf(def_values[spinner_pos6]);
                int spr = Integer.valueOf(spr_values[spinner_pos6]);
                int mag = Integer.valueOf(mag_values[spinner_pos6]);

                int Php = Integer.valueOf(Php_values[spinner_pos6]);
                int Pmp = Integer.valueOf(Pmp_values[spinner_pos6]);
                int Patk = Integer.valueOf(Patk_values[spinner_pos6]);
                int Pmag = Integer.valueOf(Pmag_values[spinner_pos6]);
                int Pdef = Integer.valueOf(Pdef_values[spinner_pos6]);
                int Pspr = Integer.valueOf(Pspr_values[spinner_pos6]);

                if(spinner_pos6 > 0)
                {
                    loadAcc2Scene(view);

                    TextView Acc2hpText = findViewById(R.id.Acc2TVhp);
                    Acc2hpText.setText(String.valueOf(hp));
                    TextView Acc2mpText = findViewById(R.id.Acc2TVmp);
                    Acc2mpText.setText(String.valueOf(mp));

                    TextView Acc2atkText = findViewById(R.id.Acc2TVatk);
                    Acc2atkText.setText(String.valueOf(atk));
                    TextView Acc2defText = findViewById(R.id.Acc2TVdef);
                    Acc2defText.setText(String.valueOf(def));
                    TextView Acc2magText = findViewById(R.id.Acc2TVmag);
                    Acc2magText.setText(String.valueOf(mag));
                    TextView Acc2sprText = findViewById(R.id.Acc2TVspr);
                    Acc2sprText.setText(String.valueOf(spr));

                    TextView Acc2PhpText = findViewById(R.id.Acc2TVPhp);
                    Acc2PhpText.setText(String.valueOf(Php));
                    TextView Acc2PmpText = findViewById(R.id.Acc2TVPmp);
                    Acc2PmpText.setText(String.valueOf(Pmp));
                    TextView Acc2PatkText = findViewById(R.id.Acc2TVPatk);
                    Acc2PatkText.setText(String.valueOf(Patk));
                    TextView Acc2PdefText = findViewById(R.id.Acc2TVPdef);
                    Acc2PdefText.setText(String.valueOf(Pdef));
                    TextView Acc2PmagText = findViewById(R.id.Acc2TVPmag);
                    Acc2PmagText.setText(String.valueOf(Pmag));
                    TextView Acc2PsprText = findViewById(R.id.Acc2TVPspr);
                    Acc2PsprText.setText(String.valueOf(Pspr));

                    if (hp == 0)
                    {
                        Acc2hpText.setVisibility(View.GONE);
                    }
                    else
                    {
                        Acc2hpText.setText("HP: " + String.valueOf(hp));
                    }

                    if (mp == 0)
                    {
                        Acc2mpText.setVisibility(View.GONE);
                    }
                    else
                    {
                        Acc2mpText.setText("MP: " + String.valueOf(mp));
                    }

                    if (atk == 0)
                    {
                        Acc2atkText.setVisibility(View.GONE);
                    }
                    else
                    {
                        Acc2atkText.setText("Atk: " + String.valueOf(atk));
                    }

                    if (def == 0)
                    {
                        Acc2defText.setVisibility(View.GONE);
                    }
                    else
                    {
                        Acc2defText.setText("Def: " + String.valueOf(def));
                    }

                    if (mag == 0)
                    {
                        Acc2magText.setVisibility(View.GONE);
                    }
                    else
                    {
                        Acc2magText.setText("Mag: " + String.valueOf(mag));
                    }

                    if (spr == 0)
                    {
                        Acc2sprText.setVisibility(View.GONE);
                    }
                    else
                    {
                        Acc2sprText.setText("Spr: " + String.valueOf(spr));
                    }


                    if (Php == 0)
                    {
                        Acc2PhpText.setVisibility(View.GONE);
                    }
                    else
                    {
                        Acc2PhpText.setText("HP: " + String.valueOf(Php) + "% ");
                    }

                    if (Pmp == 0)
                    {
                        Acc2PmpText.setVisibility(View.GONE);
                    }
                    else
                    {
                        Acc2PmpText.setText("MP: " + String.valueOf(Pmp) + "% ");
                    }

                    if (Patk == 0)
                    {
                        Acc2PatkText.setVisibility(View.GONE);
                    }
                    else
                    {
                        Acc2PatkText.setText("Atk: " + String.valueOf(Patk) + "% ");
                    }

                    if (Pdef == 0)
                    {
                        Acc2PdefText.setVisibility(View.GONE);
                    }
                    else
                    {
                        Acc2PdefText.setText("Def: " + String.valueOf(Pdef) + "% ");
                    }

                    if (Pmag == 0)
                    {
                        Acc2PmagText.setVisibility(View.GONE);
                    }
                    else
                    {
                        Acc2PmagText.setText("Mag: " + String.valueOf(Pmag) + "% ");
                    }

                    if (Pspr == 0)
                    {
                        Acc2PsprText.setVisibility(View.GONE);
                    }
                    else
                    {
                        Acc2PsprText.setText("Spr: " + String.valueOf(Pspr) + "% ");
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    //creates or resumes ability Intent
    public void toAbility(View view) {
        Intent intent = new Intent(this, abilities.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivityIfNeeded(intent, 0);
    }

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

    //6 methods that load in the specified scene
    public void loadWeap1Scene(View view) {

        Transition slide = new Slide(Gravity.BOTTOM);
        TransitionManager.go(loadWeap1, slide);
    }
    public void loadWeap2Scene(View view) {

        Transition slide = new Slide(Gravity.BOTTOM);
        TransitionManager.go(loadWeap2, slide);
    }

    public void loadHelmScene(View view)
    {
        Transition slide = new Slide(Gravity.BOTTOM);
        TransitionManager.go(loadHelm, slide);
    }
    public void loadChestScene(View view)
    {
        Transition slide = new Slide(Gravity.BOTTOM);
        TransitionManager.go(loadChest, slide);
    }
    public void loadAcc1Scene(View view)
    {
        Transition slide = new Slide(Gravity.BOTTOM);
        TransitionManager.go(loadAcc1, slide);
    }
    public void loadAcc2Scene(View view)
    {
        Transition slide = new Slide(Gravity.BOTTOM);
        TransitionManager.go(loadAcc2, slide);
    }

    //Hides the img button (currently disabled due to no good graphic to use)
    public void hideImg(View view)
    {
        ImageButton button = findViewById(R.id.EquipmentImgButton);
        button.setVisibility(View.GONE);
    }

}
