package iam.sci.convoiturage;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


/////////////:remplis la formulaire de conducteur
public class inscrirePourConducteur extends AppCompatActivity implements TextWatcher {

    //private FirebaseAuth.AuthStateListener firebaseAuthListener;
    EditText nomET=(EditText) findViewById(R.id.e8);
    EditText prenomET=(EditText) findViewById(R.id.e1);
    EditText datedenaissanceET=(EditText) findViewById(R.id.e2);
    EditText adresseET=(EditText) findViewById(R.id.e4);
    EditText telephoneET=(EditText) findViewById(R.id.e3);
    EditText emailET=(EditText) findViewById(R.id.e5);
    EditText categoriedepermisET=(EditText) findViewById(R.id.e6);
    EditText motdepasseET=(EditText) findViewById(R.id.e7);
    Button btn;
   // private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inscrirepourconducteur);

       // mAuth=FirebaseAuth.getInstance();

        btn = (Button) findViewById(R.id.button5);
        nomET.addTextChangedListener(this);
        prenomET.addTextChangedListener(this);
        datedenaissanceET.addTextChangedListener(this);
        adresseET.addTextChangedListener(this);
        telephoneET.addTextChangedListener(this);
        emailET.addTextChangedListener(this);
        categoriedepermisET.addTextChangedListener(this);
        motdepasseET.addTextChangedListener(this);

        final String email=emailET.getText().toString().trim();
        final String password=motdepasseET.getText().toString().trim();
       /* firebaseAuthListener=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();
                if(user!=null){
                    Intent intent=new Intent(inscrirePourConducteur.this,profil_de_conducteurActivity.class);
                    startActivity(intent);
                    finish();
                    return;
                }
            }
        };
       */

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                ///creer nouveau utilisateur
               /* mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(inscrirePourConducteur.this, new OnCompleteListener <AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(!task.isSuccessful()){
                            Toast.makeText(inscrirePourConducteur.this,"sign up error",Toast.LENGTH_SHORT).show();
                        }else{
                            String user_id=mAuth.getCurrentUser().getUid();
                            DatabaseReference current_user_db= FirebaseDatabase.getInstance().getReference().child("utilisateur").child("conducteur");
                            current_user_db.setValue(true);
                        }


                    }
                });
                */
            }
        });

    }


    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (nomET.getText().toString().trim().equals("!null")&& prenomET.getText().toString().trim().equals("!null")
                && datedenaissanceET.getText().toString().trim().equals("!null")
                && adresseET.getText().toString().trim().equals("!null")
                && telephoneET.getText().toString().trim().equals("!null")&& emailET.getText().toString().trim().equals("!null")
                && motdepasseET.getText().toString().trim().equals("!null") && categoriedepermisET.getText().toString().trim().equals("!null") ){
            btn.isEnabled();
        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    protected void onStart() {
        super.onStart();
       // mAuth.addAuthStateListener(firebaseAuthListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        //mAuth.removeAuthStateListener(firebaseAuthListener);
    }
}
