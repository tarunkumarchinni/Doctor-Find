package com.example.tarunkumar.doctorfind;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class signup extends AppCompatActivity {
    Button bt1;
    EditText first,last,phno,email,address,user_name,user_pass,user_con;
    TextView tv_use;
    String fn,ln,ph,em,add,u_n,u_p,u_c,dept="null",id;
    int x1,x2,x3,x4,x5,x6,x7,x8;
    Context ctx=this;
    ArrayAdapter<CharSequence> adapter;
    Spinner spinner1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        spinner1=(Spinner) findViewById(R.id.et_address);
        adapter= ArrayAdapter.createFromResource(this,R.array.location,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(),parent.getItemAtPosition(position)+"selected",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        first=(EditText)findViewById(R.id.et_firstname);
        last=(EditText)findViewById(R.id.et_lastname);
        phno=(EditText)findViewById(R.id.et_phno);
        email=(EditText)findViewById(R.id.et_email);
       // address=(EditText)findViewById(R.id.et_address);
        user_name=(EditText)findViewById(R.id.et_username1);
        user_pass=(EditText)findViewById(R.id.et_userpass);
        user_con=(EditText)findViewById(R.id.et_usercon);
        bt1=(Button)findViewById(R.id.bt);



        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fn=first.getText().toString();
                ln=last.getText().toString();
                ph=phno.getText().toString();
                em=email.getText().toString();
               // add=address.getText().toString();
                add = spinner1.getSelectedItem().toString();
                 u_n=user_name.getText().toString();
                u_p=user_pass.getText().toString();
                u_c=user_con.getText().toString();
                //Toast.makeText(getBaseContext(),email.getText().toString(),Toast.LENGTH_LONG).show();
                tv_use=(TextView)findViewById(R.id.tv_username);
                x6=first.length();
                x7=last.length();
                x8=spinner1.getSelectedItemPosition();
                x1=phno.length();
                x2=email.length();
                x3=user_name.length();
                x4=user_pass.length();
                x5=user_con.length();
                 if(x6==0){

                    Toast.makeText(getBaseContext(),"please enter conform password..",Toast.LENGTH_LONG).show();
                    first.setHintTextColor(Color.RED);
                    first.setHint("first name..");

                }
                else if(x7==0){

                    Toast.makeText(getBaseContext(),"please enter conform password..",Toast.LENGTH_LONG).show();
                    last.setHintTextColor(Color.RED);
                    last.setHint("last name..");

                }
                else if(x1==0){
                    Toast.makeText(getBaseContext(),"please enter phno..",Toast.LENGTH_LONG).show();
                    phno.setHintTextColor(Color.RED);
                    phno.setHint("phone no");
                }
               else if(x2==0){
                    Toast.makeText(getBaseContext(),"please enter email..",Toast.LENGTH_LONG).show();
                    email.setHintTextColor(Color.RED);
                    email.setHint("example@gmail.com");

                }
                 else if(x8==0){
                     Toast.makeText(signup.this,
                             "Please select the location..", Toast.LENGTH_LONG).show();

                     return;
                 }
               else if(x3==0){
                    Toast.makeText(getBaseContext(),"please enter username..",Toast.LENGTH_LONG).show();
                    user_name.setHintTextColor(Color.RED);
                    user_name.setHint("user name..");
                }
                else if(x4==0){
                    Toast.makeText(getBaseContext(),"please enter user password..",Toast.LENGTH_LONG).show();
                    user_pass.setHintTextColor(Color.RED);
                    user_pass.setHint("password..");
                }
                else if(x5==0){

                        Toast.makeText(getBaseContext(),"please enter conform password..",Toast.LENGTH_LONG).show();
                        user_con.setHintTextColor(Color.RED);
                    user_con.setHint("conform password..");

                }
                else if(x8==0){

                    Toast.makeText(getBaseContext(),"please enter conform password..",Toast.LENGTH_LONG).show();
                    address.setHintTextColor(Color.RED);
                    address.setHint("address");

                }

               // tv_use.setText("User Details  \nfirstname is:  "+fn+"\nlastname is:  "+ln+"\nphone number is:  "+ph+"\nemail is:  "+em+"\naddress is:  "+add+"\nusername :"+u_n+"\nuserpassword:"+u_p+"\nuserconformation:"+u_c);
           else if(!(u_p.equals(u_c))){
               Toast.makeText(getBaseContext(),"passwords are not matching",Toast.LENGTH_LONG).show();

           }
           else{
               Dataoperations db=new Dataoperations(ctx);
               db.putinfo(db,id,fn,ln,ph,em,add,u_n,u_p,u_c,dept);
               Toast.makeText(getBaseContext(),"signup successfuly done..",Toast.LENGTH_LONG).show();
               finish();
           }


            }


        });

    }
}
