/**
 * Author: Ravi Tamada
 * URL: www.androidhive.info
 * twitter: http://twitter.com/ravitamada
 * */
package com.example.cms;

import org.json.JSONException;
import org.json.JSONObject;
import com.example.androidhive.library.DatabaseHandler;
import com.example.androidhive.library.UserFunctions;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends Activity {
	Button btnRegister;
	Button btnLinkToLogin;
	EditText inputFullName;
	EditText inputLastName;
	EditText inputMobile;
	EditText inputAddress;
	EditText inputRole;
	EditText inputBloodgroup;
	EditText inputDepartment;
	EditText inputEmail;
	EditText inputPassword;
	TextView registerErrorMsg;
	private RadioGroup radioRole;
	private RadioButton radioButton;
	// JSON Response node names
	private static String KEY_SUCCESS = "success";
	private static String KEY_ERROR = "error";
	private static String KEY_ERROR_MSG = "error_msg";
	private static String KEY_UID = "uid";
	private static String KEY_NAME = "name";
	private static String KEY_LNAME = "lname";
	private static String KEY_MOBILE = "mobile";
	private static String KEY_DEPARTMENT = "department";
	private static String KEY_ROLE = "role";
	private static String KEY_ADDRESS = "address";
	private static String KEY_EMAIL = "email";
	private static String KEY_CREATED_AT = "created_at";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registration);
		if (android.os.Build.VERSION.SDK_INT > 9) {
		    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		    StrictMode.setThreadPolicy(policy);
		}

		// Importing all assets like buttons, text fields
		inputFullName = (EditText) findViewById(R.id.registerName);
		inputLastName = (EditText) findViewById(R.id.registerLname);
		inputMobile = (EditText) findViewById(R.id.registerMobile);
		inputAddress = (EditText) findViewById(R.id.registerAddress);
		inputRole = (EditText) findViewById(R.id.registerRole);
		inputBloodgroup = (EditText) findViewById(R.id.registerbloodgroup);
		inputDepartment = (EditText) findViewById(R.id.registerDepartment);
		inputEmail = (EditText) findViewById(R.id.registerEmail);
		inputPassword = (EditText) findViewById(R.id.registerPassword);
		btnRegister = (Button) findViewById(R.id.btnRegister);
		radioRole = (RadioGroup) findViewById(R.id.radioRole);
		//btnLinkToLogin = (Button) findViewById(R.id.btnLinkToLoginScreen);
		registerErrorMsg = (TextView) findViewById(R.id.register_error);
		
		// Register Button Click event
		btnRegister.setOnClickListener(new View.OnClickListener() {			
			public void onClick(View view) {
				int selectedId = radioRole.getCheckedRadioButtonId();
				 
				// find the radiobutton by returned id
			    radioButton = (RadioButton) findViewById(selectedId);
			    Toast.makeText(RegisterActivity.this,radioButton.getText(), Toast.LENGTH_SHORT).show();
				String name = inputFullName.getText().toString();
				String lname = inputLastName.getText().toString();
				String mobile = inputMobile.getText().toString();
				String address = inputAddress.getText().toString();
				String role = radioButton.getText().toString();
				String bloodgroup = inputBloodgroup.getText().toString();
				String department = inputDepartment.getText().toString();
				String email = inputEmail.getText().toString();
				String password = inputPassword.getText().toString();
				
				UserFunctions userFunction = new UserFunctions();
				JSONObject json = userFunction.registerUser(name, lname, mobile, address, role, bloodgroup, department, email, password);
				
				// check for login response
				try {
					if (json.getString(KEY_SUCCESS) != null) {
						registerErrorMsg.setText("");
						String res = json.getString(KEY_SUCCESS); 
						if(Integer.parseInt(res) == 1){
							// user successfully registred
							// Store user details in SQLite Database
							DatabaseHandler db = new DatabaseHandler(getApplicationContext());
							JSONObject json_user = json.getJSONObject("user");
							
							// Clear all previous data in database
							userFunction.logoutUser(getApplicationContext());
							String str=json_user.getString(KEY_NAME);
							str=json_user.getString(KEY_LNAME);
							str=json_user.getString(KEY_MOBILE);
							str=json_user.getString(KEY_DEPARTMENT);
							str=json_user.getString(KEY_ROLE);
							str=json_user.getString(KEY_ADDRESS);
							str=json_user.getString(KEY_EMAIL);
							str=json_user.getString(KEY_UID);
							db.addUser(json_user.getString(KEY_UID));						
							// Launch Dashboard Screen
							Intent dashboard = new Intent(getApplicationContext(), MainActivity.class);
							// Close all views before launching Dashboard
							dashboard.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
							startActivity(dashboard);
							// Close Registration Screen
							finish();
						}else{
							// Error in registration
							registerErrorMsg.setText("Error occured in registration");
						}
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		});

		// Link to Login Screen
		
	}
}
