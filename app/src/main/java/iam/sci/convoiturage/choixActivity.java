package iam.sci.convoiturage;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import java.sql.SQLTransactionRollbackException;
import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;


public class choixActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix);
        Button conducteur=(Button)findViewById(R.id.conducteur);
        Button passager=(Button)findViewById(R.id.passager);

        conducteur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(choixActivity.this,"clicked",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(choixActivity.this,inscrirePourConducteur.class);
                startActivity(intent);
            }
        });
        passager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(choixActivity.this,"clicked",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(choixActivity.this,inscrirePourPassager.class);
                startActivity(intent);
            }
        });
    }
}
