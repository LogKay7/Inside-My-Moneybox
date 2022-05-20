package com.example.onetirelire;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    //Noms des clés sauvegardées dans les SharedPrefs
    public static final String SOLDE = "SOLDE";
    public static final String NBBILLETS5 = "NBBILLETS5";
    public static final String NBBILLETS10 = "NBBILLETS10";
    public static final String NBBILLETS20 = "NBBILLETS20";
    public static final String NBBILLETS50 = "NBBILLETS50";
    public static final String NBBILLETS100 = "NBBILLETS100";
    public static final String NBBILLETS200 = "NBBILLETS200";
    public static final String NBBILLETS500 = "NBBILLETS500";


    public static final String NBPIECES001 = "NBPIECES001";
    public static final String NBPIECES002 = "NBPIECES002";
    public static final String NBPIECES005 = "NBPIECES005";
    public static final String NBPIECES10 = "NBPIECES10";
    public static final String NBPIECES20 = "NBPIECES20";
    public static final String NBPIECES50 = "NBPIECES50";
    public static final String NBPIECES1 = "NBPIECES1";
    public static final String NBPIECES2 = "NBPIECES2";

    public static final String VALEURSTRANSACLIST = "VALEURSTRANSACLIST";
    public static final String TITRESTRANSACLIST = "TITRESTRANSACLIST";
    public static final String DATESHEURESLIST = "DATESHEURESLIST";
    public static final String DETAILSTRANSACLISTDIALOG = "DETAILSTRANSACLISTDIALOG";
    public static final String NVSOLDETRANSACLISTDIALOG = "NVSOLDETRANSACLISTDIALOG";
    public static final String ANCSOLDETRANSACLISTDIALOG = "ANCSOLDETRANSACLISTDIALOG";

    public static final String IDTRANSAC = "IDTRANSAC";
    public static final String UNIQUEIDTRANSACLIST = "UNIQUEIDTRANSACLIST";


    public static List<String> valeursTransacList  = new ArrayList<>();
    public static List<String> titresTransacList  = new ArrayList<>();
    public static List<String> datesHeuresTransacList  = new ArrayList<>();
    public static List<Drawable> imgTransacList  = new ArrayList<>();

    //Pour l'affichage dans la dialog de Transac

    public static List<String> detailsTransacListDialog  = new ArrayList<>();
    public static List<String> nvSoldeTransacListDialog  = new ArrayList<>();
    public static List<String> ancSoldeTransacListDialog  = new ArrayList<>();

    public static List<String> uniqueidTransacList  = new ArrayList<>();

    public static int idt = 0;

    public static Boolean isRefreshed = false;  //Permet de vérifier si les images du recycler sont à jour


    FloatingActionMenu floatingActionMenuMain;
    FloatingActionButton addMoneyFab, viewDetailsFab, rmMoneyFab;
    TextView textTotal;



    int[] couleurs = {Color.parseColor("#D98880"), Color.parseColor("#C39BD3"), Color.parseColor("#7FB3D5"), Color.parseColor("#76D7C4"), Color.parseColor("#7DCEA0"), Color.parseColor("#F7DC6F"), Color.parseColor("#F0B27A"), Color.parseColor("#99FFFF"), Color.parseColor("#CC99FF"), Color.parseColor("#F1948A"), Color.parseColor("#9999FF"), Color.parseColor("#85C1E9"), Color.parseColor("#FF99FF"), Color.parseColor("#82E0AA"), Color.parseColor("#F8C471") };

    public static int inBillets5;
    public static int inBillets10;
    public static int inBillets20;
    public static int inBillets50;
    public static int inBillets100;
    public static int inBillets200;
    public static int inBillets500;
    public static int nbBilletsIn;

    public static int inPieces001;
    public static int inPieces002;
    public static int inPieces005;
    public static int inPieces10;
    public static int inPieces20;
    public static int inPieces50;
    public static int inPieces1;
    public static int inPieces2;
    public static int nbPiecesIn;

    public static float total = 0.0f;
    public static boolean isSaved = false;  //Permet de vérifier si des données sont à charger dans l'applications depuis les SharedPrefs
    String textTotalContent;


    PieChart graphicMain;
    ArrayList<PieEntry> yValues = new ArrayList<>();


    public static int getInBillets5() { return inBillets5; }

    public static void setInBillets5(int nbBillets5) {
        inBillets5 += nbBillets5;
    }

    public static int getInBillets10() {
        return inBillets10;
    }

    public static void setInBillets10(int nbBillets10) {
        inBillets10 += nbBillets10;
    }

    public static int getInBillets20() {
        return inBillets20;
    }

    public static void setInBillets20(int nbBillets20) {
        inBillets20 += nbBillets20;
    }

    public static int getInBillets50() {
        return inBillets50;
    }

    public static void setInBillets50(int nbBillets50) {
        inBillets50 += nbBillets50;
    }

    public static int getInBillets100() {
        return inBillets100;
    }

    public static void setInBillets100(int nbBillets100) {
        inBillets100 += nbBillets100;
    }

    public static int getInBillets200() {
        return inBillets200;
    }

    public static void setInBillets200(int nbBillets200) {
        inBillets200 += nbBillets200;
    }

    public static int getInBillets500() {
        return inBillets500;
    }

    public static void setInBillets500(int nbBillets500) {
        inBillets500 += nbBillets500;
    }

    public static float getTotal() {
        return total;
    }

    public static void setTotal(float nbTotal) {
        total += nbTotal;
    }

    public static void setTotal(int nbTotal) {
        total += nbTotal;
    }

// Méthodes pièces


    public static int getInPieces001() { return inPieces001; }

    public static void setInPieces001(int nbPieces001) {
        inPieces001 += nbPieces001;
    }

    public static int getInPieces002() { return inPieces002; }

    public static void setInPieces002(int nbPieces002) {
        inPieces002 += nbPieces002;
    }

    public static int getInPieces005() { return inPieces005; }

    public static void setInPieces005(int nbPieces005) {
        inPieces005 += nbPieces005;
    }

    public static int getInPieces10() { return inPieces10; }

    public static void setInPieces10(int nbPieces10) {
        inPieces10 += nbPieces10;
    }

    public static int getInPieces20() { return inPieces20; }

    public static void setInPieces20(int nbPieces20) { inPieces20 += nbPieces20; }

    public static int getInPieces50() { return inPieces50; }

    public static void setInPieces50(int nbPieces50) { inPieces50 += nbPieces50; }

    public static int getInPieces1() { return inPieces1; }

    public static void setInPieces1(int nbPieces1) {
        inPieces1 += nbPieces1;
    }

    public static int getInPieces2() { return inPieces2; }

    public static void setInPieces2(int nbPieces2) { inPieces2 += nbPieces2; }


    @Override
    protected void onRestart() {
        super.onRestart();
        textTotalContent = ("Total : " + String.format("%.2f", total) + " €");
        textTotal.setText(textTotalContent);
        nbBilletsIn = inBillets5 + inBillets10 + inBillets20 + inBillets50 + inBillets100 + inBillets200 + inBillets500;
        nbPiecesIn = inPieces001 + inPieces002 + inPieces005 + inPieces10 + inPieces20 + inPieces50 + inPieces1 + inPieces2;
        if(!isRefreshed) {
            refreshTransacImg();
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        textTotalContent = ("Total : " + String.format("%.2f", total) + " €");
        textTotal.setText(textTotalContent);
        nbBilletsIn = inBillets5 + inBillets10 + inBillets20 + inBillets50 + inBillets100 + inBillets200 + inBillets500;
        nbPiecesIn = inPieces001 + inPieces002 + inPieces005 + inPieces10 + inPieces20 + inPieces50 + inPieces1 + inPieces2;
        if(!isRefreshed) {
            refreshTransacImg();
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("DONNEES", MODE_PRIVATE);

        if(!isSaved && sharedPreferences.contains(SOLDE))      //Si les données n'ont pas été restaurées et si elles existent
        {
            total = sharedPreferences.getFloat(SOLDE,0.0f);

            if (sharedPreferences.contains(NBBILLETS5)) inBillets5 = sharedPreferences.getInt(NBBILLETS5,inBillets5);

            if (sharedPreferences.contains(NBBILLETS10)) inBillets10 = sharedPreferences.getInt(NBBILLETS10,inBillets10);

            if (sharedPreferences.contains(NBBILLETS20)) inBillets20 = sharedPreferences.getInt(NBBILLETS20,inBillets20);

            if (sharedPreferences.contains(NBBILLETS50)) inBillets50 = sharedPreferences.getInt(NBBILLETS50,inBillets50);

            if (sharedPreferences.contains(NBBILLETS100)) inBillets100 = sharedPreferences.getInt(NBBILLETS100,inBillets100);

            if (sharedPreferences.contains(NBBILLETS200)) inBillets200 = sharedPreferences.getInt(NBBILLETS200,inBillets200);

            if (sharedPreferences.contains(NBBILLETS500)) inBillets500 = sharedPreferences.getInt(NBBILLETS500,inBillets500);

            if (sharedPreferences.contains(NBPIECES001)) inPieces001 = sharedPreferences.getInt(NBPIECES001,inPieces001);

            if (sharedPreferences.contains(NBPIECES002)) inPieces002 = sharedPreferences.getInt(NBPIECES002,inPieces002);

            if (sharedPreferences.contains(NBPIECES005)) inPieces005 = sharedPreferences.getInt(NBPIECES005,inPieces005);

            if (sharedPreferences.contains(NBPIECES10)) inPieces10 = sharedPreferences.getInt(NBPIECES10,inPieces10);

            if (sharedPreferences.contains(NBPIECES20)) inPieces20 = sharedPreferences.getInt(NBPIECES20,inPieces20);

            if (sharedPreferences.contains(NBPIECES50)) inPieces50 = sharedPreferences.getInt(NBPIECES50,inPieces50);

            if (sharedPreferences.contains(NBPIECES1)) inPieces1 = sharedPreferences.getInt(NBPIECES1,inPieces1);

            if (sharedPreferences.contains(NBPIECES2)) inPieces2 = sharedPreferences.getInt(NBPIECES2,inPieces2);

            if (sharedPreferences.contains(IDTRANSAC)) idt = sharedPreferences.getInt(IDTRANSAC, idt);

            if (sharedPreferences.contains(VALEURSTRANSACLIST)) {

                    loadListData(sharedPreferences);
                    refreshTransacImg();

            }
            nbBilletsIn = inBillets5 + inBillets10 + inBillets20 + inBillets50 + inBillets100 + inBillets200 + inBillets500;

            nbPiecesIn = inPieces001 + inPieces002 + inPieces005 + inPieces10 + inPieces20 + inPieces50 + inPieces1 + inPieces2;

            isSaved = true;
        }

        textTotal = findViewById(R.id.sous_titre);
        floatingActionMenuMain = findViewById(R.id.fabMenu);
        addMoneyFab = findViewById(R.id.fabMenu_item_AddMoney);
        viewDetailsFab = findViewById(R.id.fabMenu_item_ViewDetails);
        rmMoneyFab = findViewById(R.id.fabMenu_item_RmMoney);





        ColorTemplate.createColors(couleurs);


        graphicMain = findViewById(R.id.graphic_main);
        graphicMain.setUsePercentValues(false);
        graphicMain.getDescription().setEnabled(false);
        graphicMain.setExtraOffsets(5, 10, 5, 5);
        graphicMain.setDragDecelerationFrictionCoef(0.99f );
        graphicMain.setHoleRadius(50);
        graphicMain.setHoleColor(Color.WHITE);
        graphicMain.setTransparentCircleRadius(58f);

        yValues.clear();


        if(nbBilletsIn!=0) {

            if(inBillets5 > 0) yValues.add(new PieEntry(inBillets5, "5€"));
            if(inBillets10 > 0) yValues.add(new PieEntry(inBillets10, "10€"));
            if(inBillets20 > 0) yValues.add(new PieEntry(inBillets20, "20€"));
            if(inBillets50 > 0) yValues.add(new PieEntry(inBillets50, "50€"));
            if(inBillets100 > 0) yValues.add(new PieEntry(inBillets100, "100€"));
            if(inBillets200 > 0) yValues.add(new PieEntry(inBillets200, "200€"));
            if(inBillets500 > 0) yValues.add(new PieEntry(inBillets500, "500€"));

        }
        if (nbPiecesIn!=0) {

            if(inPieces001 > 0) yValues.add(new PieEntry(inPieces001, "0,01€"));
            if(inPieces002 > 0) yValues.add(new PieEntry(inPieces002, "0,02€"));
            if(inPieces005 > 0) yValues.add(new PieEntry(inPieces005, "0,05€"));
            if(inPieces10 > 0) yValues.add(new PieEntry(inPieces10, "0,10€"));
            if(inPieces20 > 0) yValues.add(new PieEntry(inPieces20, "0,20€"));
            if(inPieces50 > 0) yValues.add(new PieEntry(inPieces50, "0,50€"));
            if(inPieces1 > 0) yValues.add(new PieEntry(inPieces1, "1€"));
            if(inPieces2 > 0) yValues.add(new PieEntry(inPieces2, "2€"));
        }

        graphicMain.animateY(1000, Easing.EasingOption.EaseInOutCubic);

        Legend legend = graphicMain.getLegend();
        legend.setEnabled(false);


        PieDataSet dataSet = new PieDataSet(yValues, "");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);
        dataSet.setColors(couleurs);

        PieData data = new PieData(dataSet);
        data.setValueFormatter(new MyValueFormatter());
        data.setValueTextSize(10f);
        data.setValueTextColor(Color.YELLOW);

        graphicMain.setData(data);




        textTotalContent = ("Total : " + String.format("%.2f", total) + " €");
        textTotal.setText(textTotalContent);

        addMoneyFab.setLabelColors(ContextCompat.getColor(this, R.color.white),
                ContextCompat.getColor(this, R.color.pressed),
                ContextCompat.getColor(this, R.color.white_transparent));

        viewDetailsFab.setLabelColors(ContextCompat.getColor(this, R.color.white),
                ContextCompat.getColor(this, R.color.pressed),
                ContextCompat.getColor(this, R.color.white_transparent));

        rmMoneyFab.setLabelColors(ContextCompat.getColor(this, R.color.white),
                ContextCompat.getColor(this, R.color.pressed),
                ContextCompat.getColor(this, R.color.white_transparent));


        addMoneyFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {           //Ajouter de l'argent
                startActivity(new Intent(MainActivity.this, ChoiceMoneyAddActivity.class));
            }
        });



        viewDetailsFab.setOnClickListener(new View.OnClickListener() {              //Bouton afficher les détails
            @Override
            public void onClick(View v) {               //Afficher les détails
                startActivity(new Intent(MainActivity.this, Details.class));
            }

            });

        rmMoneyFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                                                                //Vider la tirelire
                startActivity(new Intent(MainActivity.this, RemoveMoney.class));
            }
            });
    }


    public void loadListData(SharedPreferences sharedPref)
    {
        Gson gson = new Gson();
        String json = sharedPref.getString(VALEURSTRANSACLIST, null);
        Type type = new TypeToken<ArrayList<String>>(){ }.getType();
        valeursTransacList = gson.fromJson(json, type);

        Gson gson2 = new Gson();
        String json2 = sharedPref.getString(TITRESTRANSACLIST, null);
        Type type2 = new TypeToken<ArrayList<String>>(){ }.getType();
        titresTransacList = gson2.fromJson(json2, type2);

        Gson gson3 = new Gson();
        String json3 = sharedPref.getString(DATESHEURESLIST, null);
        Type type3 = new TypeToken<ArrayList<String>>(){ }.getType();
        datesHeuresTransacList = gson3.fromJson(json3, type3);

        Gson gson4 = new Gson();
        String json4 = sharedPref.getString(DETAILSTRANSACLISTDIALOG, null);
        Type type4 = new TypeToken<ArrayList<String>>(){ }.getType();
        detailsTransacListDialog = gson4.fromJson(json4, type4);

        Gson gson5 = new Gson();
        String json5 = sharedPref.getString(NVSOLDETRANSACLISTDIALOG, null);
        Type type5 = new TypeToken<ArrayList<String>>(){ }.getType();
        nvSoldeTransacListDialog = gson5.fromJson(json5, type5);

        Gson gson6 = new Gson();
        String json6 = sharedPref.getString(ANCSOLDETRANSACLISTDIALOG, null);
        Type type6 = new TypeToken<ArrayList<String>>(){ }.getType();
        ancSoldeTransacListDialog = gson6.fromJson(json6, type6);

        Gson gson7 = new Gson();
        String json7 = sharedPref.getString(UNIQUEIDTRANSACLIST, null);
        Type type7 = new TypeToken<ArrayList<String>>(){ }.getType();
        uniqueidTransacList = gson7.fromJson(json7, type7);

    }

    public void refreshTransacImg()
    {
        imgTransacList.clear();

        if(valeursTransacList != null)
        {
            for (int i = 0; i < valeursTransacList.size(); i++)
            {
                if (titresTransacList.get(i).equals("Ajout d'argent")) {        //Permet d'attribuer une image aux items du recyclerview de TransacActivity
                    imgTransacList.add(getDrawable(R.drawable.ic_add_money_transac));
                } else
                {
                    imgTransacList.add(getDrawable(R.drawable.ic_remove_money_transac));
                }
            }
            isRefreshed = true;
        }
    }

}
