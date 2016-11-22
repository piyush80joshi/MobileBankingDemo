package com.cts.mobilebankingdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.cts.mobilebankingdemo.service.BankingApplication;

import java.util.ArrayList;

public class BalanceTransferActivity extends AppCompatActivity {
    private Spinner acctFromSpn;
    private Spinner acctToSpn;
    private TextView tTransferLogOut;
    private TextView tFromAcct;
    private TextView tToAcct;
    private Button bCancel;
    private Button bTransferBalance;
    private TextView tUser;
    private String userName;
    private EditText eAmount;
    private String selectedFromAccount;
    private String selectedToAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balance_transfer);
        eAmount = (EditText) findViewById(R.id.mAmountTxt);
        bTransferBalance = (Button) findViewById(R.id.mTransBalBtn);
        tTransferLogOut = (TextView) findViewById(R.id.mLogoutTxt3);
        userName = ((BankingApplication) getApplicationContext()).getUserName();
        tUser = (TextView) findViewById(R.id.mUserTxt3);
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
                transferBalance();
            }
        });

        bCancel = (Button) findViewById(R.id.mbackBtn);
        bCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bankingIntent = new Intent(BalanceTransferActivity.this, BankingActivity.class);
                BalanceTransferActivity.this.startActivity(bankingIntent);
            }
        });
        //-------------------------
        tFromAcct = (TextView) findViewById(R.id.mAcctFromTxt);
        tToAcct = (TextView) findViewById(R.id.mAcctToTxt);
        ArrayList<String> fromAccountList = getFromAccountList();
        ArrayAdapter fromAcctAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, fromAccountList);

        acctFromSpn = (Spinner) findViewById(R.id.mActFromSpn);
        acctFromSpn.setAdapter(fromAcctAdapter);
        acctFromSpn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedFromAccount = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayList<String> toAccountList = getToAccountList();
        ArrayAdapter toAcctAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, toAccountList);
        acctToSpn = (Spinner) findViewById(R.id.mAcctToSpn);
        acctToSpn.setAdapter(toAcctAdapter);
        acctToSpn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedToAccount = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private ArrayList<String> getToAccountList() {
        ArrayList toAccountList = new ArrayList<String>();
        toAccountList.add("Ritam.B");
        toAccountList.add("Mani");
        return toAccountList;
    }

    private ArrayList<String> getFromAccountList() {
        ArrayList fromAccountList = new ArrayList<String>();
        fromAccountList.add(userName);

        return fromAccountList;
    }

    private void transferBalance() {
        //TODO

        String toastString = "Amount $" + eAmount.getText().toString() + " transferred from Account " + selectedFromAccount + " to Account " + selectedToAccount + " .";
        Toast.makeText(getBaseContext(), toastString, Toast.LENGTH_LONG).show();
    }


}
