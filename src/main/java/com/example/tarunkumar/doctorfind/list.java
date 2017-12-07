package com.example.tarunkumar.doctorfind;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.ArrayList;

/*public class list extends AppCompatActivity {
    Dataoperations dop;
    ListView listView;
    String s1="Dental";
    Context context;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        listView = (ListView) findViewById(R.id.displaylist);
        dop = new Dataoperations(context);
       // Toast.makeText(context, "use ......", Toast.LENGTH_LONG).show();
        showlist();
    }

    public void showlist() {
        ArrayList<display> doctorslist = new ArrayList<display>();
        // doctorslist.clear();

        String query = "SELECT first,address FROM signup1 ";

        Cursor c1 = SqlHandler.selectQuery(query);
        if (c1 != null && c1.getCount() != 0) {
            if (c1.moveToFirst()) {
                do {
                    display contactListItems = new display();

                    contactListItems.setFname(c1.getString(0));     //c1.getColumnIndex("first")
                    contactListItems.setAddress(c1.getString(1));
                    // Toast.makeText(context,"use ......"+ c1.getString(1),Toast.LENGTH_LONG).show();
                    doctorslist.add(contactListItems);


                } while (c1.moveToNext());
            }
        }
        // Toast.makeText(context,"use ......",Toast.LENGTH_LONG).show();

        displayAdapter contactListAdapter = new displayAdapter(
                list.this, doctorslist);
        listView.setAdapter(contactListAdapter);


    }

}
*/

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;import android.widget.ListView;

public class list extends AppCompatActivity {
    // Array of strings...
    ListView simpleList;
    Context ctx = this;
    Dataoperations dop, dp;
    Cursor cursor;
  public static String user_name,user_pass,record_id,department_of;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Bundle bn = getIntent().getExtras();
       // Toast.makeText(ctx,"hii from list class",Toast.LENGTH_LONG).show();
        user_name = bn.getString("user_name");
        user_pass = bn.getString("user_pass");
        record_id = bn.getString("record_id");
        department_of=bn.getString("department_of");
       // Toast.makeText(ctx,"hii from list class"+user_name+"\n"+user_pass+"\n"+record_id+"\n"+department_of,Toast.LENGTH_LONG).show();

      /*  simpleList = (ListView) findViewById(R.id.simpleListView);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.display_row, R.id.tv1, countryList);
        simpleList.setAdapter(arrayAdapter);*/
        //  list l=new list();
        //  l.populatelistview();
   /*  1  Dataoperations dop=new Dataoperations(ctx);
        Cursor cursor=dop.getallrows(dop);
       // Dataoperations dop=new Dataoperations(ctx);

        String[] fromfields={Tabledata.Tabledatainfo.FIRST,Tabledata.Tabledatainfo.ADDRESS};


        int[] toviewnames=new int[] {R.id.tv1};
        SimpleCursorAdapter mycursor1;
        simpleList = (ListView) findViewById(R.id.simpleListView);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.display_row, R.id.tv1, fromfields);
       // mycursor1=new SimpleCursorAdapter(getBaseContext(),R.layout.display_row,cursor,fromfields,toviewnames,0);
      //  ListView mylist=(ListView)findViewById(R.id.simpleListView);
       // mylist.setAdapter(mycursor1);
        simpleList.setAdapter(arrayAdapter);1*/


   /* private  void populatelistview(){

        Cursor cursor=dop.getallrows();
        String[] fromfields=new String[]{Tabledata.Tabledatainfo.FIRST};


        int[] toviewnames=new int[] {R.id.tv1};
        SimpleCursorAdapter mycursor;
        mycursor=new SimpleCursorAdapter(getBaseContext(),R.layout.display_row,cursor,fromfields,toviewnames,0);
        ListView mylist=(ListView)findViewById(R.id.simpleListView);
        mylist.setAdapter(mycursor);
       // mylist.setAdapter(arrayAdapter);
    }*/
    Backendtask bet=new Backendtask(this);
        bet.execute("get_info");
    }
}


