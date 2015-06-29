package com.example.androidhive;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

//import com.triggerinnovations.physics.R;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class pdfloader1 extends explodr1 {
	public void onCreate(Bundle savedInstanceState) 
	{
        
		 super.onCreate( savedInstanceState);
		 setContentView(R.layout.pdfloader1);
		
		
       // requestWindowFeature(Window.FEATURE_NO_TITLE);
		 
        {
		//code to load respective pdfs	
        	try {
    			AssetManager am = this.getAssets();
    		
    			InputStream is = am.open(filname);
    			File dir = new File("data/data/com.example.androidhive/files/");
    			
    			dir.mkdir();
    			
    			File file = new File("data/data/com.example.androidhive/cache/file.pdf");
    			file.createNewFile();
    		
    			OutputStream out=new FileOutputStream(file);
    			byte buf[]=new byte[1024];
    			int len;
    			while((len=is.read(buf))>0)
    				out.write(buf,0,len);
    			out.close();
    			is.close();
    			Runtime.getRuntime().exec("chmod 777 data/data/com.example.androidhive/cache/file.pdf");
    			//parcel = ParcelFileDescriptor.open(file, ParcelFileDescriptor.MODE_READ_WRITE);
    		}
    		catch (Exception e) {
    			Log.e("Exception",e.toString());
    		}
       

File targetfile=new File("data/data/com.example.androidhive/cache/file.pdf");
Uri targeturi=Uri.fromFile(targetfile);

Intent intent=new Intent(Intent.ACTION_VIEW);
intent.setDataAndType(targeturi, "application/pdf");
intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
startActivity(intent);
finish();
		}
//        Button done=(Button)findViewById(R.id.a);
//        done.setOnClickListener(new OnClickListener() {
//			
//			public void onClick(View arg0) {
//				// TODO Auto-generated method stub
//				Intent back=new Intent();
//				back.setClass(getApplicationContext(), explodr1.class);
//				
//			}
//		});
     
	}
}
