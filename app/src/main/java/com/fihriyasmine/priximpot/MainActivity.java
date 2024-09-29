package com.fihriyasmine.priximpot;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String nom;
    private String adresse;
    private double surface;
    private int nbrPieces;
    private boolean piscine;
    private TextView impotBase;
    private TextView impotSupp;
    private TextView impotTotal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        EditText inputNom = findViewById(R.id.inputNom);
        EditText inputAdresse = findViewById(R.id.inputAdresse);
        EditText inputSurface = findViewById(R.id.inputSurface);
        EditText inputNbrPieces = findViewById(R.id.inputNbrPieces);
        CheckBox checkBoxPiscine = findViewById(R.id.checkBox);
        impotBase = findViewById(R.id.impotBase);
        impotSupp = findViewById(R.id.impotSupp);
        impotTotal = findViewById(R.id.impotTotal);

        Button calculer = findViewById(R.id.btnCalcul);
        Button reinitialiser = findViewById(R.id.btnReinitialiser);

        calculer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    nom = inputNom.getText().toString();
                    adresse = inputAdresse.getText().toString();
                    surface = Double.parseDouble(inputSurface.getText().toString());
                    nbrPieces = Integer.parseInt(inputNbrPieces.getText().toString());
                    piscine = checkBoxPiscine.isChecked();

                    double clcimpotBase = surface * 2;
                    double clcimpotSupp = nbrPieces * 50 + (piscine ? 100 : 0);
                    double clcimpotTotal = clcimpotBase + clcimpotSupp;

                    impotBase.setText("Impôt de base : " + clcimpotBase );
                    impotSupp.setText("Impôt supplémentaire : " + clcimpotSupp );
                    impotTotal.setText("Total des impôts : " + clcimpotTotal );
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Veuillez entrer des valeurs valides.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        reinitialiser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                inputNom.setText("");
                inputAdresse.setText("");
                inputSurface.setText("");
                inputNbrPieces.setText("");
                checkBoxPiscine.setChecked(false);
                impotBase.setText("Impôt de base : ");
                impotSupp.setText("Impôt supplémentaire : ");
                impotTotal.setText("Total des impôts : ");
            }
        });
    }
}
