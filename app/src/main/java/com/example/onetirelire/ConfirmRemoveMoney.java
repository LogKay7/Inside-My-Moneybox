package com.example.onetirelire;

import androidx.appcompat.app.AppCompatActivity;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;

import android.content.Intent;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ConfirmRemoveMoney extends AppCompatActivity {

    ImageView imgDone;
    Button btnRetourAccueil;

    AnimatedVectorDrawableCompat avd;
    AnimatedVectorDrawable avd2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_remove_money);

        btnRetourAccueil = findViewById(R.id.btn_accueil_transac);

        imgDone = findViewById(R.id.imgDone);

        Drawable drawable = imgDone.getDrawable();

        if (drawable instanceof AnimatedVectorDrawableCompat)
        {
            avd = (AnimatedVectorDrawableCompat) drawable;
            avd.start();
        } else if(drawable instanceof AnimatedVectorDrawable)
        {
            avd2 = (AnimatedVectorDrawable) drawable;
            avd2.start();
        }


        btnRetourAccueil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ConfirmRemoveMoney.this, MainActivity.class));

            }
        });


    }
}
