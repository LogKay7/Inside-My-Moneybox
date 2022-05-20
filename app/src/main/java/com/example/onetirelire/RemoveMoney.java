package com.example.onetirelire;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import static com.example.onetirelire.MainActivity.*;

public class RemoveMoney extends AppCompatActivity {


    SharedPreferences sharedPreferences;

    Button btnConfirmRmMoney;
    Button btnRetourRmMoney;
    Button btnDetailsRmMoney;
    TextView textVRmMoneyRecap;
    TextView textQuestion;
    String textRecap;
    String textDateHeure = "";

    String contenuDetailsDialog = " ";
    String textDetailsDialog = " ";

    @Override
    protected void onResume() {
        super.onResume();

        if(total == 0.0f) //Si la tirelire est vide
        {
            textRecap = ("La tirelire est vide");
            btnConfirmRmMoney.setVisibility(View.INVISIBLE);
            btnConfirmRmMoney.setEnabled(false);
            btnConfirmRmMoney.setTextColor(ContextCompat.getColor(this, R.color.disabled));
            textQuestion.setVisibility(View.INVISIBLE);
        }
        else {
            if(nbBilletsIn !=1 && nbPiecesIn !=1 )
            {
                textRecap = ("La tirelire contient "+nbPiecesIn+" pièces et "+nbBilletsIn+" billets pour un total de "+String.format("%.2f", total)+" €");
            } else if(nbBilletsIn ==1 )
            {
                textRecap = ("La tirelire contient "+nbPiecesIn+" pièces et 1 billet pour un total de "+String.format("%.2f", total)+" €");
            } else
            {
                textRecap = ("La tirelire contient 1 pièce et "+nbBilletsIn+" billets pour un total de "+String.format("%.2f", total)+" €");
            }

            btnConfirmRmMoney.setVisibility(View.VISIBLE);
            textQuestion.setVisibility(View.VISIBLE);
            btnConfirmRmMoney.setEnabled(true);
            btnConfirmRmMoney.setTextColor(ContextCompat.getColor(this, R.color.colorButtonAdd));
        }
        textVRmMoneyRecap.setText(textRecap);


    }

    @Override
    protected void onRestart() {
        super.onRestart();
        textRecap = " ";
        contenuDetailsDialog = " ";
        textDetailsDialog = " ";
        if(total == 0.0f) //Si la tirelire est vide
        {
            textRecap = ("La tirelire est vide");
            btnConfirmRmMoney.setVisibility(View.INVISIBLE);
            btnConfirmRmMoney.setEnabled(false);
            btnConfirmRmMoney.setTextColor(ContextCompat.getColor(this, R.color.disabled));
            textQuestion.setVisibility(View.INVISIBLE);
        }
        else {
            if(nbBilletsIn !=1 && nbPiecesIn !=1 )
            {
                textRecap = ("La tirelire contient "+nbPiecesIn+" pièces et "+nbBilletsIn+" billets pour un total de "+String.format("%.2f", total)+" €");
            } else if(nbBilletsIn ==1 )
            {
                textRecap = ("La tirelire contient "+nbPiecesIn+" pièces et 1 billet pour un total de "+String.format("%.2f", total)+" €");
            } else
            {
                textRecap = ("La tirelire contient 1 pièce et "+nbBilletsIn+" billets pour un total de "+String.format("%.2f", total)+" €");
            }

            btnConfirmRmMoney.setVisibility(View.VISIBLE);
            textQuestion.setVisibility(View.VISIBLE);
            btnConfirmRmMoney.setEnabled(true);
            btnConfirmRmMoney.setTextColor(ContextCompat.getColor(this, R.color.colorButtonAdd));
        }
        textVRmMoneyRecap.setText(textRecap);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_money);

        sharedPreferences = getSharedPreferences("DONNEES", MODE_PRIVATE);

        btnConfirmRmMoney = findViewById(R.id.btn_confirmation_rm_money);
        btnRetourRmMoney = findViewById(R.id.btn_rm_money_retour);
        btnDetailsRmMoney = findViewById(R.id.btn_rm_money_details);
        textVRmMoneyRecap = findViewById(R.id.textVRmMoneyTitre);
        textQuestion = findViewById(R.id.textVRmMoneyText);

        if(total == 0.0f) //Si la tirelire est vide
        {
            textRecap = ("La tirelire est vide");
            btnConfirmRmMoney.setVisibility(View.INVISIBLE);
            btnConfirmRmMoney.setEnabled(false);
            btnConfirmRmMoney.setTextColor(ContextCompat.getColor(this, R.color.disabled));
            textQuestion.setVisibility(View.INVISIBLE);
        }
        else {
            if(nbBilletsIn !=1 && nbPiecesIn !=1 )
            {
                textRecap = ("La tirelire contient "+nbPiecesIn+" pièces et "+nbBilletsIn+" billets pour un total de "+String.format("%.2f", total)+" €");

            } else if(nbBilletsIn ==1 && nbPiecesIn == 1) {

                textRecap = ("La tirelire contient 1 pièce et 1 billet");

            } else if(nbBilletsIn ==1 )
            {
                textRecap = ("La tirelire contient "+nbPiecesIn+" pièces et 1 billet pour un total de "+String.format("%.2f", total)+" €");

            } else
            {
                textRecap = ("La tirelire contient 1 pièce et "+nbBilletsIn+" billets pour un total de "+String.format("%.2f", total)+" €");
            }


            btnConfirmRmMoney.setVisibility(View.VISIBLE);
            textQuestion.setVisibility(View.VISIBLE);
            btnConfirmRmMoney.setEnabled(true);
            btnConfirmRmMoney.setTextColor(ContextCompat.getColor(this, R.color.colorButtonAdd));
        }
        textVRmMoneyRecap.setText(textRecap);

        btnConfirmRmMoney.setOnClickListener(new View.OnClickListener() {   //Suppression du contenu de la tirelire
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RemoveMoney.this, ConfirmRemoveMoney.class));

                Date now = new Date();
                DateFormat dateformatter = DateFormat.getDateInstance(DateFormat.SHORT);
                String formattedDate = dateformatter.format(now);
                textDateHeure += formattedDate + "   ";

                DateFormat timeformatter = DateFormat.getTimeInstance(DateFormat.SHORT);
                String formattedTime = timeformatter.format(now);
                textDateHeure += formattedTime;

                valeursTransacList.add("- "+String.format("%.2f", total)+" €");
                titresTransacList.add("La tirelire a été vidée");
                datesHeuresTransacList.add(textDateHeure);


                ancSoldeTransacListDialog.add("Solde précédent : + "+String.format("%.2f", total)+" €");

                if(inPieces001>0)
                {
                    if(inPieces001==1)
                    {
                        contenuDetailsDialog = "1 pièce de 0,01 € \n";
                    } else
                    {
                        contenuDetailsDialog = inPieces001 + " pièces de 0,01 € \n";
                    }
                }

                if(inPieces002>0)
                {
                    if(inPieces002==1)
                    {
                        contenuDetailsDialog += "1 pièce de 0,02 € \n";
                    } else
                    {
                        contenuDetailsDialog += inPieces002 + " pièces de 0,02 € \n";
                    }
                }

                if(inPieces005>0)
                {
                    if (inPieces005 == 1)
                    {
                        contenuDetailsDialog += "1 pièce de 0,05 € \n";
                    } else
                    {
                        contenuDetailsDialog += inPieces005 + " pièces de 0,05 € \n";
                    }
                }

                if(inPieces10>0)
                {
                    if (inPieces10 == 1)
                    {
                        contenuDetailsDialog += "1 pièce de 0,10 € \n";
                    } else
                    {
                        contenuDetailsDialog += inPieces10 + " pièces de 0,10 € \n";
                    }
                }

                if(inPieces20>0)
                {
                    if (inPieces20 == 1)
                    {
                        contenuDetailsDialog += "1 pièce de 0,20 € \n";
                    } else
                    {
                        contenuDetailsDialog += inPieces20 + " pièces de 0,20 € \n";
                    }
                }

                if(inPieces50>0)
                {
                    if (inPieces50 == 1)
                    {
                        contenuDetailsDialog += "1 pièce de 0,50 € \n";
                    } else
                    {
                        contenuDetailsDialog += inPieces50 + " pièces de 0,50 € \n";
                    }
                }

                if(inPieces1>0)
                {
                    if (inPieces1 == 1)
                    {
                        contenuDetailsDialog += "1 pièce de 1 € \n";
                    } else
                    {
                        contenuDetailsDialog += inPieces1 + " pièces de 1 € \n";
                    }
                }

                if(inPieces2>0)
                {
                    if (inPieces2 == 1)
                    {
                        contenuDetailsDialog += "1 pièce de 2 € \n";
                    } else
                    {
                        contenuDetailsDialog += inPieces2 + " pièces de 2 € \n";
                    }
                }


                if(inBillets5>0)
                {
                    if(inBillets5==1)
                    {
                        contenuDetailsDialog += "1 billet de 5€ \n";
                    } else
                    {
                        contenuDetailsDialog += inBillets5 + " billets de 5€ \n";
                    }
                }

                if(inBillets10>0)
                {
                    if(inBillets10==1)
                    {
                        contenuDetailsDialog += "1 billet de 10€ \n";
                    } else
                    {
                        contenuDetailsDialog += inBillets10 + " billets de 10€ \n";
                    }
                }

                if(inBillets20>0)
                {
                    if(inBillets20==1)
                    {
                        contenuDetailsDialog += "1 billet de 20€ \n";
                    } else
                    {
                        contenuDetailsDialog += inBillets20 + " billets de 20€ \n";
                    }
                }

                if(inBillets50>0)
                {
                    if(inBillets50==1)
                    {
                        contenuDetailsDialog += "1 billet de 50€ \n";
                    } else
                    {
                        contenuDetailsDialog += inBillets50 + " billets de 50€ \n";
                    }
                }

                if(inBillets100>0)
                {
                    if(inBillets100==1)
                    {
                        contenuDetailsDialog += "1 billet de 100€ \n";
                    } else
                    {
                        contenuDetailsDialog += inBillets100 + " billets de 100€ \n";
                    }
                }

                if(inBillets200>0)
                {
                    if(inBillets200==1)
                    {
                        contenuDetailsDialog += "1 billet de 200€ \n";
                    } else
                    {
                        contenuDetailsDialog += inBillets200 + " billets de 200€ \n";
                    }
                }

                if(inBillets500>0)
                {
                    if(inBillets500==1)
                    {
                        contenuDetailsDialog += "1 billet de 500€ \n";
                    } else
                    {
                        contenuDetailsDialog += inBillets500 + " billets de 500€ \n";
                    }
                }

                textDetailsDialog = "La tirelire a été vidée de \n";
                textDetailsDialog += contenuDetailsDialog;


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

                nvSoldeTransacListDialog.add("Nouveau solde : + "+String.format("%.2f", total)+" €");

                idt ++;
                uniqueidTransacList.add(String.valueOf(idt));
                detailsTransacListDialog.add(textDetailsDialog);

                saveListData(sharedPreferences, titresTransacList, TITRESTRANSACLIST);
                saveListData(sharedPreferences, valeursTransacList, VALEURSTRANSACLIST);
                saveListData(sharedPreferences, datesHeuresTransacList, DATESHEURESLIST);
                saveListData(sharedPreferences, detailsTransacListDialog, DETAILSTRANSACLISTDIALOG);
                saveListData(sharedPreferences, nvSoldeTransacListDialog, NVSOLDETRANSACLISTDIALOG);
                saveListData(sharedPreferences, ancSoldeTransacListDialog, ANCSOLDETRANSACLISTDIALOG);
                saveListData(sharedPreferences, uniqueidTransacList, UNIQUEIDTRANSACLIST);
                isRefreshed = false;


                sharedPreferences
                        .edit()
                        .putFloat(SOLDE, total)
                        .putInt(NBBILLETS5, inBillets5)
                        .putInt(NBBILLETS10, inBillets10)
                        .putInt(NBBILLETS20, inBillets20)
                        .putInt(NBBILLETS50, inBillets50)
                        .putInt(NBBILLETS100, inBillets100)
                        .putInt(NBBILLETS200, inBillets200)
                        .putInt(NBBILLETS500, inBillets500)
                        .putInt(NBPIECES001, inPieces001)           //Réinitialisation du fichier sauvegardé
                        .putInt(NBPIECES002, inPieces002)
                        .putInt(NBPIECES005, inPieces005)
                        .putInt(NBPIECES10, inPieces10)
                        .putInt(NBPIECES20, inPieces20)
                        .putInt(NBPIECES50, inPieces50)
                        .putInt(NBPIECES1, inPieces1)
                        .putInt(NBPIECES2, inPieces2)
                        .putInt(IDTRANSAC, idt)
                        .apply();



            }
        });

        btnDetailsRmMoney.setOnClickListener(new View.OnClickListener() {           //Affichage du contenu de la tirelire
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RemoveMoney.this, Details.class));

            }
        });

        btnRetourRmMoney.setOnClickListener(new View.OnClickListener() {             //Retour à l'accueil
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RemoveMoney.this, MainActivity.class));
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
