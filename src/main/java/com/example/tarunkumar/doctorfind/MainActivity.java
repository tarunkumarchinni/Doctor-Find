package com.example.tarunkumar.doctorfind;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button bt1,bt2,bt3;
    EditText user;
    EditText pas;
    TextView tv_use;
    String usn,passwo,depart,record_id;
    Context ctx=this;
    int x1,x2,x3,x4;
    public static final String MyPREFERENCES = "MyPrefs" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user=(EditText)findViewById(R.id.et_username);
        pas=(EditText)findViewById(R.id.et_pass);
        bt1=(Button)findViewById(R.id.bt);
        bt2=(Button)findViewById(R.id.bt_signup);
        bt3=(Button)findViewById(R.id.bt_docsign);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usn=user.getText().toString();
                passwo=pas.getText().toString();
                x1=user.length();
                x2=pas.length();

                if(x1==0){
                    Toast.makeText(getBaseContext(),"please enter valid username..",Toast.LENGTH_LONG).show();
                    user.setHintTextColor(Color.RED);
                    user.setHint("username");

                }
                else if(x2==0){
                    Toast.makeText(getBaseContext(),"please enter valid password..",Toast.LENGTH_LONG).show();
                    pas.setHintTextColor(Color.RED);
                    pas.setHint("password");


                }
                else {


                    // System.out.println("username is  :"+usn);
                    //Toast.makeText(getBaseContext(), user.getText().toString(), Toast.LENGTH_LONG).show();
                    //Toast.makeText(getBaseContext(), "please wait....", Toast.LENGTH_LONG).show();

                    tv_use = (TextView) findViewById(R.id.tv_username);
                    // tv_use.setText("Username is:  "+usn+"\npassword is:  "+passwo);
                    Dataoperations dop = new Dataoperations(ctx);
                    Cursor cr = dop.getinfo(dop);
                    cr.moveToFirst();
                    boolean loginstatus = false;
                    String Name = "";
                    String pass = "";
                    String dept = "";
                    do {
                        if (usn.equals(cr.getString(0)) && passwo.equals(cr.getString(1))) {

                            loginstatus = true;
                            Name = cr.getString(0);
                            pass = cr.getString(1);
                            //  dept = cr.getString(2);

                            if (cr.getString(2).equals("null")) {
                                record_id = cr.getString(3);

                                //Toast.makeText(getBaseContext(), "login sucess...", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(MainActivity.this, search.class);//Login1Activity
                                Bundle bn = new Bundle();
                                bn.putString("user_name", Name);
                                bn.putString("user_pass", pass);
                                bn.putString("record_id", record_id);
                                intent.putExtras(bn);
                                startActivity(intent);


                                finish();
                            } else {
                                record_id = cr.getString(3);

                                //Toast.makeText(getBaseContext(), "login sucess...", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(MainActivity.this, doctor_profile.class);//doclogin.class
                                Bundle bn = new Bundle();
                                bn.putString("user_name", Name);
                                bn.putString("user_pass", pass);
                                bn.putString("record_id", record_id);
                                intent.putExtras(bn);
                                startActivity(intent);


                                finish();

                            }

                        }
                    } while (cr.moveToNext());
                    if (loginstatus == true) {
                        Toast.makeText(getBaseContext(), "login sucess...", Toast.LENGTH_LONG).show();
                        finish();

                    } else {
                        Toast.makeText(getBaseContext(),"please enter valid details..",Toast.LENGTH_LONG).show();
                        Toast.makeText(getBaseContext(), "login Failed...", Toast.LENGTH_LONG).show();
                        Intent intent1=new Intent(MainActivity.this,MainActivity.class);
                        startActivity(intent1);
                        finish();
                    }

                }
            }


        });

        bt2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(MainActivity.this,signup.class);
                startActivity(intent1);
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(MainActivity.this,docsignup.class);
                startActivity(intent2);
            }
        });
    }
}
