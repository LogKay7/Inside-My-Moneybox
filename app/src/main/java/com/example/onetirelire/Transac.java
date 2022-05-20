package com.example.onetirelire;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import it.xabaras.android.recyclerview.swipedecorator.RecyclerViewSwipeDecorator;

import static com.example.onetirelire.MainActivity.ANCSOLDETRANSACLISTDIALOG;
import static com.example.onetirelire.MainActivity.DATESHEURESLIST;
import static com.example.onetirelire.MainActivity.DETAILSTRANSACLISTDIALOG;
import static com.example.onetirelire.MainActivity.NVSOLDETRANSACLISTDIALOG;
import static com.example.onetirelire.MainActivity.TITRESTRANSACLIST;
import static com.example.onetirelire.MainActivity.UNIQUEIDTRANSACLIST;
import static com.example.onetirelire.MainActivity.VALEURSTRANSACLIST;
import static com.example.onetirelire.MainActivity.ancSoldeTransacListDialog;
import static com.example.onetirelire.MainActivity.datesHeuresTransacList;
import static com.example.onetirelire.MainActivity.detailsTransacListDialog;
import static com.example.onetirelire.MainActivity.imgTransacList;
import static com.example.onetirelire.MainActivity.inBillets10;
import static com.example.onetirelire.MainActivity.inBillets100;
import static com.example.onetirelire.MainActivity.inBillets20;
import static com.example.onetirelire.MainActivity.inBillets200;
import static com.example.onetirelire.MainActivity.inBillets5;
import static com.example.onetirelire.MainActivity.inBillets50;
import static com.example.onetirelire.MainActivity.inBillets500;
import static com.example.onetirelire.MainActivity.inPieces001;
import static com.example.onetirelire.MainActivity.inPieces002;
import static com.example.onetirelire.MainActivity.inPieces005;
import static com.example.onetirelire.MainActivity.inPieces1;
import static com.example.onetirelire.MainActivity.inPieces10;
import static com.example.onetirelire.MainActivity.inPieces2;
import static com.example.onetirelire.MainActivity.inPieces20;
import static com.example.onetirelire.MainActivity.inPieces50;
import static com.example.onetirelire.MainActivity.isRefreshed;
import static com.example.onetirelire.MainActivity.nbBilletsIn;
import static com.example.onetirelire.MainActivity.nbPiecesIn;
import static com.example.onetirelire.MainActivity.nvSoldeTransacListDialog;
import static com.example.onetirelire.MainActivity.titresTransacList;
import static com.example.onetirelire.MainActivity.total;
import static com.example.onetirelire.MainActivity.uniqueidTransacList;
import static com.example.onetirelire.MainActivity.valeursTransacList;

public class Transac extends AppCompatActivity {

    FloatingActionMenu floatingActionMenuTransac;
    FloatingActionButton rmAllTransacFab, rmAllDataFab, rmRetourAccueil;

    SharedPreferences sharedPreferences;

    TextView textVSolde;
    TextView textVContenu;
    String textSolde;
    String textContenu = "";


    String valeurTransacRemoved = null;
    String titreTransacRemoved = null;
    String dateHeureTransacRemoved = null;
    Drawable imgTransacRemoved = null;
    String detailsTransacRemoved = null;
    String ancSoldeTransacRemoved = null;
    String nvSoldeTransacRemoved = null;
    String idTransacRemoved = null;


    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;

    @Override
    protected void onRestart() {
        super.onRestart();

    }

    @Override
    protected void onResume() {
        super.onResume();

    }



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transac);

        //Contenu de la CardView

        textVSolde = findViewById(R.id.textv_solde_transac);
        textVContenu = findViewById(R.id.textv_contenu_transac);

        floatingActionMenuTransac = findViewById(R.id.fabMenu3);
        rmAllTransacFab = findViewById(R.id.fabMenu_item_supprime_tout_transac);
        rmAllDataFab = findViewById(R.id.fabMenu_item_reinitialisation);
        rmRetourAccueil = findViewById(R.id.fabMenu_item_retour_accueil);

        rmAllTransacFab.setLabelColors(ContextCompat.getColor(this, R.color.white),
                ContextCompat.getColor(this, R.color.pressed),
                ContextCompat.getColor(this, R.color.white_transparent));

        rmAllDataFab.setLabelColors(ContextCompat.getColor(this, R.color.white),
                ContextCompat.getColor(this, R.color.pressed),
                ContextCompat.getColor(this, R.color.white_transparent));

        rmRetourAccueil.setLabelColors(ContextCompat.getColor(this, R.color.white),
                ContextCompat.getColor(this, R.color.pressed),
                ContextCompat.getColor(this, R.color.white_transparent));


        rmAllTransacFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {           //Supprimer toutes les transactions

                if(valeursTransacList.size()>0) {
                    new AlertDialog.Builder(Transac.this)
                            .setTitle("Supprimer les transactions")
                            .setMessage("Etes-vous sûr de vouloir supprimer toutes les transactions ?")

                            // Specifying a listener allows you to take an action before dismissing the dialog.
                            // The dialog is automatically dismissed when a dialog button is clicked.
                            .setPositiveButton("Supprimer", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    // Continue with delete operation

                                    valeursTransacList.clear();
                                    titresTransacList.clear();
                                    datesHeuresTransacList.clear();
                                    imgTransacList.clear();
                                    detailsTransacListDialog.clear();
                                    ancSoldeTransacListDialog.clear();
                                    nvSoldeTransacListDialog.clear();
                                    uniqueidTransacList.clear();


                                    recyclerAdapter.notifyDataSetChanged();
                                    saveListData(sharedPreferences);
                                }
                            })

                            // A null listener allows the button to dismiss the dialog and take no further action.
                            .setNegativeButton("Annuler", null)
                            .setIcon(android.R.drawable.ic_delete)
                            .show();
                } else
                {
                    Toast.makeText(Transac.this,"Aucune transaction à supprimer",Toast.LENGTH_SHORT).show();

                }
            }
        });



        rmAllDataFab.setOnClickListener(new View.OnClickListener() {    //Suppression de toutes les données
            @Override
            public void onClick(View v) {
                if(valeursTransacList.size()>0 || uniqueidTransacList.size()>0 || nbPiecesIn!=0 || nbBilletsIn!=0 ) {
                    new AlertDialog.Builder(Transac.this)
                            .setTitle("Réinitialisation des données")
                            .setMessage("Etes-vous sûr de vouloir supprimer toutes les données ?")

                            // Specifying a listener allows you to take an action before dismissing the dialog.
                            // The dialog is automatically dismissed when a dialog button is clicked.
                            .setPositiveButton("Réinitialiser", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    // Continue with delete operation

                                    inBillets5 = 0;
                                    inBillets10 = 0;
                                    inBillets20 = 0;
                                    inBillets50 = 0;
                                    inBillets100 = 0;
                                    inBillets200 = 0;
                                    inBillets500 = 0;
                                    nbBilletsIn = 0;
                                    inPieces001 = 0;
                                    inPieces002 = 0;
                                    inPieces005 = 0;
                                    inPieces10 = 0;
                                    inPieces20 = 0;
                                    inPieces50 = 0;
                                    inPieces1 = 0;
                                    inPieces2 = 0;
                                    nbPiecesIn = 0;
                                    total = 0.0f;

                                    valeursTransacList.clear();
                                    titresTransacList.clear();
                                    datesHeuresTransacList.clear();
                                    imgTransacList.clear();
                                    detailsTransacListDialog.clear();
                                    ancSoldeTransacListDialog.clear();
                                    nvSoldeTransacListDialog.clear();
                                    uniqueidTransacList.clear();
                                    recyclerAdapter.notifyDataSetChanged();

                                    saveListData(sharedPreferences);
                                    startActivity(new Intent(Transac.this, MainActivity.class));
                                }


                            })

                            // A null listener allows the button to dismiss the dialog and take no further action.
                            .setNegativeButton("Annuler", null)
                            .setIcon(android.R.drawable.ic_delete)
                            .show();
                } else
                {
                    Toast.makeText(Transac.this,"Aucune données à supprimer",Toast.LENGTH_SHORT).show();
                }
            }

        });

        rmRetourAccueil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        textSolde = String.format("%.2f", total)+" €";
        textVSolde.setText(textSolde);

        if (total == 0.0f) //Si la tirelire est vide
        {
            textContenu = ("La tirelire est vide");
        } else {
            if (nbBilletsIn != 1 && nbPiecesIn != 1) {
                textContenu = ("La tirelire contient " + nbPiecesIn + " pièces et " + nbBilletsIn + " billets");

            } else if (nbBilletsIn == 1 && nbPiecesIn == 1) {

                textContenu = ("La tirelire contient 1 pièce et 1 billet");

            } else if (nbBilletsIn == 1) {

                textContenu = ("La tirelire contient " + nbPiecesIn + " pièces et 1 billet");

            } else {

                textContenu = ("La tirelire contient 1 pièce et " + nbBilletsIn + " billets");
            }
        }

        textVContenu.setText(textContenu);

        recyclerView = findViewById(R.id.recyclerViewTransac);

        recyclerAdapter = new RecyclerAdapter(valeursTransacList, this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(recyclerAdapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);

        recyclerView.addItemDecoration(dividerItemDecoration);




        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView( recyclerView);
    }








    ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

            final int position = viewHolder.getAdapterPosition();


                        valeurTransacRemoved = valeursTransacList.get(position);
                        titreTransacRemoved = titresTransacList.get(position);
                        dateHeureTransacRemoved = datesHeuresTransacList.get(position);
                        imgTransacRemoved = imgTransacList.get(position);
                        detailsTransacRemoved = detailsTransacListDialog.get(position);
                        ancSoldeTransacRemoved = ancSoldeTransacListDialog.get(position);
                        nvSoldeTransacRemoved = nvSoldeTransacListDialog.get(position);
                        idTransacRemoved = uniqueidTransacList.get(position);


                        valeursTransacList.remove(position);
                        titresTransacList.remove(position);
                        datesHeuresTransacList.remove(position);
                        imgTransacList.remove(position);
                        detailsTransacListDialog.remove(position);
                        ancSoldeTransacListDialog.remove(position);
                        nvSoldeTransacListDialog.remove(position);
                        uniqueidTransacList.remove(position);


            isRefreshed = false;

                        recyclerAdapter.notifyItemRemoved(position);
                        recyclerAdapter.notifyItemRangeChanged(position, recyclerAdapter.getItemCount());
                        saveListData(sharedPreferences);

                        Snackbar.make(recyclerView,"Opération effacée", Snackbar.LENGTH_LONG)
                                .setAction("Annuler", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) { //Annuler

                                        valeursTransacList.add(position, valeurTransacRemoved);
                                        titresTransacList.add(position, titreTransacRemoved);
                                        datesHeuresTransacList.add(position, dateHeureTransacRemoved);
                                        imgTransacList.add(position, imgTransacRemoved);
                                        detailsTransacListDialog.add(position,detailsTransacRemoved);
                                        ancSoldeTransacListDialog.add(position,ancSoldeTransacRemoved);
                                        nvSoldeTransacListDialog.add(position,nvSoldeTransacRemoved);
                                        uniqueidTransacList.add(position,idTransacRemoved);

                                        recyclerAdapter.notifyItemInserted(position);
                                        recyclerAdapter.notifyItemRangeChanged(position, recyclerAdapter.getItemCount());
                                    }
                                }).show();

        }

        public void onChildDraw (Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder,float dX, float dY,int actionState, boolean isCurrentlyActive){

            new RecyclerViewSwipeDecorator.Builder(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
                    .addSwipeLeftBackgroundColor(ContextCompat.getColor(Transac.this, R.color.red))
                    .addSwipeLeftActionIcon(R.drawable.ic_delete_forever)
                    .create()
                    .decorate();

            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        }

    };



    public void saveListData(SharedPreferences sharedPref)
    {
        sharedPref = getSharedPreferences("DONNEES", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        Gson gson = new Gson();
        String json = gson.toJson(valeursTransacList);
        editor.putString(VALEURSTRANSACLIST, json);
        editor.apply();

        Gson gson2 = new Gson();
        String json2 = gson2.toJson(titresTransacList);
        editor.putString(TITRESTRANSACLIST, json2);
        editor.apply();

        Gson gson3 = new Gson();
        String json3 = gson3.toJson(datesHeuresTransacList);
        editor.putString(DATESHEURESLIST, json3);
        editor.apply();

        Gson gson4 = new Gson();
        String json4 = gson4.toJson(detailsTransacListDialog);
        editor.putString(DETAILSTRANSACLISTDIALOG, json4);
        editor.apply();

        Gson gson5 = new Gson();
        String json5 = gson5.toJson(ancSoldeTransacListDialog);
        editor.putString(ANCSOLDETRANSACLISTDIALOG, json5);
        editor.apply();

        Gson gson6 = new Gson();
        String json6 = gson6.toJson(nvSoldeTransacListDialog);
        editor.putString(NVSOLDETRANSACLISTDIALOG, json6);
        editor.apply();

        Gson gson7 = new Gson();
        String json7 = gson7.toJson(uniqueidTransacList);
        editor.putString(UNIQUEIDTRANSACLIST, json7);
        editor.apply();
    }


}
