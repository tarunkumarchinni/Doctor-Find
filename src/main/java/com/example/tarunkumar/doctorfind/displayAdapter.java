package com.example.tarunkumar.doctorfind;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static android.R.attr.resource;

/**
 * Created by TARUN KUMAR on 03-06-2017.
 */

public class displayAdapter extends ArrayAdapter{

    List list = new ArrayList();


    public displayAdapter(Context context, int resource) {
        super(context, resource);
    }


    public void add(display object) {
        list.add(object);
        super.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }


    @Override
    public Object getItem(int position) {
        return list.get(position);
    }


    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        View row=convertView;
        displayHolder dh;
        if(row==null){
            LayoutInflater layoutInflater=(LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=layoutInflater.inflate(R.layout.display_row,parent,false);
            dh=new displayHolder();
            dh.tx_name=(TextView)row.findViewById(R.id.tv1);
            dh.tx_address=(TextView)row.findViewById(R.id.tv2);
            row.setTag(dh);
        }
        else{
            dh=(displayHolder)row.getTag();
        }
        display dis=(display)getItem(position);
        dh.tx_name.setText(dis.getFname().toString());
        dh.tx_address.setText(dis.getAddress().toString());
        return row;
    }
    static  class displayHolder{
        TextView tx_id,tx_name,tx_address,tx_phno;
    }
  /* Context context;
    ArrayList<display> docList;

    public displayAdapter(Context context, ArrayList<display> list) {

        this.context = context;
        docList = list;
    }


    @Override
    public int getCount() {

        return docList.size();
    }

    @Override
    public Object getItem(int position) {

        return docList.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup arg2) {
        display contactListItems = docList.get(position);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.display_row,null );

        }
        String s1,s2,d1,d2;
       TextView tv1 = (TextView) convertView.findViewById(R.id.tv1);
         tv1.setText("fname is:"+contactListItems.getFname());
      //  TextView tv2 = (TextView) convertView.findViewById(R.id.tv2);
       // tv2.setText("address"+contactListItems.getAddress());
      //  Toast.makeText(context,,Toast.LENGTH_LONG).show();

        return convertView;

    }*/

}
