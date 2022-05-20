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
import android.widget.TextView;
import android.widget.Toast;


public class ActivityAddBillets extends AppCompatActivity {

    private int nbBillets5 = 0;
    private boolean _b5 = false;
    private int nbBillets10 = 0;
    private boolean _b10 = false;
    private int nbBillets20 = 0;
    private boolean _b20 = false;
    private int nbBillets50 = 0;
    private boolean _b50 = false;
    private int nbBillets100 = 0;
    private boolean _b100 = false;
    private int nbBillets200 = 0;
    private boolean _b200 = false;
    private int nbBillets500 = 0;
    private boolean _b500 = false;
    Button btnMoinsBillets5 ;
    Button btnPlusBillets5 ;
    EditText textNbBillets5 ;
    Button btnMoinsBillets10 ;
    Button btnPlusBillets10 ;
    EditText textNbBillets10 ;
    Button btnMoinsBillets20 ;
    Button btnPlusBillets20 ;
    EditText textNbBillets20 ;
    Button btnMoinsBillets50 ;
    Button btnPlusBillets50 ;
    EditText textNbBillets50 ;
    Button btnMoinsBillets100 ;
    Button btnPlusBillets100 ;
    EditText textNbBillets100 ;
    Button btnMoinsBillets200 ;
    Button btnPlusBillets200 ;
    EditText textNbBillets200 ;
    Button btnMoinsBillets500 ;
    Button btnPlusBillets500 ;
    EditText textNbBillets500 ;
    String edTextControl;
    Button btnValidationAddBillets;

    private int nbBillets5In = MainActivity.getInBillets5();
    private int nbBillets10In = MainActivity.getInBillets10();
    private int nbBillets20In = MainActivity.getInBillets20();
    private int nbBillets50In = MainActivity.getInBillets50();
    private int nbBillets100In = MainActivity.getInBillets100();
    private int nbBillets200In = MainActivity.getInBillets200();
    private int nbBillets500In = MainActivity.getInBillets500();


    private TextWatcher textWatcher5 = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int start, int before, int count) {

        }

        @Override
        //Détecte l'écriture dans la Textview du nbre de billets
        public void onTextChanged(CharSequence charSequence, int start, int count, int after) {
        }

        @Override
        public void afterTextChanged(Editable editable) {

            edTextControl = textNbBillets5.getText().toString().trim();

            if(edTextControl.isEmpty() || edTextControl.length() == 0 || edTextControl.equals("") || edTextControl == null || edTextControl.equals("-"))
            {
                //EditText is empty
                _b5= false;     //Permettra de vérifier avant de valider le formulaire
                nbBillets5 = 0;
            }
            else
            {
                if(edTextControl.equals("0")){          //Si = 0
                    _b5= false;
                }
                else {
                    nbBillets5 = Integer.parseInt(textNbBillets5.getText().toString());
                    _b5 = true;                     //Condition d'activation du bouton validation
                }
            }
        }

    };

    private TextWatcher textWatcher10 = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int start, int before, int count) {

        }

        @Override
        //Détecte l'écriture dans la Textview du nbre de billets
        public void onTextChanged(CharSequence charSequence, int start, int count, int after) {
        }

        @Override
        public void afterTextChanged(Editable editable) {

            edTextControl = textNbBillets10.getText().toString().trim();

            if(edTextControl.isEmpty() || edTextControl.length() == 0 || edTextControl.equals("") || edTextControl == null || edTextControl.equals("-"))
            {
                //EditText is empty
                _b10= false;     //Permettra de vérifier avant de valider le formulaire
                nbBillets10 = 0;
            }
            else
            {
                if(edTextControl.equals("0")){
                    _b10= false;
                }
                else {
                    nbBillets10 = Integer.parseInt(textNbBillets10.getText().toString());
                    _b10 = true;                     //Condition d'activation du bouton validation
                }
            }
        }

    };

    private TextWatcher textWatcher20 = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int start, int before, int count) {

        }

        @Override
        //Détecte l'écriture dans la Textview du nbre de billets
        public void onTextChanged(CharSequence charSequence, int start, int count, int after) {
        }

        @Override
        public void afterTextChanged(Editable editable) {

            edTextControl = textNbBillets20.getText().toString().trim();

            if(edTextControl.isEmpty() || edTextControl.length() == 0 || edTextControl.equals("") || edTextControl == null || edTextControl.equals("-"))
            {
                //EditText is empty
                _b20= false;     //Permettra de vérifier avant de valider le formulaire
                nbBillets20 = 0;

            }
            else
            {
                if(edTextControl.equals("0")){
                    _b20= false;
                }
                else {
                    nbBillets20 = Integer.parseInt(textNbBillets20.getText().toString());
                    _b20 = true;                     //Condition d'activation du bouton validation
                }
            }
        }

    };

    private TextWatcher textWatcher50 = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int start, int before, int count) {

        }

        @Override
        //Détecte l'écriture dans la Textview du nbre de billets
        public void onTextChanged(CharSequence charSequence, int start, int count, int after) {
        }

        @Override
        public void afterTextChanged(Editable editable) {

            edTextControl = textNbBillets50.getText().toString().trim();

            if(edTextControl.isEmpty() || edTextControl.length() == 0 || edTextControl.equals("") || edTextControl == null || edTextControl.equals("-"))
            {
                //EditText is empty
                _b50= false;     //Permettra de vérifier avant de valider le formulaire
                nbBillets50 = 0;
            }
            else
            {
                if(edTextControl.equals("0")){
                    _b50= false;
                }
                else {
                    nbBillets50 = Integer.parseInt(textNbBillets50.getText().toString());
                    _b50 = true;                     //Condition d'activation du bouton validation
                }
            }
        }

    };

    private TextWatcher textWatcher100 = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int start, int before, int count) {

        }

        @Override
        //Détecte l'écriture dans la Textview du nbre de billets
        public void onTextChanged(CharSequence charSequence, int start, int count, int after) {
        }

        @Override
        public void afterTextChanged(Editable editable) {

            edTextControl = textNbBillets100.getText().toString().trim();

            if(edTextControl.isEmpty() || edTextControl.length() == 0 || edTextControl.equals("") || edTextControl == null || edTextControl.equals("-"))
            {
                //EditText is empty
                _b100= false;     //Permettra de vérifier avant de valider le formulaire
                nbBillets100 = 0;
            }
            else
            {
                if(edTextControl.equals("0")){
                    _b100= false;
                }
                else {
                    nbBillets100 = Integer.parseInt(textNbBillets100.getText().toString());
                    _b100 = true;                     //Condition d'activation du bouton validation
                }
            }
        }

    };

    private TextWatcher textWatcher200 = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int start, int before, int count) {

        }

        @Override
        //Détecte l'écriture dans la Textview du nbre de billets
        public void onTextChanged(CharSequence charSequence, int start, int count, int after) {
        }

        @Override
        public void afterTextChanged(Editable editable) {

            edTextControl = textNbBillets200.getText().toString().trim();

            if(edTextControl.isEmpty() || edTextControl.length() == 0 || edTextControl.equals("") || edTextControl == null || edTextControl.equals("-"))
            {
                //EditText is empty
                _b200= false;     //Permettra de vérifier avant de valider le formulaire
                nbBillets200 = 0;
            }
            else
            {
                if(edTextControl.equals("0")){
                    _b200= false;
                }
                else {
                    nbBillets200 = Integer.parseInt(textNbBillets200.getText().toString());
                    _b200 = true;                     //Condition d'activation du bouton validation
                }
            }
        }

    };

    private TextWatcher textWatcher500 = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int start, int before, int count) {

        }

        @Override
        //Détecte l'écriture dans la Textview du nbre de billets
        public void onTextChanged(CharSequence charSequence, int start, int count, int after) {
        }

        @Override
        public void afterTextChanged(Editable editable) {

            edTextControl = textNbBillets500.getText().toString().trim();

            if(edTextControl.isEmpty() || edTextControl.length() == 0 || edTextControl.equals("") || edTextControl == null || edTextControl.equals("-"))
            {
                //EditText is empty
                _b500= false;     //Permettra de vérifier avant de valider le formulaire
                nbBillets500 = 0;
            }
            else
            {
                if(edTextControl.equals("0")){
                    _b500= false;
                }
                else {
                    nbBillets500 = Integer.parseInt(textNbBillets500.getText().toString());
                    _b500 = true;                     //Condition d'activation du bouton validation
                }
            }
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_billets);
        btnMoinsBillets5 = findViewById(R.id.btn_moins_billet5);
        btnPlusBillets5 = findViewById(R.id.btn_plus_billet5);                  //Initialisation des vues
        textNbBillets5 = findViewById(R.id.text_nb_billets5);
        textNbBillets5.addTextChangedListener(textWatcher5);
        btnMoinsBillets10 = findViewById(R.id.btn_moins_billet10);
        btnPlusBillets10 = findViewById(R.id.btn_plus_billet10);                  //Initialisation des vues
        textNbBillets10 = findViewById(R.id.text_nb_billets10);
        textNbBillets10.addTextChangedListener(textWatcher10);
        btnMoinsBillets20 = findViewById(R.id.btn_moins_billet20);
        btnPlusBillets20 = findViewById(R.id.btn_plus_billet20);                  //Initialisation des vues
        textNbBillets20 = findViewById(R.id.text_nb_billets20);
        textNbBillets20.addTextChangedListener(textWatcher20);
        btnMoinsBillets50 = findViewById(R.id.btn_moins_billet50);
        btnPlusBillets50 = findViewById(R.id.btn_plus_billet50);                  //Initialisation des vues
        textNbBillets50 = findViewById(R.id.text_nb_billets50);
        textNbBillets50.addTextChangedListener(textWatcher50);
        btnMoinsBillets100 = findViewById(R.id.btn_moins_billet100);
        btnPlusBillets100 = findViewById(R.id.btn_plus_billet100);                  //Initialisation des vues
        textNbBillets100 = findViewById(R.id.text_nb_billets100);
        textNbBillets100.addTextChangedListener(textWatcher100);
        btnMoinsBillets200 = findViewById(R.id.btn_moins_billet200);
        btnPlusBillets200 = findViewById(R.id.btn_plus_billet200);                  //Initialisation des vues
        textNbBillets200 = findViewById(R.id.text_nb_billets200);
        textNbBillets200.addTextChangedListener(textWatcher200);
        btnMoinsBillets500 = findViewById(R.id.btn_moins_billet500);
        btnPlusBillets500 = findViewById(R.id.btn_plus_billet500);                  //Initialisation des vues
        textNbBillets500 = findViewById(R.id.text_nb_billets500);
        textNbBillets500.addTextChangedListener(textWatcher500);
        btnValidationAddBillets = findViewById(R.id.btn_validation_add_billets);

        textNbBillets5.setFilters(new InputFilter[]{ new InputFilterMinMax("-"+nbBillets5In, "999")});
        textNbBillets10.setFilters(new InputFilter[]{ new InputFilterMinMax("-"+nbBillets10In, "999")});
        textNbBillets20.setFilters(new InputFilter[]{ new InputFilterMinMax("-"+nbBillets20In, "999")});
        textNbBillets50.setFilters(new InputFilter[]{ new InputFilterMinMax("-"+nbBillets50In, "999")});
        textNbBillets100.setFilters(new InputFilter[]{ new InputFilterMinMax("-"+nbBillets100In, "999")});
        textNbBillets200.setFilters(new InputFilter[]{ new InputFilterMinMax("-"+nbBillets200In, "999")});
        textNbBillets500.setFilters(new InputFilter[]{ new InputFilterMinMax("-"+nbBillets500In, "999")});

        btnMoinsBillets5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nbBillets5 --;                                                     //Clic sur les boutons + ou -
                textNbBillets5.setText(String.valueOf(nbBillets5));
            }
        });

        btnPlusBillets5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nbBillets5 ++;
                textNbBillets5.setText(String.valueOf(nbBillets5));
            }
        });

        btnMoinsBillets10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nbBillets10 --;                                                     //Clic sur les boutons + ou -
                textNbBillets10.setText(String.valueOf(nbBillets10));
            }
        });

        btnPlusBillets10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nbBillets10 ++;
                textNbBillets10.setText(String.valueOf(nbBillets10));
            }
        });

        btnMoinsBillets20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nbBillets20 --;                                                     //Clic sur les boutons + ou -
                textNbBillets20.setText(String.valueOf(nbBillets20));
            }
        });

        btnPlusBillets20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nbBillets20 ++;
                textNbBillets20.setText(String.valueOf(nbBillets20));
            }
        });

        btnMoinsBillets50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nbBillets50 --;                                                     //Clic sur les boutons + ou -
                textNbBillets50.setText(String.valueOf(nbBillets50));
            }
        });

        btnPlusBillets50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nbBillets50 ++;
                textNbBillets50.setText(String.valueOf(nbBillets50));
            }
        });

        btnMoinsBillets100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nbBillets100 --;                                                     //Clic sur les boutons + ou -
                textNbBillets100.setText(String.valueOf(nbBillets100));
            }
        });

        btnPlusBillets100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nbBillets100 ++;
                textNbBillets100.setText(String.valueOf(nbBillets100));
            }
        });

        btnMoinsBillets200.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nbBillets200 --;                                                     //Clic sur les boutons + ou -
                textNbBillets200.setText(String.valueOf(nbBillets200));
            }
        });

        btnPlusBillets200.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nbBillets200 ++;
                textNbBillets200.setText(String.valueOf(nbBillets200));
            }
        });

        btnMoinsBillets500.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nbBillets500 --;                                                     //Clic sur les boutons + ou -
                textNbBillets500.setText(String.valueOf(nbBillets500));
            }
        });

        btnPlusBillets500.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nbBillets500 ++;
                textNbBillets500.setText(String.valueOf(nbBillets500));
            }
        });


        btnValidationAddBillets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(_b5 || _b10 || _b20 || _b50 || _b100 || _b200 || _b500)
                {       // Validation

                    Intent intent = new Intent(ActivityAddBillets.this, ActivityRecapAddBillets.class);
                    intent.putExtra("nbBillets5", nbBillets5);
                    intent.putExtra("nbBillets10", nbBillets10);
                    intent.putExtra("nbBillets20", nbBillets20);
                    intent.putExtra("nbBillets50", nbBillets50);
                    intent.putExtra("nbBillets100", nbBillets100);
                    intent.putExtra("nbBillets200", nbBillets200);
                    intent.putExtra("nbBillets500", nbBillets500);

//Enregistrer les données

                    startActivity(intent);
                }
                else {      //Champs manquants
                    Toast.makeText(ActivityAddBillets.this,"Champs manquants",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}
