/**
 * Author: Ravi Tamada
 * URL: www.androidhive.info
 * twitter: http://twitter.com/ravitamada
 * */
package com.example.androidhive.library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import android.content.Context;

public class UserFunctions {
	
	private JSONParser jsonParser;
	
	private static String loginURL = "http://192.168.1.3/cms/index.php";//?XDEBUG_SESSION_START=netbeans-xdebug";
	private static String registerURL = "http://192.168.1.3/cms/index.php";//?XDEBUG_SESSION_START=netbeans-xdebug";
	
	private static String login_tag = "login";
	private static String register_tag = "register";
	
	// constructor
	public UserFunctions(){
		jsonParser = new JSONParser();
	}
	
	/**
	 * function make Login Request
	 * @param email
	 * @param password
	 * */
	public JSONObject loginUser(String email, String password){
		// Building Parameters
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("tag", login_tag));
		params.add(new BasicNameValuePair("email", email));
		params.add(new BasicNameValuePair("password", password));
		JSONObject json = jsonParser.getJSONFromUrl(loginURL, params);
		// return json
		// Log.e("JSON", json.toString());
		return json;
	}
	
	/**
	 * function make Login Request
	 * @param name
	 * @param email
	 * @param password
	 * @param mobile 
	 * @param lname 
	 * @param department 
	 * @param bloodgroup 
	 * @param role 
	 * @param address 
	 * */
	public JSONObject registerUser(String name, String lname, String mobile, String address, String role, String bloodgroup, String department, String email, String password){
		// Building Parameters
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("tag", register_tag));
		params.add(new BasicNameValuePair("name", name));
		params.add(new BasicNameValuePair("lname", lname));
		params.add(new BasicNameValuePair("address", address));
		params.add(new BasicNameValuePair("role", role));
		params.add(new BasicNameValuePair("bloodgroup", bloodgroup));
		params.add(new BasicNameValuePair("department", department));
		params.add(new BasicNameValuePair("mobile", mobile));
		params.add(new BasicNameValuePair("email", email));
		params.add(new BasicNameValuePair("password", password));
		
		// getting JSON Object
		JSONObject json = jsonParser.getJSONFromUrl(registerURL, params);
		// return json
		return json;
	}
	
	/**
	 * Function get Login status
	 * */
	public boolean isUserLoggedIn(Context context){
		DatabaseHandler db = new DatabaseHandler(context);
		int count = db.getRowCount();
		if(count > 0){
			// user logged in
			return true;
		}
		return false;
	}
	
	/**
	 * Function to logout user
	 * Reset Database
	 * */
	public HashMap<String, String> getUserDetails(Context context){
		
		DatabaseHandler db = new DatabaseHandler(context);
		HashMap<String, String> user= db.getUserDetails();
		return user;
	}
	
	public boolean logoutUser(Context context){
		DatabaseHandler db = new DatabaseHandler(context);
		db.resetTables();
		return true;
	}
	
}
