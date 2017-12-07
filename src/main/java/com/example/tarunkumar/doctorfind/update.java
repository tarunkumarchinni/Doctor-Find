package com.example.tarunkumar.doctorfind;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Color;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.tarunkumar.doctorfind.R.id.tv1;

public class update extends AppCompatActivity {
    String user_name;
    String user_pass,newusername,newemail,newphno,newaddress;
    protected EditText new_username;
    protected EditText new_email;
    protected EditText new_phno;
    protected EditText new_address;
    int x1,x2,x3,x4,x5;
    Button b_update;
    TextView tv;
    Context ctx=this;
    Dataoperations dop;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationview;
    Spinner spinner1;
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        Bundle bn = getIntent().getExtras();
        user_name = bn.getString("user_name");
        user_pass = bn.getString("user_pass");
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
                    Intent intent = new Intent(update.this, search.class);
                    Bundle bn = new Bundle();
                    bn.putString("user_name",user_name);
                    bn.putString("user_pass",user_pass);
                    //bn.putString("record_id", record_id);
                    intent.putExtras(bn);
                    startActivity(intent);

                }
                else if(item.getItemId()==R.id.id_profile){
                    Intent in = new Intent(update.this, patients_profile.class);
                    Bundle bn1 = new Bundle();
                    bn1.putString("user_name",user_name);
                    bn1.putString("user_pass",user_pass);
                   // bn1.putString("record_id", record_id);
                    in.putExtras(bn1);
                    startActivity(in);

                }
                else{
                    SharedPreferences sharedpreferences = getSharedPreferences(MainActivity.MyPREFERENCES, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.clear();
                    editor.commit();
                    finish();
                    Intent in = new Intent(update.this, MainActivity.class);
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

        new_username = (EditText) findViewById(R.id.et_firstname);
        new_email = (EditText) findViewById(R.id.et_email);
        new_phno = (EditText) findViewById(R.id.et_phno);
        new_address = (EditText) findViewById(R.id.et_address);


        Dataoperations dop = new Dataoperations(ctx);
        Cursor cr = dop.getinfo(dop);
        cr.moveToFirst();

        String Name = "";
        String pass = "";
        String dept = "", email = "", phno = "", first = "", last = "", location = "";
        do {
            if (user_name.equals(cr.getString(0)) && user_pass.equals(cr.getString(1))) {


                Name = cr.getString(0);
                // pass = cr.getString(1);
                //  dept = cr.getString(2);
                email = cr.getString(7);
                phno = cr.getString(6);
                first = cr.getString(4);
                last = cr.getString(5);
                location = cr.getString(8);


            }

        } while (cr.moveToNext());
                                                   //setText(""+Name);
       /* tv1.setText(""+Name);
        tv2.setText(" "+first);
        tv3.setText(""+last);
        tv4.setText(""+email);
        tv5.setText(" "+phno);
        tv6.setText(""+location);*/
        new_username.setText(Name);
        new_email.setText(email);
        new_phno.setText(phno);
        new_address.setText(location);



                b_update= (Button) findViewById(R.id.bt);
               b_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dataoperations dop;
                newusername = new_username.getText().toString();
                newemail = new_email.getText().toString();
                newphno = new_phno.getText().toString();
              //  newaddress = spinner1.getSelectedItem().toString();
                newaddress = new_address.getText().toString();
                //tv.setText("Username is:  " + user_name + "\npassword is:  " + user_pass + "\nnew Username is:  " + newusername);
                    dop = new Dataoperations(ctx);
                    dop.updateinfo(dop, user_name, user_pass, newusername, newemail, newphno, newaddress);
                    Toast.makeText(getBaseContext(), "update successs....", Toast.LENGTH_LONG).show();
                    finish();

            }
        });

    }
}
