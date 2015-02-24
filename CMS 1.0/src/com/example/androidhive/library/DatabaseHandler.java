/**
 * Author: Ravi Tamada
 * URL: www.androidhive.info
 * twitter: http://twitter.com/ravitamada
 * */
package com.example.androidhive.library;

import java.util.HashMap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {

	// All Static variables
	// Database Version
	private static final int DATABASE_VERSION = 1;

	// Database Name
	private static final String DATABASE_NAME = "android_api";

	// Login table name
	private static final String TABLE_LOGIN = "cms_login";

	// Login Table Columns names
	private static final String KEY_ID = "id";
	private static final String KEY_NAME = "name";
	private static final String KEY_EMAIL = "email";
	private static final String KEY_UID = "uid";
	private static String KEY_LNAME = "lname";
	private static String KEY_MOBILE = "mobile";
	private static String KEY_DEPARTMENT = "department";
	private static String KEY_ROLE = "role";
	private static String KEY_ADDRESS = "address";
	private static String KEY_CREATED_AT = "created_at";

	public DatabaseHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	// Creating Tables
	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_LOGIN_TABLE = "CREATE TABLE " + TABLE_LOGIN + "("
				+ KEY_ID + " INTEGER PRIMARY KEY," 
				+ KEY_NAME + " TEXT,"
				+ KEY_LNAME + " TEXT,"
				+ KEY_MOBILE + " TEXT,"
				+ KEY_DEPARTMENT + " TEXT,"
				+ KEY_ROLE + " TEXT,"
				+ KEY_ADDRESS + " TEXT,"
				+ KEY_EMAIL + " TEXT UNIQUE,"
				+ KEY_UID + " TEXT" + ")";
		db.execSQL(CREATE_LOGIN_TABLE);
	}

	// Upgrading database
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOGIN);

		// Create tables again
		onCreate(db);
	}

	/**
	 * KEY_UID,KEY_EMAIL,KEY_ADDRESS,KEY_ROLE,KEY_DEPARTMENT,KEY_MOBILE,KEY_LNAME,KEY_NAME
	 * */
	public void addUser(String uid, String email, String address, String role, String department, String mobile, String lname, String name) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_UID, uid);
		values.put(KEY_EMAIL, email);
		values.put(KEY_ADDRESS, address);
		values.put(KEY_ROLE, role);
		values.put(KEY_DEPARTMENT, department);
		values.put(KEY_MOBILE, mobile);
		values.put(KEY_LNAME, lname);
		values.put(KEY_NAME, name);
		 
		
		// Inserting Row
		db.insert(TABLE_LOGIN, null, values);
		db.close(); // Closing database connection
	}
	
	/**
	 * Getting user data from database
	 * 	+ KEY_ID + " INTEGER PRIMARY KEY," 
				+ KEY_NAME + " TEXT,"
				+ KEY_LNAME + " TEXT,"
				+ KEY_MOBILE + " TEXT,"
				+ KEY_DEPARTMENT + " TEXT,"
				+ KEY_ROLE + " TEXT,"
				+ KEY_ADDRESS + " TEXT,"
				+ KEY_EMAIL + " TEXT UNIQUE,"
				+ KEY_UID + " TEXT" + ")";
	 * */
	public HashMap<String, String> getUserDetails(){
		HashMap<String,String> user = new HashMap<String,String>();
		String selectQuery = "SELECT  * FROM " + TABLE_LOGIN;
		 
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // Move to first row
        cursor.moveToFirst();
        if(cursor.getCount() > 0){
        	user.put("name", cursor.getString(1));
        	user.put("lname", cursor.getString(2));
        	user.put("mobile", cursor.getString(3));
        	user.put("department", cursor.getString(4));
        	user.put("role", cursor.getString(5));
        	user.put("address", cursor.getString(6));
        	user.put("email", cursor.getString(7));
        	user.put("uid", cursor.getString(8));
        }
        cursor.close();
        db.close();
		// return user
		return user;
	}

	/**
	 * Getting user login status
	 * return true if rows are there in table
	 * */
	public int getRowCount() {
		String countQuery = "SELECT  * FROM " + TABLE_LOGIN;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(countQuery, null);
		int rowCount = cursor.getCount();
		db.close();
		cursor.close();
		
		// return row count
		return rowCount;
	}
	
	
	
	/**
	 * Re crate database
	 * Delete all tables and create them again
	 * */
	public void resetTables(){
		SQLiteDatabase db = this.getWritableDatabase();
		// Delete All Rows
		db.delete(TABLE_LOGIN, null, null);
		db.close();
	}

}
