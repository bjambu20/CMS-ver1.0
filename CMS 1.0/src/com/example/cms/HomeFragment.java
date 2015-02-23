package com.example.cms;

import com.example.androidhive.library.UserFunctions;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class HomeFragment extends Fragment implements View.OnClickListener {
	UserFunctions userFunctions;
	Button btnLogout;
	public HomeFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		 userFunctions = new UserFunctions();
	        if(userFunctions.isUserLoggedIn(getActivity())){
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        
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
