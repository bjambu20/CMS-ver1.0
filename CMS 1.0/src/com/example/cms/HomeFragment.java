package com.example.cms;

import java.util.HashMap;
import java.util.Map;
import com.example.androidhive.library.UserFunctions;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class HomeFragment extends Fragment implements View.OnClickListener {
	UserFunctions userFunctions;
	Button btnLogout;
	String id,lname,email,address,department,name,role,mobile;
	private int mRowCount = 0;
	public HomeFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		 userFunctions = new UserFunctions();
	        if(userFunctions.isUserLoggedIn(getActivity())){
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        HashMap<String,String> user = userFunctions.getUserDetails(getActivity());
        for (Map.Entry entry : user.entrySet()) {
        	mRowCount++;
        	String str= entry.getKey().toString();
        	TableLayout table = (TableLayout)rootView.findViewById(R.id.the_table);
			TableRow row = new TableRow(this.getActivity());
			TextView tv1 = new TextView(this.getActivity());
			TextView tv = new TextView(this.getActivity());
			tv.setText(entry.getKey().toString().toUpperCase());
			tv1.setText(entry.getValue().toString());
			tv.setGravity(Gravity.CENTER);
//			tv1.setGravity(gravity)
			row.addView(tv);row.addView(tv1);
			table.addView(row);
			
        	System.out.println(entry.getKey() + ", " + entry.getValue());
        }


        btnLogout= (Button) rootView.findViewById(R.id.btnLogout);
      
    	
    	btnLogout.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(getActivity(), "Log out", 3000).show();
				userFunctions.logoutUser(getActivity());
				Intent login = new Intent(getActivity(), Login.class);
	        	login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	        	startActivity(login);
	        	// Closing dashboard screen
	        	getActivity().finish();
			}
		});
       
        return rootView;
        
        }else{
        	// user is not logged in show login screen
        	Intent login = new Intent(getActivity(), Login.class);
        	login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        	startActivity(login);
        	// Closing dashboard screen
        	getActivity().finish();
        	return null;
        }
                
    }

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}
}
