package com.example.cms;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.androidhive.library.UserFunctions;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class AttendanceActivty extends Fragment {
	private int mRowCount = 0;
	
	int ci;
	TextView tv,tv2;
	TableRow row,row2;
	TableLayout table;
	Button submit;
	EditText indate;
	Spinner classid;
	String cid=null;
	String date=null;
	JSONObject str;
	private static String KEY_SUCCESS = "success";
	private static String KEY_ERROR = "error";
	private static String KEY_ERROR_MSG = "error_msg";
	private static final String TAG_PRODUCTS = "products";
	private static final String TAG_PID = "pid";
	private static final String TAG_NAME = "name";
	UserFunctions userFunction = new UserFunctions();
	JSONArray products = null;
	
	public AttendanceActivty(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		
		
		if (android.os.Build.VERSION.SDK_INT > 9) {
			StrictMode.ThreadPolicy policy = 
			        new StrictMode.ThreadPolicy.Builder().permitAll().build();
			StrictMode.setThreadPolicy(policy);
			}
        View rootView = inflater.inflate(R.layout.fragment_attendance, container, false);
        HashMap<String,String> user = new HashMap<String,String>();
        HashMap<String, String> map = new HashMap<String, String>();
        submit=(Button) rootView.findViewById(R.id.timbutton);
        classid=(Spinner) rootView.findViewById(R.id.spinnerClassid);
        indate=(EditText) rootView.findViewById(R.id.datein);
        submit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String datein=indate.getText().toString();
				int c=classid.getSelectedItemPosition();
				Intent intent = new Intent(getActivity().getBaseContext(),
						MainActivity.class);
				intent.putExtra("date", datein);
				intent.putExtra("cid", c);
				getActivity().startActivity(intent);
				getActivity().finish();
				
			}
		});
        HashMap<String, String> userdetail=userFunction.getUserDetails(getActivity());
        ci = getArguments().getInt("cid");
        date=getArguments().getString("date");
		String role = "role";
		for (Map.Entry entry : userdetail.entrySet()) {
			if (role.equals(entry.getKey())) {
				role = entry.getValue().toString();
				break; // breaking because its one to one map
			}
		}
		if(role.equalsIgnoreCase("Student")){
			classid.setVisibility(View.GONE);
			submit.setVisibility(View.GONE);
			String value="uid";
	        for(Map.Entry entry: userdetail.entrySet()){
	            if(value.equals(entry.getKey())){
	                cid = entry.getValue().toString();
	                Toast.makeText(getActivity(), cid, 3000).show();
	                break; //breaking because its one to one map
	            }
	        }
	        str =userFunction.Userattendancetable(cid);
		}else{
			String clas=Integer.toString(ci);
			str =userFunction.Userattendancetable(clas,date);
		}
	        
       
        try {
 		//JSONObject json_user = str.getJSONObject("user");
 		products = str.getJSONArray(TAG_PRODUCTS);

		// looping through All Products
		for (int i = 0; i < products.length(); i++) {
			JSONObject c = products.getJSONObject(i);

			// Storing each json item in variable
			String id = c.getString(TAG_PID);
			String name = c.getString(TAG_NAME);
			TableLayout table = (TableLayout)rootView.findViewById(R.id.the_table);
 			TableRow row = new TableRow(this.getActivity());
 			TextView tv1 = new TextView(this.getActivity());
 			TextView tv = new TextView(this.getActivity());
 			tv.setText(id);
 			tv1.setText(name);
 			tv.setGravity(Gravity.CENTER);
 			row.addView(tv);row.addView(tv1);
 			table.addView(row);

		}
 	} catch (JSONException e) {
 		// TODO Auto-generated catch block
 		e.printStackTrace();
 	}
      
     
        return rootView;
    }
}
