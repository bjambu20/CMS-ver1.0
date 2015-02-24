package com.example.cms;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import com.example.androidhive.library.UserFunctions;
import android.app.Fragment;
import android.os.Bundle;
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
 
        View rootView = inflater.inflate(R.layout.fragment_timetable, container, false);
        

       Button  btnLogout= (Button) rootView.findViewById(R.id.timbutton);
       btnLogout.setOnClickListener(new OnClickListener() {
    	  
    	   
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Toast.makeText(getActivity(), "Done", 3000).show();
		   	   String class_id="1";
		   	   
		       
		   	UserFunctions userFunction = new UserFunctions();
			JSONObject json = userFunction.registerUser2(class_id);
			
//		     try {
//				String str=json.getString(KEY_SUCCESS);
//				str=json.getString(KEY_DAY);
//				str=json.getString(KEY_PERIOD1);
//				str=json.getString(KEY_PERIOD2);
//				str=json.getString(KEY_PERIOD3);
//				str=json.getString(KEY_PERIOD4);
//				str=json.getString(KEY_PERIOD5);
//				str=json.getString(KEY_PERIOD6);
//				str=json.getString(KEY_PERIOD7);
//				str=json.getString(KEY_PERIOD8);
//			} catch (JSONException e) {
//				
//				e.printStackTrace();
//			}
//		        
		}
	});
       
       
       HashMap<String,String> user = userFunction.getUserDetails(getActivity());
       
       
       for(int i=0;i<7;i++){ 
    	   
       table = (TableLayout)rootView.findViewById(R.id.the_table);
  		row = new TableRow(this.getActivity());
  		row2 = new TableRow(this.getActivity());
  		tv = new TextView(this.getActivity());
  		tv2 = new TextView(this.getActivity());
		mRowCount++;
  		tv.setText("Period "+Integer.toString(mRowCount));
  		tv2.setText("Sub "+Integer.toString(mRowCount));
  		tv.setGravity(Gravity.LEFT);
  		tv2.setGravity(Gravity.LEFT);
  		row.addView(tv);
  		row.addView(tv2);
  		table.addView(row);
       }	
        return rootView;
    }

	
}
