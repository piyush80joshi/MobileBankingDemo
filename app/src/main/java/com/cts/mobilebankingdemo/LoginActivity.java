package com.cts.mobilebankingdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.cts.mobilebankingdemo.service.BankingApplication;

import static android.view.View.*;

public class LoginActivity extends AppCompatActivity {
    private EditText eUserName;
    private EditText ePassword;
    private Button bLogin;
    private TextView tRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
         eUserName= (EditText) findViewById(R.id.mUserNameTxt);
         ePassword= (EditText) findViewById(R.id.mPassworTxt);
         bLogin= (Button) findViewById(R.id.mLoginBtn);
         tRegister = (TextView) findViewById(R.id.mRegAuthTxt);

        bLogin.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view) {
                String userName=eUserName.getText().toString();
                String password=ePassword.getText().toString();
                boolean success= login(userName,password);
                if(success) {
                    Intent bankingIntent = new Intent(LoginActivity.this, BankingActivity.class);
                    LoginActivity.this.startActivity(bankingIntent);
                }

            }
        });

        tRegister.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO
            }
        });
    }

    private boolean login(String userName, String password) {
        if(isValidUserName(userName)) {
            if(isValidPassword(password)){
                ((BankingApplication)getApplicationContext()).setUserName(userName);
                return true;
            }else {
                ePassword.setError(getString(R.string.error_incorrect_password));
                ePassword.requestFocus();
                return false;
            }
        }  else {
            eUserName.setError(getString(R.string.error_invalid_username));
            eUserName.requestFocus();
            return false; }
    }

    private boolean isValidUserName(String userName) {
        if(userName.equalsIgnoreCase("piyush"))
            return true;
        else
            return false;
    }

    private boolean isValidPassword(String password) {
        if(password.equalsIgnoreCase("piyush"))

            return true;
        else
            return false;
    }
}
