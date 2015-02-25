package com.example.cms;

import java.util.HashMap;
import java.util.Map;

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
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class TimetableActivity extends Fragment {
	
	private int mRowCount = 0;
	private Spinner day;
	
	TextView tv,tv2;
	TableRow row,row2;
	TableLayout table;
	
	private static String KEY_SUCCESS = "success";
	private static String KEY_ERROR = "error";
	private static String KEY_ERROR_MSG = "error_msg";
	private static String KEY_DAY = "day";
	private static String KEY_PERIOD1 = "period1";
	private static String KEY_PERIOD2 = "period2";
	private static String KEY_PERIOD3 = "period3";
	private static String KEY_PERIOD4 = "period4";
	private static String KEY_PERIOD5 = "period5";
	private static String KEY_PERIOD6 = "period6";
	private static String KEY_PERIOD7 = "period7";
	private static String KEY_PERIOD8 = "period8";
	 UserFunctions userFunction = new UserFunctions();
	
	public TimetableActivity(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		if (android.os.Build.VERSION.SDK_INT > 9) {
			StrictMode.ThreadPolicy policy = 
			        new StrictMode.ThreadPolicy.Builder().permitAll().build();
			StrictMode.setThreadPolicy(policy);
			}
        View rootView = inflater.inflate(R.layout.fragment_timetable, container, false);
        

       Button  btnLogout= (Button) rootView.findViewById(R.id.timbutton);
       btnLogout.setOnClickListener(new OnClickListener() {
    	  
    	   
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Toast.makeText(getActivity(), "Done", 3000).show();
			Intent i = new Intent(getActivity(), MainActivity.class);
			startActivity(i);
		   
		}
	});
       
       HashMap<String,String> user = new HashMap<String,String>();
       JSONObject str=userFunction.Usertimetable("12");
       try {
		JSONObject json_user = str.getJSONObject("user");
		Toast.makeText(getActivity(), json_user.getString(KEY_SUCCESS), 3000).show();
		Toast.makeText(getActivity(), json_user.getString(KEY_DAY), 3000).show();
		Toast.makeText(getActivity(), json_user.getString(KEY_PERIOD1), 3000).show();
		user.put("sub1", json_user.getString(KEY_PERIOD1));
		user.put("sub2", json_user.getString(KEY_PERIOD2));
		user.put("sub3", json_user.getString(KEY_PERIOD3));
		user.put("sub4", json_user.getString(KEY_PERIOD4));
		user.put("sub5", json_user.getString(KEY_PERIOD5));
		user.put("sub6", json_user.getString(KEY_PERIOD6));
		user.put("sub7", json_user.getString(KEY_PERIOD7));
		user.put("sub8", json_user.getString(KEY_PERIOD8));
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       for (Map.Entry entry : user.entrySet()) {
       	mRowCount++;
       	TableLayout table = (TableLayout)rootView.findViewById(R.id.the_table);
			TableRow row = new TableRow(this.getActivity());
			TextView tv1 = new TextView(this.getActivity());
			TextView tv = new TextView(this.getActivity());
			tv.setText(entry.getKey().toString());
			tv1.setText(entry.getValue().toString());
			tv.setGravity(Gravity.CENTER);
//			tv1.setGravity(gravity)
			row.addView(tv);row.addView(tv1);
			table.addView(row);
			
       	System.out.println(entry.getKey() + ", " + entry.getValue());
       }
        return rootView;
    }

	
}
