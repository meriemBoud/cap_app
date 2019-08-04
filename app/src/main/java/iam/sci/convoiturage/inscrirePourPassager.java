package iam.sci.convoiturage;

import android.content.Intent;
/////////:import android.support.v7.app.AppCompatActivity;
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

import static com.google.firebase.auth.FirebaseAuth.*;


/////////////:remplis la formulaire pour le passager
public class inscrirePourPassager extends AppCompatActivity implements TextWatcher {

    private FirebaseAuth.AuthStateListener firebaseAuthListener;
    EditText nomETp=(EditText) findViewById(R.id.et1);
    EditText prenomETp=(EditText) findViewById(R.id.et2);
    EditText datedenaissanceETp=(EditText) findViewById(R.id.et3);
    EditText adresseETp=(EditText) findViewById(R.id.et5);
    EditText telephoneETp=(EditText) findViewById(R.id.et4);
     EditText emailETp=(EditText) findViewById(R.id.et6);
    EditText motdepasseETp=(EditText) findViewById(R.id.et7);


    private FirebaseAuth mAuth;


    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inscrirpourpassager);

        mAuth = getInstance();

        btn=(Button)findViewById(R.id.button5);
        nomETp.addTextChangedListener(this);
        prenomETp.addTextChangedListener(this);
        datedenaissanceETp.addTextChangedListener(this);
        adresseETp.addTextChangedListener(this);
        telephoneETp.addTextChangedListener(this);
        emailETp.addTextChangedListener(this);
        motdepasseETp.addTextChangedListener(this);

        firebaseAuthListener=new FirebaseAuth.AuthStateListener(){

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();
                if(user!=null){
                    Intent intent=new Intent(inscrirePourPassager.this,profil_de_passagerActivity.class);
                    startActivity(intent);
                    finish();
                    return;
                }
            }
        };

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String email= emailETp.getText().toString().trim();
            String password= motdepasseETp.getText().toString().trim();
              mAuth.createUserWithEmailAndPassword(email,password) .addOnCompleteListener(inscrirePourPassager.this, new OnCompleteListener <AuthResult>() {
                  @Override
                  public void onComplete(@NonNull Task<AuthResult> task) {
                     if (!task.isSuccessful()){
                         Toast.makeText(getApplicationContext(), "erreur ", Toast.LENGTH_SHORT).show();
                     }else {
                         String  user_id=mAuth.getCurrentUser().getUid();
                       DatabaseReference current_user_db=FirebaseDatabase.getInstance().getReference().child("utilisatrur").child("passager").child(user_id);
                         current_user_db.setValue(true);
                     }
                  }
              });
            }
        });
            }
    @Override
    public void afterTextChanged(Editable s) {

        if (nomETp.getText().toString().trim().equals("!null")&& prenomETp.getText().toString().trim().equals("!null")
                && datedenaissanceETp.getText().toString().trim().equals("!null")
                && adresseETp.getText().toString().trim().equals("!null")&& telephoneETp.getText().toString().trim().equals("!null")
                && emailETp.getText().toString().trim().equals("!null")
                && motdepasseETp.getText().toString().trim().equals("!null") ){
            btn.isEnabled();
        }

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(firebaseAuthListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mAuth.removeAuthStateListener(firebaseAuthListener);
    }
}

