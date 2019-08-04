package iam.sci.convoiturage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import androidx.appcompat.app.AppCompatActivity;


public class AccederActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceder);



        /////////////////inscrir

        Button signin = findViewById(R.id.buttoninscrire);
        signin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Clicked Signin", Toast.LENGTH_SHORT).show();
                Intent myIntent = new Intent(getBaseContext(), choixActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });



        ////pour le bouton connecter

        Button sing = (Button) findViewById(R.id.buttoncon);
        sing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Clicked connected", Toast.LENGTH_SHORT).show();
                Intent myIntent = new Intent(getBaseContext(), profil_de_passagerActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });


    }
}
