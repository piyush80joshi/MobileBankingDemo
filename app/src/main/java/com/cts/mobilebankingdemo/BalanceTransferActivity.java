package com.cts.mobilebankingdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.cts.mobilebankingdemo.service.BankingApplication;

import java.util.ArrayList;

public class BalanceTransferActivity extends AppCompatActivity {
    private Spinner acctFromSpn ;
    private Spinner acctToSpn ;
    private TextView tTransferLogOut;
    private TextView tFromAcct;
    private TextView tToAcct;
    private Button bBack;
    private Button bTransferBalance;
    private TextView tUser;
    private String userName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balance_transfer);
        bTransferBalance =(Button) findViewById(R.id.mTransBalBtn);
        tTransferLogOut = (TextView) findViewById(R.id.mLogoutTxt3);
        userName=((BankingApplication)getApplicationContext()).getUserName();
        tUser =(TextView)findViewById(R.id.mUserTxt3);
        tUser.setText(userName);
        tTransferLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginIntent = new Intent(BalanceTransferActivity.this, LoginActivity.class);
                BalanceTransferActivity.this.startActivity(loginIntent);
            }
        });

        bTransferBalance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               //TODO
                /* Intent transferBalanceIntent = new Intent(BankingActivity.this, BalanceTransferActivity.class);
                BankingActivity.this.startActivity(transferBalanceIntent);*/
            }
        });
        //-------------------------
        tFromAcct=(TextView)findViewById(R.id.mAcctFromTxt);
        tToAcct=(TextView)findViewById(R.id.mAcctToTxt);
        ArrayList<String> fromAccountList = new ArrayList<String>();
        fromAccountList.add("Account 1");
        fromAccountList.add("Account 2");
        ArrayAdapter fromAcctAdapter=new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,fromAccountList);

        acctFromSpn = (Spinner)findViewById(R.id.mActFromSpn);
        acctFromSpn.setAdapter(fromAcctAdapter);
        acctFromSpn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getBaseContext(),adapterView.getItemAtPosition(i)+" Selected ",Toast.LENGTH_LONG);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayList<String> toAccountList = new ArrayList<String>();
        toAccountList.add("To Account 1");
        toAccountList.add("To Account 2");
        ArrayAdapter toAcctAdapter=new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,toAccountList);
        acctToSpn = (Spinner)findViewById(R.id.mAcctToSpn);
        acctToSpn.setAdapter(toAcctAdapter);
        acctToSpn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getBaseContext(),adapterView.getItemAtPosition(i)+" Selected ",Toast.LENGTH_LONG);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

}
