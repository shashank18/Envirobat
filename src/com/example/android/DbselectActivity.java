package com.example.androidhive;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.TableRow.LayoutParams;

public class DbselectActivity extends Activity
{
	
	
	 public void onCreate(Bundle savedInstanceState)
	 
	 {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.main8);
	        
	        Button button = (Button) findViewById(R.id.button1);
	       
	        button.setOnClickListener(new View.OnClickListener()
	        {
	        public void onClick(View view) 
	          {
	             String result = null;
	        	InputStream is = null;
	        	
	        	try{
	        	        HttpClient httpclient = new DefaultHttpClient();
	        	        HttpPost httppost = new HttpPost("http://sindhu.ece.iisc.ernet.in/mainserver/android_showdevicedb.php");
	        	        HttpResponse response = httpclient.execute(httppost); 
	        	        HttpEntity entity = response.getEntity();
	        	        is = entity.getContent();

	        	        Log.e("log_tag", "connection success ");
	        	     //   Toast.makeText(getApplicationContext(), "pass", Toast.LENGTH_SHORT).show();
	        	}
	        	catch(Exception e)
	        	{
	        	        Log.e("log_tag", "Error in http connection "+e.toString());
	        	        Toast.makeText(getApplicationContext(), "Connection fail", Toast.LENGTH_SHORT).show();

	        	}
	        	//convert response to string
	        	try
	        	{
	        	        BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
	        	        StringBuilder sb = new StringBuilder();
	        	        String line = null;
	        	        while ((line = reader.readLine()) != null) 
	        	        {
	        	                sb.append(line + "\n");
	        	              //  Toast.makeText(getApplicationContext(), "Input Reading pass", Toast.LENGTH_SHORT).show();
	        	        }
	        	        is.close();

	        	        result=sb.toString();
	        	}
	        	catch(Exception e)
	        	{
	        	       Log.e("log_tag", "Error converting result "+e.toString());
	        	    Toast.makeText(getApplicationContext(), " Input reading fail", Toast.LENGTH_SHORT).show();

	        	}

	        	//parse json data
	        	try
	        	{
	        
	        	JSONArray jArray = new JSONArray(result);
	        	
	   
	        	String re=jArray.getString(jArray.length()-1);
	        	
	
	        	TableLayout tv=(TableLayout) findViewById(R.id.table);
	        	tv.removeAllViewsInLayout();
	            
	           
	            
	            
	        	   int flag=1;
	        	 
	        	for(int i=-1;i<jArray.length()-1;i++)
	        	        
	        	        {
	        	        	 
	        	              
	        	              
	        	              
	        		            TableRow tr=new TableRow(DbselectActivity.this);
	        		            
	        		            tr.setLayoutParams(new LayoutParams(
	        		                       LayoutParams.FILL_PARENT,
	        		                       LayoutParams.WRAP_CONTENT));
	        		            
	        		            
	        		            
	        		         
	        		            if(flag==1)
	        		            {
	        		            	
	        		            	TextView b6=new TextView(DbselectActivity.this);
	        		            	 b6.setPadding(10, 5, 0, 0);
	        		        	     b6.setText("DevID");
	        		        	     b6.setTextColor(Color.BLACK);
	        		        	     b6.setTextSize(15);
	        		                 tr.addView(b6);
	        		                 
	        		               
	        		            
	        		            	
	        		                TextView b19=new TextView(DbselectActivity.this);
	        		                 b19.setPadding(10, 5, 0, 0);
	        		                 b19.setTextSize(15);
	        		        	     b19.setText("SensorPNo");
	        		        	     b19.setTextColor(Color.BLACK);
	        		        	     tr.addView(b19);
	         		                TextView b20=new TextView(DbselectActivity.this);
	        		                 b20.setPadding(10, 5, 0, 0);
	        		                 b20.setTextSize(15);
	        		        	     b20.setText("SensorType");
	        		        	     b20.setTextColor(Color.BLACK);
	        		        	     tr.addView(b20);
	        		                 
	        		               TextView b29=new TextView(DbselectActivity.this);
	        		             b29.setPadding(10, 5, 0, 0);
	        		        	     b29.setText("Reading");
	        		        	     b29.setTextColor(Color.BLACK);
	        		        	     b29.setTextSize(15);
	        		                 tr.addView(b29);
	        		         
	        		                 
	        		             tv.addView(tr);
	        		            
	        		        	     final View vline = new View(DbselectActivity.this);
	        			       		   vline.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, 2));
	        			       		   vline.setBackgroundColor(Color.BLACK);
	        			       		  
	        		            
	        		            
	        		            tv.addView(vline);
	        		            flag=0;
	        		            	
	        		            	
	        		            }
		            
	        		            else
	        		            {
	        		            	
	        		            
	        		            	
	        		            	JSONObject json_data = jArray.getJSONObject(i);
	        		        	    
	  	        	              Log.i("log_tag","Devid: "+json_data.getString("DevID")+
	  	        	            		    ", SensorPNo: "+json_data.getString("SensorPNo")+
	  	        	                        ", SensorType: "+json_data.getString("SensorType")+
	  	        	                        ", No: "+json_data.getString("ConvertedReading"));
	  	        	       
	        		            
	        		            
	        	            
	        	            TextView b=new TextView(DbselectActivity.this);
	       	        	     String stime=String.valueOf(json_data.getString("DevID"));
	       	        	 	  b.setText(stime);
	       	        	 	  b.setPadding(0, 18, 0, 0);
	       	        	     b.setTextColor(Color.DKGRAY);
	       	        	     b.setTextSize(15);
	       	                 tr.addView(b);
	       	                 
		        	            
	       	            
	       	            	
	       	                TextView b1=new TextView(DbselectActivity.this);
	       	                 b1.setPadding(10, 18, 0, 0);
	       	                 b1.setTextSize(15);
	       	                 String stime1=json_data.getString("SensorPNo");
	       	             	 b1.setText(stime1);
	       	        	     b1.setTextColor(Color.DKGRAY);
	       	        	     tr.addView(b1);
	       	                
	       	        	  TextView b11=new TextView(DbselectActivity.this);
	       	                 b11.setPadding(10, 18, 0, 0);
	       	                 b11.setTextSize(15);
	       	                 String stime13=json_data.getString("SensorType");
	       	             	 b11.setText(stime13);
	       	        	     b11.setTextColor(Color.DKGRAY);
	       	        	     tr.addView(b11);
	       	                 
	       	               TextView b21=new TextView(DbselectActivity.this);
	        	             b21.setPadding(10, 18, 0, 0);
	       	        	     String stime2=json_data.getString("ConvertedReading");
	       	        		 b21.setText(stime2);
	       	        	     b21.setTextColor(Color.DKGRAY);
	       	        	     b21.setTextSize(15);
	       	                 tr.addView(b21);
	       	         
	       	                   tv.addView(tr);
	        	            
	        	            
	       	         final View vline1 = new View(DbselectActivity.this);
	       		   vline1.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, 1));
	       		   vline1.setBackgroundColor(Color.DKGRAY);
	       		   tv.addView(vline1);		
	        	        
	        	       	
	        		            }
	        	               
                       }
	    
	
	        	
	        	}
	        	catch(JSONException e)
	        	{
	        	        Log.e("log_tag", "Error parsing data "+e.toString());
	        	        Toast.makeText(getApplicationContext(), "JsonArray fail", Toast.LENGTH_SHORT).show();
	        	}

	        	

	        	 
	       }
	       });
	        
	        


	 }
	

}
