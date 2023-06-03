package uk.ac.tees.scdt.mad.w9544759.ReddyWeatherApp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPasswordActivity extends AppCompatActivity {

    private Button btnSubmitForgotPassword;
    private EditText edtEmailForgotPassword;
    private TextView textForgotPasswordLoginPage;

    FirebaseAuth auth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        btnSubmitForgotPassword = findViewById(R.id.editForgotPasswordButton);
        edtEmailForgotPassword = findViewById(R.id.editForgotPasswordEmail);

        btnSubmitForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailPassword = edtEmailForgotPassword.getText().toString().trim();
                if(!emailPassword.equals(""))
                {
                    passwordReset(emailPassword);
                }
            }
        });

        auth = FirebaseAuth.getInstance();


        textForgotPasswordLoginPage = findViewById(R.id.textForgotPasswordLoginPage);
        textForgotPasswordLoginPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent(ForgotPasswordActivity.this,LoginActivity.class));
            }
        });

    }

    public void passwordReset(String email)
    {
        auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText( ForgotPasswordActivity.this, "Please check your email.", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText( ForgotPasswordActivity.this, "There is a problem.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}