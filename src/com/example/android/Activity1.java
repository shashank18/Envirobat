package com.example.androidhive;

//import com.example.flash.explodr1;

//import a.b.c.Activity2;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Activity1 extends Activity {
    /** Called when the activity is first created. */
	static String filname;
	 public static int flag=1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main3);
        
        Button b1=(Button)findViewById(R.id.first);
        Button b2=(Button)findViewById(R.id.second);
        Button b3=(Button)findViewById(R.id.third);
        Button b4=(Button)findViewById(R.id.fourth);
        
        b1.setOnClickListener(new OnClickListener() {
			
 			public void onClick(View v) {
 				// TODO Auto-generated method stub
 				
 				
 		Intent i1=new Intent();
 		i1.setClass(getApplicationContext(), BluetoothChat.class);
 		startActivity(i1);
 				
 			}
 		});
        b4.setOnClickListener(new OnClickListener() {
			
     			public void onClick(View v) {
     				// TODO Auto-generated method stub
     				
     				
     		Intent i1=new Intent();
     		i1.setClass(getApplicationContext(), CopyWebViewDemoActivity.class);
     		startActivity(i1);
     				
     			}
     		});
        b3.setOnClickListener(new OnClickListener() {
			
 			public void onClick(View v) {
 				// TODO Auto-generated method stub
 				
 				
 		Intent i1=new Intent();
 		i1.setClass(getApplicationContext(), WebViewDemoActivity.class);
 		startActivity(i1);
 				
 			}
 		});
 b2.setOnClickListener(new OnClickListener() {
			
 			public void onClick(View v) {
 				// TODO Auto-generated method stub
 				
 				
 		Intent i2=new Intent();
 		i2.setClass(getApplicationContext(), deviceinfo.class);
 		startActivity(i2);
 				
 			}
 		});
    }
}