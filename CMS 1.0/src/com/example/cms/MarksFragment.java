package com.example.cms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.example.androidhive.library.UserFunctions;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class MarksFragment extends Fragment {
	TextView tv,tv2;
	TableRow row,row2;
	private Spinner testspinner,subspinner,classid;
	TableLayout table;
	String test,sub;
	JSONObject str;
	String cid=null,depid=null;int ci=0;
	private static String KEY_SUCCESS = "success";
	private static String KEY_ERROR = "error";
	private static String KEY_ERROR_MSG = "error_msg";
	private static final String TAG_PRODUCTS = "products";
	private static final String TAG_PID = "pid";
	private static final String TAG_NAME = "name";
	UserFunctions userFunction = new UserFunctions();
	JSONArray products = null;
	UserFunctions userFunctions;
	private ProgressDialog pDialog;
	public MarksFragment(){}
	
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
		test=getArguments().getString("message");
		sub=getArguments().getString("message1");
		ci = getArguments().getInt("cid");
		if(0<ci)
		{
			cid=Integer.toString(ci);
		}
		if (android.os.Build.VERSION.SDK_INT > 9) {
			StrictMode.ThreadPolicy policy = 
			        new StrictMode.ThreadPolicy.Builder().permitAll().build();
			StrictMode.setThreadPolicy(policy);
			}
        View rootView = inflater.inflate(R.layout.fragment_marks, container, false);
         HashMap<String, String> userdetail=userFunction.getUserDetails(getActivity());
        String value="uid";
        String clid="department";
        if(cid==null){
        for(Map.Entry entry: userdetail.entrySet()){
            if(value.equals(entry.getKey())){
                cid = entry.getValue().toString();
                Toast.makeText(getActivity(), cid, 3000).show();
                break;             }
        }
        for(Map.Entry entry: userdetail.entrySet()){
            if(clid.equals(entry.getKey())){
                depid = entry.getValue().toString();
                Toast.makeText(getActivity(), cid, 3000).show();
                break;             }
        }
        }
        testspinner = (Spinner) rootView.findViewById(R.id.spinnerTest);
        subspinner =  (Spinner) rootView.findViewById(R.id.spinnerSub);
        classid =  (Spinner) rootView.findViewById(R.id.spinnerClassid);
    	Button btnLogout = (Button) rootView.findViewById(R.id.timbutton);
    	if(role.equalsIgnoreCase("Student")){
			classid.setVisibility(View.GONE);
		}
		btnLogout.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// Toast.makeText(getActivity(), strtext, 3000).show();

				int d = testspinner.getSelectedItemPosition();
				int s = subspinner.getSelectedItemPosition();
				int cd = classid.getSelectedItemPosition();
				String arr[] = getResources().getStringArray(R.array.spinnerTest);
				test = arr[d];
				String arr1[] = getResources().getStringArray(R.array.spinnerSub);
				sub=arr1[s];
				Intent intent = new Intent(getActivity().getBaseContext(),
						MainActivity.class);
				intent.putExtra("message", test);
				intent.putExtra("message1", sub);
				intent.putExtra("cid", cd);
				getActivity().startActivity(intent);
				getActivity().finish();
			}
		});
        if(test!=null&&sub!=null){
        	
        	if(role.equalsIgnoreCase("student")){
//        		new LoadAllUsers().execute();
        		str=userFunction.Usermarkstable(cid,test,sub,depid);
        		}
        	else{
        		str=userFunction.Facultymarkstable(cid,test,sub);	
        	}
        	
        try {
 		
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
      
        }

        return rootView;
    }
	class LoadAllUsers extends AsyncTask<String, String, String> {

		/**
		 * Before starting background thread Show Progress Dialog
		 * */
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pDialog = new ProgressDialog(getActivity());
			pDialog.setMessage("SignIn. Please wait...");
			pDialog.setIndeterminate(false);
			pDialog.setCancelable(false);
			pDialog.show();
		}

		/**
		 * getting All products from url
		 * */
		protected String doInBackground(String... args) {
			Log.i("all products", "3");
			// String id1 = "12";
			// Building Parameters
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			// params.add(new BasicNameValuePair("pid", strUsername));
			// params.add(new BasicNameValuePair("username", strUsername));
			// params.add(new BasicNameValuePair("password", strPassword));
			// getting JSON string from URL
			
			str=userFunction.Usermarkstable(cid,test,sub,depid);
			 try {
			 		
			 		products = str.getJSONArray(TAG_PRODUCTS);

					// looping through All Products
					for (int i = 0; i < products.length(); i++) {
						JSONObject c = products.getJSONObject(i);

						// Storing each json item in variable
						String id = c.getString(TAG_PID);
						String name = c.getString(TAG_NAME);
						TableLayout table = (TableLayout)getActivity().findViewById(R.id.the_table);
						//TableLayout table =(TableLayout) getActivity()R.id.the_table;
			 			TableRow row = new TableRow(getActivity());
			 			TextView tv1 = new TextView(getActivity());
			 			TextView tv = new TextView(getActivity());
			 			tv.setText(id);
			 			tv1.setText(name);
			 			tv.setGravity(Gravity.CENTER);
			 			row.addView(tv);row.addView(tv1);
			 			table.addView(row);

					}
			 	} catch (JSONException e) {
			 		// TODO Auto-generated catch block
			 	}

			return null;
		}

		/**
		 * After completing background task Dismiss the progress dialog
		 * **/
		protected void onPostExecute(Void result) {
				// Getting reference to the TextView tv_counter of the layout activity_main
				//TextView tvCounter = (TextView) findViewById(R.id.tv_counter);
				//tvCounter.setText("******** DONE ********");	
				Toast.makeText(getActivity(), "******** Done ********", 1000).show();
	    	
			}		
	}

}
