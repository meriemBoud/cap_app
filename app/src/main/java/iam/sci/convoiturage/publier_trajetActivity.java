package iam.sci.convoiturage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class publier_trajetActivity extends AppCompatActivity implements TextWatcher {
    FirebaseDatabase database=FirebaseDatabase.getInstance();


    final   EditText distination =(EditText)findViewById(R.id.distinaion);
    final EditText depart =(EditText)findViewById(R.id.depart);
    final EditText arriver =(EditText)findViewById(R.id.arriver);
    final EditText place =(EditText)findViewById(R.id.place);
    final EditText durée =(EditText)findViewById(R.id.durée);
    final EditText date =(EditText)findViewById(R.id.date);
    final EditText prix =(EditText)findViewById(R.id.prix);
    final EditText conditions =(EditText)findViewById(R.id.condition);
    final Button publier=(Button)findViewById(R.id.publier);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publier_trajet);

        distination.addTextChangedListener(this);
        depart.addTextChangedListener(this);
        arriver.addTextChangedListener(this);
        place.addTextChangedListener(this);
        durée.addTextChangedListener(this);
        date.addTextChangedListener(this);
        prix.addTextChangedListener(this);
        conditions.addTextChangedListener(this);





        publier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference myRef1 = database.getReference("distination");
                DatabaseReference myRef2 = database.getReference("la ville de départ");
                DatabaseReference myRef3 = database.getReference("La ville d'arriver");
                DatabaseReference myRef4 = database.getReference("Le nombre de places disponible");
                DatabaseReference myRef5 = database.getReference("La durée ou la distance");
                DatabaseReference myRef6 = database.getReference("date");
                DatabaseReference myRef7 = database.getReference("Prix");
                DatabaseReference myRef8 = database.getReference("Les conditions");

                myRef1.setValue(distination);
                myRef2.setValue(depart);
                myRef3.setValue(arriver);
                myRef4.setValue(place);
                myRef5.setValue(durée);
                myRef6.setValue(date);
                myRef7.setValue(prix);
                myRef8.setValue(conditions);
            }
        });




    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
       if (distination.getText().toString().trim().equals("!null")&& depart.getText().toString().trim().equals("!null")
          &&arriver.getText().toString().trim().equals("!null")
          && place.getText().toString().trim().equals("!null")&&durée.getText().toString().trim().equals("!null")
          && date.getText().toString().trim().equals("!null")
          && prix.getText().toString().trim().equals("!null")&& conditions.getText().toString().trim().equals("!null")){

           publier.isEnabled();
       }

    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
