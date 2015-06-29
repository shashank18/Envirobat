package com.example.androidhive;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class CopyWebViewDemoActivity extends Activity 
{
	private WebView visitmmWebView;
	 private static final String VISITMM_URL = "http://sindhu.ece.iisc.ernet.in/mainserver/android_showdevicedb.php";
	 @Override
	 protected void onCreate(Bundle savedInstanceState) {
	     super.onCreate(savedInstanceState);
	     IntializeWebView();
	 }

	 public void IntializeWebView(){
	     setContentView(R.layout.main9);
	     visitmmWebView = (WebView) findViewById(R.id.webview);
	     visitmmWebView.getSettings().setUseWideViewPort(true);
	     visitmmWebView.getSettings().setLoadWithOverviewMode(true);
	     visitmmWebView.setWebViewClient(new WebViewClient());
	     visitmmWebView.loadUrl(VISITMM_URL);
	    visitmmWebView.getSettings().setBuiltInZoomControls(true);
	     WebSettings webSettings = visitmmWebView.getSettings();
	     visitmmWebView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
	     visitmmWebView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
	     webSettings.setJavaScriptEnabled(true);
	     visitmmWebView.setVerticalScrollBarEnabled(true);
	     visitmmWebView.setHorizontalScrollBarEnabled(true);
	 }

	 @Override
	 public void onConfigurationChanged(Configuration newConfig) {
	     super.onConfigurationChanged(newConfig);    //To change body of overridden methods use File | Settings | File Templates.
	     IntializeWebView();
	 }

	 /**
	  * Make back works for browser history
	  */
	 @Override
	 public boolean onKeyDown(int keyCode, KeyEvent event) {

	     if ((keyCode == KeyEvent.KEYCODE_BACK) && visitmmWebView.canGoBack()) {
	         visitmmWebView.goBack();
	         return true;
	     }

	     return super.onKeyDown(keyCode, event);
	 }
}

