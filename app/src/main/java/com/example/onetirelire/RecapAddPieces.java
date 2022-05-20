package com.example.onetirelire;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import static com.example.onetirelire.MainActivity.*;

public class RecapAddPieces extends AppCompatActivity {

    SharedPreferences sharedPreferences2;

    private int nbPieces001;
    private float valeur001;
    private int nbPieces002;
    private float valeur002;
    private int nbPieces005;
    private float valeur005;
    private int nbPieces10;
    private float valeur10;
    private int nbPieces20;
    private float valeur20;
    private int nbPieces50;
    private float valeur50;
    private int nbPieces1;
    private float valeur1;
    private int nbPieces2;
    private float valeur2;
    private float ancTotal;
    private float totalAdd;
    private float nvTotal;


    boolean _ajt = false;
    boolean _suppr = false;
    String textTotalAjt;
    String textTotalSuppr;
    String textTotal;
    TextView textViewRecapAjtPieces;
    Button btnConfirmationAddPieces;

    String textDateHeure = "";

    String textDetailsDialog;
    String textAjoutDetailsDialog;
    String textRetraitDetailsDialog;

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();
        nbPieces001 = intent.getIntExtra("nbPieces001",0);
        nbPieces002 = intent.getIntExtra("nbPieces002",0);
        nbPieces005 = intent.getIntExtra("nbPieces005",0);
        nbPieces10 = intent.getIntExtra("nbPieces10",0);
        nbPieces20 = intent.getIntExtra("nbPieces20",0);
        nbPieces50 = intent.getIntExtra("nbPieces50",0);
        nbPieces1 = intent.getIntExtra("nbPieces1",0);
        nbPieces2 = intent.getIntExtra("nbPieces2",0);
        textTotalAjt = " ";
        textTotalSuppr = " ";
        textTotal = " ";

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Intent intent = getIntent();
        nbPieces001 = intent.getIntExtra("nbPieces001",0);
        nbPieces002 = intent.getIntExtra("nbPieces002",0);
        nbPieces005 = intent.getIntExtra("nbPieces005",0);
        nbPieces10 = intent.getIntExtra("nbPieces10",0);
        nbPieces20 = intent.getIntExtra("nbPieces20",0);
        nbPieces50 = intent.getIntExtra("nbPieces50",0);
        nbPieces1 = intent.getIntExtra("nbPieces1",0);
        nbPieces2 = intent.getIntExtra("nbPieces2",0);
        textTotalAjt = " ";
        textTotalSuppr = " ";
        textTotal = " ";
        textDetailsDialog = " ";
        textAjoutDetailsDialog = " ";
        textRetraitDetailsDialog = " ";

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recap_add_pieces);

        sharedPreferences2 = getSharedPreferences("DONNEES", MODE_PRIVATE);

        textViewRecapAjtPieces  = findViewById(R.id.textvAjout);
        btnConfirmationAddPieces = findViewById(R.id.btn_confirmation_add_pieces);


        Intent intent = getIntent();
        nbPieces001 = intent.getIntExtra("nbPieces001",0);
        nbPieces002 = intent.getIntExtra("nbPieces002",0);
        nbPieces005 = intent.getIntExtra("nbPieces005",0);
        nbPieces10 = intent.getIntExtra("nbPieces10",0);
        nbPieces20 = intent.getIntExtra("nbPieces20",0);
        nbPieces50 = intent.getIntExtra("nbPieces50",0);
        nbPieces1 = intent.getIntExtra("nbPieces1",0);
        nbPieces2 = intent.getIntExtra("nbPieces2",0);

        textTotalAjt = " ";
        textTotalSuppr = " ";
        textTotal = " ";
        totalAdd = 0.f;

        textDetailsDialog = " ";
        textAjoutDetailsDialog = " ";
        textRetraitDetailsDialog = " ";


        if(nbPieces001 == 0) {

        } else if(nbPieces001 > 0) {
            if(nbPieces001 == 1) {
                valeur001 = 0.01f;
                textTotalAjt += ("1 pièce de 0,01 €  ->  + 0,01 € \n\n");
                _ajt = true;
                totalAdd += 0.01;
                textAjoutDetailsDialog += ("1 pièce de 0,01 € \n");

            } else {
                valeur001 = nbPieces001 /100f;
                textTotalAjt += (nbPieces001 + " pièces de 0,01 €  ->  + " + String.format("%.2f", valeur001) +" € \n\n");
                _ajt = true;
                totalAdd += valeur001;
                textAjoutDetailsDialog += (nbPieces001 + " pièces de 0,01 € \n");

            }
        } else {
            if(nbPieces001 == -1) {
                valeur001 = 0.01f;
                textTotalSuppr += ("1 pièce de 0,01 €  ->  - 0,01 € \n\n");
                _suppr = true;
                totalAdd -= 0.01f;
                textRetraitDetailsDialog += ("1 pièce de 0,01 € \n");

            } else {
                valeur001 = nbPieces001 / -100f;
                textTotalSuppr += (Math.abs(nbPieces001) + " pièces de 0,01 €  ->  - " + String.format("%.2f", valeur001) + " € \n\n");
                _suppr = true;
                totalAdd -= valeur001;
                textRetraitDetailsDialog += (Math.abs(nbPieces001) + " pièces de 0,01 € \n");

            }
        }

        if(nbPieces002 == 0) {

            //Aucun billet

        } else if(nbPieces002 > 0) {
            if(nbPieces002 == 1) {
                valeur002 = 0.02f;
                textTotalAjt += ("1 pièce de 0,02 €  ->  + 0,02 € \n\n");
                _ajt = true;
                totalAdd += 0.02f;
                textAjoutDetailsDialog += ("1 pièce de 0,02 € \n");

            } else {
                valeur002 = nbPieces002 /50f;
                textTotalAjt += (nbPieces002 + " pièces de 0,02 €  ->  + " + String.format("%.2f", valeur002) + " € \n\n");
                _ajt = true;
                totalAdd += valeur002;
                textAjoutDetailsDialog += (nbPieces002 + " pièces de 0,02 € \n");

            }

        } else {
            if(nbPieces002 == -1) {
                valeur002 = 0.02f;
                textTotalSuppr += ("1 pièce de 0,02 €  ->  - 0,02 € \n\n");
                _suppr = true;
                totalAdd -= 0.02f;
                textRetraitDetailsDialog += ("1 pièce de 0,02 € \n");


            } else {
                valeur002 = nbPieces002 / -50f;
                textTotalSuppr += (Math.abs(nbPieces002) + " pièces de 0,02 €  ->  - " + String.format("%.2f", valeur002) + " € \n\n");
                _suppr = true;
                totalAdd -= valeur002;
                textRetraitDetailsDialog += (Math.abs(nbPieces002) + " pièces de 0,02 € \n");

            }

        }

        if(nbPieces005 == 0) {

            //Aucun billet

        } else if(nbPieces005 > 0) {
            if(nbPieces005 == 1) {
                valeur005 = 0.05f;
                textTotalAjt += ("1 pièce de 0,05 €  ->  + 0,05 € \n\n");
                _ajt = true;
                totalAdd += 0.05f;
                textAjoutDetailsDialog += ("1 pièce de 0,05 € \n");

            } else {
                valeur005 = nbPieces005 /20f;
                textTotalAjt += (nbPieces005 + " pièces de 0,05 €  ->  + " + String.format("%.2f", valeur005) + " € \n\n");
                _ajt = true;
                totalAdd += valeur005;
                textAjoutDetailsDialog += (nbPieces005 + " pièces de 0,05 € \n");

            }

        } else {
            if(nbPieces005 == -1) {
                valeur005 = 0.05f;
                textTotalSuppr += ("1 pièce de 0,05 €  ->  - 0,05 € \n\n");
                _suppr = true;
                totalAdd -= 0.05f;
                textRetraitDetailsDialog += ("1 pièce de 0,05 € \n");

            } else {
                valeur005 = nbPieces005 / -20f;
                textTotalSuppr += (Math.abs(nbPieces005) + " pièces de 0,05 €  ->  - " + String.format("%.2f", valeur005) + " € \n\n");
                _suppr = true;
                totalAdd -= valeur005;
                textRetraitDetailsDialog += (Math.abs(nbPieces005) + " pièces de 0,05 € \n");

            }
        }

        if(nbPieces10 == 0) {

        } else if(nbPieces10 > 0) {
            if(nbPieces10 == 1) {
                valeur10 = 0.10f;
                textTotalAjt += ("1 pièce de 0,10 €  ->  + 0,10 € \n\n");
                _ajt = true;
                totalAdd += 0.10f;
                textAjoutDetailsDialog += ("1 pièce de 0,10 € \n");


            } else {
                valeur10 = nbPieces10 / 10f;
                textTotalAjt += (nbPieces10 + " pièces de 0,10 €  ->  + " + String.format("%.2f", valeur10) +" € \n\n");
                _ajt = true;
                totalAdd += valeur10;
                textAjoutDetailsDialog += (nbPieces10 + " pièces de 0,10 € \n");

            }
        } else {
            if(nbPieces10 == -1) {
                valeur10 = 0.10f;
                textTotalSuppr += ("1 pièce de 0,10 €  ->  - 0,10 € \n\n");
                _suppr = true;
                totalAdd -= 0.10f;
                textRetraitDetailsDialog += ("1 pièce de 0,10 € \n");

            } else {
                valeur10 = nbPieces10 / -10f;
                textTotalSuppr += (Math.abs(nbPieces10) + " pièces de 0,10 €  ->  - " + String.format("%.2f", valeur10) + " € \n\n");
                _suppr = true;
                totalAdd -= valeur10;
                textRetraitDetailsDialog += (Math.abs(nbPieces10) + " pièces de 0,10 € \n");

            }
        }

        if(nbPieces20 == 0) {

            //Aucun billet

        } else if(nbPieces20 > 0) {
            if(nbPieces20 == 1) {
                valeur20 = 0.20f;
                textTotalAjt += ("1 pièce de 0,20 €  ->  + 0,20 € \n\n");
                _ajt = true;
                totalAdd += 0.20f;
                textAjoutDetailsDialog += ("1 pièce de 0,20 € \n");

            } else {
                valeur20 = nbPieces20 / 5f;
                textTotalAjt += (nbPieces20 + " pièces de 0,20 €  ->  + " + String.format("%.2f", valeur20) + " € \n\n");
                _ajt = true;
                totalAdd += valeur20;
                textAjoutDetailsDialog += (nbPieces20 + " pièces de 0,20 € \n");

            }

        } else {
            if(nbPieces20 == -1) {
                valeur20 = 0.20f;
                textTotalSuppr += ("1 pièce de 0,20 €  ->  - 0,20 € \n\n");
                _suppr = true;
                totalAdd -= 0.20f;
                textRetraitDetailsDialog += ("1 pièce de 0,20 € \n");

            } else {
                valeur20 = nbPieces20 / -5f;
                textTotalSuppr += (Math.abs(nbPieces20) + " pièces de 0,20 €  ->  - " + String.format("%.2f", valeur20) + " € \n\n");
                _suppr = true;
                totalAdd -= valeur20;
                textRetraitDetailsDialog += (Math.abs(nbPieces20) + " pièces de 0,20 € \n");

            }
        }

        if(nbPieces50 == 0) {

            //Aucun billet

        } else if(nbPieces50 > 0) {
            if(nbPieces50 == 1) {
                valeur50 = 0.50f;
                textTotalAjt += ("1 pièce de 0,50 €  ->  + 0,50 € \n\n");
                _ajt = true;
                totalAdd += 0.50f;
                textAjoutDetailsDialog += ("1 pièce de 0,50 € \n");

            } else {
                valeur50 = nbPieces50 /2f;
                textTotalAjt += (nbPieces50 + " pièces de 0,50 €  ->  + " + String.format("%.2f", valeur50) + " € \n\n");
                _ajt = true;
                totalAdd += valeur50;
                textAjoutDetailsDialog += (nbPieces50 + " pièces de 0,50 € \n");

            }

        } else {
            if(nbPieces50 == -1) {
                valeur50 = 0.50f;
                textTotalSuppr += ("1 pièce de 0,50 €  ->  - 0,50 € \n\n");
                _suppr = true;
                totalAdd -= 0.50f;
                textRetraitDetailsDialog += ("1 pièce de 0,50 € \n");

            } else {
                valeur50 = nbPieces50 / -2f;
                textTotalSuppr += (Math.abs(nbPieces50) + " pièces de 0,50 €  ->  - " +String.format("%.2f", valeur50) + " € \n\n");
                _suppr = true;
                totalAdd -= valeur50;
                textRetraitDetailsDialog += (Math.abs(nbPieces50) + " pièces de 0,50 € \n");

            }

        }

        if(nbPieces1 == 0) {

        } else if(nbPieces1 > 0) {
            if(nbPieces1 == 1) {
                valeur1 = 1;
                textTotalAjt += ("1 pièce de 1 €  ->  + 1,00 € \n\n");
                _ajt = true;
                totalAdd += 1;
                textAjoutDetailsDialog += ("1 pièce de 1 € \n");

            } else {
                valeur1 = nbPieces1;
                textTotalAjt += (nbPieces1 + " pièces de 1 €  ->  + " + String.format("%.2f", valeur1) +" € \n\n");
                _ajt = true;
                totalAdd += valeur1;
                textAjoutDetailsDialog += (nbPieces1 + " pièces de 1 € \n");

            }
        } else {
            if(nbPieces1 == -1) {
                valeur1 = 1;
                textTotalSuppr += ("1 pièce de 1 €  ->  - 1,00 € \n\n");
                _suppr = true;
                totalAdd -= 1;
                textRetraitDetailsDialog += ("1 pièce de 1 € \n");

            } else {
                valeur1 = nbPieces1 * -1;
                textTotalSuppr += (Math.abs(nbPieces1) + " pièces de 1 €  ->  - " + String.format("%.2f", valeur1) + " € \n\n");
                _suppr = true;
                totalAdd -= valeur1;
                textRetraitDetailsDialog += (Math.abs(nbPieces1) + " pièces de 1 € \n");

            }
        }

        if(nbPieces2 == 0) {

        } else if(nbPieces2 > 0) {
            if(nbPieces2 == 1) {
                valeur2 = 2;
                textTotalAjt += ("1 pièce de 2 €  ->  + 2,00 € \n\n");
                _ajt = true;
                totalAdd += 2;
                textAjoutDetailsDialog += ("1 pièce de 2 € \n");

            } else {
                valeur2 = nbPieces2 * 2;
                textTotalAjt += (nbPieces2 + " pièces de 2 €  ->  + " + String.format("%.2f", valeur2) +" € \n\n");
                _ajt = true;
                totalAdd += valeur2;
                textAjoutDetailsDialog += (nbPieces2 + " pièces de 2 € \n");

            }
        } else {
            if(nbPieces2 == -1) {
                valeur2 = 2;
                textTotalSuppr += ("1 pièce de 2 €  ->  - 2,00 € \n\n");
                _suppr = true;
                totalAdd -= 2;
                textRetraitDetailsDialog += ("1 pièce de 2 € \n");

            } else {
                valeur2 = nbPieces2 * -2;
                textTotalSuppr += (Math.abs(nbPieces2) + " pièces de 2 €  ->  - " + String.format("%.2f", valeur2) + " € \n\n");
                _suppr = true;
                totalAdd -= valeur2;
                textRetraitDetailsDialog += (Math.abs(nbPieces2) + " pièces de 2 € \n");

            }
        }

        if(_ajt) {
            textTotalAjt += "\n à ajouter dans la tirelire \n\n\n";
            textDetailsDialog = ("Ajout de\n"+ textAjoutDetailsDialog +"\n\n");

        }

        if(_suppr) {
            textTotalSuppr += "\n à retirer de la tirelire";
            textDetailsDialog += ("Retrait de\n"+ textRetraitDetailsDialog + "\n");
        }

        textTotal = textTotalAjt + textTotalSuppr;
        textViewRecapAjtPieces.setText(textTotal);


        btnConfirmationAddPieces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {       //ENREGISTREMENTS DES VALEURS

                MainActivity.setInPieces001(nbPieces001);
                MainActivity.setInPieces002(nbPieces002);
                MainActivity.setInPieces005(nbPieces005);
                MainActivity.setInPieces10(nbPieces10);
                MainActivity.setInPieces20(nbPieces20);
                MainActivity.setInPieces50(nbPieces50);
                MainActivity.setInPieces1(nbPieces1);
                MainActivity.setInPieces2(nbPieces2);

                nbPiecesIn = nbPieces001 + nbPieces002 + nbPieces005 + nbPieces10 + nbPieces20 + nbPieces50 + nbPieces1 + nbPieces2;

                ancTotal = MainActivity.getTotal();
                ancSoldeTransacListDialog.add("Solde précédent : + "+String.format("%.2f", ancTotal)+" €");
                MainActivity.setTotal(totalAdd);
                nvTotal = MainActivity.getTotal();
                nvSoldeTransacListDialog.add("Nouveau solde : + "+String.format("%.2f", nvTotal)+" €");

                idt ++;
                uniqueidTransacList.add(String.valueOf(idt));
                detailsTransacListDialog.add(textDetailsDialog);


                sharedPreferences2
                        .edit()
                        .putFloat(SOLDE, nvTotal)
                        .putInt(NBPIECES001, inPieces001)
                        .putInt(NBPIECES002, inPieces002)
                        .putInt(NBPIECES005, inPieces005)
                        .putInt(NBPIECES10, inPieces10)
                        .putInt(NBPIECES20, inPieces20)
                        .putInt(NBPIECES50, inPieces50)
                        .putInt(NBPIECES1, inPieces1)
                        .putInt(NBPIECES2, inPieces2)
                        .putInt(IDTRANSAC, idt)
                        .apply();

                if(totalAdd > 0.0f)
                {
                    titresTransacList.add("Ajout d'argent");
                    valeursTransacList.add("+ "+String.format("%.2f", totalAdd)+" €");
                } else
                {
                    titresTransacList.add("Retrait d'argent");
                    valeursTransacList.add(String.format("%.2f", totalAdd)+" €");
                }

                Date now = new Date();
                DateFormat dateformatter = DateFormat.getDateInstance(DateFormat.SHORT);
                String formattedDate = dateformatter.format(now);
                textDateHeure += formattedDate + "   ";

                DateFormat timeformatter = DateFormat.getTimeInstance(DateFormat.SHORT);
                String formattedTime = timeformatter.format(now);
                textDateHeure += formattedTime;

                datesHeuresTransacList.add(textDateHeure);

                saveListData(sharedPreferences2, titresTransacList, TITRESTRANSACLIST);
                saveListData(sharedPreferences2, valeursTransacList, VALEURSTRANSACLIST);
                saveListData(sharedPreferences2, datesHeuresTransacList, DATESHEURESLIST);
                saveListData(sharedPreferences2, detailsTransacListDialog, DETAILSTRANSACLISTDIALOG);
                saveListData(sharedPreferences2, nvSoldeTransacListDialog, NVSOLDETRANSACLISTDIALOG);
                saveListData(sharedPreferences2, ancSoldeTransacListDialog, ANCSOLDETRANSACLISTDIALOG);
                saveListData(sharedPreferences2, uniqueidTransacList, UNIQUEIDTRANSACLIST);

                isRefreshed = false;

                Intent intent2 = new Intent(RecapAddPieces.this, ConfirmAdd.class);
                intent2.putExtra("ancTotal", ancTotal);
                intent2.putExtra("totalAdd", totalAdd);
                intent2.putExtra("nvTotal", nvTotal);
                startActivity(intent2);
            }
        });
    }

    public void saveListData(SharedPreferences sharedPref, List<String> nameList, String key)
    {

        SharedPreferences.Editor editor = sharedPref.edit();
        Gson gson = new Gson();
        String json = gson.toJson(nameList);
        editor.putString(key, json);
        editor.apply();

    }

}
