package com.example.androidhive;

//import com.triggerinnovations.physics.R;
//import com.triggerinnovations.startup.flash2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class flash1 extends Activity
{
	
	protected boolean _active = true;
	protected int _splashTime = 3000; 
	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.flash);
        Thread splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    while(_active && (waited < _splashTime)) {
                        sleep(100);
                        if(_active) {
                            waited += 100;
                        }
                    }
                } catch(InterruptedException e) {
                    // do nothing
                } finally {
                    finish();
                    Intent myintent1=new Intent();
    				myintent1.setClass(getApplicationContext(),flash2.class);
    				startActivity(myintent1);
    				
                   // stop();
                }
            }
        };
        splashTread.start();
	}
	
}
