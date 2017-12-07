package com.example.tarunkumar.doctorfind;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
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

public class patients_profile extends AppCompatActivity {
    TextView tv1,tv2,tv3,tv4,tv5,tv6;
    String usn,passwo,record_id,t1,t2,t3,t4,t5;
    ImageView image;
    Context ctx=this;
    Button bt;
    String  user_name,user_pass;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patients_profile);
        Bundle bn=getIntent().getExtras();
        usn=bn.getString("user_name");
        passwo=bn.getString("user_pass");
        record_id=bn.getString("record_id");
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
                    Intent intent = new Intent(patients_profile.this, search.class);
                    Bundle bn = new Bundle();
                    bn.putString("user_name",user_name);
                    bn.putString("user_pass",user_pass);
                    bn.putString("record_id", record_id);
                    intent.putExtras(bn);
                    startActivity(intent);

                }
                else if(item.getItemId()==R.id.id_profile){
                    Intent in = new Intent(patients_profile.this, patients_profile.class);
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
                    Intent in = new Intent(patients_profile.this, MainActivity.class);
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

        tv1=(TextView)findViewById(R.id.tv1);
        tv2=(TextView)findViewById(R.id.tv2);
        tv3=(TextView)findViewById(R.id.tv3);
        tv4=(TextView)findViewById(R.id.tv4);
        tv5=(TextView)findViewById(R.id.tv5);
        tv6=(TextView)findViewById(R.id.tv6);
        Dataoperations dop=new Dataoperations(ctx);
        Cursor cr=dop.getinfo(dop);
        cr.moveToFirst();

        String Name="";
        String pass="";
        String dept="" ,email="",phno="",first="",last="",location="";
        do{
            if(usn.equals(cr.getString(0))&&passwo.equals(cr.getString(1))) {


                Name = cr.getString(0);
                // pass = cr.getString(1);
                //  dept = cr.getString(2);
                email = cr.getString(7);
                phno = cr.getString(6);
                first = cr.getString(4);
                last = cr.getString(5);
                location = cr.getString(8);



            }

        }while(cr.moveToNext());
        //tv1.setText(""+Name);
        tv2.setText(" "+first);
        tv3.setText(""+last);
        tv4.setText(""+email);
        tv5.setText(" "+phno);
        tv6.setText(""+location);
        bt=(Button)findViewById(R.id.bt1);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(patients_profile.this,update.class);
                Bundle bn = new Bundle();
                bn.putString("user_name", usn);
                bn.putString("user_pass", passwo);
                bn.putString("record_id", record_id);
                intent.putExtras(bn);
                startActivity(intent);
            }
        });
    }

}
