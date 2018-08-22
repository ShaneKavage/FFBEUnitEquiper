package com.example.shane.finalapps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;


public class Calculate extends AppCompatActivity {

    //Declaring ints based on the passed info from the other activities
    private int FcharSpin;
    private int Fweap1Spin;
    private int Fweap2Spin;
    private int Facc1Spin;
    private int Facc2Spin;
    private int FhelmSpin;
    private int FchestSpin;
    private int Fabil1Spin;
    private int Fabil2Spin;
    private int Fabil3Spin;
    private int Fabil4Spin;
    private int FesperSpin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);

        //setting the ints = to the spinner values from the other activities
         FcharSpin = CharSelect.CcharSpin;
         Fweap1Spin = equipment.Eweap1Spin;
         Fweap2Spin = equipment.Eweap2Spin;
         Facc1Spin = equipment.Eacc1Spin;
         Facc2Spin = equipment.Eacc2Spin;
         FhelmSpin = equipment.EhelmSpin;
         FchestSpin = equipment.EchestSpin;
         Fabil1Spin = abilities.Aabil1Spin;
         Fabil2Spin = abilities.Aabil2Spin;
         Fabil3Spin = abilities.Aabil3Spin;
         Fabil4Spin =abilities.Aabil4Spin;
         FesperSpin = Esper.SesperSpin;;

         //declaring string arrays of the Value Files to make up for no databases
        String[] char_name = getResources().getStringArray(R.array.Character_Names);
        String[] char_rarity = getResources().getStringArray(R.array.rarity);
        String[] char_numb = getResources().getStringArray(R.array.char_Number);
        String[] charhp_values = getResources().getStringArray(R.array.hp_values);
        String[] charmp_values = getResources().getStringArray(R.array.mp_values);
        String[] charatk_values = getResources().getStringArray(R.array.atk_values);
        String[] chardef_values = getResources().getStringArray(R.array.def_values);
        String[] charmag_values = getResources().getStringArray(R.array.mag_values);
        String[] charspr_values = getResources().getStringArray(R.array.spr_values);
        String[] charPhp_values = getResources().getStringArray(R.array.Php_values);
        String[] charPmp_values = getResources().getStringArray(R.array.Pmp_values);
        String[] charPatk_values = getResources().getStringArray(R.array.Patk_values);
        String[] charPdef_values = getResources().getStringArray(R.array.Pdef_values);
        String[] charPmag_values = getResources().getStringArray(R.array.Pmag_values);
        String[] charPspr_values = getResources().getStringArray(R.array.Pspr_values);

        //declaring string arrays of the Value Files to make up for no databases
        String[] wp1hp_values = getResources().getStringArray(R.array.Wephp_values);
        String[] wp1mp_values = getResources().getStringArray(R.array.Wepmp_values);
        String[] wp1atk_values = getResources().getStringArray(R.array.Wepatk_values);
        String[] wp1def_values = getResources().getStringArray(R.array.Wepdef_values);
        String[] wp1mag_values = getResources().getStringArray(R.array.Wepmag_values);
        String[] wp1spr_values = getResources().getStringArray(R.array.Wepspr_values);
        String[] wp1Php_values = getResources().getStringArray(R.array.WepPhp_values);
        String[] wp1Pmp_values = getResources().getStringArray(R.array.WepPmp_values);
        String[] wp1Patk_values = getResources().getStringArray(R.array.WepPatk_values);
        String[] wp1Pdef_values = getResources().getStringArray(R.array.WepPdef_values);
        String[] wp1Pmag_values = getResources().getStringArray(R.array.WepPmag_values);
        String[] wp1Pspr_values = getResources().getStringArray(R.array.WepPspr_values);

        //declaring string arrays of the Value Files to make up for no databases
        String[] wp2hp_values = getResources().getStringArray(R.array.Wephp_values);
        String[] wp2mp_values = getResources().getStringArray(R.array.Wepmp_values);
        String[] wp2atk_values = getResources().getStringArray(R.array.Wepatk_values);
        String[] wp2def_values = getResources().getStringArray(R.array.Wepdef_values);
        String[] wp2mag_values = getResources().getStringArray(R.array.Wepmag_values);
        String[] wp2spr_values = getResources().getStringArray(R.array.Wepspr_values);
        String[] wp2Php_values = getResources().getStringArray(R.array.WepPhp_values);
        String[] wp2Pmp_values = getResources().getStringArray(R.array.WepPmp_values);
        String[] wp2Patk_values = getResources().getStringArray(R.array.WepPatk_values);
        String[] wp2Pdef_values = getResources().getStringArray(R.array.WepPdef_values);
        String[] wp2Pmag_values = getResources().getStringArray(R.array.WepPmag_values);
        String[] wp2Pspr_values = getResources().getStringArray(R.array.WepPspr_values);

        //declaring string arrays of the Value Files to make up for no databases
        String[] helmhp_values = getResources().getStringArray(R.array.Helmhp_values);
        String[] helmmp_values = getResources().getStringArray(R.array.Helmmp_values);
        String[] helmatk_values = getResources().getStringArray(R.array.Helmatk_values);
        String[] helmdef_values = getResources().getStringArray(R.array.Helmdef_values);
        String[] helmmag_values = getResources().getStringArray(R.array.Helmmag_values);
        String[] helmspr_values = getResources().getStringArray(R.array.Helmspr_values);
        String[] helmPhp_values = getResources().getStringArray(R.array.HelmPhp_values);
        String[] helmPmp_values = getResources().getStringArray(R.array.HelmPmp_values);
        String[] helmPatk_values = getResources().getStringArray(R.array.HelmPatk_values);
        String[] helmPdef_values = getResources().getStringArray(R.array.HelmPdef_values);
        String[] helmPmag_values = getResources().getStringArray(R.array.HelmPmag_values);
        String[] helmPspr_values = getResources().getStringArray(R.array.HelmPspr_values);

        //declaring string arrays of the Value Files to make up for no databases
        String[] chesthp_values = getResources().getStringArray(R.array.Chesthp_values);
        String[] chestmp_values = getResources().getStringArray(R.array.Chestmp_values);
        String[] chestatk_values = getResources().getStringArray(R.array.Chestatk_values);
        String[] chestdef_values = getResources().getStringArray(R.array.Chestdef_values);
        String[] chestmag_values = getResources().getStringArray(R.array.Chestmag_values);
        String[] chestspr_values = getResources().getStringArray(R.array.Chestspr_values);
        String[] chestPhp_values = getResources().getStringArray(R.array.ChestPhp_values);
        String[] chestPmp_values = getResources().getStringArray(R.array.ChestPmp_values);
        String[] chestPatk_values = getResources().getStringArray(R.array.ChestPatk_values);
        String[] chestPdef_values = getResources().getStringArray(R.array.ChestPdef_values);
        String[] chestPmag_values = getResources().getStringArray(R.array.ChestPmag_values);
        String[] chestPspr_values = getResources().getStringArray(R.array.ChestPspr_values);

        //declaring string arrays of the Value Files to make up for no databases
        String[] acc1hp_values = getResources().getStringArray(R.array.Acchp_values);
        String[] acc1mp_values = getResources().getStringArray(R.array.Accmp_values);
        String[] acc1atk_values = getResources().getStringArray(R.array.Accatk_values);
        String[] acc1def_values = getResources().getStringArray(R.array.Accdef_values);
        String[] acc1mag_values = getResources().getStringArray(R.array.Accmag_values);
        String[] acc1spr_values = getResources().getStringArray(R.array.Accspr_values);
        String[] acc1Php_values = getResources().getStringArray(R.array.AccPhp_values);
        String[] acc1Pmp_values = getResources().getStringArray(R.array.AccPmp_values);
        String[] acc1Patk_values = getResources().getStringArray(R.array.AccPatk_values);
        String[] acc1Pdef_values = getResources().getStringArray(R.array.AccPdef_values);
        String[] acc1Pmag_values = getResources().getStringArray(R.array.AccPmag_values);
        String[] acc1Pspr_values = getResources().getStringArray(R.array.AccPspr_values);

        //declaring string arrays of the Value Files to make up for no databases
        String[] acc2hp_values = getResources().getStringArray(R.array.Acchp_values);
        String[] acc2mp_values = getResources().getStringArray(R.array.Accmp_values);
        String[] acc2atk_values = getResources().getStringArray(R.array.Accatk_values);
        String[] acc2def_values = getResources().getStringArray(R.array.Accdef_values);
        String[] acc2mag_values = getResources().getStringArray(R.array.Accmag_values);
        String[] acc2spr_values = getResources().getStringArray(R.array.Accspr_values);
        String[] acc2Php_values = getResources().getStringArray(R.array.AccPhp_values);
        String[] acc2Pmp_values = getResources().getStringArray(R.array.AccPmp_values);
        String[] acc2Patk_values = getResources().getStringArray(R.array.AccPatk_values);
        String[] acc2Pdef_values = getResources().getStringArray(R.array.AccPdef_values);
        String[] acc2Pmag_values = getResources().getStringArray(R.array.AccPmag_values);
        String[] acc2Pspr_values = getResources().getStringArray(R.array.AccPspr_values);

        //declaring string arrays of the Value Files to make up for no databases
        String[] abil1Php_values = getResources().getStringArray(R.array.AbilityPhp);
        String[] abil1Pmp_values = getResources().getStringArray(R.array.AbilityPmp);
        String[] abil1Patk_values = getResources().getStringArray(R.array.AbilityPatk);
        String[] abil1Pdef_values = getResources().getStringArray(R.array.AbilityPdef);
        String[] abil1Pmag_values = getResources().getStringArray(R.array.AbilityPmag);
        String[] abil1Pspr_values = getResources().getStringArray(R.array.AbilityPspr);

        //declaring string arrays of the Value Files to make up for no databases
        String[] abil2Php_values = getResources().getStringArray(R.array.AbilityPhp);
        String[] abil2Pmp_values = getResources().getStringArray(R.array.AbilityPmp);
        String[] abil2Patk_values = getResources().getStringArray(R.array.AbilityPatk);
        String[] abil2Pdef_values = getResources().getStringArray(R.array.AbilityPdef);
        String[] abil2Pmag_values = getResources().getStringArray(R.array.AbilityPmag);
        String[] abil2Pspr_values = getResources().getStringArray(R.array.AbilityPspr);

        //declaring string arrays of the Value Files to make up for no databases
        String[] abil3Php_values = getResources().getStringArray(R.array.AbilityPhp);
        String[] abil3Pmp_values = getResources().getStringArray(R.array.AbilityPmp);
        String[] abil3Patk_values = getResources().getStringArray(R.array.AbilityPatk);
        String[] abil3Pdef_values = getResources().getStringArray(R.array.AbilityPdef);
        String[] abil3Pmag_values = getResources().getStringArray(R.array.AbilityPmag);
        String[] abil3Pspr_values = getResources().getStringArray(R.array.AbilityPspr);

        //declaring string arrays of the Value Files to make up for no databases
        String[] abil4Php_values = getResources().getStringArray(R.array.AbilityPhp);
        String[] abil4Pmp_values = getResources().getStringArray(R.array.AbilityPmp);
        String[] abil4Patk_values = getResources().getStringArray(R.array.AbilityPatk);
        String[] abil4Pdef_values = getResources().getStringArray(R.array.AbilityPdef);
        String[] abil4Pmag_values = getResources().getStringArray(R.array.AbilityPmag);
        String[] abil4Pspr_values = getResources().getStringArray(R.array.AbilityPspr);

        //declaring string arrays of the Value Files to make up for no databases
        String[] esphp_values = getResources().getStringArray(R.array.Esper_hp);
        String[] espmp_values = getResources().getStringArray(R.array.Esper_mp);
        String[] espatk_values = getResources().getStringArray(R.array.Esper_atk);
        String[] espdef_values = getResources().getStringArray(R.array.Esper_def);
        String[] espmag_values = getResources().getStringArray(R.array.Esper_mag);
        String[] espspr_values = getResources().getStringArray(R.array.Esper_spr);

        String charName = String.valueOf(char_name[FcharSpin]);

        //Declaring the ints based on the spinner positions for from the value.xml

        //gets character values
        int charrarityVal = Integer.valueOf(char_rarity[FcharSpin]);
        int charnumb = Integer.valueOf(char_numb[FcharSpin]);
        int charhp = Integer.valueOf(charhp_values[FcharSpin]);
        int charmp = Integer.valueOf(charmp_values[FcharSpin]);
        int charatk = Integer.valueOf(charatk_values[FcharSpin]);
        int chardef = Integer.valueOf(chardef_values[FcharSpin]);
        int charspr = Integer.valueOf(charspr_values[FcharSpin]);
        int charmag = Integer.valueOf(charmag_values[FcharSpin]);
        int charPhp = Integer.valueOf(charPhp_values[FcharSpin]);
        int charPmp = Integer.valueOf(charPmp_values[FcharSpin]);
        int charPatk = Integer.valueOf(charPatk_values[FcharSpin]);
        int charPmag = Integer.valueOf(charPmag_values[FcharSpin]);
        int charPdef = Integer.valueOf(charPdef_values[FcharSpin]);
        int charPspr = Integer.valueOf(charPspr_values[FcharSpin]);

        //gets wep1 values
        int wep1hp = Integer.valueOf(wp1hp_values[Fweap1Spin]);
        int wep1mp = Integer.valueOf(wp1mp_values[Fweap1Spin]);
        int wep1atk = Integer.valueOf(wp1atk_values[Fweap1Spin]);
        int wep1def = Integer.valueOf(wp1def_values[Fweap1Spin]);
        int wep1spr = Integer.valueOf(wp1spr_values[Fweap1Spin]);
        int wep1mag = Integer.valueOf(wp1mag_values[Fweap1Spin]);
        int wep1Php = Integer.valueOf(wp1Php_values[Fweap1Spin]);
        int wep1Pmp = Integer.valueOf(wp1Pmp_values[Fweap1Spin]);
        int wep1Patk = Integer.valueOf(wp1Patk_values[Fweap1Spin]);
        int wep1Pmag = Integer.valueOf(wp1Pmag_values[Fweap1Spin]);
        int wep1Pdef = Integer.valueOf(wp1Pdef_values[Fweap1Spin]);
        int wep1Pspr = Integer.valueOf(wp1Pspr_values[Fweap1Spin]);

        //gets wep2 values
        int wep2hp = Integer.valueOf(wp2hp_values[Fweap2Spin]);
        int wep2mp = Integer.valueOf(wp2mp_values[Fweap2Spin]);
        int wep2atk = Integer.valueOf(wp2atk_values[Fweap2Spin]);
        int wep2def = Integer.valueOf(wp2def_values[Fweap2Spin]);
        int wep2spr = Integer.valueOf(wp2spr_values[Fweap2Spin]);
        int wep2mag = Integer.valueOf(wp2mag_values[Fweap2Spin]);
        int wep2Php = Integer.valueOf(wp2Php_values[Fweap2Spin]);
        int wep2Pmp = Integer.valueOf(wp2Pmp_values[Fweap2Spin]);
        int wep2Patk = Integer.valueOf(wp2Patk_values[Fweap2Spin]);
        int wep2Pmag = Integer.valueOf(wp2Pmag_values[Fweap2Spin]);
        int wep2Pdef = Integer.valueOf(wp2Pdef_values[Fweap2Spin]);
        int wep2Pspr = Integer.valueOf(wp2Pspr_values[Fweap2Spin]);

        //gets helms values
        int helmhp = Integer.valueOf(helmhp_values[FhelmSpin]);
        int helmmp = Integer.valueOf(helmmp_values[FhelmSpin]);
        int helmatk = Integer.valueOf(helmatk_values[FhelmSpin]);
        int helmdef = Integer.valueOf(helmdef_values[FhelmSpin]);
        int helmspr = Integer.valueOf(helmspr_values[FhelmSpin]);
        int helmmag = Integer.valueOf(helmmag_values[FhelmSpin]);
        int helmPhp = Integer.valueOf(helmPhp_values[FhelmSpin]);
        int helmPmp = Integer.valueOf(helmPmp_values[FhelmSpin]);
        int helmPatk = Integer.valueOf(helmPatk_values[FhelmSpin]);
        int helmPmag = Integer.valueOf(helmPmag_values[FhelmSpin]);
        int helmPdef = Integer.valueOf(helmPdef_values[FhelmSpin]);
        int helmPspr = Integer.valueOf(helmPspr_values[FhelmSpin]);

        //gets chest values
        int chesthp = Integer.valueOf(chesthp_values[FchestSpin]);
        int chestmp = Integer.valueOf(chestmp_values[FchestSpin]);
        int chestatk = Integer.valueOf(chestatk_values[FchestSpin]);
        int chestdef = Integer.valueOf(chestdef_values[FchestSpin]);
        int chestspr = Integer.valueOf(chestspr_values[FchestSpin]);
        int chestmag = Integer.valueOf(chestmag_values[FchestSpin]);
        int chestPhp = Integer.valueOf(chestPhp_values[FchestSpin]);
        int chestPmp = Integer.valueOf(chestPmp_values[FchestSpin]);
        int chestPatk = Integer.valueOf(chestPatk_values[FchestSpin]);
        int chestPmag = Integer.valueOf(chestPmag_values[FchestSpin]);
        int chestPdef = Integer.valueOf(chestPdef_values[FchestSpin]);
        int chestPspr = Integer.valueOf(chestPspr_values[FchestSpin]);

        //gets accessory 1 values
        int acc1hp = Integer.valueOf(acc1hp_values[Facc1Spin]);
        int acc1mp = Integer.valueOf(acc1mp_values[Facc1Spin]);
        int acc1atk = Integer.valueOf(acc1atk_values[Facc1Spin]);
        int acc1def = Integer.valueOf(acc1def_values[Facc1Spin]);
        int acc1spr = Integer.valueOf(acc1spr_values[Facc1Spin]);
        int acc1mag = Integer.valueOf(acc1mag_values[Facc1Spin]);
        int acc1Php = Integer.valueOf(acc1Php_values[Facc1Spin]);
        int acc1Pmp = Integer.valueOf(acc1Pmp_values[Facc1Spin]);
        int acc1Patk = Integer.valueOf(acc1Patk_values[Facc1Spin]);
        int acc1Pmag = Integer.valueOf(acc1Pmag_values[Facc1Spin]);
        int acc1Pdef = Integer.valueOf(acc1Pdef_values[Facc1Spin]);
        int acc1Pspr = Integer.valueOf(acc1Pspr_values[Facc1Spin]);

        //gets accessory 2 values
        int acc2hp = Integer.valueOf(acc2hp_values[Facc2Spin]);
        int acc2mp = Integer.valueOf(acc2mp_values[Facc2Spin]);
        int acc2atk = Integer.valueOf(acc2atk_values[Facc2Spin]);
        int acc2def = Integer.valueOf(acc2def_values[Facc2Spin]);
        int acc2spr = Integer.valueOf(acc2spr_values[Facc2Spin]);
        int acc2mag = Integer.valueOf(acc2mag_values[Facc2Spin]);
        int acc2Php = Integer.valueOf(acc2Php_values[Facc2Spin]);
        int acc2Pmp = Integer.valueOf(acc2Pmp_values[Facc2Spin]);
        int acc2Patk = Integer.valueOf(acc2Patk_values[Facc2Spin]);
        int acc2Pmag = Integer.valueOf(acc2Pmag_values[Facc2Spin]);
        int acc2Pdef = Integer.valueOf(acc2Pdef_values[Facc2Spin]);
        int acc2Pspr = Integer.valueOf(acc2Pspr_values[Facc2Spin]);

        //gets ability 1 values
        int abil1Php = Integer.valueOf(abil1Php_values[Fabil1Spin]);
        int abil1Pmp = Integer.valueOf(abil1Pmp_values[Fabil1Spin]);
        int abil1Patk = Integer.valueOf(abil1Patk_values[Fabil1Spin]);
        int abil1Pmag = Integer.valueOf(abil1Pmag_values[Fabil1Spin]);
        int abil1Pdef = Integer.valueOf(abil1Pdef_values[Fabil1Spin]);
        int abil1Pspr = Integer.valueOf(abil1Pspr_values[Fabil1Spin]);

        //gets ability 2 values
        int abil2Php = Integer.valueOf(abil2Php_values[Fabil2Spin]);
        int abil2Pmp = Integer.valueOf(abil2Pmp_values[Fabil2Spin]);
        int abil2Patk = Integer.valueOf(abil2Patk_values[Fabil2Spin]);
        int abil2Pmag = Integer.valueOf(abil2Pmag_values[Fabil2Spin]);
        int abil2Pdef = Integer.valueOf(abil2Pdef_values[Fabil2Spin]);
        int abil2Pspr = Integer.valueOf(abil2Pspr_values[Fabil2Spin]);

        //gets ability 3 values
        int abil3Php = Integer.valueOf(abil3Php_values[Fabil3Spin]);
        int abil3Pmp = Integer.valueOf(abil3Pmp_values[Fabil3Spin]);
        int abil3Patk = Integer.valueOf(abil3Patk_values[Fabil3Spin]);
        int abil3Pmag = Integer.valueOf(abil3Pmag_values[Fabil3Spin]);
        int abil3Pdef = Integer.valueOf(abil3Pdef_values[Fabil3Spin]);
        int abil3Pspr = Integer.valueOf(abil3Pspr_values[Fabil3Spin]);

        //gets ability 4 values
        int abil4Php = Integer.valueOf(abil4Php_values[Fabil4Spin]);
        int abil4Pmp = Integer.valueOf(abil4Pmp_values[Fabil4Spin]);
        int abil4Patk = Integer.valueOf(abil4Patk_values[Fabil4Spin]);
        int abil4Pmag = Integer.valueOf(abil4Pmag_values[Fabil4Spin]);
        int abil4Pdef = Integer.valueOf(abil4Pdef_values[Fabil4Spin]);
        int abil4Pspr = Integer.valueOf(abil4Pspr_values[Fabil4Spin]);

        //gets esper values
        int esphp = Integer.valueOf(esphp_values[FesperSpin]);
        int espmp = Integer.valueOf(espmp_values[FesperSpin]);
        int espatk = Integer.valueOf(espatk_values[FesperSpin]);
        int espdef = Integer.valueOf(espdef_values[FesperSpin]);
        int espspr = Integer.valueOf(espspr_values[FesperSpin]);
        int espmag = Integer.valueOf(espmag_values[FesperSpin]);

        //Math to add all stats together and get totals
        double totalhp = (charhp + wep1hp + wep2hp + helmhp + chesthp + acc1hp + acc2hp + (.01*esphp));
        double totalmp = (charmp + wep1mp + wep2mp + helmmp + chestmp + acc1mp + acc2mp + (.01*espmp));
        double totalatk = (charatk + wep1atk + wep2atk + helmatk + chestatk + acc1atk + acc2atk + (.01*espatk));
        double totaldef = (chardef + wep1def + wep2def + helmdef + chestdef + acc1def + acc2def + (.01*espdef));
        double totalmag = (charmag + wep1mag + wep2mag + helmmag + chestmag + acc1mag + acc2mag + (.01*espmag));
        double totalspr = (charspr + wep1spr + wep2spr + helmspr + chestspr + acc1spr + acc2spr + (.01*espspr));

        double totalPhp = (charPhp + wep1Php + wep2Php + helmPhp + chestPhp + acc1Php + acc2Php + abil1Php + abil2Php + abil3Php + abil4Php);
        double totalPmp = (charPmp + wep1Pmp + wep2Pmp + helmPmp + chestPmp + acc1Pmp + acc2Pmp + abil1Pmp + abil2Pmp + abil3Pmp + abil4Pmp);
        double totalPatk = (charPatk + wep1Patk + wep2Patk + helmPatk + chestPatk + acc1Patk + acc2Patk + abil1Patk + abil2Patk + abil3Patk + abil4Patk);
        double totalPdef = (charPdef + wep1Pdef + wep2Pdef + helmPdef + chestPdef + acc1Pdef + acc2Pdef + abil1Pdef + abil2Pdef + abil3Pdef + abil4Pdef);
        double totalPmag = (charPmag + wep1Pmag + wep2Pmag + helmPmag + chestPmag + acc1Pmag + acc2Pmag + abil1Pmag + abil2Pmag + abil3Pmag + abil4Pmag);
        double totalPspr = (charPspr + wep1Pspr + wep2Pspr + helmPspr + chestPspr + acc1Pspr + acc2Pspr + abil1Pspr + abil2Pspr + abil3Pspr + abil4Pspr);

        //Setting the finals
        double finalHp = Math.floor( totalhp + (charhp * (.01 * totalPhp)) );
        double finalMp =  Math.floor( totalmp + (charmp * (.01 *totalPmp)) );
        double finalAtk =  Math.floor( totalatk + (charatk * (.01 * totalPatk)) );
        double finalDef =  Math.floor( totaldef + (chardef * (.01 * totalPdef)) );
        double finalMag =  Math.floor( totalmag + (charmag * (.01 * totalPmag)) );
        double finalSpr =  Math.floor( totalspr + (charspr * (.01 * totalPspr)) );

        //Changing all of the text fields to show the stats
        TextView FinalCharName = findViewById(R.id.CharacterName);
        FinalCharName.setText(charName);
        TextView FinalCharNum = findViewById(R.id.CharacterNumber);
        FinalCharNum.setText("No.: " + Integer.toString(charnumb));
        TextView FinalCharRare = findViewById(R.id.CharacterRarity);
        FinalCharRare.setText("Rarity: " +Integer.toString(charrarityVal));
        TextView FinalHpTV = findViewById(R.id.CharacterHp);
        FinalHpTV.setText(Double.toString(finalHp));
        TextView FinalMpTV = findViewById(R.id.CharacterMp);
        FinalMpTV.setText(Double.toString(finalMp));
        TextView FinalAtkTV = findViewById(R.id.CharacterAtk);
        FinalAtkTV.setText(Double.toString(finalAtk));
        TextView FinalDefTV = findViewById(R.id.CharacterDef);
        FinalDefTV.setText(Double.toString(finalDef));
        TextView FinalMagTV = findViewById(R.id.CharacterMag);
        FinalMagTV.setText(Double.toString(finalMag));
        TextView FinalSprTV = findViewById(R.id.CharacterSpr);
        FinalSprTV.setText(Double.toString(finalSpr));

        //Final Textfield stats
        TextView FinalPHpTV = findViewById(R.id.CharacterPHp);
        FinalPHpTV.setText("Percent Hp: " + Double.toString(totalPhp) + "%");
        TextView FinalPMpTV = findViewById(R.id.CharacterPMp);
        FinalPMpTV.setText("Percent Mp: " + Double.toString(totalPmp)+ "%");
        TextView FinalPAtkTV = findViewById(R.id.CharacterPAtk);
        FinalPAtkTV.setText("Percent Atk: " + Double.toString(totalPatk) + "%");
        TextView FinalPDefTV = findViewById(R.id.CharacterPDef);
        FinalPDefTV.setText("Percent Def: " + Double.toString(totalPdef) + "%");
        TextView FinalPMagTV = findViewById(R.id.CharacterPMag);
        FinalPMagTV.setText("Percent Mag: " + Double.toString(totalPmag) + "%");
        TextView FinalPSprTV = findViewById(R.id.CharacterPSpr);
        FinalPSprTV.setText("Percent Spr: " + Double.toString(totalPspr) + "%");

        //Image switch to change which character is shown
        ImageView background = findViewById(R.id.CharacterSpriteImg);
        switch (FcharSpin)
        {
            case 0:background.setBackgroundResource(R.drawable.black);
                break;
            case 1:background.setBackgroundResource(R.drawable.c1);
                break;
            case 2:background.setBackgroundResource(R.drawable.c2);
                break;
            case 3:background.setBackgroundResource(R.drawable.c3);
                break;
            case 4:background.setBackgroundResource(R.drawable.c4);
                break;
            case 5:background.setBackgroundResource(R.drawable.c5);
                break;
            case 6:background.setBackgroundResource(R.drawable.c6);
                break;
            case 7:background.setBackgroundResource(R.drawable.c7);
                break;
            case 8:background.setBackgroundResource(R.drawable.c8);
                break;
            case 9:background.setBackgroundResource(R.drawable.c9);
                break;
            case 10:background.setBackgroundResource(R.drawable.c10);
                break;

        }
    }

    //creates or resumes ability Intent
    public void toAbility(View view) {
        Intent intent = new Intent(this, abilities.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivityIfNeeded(intent, 0);
        finish();
    }

    //creates or resumes Epser Intent
    public void toEsper(View view) {
        Intent intent = new Intent(this, Esper.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivityIfNeeded(intent, 0);
        finish();
    }

    //creates or resumes equipment Intent
    public void toEquip(View view) {
        Intent intent = new Intent(this, equipment.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivityIfNeeded(intent, 0);
        finish();
    }

    //creates or resumes character Intent
    public void toChar(View view) {
        Intent intent = new Intent(this, CharSelect.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivityIfNeeded(intent, 0);
        finish();
    }

    //creates or resumes calculateIntent
    public void toCalculate(View view)
    {
        Intent intent = new Intent(this, Calculate.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivityIfNeeded(intent, 0);
        finish();

    }

}
