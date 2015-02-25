package com.example.cms;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
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
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class MarksFragment extends Fragment {
	TextView tv,tv2;
	TableRow row,row2;
	TableLayout table;
	
	private static String KEY_SUCCESS = "success";
	private static String KEY_ERROR = "error";
	private static String KEY_ERROR_MSG = "error_msg";
	private static final String TAG_PRODUCTS = "products";
	private static final String TAG_PID = "pid";
	private static final String TAG_NAME = "name";
	UserFunctions userFunction = new UserFunctions();
	JSONArray products = null;
	UserFunctions userFunctions;
	public MarksFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		if (android.os.Build.VERSION.SDK_INT > 9) {
			StrictMode.ThreadPolicy policy = 
			        new StrictMode.ThreadPolicy.Builder().permitAll().build();
			StrictMode.setThreadPolicy(policy);
			}
        View rootView = inflater.inflate(R.layout.fragment_marks, container, false);
     //   HashMap<String,String> user = userFunctions.getUserDetails(getActivity());
    
        HashMap<String, String> userdetail=userFunction.getUserDetails(getActivity());
        String value="department";
        String cid=null;
        for(Map.Entry entry: userdetail.entrySet()){
            if(value.equals(entry.getKey())){
                cid = entry.getValue().toString();
                Toast.makeText(getActivity(), cid, 3000).show();
                break; //breaking because its one to one map
            }
        }

      JSONObject str=userFunction.Usermarkstable(cid);
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
