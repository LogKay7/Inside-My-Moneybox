package com.example.onetirelire;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.example.onetirelire.MainActivity.valeursTransacList;

public class ChoiceMoneyAddActivity extends AppCompatActivity {

    Button btnAddBillets, btnAddPieces;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_money_add);

        btnAddBillets = findViewById(R.id.btn_add_billets);
        btnAddPieces = findViewById(R.id.btn_add_pieces);

        btnAddBillets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent6 = new Intent(ChoiceMoneyAddActivity.this, ActivityAddBillets.class);  //Ajouter des billets
                startActivity(intent6);
            }
        });

        btnAddPieces.setOnClickListener(new View.OnClickListener() {            //Ajouter des pièces
            @Override
            public void onClick(View v) {
                Intent intent5 = new Intent(ChoiceMoneyAddActivity.this, AddPieces.class);  //Ajouter des billets
                startActivity(intent5);
            }
        });

    }
}
