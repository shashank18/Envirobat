package com.example.androidhive;

//import java.io.File;

//import com.triggerinnovations.physics.R;
//import com.triggerinnovations.physics.opticalfiber.Optical;
//import com.triggerinnovations.physics.startup.set1;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class explodr1 extends Activity1 {
	 static String filname;
	 Button b1;
	// Button b2;
	 //Button b3;
	//private OnClickListener myhandler1;
    public void onCreate(Bundle savedInstanceState) 
    {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main3);
    final int expts=0;
    Button b1=(Button)findViewById(R.id.first);
    //Button b2=(Button)findViewById(R.id.city);
    //Button b3=(Button)findViewById(R.id.recent);
    b1.setOnClickListener(new View.OnClickListener() {

      public void onClick(View arg0)
      {
	    final int expts;
			
		if(flag==1)
		{
			expts=1;
		filname="exp1.pdf";
		}
		else if(flag==2)
		{
			expts=2;
			filname="exp2.pdf";
		}
		else if(flag==3)
		{
			expts=3;
			
			filname="exp3.pdf";
		}
		else if(flag==4)
		{
			expts=4;
			filname="exp4.pdf";
		}
		else if(flag==5)
		{
			expts=5;
			filname="exp5.pdf";
		}
		else if(flag==6)
		{
			//filname="exp2.pdf";
		}
		
		Intent open=new Intent();
		open.setClass(getApplicationContext(), pdfloader1.class);
		startActivity(open);
	}
});
    /*b2.setOnClickListener(new View.OnClickListener() {

        public void onClick(View arg0)
        {
  	    final int expts;
  			
  		if(flag==1)
  		{
  			expts=1;
  		filname="exp1.pdf";
  		}
  		else if(flag==2)
  		{
  			expts=2;
  			filname="exp2.pdf";
  		}
  		else if(flag==3)
  		{
  			expts=3;
  			
  			filname="exp3.pdf";
  		}
  		else if(flag==4)
  		{
  			expts=4;
  			filname="exp4.pdf";
  		}
  		else if(flag==5)
  		{
  			expts=5;
  			filname="exp5.pdf";
  		}
  		else if(flag==6)
  		{
  			//filname="exp2.pdf";
  		}
  		
  		Intent open=new Intent();
  		open.setClass(getApplicationContext(), pdfloader1.class);
  		startActivity(open);
  	}
  });    
    b3.setOnClickListener(new View.OnClickListener() {

        public void onClick(View arg0)
        {
  	    final int expts;
  			
  		if(flag==1)
  		{
  			expts=1;
  		filname="exp1.pdf";
  		}
  		else if(flag==2)
  		{
  			expts=2;
  			filname="exp2.pdf";
  		}
  		else if(flag==3)
  		{
  			expts=3;
  			
  			filname="exp3.pdf";
  		}
  		else if(flag==4)
  		{
  			expts=4;
  			filname="exp4.pdf";
  		}
  		else if(flag==5)
  		{
  			expts=5;
  			filname="exp5.pdf";
  		}
  		else if(flag==6)
  		{
  			//filname="exp2.pdf";
  		}
  		
  		Intent open=new Intent();
  		open.setClass(getApplicationContext(), pdfloader1.class);
  		startActivity(open);
  	}
  });
/*Button theory=(Button)findViewById(R.id.lang);
       
theory.setOnClickListener(new OnClickListener() {
	
	public void onClick(View arg0) {
			final int expts;
		
		if(flag==1)
		{
			expts=1;
		filname="exp1.pdf";
		}
		else if(flag==2)
		{
			expts=2;
			filname="exp2.pdf";
		}
		else if(flag==3)
		{
			expts=3;
			
			filname="exp3.pdf";
		}
		else if(flag==4)
		{
			expts=4;
			filname="exp4.pdf";
		}
		else if(flag==5)
		{
			expts=5;
			filname="exp5.pdf";
		}
		else if(flag==6)
		{
			//filname="exp2.pdf";
		}
		
		Intent open=new Intent();
		open.setClass(getApplicationContext(), pdfloader1.class);
		startActivity(open);
	}
});
Button theory1=(Button)findViewById(R.id.city);

theory1.setOnClickListener(new OnClickListener() {
	
	public void onClick(View arg0) {
			final int expts;
		
		if(flag==1)
		{
			expts=1;
		filname="exp1.pdf";
		}
		else if(flag==2)
		{
			expts=2;
			filname="exp2.pdf";
		}
		else if(flag==3)
		{
			expts=3;
			
			filname="exp3.pdf";
		}
		else if(flag==4)
		{
			expts=4;
			filname="exp4.pdf";
		}
		else if(flag==5)
		{
			expts=5;
			filname="exp5.pdf";
		}
		else if(flag==6)
		{
			//filname="exp2.pdf";
		}
		
		Intent open=new Intent();
		open.setClass(getApplicationContext(), pdfloader1.class);
		startActivity(open);
	}
});
Button theory2=(Button)findViewById(R.id.city);

theory2.setOnClickListener(new OnClickListener() {
	
	public void onClick(View arg0) {
			final int expts;
		
		if(flag==1)
		{
			expts=1;
		filname="exp1.pdf";
		}
		else if(flag==2)
		{
			expts=2;
			filname="exp2.pdf";
		}
		else if(flag==3)
		{
			expts=3;
			
			filname="exp3.pdf";
		}
		else if(flag==4)
		{
			expts=4;
			filname="exp4.pdf";
		}
		else if(flag==5)
		{
			expts=5;
			filname="exp5.pdf";
		}
		else if(flag==6)
		{
			//filname="exp2.pdf";
		}
		
		Intent open=new Intent();
		open.setClass(getApplicationContext(), pdfloader1.class);
		startActivity(open);
	}
});*/
}}
