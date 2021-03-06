package com.sup.administrator.movie;

import android.content.DialogInterface;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class movie extends AppCompatActivity {
EditText e,a1,a2,a3,a4,a5,a6,a7;
    TextView t1,t2,t3,t4,t5,t6,t7;
    Button b,b1,b2;
    String s,s1,s2,s3,s4,s5,s6,s7,u1,u2,u3,u4,u5,u6,u7,getid;
    AlertDialog.Builder build;

    moviedb m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        e=(EditText)findViewById(R.id.mov);
       a1=(EditText)findViewById(R.id.a1);
        a2=(EditText)findViewById(R.id.a2);
        a3=(EditText)findViewById(R.id.a3);
        a4=(EditText)findViewById(R.id.a4);
        a5=(EditText)findViewById(R.id.a5);
        a6=(EditText)findViewById(R.id.a6);
        a7=(EditText)findViewById(R.id.a7);
        t1=(TextView)findViewById(R.id.t1);
        t2=(TextView)findViewById(R.id.t2);
        t3=(TextView)findViewById(R.id.t3);
        t4=(TextView)findViewById(R.id.t4);
        t5=(TextView)findViewById(R.id.t5);
        t6=(TextView)findViewById(R.id.t6);
        t7=(TextView)findViewById(R.id.t7);
        b1=(Button)findViewById(R.id.update) ;
        b2=(Button)findViewById(R.id.delete) ;
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                boolean status=m.delete(getid);
//                if(status==true)
//                {
//                    Toast.makeText(getApplicationContext(),"deleted succesfully",Toast.LENGTH_LONG).show();
//                }
//                else
//                {
//                    Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_LONG).show();
//
//                }
                AlertDialog alert=build.create();
                alert.show();
            }
        });

        build=new AlertDialog.Builder(this);
        build.setTitle("confirm");
        build.setMessage("Are you sure want to delete");
        build.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),"Yes clicked",Toast.LENGTH_LONG).show();
                dialogInterface.dismiss();
                boolean status=m.delete(getid);
                if(status==true)
                {
                    Toast.makeText(getApplicationContext(),"deleted succesfully",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_LONG).show();

                }
            }
        });
        build.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),"no clicked",Toast.LENGTH_LONG).show();
                dialogInterface.dismiss();
            }
        });




        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              u1=a1.getText().toString();
                u2=a2.getText().toString();
                u3=a3.getText().toString();
                u4=a4.getText().toString();
                u5=a5.getText().toString();
                u6=a6.getText().toString();
                u7=a7.getText().toString();
//                Toast.makeText(getApplicationContext(),u1,Toast.LENGTH_LONG).show();

                boolean result=m.update(getid,u1,u2,u3,u4,u5,u6,u7);
                if (result==true)
                {
                    Toast.makeText(getApplicationContext(),"updated",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_LONG).show();

                }





            }
        });


        b=(Button)findViewById(R.id.se);
        m=new moviedb(this);
        m.getWritableDatabase();

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s=e.getText().toString();
                Log.d("name",s);
                Cursor cur=m.search(s);
                if(cur.getCount()==0)
                {
                    Toast.makeText(getApplicationContext(),"no data",Toast.LENGTH_LONG).show();
                }
                else
                {
                    while (cur.moveToNext())
                    {
                        s1=cur.getString(2);
                        s2=cur.getString(3);
                        s3=cur.getString(4);
                        s4=cur.getString(5);
                        s5=cur.getString(6);
                        s6=cur.getString(7);
                        s7=cur.getString(8);
                        t1.setVisibility(View.VISIBLE);
                        a1.setVisibility(View.VISIBLE);
                        a1.setText(s1);
                        t2.setVisibility(View.VISIBLE);
                        a2.setVisibility(View.VISIBLE);
                        a2.setText(s2);
                        t3.setVisibility(View.VISIBLE);
                        a3.setVisibility(View.VISIBLE);
                        a3.setText(s3);
                        t4.setVisibility(View.VISIBLE);
                        a4.setVisibility(View.VISIBLE);
                        a4.setText(s4);
                        t5.setVisibility(View.VISIBLE);
                        a5.setVisibility(View.VISIBLE);
                        a5.setText(s5);
                        t6.setVisibility(View.VISIBLE);
                        a6.setVisibility(View.VISIBLE);
                        a6.setText(s6);
                        t7.setVisibility(View.VISIBLE);
                        a7.setVisibility(View.VISIBLE);
                        a7.setText(s7);
                        getid=cur.getString(0);
                        Toast.makeText(getApplicationContext(),getid,Toast.LENGTH_LONG).show();
                       b1.setVisibility(View.VISIBLE);
                        b2.setVisibility(View.VISIBLE);


//                        Toast.makeText(getApplicationContext(),s1,Toast.LENGTH_LONG).show();
                    }

                }
            }
        });


    }
}
