package com.example.androidhive;

//import com.triggerinnovations.physics.R;
//import com.triggerinnovations.startup.LoginActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

//import com.triggerinnovations.physics.R;
//import com.triggerinnovations.startup.LoginActivity;

public class flash2 extends Activity 
{
	

	protected boolean _active = true;
	protected int _splashTime = 5000; 
	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.flash2);
        Thread splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    while(_active && (waited < _splashTime)) {
                        sleep(200);
                        if(_active) {
                            waited += 250;
                        }
                    }
                } catch(InterruptedException e) {
                    // do nothing
                } finally {
                    finish();
                    Intent myintent1=new Intent();
    				myintent1.setClass(getApplicationContext(),Activity1.class);
    				startActivity(myintent1);
                   // stop();
                }
            }
        };
        splashTread.start();
	}
	
	

}
