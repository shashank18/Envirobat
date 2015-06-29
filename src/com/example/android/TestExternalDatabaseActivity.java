package com.example.androidhive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

//import com.example.bundle.third;

//import com.example.bundle.R;

import android.os.Bundle;
import android.os.StrictMode;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TestExternalDatabaseActivity extends Activity {
	TextView resultview;
	StringBuffer buffer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main1);
		StrictMode.enableDefaults();
		resultview=(TextView)findViewById(R.id.result);
		getData();
		Button b1=(Button) findViewById(R.id.b2);
		 final TextView tv=(TextView)findViewById(R.id.result);
		b1.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) 
			{
			      // TODO Auto-generated method stub
			      
			    	 String result=tv.getText().toString();
			      //long phone=Long.parseLong(editTExtPhone.getText().toString());
			      
			      // create a new intent
			      Intent intent =new Intent(getApplicationContext(),BluetoothChat.class);
			      // put the name and phone(to be sent to other activity) in intent
			      intent.putExtra("PERSON_NAME", result);
			      //intent.putExtra("PHONENUMBER", phone);
			      
			      // start the second activity
			      startActivity(intent);
			     }
				// TODO Auto-generated method stub
			
			
		});
	}
	public void getData()
	{
		String result="";
		InputStream isr=null;
		try{
			HttpClient httpclient=new DefaultHttpClient();
			HttpPost httppost=new HttpPost("http://shashankmirji.comuf.com/database1.php");
			HttpResponse response=httpclient.execute(httppost);
			HttpEntity entity=response.getEntity();
			isr=entity.getContent();
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			resultview.setText("Shashank something is problem in database connection");
		}
		try
		{
			BufferedReader reader=new BufferedReader(new InputStreamReader(isr,"iso-8859-1"),8);
			StringBuilder sb=new StringBuilder();
			String line=null;
			while((line=reader.readLine())!=null)
			{
				sb.append(line +"\n");
			}
			isr.close();
			result=sb.toString();
		}
		catch (Exception e) 
		{
			
			// TODO: handle exception
			resultview.setText("Shashank something is problem in coversion to string");
			
		}
		
		try{
			String s="";
			JSONArray jArray=new JSONArray(result);
			for(int i=0;i<jArray.length();i++)
			{
				JSONObject json=jArray.getJSONObject(i);
			s=s+
					"SensorName :  "+json.getString("SensorName")+"\n"+
					"SensorValue :  "+json.getInt("SensorValue")+"\n";
			}
			
			resultview.setText(s); 
			Toast.makeText(getApplicationContext(),s.toString(), 1).show();	
			}
		catch (Exception e) {
			// TODO: handle exception
			resultview.setText("Shashank something is problem in JSON scriting ");
		}
	}
}
				
			