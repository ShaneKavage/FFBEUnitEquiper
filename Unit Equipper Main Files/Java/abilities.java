package com.example.shane.finalapps;
/*A bad app i made for a final. It did the job, but I am recoding and changing it to less coupled, and eventually linked to a database*/
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
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class abilities extends AppCompatActivity {

    //loads up 4 spinners that share an adapter
    private Spinner spinner1;
    private Spinner spinner2;
    private Spinner spinner3;
    private Spinner spinner4;

    private ArrayAdapter<CharSequence> adapter;

    //loads up the scenes that have the TextView stats
    private Scene loadAbil1;
    private Scene loadAbil2;
    private Scene loadAbil3;
    private Scene loadAbil4;

    //hides the scenes when the spinner == 0
    private Scene hideAbil;
    private Scene hideAbi2;
    private Scene hideAbi3;
    private Scene hideAbi4;

    //4 statics to transfer spinner values to calculate
   static int Aabil1Spin = 0;
   static int Aabil2Spin = 0;
   static int Aabil3Spin = 0;
   static int Aabil4Spin = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abilities);

        //loads up all of the scenes to their respective view
        loadAbil1 = Scene.getSceneForLayout((ViewGroup) findViewById(R.id.abil1), R.layout.equipment_scene, this);
        loadAbil2 = Scene.getSceneForLayout((ViewGroup) findViewById(R.id.abil2), R.layout.equipment_scene2, this);
        loadAbil3 = Scene.getSceneForLayout((ViewGroup) findViewById(R.id.abil3), R.layout.equipment_scene3, this);
        loadAbil4 = Scene.getSceneForLayout((ViewGroup) findViewById(R.id.abil4), R.layout.equipment_scene4, this);

        hideAbil = Scene.getSceneForLayout((ViewGroup) findViewById(R.id.abil1), R.layout.hide_scene, this);
        hideAbi2 = Scene.getSceneForLayout((ViewGroup) findViewById(R.id.abil2), R.layout.hide_scene, this);
        hideAbi3 = Scene.getSceneForLayout((ViewGroup) findViewById(R.id.abil3), R.layout.hide_scene, this);
        hideAbi4 = Scene.getSceneForLayout((ViewGroup) findViewById(R.id.abil4), R.layout.hide_scene, this);


        // sets the spinners and loads in the adapter
        spinner1 = findViewById(R.id.Abil1Spin);
        adapter = ArrayAdapter.createFromResource(this,R.array.Ability_names, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);

        spinner2 = findViewById(R.id.Abil2Spin);
        adapter = ArrayAdapter.createFromResource(this,R.array.Ability_names, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter);

        spinner3 = findViewById(R.id.Abil3Spin);
        adapter = ArrayAdapter.createFromResource(this,R.array.Ability_names, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter);

        spinner4 = findViewById(R.id.Abil4Spin);
        adapter = ArrayAdapter.createFromResource(this,R.array.Ability_names, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner4.setAdapter(adapter);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
                //sets the static int to the spinner position value for the calculate page
                int spinner_pos1 = spinner1.getSelectedItemPosition();
                Aabil1Spin = spinner_pos1;

                //Creates string arrays that hold the values for each ability.
                String[] Php_values = getResources().getStringArray(R.array.AbilityPhp);
                String[] Pmp_values = getResources().getStringArray(R.array.AbilityPmp);
                String[] Patk_values = getResources().getStringArray(R.array.AbilityPatk);
                String[] Pdef_values = getResources().getStringArray(R.array.AbilityPdef);
                String[] Pmag_values = getResources().getStringArray(R.array.AbilityPmag);
                String[] Pspr_values = getResources().getStringArray(R.array.AbilityPspr);

                //Creates ints equal to the value of the string array at the given spinner position
                int Php = Integer.valueOf(Php_values[spinner_pos1]);
                int Pmp = Integer.valueOf(Pmp_values[spinner_pos1]);
                int Patk = Integer.valueOf(Patk_values[spinner_pos1]);
                int Pmag = Integer.valueOf(Pmag_values[spinner_pos1]);
                int Pdef = Integer.valueOf(Pdef_values[spinner_pos1]);
                int Pspr = Integer.valueOf(Pspr_values[spinner_pos1]);


                // if the spinner position is anything but none
                if (spinner_pos1 > 0)
                {

                    //loads in the scene with the TextViews
                    loadAbil1Scene(view);

                    //Sets textviews to be changed by visibility or value
                    TextView abilHp = findViewById(R.id.EquipTVhp);
                    TextView abilMp = findViewById(R.id.EquipTVmp);
                    TextView abilPhp = findViewById(R.id.EquipTVPhp);
                    TextView abilPmp = findViewById(R.id.EquipTVPmp);

                    abilHp.setVisibility(View.GONE);
                    abilMp.setVisibility(View.GONE);

                    TextView abilAtk = findViewById(R.id.EquipTVatk);
                    TextView abilDef = findViewById(R.id.EquipTVdef);
                    TextView abilMag = findViewById(R.id.EquipTVmag);
                    TextView abilSpr = findViewById(R.id.EquipTVspr);

                    abilAtk.setVisibility(View.GONE);
                    abilDef.setVisibility(View.GONE);
                    abilMag.setVisibility(View.GONE);
                    abilSpr.setVisibility(View.GONE);

                    TextView abilPatk = findViewById(R.id.EquipTVPatk);
                    TextView abilPdef = findViewById(R.id.EquipTVPdef);
                    TextView abilPmag = findViewById(R.id.EquipTVPmag);
                    TextView abilPspr = findViewById(R.id.EquipTVPspr);
                    TextView abilDh = findViewById(R.id.EquipTVdh);

                    abilDh.setVisibility(view.GONE);

                    //if any of the values are == 0 I set them to gone
                    if (Php == 0)
                    {
                        abilPhp.setVisibility(View.GONE);
                    }
                    else
                    {
                        abilPhp.setText("HP: " + String.valueOf(Php) + "% ");
                    }

                    if (Pmp == 0)
                    {
                        abilPmp.setVisibility(View.GONE);
                    }
                    else
                    {
                        abilPmp.setText("MP: " + String.valueOf(Pmp) + "% ");
                    }

                    if (Patk == 0)
                    {
                        abilPatk.setVisibility(View.GONE);
                    }
                    else
                    {
                        abilPatk.setText("Atk: " + String.valueOf(Patk) + "% ");
                    }

                    if (Pdef == 0)
                    {
                        abilPdef.setVisibility(View.GONE);
                    }
                    else
                    {
                        abilPdef.setText("Def: " + String.valueOf(Pdef) + "% ");
                    }

                    if (Pmag == 0)
                    {
                        abilPmag.setVisibility(View.GONE);
                    }
                    else
                    {
                        abilPmag.setText("Mag: " + String.valueOf(Pmag) + "% ");
                    }

                    if (Pspr == 0)
                    {
                        abilPspr.setVisibility(View.GONE);
                    }
                    else
                    {
                        abilPspr.setText("Spr: " + String.valueOf(Pspr) + "% ");
                    }

                }
                else
                {
                    //if spinnerPos == 0 I hide the scene.
                    loadHide1Scene(view);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //spinners 2-4 are copies of spinner 1
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
                int spinner_pos2 = spinner2.getSelectedItemPosition();
                Aabil2Spin = spinner_pos2;

                String[] Php_values = getResources().getStringArray(R.array.AbilityPhp);
                String[] Pmp_values = getResources().getStringArray(R.array.AbilityPmp);
                String[] Patk_values = getResources().getStringArray(R.array.AbilityPatk);
                String[] Pdef_values = getResources().getStringArray(R.array.AbilityPdef);
                String[] Pmag_values = getResources().getStringArray(R.array.AbilityPmag);
                String[] Pspr_values = getResources().getStringArray(R.array.AbilityPspr);

                int Php = Integer.valueOf(Php_values[spinner_pos2]);
                int Pmp = Integer.valueOf(Pmp_values[spinner_pos2]);
                int Patk = Integer.valueOf(Patk_values[spinner_pos2]);
                int Pmag = Integer.valueOf(Pmag_values[spinner_pos2]);
                int Pdef = Integer.valueOf(Pdef_values[spinner_pos2]);
                int Pspr = Integer.valueOf(Pspr_values[spinner_pos2]);

                if (spinner_pos2 >0)
                {
                    loadAbil2Scene(view);

                    TextView abilHp = findViewById(R.id.EquipTVhp2);
                    TextView abilMp = findViewById(R.id.EquipTVmp2);
                    TextView abilPhp = findViewById(R.id.EquipTVPhp2);
                    TextView abilPmp = findViewById(R.id.EquipTVPmp2);

                    abilHp.setVisibility(View.GONE);
                    abilMp.setVisibility(View.GONE);

                    TextView abilAtk = findViewById(R.id.EquipTVatk2);
                    TextView abilDef = findViewById(R.id.EquipTVdef2);
                    TextView abilMag = findViewById(R.id.EquipTVmag2);
                    TextView abilSpr = findViewById(R.id.EquipTVspr2);

                    abilAtk.setVisibility(View.GONE);
                    abilDef.setVisibility(View.GONE);
                    abilMag.setVisibility(View.GONE);
                    abilSpr.setVisibility(View.GONE);

                    TextView abilPatk = findViewById(R.id.EquipTVPatk2);
                    TextView abilPdef = findViewById(R.id.EquipTVPdef2);
                    TextView abilPmag = findViewById(R.id.EquipTVPmag2);
                    TextView abilPspr = findViewById(R.id.EquipTVPspr2);
                    TextView abilDh = findViewById(R.id.EquipTVdh2);

                    abilDh.setVisibility(view.GONE);

                    if (Php == 0)
                    {
                        abilPhp.setVisibility(View.GONE);
                    }
                    else
                    {
                        abilPhp.setText("HP: " + String.valueOf(Php) + "% ");
                    }

                    if (Pmp == 0)
                    {
                        abilPmp.setVisibility(View.GONE);
                    }
                    else
                    {
                        abilPmp.setText("MP: " + String.valueOf(Pmp) + "% ");
                    }

                    if (Patk == 0)
                    {
                        abilPatk.setVisibility(View.GONE);
                    }
                    else
                    {
                        abilPatk.setText("Atk: " + String.valueOf(Patk) + "% ");
                    }

                    if (Pdef == 0)
                    {
                        abilPdef.setVisibility(View.GONE);
                    }
                    else
                    {
                        abilPdef.setText("Def: " + String.valueOf(Pdef) + "% ");
                    }

                    if (Pmag == 0)
                    {
                        abilPmag.setVisibility(View.GONE);
                    }
                    else
                    {
                        abilPmag.setText("Mag: " + String.valueOf(Pmag) + "% ");
                    }

                    if (Pspr == 0)
                    {
                        abilPspr.setVisibility(View.GONE);
                    }
                    else
                    {
                        abilPspr.setText("Spr: " + String.valueOf(Pspr) + "% ");
                    }

                }
                else
                {
                    loadHide2Scene(view);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
                int spinner_pos3 = spinner3.getSelectedItemPosition();
                Aabil3Spin = spinner_pos3;

                String[] Php_values = getResources().getStringArray(R.array.AbilityPhp);
                String[] Pmp_values = getResources().getStringArray(R.array.AbilityPmp);
                String[] Patk_values = getResources().getStringArray(R.array.AbilityPatk);
                String[] Pdef_values = getResources().getStringArray(R.array.AbilityPdef);
                String[] Pmag_values = getResources().getStringArray(R.array.AbilityPmag);
                String[] Pspr_values = getResources().getStringArray(R.array.AbilityPspr);

                int Php = Integer.valueOf(Php_values[spinner_pos3]);
                int Pmp = Integer.valueOf(Pmp_values[spinner_pos3]);
                int Patk = Integer.valueOf(Patk_values[spinner_pos3]);
                int Pmag = Integer.valueOf(Pmag_values[spinner_pos3]);
                int Pdef = Integer.valueOf(Pdef_values[spinner_pos3]);
                int Pspr = Integer.valueOf(Pspr_values[spinner_pos3]);

                if (spinner_pos3 >0)
                {
                    loadAbil3Scene(view);

                    TextView abilHp = findViewById(R.id.EquipTVhp3);
                    TextView abilMp = findViewById(R.id.EquipTVmp3);
                    TextView abilPhp = findViewById(R.id.EquipTVPhp3);
                    TextView abilPmp = findViewById(R.id.EquipTVPmp3);

                    abilHp.setVisibility(View.GONE);
                    abilMp.setVisibility(View.GONE);

                    TextView abilAtk = findViewById(R.id.EquipTVatk3);
                    TextView abilDef = findViewById(R.id.EquipTVdef3);
                    TextView abilMag = findViewById(R.id.EquipTVmag3);
                    TextView abilSpr = findViewById(R.id.EquipTVspr3);

                    abilAtk.setVisibility(View.GONE);
                    abilDef.setVisibility(View.GONE);
                    abilMag.setVisibility(View.GONE);
                    abilSpr.setVisibility(View.GONE);

                    TextView abilPatk = findViewById(R.id.EquipTVPatk3);
                    TextView abilPdef = findViewById(R.id.EquipTVPdef3);
                    TextView abilPmag = findViewById(R.id.EquipTVPmag3);
                    TextView abilPspr = findViewById(R.id.EquipTVPspr3);
                    TextView abilDh = findViewById(R.id.EquipTVdh3);

                    abilDh.setVisibility(view.GONE);

                    if (Php == 0)
                    {
                        abilPhp.setVisibility(View.GONE);
                    }
                    else
                    {
                        abilPhp.setText("HP:" + String.valueOf(Php) + "% ");
                    }

                    if (Pmp == 0)
                    {
                        abilPmp.setVisibility(View.GONE);
                    }
                    else
                    {
                        abilPmp.setText("MP:" + String.valueOf(Pmp) + "% ");
                    }

                    if (Patk == 0)
                    {
                        abilPatk.setVisibility(View.GONE);
                    }
                    else
                    {
                        abilPatk.setText("Atk: " + String.valueOf(Patk) + "% ");
                    }

                    if (Pdef == 0)
                    {
                        abilPdef.setVisibility(View.GONE);
                    }
                    else
                    {
                        abilPdef.setText("Def: " + String.valueOf(Pdef) + "% ");
                    }

                    if (Pmag == 0)
                    {
                        abilPmag.setVisibility(View.GONE);
                    }
                    else
                    {
                        abilPmag.setText("Mag: " + String.valueOf(Pmag) + "% ");
                    }

                    if (Pspr == 0)
                    {
                        abilPspr.setVisibility(View.GONE);
                    }
                    else
                    {
                        abilPspr.setText("Spr: " + String.valueOf(Pspr) + "% ");
                    }

                }
                else
                {
                    loadHide3Scene(view);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
                int spinner_pos4 = spinner4.getSelectedItemPosition();
                Aabil4Spin = spinner_pos4;

                String[] Php_values = getResources().getStringArray(R.array.AbilityPhp);
                String[] Pmp_values = getResources().getStringArray(R.array.AbilityPmp);
                String[] Patk_values = getResources().getStringArray(R.array.AbilityPatk);
                String[] Pdef_values = getResources().getStringArray(R.array.AbilityPdef);
                String[] Pmag_values = getResources().getStringArray(R.array.AbilityPmag);
                String[] Pspr_values = getResources().getStringArray(R.array.AbilityPspr);

                int Php = Integer.valueOf(Php_values[spinner_pos4]);
                int Pmp = Integer.valueOf(Pmp_values[spinner_pos4]);
                int Patk = Integer.valueOf(Patk_values[spinner_pos4]);
                int Pmag = Integer.valueOf(Pmag_values[spinner_pos4]);
                int Pdef = Integer.valueOf(Pdef_values[spinner_pos4]);
                int Pspr = Integer.valueOf(Pspr_values[spinner_pos4]);

                if (spinner_pos4 >0)
                {
                    loadAbil4Scene(view);

                    TextView abilHp = findViewById(R.id.EquipTVhp4);
                    TextView abilMp = findViewById(R.id.EquipTVmp4);
                    TextView abilPhp = findViewById(R.id.EquipTVPhp4);
                    TextView abilPmp = findViewById(R.id.EquipTVPmp4);

                    abilHp.setVisibility(View.GONE);
                    abilMp.setVisibility(View.GONE);

                    TextView abilAtk = findViewById(R.id.EquipTVatk4);
                    TextView abilDef = findViewById(R.id.EquipTVdef4);
                    TextView abilMag = findViewById(R.id.EquipTVmag4);
                    TextView abilSpr = findViewById(R.id.EquipTVspr4);

                    abilAtk.setVisibility(View.GONE);
                    abilDef.setVisibility(View.GONE);
                    abilMag.setVisibility(View.GONE);
                    abilSpr.setVisibility(View.GONE);

                    TextView abilPatk = findViewById(R.id.EquipTVPatk4);
                    TextView abilPdef = findViewById(R.id.EquipTVPdef4);
                    TextView abilPmag = findViewById(R.id.EquipTVPmag4);
                    TextView abilPspr = findViewById(R.id.EquipTVPspr4);
                    TextView abilDh = findViewById(R.id.EquipTVdh4);

                    abilDh.setVisibility(view.GONE);

                    if (Php == 0)
                    {
                        abilPhp.setVisibility(View.GONE);
                    }
                    else
                    {
                        abilPhp.setText("HP: " + String.valueOf(Php) + "% ");
                    }

                    if (Pmp == 0)
                    {
                        abilPmp.setVisibility(View.GONE);
                    }
                    else
                    {
                        abilPmp.setText("MP: " + String.valueOf(Pmp) + "% ");
                    }

                    if (Patk == 0)
                    {
                        abilPatk.setVisibility(View.GONE);
                    }
                    else
                    {
                        abilPatk.setText("Atk: " + String.valueOf(Patk) + "% ");
                    }

                    if (Pdef == 0)
                    {
                        abilPdef.setVisibility(View.GONE);
                    }
                    else
                    {
                        abilPdef.setText("Def: " + String.valueOf(Pdef) + "% ");
                    }

                    if (Pmag == 0)
                    {
                        abilPmag.setVisibility(View.GONE);
                    }
                    else
                    {
                        abilPmag.setText("Mag: " + String.valueOf(Pmag) + "% ");
                    }

                    if (Pspr == 0)
                    {
                        abilPspr.setVisibility(View.GONE);
                    }
                    else
                    {
                        abilPspr.setText("Spr: " + String.valueOf(Pspr) + "% ");
                    }

                }
                else
                {

                        loadHide4Scene(view);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

    //method for hiding the AbilityImgButton (currently set to gone due to no good graphic to use)
    public void hideImg(View view)
    {
        ImageButton button = findViewById(R.id.AbilityImgButton);
        button.setVisibility(View.GONE);
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

    //loads in the 4 scenes that hold the TV
    public void loadAbil1Scene(View view)
    {
        Transition slide = new Slide(Gravity.LEFT);
        TransitionManager.go(loadAbil1, slide);


    }
    public void loadAbil2Scene(View view)
    {
        Transition slide = new Slide(Gravity.RIGHT);
        TransitionManager.go(loadAbil2, slide);

    }
    public void loadAbil3Scene(View view)
    {
        Transition slide = new Slide(Gravity.LEFT);
        TransitionManager.go(loadAbil3, slide);

    }
    public void loadAbil4Scene(View view)
    {
        Transition slide = new Slide(Gravity.RIGHT);
        TransitionManager.go(loadAbil4, slide);

    }

    //hides the respective scenes if any of the spinners are 0
    public  void loadHide1Scene(View view)
    {
        Transition slide = new Slide(Gravity.LEFT);
        TransitionManager.go(hideAbil, slide);
    }
    public  void loadHide2Scene(View view)
    {
        Transition slide = new Slide(Gravity.RIGHT);
        TransitionManager.go(hideAbi2, slide);
    }
    public  void loadHide3Scene(View view)
    {
        Transition slide = new Slide(Gravity.LEFT);
        TransitionManager.go(hideAbi3, slide);
    }
    public  void loadHide4Scene(View view)
    {
        Transition slide = new Slide(Gravity.RIGHT);
        TransitionManager.go(hideAbi4, slide);
    }
}
