package com.cts.mobilebankingdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.cts.mobilebankingdemo.service.BankingApplication;

public class BankingActivity extends AppCompatActivity {
    private Button bViewBalance;
    private Button bTransferBalance;
    private TextView tRegisterBAuth;
    private TextView tLogout;
    private TextView tUserName;
    private String userName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banking);
        bViewBalance = (Button) findViewById(R.id.mViewBalanceBtn);
        bTransferBalance =(Button) findViewById(R.id.mTransferBtn);
        tRegisterBAuth = (TextView) findViewById(R.id.mRegAuthBTxt);
        tLogout = (TextView) findViewById(R.id.mLogOutTxt2);
        userName=((BankingApplication)getApplicationContext()).getUserName();
        tUserName=(TextView)findViewById(R.id.mUserNameTxt);
        tUserName.setText(userName);
        tLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginIntent = new Intent(BankingActivity.this, LoginActivity.class);
                BankingActivity.this.startActivity(loginIntent);
            }
        });

        bTransferBalance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent transferBalanceIntent = new Intent(BankingActivity.this, BalanceTransferActivity.class);
                BankingActivity.this.startActivity(transferBalanceIntent);
            }
        });
        bViewBalance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent transferBalanceIntent = new Intent(BankingActivity.this, BalanceTransferActivity.class);
                BankingActivity.this.startActivity(transferBalanceIntent);*/
            }
        });
        tRegisterBAuth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent transferBalanceIntent = new Intent(BankingActivity.this, BalanceTransferActivity.class);
                BankingActivity.this.startActivity(transferBalanceIntent);*/
            }
        });
    }
}
