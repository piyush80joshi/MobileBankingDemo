package com.cts.mobilebankingdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;

public class BalanceTransferActivity extends AppCompatActivity {
    private Spinner acctFromSpn ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balance_transfer);
        acctFromSpn = (Spinner)findViewById(R.id.mActFromSpn);

    }

}
