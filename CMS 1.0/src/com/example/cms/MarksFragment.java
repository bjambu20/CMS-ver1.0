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
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class MarksFragment extends Fragment {
	TextView tv,tv2;
	TableRow row,row2;
	private Spinner testspinner,subspinner;
	TableLayout table;
	String test,sub;
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
		test=getArguments().getString("message");
		sub=getArguments().getString("message1");
		if (android.os.Build.VERSION.SDK_INT > 9) {
			StrictMode.ThreadPolicy policy = 
			        new StrictMode.ThreadPolicy.Builder().permitAll().build();
			StrictMode.setThreadPolicy(policy);
			}
        View rootView = inflater.inflate(R.layout.fragment_marks, container, false);
         HashMap<String, String> userdetail=userFunction.getUserDetails(getActivity());
        String value="uid";
        String cid=null;
        for(Map.Entry entry: userdetail.entrySet()){
            if(value.equals(entry.getKey())){
                cid = entry.getValue().toString();
                Toast.makeText(getActivity(), cid, 3000).show();
                break;             }
        }
        testspinner = (Spinner) rootView.findViewById(R.id.spinnerTest);
        subspinner =  (Spinner) rootView.findViewById(R.id.spinnerSub);
    	Button btnLogout = (Button) rootView.findViewById(R.id.timbutton);
		btnLogout.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// Toast.makeText(getActivity(), strtext, 3000).show();

				int d = testspinner.getSelectedItemPosition();
				int s = subspinner.getSelectedItemPosition();
				String arr[] = getResources().getStringArray(R.array.spinnerTest);
				test = arr[d];
				String arr1[] = getResources().getStringArray(R.array.spinnerSub);
				sub=arr1[s];
				Intent intent = new Intent(getActivity().getBaseContext(),
						MainActivity.class);
				intent.putExtra("message", test);
				intent.putExtra("message1", sub);
				getActivity().startActivity(intent);
				getActivity().finish();
			}
		});
        if(test!=null&&sub!=null){
      JSONObject str=userFunction.Usermarkstable(cid,test,sub);
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
}
