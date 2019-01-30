package com.sup.administrator.movie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText e1,e2,e3,e4,e5,e6,e7,e8;
    Button b;
    String s1,s2,s3,s4,s5,s6,s7,s8;
    moviedb mo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=(EditText)findViewById(R.id.name);
        e2=(EditText)findViewById(R.id.act);
        e3=(EditText)findViewById(R.id.acts);
        e4=(EditText)findViewById(R.id.ry);
        e5=(EditText)findViewById(R.id.dir);
        e6=(EditText)findViewById(R.id.pro);
        e7=(EditText)findViewById(R.id.cm);
        e8=(EditText)findViewById(R.id.tc);
       b=(Button) findViewById(R.id.reg);
        mo=new moviedb(this);
        mo.getWritableDatabase();
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1=e1.getText().toString();
                s2=e2.getText().toString();
                s3=e3.getText().toString();
                s4=e4.getText().toString();
                s5=e5.getText().toString();
                s6=e6.getText().toString();
                s7=e7.getText().toString();
                s8=e8.getText().toString();
                Log.d("nam",s1);
                Log.d("act",s2);
                Log.d("acts",s3);
                Log.d("ry",s4);
                Log.d("dir",s5);
                Log.d("pr",s6);
                Log.d("cm",s7);
                Log.d("tc",s8);
                boolean status=mo.insert(s1,s2,s3,s4,s5,s6,s7,s8);
                if(status==true)
                {
                    Toast.makeText(getApplicationContext(),"success",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"err",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
