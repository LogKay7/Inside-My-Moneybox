package com.example.onetirelire;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.onetirelire.MainActivity.*;


public class AddPieces extends AppCompatActivity {

    private int nbPieces001 = 0;
    private boolean _p001 = false;
    private int nbPieces002 = 0;
    private boolean _p002 = false;
    private int nbPieces005 = 0;
    private boolean _p005 = false;
    private int nbPieces10 = 0;
    private boolean _p10 = false;
    private int nbPieces20 = 0;
    private boolean _p20 = false;
    private int nbPieces50 = 0;
    private boolean _p50 = false;
    private int nbPieces1 = 0;
    private boolean _p1 = false;
    private int nbPieces2 = 0;
    private boolean _p2 = false;
    Button btnMoinsPieces001 ;
    Button btnPlusPieces001 ;
    EditText textNbPieces001 ;
    Button btnMoinsPieces002 ;
    Button btnPlusPieces002 ;
    EditText textNbPieces002 ;
    Button btnMoinsPieces005 ;
    Button btnPlusPieces005 ;
    EditText textNbPieces005 ;
    Button btnMoinsPieces10 ;
    Button btnPlusPieces10 ;
    EditText textNbPieces10 ;
    Button btnMoinsPieces20 ;
    Button btnPlusPieces20 ;
    EditText textNbPieces20 ;
    Button btnMoinsPieces50 ;
    Button btnPlusPieces50 ;
    EditText textNbPieces50 ;
    Button btnMoinsPieces1 ;
    Button btnPlusPieces1 ;
    EditText textNbPieces1 ;
    Button btnMoinsPieces2 ;
    Button btnPlusPieces2 ;
    EditText textNbPieces2 ;
    String edTextControl;
    Button btnValidationAddPieces;

    private int nbPieces001In = MainActivity.getInPieces001();
    private int nbPieces002In = MainActivity.getInPieces002();
    private int nbPieces005In = MainActivity.getInPieces005();
    private int nbPieces10In = MainActivity.getInPieces10();
    private int nbPieces20In = MainActivity.getInPieces20();
    private int nbPieces50In = MainActivity.getInPieces50();
    private int nbPieces1In = MainActivity.getInPieces1();
    private int nbPieces2In = MainActivity.getInPieces2();



    private TextWatcher textWatcher001 = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int start, int before, int count) {
        }

        @Override
        //Détecte l'écriture dans la Textview du nbre de pièces
        public void onTextChanged(CharSequence charSequence, int start, int count, int after) {
        }

        @Override
        public void afterTextChanged(Editable editable) {

            edTextControl = textNbPieces001.getText().toString().trim();

            if(edTextControl.isEmpty() || edTextControl.length() == 0 || edTextControl.equals("") || edTextControl == null || edTextControl.equals("-"))
            {
                //EditText is empty
                _p001= false;     //Permettra de vérifier avant de valider le formulaire
                nbPieces001 = 0;
            }
            else
            {
                if(edTextControl.equals("0")){          //Si = 0
                    _p001= false;
                }
                else {
                    nbPieces001 = Integer.parseInt(textNbPieces001.getText().toString());
                    _p001 = true;                     //Condition d'activation du bouton validation
                }
            }
        }

    };

    private TextWatcher textWatcher002 = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int start, int before, int count) {

        }

        @Override
        //Détecte l'écriture dans la Textview du nbre de pièces
        public void onTextChanged(CharSequence charSequence, int start, int count, int after) {
        }

        @Override
        public void afterTextChanged(Editable editable) {

            edTextControl = textNbPieces002.getText().toString().trim();

            if(edTextControl.isEmpty() || edTextControl.length() == 0 || edTextControl.equals("") || edTextControl == null || edTextControl.equals("-"))
            {
                //EditText is empty
                _p002= false;     //Permettra de vérifier avant de valider le formulaire
                nbPieces002 = 0;
            }
            else
            {
                if(edTextControl.equals("0")){
                    _p002= false;
                }
                else {
                    nbPieces002 = Integer.parseInt(textNbPieces002.getText().toString());
                    _p002 = true;                     //Condition d'activation du bouton validation
                }
            }
        }

    };

    private TextWatcher textWatcher005 = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int start, int before, int count) {

        }

        @Override
        //Détecte l'écriture dans la Textview du nbre de pièces
        public void onTextChanged(CharSequence charSequence, int start, int count, int after) {
        }

        @Override
        public void afterTextChanged(Editable editable) {

            edTextControl = textNbPieces005.getText().toString().trim();

            if(edTextControl.isEmpty() || edTextControl.length() == 0 || edTextControl.equals("") || edTextControl == null || edTextControl.equals("-"))
            {
                //EditText is empty
                _p005= false;     //Permettra de vérifier avant de valider le formulaire
                nbPieces005 = 0;

            }
            else
            {
                if(edTextControl.equals("0")){
                    _p005= false;
                }
                else {
                    nbPieces005 = Integer.parseInt(textNbPieces005.getText().toString());
                    _p005 = true;                     //Condition d'activation du bouton validation
                }
            }
        }

    };

    private TextWatcher textWatcher10 = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int start, int before, int count) {

        }

        @Override
        //Détecte l'écriture dans la Textview du nbre de pièces
        public void onTextChanged(CharSequence charSequence, int start, int count, int after) {
        }

        @Override
        public void afterTextChanged(Editable editable) {

            edTextControl = textNbPieces10.getText().toString().trim();

            if(edTextControl.isEmpty() || edTextControl.length() == 0 || edTextControl.equals("") || edTextControl == null || edTextControl.equals("-"))
            {
                //EditText is empty
                _p10= false;     //Permettra de vérifier avant de valider le formulaire
                nbPieces10 = 0;
            }
            else
            {
                if(edTextControl.equals("0")){
                    _p10= false;
                }
                else {
                    nbPieces10 = Integer.parseInt(textNbPieces10.getText().toString());
                    _p10 = true;                     //Condition d'activation du bouton validation
                }
            }
        }

    };

    private TextWatcher textWatcher20 = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int start, int before, int count) {

        }

        @Override
        //Détecte l'écriture dans la Textview du nbre de pièces
        public void onTextChanged(CharSequence charSequence, int start, int count, int after) {
        }

        @Override
        public void afterTextChanged(Editable editable) {

            edTextControl = textNbPieces20.getText().toString().trim();

            if(edTextControl.isEmpty() || edTextControl.length() == 0 || edTextControl.equals("") || edTextControl == null || edTextControl.equals("-"))
            {
                //EditText is empty
                _p20= false;     //Permettra de vérifier avant de valider le formulaire
                nbPieces20 = 0;
            }
            else
            {
                if(edTextControl.equals("0")){
                    _p20= false;
                }
                else {
                    nbPieces20 = Integer.parseInt(textNbPieces20.getText().toString());
                    _p20 = true;                     //Condition d'activation du bouton validation
                }
            }
        }

    };

    private TextWatcher textWatcher50 = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int start, int before, int count) {

        }

        @Override
        //Détecte l'écriture dans la Textview du nbre de pièces
        public void onTextChanged(CharSequence charSequence, int start, int count, int after) {
        }

        @Override
        public void afterTextChanged(Editable editable) {

            edTextControl = textNbPieces50.getText().toString().trim();

            if(edTextControl.isEmpty() || edTextControl.length() == 0 || edTextControl.equals("") || edTextControl == null || edTextControl.equals("-"))
            {
                //EditText is empty
                _p50 = false;     //Permettra de vérifier avant de valider le formulaire
                nbPieces50 = 0;
            }
            else
            {
                if(edTextControl.equals("0")){
                    _p50 = false;
                }
                else {
                    nbPieces50 = Integer.parseInt(textNbPieces50.getText().toString());
                    _p50 = true;                     //Condition d'activation du bouton validation
                }
            }
        }

    };

    private TextWatcher textWatcher1 = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int start, int before, int count) {

        }

        @Override
        //Détecte l'écriture dans la Textview du nbre de pièces
        public void onTextChanged(CharSequence charSequence, int start, int count, int after) {
        }

        @Override
        public void afterTextChanged(Editable editable) {

            edTextControl = textNbPieces1.getText().toString().trim();

            if(edTextControl.isEmpty() || edTextControl.length() == 0 || edTextControl.equals("") || edTextControl == null || edTextControl.equals("-"))
            {
                //EditText is empty
                _p1 = false;     //Permettra de vérifier avant de valider le formulaire
                nbPieces1 = 0;
            }
            else
            {
                if(edTextControl.equals("0")){
                    _p1 = false;
                }
                else {
                    nbPieces1 = Integer.parseInt(textNbPieces1.getText().toString());
                    _p1 = true;                     //Condition d'activation du bouton validation
                }
            }
        }

    };

    private TextWatcher textWatcher2 = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int start, int before, int count) {

        }

        @Override
        //Détecte l'écriture dans la Textview du nbre de pièces
        public void onTextChanged(CharSequence charSequence, int start, int count, int after) {
        }

        @Override
        public void afterTextChanged(Editable editable) {

            edTextControl = textNbPieces2.getText().toString().trim();

            if(edTextControl.isEmpty() || edTextControl.length() == 0 || edTextControl.equals("") || edTextControl == null || edTextControl.equals("-"))
            {
                //EditText is empty
                _p2 = false;     //Permettra de vérifier avant de valider le formulaire
                nbPieces2 = 0;
            }
            else
            {
                if(edTextControl.equals("0")){
                    _p2 = false;
                }
                else {
                    nbPieces2 = Integer.parseInt(textNbPieces2.getText().toString());
                    _p2 = true;                     //Condition d'activation du bouton validation
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pieces);
        btnMoinsPieces001 = findViewById(R.id.btn_moins_pieces001);
        btnPlusPieces001 = findViewById(R.id.btn_plus_pieces001);                  //Initialisation des vues
        textNbPieces001 = findViewById(R.id.text_nb_pieces001);
        textNbPieces001.addTextChangedListener(textWatcher001);
        btnMoinsPieces002 = findViewById(R.id.btn_moins_pieces002);
        btnPlusPieces002 = findViewById(R.id.btn_plus_pieces002);                  //Initialisation des vues
        textNbPieces002 = findViewById(R.id.text_nb_pieces002);
        textNbPieces002.addTextChangedListener(textWatcher002);
        btnMoinsPieces005 = findViewById(R.id.btn_moins_pieces005);
        btnPlusPieces005 = findViewById(R.id.btn_plus_pieces005);                  //Initialisation des vues
        textNbPieces005 = findViewById(R.id.text_nb_pieces005);
        textNbPieces005.addTextChangedListener(textWatcher005);
        btnMoinsPieces10 = findViewById(R.id.btn_moins_pieces10);
        btnPlusPieces10 = findViewById(R.id.btn_plus_pieces10);                  //Initialisation des vues
        textNbPieces10 = findViewById(R.id.text_nb_pieces10);
        textNbPieces10.addTextChangedListener(textWatcher10);
        btnMoinsPieces20 = findViewById(R.id.btn_moins_pieces20);
        btnPlusPieces20 = findViewById(R.id.btn_plus_pieces20);                  //Initialisation des vues
        textNbPieces20 = findViewById(R.id.text_nb_pieces20);
        textNbPieces20.addTextChangedListener(textWatcher20);
        btnMoinsPieces50 = findViewById(R.id.btn_moins_pieces50);
        btnPlusPieces50 = findViewById(R.id.btn_plus_pieces50);                  //Initialisation des vues
        textNbPieces50 = findViewById(R.id.text_nb_pieces50);
        textNbPieces50.addTextChangedListener(textWatcher50);
        btnMoinsPieces1 = findViewById(R.id.btn_moins_pieces1);
        btnPlusPieces1 = findViewById(R.id.btn_plus_pieces1);                  //Initialisation des vues
        textNbPieces1 = findViewById(R.id.text_nb_pieces1);
        textNbPieces1.addTextChangedListener(textWatcher1);
        btnMoinsPieces2 = findViewById(R.id.btn_moins_pieces2);
        btnPlusPieces2 = findViewById(R.id.btn_plus_pieces2);                  //Initialisation des vues
        textNbPieces2 = findViewById(R.id.text_nb_pieces2);
        textNbPieces2.addTextChangedListener(textWatcher2);
        btnValidationAddPieces = findViewById(R.id.btn_validation_add_pieces);

        textNbPieces001.setFilters(new InputFilter[]{ new InputFilterMinMax("-"+nbPieces001In, "999")});
        textNbPieces002.setFilters(new InputFilter[]{ new InputFilterMinMax("-"+nbPieces002In, "999")});
        textNbPieces005.setFilters(new InputFilter[]{ new InputFilterMinMax("-"+nbPieces005In, "999")});
        textNbPieces10.setFilters(new InputFilter[]{ new InputFilterMinMax("-"+nbPieces10In, "999")});
        textNbPieces20.setFilters(new InputFilter[]{ new InputFilterMinMax("-"+nbPieces20In, "999")});
        textNbPieces50.setFilters(new InputFilter[]{ new InputFilterMinMax("-"+nbPieces50In, "999")});
        textNbPieces1.setFilters(new InputFilter[]{ new InputFilterMinMax("-"+nbPieces1In, "999")});
        textNbPieces2.setFilters(new InputFilter[]{ new InputFilterMinMax("-"+nbPieces2In, "999")});


        btnMoinsPieces001.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nbPieces001 --;                                                     //Clic sur les boutons + ou -
                textNbPieces001.setText(String.valueOf(nbPieces001));
            }
        });

        btnPlusPieces001.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nbPieces001 ++;
                textNbPieces001.setText(String.valueOf(nbPieces001));
            }
        });

        btnMoinsPieces002.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nbPieces002 --;                                                     //Clic sur les boutons + ou -
                textNbPieces002.setText(String.valueOf(nbPieces002));
            }
        });

        btnPlusPieces002.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nbPieces002 ++;
                textNbPieces002.setText(String.valueOf(nbPieces002));
            }
        });

        btnMoinsPieces005.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nbPieces005 --;                                                     //Clic sur les boutons + ou -
                textNbPieces005.setText(String.valueOf(nbPieces005));
            }
        });

        btnPlusPieces005.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nbPieces005 ++;
                textNbPieces005.setText(String.valueOf(nbPieces005));
            }
        });

        btnMoinsPieces10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nbPieces10 --;                                                     //Clic sur les boutons + ou -
                textNbPieces10.setText(String.valueOf(nbPieces10));
            }
        });

        btnPlusPieces10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nbPieces10 ++;
                textNbPieces10.setText(String.valueOf(nbPieces10));
            }
        });

        btnMoinsPieces20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nbPieces20 --;                                                     //Clic sur les boutons + ou -
                textNbPieces20.setText(String.valueOf(nbPieces20));
            }
        });

        btnPlusPieces20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nbPieces20 ++;
                textNbPieces20.setText(String.valueOf(nbPieces20));
            }
        });

        btnMoinsPieces50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nbPieces50 --;                                                     //Clic sur les boutons + ou -
                textNbPieces50.setText(String.valueOf(nbPieces50));
            }
        });

        btnPlusPieces50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nbPieces50 ++;
                textNbPieces50.setText(String.valueOf(nbPieces50));
            }
        });

        btnMoinsPieces1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nbPieces1 --;                                                     //Clic sur les boutons + ou -
                textNbPieces1.setText(String.valueOf(nbPieces1));
            }
        });

        btnPlusPieces1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nbPieces1 ++;
                textNbPieces1.setText(String.valueOf(nbPieces1));
            }
        });

        btnMoinsPieces2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nbPieces2 --;                                                     //Clic sur les boutons + ou -
                textNbPieces2.setText(String.valueOf(nbPieces2));
            }
        });

        btnPlusPieces2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nbPieces2 ++;
                textNbPieces2.setText(String.valueOf(nbPieces2));
            }
        });


        btnValidationAddPieces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(_p001 || _p002 || _p005 || _p10 || _p20 || _p50 || _p1 || _p2)
                {       // Validation

                    Intent intent = new Intent(AddPieces.this, RecapAddPieces.class);
                    intent.putExtra("nbPieces001", nbPieces001);
                    intent.putExtra("nbPieces002", nbPieces002);
                    intent.putExtra("nbPieces005", nbPieces005);
                    intent.putExtra("nbPieces10", nbPieces10);
                    intent.putExtra("nbPieces20", nbPieces20);
                    intent.putExtra("nbPieces50", nbPieces50);
                    intent.putExtra("nbPieces1", nbPieces1);
                    intent.putExtra("nbPieces2", nbPieces2);

                    startActivity(intent);
                }
                else {      //Champs manquants
                    Toast.makeText(AddPieces.this,"Champs manquants",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}
