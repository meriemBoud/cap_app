package iam.sci.convoiturage;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class profil_de_conducteurActivity extends AppCompatActivity {
    private Button publier,consulter,verifier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_de_conducteur);
        Button publier=(Button)findViewById(R.id.publier);
        Button consulter=(Button)findViewById(R.id.consulter);
        Button verifier=(Button)findViewById(R.id.verifier);

        publier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(profil_de_conducteurActivity.this,publier_trajetActivity.class);
                startActivity(intent);
                finish();
                return;
            }
        });

        consulter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        verifier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}
