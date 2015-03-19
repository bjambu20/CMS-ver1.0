package com.example.cms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
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
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class WhatsHotFragment extends Fragment {
	private ProgressDialog pDialog;
	ArrayList<HashMap<String, String>> productsList;
	UserFunctions userFunction = new UserFunctions();
	JSONArray products = null;
	JSONObject str;
	private static final String TAG_PRODUCTS = "products";
	private static final String TAG_PID = "pid";
	private static final String TAG_NAME = "name";
	public WhatsHotFragment(){}
	
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		if (android.os.Build.VERSION.SDK_INT > 9) {
			StrictMode.ThreadPolicy policy = 
			        new StrictMode.ThreadPolicy.Builder().permitAll().build();
			StrictMode.setThreadPolicy(policy);
			}
        View rootView = inflater.inflate(R.layout.fragment_busroute, container, false);
        HashMap<String, String> user = new HashMap<String, String>();
        //new LoadAllProducts().execute();
        str =userFunction.busdetails();
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
	class LoadAllProducts extends AsyncTask<String, String, String> {

		/**
		 * Before starting background thread Show Progress Dialog
		 * */
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pDialog = new ProgressDialog(getActivity());
			pDialog.setMessage("Loading details, Please wait...");
			pDialog.setIndeterminate(false);
			pDialog.setCancelable(false);
			pDialog.show();
		}

		/**
		 * getting All products from url
		 * */
		protected String doInBackground(String... args) {
			for (int i = 0; i < 100; i++){} 
			return null;
			
		}

		/**
		 * After completing background task Dismiss the progress dialog
		 * **/
		protected void onPostExecute(String file_url) {
			// dismiss the dialog after getting all products
			pDialog.dismiss();
			// updating UI from Background Thread
			

		}

	}

}
