package com.example.tarunkumar.doctorfind;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import static com.example.tarunkumar.doctorfind.Tabledata.Tabledatainfo.IMAGE;
import static com.example.tarunkumar.doctorfind.Tabledata.Tabledatainfo.PHNO;
import static com.example.tarunkumar.doctorfind.Tabledata.Tabledatainfo.TABLE_NAME;
import static com.example.tarunkumar.doctorfind.Tabledata.Tabledatainfo.USER_RECORD_ID;
import static com.example.tarunkumar.doctorfind.Tabledata.Tabledatainfo.U_N;

/**
 * Created by TARUN KUMAR on 28-05-2017.
 */

public class Dataoperations extends SQLiteOpenHelper {

    private Dataoperations mDbHelper,dop;
    private SQLiteDatabase mDb;

    private static final String DATABASE_NAME = "trash";

    public static final int database_version = 1;
    private static final String TABLE_NAME = "signup1";
    public String create_query = "CREATE TABLE " + TABLE_NAME + "(" + Tabledata.Tabledatainfo.USER_RECORD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT DEFAULT 1 ,"+Tabledata.Tabledatainfo.IMAGE+" BLOB," + Tabledata.Tabledatainfo.FIRST + " TEXT NOT NULL," + Tabledata.Tabledatainfo.LAST + " TEXT NOT NULL," + Tabledata.Tabledatainfo.PHNO + " INTEGER NOT NULL," + Tabledata.Tabledatainfo.EMAIL + " TEXT NOT NULL," + Tabledata.Tabledatainfo.ADDRESS + " TEXT," + Tabledata.Tabledatainfo.U_N + " TEXT NOT NULL," + Tabledata.Tabledatainfo.U_P + " TEXT NOT NULL," + Tabledata.Tabledatainfo.U_c + " TEXT NOT NULL," + Tabledata.Tabledatainfo.DEPT + " TEXT );";
   // public String alt_query="ALTER TABLE "+TABLE_NAME+" ADD "+IMAGE+" BLOB;";

    Context mCtx;
    public Dataoperations(Context context) {
        super(context, Tabledata.Tabledatainfo.DATABASE_NAME, null, database_version);
       /* mCtx = context;
        mDbHelper = new Dataoperations(mCtx);*/
        Log.d("Data base operations", "Data base created");
    }



    @Override

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(create_query);
        Log.d("Data base operations", "table created");
       // db.execSQL(alt_query);

       // Log.d("altered the query","table altered..");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Tabledata.Tabledatainfo.TABLE_NAME);
        onCreate(db);

    }

    public void putinfo(Dataoperations dop, String id, String fn, String ln, String ph, String em, String add, String u_na, String u_pa, String u_co, String dept) {
        SQLiteDatabase SQ = dop.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(Tabledata.Tabledatainfo.USER_RECORD_ID, id);
        cv.put(Tabledata.Tabledatainfo.FIRST, fn);
        cv.put(Tabledata.Tabledatainfo.LAST, ln);
        cv.put(Tabledata.Tabledatainfo.PHNO, ph);
        cv.put(Tabledata.Tabledatainfo.EMAIL, em);
        cv.put(Tabledata.Tabledatainfo.ADDRESS, add);
        cv.put(Tabledata.Tabledatainfo.U_N, u_na);
        cv.put(Tabledata.Tabledatainfo.U_P, u_pa);
        cv.put(Tabledata.Tabledatainfo.U_c, u_co);
        cv.put(Tabledata.Tabledatainfo.DEPT, dept);
        Long sk = SQ.insert(TABLE_NAME, null, cv);
        Log.d("Data base operations", "one row inserted.");

    }

    public Cursor getinfo(Dataoperations dop) {
        SQLiteDatabase SQ = dop.getReadableDatabase();
        String[] Columns = {Tabledata.Tabledatainfo.U_N, Tabledata.Tabledatainfo.U_P, Tabledata.Tabledatainfo.DEPT, Tabledata.Tabledatainfo.USER_RECORD_ID, Tabledata.Tabledatainfo.FIRST, Tabledata.Tabledatainfo.LAST, Tabledata.Tabledatainfo.PHNO, Tabledata.Tabledatainfo.EMAIL, Tabledata.Tabledatainfo.ADDRESS};
        Cursor cr = SQ.query(TABLE_NAME, Columns, null, null, null, null, null);
        return cr;
    }

    public void updateinfo(Dataoperations dop, String username, String pass, String newname,String newemail,String newphone,String newaddress) {
        SQLiteDatabase SQ = dop.getWritableDatabase();
        String selection = Tabledata.Tabledatainfo.U_N + " LIKE ? AND " + Tabledata.Tabledatainfo.U_P + " LIKE ?";
        String args[] = {username, pass};
        ContentValues CR = new ContentValues();
        CR.put(Tabledata.Tabledatainfo.U_N, newname);
        CR.put(Tabledata.Tabledatainfo.EMAIL, newemail);
        CR.put(Tabledata.Tabledatainfo.PHNO, newphone);
        CR.put(Tabledata.Tabledatainfo.ADDRESS, newaddress);
        SQ.update(TABLE_NAME, CR, selection, args);
    }

    public Cursor getinformations(String s1, SQLiteDatabase dop) {
        // SQLiteDatabase SQ = dop.getReadableDatabase();
        String[] Columns = {Tabledata.Tabledatainfo.U_N, Tabledata.Tabledatainfo.U_P, Tabledata.Tabledatainfo.DEPT, Tabledata.Tabledatainfo.USER_RECORD_ID, Tabledata.Tabledatainfo.FIRST, Tabledata.Tabledatainfo.ADDRESS};
        String selection = Tabledata.Tabledatainfo.DEPT + " LIKE ?";
        String[] selection_args = {s1};
        Cursor cr = dop.query(TABLE_NAME, Columns, selection, selection_args, null, null, null);
        return cr;
    }

    public Cursor getallrows(Dataoperations dop) {
        String where = null;

        SQLiteDatabase SQ = dop.getReadableDatabase();
        String[] Columns = {Tabledata.Tabledatainfo.U_N, Tabledata.Tabledatainfo.U_P, Tabledata.Tabledatainfo.DEPT, Tabledata.Tabledatainfo.USER_RECORD_ID, Tabledata.Tabledatainfo.FIRST};

        Cursor c = SQ.query(true, TABLE_NAME, Columns, where, null, null, null, null, null);
        if (c != null) {
            c.moveToFirst();
        }
        return c;
    }




//image code

/*    public// Adding new contact
    void addContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Tabledata.Tabledatainfo.U_N, contact._name); // Contact Name
        values.put(Tabledata.Tabledatainfo.IMAGE, contact._image); // Contact Phone

        // Inserting Row
        db.insert(TABLE_NAME, null, values);
        db.close(); // Closing database connection
    }

    // Getting single contact
    Contact getContact(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, new String[] {Tabledata.Tabledatainfo.USER_RECORD_ID,
                        Tabledata.Tabledatainfo.U_N, Tabledata.Tabledatainfo.IMAGE}, Tabledata.Tabledatainfo.USER_RECORD_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Contact contact = new Contact(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getBlob(1));

        // return contact
        return contact;

    }

    // Getting All Contacts
    public List<Contact> getAllContacts(String s1) {
        List<Contact> contactList = new ArrayList<Contact>();
        // Select All Query
        String selectQuery = "SELECT  * FROM signup1 WHERE USER_RECORD_ID="+s1;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Contact contact = new Contact();
                contact.setID(Integer.parseInt(cursor.getString(0)));
                contact.setName(cursor.getString(1));
                contact.setImage(cursor.getBlob(2));
                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }
        // close inserting data from database
        db.close();
        // return contact list
        return contactList;

    }

    // Updating single contact
    public int updateContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Tabledata.Tabledatainfo.U_N, contact.getName());
        values.put(Tabledata.Tabledatainfo.IMAGE, contact.getImage());

        // updating row
        return db.update(TABLE_NAME, values, Tabledata.Tabledatainfo.USER_RECORD_ID + " = ?",
                new String[] { String.valueOf(contact.getID()) });

    }

    // Deleting single contact
    public void deleteContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, Tabledata.Tabledatainfo.USER_RECORD_ID + " = ?",
                new String[] { String.valueOf(contact.getID()) });
        db.close();
    }

    // Getting contacts Count
    public int getContactsCount() {
        String countQuery = "SELECT  * FROM " + Tabledata.Tabledatainfo.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }










*/
}
