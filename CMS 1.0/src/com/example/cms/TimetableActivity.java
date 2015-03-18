package com.example.cms;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import com.example.androidhive.library.UserFunctions;

import android.app.Fragment;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class TimetableActivity extends Fragment {

	private int mRowCount = 0;
	private Spinner selectday,classid;
	String strtext = null;
	String day = null;
	private static String KEY_SUCCESS = "success";
	private static String KEY_ERROR = "error";
	private static String KEY_ERROR_MSG = "error_msg";
	private static String KEY_DAY = "day";
	String cid=null;int ci=0;
	private static String KEY_PERIOD1 = "period1";
	private static String KEY_PERIOD2 = "period2";
	private static String KEY_PERIOD3 = "period3";
	private static String KEY_PERIOD4 = "period4";
	private static String KEY_PERIOD5 = "period5";
	private static String KEY_PERIOD6 = "period6";
	private static String KEY_PERIOD7 = "period7";
	private static String KEY_PERIOD8 = "period8";
	UserFunctions userFunction = new UserFunctions();

	public TimetableActivity() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		HashMap<String, String> userdetail_role = userFunction
				.getUserDetails(getActivity());
		String role = "role";
		for (Map.Entry entry : userdetail_role.entrySet()) {
			if (role.equals(entry.getKey())) {
				role = entry.getValue().toString();
				Toast.makeText(getActivity(), cid, 3000).show();
				break; // breaking because its one to one map
			}
		}

		day = getArguments().getString("message");
		ci = getArguments().getInt("cid");
		if(0<ci)
		{
			cid=Integer.toString(ci);
		}

		if (android.os.Build.VERSION.SDK_INT > 9) {
			StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
					.permitAll().build();
			StrictMode.setThreadPolicy(policy);
		}
		View rootView = inflater.inflate(R.layout.fragment_timetable,
				container, false);

		selectday = (Spinner) rootView.findViewById(R.id.day);
		classid = (Spinner) rootView.findViewById(R.id.classid);
		Button btnLogout = (Button) rootView.findViewById(R.id.timbutton);
		if(role.equalsIgnoreCase("Student")){
			classid.setVisibility(View.GONE);
		}
		btnLogout.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// Toast.makeText(getActivity(), strtext, 3000).show();

				int d = selectday.getSelectedItemPosition();
				int cd = classid.getSelectedItemPosition();
				String arr[] = getResources().getStringArray(R.array.spinnerDay);
				String arr2[] = getResources().getStringArray(R.array.spinnerCid);
				day = arr[d];
				Intent intent = new Intent(getActivity().getBaseContext(),MainActivity.class);
				intent.putExtra("message", day);
				intent.putExtra("cid", cd);
				getActivity().startActivity(intent);
				getActivity().finish();
			}
		});

		if (day != null && day != "day") {
			Toast.makeText(getActivity(), day, 3000).show();
			HashMap<String, String> user = new HashMap<String, String>();
			HashMap<String, String> userdetail = userFunction
					.getUserDetails(getActivity());
			String value = "department";
			if(cid == null){
			for (Map.Entry entry : userdetail.entrySet()) {
				if (value.equals(entry.getKey())) {
					cid = entry.getValue().toString();
					Toast.makeText(getActivity(), cid, 3000).show();
					break; // breaking because its one to one map
				}
			}}
			JSONObject str = userFunction.Usertimetable(cid, day);
			try {
				JSONObject json_user = str.getJSONObject("user");
				if(json_user.getString(KEY_PERIOD1)!="null"){
				user.put("Period 1", json_user.getString(KEY_PERIOD1));
				user.put("Period 2", json_user.getString(KEY_PERIOD2));
				user.put("Period 3", json_user.getString(KEY_PERIOD3));
				user.put("Period 4", json_user.getString(KEY_PERIOD4));
				user.put("Period 5", json_user.getString(KEY_PERIOD5));
				user.put("Period 6", json_user.getString(KEY_PERIOD6));
				user.put("Period 7", json_user.getString(KEY_PERIOD7));
				user.put("Period 8", json_user.getString(KEY_PERIOD8));
				} else {
					user.put("","Will update soon" );
				}
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (Map.Entry entry : user.entrySet()) {
				mRowCount++;
				TableLayout table = (TableLayout) rootView
						.findViewById(R.id.the_table);
				TableRow row = new TableRow(this.getActivity());
				TextView tv1 = new TextView(this.getActivity());
				TextView tv = new TextView(this.getActivity());
				tv.setText(entry.getKey().toString());
				tv1.setText(entry.getValue().toString());
				tv.setGravity(Gravity.CENTER);
				row.addView(tv);
				row.addView(tv1);
				table.addView(row);

				System.out.println(entry.getKey() + ", " + entry.getValue());
			}
			//
		}
		 // new CountDownTask().execute();
		return rootView;
	}
	 private class CountDownTask extends AsyncTask<Void, Integer, Void>{
	    	
	    	// A callback method executed on UI thread on starting the task
	    	@Override
	    	protected void onPreExecute() {
	    		// Getting reference to the TextView tv_counter of the layout activity_main
//	    		TextView tvCounter = (TextView) findViewById(R.id.tv_counter);
//	    		tvCounter.setText("******** Countdown Starts ********");
	    		Toast.makeText(getActivity(), "******** Countdown Starts ********", 1000).show();
	    	}

	    	// A callback method executed on non UI thread, invoked after 
	    	// onPreExecute method if exists
			@Override
			protected Void doInBackground(Void... params) {
				for(int i=10;i>=0;i--){
					try {
						Thread.sleep(1000);
						publishProgress(i); // Invokes onProgressUpdate()
					} catch (InterruptedException e) {
					}
				}
				return null;
			}
			
			// A callback method executed on UI thread, invoked by the publishProgress() 
			// from doInBackground() method
			@Override
			protected void onProgressUpdate(Integer... values) {
				// Getting reference to the TextView tv_counter of the layout activity_main
				//TextView tvCounter = (TextView) findViewById(R.id.tv_counter);
				
				// Updating the TextView 
				//tvCounter.setText( Integer.toString(values[0].intValue()));		
	    		Toast.makeText(getActivity(), Integer.toString(values[0].intValue()), 1000).show();

			}
			
			// A callback method executed on UI thread, invoked after the completion of the task
			@Override
			protected void onPostExecute(Void result) {
				// Getting reference to the TextView tv_counter of the layout activity_main
				//TextView tvCounter = (TextView) findViewById(R.id.tv_counter);
				//tvCounter.setText("******** DONE ********");	
				Toast.makeText(getActivity(), "******** Done ********", 1000).show();
	    	
			}		
	    }

}
