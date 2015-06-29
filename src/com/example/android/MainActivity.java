package com.example.androidhive;

import java.util.ArrayList;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import android.widget.TextView;

public class MainActivity extends Activity {

	String data = "";
	TableLayout tl;
	//TableLayout t2;
	TableRow tr;
	TextView label;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		tl = (TableLayout) findViewById(R.id.maintable);

		final GetDataFromDB getdb = new GetDataFromDB();
		new Thread(new Runnable() {
			public void run() {
				data = getdb.getDataFromDB();
				System.out.println(data);
				
				runOnUiThread(new Runnable() {
					
					public void run() {
						ArrayList<Users> users = parseJSON(data);
						addData(users);						
					}
				});
				
			}
		}).start();
	}

	public ArrayList<Users> parseJSON(String result) {
		ArrayList<Users> users = new ArrayList<Users>();
		try {
			JSONArray jArray = new JSONArray(result);
			for (int i = 0; i < jArray.length(); i++) {
				JSONObject json_data = jArray.getJSONObject(i);
				Users user = new Users();
				user.setDEVID(json_data.getInt("DevID"));
				
				user.setDATE(json_data.getInt("Date"));
				user.setSENSORTYPE(json_data.getString("SensorType"));
				user.setREADING(json_data.getString("Reading"));
			
		
				
			users.add(user);
			}
		} catch (JSONException e) {
			Log.e("log_tag", "Error parsing data " + e.toString());  
		}
		return users;
	}

	void addHeader(){
		/** Create a TableRow dynamically **/
		tr = new TableRow(this);

		/** Creating a TextView to add to the row **/
		label = new TextView(this);
		label.setText("DevID");
		label.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT));
		label.setPadding(1, 1, 1, 1);
		label.setBackgroundColor(Color.RED);
		LinearLayout Ll = new LinearLayout(this);
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,
				LayoutParams.WRAP_CONTENT);
		params.setMargins(1, 1, 1, 1);
		//Ll.setPadding(10, 5, 5, 5);
		Ll.addView(label,params);
		tr.addView((View)Ll); // Adding textView to tablerow.

		/** Creating Qty Button **/
		TextView Date = new TextView(this);
		Date.setText("Date");
		Date.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT));
		Date.setPadding(1, 1, 1, 1);
		Date.setBackgroundColor(Color.RED);
		Ll = new LinearLayout(this);
		params = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,
				LayoutParams.WRAP_CONTENT);
		params.setMargins(0, 1, 1, 1);
		//Ll.setPadding(10, 5, 5, 5);
		Ll.addView(Date,params);
		tr.addView((View)Ll); // Adding textview to tablerow.

		 // Add the TableRow to the TableLayout
   
      TextView SensorType = new TextView(this);
		SensorType.setText("SensorType");
		SensorType.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT));
		SensorType.setPadding(1, 1, 1, 1);
		SensorType.setBackgroundColor(Color.BLUE);
		Ll = new LinearLayout(this);
		params = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,
				LayoutParams.WRAP_CONTENT);
		params.setMargins(0, 1, 1, 1);
		//Ll.setPadding(10, 5, 5, 5);
		Ll.addView(SensorType,params);
		tr.addView((View)Ll); // Adding textview to tablerow.
		//////////////////
		TextView Reading = new TextView(this);
		Reading.setText("Reading");
		Reading.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT));
		Reading.setPadding(1, 1, 1, 1);
		Reading.setBackgroundColor(Color.CYAN);
		Ll = new LinearLayout(this);
		params = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,
				LayoutParams.WRAP_CONTENT);
		params.setMargins(0, 1, 1, 1);
		//Ll.setPadding(10, 5, 5, 5);
		Ll.addView(Reading,params);
		tr.addView((View)Ll); // Adding textview to tablerow.
		
		/////////////////////
		
		
	     tl.addView(tr, new TableLayout.LayoutParams(
	                LayoutParams.FILL_PARENT,
	                LayoutParams.WRAP_CONTENT));
		 // Add the TableRow to the TableLayout
        

	}
	
	@SuppressWarnings({ "rawtypes" })
	public void addData(ArrayList<Users> users) {

		addHeader();
		
		for (Iterator i = users.iterator(); i.hasNext();) {

			Users p = (Users) i.next();
			

			/** Create a TableRow dynamically **/
			tr = new TableRow(this);

			/** Creating a TextView to add to the row **/
			label = new TextView(this);
			label.setText(p.getDEVID());
			label.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
					LayoutParams.WRAP_CONTENT));
			label.setPadding(5, 5, 5, 5);
			label.setBackgroundColor(Color.GRAY);
			LinearLayout Ll = new LinearLayout(this);
			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,
					LayoutParams.WRAP_CONTENT);
			params.setMargins(5, 2, 2, 2);
			//Ll.setPadding(10, 5, 5, 5);
			Ll.addView(label,params);
			tr.addView((View)Ll); // Adding textView to tablerow.

			/** Creating Qty Button **/
			TextView Date = new TextView(this);
			Date.setText(p.getDATE());
			Date.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
					LayoutParams.WRAP_CONTENT));
			Date.setPadding(5, 5, 5, 5);
			Date.setBackgroundColor(Color.GRAY);
			Ll = new LinearLayout(this);
			params = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,
					LayoutParams.WRAP_CONTENT);
			params.setMargins(0, 2, 2, 2);
			//Ll.setPadding(10, 5, 5, 5);
			Ll.addView(Date,params);
			tr.addView((View)Ll); // Adding textview to tablerow.

			TextView SensorType = new TextView(this);
			SensorType.setText(p.getSENSORTYPE());
			SensorType.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
					LayoutParams.WRAP_CONTENT));
			SensorType.setPadding(5, 5, 5, 5);
			SensorType.setBackgroundColor(Color.GRAY);
			Ll = new LinearLayout(this);
			params = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,
					LayoutParams.WRAP_CONTENT);
			params.setMargins(0, 2, 2, 2);
			//Ll.setPadding(10, 5, 5, 5);
			Ll.addView(SensorType,params);
			tr.addView((View)Ll);
			////////////
			
			TextView Reading = new TextView(this);
			Reading.setText(p.getREADING());
			Reading.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
					LayoutParams.WRAP_CONTENT));
			Reading.setPadding(5, 5, 5, 5);
			Reading.setBackgroundColor(Color.GRAY);
			Ll = new LinearLayout(this);
			params = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,
					LayoutParams.WRAP_CONTENT);
			params.setMargins(0, 2, 2, 2);
			//Ll.setPadding(10, 5, 5, 5);
			Ll.addView(Reading,params);
			tr.addView((View)Ll);
			
			
			
			
			/////////////
			 // Add the TableRow to the TableLayout
            tl.addView(tr, new TableLayout.LayoutParams(
                    LayoutParams.FILL_PARENT,
                    LayoutParams.WRAP_CONTENT));
            
		}
	}
}
