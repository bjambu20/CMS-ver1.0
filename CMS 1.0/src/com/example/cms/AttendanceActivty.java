package com.example.cms;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.example.androidhive.library.UserFunctions;

import android.app.Fragment;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class AttendanceActivty extends Fragment {
	private int mRowCount = 0;
	
	
	TextView tv,tv2;
	TableRow row,row2;
	TableLayout table;
	
	private static String KEY_SUCCESS = "success";
	private static String KEY_ERROR = "error";
	private static String KEY_ERROR_MSG = "error_msg";
	private static String KEY_DAY = "day";
	private static String KEY_PERIOD1 = "value";
	UserFunctions userFunction = new UserFunctions();

	
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
        JSONObject str=userFunction.Userattendancetable("12");
        try {
 		JSONObject json_user = str.getJSONObject("user");
 		Toast.makeText(getActivity(), json_user.getString(KEY_SUCCESS), 3000).show();
 		Toast.makeText(getActivity(), json_user.getString(KEY_DAY), 3000).show();
 		Toast.makeText(getActivity(), json_user.getString(KEY_PERIOD1), 3000).show();
 		user.put("sub1", json_user.getString(KEY_DAY));
 		user.put("sub2", json_user.getString(KEY_PERIOD1));
 		
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
// 			tv1.setGravity(gravity)
 			row.addView(tv);row.addView(tv1);
 			table.addView(row);
 			
        	System.out.println(entry.getKey() + ", " + entry.getValue());
        }

        return rootView;
    }
}
