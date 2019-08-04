package iam.sci.convoiturage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class profil_de_passagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_de_passager);
        Button a = (Button) findViewById(R.id.button9);
        Button b = (Button) findViewById(R.id.button10);
        Button c = (Button) findViewById(R.id.button11);


         Button d = (Button) findViewById(R.id.button11);
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "clicked", Toast.LENGTH_SHORT).show();
                Intent p = new Intent(getBaseContext(), profil_de_conducteurActivity.class);
                startActivity(p);
            }
        });


   Button e=(Button)findViewById(R.id.button9);
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"clicked",Toast.LENGTH_SHORT).show();
                Intent p=new Intent(getBaseContext(), profil_de_conducteurActivity.class);
                startActivity(p);
            }
        });

        Button f=(Button)findViewById(R.id.button10);
        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
      Toast.makeText(getApplicationContext(),"clicked",Toast.LENGTH_SHORT).show();
       Intent p=new Intent(getBaseContext(), profil_de_conducteurActivity.class);
       startActivity(p);
            }

        });
    }
}
