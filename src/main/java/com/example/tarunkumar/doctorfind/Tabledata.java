package com.example.tarunkumar.doctorfind;

/**
 * Created by TARUN KUMAR on 28-05-2017.
 */
import android.provider.BaseColumns;

public class Tabledata {
    public Tabledata(){

    }
    public static abstract class Tabledatainfo implements BaseColumns{
        public static final String USER_RECORD_ID="user_record_id";
     public static final String FIRST="first";
        public static final String LAST="last";
        public static final String PHNO="phno";
        public static final String EMAIL="email";
        public static final String ADDRESS="address";
        public static final String U_N="u_n";
        public static final String U_P="u_p";
        public static final String U_c="u_c";
        public static final String DEPT="department";
        public static final String IMAGE="image";


        public static final String DATABASE_NAME="trash";
        public static final String TABLE_NAME="signup1";
       // public static final String TABLE_NAME1="signup1";

    }

}
