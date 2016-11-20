package com.cts.mobilebankingdemo.service;

import android.app.Application;

/**
 * Created by piyush on 11/19/2016.
 */

public class BankingApplication extends Application {


    String userName;
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
