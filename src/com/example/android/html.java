package com.example.androidhive;

//import com.example.flash.explodr1;

//import a.b.c.Activity2;
import java.io.IOException;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;

public class html extends Activity {
    /** Called when the activity is first created. */
	static String filname;
	 public static int flag=1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main4);
        //WebView mWebView = null;
        //mWebView = (WebView) findViewById(R.id.webView1);
        //mWebView.getSettings().setJavaScriptEnabled(true);
        //mWebView.loadUrl("http://sindhu.ece.iisc.ernet.in/shashank/graph1.php"); //new.html is html file name.
        WebView browser = (WebView) findViewById(R.id.webView1);
        browser.getSettings().setLoadWithOverviewMode(true);
        browser.getSettings().setUseWideViewPort(true);
        browser.loadUrl("http://sindhu.ece.iisc.ernet.in/envirobat/3/mapview.php");
        //String url = "http://shashankmirji.comuf.com/pie.php";
        //HttpClient client = new DefaultHttpClient();

        //try {
         // client.execute(new HttpGet(url));
        //} catch(IOException e) {
          //do something here
        }
    }
