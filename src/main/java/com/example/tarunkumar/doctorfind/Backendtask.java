package com.example.tarunkumar.doctorfind;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by TARUN KUMAR on 05-06-2017.
 */

public class Backendtask extends AsyncTask<String, display,String> {
    Context ctx;
    displayAdapter disadapter;
    Activity activity;
    ListView listView;

    Backendtask(Context ctx) {
        this.ctx = ctx;
        activity = (Activity) ctx;
    }

    @Override
    protected String doInBackground(String... params) {
        String method = params[0];
        Dataoperations dop = new Dataoperations(ctx);
      /*  if(method.equals("add_info")){
            String id=params[1];
            String name=params[2];
            SQLiteDatabase db=dop.getWritableDatabase();
           // dop.addinformation(db,id,name);
           return  "one row inserted";
        }*/
         String use_n,dept,use_p,re_id;
        use_n=list.user_name;
        use_p=list.user_pass;
        re_id=list.record_id;
        dept=list.department_of;
      //  user_name = bn.getString("user_name");
      //  user_pass = bn.getString("user_pass");
      //  record_id = bn.getString("record_id");
      //  department_of=bn.getString("department_of");
       // Toast.makeText(ctx,"department is:"+dept,Toast.LENGTH_LONG).show();
        System.out.println("department is:"+dept+"\n"+use_n+"\n"+use_p+"\n"+re_id);
        if (method.equals("get_info")) {
            listView = (ListView) activity.findViewById(R.id.simpleListView);
            SQLiteDatabase db = dop.getReadableDatabase();
            Cursor cr = dop.getinformations(dept,db);
            disadapter = new displayAdapter(ctx, R.layout.display_row);
            String name, address;
            int id, phno;
            while (cr.moveToNext()) {
                name = cr.getString(cr.getColumnIndex(Tabledata.Tabledatainfo.FIRST));
                address = cr.getString(cr.getColumnIndex(Tabledata.Tabledatainfo.ADDRESS));
                //id = cr.getInt(cr.getColumnIndex(Tabledata.Tabledatainfo.USER_RECORD_ID));
               // phno = cr.getInt(cr.getColumnIndex(Tabledata.Tabledatainfo.PHNO));
                display dis = new display(name, address);
                publishProgress(dis);
            }
            return "get_info";

        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onProgressUpdate(display... values) {
        disadapter.add(values[0]);
    }

    @Override
    protected void onPostExecute(String result) {
        if (result.equals("get_info")) {
            listView.setAdapter(disadapter);
        } else {

            Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();

        }

    }
}