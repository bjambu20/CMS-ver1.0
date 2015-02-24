package com.example.cms;

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
			
       		
		}
	});
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
