package com.example.tarunkumar.doctorfind;

import android.content.Intent;

/**
 * Created by TARUN KUMAR on 03-06-2017.
 */

public class display {
    private  int id,phno;
    private String fname,address;
    public display(String fname,String address){
      this.setId(id);
        this.setFname(fname);
        this.setAddress(address);
        this.setPhno(phno);
    }

    public String getFname(){
        return fname;
    }
    public void setFname(String fname){
        this.fname=fname;

    }
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address=address;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPhno() {
        return phno;
    }

    public void setPhno(int phno) {
        this.phno = phno;
    }
}
