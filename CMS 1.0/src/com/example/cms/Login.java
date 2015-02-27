/**
 * Author: Ravi Tamada
 * URL: www.androidhive.info
 * twitter: http://twitter.com/ravitamada
 * */
package com.example.cms;

import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.androidhive.library.DatabaseHandler;
import com.example.androidhive.library.UserFunctions;

public class Login extends Activity {
	Button btnLogin,register;
	TextView btnLinkToRegister;
	EditText inputEmail;
	EditText inputPassword;
	TextView loginErrorMsg;

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
	UserFunctions userFunction = new UserFunctions();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		if (android.os.Build.VERSION.SDK_INT > 9) {
		    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		    StrictMode.setThreadPolicy(policy);
		}

		// Importing all assets like buttons, text fields
		inputEmail = (EditText) findViewById(R.id.loginEmail);
		inputPassword = (EditText) findViewById(R.id.loginPassword);
		btnLogin = (Button) findViewById(R.id.btnLogin);
		register = (Button) findViewById(R.id.register);
		loginErrorMsg = (TextView) findViewById(R.id.login_error);
		HandleClick hc = new HandleClick();
		findViewById(R.id.barsacn).setOnClickListener(hc);
		// Login button Click Event
		btnLogin.setOnClickListener(new View.OnClickListener() {

			public void onClick(View view) {
				String email = inputEmail.getText().toString();
				String password = inputPassword.getText().toString();
				
				Log.d("Button", "Login");
				JSONObject json = userFunction.loginUser(email, password);

				// check for login response
				try {
					
					
					if (json.getString(KEY_SUCCESS) =="0") {
						loginErrorMsg.setText("");
						JSONObject json_user = json.getJSONObject("user");
						String res = json_user.getString(KEY_SUCCESS); 
						if(Integer.parseInt(res) == 1){
							DatabaseHandler db = new DatabaseHandler(getApplicationContext());
							userFunction.logoutUser(getApplicationContext());
							db.addUser(json_user.getString(KEY_UID),json_user.getString(KEY_EMAIL),json_user.getString(KEY_ADDRESS),json_user.getString(KEY_ROLE),json_user.getString(KEY_DEPARTMENT),json_user.getString(KEY_MOBILE),json_user.getString(KEY_LNAME),json_user.getString(KEY_NAME));							// Launch Dashboard Screen
							Intent dashboard = new Intent(getApplicationContext(), MainActivity.class);
							dashboard.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
							startActivity(dashboard);
							finish();
						}else{
							// Error in login
							loginErrorMsg.setText("Incorrect username/password");
							Toast.makeText(getApplicationContext(), "Incorrect username/password", 3000).show();
						}
					}else{
						// Error in login
						loginErrorMsg.setText("Incorrect username/password");
						Toast.makeText(getApplicationContext(), "Incorrect username/password", 3000).show();
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		});

		// Link to Register Screen
		register.setOnClickListener(new View.OnClickListener() {

			public void onClick(View view) {
				Intent i = new Intent(getApplicationContext(),
						RegisterActivity.class);
				startActivity(i);
				finish();
			}
		});
	}
	  private class HandleClick implements OnClickListener{
		    public void onClick(View arg0) {
		      Intent intent = new Intent("com.google.zxing.client.android.SCAN");
		      switch(arg0.getId()){
//		        case R.id.butQR:
//		          intent.putExtra("SCAN_MODE", "PRODUCT_MODE");QR_CODE_MODE
//		        break;
		        case R.id.barsacn:
		          intent.putExtra("SCAN_MODE", "CODE_39,CODE_93,CODE_128,DATA_MATRIX,ITF");
		        break;
//		        case R.id.butOther:
//		          intent.putExtra("SCAN_FORMATS", "");
//		        break;
		      }
		      startActivityForResult(intent, 0);    //Barcode Scanner to scan for us
		    }
		  }
	  public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		    if (requestCode == 0) {
//		      TextView tvStatus=(TextView)findViewById(R.id.tvResult);
//		      TextView tvResult=(TextView)findViewById(R.id.tvStatus);
		      if (resultCode == RESULT_OK) {
//		        tvStatus.setText(intent.getStringExtra("SCAN_RESULT_FORMAT"));
//		        tvResult.setText(intent.getStringExtra("SCAN_RESULT"));
		    	  Toast.makeText(getApplicationContext(), intent.getStringExtra("SCAN_RESULT_FORMAT"), 3000).show();
			        Toast.makeText(getApplicationContext(), intent.getStringExtra("SCAN_RESULT"), 3000).show();
			        JSONObject json = userFunction.loginUserbyID(intent.getStringExtra("SCAN_RESULT"));
			        try {
						JSONObject json_user = json.getJSONObject("user");
						if (json_user.getString(KEY_SUCCESS) != null) {
							loginErrorMsg.setText("");
							String res = json_user.getString(KEY_SUCCESS); 
							if(Integer.parseInt(res) == 1){
								DatabaseHandler db = new DatabaseHandler(getApplicationContext());
								userFunction.logoutUser(getApplicationContext());
								db.addUser(json_user.getString(KEY_UID),json_user.getString(KEY_EMAIL),json_user.getString(KEY_ADDRESS),json_user.getString(KEY_ROLE),json_user.getString(KEY_DEPARTMENT),json_user.getString(KEY_MOBILE),json_user.getString(KEY_LNAME),json_user.getString(KEY_NAME));							// Launch Dashboard Screen
								Intent dashboard = new Intent(getApplicationContext(), MainActivity.class);
								dashboard.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
								startActivity(dashboard);
								finish();
							}else{
								// Error in login
								loginErrorMsg.setText("Incorrect username/password");
							}
						}
					} catch (JSONException e) {
						e.printStackTrace();
					}
		      } else if (resultCode == RESULT_CANCELED) {
		        Toast.makeText(getApplicationContext(), "Press a button to start a scan", 3000).show();
		        Toast.makeText(getApplicationContext(), "Scan cancelled", 3000).show();
//		        tvResult.setText("Scan cancelled.");
		      }
		    }
		  }
}
