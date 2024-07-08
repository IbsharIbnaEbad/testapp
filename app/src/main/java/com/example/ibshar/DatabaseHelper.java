package com.example.ibshar;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "DATABASE_OF_MY_SYSTEM";

    public static final int DATABASE_VERSION = 1;

    public static final String COL_PHONE = "phonenumber";
    public static final String COL_PASSWORD = "password";
    public static final String COL_FIRSTNAME = "firstname";
    public static final String COL_ID = "id";
    private static final String TABLE_REGISTER = "REGISTERTABLE";

    public static final String TABLE_Insertion = "Insertion";
    public static final String COL_Item_NAME = "ItemName";
    public static final String COL_Item_PRICE = "Price";
    public static final String COL_Item_Description = "Description";
    public static final String COL_Item_IMAGE_URI = "itemImageUri";

    //add newly
    private Context context;


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_REGISTER);
        //addd
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Insertion);
        onCreate(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + TABLE_REGISTER + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_FIRSTNAME + " TEXT, " +
                COL_PASSWORD + " TEXT, " +
                COL_PHONE + " TEXT)");

        db.execSQL("CREATE TABLE " + TABLE_Insertion + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_Item_NAME + " TEXT, " +
                COL_Item_PRICE + " REAL, " +
                COL_Item_Description + " TEXT, " +
                COL_Item_IMAGE_URI + " BLOB)");

    }

    public boolean insertUser(String firstname, String password, String phonenumber) {

        SQLiteDatabase db = this.getWritableDatabase();


        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_FIRSTNAME, firstname);
        contentValues.put(COL_PASSWORD, password);
        contentValues.put(COL_PHONE, phonenumber);

        long result = db.insert(TABLE_REGISTER, null, contentValues);

        return result != -1;
    }

    public boolean checkUserName(String username, String password) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_REGISTER + " WHERE " + COL_FIRSTNAME + " = ? AND " + COL_PASSWORD + " = ?", new String[]{username, password});
        boolean exists = cursor.getCount() > 0;
        cursor.close();
        return exists;
    }

    public void insertProduct(String name, int price, String description, byte[] imageByteArray) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_Item_NAME, name);
        values.put(COL_Item_PRICE, price);
        values.put(COL_Item_Description, description);
        values.put(COL_Item_IMAGE_URI, imageByteArray);
       // add newly
        long  result = db.insert(TABLE_Insertion, null, values);
        if (result == -1) {
            // Handle insertion failure
            Toast.makeText(context, "Failed to insert product", Toast.LENGTH_SHORT).show();
        } else {
            // Handle successful insertion
            Toast.makeText(context, "Product inserted successfully", Toast.LENGTH_SHORT).show();
        }
        db.close();
    }

    /*public Cursor getAllProducts() {

        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery(" SELECT * FROM " + TABLE_Insertion, null);
    }*/

    //added
    public Cursor getAllProducts() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT Id as _id, ItemName, Price, Description, itemImageUri FROM " + TABLE_Insertion, null);
    }


    public Cursor getProductByName(String productName) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_Insertion + " WHERE " + COL_Item_NAME + " = ?", new String[]{productName});
    }

    public void updateProduct(int itemId, String itemName, int price, String itemDescription, byte[] productImageByteArray) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();


        values.put(COL_Item_NAME, itemName);
        values.put(COL_Item_PRICE, price);
        values.put(COL_Item_Description, itemDescription);
        values.put(COL_Item_IMAGE_URI, productImageByteArray);

        db.update(TABLE_Insertion, values, COL_ID + " = ?", new String[]{String.valueOf(itemId)});
        db.close();
    }

    public void deleteProduct(String itemName) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_Insertion, COL_Item_NAME + " = ?", new String[]{itemName});
        db.close();

    }
}
