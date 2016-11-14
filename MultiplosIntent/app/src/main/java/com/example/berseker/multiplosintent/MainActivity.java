package com.example.berseker.multiplosintent;

import android.app.IntentService;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private EditText envianum,recibenum;
    private Button go;
    public int vec1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     envianum=(EditText)findViewById(R.id.envianum);
     recibenum=(EditText)findViewById(R.id.recibenum);
     go=(Button)findViewById(R.id.go);


        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String vec=envianum.getText().toString();
                vec1=Integer.parseInt(vec);

                Intent dato = new Intent(MainActivity.this,Myintento.class);
                 dato.putExtra("valor",vec1);
                 startService(dato);



            }
        });

        IntentFilter filter = new IntentFilter();
        filter.addAction(Myintento.ACTION_UNO);
        ProgresReceiver rcv = new ProgresReceiver();
        registerReceiver(rcv,filter);







    }


    public class ProgresReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(Myintento.ACTION_UNO)) {


                int prog = intent.getIntExtra("envio",0);
                recibenum.setText(prog+"\n"+recibenum.getText().toString());

            }


        }
    }

}
