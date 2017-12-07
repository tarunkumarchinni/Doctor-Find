package com.example.tarunkumar.doctorfind;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tarunkumar.doctorfind.R;

public class search extends AppCompatActivity {
    String user_name, user_pass, record_id;
    Button btv1,btv2,btv3,btv4,btv5,btv6,btv7,btv8,btv9,btv10,btv11,btv12,log;
    TextView tv;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Bundle bn = getIntent().getExtras();
        user_name = bn.getString("user_name");
        user_pass = bn.getString("user_pass");
        record_id = bn.getString("record_id");
       //  toolbar = (Toolbar) findViewById(R.id.toolbar);
        //  setSupportActionBar(toolbar);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        actionBarDrawerToggle=new ActionBarDrawerToggle(this, drawerLayout,R.string.drawer_open,R.string.drawer_close);
       // drawerLayout.setDrawerListener(actionBarDrawerToggle);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        navigationview=(NavigationView)findViewById(R.id.navigation_view);
        navigationview.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                if(item.isChecked()){
                    item.setChecked(false);

                }
                else {
                    item.setChecked(true);
                }
                    setTitle(item.getTitle());
                    drawerLayout.closeDrawers();
                    if(item.getItemId()==R.id.home_id){
                        Intent intent = new Intent(search.this, search.class);
                        Bundle bn = new Bundle();
                        bn.putString("user_name",user_name);
                        bn.putString("user_pass",user_pass);
                        bn.putString("record_id", record_id);
                        intent.putExtras(bn);
                        startActivity(intent);

                    }
                    else if(item.getItemId()==R.id.id_profile){
                        Intent in = new Intent(search.this, patients_profile.class);
                        Bundle bn1 = new Bundle();
                        bn1.putString("user_name",user_name);
                        bn1.putString("user_pass",user_pass);
                        bn1.putString("record_id", record_id);
                        in.putExtras(bn1);
                        startActivity(in);

                }
                else{
                        SharedPreferences sharedpreferences = getSharedPreferences(MainActivity.MyPREFERENCES, Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedpreferences.edit();
                        editor.clear();
                        editor.commit();
                        finish();
                        Intent in = new Intent(search.this, MainActivity.class);
                        startActivity(in);
                    }
                    /*switch (item.getItemId()) {
                        case R.id.home_id:
                            Intent intent = new Intent(search.this, search.class);
                            startActivity(intent);
                        case R.id.id_profile:
                            Intent in = new Intent(search.this, edit.class);
                            startActivity(in);
                        case R.id.logout_id:
                            Intent inte = new Intent(search.this, MainActivity.class);
                            startActivity(inte);

                    }*/

                return true;
            }
        });

        tv = (TextView) findViewById(R.id.textView);
       // tv.setText("user:" + user_name + "\n pass" + user_pass + "\nrecordid: " + record_id);
        btv1 = (Button) findViewById(R.id.bt1);
      // btv2 = (Button) findViewById(R.id.bt2);
        btv3 = (Button) findViewById(R.id.bt3);
        btv4 = (Button) findViewById(R.id.bt4);
      //  btv5 = (Button) findViewById(R.id.bt5);
        btv6 = (Button) findViewById(R.id.bt6);
        btv7 = (Button) findViewById(R.id.bt7);
        btv8 = (Button) findViewById(R.id.bt8);
     //   btv9 = (Button) findViewById(R.id.bt9);
        btv10 = (Button) findViewById(R.id.bt10);
        btv11 = (Button) findViewById(R.id.bt11);
      //  btv12 = (Button) findViewById(R.id.bt12);
       // log=(Button)findViewById(R.id.logout);


      /*  bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String s1="dental";
                Intent intent=new Intent(search.this,list.class);
                Bundle bn = new Bundle();
                bn.putString("user_name", user_name);
                bn.putString("user_pass", user_pass);
                bn.putString("record_id", record_id);
                bn.putString("s1", s1);
                intent.putExtras(bn);
                startActivity(intent);
                finish();
            }
        });
    }*/


      btv1.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              String department_of="Anesthesia";
              Intent intent=new Intent(search.this,list.class);
              Bundle bn = new Bundle();
              bn.putString("user_name",user_name);
              bn.putString("user_pass",user_pass);
              bn.putString("record_id", record_id);
              bn.putString("department_of",department_of);
              intent.putExtras(bn);
                  startActivity(intent);


          }

      });
      /* btv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String department_of="Endocrinology";
                Intent intent=new Intent(search.this,list.class);
                Bundle bn = new Bundle();
                bn.putString("user_name",user_name);
                bn.putString("user_pass",user_pass);
                bn.putString("record_id", record_id);
                bn.putString("department_of",department_of);
                intent.putExtras(bn);
                startActivity(intent);


            }

        });*/
        btv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String department_of="Cardiology";
                Intent intent=new Intent(search.this,list.class);
                Bundle bn = new Bundle();
                bn.putString("user_name",user_name);
                bn.putString("user_pass",user_pass);
                bn.putString("record_id", record_id);
                bn.putString("department_of",department_of);
                intent.putExtras(bn);
                startActivity(intent);


            }

        });
        btv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String department_of="Urology";
                Intent intent=new Intent(search.this,list.class);
                Bundle bn = new Bundle();
                bn.putString("user_name",user_name);
                bn.putString("user_pass",user_pass);
                bn.putString("record_id", record_id);
                bn.putString("department_of",department_of);
                intent.putExtras(bn);
                startActivity(intent);


            }

        });
       /* btv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String department_of="Dermatology";
                Intent intent=new Intent(search.this,list.class);
                Bundle bn = new Bundle();
                bn.putString("user_name",user_name);
                bn.putString("user_pass",user_pass);
                bn.putString("record_id", record_id);
                bn.putString("department_of",department_of);
                intent.putExtras(bn);
                startActivity(intent);


            }

        });*/
        btv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String department_of="E.N.T(Ear Nose Throat)";
                Intent intent=new Intent(search.this,list.class);
                Bundle bn = new Bundle();
                bn.putString("user_name",user_name);
                bn.putString("user_pass",user_pass);
                bn.putString("record_id", record_id);
                bn.putString("department_of",department_of);
                intent.putExtras(bn);
                startActivity(intent);


            }

        });
        btv7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String department_of="Gastroenterology";
                Intent intent=new Intent(search.this,list.class);
                Bundle bn = new Bundle();
                bn.putString("user_name",user_name);
                bn.putString("user_pass",user_pass);
                bn.putString("record_id", record_id);
                bn.putString("department_of",department_of);
                intent.putExtras(bn);
                startActivity(intent);


            }

        });
        btv8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String department_of="General Surgery";
                Intent intent=new Intent(search.this,list.class);
                Bundle bn = new Bundle();
                bn.putString("user_name",user_name);
                bn.putString("user_pass",user_pass);
                bn.putString("record_id", record_id);
                bn.putString("department_of",department_of);
                intent.putExtras(bn);
                startActivity(intent);


            }

        });
/*        btv9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String department_of="In vitro fertilization(IVF)";
                Intent intent=new Intent(search.this,list.class);
                Bundle bn = new Bundle();
                bn.putString("user_name",user_name);
                bn.putString("user_pass",user_pass);
                bn.putString("record_id", record_id);
                bn.putString("department_of",department_of);
                intent.putExtras(bn);
                startActivity(intent);


            }

        });*/
        btv10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String department_of="Neuro surgery";
                Intent intent=new Intent(search.this,list.class);
                Bundle bn = new Bundle();
                bn.putString("user_name",user_name);
                bn.putString("user_pass",user_pass);
                bn.putString("record_id", record_id);
                bn.putString("department_of",department_of);
                intent.putExtras(bn);
                startActivity(intent);


            }

        });
        btv11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String department_of="Gynecology";
                Intent intent=new Intent(search.this,list.class);
                Bundle bn = new Bundle();
                bn.putString("user_name",user_name);
                bn.putString("user_pass",user_pass);
                bn.putString("record_id", record_id);
                bn.putString("department_of",department_of);
                intent.putExtras(bn);
                startActivity(intent);


            }

        });
/*        btv12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String department_of="Orthopaedic";
                Intent intent=new Intent(search.this,list.class);
                Bundle bn = new Bundle();
                bn.putString("user_name",user_name);
                bn.putString("user_pass",user_pass);
                bn.putString("record_id", record_id);
                bn.putString("department_of",department_of);
                intent.putExtras(bn);
                startActivity(intent);


            }

        });*/

    }
  /*  public  void logout(View view){
        SharedPreferences sharedpreferences = getSharedPreferences(MainActivity.MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.clear();
        editor.commit();
        finish();
        Intent in = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(in);
    }
   /* public void list(View view) {
        startActivity(new Intent(this, list.class));
    }*/
}
