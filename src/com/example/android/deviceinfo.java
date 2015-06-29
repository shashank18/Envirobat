package com.example.androidhive;

//import com.example.flash.explodr1;

//import a.b.c.Activity2;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class deviceinfo extends Activity {
    /** Called when the activity is first created. */
	//static String filname;
	// public static int flag=1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main5);
        
        Button b2=(Button)findViewById(R.id.b1);
 b2.setOnClickListener(new OnClickListener() {
			
 			public void onClick(View v) {
 				// TODO Auto-generated method stub
 				
 				
 		Intent i2=new Intent();
 		i2.setClass(getApplicationContext(), Activity1.class);
 		startActivity(i2);
 				
 			}
 		});
       
    }
}