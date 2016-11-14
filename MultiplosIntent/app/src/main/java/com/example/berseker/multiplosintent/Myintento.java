package com.example.berseker.multiplosintent;

import android.app.IntentService;
import android.content.Intent;

/**
 * Created by berseker on 11/9/2016.
 */

public class Myintento extends IntentService {
public static final String ACTION_UNO="com.example.intent.action.UNO";


    public Myintento() {
        super("Myintento");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

    int ter = intent.getIntExtra("valor",0);
      for(int i=1;i<ter;i++){

       if(esMultiplo(ter,i)){
           Intent trans =new Intent();
           trans.setAction(ACTION_UNO);
           trans.putExtra("envio",+i);
       sendBroadcast(trans);
       }

      }


    }

    public static boolean esMultiplo(int n1,int n2){
        if (n1%n2==0)
            return true;
        else
            return false;
    }
}



