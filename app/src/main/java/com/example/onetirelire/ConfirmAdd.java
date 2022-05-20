package com.example.onetirelire;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;

import android.content.Intent;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ConfirmAdd extends AppCompatActivity {

    private float ancTotal;
    private float totalAdd;
    private float nvTotal;

    private String textAncSolde;
    private String textNvSolde;
    private String textAddTotal;

    TextView ancSolde;
    TextView valAjout;
    TextView nvSolde;

    Button btnRetourAccueil;

    ImageView imgAnimDone;

    AnimatedVectorDrawableCompat avd;
    AnimatedVectorDrawable avd2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_add);

        Intent intent1 = getIntent();
        ancTotal = intent1.getFloatExtra("ancTotal",0);
        totalAdd = intent1.getFloatExtra("totalAdd",0);
        nvTotal = intent1.getFloatExtra("nvTotal",0);



        ancSolde = findViewById(R.id.textv_solde_initial);
        valAjout = findViewById(R.id.textv_ajout);
        nvSolde = findViewById(R.id.textv_solde_final);
        btnRetourAccueil = findViewById(R.id.btn_retour_accueil);

        imgAnimDone = findViewById(R.id.imageAnimDone);

        Drawable drawable1 = imgAnimDone.getDrawable();

        if (drawable1 instanceof AnimatedVectorDrawableCompat)
        {
            avd = (AnimatedVectorDrawableCompat) drawable1;
            avd.start();
        } else if(drawable1 instanceof AnimatedVectorDrawable)
        {
            avd2 = (AnimatedVectorDrawable) drawable1;
            avd2.start();
        }

        textAncSolde = "Solde initial : " + String.format("%.2f", ancTotal);
        textNvSolde = "Nouveau solde : " + String.format("%.2f", nvTotal);

        ancSolde.setText(textAncSolde);
        if(totalAdd>0)              //Si valeur positive, signe +
        {
            textAddTotal = "+ " + String.format("%.2f", totalAdd);
            valAjout.setText(textAddTotal);
            valAjout.setTextColor(ContextCompat.getColor(this, R.color.green));
        }
        else {
            textAddTotal = String.format("%.2f", totalAdd);
            valAjout.setText(textAddTotal);
            valAjout.setTextColor(ContextCompat.getColor(this, R.color.red));
        }
        nvSolde.setText(textNvSolde);


        btnRetourAccueil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ConfirmAdd.this, MainActivity.class));
            }
        });

    }
}
