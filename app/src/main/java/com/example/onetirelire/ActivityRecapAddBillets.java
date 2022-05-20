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


public class ActivityRecapAddBillets extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    private int nbBillets5;
    private int valeur5;
    private int nbBillets10;
    private int valeur10;
    private int nbBillets20;
    private int valeur20;
    private int nbBillets50;
    private int valeur50;
    private int nbBillets100;
    private int valeur100;
    private int nbBillets200;
    private int valeur200;
    private int nbBillets500;
    private int valeur500;
    private float ancTotal;
    private float totalAdd;
    private float nvTotal;


    boolean _ajt = false;
    boolean _suppr = false;
    String textTotalAjt;
    String textTotalSuppr;
    String textTotal;
    TextView textViewRecapAjtBillets;
    Button btnConfirmationAddBillets;

    String textDateHeure = " ";

    String textDetailsDialog;
    String textAjoutDetailsDialog;
    String textRetraitDetailsDialog;



    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();
        nbBillets5 = intent.getIntExtra("nbBillets5",0);
        nbBillets10 = intent.getIntExtra("nbBillets10",0);
        nbBillets20 = intent.getIntExtra("nbBillets20",0);
        nbBillets50 = intent.getIntExtra("nbBillets50",0);
        nbBillets100 = intent.getIntExtra("nbBillets100",0);
        nbBillets200 = intent.getIntExtra("nbBillets200",0);
        nbBillets500 = intent.getIntExtra("nbBillets500",0);

        textTotalAjt = " ";
        textTotalSuppr = " ";
        textTotal = " ";

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Intent intent = getIntent();
        nbBillets5 = intent.getIntExtra("nbBillets5",0);
        nbBillets10 = intent.getIntExtra("nbBillets10",0);
        nbBillets20 = intent.getIntExtra("nbBillets20",0);
        nbBillets50 = intent.getIntExtra("nbBillets50",0);
        nbBillets100 = intent.getIntExtra("nbBillets100",0);
        nbBillets200 = intent.getIntExtra("nbBillets200",0);
        nbBillets500 = intent.getIntExtra("nbBillets500",0);
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
        setContentView(R.layout.activity_recap_add_billets);

        sharedPreferences = getSharedPreferences("DONNEES", MODE_PRIVATE);

        textViewRecapAjtBillets  = findViewById(R.id.textvAjout);
        btnConfirmationAddBillets = findViewById(R.id.btn_confirmation_add_billets);

        Intent intent = getIntent();
        nbBillets5 = intent.getIntExtra("nbBillets5",0);
        nbBillets10 = intent.getIntExtra("nbBillets10",0);
        nbBillets20 = intent.getIntExtra("nbBillets20",0);
        nbBillets50 = intent.getIntExtra("nbBillets50",0);
        nbBillets100 = intent.getIntExtra("nbBillets100",0);
        nbBillets200 = intent.getIntExtra("nbBillets200",0);
        nbBillets500 = intent.getIntExtra("nbBillets500",0);


        textTotalAjt = " ";
        textTotalSuppr = " ";
        textTotal = " ";
        textDetailsDialog = " ";
        textAjoutDetailsDialog = " ";
        textRetraitDetailsDialog = " ";


        totalAdd = 0.f;


        if(nbBillets5 == 0) {

        } else if(nbBillets5 > 0) {
                if(nbBillets5 == 1) {
                    valeur5 = 5;
                    textTotalAjt += ("1 billet de 5 €  ->  + " + valeur5 +" € \n\n");
                    _ajt = true;
                    totalAdd += 5;
                    textAjoutDetailsDialog += ("1 billet de 5€ \n");
                } else {
                    valeur5 = nbBillets5 * 5;
                    textTotalAjt += (nbBillets5 + " billets de 5 €  ->  + " + valeur5 +" € \n\n");
                    _ajt = true;
                    totalAdd += valeur5;
                    textAjoutDetailsDialog += (nbBillets5 + " billets de 5 € \n");
                }
        } else {
            if(nbBillets5 == -1) {
                valeur5 = 5;
                textTotalSuppr += ("1 billet de 5 €  ->  - " + valeur5 + " € \n\n");
                _suppr = true;
                totalAdd -= 5;
                textRetraitDetailsDialog += ("1 billet de 5€ \n");

            } else {
                valeur5 = nbBillets5 * -5;
                textTotalSuppr += (Math.abs(nbBillets5) + " billets de 5 €  ->  - " + valeur5 + " € \n\n");
                _suppr = true;
                totalAdd -= valeur5;
                textRetraitDetailsDialog += (Math.abs(nbBillets5) + " billets de 5 € \n");

            }
        }

        if(nbBillets10 == 0) {

            //Aucun billet

        } else if(nbBillets10 > 0) {
            if(nbBillets10 == 1) {
                valeur10 = 10;
                textTotalAjt += ("1 billet de 10 €  ->  + " + valeur10 + " € \n\n");
                _ajt = true;
                totalAdd += 10;
                textAjoutDetailsDialog += ("1 billet de 10 € \n");

            } else {
                valeur10 = nbBillets10 * 10;
                textTotalAjt += (nbBillets10 + " billets de 10 €  ->  + " + valeur10 + " € \n\n");
                _ajt = true;
                totalAdd += valeur10;
                textAjoutDetailsDialog += (nbBillets10 + " billets de 10 € \n");
            }

        } else {
            if(nbBillets10 == -1) {
                valeur10 = 10;
                textTotalSuppr += ("1 billet de 10 €  ->  - " + valeur10 + " € \n\n");
                _suppr = true;
                totalAdd -= 10;
                textRetraitDetailsDialog += ("1 billet de 10 € \n");

            } else {
                valeur10 = nbBillets10 * -10;
                textTotalSuppr += (Math.abs(nbBillets10) + " billets de 10 €  ->  - " + valeur10 + " € \n\n");
                _suppr = true;
                totalAdd -= valeur10;
                textRetraitDetailsDialog += (Math.abs(nbBillets10) + " billets de 10 € \n");
            }

        }

        if(nbBillets20 == 0) {

            //Aucun billet

        } else if(nbBillets20 > 0) {
            if(nbBillets20 == 1) {
                valeur20 = 20;
                textTotalAjt += ("1 billet de 20 €  ->  + " + valeur20 + " € \n\n");
                _ajt = true;
                totalAdd += 20;
                textAjoutDetailsDialog += ("1 billet de 20 € \n");

            } else {
                valeur20 = nbBillets20 * 20;
                textTotalAjt += (nbBillets20 + " billets de 20 €  ->  + " + valeur20 + " € \n\n");
                _ajt = true;
                totalAdd += valeur20;
                textAjoutDetailsDialog += (nbBillets20 + " billets de 20 € \n");
            }

        } else {
            if(nbBillets20 == -1) {
                valeur20 = 20;
                textTotalSuppr += ("1 billet de 20 €  ->  - " + valeur20 + " € \n\n");
                _suppr = true;
                totalAdd -= 20;
                textRetraitDetailsDialog += ("1 billet de 20 € \n");

            } else {
                valeur20 = nbBillets20 * -20;
                textTotalSuppr += (Math.abs(nbBillets20) + " billets de 20 €  ->  - " + valeur20 + " € \n\n");
                _suppr = true;
                totalAdd -= valeur20;
                textRetraitDetailsDialog += (Math.abs(nbBillets20) + " billets de 20 € \n");

            }

        }

        if(nbBillets50 == 0) {

        } else if(nbBillets50 > 0) {
            if(nbBillets50 == 1) {
                valeur50 = 50;
                textTotalAjt += ("1 billet de 50 €  ->  + " + valeur50 +" € \n\n");
                _ajt = true;
                totalAdd += 50;
                textAjoutDetailsDialog += ("1 billet de 50 € \n");

            } else {
                valeur50 = nbBillets50 * 50;
                textTotalAjt += (nbBillets50 + " billets de 50 €  ->  + " + valeur50 +" € \n\n");
                _ajt = true;
                totalAdd += valeur50;
                textAjoutDetailsDialog += (nbBillets50 + " billets de 50 € \n");
            }
        } else {
            if(nbBillets50 == -1) {
                valeur50 = 50;
                textTotalSuppr += ("1 billet de 50 €  ->  - " + valeur50 + " € \n\n");
                _suppr = true;
                totalAdd -= 50;
                textRetraitDetailsDialog += ("1 billet de 50 € \n");

            } else {
                valeur50 = nbBillets50 * -50;
                textTotalSuppr += (Math.abs(nbBillets50) + " billets de 50 €  ->  - " + valeur50 + " € \n\n");
                _suppr = true;
                totalAdd -= valeur50;
                textRetraitDetailsDialog += (Math.abs(nbBillets50) + " billets de 50 € \n");

            }
        }

        if(nbBillets100 == 0) {

            //Aucun billet

        } else if(nbBillets100 > 0) {
            if(nbBillets100 == 1) {
                valeur100 = 100;
                textTotalAjt += ("1 billet de 100 €  ->  + " + valeur100 + " € \n\n");
                _ajt = true;
                totalAdd += 100;
                textAjoutDetailsDialog += ("1 billet de 100 € \n");

            } else {
                valeur100 = nbBillets100 * 100;
                textTotalAjt += (nbBillets100 + " billets de 100 €  ->  + " + valeur100 + " € \n\n");
                _ajt = true;
                totalAdd += valeur100;
                textAjoutDetailsDialog += (nbBillets100 + " billets de 100 € \n");
            }

        } else {
            if(nbBillets100 == -1) {
                valeur100 = 100;
                textTotalSuppr += ("1 billet de 100 €  ->  - " + valeur100 + " € \n\n");
                _suppr = true;
                totalAdd -= 100;
                textRetraitDetailsDialog += ("1 billet de 100 € \n");

            } else {
                valeur100 = nbBillets100 * -100;
                textTotalSuppr += (Math.abs(nbBillets100) + " billets de 100 €  ->  - " + valeur100 + " € \n\n");
                _suppr = true;
                totalAdd -= valeur100;
                textRetraitDetailsDialog += (Math.abs(nbBillets100) + " billets de 100 € \n");

            }

        }

        if(nbBillets200 == 0) {

            //Aucun billet

        } else if(nbBillets200 > 0) {
            if(nbBillets200 == 1) {
                valeur200 = 200;
                textTotalAjt += ("1 billet de 200 €  ->  + " + valeur200 + " € \n\n");
                _ajt = true;
                totalAdd += 200;
                textAjoutDetailsDialog += ("1 billet de 200 € \n");

            } else {
                valeur200 = nbBillets200 * 200;
                textTotalAjt += (nbBillets200 + " billets de 200 €  ->  + " + valeur200 + " € \n\n");
                _ajt = true;
                totalAdd += valeur200;
                textAjoutDetailsDialog += (nbBillets200 + " billets de 200 € \n");

            }

        } else {
            if(nbBillets200 == -1) {
                valeur200 = 200;
                textTotalSuppr += ("1 billet de 200 €  ->  - " + valeur200 + " € \n\n");
                _suppr = true;
                totalAdd -= 200;
                textRetraitDetailsDialog += ("1 billet de 200 € \n");


            } else {
                valeur200 = nbBillets200 * -200;
                textTotalSuppr += (Math.abs(nbBillets200) + " billets de 200 €  ->  - " + valeur200 + " € \n\n");
                _suppr = true;
                totalAdd -= valeur200;
                textRetraitDetailsDialog += (Math.abs(nbBillets200) + " billets de 200 € \n");

            }

        }


        if(nbBillets500 == 0) {

        } else if(nbBillets500 > 0) {
            if(nbBillets500 == 1) {
                valeur500 = 500;
                textTotalAjt += ("1 billet de 500 €  ->  + " + valeur500 +" € \n\n");
                _ajt = true;
                totalAdd += 500;
                textAjoutDetailsDialog += ("1 billet de 500 € \n");

            } else {
                valeur500 = nbBillets500 * 500;
                textTotalAjt += (nbBillets500 + " billets de 500 €  ->  + " + valeur500 +" € \n\n");
                _ajt = true;
                totalAdd += valeur500;
                textAjoutDetailsDialog += (nbBillets500 + " billets de 500 € \n");
            }
        } else {
            if(nbBillets500 == -1) {
                valeur500 = 500;
                textTotalSuppr += ("1 billet de 500 €  ->  - " + valeur500 + " € \n\n");
                _suppr = true;
                totalAdd -= 500;
                textRetraitDetailsDialog += ("1 billet de 500 € \n");

            } else {
                valeur500 = nbBillets500 * -500;
                textTotalSuppr += (Math.abs(nbBillets500) + " billets de 500 €  ->  - " + valeur500 + " € \n\n");
                _suppr = true;
                totalAdd -= valeur500;
                textRetraitDetailsDialog += (Math.abs(nbBillets500) + " billets de 500 € \n");

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
        textViewRecapAjtBillets.setText(textTotal);


        btnConfirmationAddBillets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {       //ENREGISTREMENTS DES VALEURS

                MainActivity.setInBillets5(nbBillets5);
                MainActivity.setInBillets10(nbBillets10);
                MainActivity.setInBillets20(nbBillets20);
                MainActivity.setInBillets50(nbBillets50);
                MainActivity.setInBillets100(nbBillets100);
                MainActivity.setInBillets200(nbBillets200);
                MainActivity.setInBillets500(nbBillets500);
                nbBilletsIn = nbBillets5 + nbBillets10 + nbBillets20 + nbBillets50 + nbBillets100 + nbBillets200 + nbBillets500;

                ancTotal = MainActivity.getTotal();
                ancSoldeTransacListDialog.add("Solde précédent : + "+String.format("%.2f", ancTotal)+" €");
                MainActivity.setTotal(totalAdd);
                nvTotal = MainActivity.getTotal();
                nvSoldeTransacListDialog.add("Nouveau solde : + "+String.format("%.2f", nvTotal)+" €");

                idt ++;
                uniqueidTransacList.add(String.valueOf(idt));


                detailsTransacListDialog.add(textDetailsDialog);


                sharedPreferences
                        .edit()
                        .putFloat(SOLDE, nvTotal)
                        .putInt(NBBILLETS5, inBillets5)
                        .putInt(NBBILLETS10, inBillets10)
                        .putInt(NBBILLETS20, inBillets20)
                        .putInt(NBBILLETS50, inBillets50)
                        .putInt(NBBILLETS100, inBillets100)
                        .putInt(NBBILLETS200, inBillets200)
                        .putInt(NBBILLETS500, inBillets500)
                        .putInt(IDTRANSAC, idt)
                        .apply();

                if(totalAdd >= 0.0f)
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

                saveListData(sharedPreferences, titresTransacList, TITRESTRANSACLIST);
                saveListData(sharedPreferences, valeursTransacList, VALEURSTRANSACLIST);
                saveListData(sharedPreferences, datesHeuresTransacList, DATESHEURESLIST);
                saveListData(sharedPreferences, detailsTransacListDialog, DETAILSTRANSACLISTDIALOG);
                saveListData(sharedPreferences, nvSoldeTransacListDialog, NVSOLDETRANSACLISTDIALOG);
                saveListData(sharedPreferences, ancSoldeTransacListDialog, ANCSOLDETRANSACLISTDIALOG);
                saveListData(sharedPreferences, uniqueidTransacList, UNIQUEIDTRANSACLIST);

                isRefreshed = false;


                Intent intent2 = new Intent(ActivityRecapAddBillets.this, ConfirmAdd.class);
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
