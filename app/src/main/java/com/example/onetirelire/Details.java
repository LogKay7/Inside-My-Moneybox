package com.example.onetirelire;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.onetirelire.MainActivity.*;

public class Details extends AppCompatActivity {

    FloatingActionMenu floatingActionMenuDetails;
    FloatingActionButton ModifyFab, viewTransacFab, rmvMoneyFab;

    TextView textViewPiecesDetails;
    TextView textViewBilletsDetails;

    String textPieces;
    String textBillets;

    float valeurp001;
    float valeurp002;
    float valeurp005;
    float valeurp10;
    float valeurp20;
    float valeurp50;
    float valeurp1;
    float valeurp2;
    float totalp;

    int valeurb5;
    int valeurb10;
    int valeurb20;
    int valeurb50;
    int valeurb100;
    int valeurb200;
    int valeurb500;
    int totalb;


    @Override
    protected void onResume() {
        super.onResume();

        textPieces ="";
        textBillets ="";
        valeurp001 = 0.f;
        valeurp002 = 0.f;
        valeurp005= 0.f;
        valeurp10 = 0.f;
        valeurp20 = 0.f;
        valeurp50 = 0.f;
        valeurp1 = 0.f;
        valeurp2 = 0.f;
        totalp = 0.0f;
        valeurb5 = 0;
        valeurb10 = 0;
        valeurb20 = 0;
        valeurb50 = 0;
        valeurb100 = 0;
        valeurb200 = 0;
        valeurb500 = 0;
        totalb = 0;

    }

    @Override
    protected void onRestart() {
        super.onRestart();

        textPieces ="";
        textBillets ="";
        valeurp001 = 0.f;
        valeurp002 = 0.f;
        valeurp005= 0.f;
        valeurp10 = 0.f;
        valeurp20 = 0.f;
        valeurp50 = 0.f;
        valeurp1 = 0.f;
        valeurp2 = 0.f;
        totalp = 0.0f;
        valeurb5 = 0;
        valeurb10 = 0;
        valeurb20 = 0;
        valeurb50 = 0;
        valeurb100 = 0;
        valeurb200 = 0;
        valeurb500 = 0;
        totalb = 0;

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        textPieces ="";
        textBillets ="";

        valeurp001 = 0.f;
        valeurp002 = 0.f;
        valeurp005= 0.f;
        valeurp10 = 0.f;
        valeurp20 = 0.f;
        valeurp50 = 0.f;
        valeurp1 = 0.f;
        valeurp2 = 0.f;
        totalp = 0.0f;

        valeurb5 = 0;
        valeurb10 = 0;
        valeurb20 = 0;
        valeurb50 = 0;
        valeurb100 = 0;
        valeurb200 = 0;
        valeurb500 = 0;
        totalb = 0;

        floatingActionMenuDetails = findViewById(R.id.fabMenu2);
        ModifyFab = findViewById(R.id.fabMenu_item_Modify);
        viewTransacFab = findViewById(R.id.fabMenu_item_ViewTransac);
        rmvMoneyFab = findViewById(R.id.fabMenu_item_RmvMoney);

        ModifyFab.setLabelColors(ContextCompat.getColor(this, R.color.white),
                ContextCompat.getColor(this, R.color.pressed),
                ContextCompat.getColor(this, R.color.white_transparent));

        viewTransacFab.setLabelColors(ContextCompat.getColor(this, R.color.white),
                ContextCompat.getColor(this, R.color.pressed),
                ContextCompat.getColor(this, R.color.white_transparent));

        rmvMoneyFab.setLabelColors(ContextCompat.getColor(this, R.color.white),
                ContextCompat.getColor(this, R.color.pressed),
                ContextCompat.getColor(this, R.color.white_transparent));

        textViewPiecesDetails = findViewById(R.id.text_pieces_details);
        textViewBilletsDetails = findViewById(R.id.text_billets_details);

        if(inPieces001 == 0) {
                valeurp001 = 0.0f;

        } else {
            if(inPieces001 == 1) {
                valeurp001 = 0.01f;
                textPieces += ("1 pièce de 0,01 €  ->  + 0,01 €\n");

            } else {
                valeurp001 = inPieces001 / 100.f;
                textPieces += (inPieces001 + " pièces de 0,01 €  ->  + " + String.format("%.2f",valeurp001) +" € \n");
            }
        }

        if(inPieces002 == 0) {
            valeurp002 = 0.0f;

        } else {
            if(inPieces002 == 1) {
                valeurp002 = 0.02f;
                textPieces += ("1 pièce de 0,02 €  ->  + 0,02 €\n");

            } else {
                valeurp002 = inPieces002 / 50.f;
                textPieces += (inPieces002 + " pièces de 0,02 €  ->  + " + String.format("%.2f",valeurp002) +" € \n");
            }
        }

        if(inPieces005 == 0) {
            valeurp005 = 0.0f;

        } else {
            if(inPieces005 == 1) {
                valeurp005 = 0.05f;
                textPieces += ("1 pièce de 0,05 €  ->  + 0,05 €\n");

            } else {
                valeurp005 = inPieces005 / 20.f;
                textPieces += (inPieces005 + " pièces de 0,05 €  ->  + " + String.format("%.2f",valeurp005) +" € \n");
            }
        }

        if(inPieces10 == 0) {
            valeurp10 = 0.0f;

        } else {
            if(inPieces10 == 1) {
                valeurp10 = 0.10f;
                textPieces += ("1 pièce de 0,10 €  ->  + 0,10 €\n");

            } else {
                valeurp10 = inPieces10 / 10.f;
                textPieces += (inPieces10 + " pièces de 0,10 €  ->  + " + String.format("%.2f",valeurp10) +" € \n");
            }
        }

        if(inPieces20 == 0) {
            valeurp20 = 0.0f;

        } else {
            if(inPieces20 == 1) {
                valeurp20 = 0.20f;
                textPieces += ("1 pièce de 0,20 €  ->  + 0,20 €\n");

            } else {
                valeurp20 = inPieces20 / 5.f;
                textPieces += (inPieces20 + " pièces de 0,20 €  ->  + " + String.format("%.2f",valeurp20) +" € \n");
            }
        }

        if(inPieces50 == 0) {
            valeurp50 = 0.0f;

        } else {
            if(inPieces50 == 1) {
                valeurp50 = 0.50f;
                textPieces += ("1 pièce de 0,50 €  ->  + 0,50 €\n");

            } else {
                valeurp50 = inPieces50 / 2.f;
                textPieces += (inPieces50 + " pièces de 0,50 €  ->  + " + String.format("%.2f",valeurp50) +" € \n");
            }
        }

        if(inPieces1 == 0) {
            valeurp1 = 0.0f;

        } else {
            if(inPieces1 == 1) {
                valeurp1 = 1f;
                textPieces += ("1 pièce de 1 €  ->  + 1 €\n");

            } else {
                valeurp1 = inPieces1;
                textPieces += (inPieces1 + " pièces de 1 €  ->  + " + valeurp1 +" € \n");
            }
        }

        if(inPieces2 == 0) {
            valeurp2 = 0.0f;

        } else {
            if(inPieces2 == 1) {
                valeurp2 = 2f;
                textPieces += ("1 pièce de 2 €  ->  + 2 €\n");

            } else {
                valeurp2 = inPieces2 *2;
                textPieces += (inPieces2 + " pièces de 2 €  ->  + " + valeurp2 +" € \n");
            }
        }


        totalp = valeurp001 + valeurp002 + valeurp005 + valeurp10 + valeurp20 + valeurp50 + valeurp1 + valeurp2;

        if (totalp == 0.0f)
        {
            textPieces = "Aucune pièce dans la tirelire";
        }
        else
        {
            if(nbPiecesIn == 1)
            {
                textPieces += "\nLa tirelire contient 1 pièce de "+String.format("%.2f",totalp)+" €";
            }
            else
            {
                textPieces += "\nLa tirelire contient "+nbPiecesIn+" pièces pour un total de "+String.format("%.2f",totalp)+" €";
            }
        }

    textViewPiecesDetails.setText(textPieces);


        if(inBillets5 == 0) {
            valeurb5 = 0;

        } else {
            if(inBillets5 == 1) {
                valeurb5 = 5;
                textBillets += ("1 billet de 5 €\n");

            } else {
                valeurb5 = inBillets5 * 5;
                textBillets += (inBillets5 + " billets de 5 €  ->  " + valeurb5 +" € \n");
            }
        }

        if(inBillets10 == 0) {
            valeurb10 = 0;

        } else {
            if(inBillets10 == 1) {
                valeurb10 = 10;
                textBillets += ("1 billet de 10 €\n");

            } else {
                valeurb10 = inBillets10 * 10;
                textBillets += (inBillets10 + " billets de 10 €  ->  " + valeurb10 +" € \n");
            }
        }

        if(inBillets20 == 0) {
            valeurb20 = 0;

        } else {
            if(inBillets20 == 1) {
                valeurb20 = 20;
                textBillets += ("1 billet de 20 €\n");

            } else {
                valeurb20 = inBillets20 * 20;
                textBillets += (inBillets20 + " billets de 20 €  ->  " + valeurb20 +" € \n");
            }
        }

        if(inBillets50 == 0) {
            valeurb50 = 0;

        } else {
            if(inBillets50 == 1) {
                valeurb50 = 50;
                textBillets += ("1 billet de 50 €\n");

            } else {
                valeurb50 = inBillets50 * 50;
                textBillets += (inBillets50 + " billets de 50 €  ->  " + valeurb50 +" € \n");
            }
        }

        if(inBillets100 == 0) {
            valeurb100 = 0;

        } else {
            if(inBillets100 == 1) {
                valeurb100 = 100;
                textBillets += ("1 billet de 100 €\n");

            } else {
                valeurb100 = inBillets100 * 100;
                textBillets += (inBillets100 + " billets de 100 €  ->  " + valeurb100 +" € \n");
            }
        }

        if(inBillets200 == 0) {
            valeurb200 = 0;

        } else {
            if(inBillets200 == 1) {
                valeurb200 = 200;
                textBillets += ("1 billet de 200 €\n");

            } else {
                valeurb200 = inBillets200 * 200;
                textBillets += (inBillets200 + " billets de 200 €   ->  " + valeurb200 +" € \n");
            }
        }

        if(inBillets500 == 0) {
            valeurb500 = 0;

        } else {
            if(inBillets500 == 1) {
                valeurb500 = 500;
                textBillets += ("1 billet de 500 € \n");

            } else {
                valeurb500 = inBillets500 * 500;
                textBillets += (inBillets500 + " billets de 500 €  ->  " + valeurb500 +" € \n");
            }
        }

        totalb = valeurb5 + valeurb10 + valeurb20 + valeurb50 + valeurb100 + valeurb200 + valeurb500;

        if (totalb == 0)
        {
            textBillets = "Aucun billet dans la tirelire";
        }
        else
        {
            if(nbBilletsIn == 0)
            {
                textBillets += "\nLa tirelire contient 1 billet de "+totalb+" €";

            } else
            {
                textBillets += "\nLa tirelire contient "+nbBilletsIn+" billets pour un total de "+totalb+" €";

            }
        }

        textViewBilletsDetails.setText(textBillets);



    textViewPiecesDetails.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(Details.this, AddPieces.class));
        }
    });

    textViewBilletsDetails.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(Details.this, ActivityAddBillets.class));
        }
    });






        ModifyFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Details.this, ChoiceMoneyAddActivity.class));

            }
        });

        viewTransacFab.setOnClickListener(new View.OnClickListener() {              //Bouton afficher les détails
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Details.this, Transac.class));
            }

        });

        rmvMoneyFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Details.this, RemoveMoney.class));
            }
        });






    }
}
