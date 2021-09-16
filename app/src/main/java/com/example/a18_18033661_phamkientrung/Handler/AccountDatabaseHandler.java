package com.example.a18_18033661_phamkientrung.Handler;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.a18_18033661_phamkientrung.Entity.Account;


public class AccountDatabaseHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Account";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "accounts";

    private static final String KEY_ID = "id";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_TIMELOGIN = "timelogin";

    public AccountDatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_students_table = String.format("CREATE TABLE %s(%s INTEGER  PRIMARY KEY AUTOINCREMENT, %s TEXT, %s DATE)",
                TABLE_NAME, KEY_ID, KEY_EMAIL, KEY_TIMELOGIN);
        db.execSQL(create_students_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String drop_students_table = String.format("DROP TABLE IF EXISTS %s", TABLE_NAME);
        db.execSQL(drop_students_table);
        onCreate(db);
    }

    public void add(Account account){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_EMAIL, account.getEmail());
        values.put(KEY_TIMELOGIN, account.getTimeLogin().getTime());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

//    public LinkedList<Product> getAll() {
//        LinkedList<Product> products = new LinkedList<>();
//        String query = "SELECT * FROM " + TABLE_NAME;
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery(query, null);
//        cursor.moveToFirst();
//        while(cursor.isAfterLast() == false) {
//            Product b = new Product(cursor.getInt(0), cursor.getDouble(2), cursor.getString(1), cursor.getString(3));
//            products.add(b);
//            cursor.moveToNext();
//        }
//        return products;
//    }
}
