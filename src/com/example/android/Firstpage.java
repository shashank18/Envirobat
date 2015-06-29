package com.example.androidhive;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

//import triggerinnovations.hellobelgaum.R;
import android.net.NetworkInfo;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class Firstpage extends Activity implements Runnable {
	String[] domain = { "cense-20130100001", "cense-20130100002",
			"cense-20130100003", "cense-20130100004", "cense-20130100005",
			"CiSTUP-20130100006" };
	String[] domain1 = { "TGS4161-CO2", "MiCS-5521-CO", "MiCS-2710-NO2",
			"TMP36-TEM", "HIH-4031-HUM", "EC4-20-502-S02", "MiCS-2610-03" };
	String[] domain2 = { "live", "zoom" };
	String sdomain;
	String sdomain1;
	String sdomain2;
	HttpPost httppost;
	HttpResponse response;
	HttpClient httpclient;
	InputStream inputStream;
	byte[] data;
	StringBuffer buffer;
	List<NameValuePair> nameValuePairs;
	Dialog dialog;

	/** Called when the activity is first created. */
	int flag = 0, flag_internet = 0; //

	EditText txtName;
	String t;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main6);
		//Button submit = (Button) findViewById(R.id.b1);
		// TextView registerScreen = (TextView)
		// findViewById(R.id.link_to_register);

		Button b1 = (Button) findViewById(R.id.b1);
		Button b2 = (Button)findViewById(R.id.b2);
		// txtName=(EditText)findViewById(R.id.ser1);

		final Spinner spinstate = (Spinner) findViewById(R.id.spinner);
		final Spinner spinstate1 = (Spinner) findViewById(R.id.spinner3);
		final Spinner spinstate2 = (Spinner) findViewById(R.id.spinner4);
		// spinstate.setOnItemSelectedListener((OnItemSelectedListener) this);

		ArrayAdapter state = new ArrayAdapter(this,
				android.R.layout.simple_spinner_item, domain);
		state.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinstate.setAdapter(state);

		spinstate.setOnItemSelectedListener(new OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				sdomain = spinstate.getSelectedItem().toString();
				// ((TextView)
				// spincount.getSelectedItem()).setTextColor(Color.WHITE);
				// ((TextView) spincount.getSelectedItem()).setTextSize(18);
				// ((TextView)arg0.getChildAt(0)).setTextColor(Color.WHITE);
				((TextView) arg0.getChildAt(0)).setTextSize(18);
				Toast.makeText(getBaseContext(), sdomain, Toast.LENGTH_LONG)
						.show();
			}

			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
			}
		});

		// Listening to login button
		/*
		 * login.setOnClickListener(new View.OnClickListener() { //@Override
		 * public void onClick(View v) { //Goto dash board Intent i = new
		 * Intent(getApplicationContext(), DashBoard.class); startActivity(i); }
		 * });
		 */
		// Listening to register new account link
		/*
		 * registerScreen.setOnClickListener(new View.OnClickListener() {
		 * 
		 * public void onClick(View v) { // Switching to Register screen Intent
		 * i = new Intent(getApplicationContext(), Contactus.class);
		 * startActivity(i); } });
		 */
		// /Onclick on second spinner
		// spinstate1.setOnItemSelectedListener((OnItemSelectedListener) this);
		// spinstate2.setOnItemSelectedListener((OnItemSelectedListener) this);
		ArrayAdapter state1 = new ArrayAdapter(this,
				android.R.layout.simple_spinner_item, domain1);
		state1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinstate1.setAdapter(state1);

		spinstate1.setOnItemSelectedListener(new OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				sdomain1 = spinstate1.getSelectedItem().toString();
				// ((TextView)
				// spincount.getSelectedItem()).setTextColor(Color.WHITE);
				// ((TextView) spincount.getSelectedItem()).setTextSize(18);
				// ((TextView)arg0.getChildAt(0)).setTextColor(Color.WHITE);
				((TextView) arg0.getChildAt(0)).setTextSize(18);
				Toast.makeText(getBaseContext(), sdomain1, Toast.LENGTH_LONG)
						.show();
			}

			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
			}
		});

		// /Onclick on third spinner
		// spinstate1.setOnItemSelectedListener((OnItemSelectedListener) this);
		// spinstate2.setOnItemSelectedListener((OnItemSelectedListener) this);
		ArrayAdapter state2 = new ArrayAdapter(this,
				android.R.layout.simple_spinner_item, domain2);
		state2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinstate2.setAdapter(state2);

		spinstate2.setOnItemSelectedListener(new OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				sdomain2 = spinstate2.getSelectedItem().toString();
				// ((TextView)
				// spincount.getSelectedItem()).setTextColor(Color.WHITE);
				// ((TextView) spincount.getSelectedItem()).setTextSize(18);
				// ((TextView)arg0.getChildAt(0)).setTextColor(Color.WHITE);
				((TextView) arg0.getChildAt(0)).setTextSize(18);
				Toast.makeText(getBaseContext(), sdomain2, Toast.LENGTH_LONG)
						.show();
			}

			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
			}
		});
		b1.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {

				// ///////////////////////////////////////////////////////

				try {

					httpclient = new DefaultHttpClient();
					httppost = new HttpPost(
							"http://sindhu.ece.iisc.ernet.in/envirobat/2/android_graphdisplay1.php");

					nameValuePairs = new ArrayList<NameValuePair>(3);
					// nameValuePairs.add(new
					// BasicNameValuePair("num1",t.trim()));
					nameValuePairs.add(new BasicNameValuePair("deviceid",
							sdomain.trim()));
					nameValuePairs.add(new BasicNameValuePair("sensorid",
							sdomain1.trim()));
					nameValuePairs.add(new BasicNameValuePair("type", sdomain2
							.trim()));
					httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
					// Toast.makeText(getApplicationContext(),sdomain.toString(),
					// Toast.LENGTH_LONG).show();

					response = httpclient.execute(httppost);
					inputStream = response.getEntity().getContent();

					data = new byte[256];

					buffer = new StringBuffer();
					int len = 0;
					while (-1 != (len = inputStream.read(data))) {
						buffer.append(new String(data, 0, len));
					}

					inputStream.close();
				}

				catch (Exception e) {
					Toast.makeText(Firstpage.this,
							"shashank error pa" + e.toString(),
							Toast.LENGTH_LONG).show();
				}

				// /////////////////////////////////////////////////////////////////////
				Toast.makeText(
						Firstpage.this,
						"Device id= " + sdomain.toString() + " Sensorid:"
								+ sdomain1.toString() + "type:"
								+ sdomain2.toString(), Toast.LENGTH_LONG)
						.show();

			}
		});
		  b2.setOnClickListener(new OnClickListener() {
				
	 			public void onClick(View v) {
	 				// TODO Auto-generated method stub
	 				
	 				
	 		Intent i1=new Intent();
	 		i1.setClass(getApplicationContext(), WebViewDemoActivity.class);
	 		startActivity(i1);
	 				
	 			}
	 		});

	}

	public void run() {
		// TODO Auto-generated method stub
		// process();
		handler.sendEmptyMessage(0);

		// Bundle b=new Bundle();

		// b.putString("ser", buffer.toString());
		// b.putString("src", txtName.getText().toString());
		// Log.d("buff",buffer.toString());
		// Toast.makeText(getApplicationContext(),buffer.toString(),
		// Toast.LENGTH_LONG).show();
		// Intent myintent=new Intent();
		// myintent.setClass(getApplicationContext(),HelloBelgaumActivity.class);
		// myintent.putExtras(b);
		// startActivity(myintent);
		// finish();
	}

	private Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			dialog.dismiss();
			// tv.setText(pi_string);

		}
	};

	boolean check_internet() {
		if (isInternetOn()) {
			// INTERNET IS AVAILABLE, DO STUFF..
			// Toast.makeText(getBaseContext(),
			// "Internet is Enabled",Toast.LENGTH_LONG).show();
			return true;
			// enable_internet();
		} else {
			// flag_internet=0;
			// Toast.makeText(getBaseContext(),
			// "Internet is DISABLED",Toast.LENGTH_LONG).show();
			enable_internet();

			if (flag_internet == 1)
				return true;
			else
				return false;

		}

	}

	public boolean isInternetOn() {
		ConnectivityManager connec = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		// ARE WE CONNECTED TO THE NET
		if (connec.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTED
				|| connec.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTING
				|| connec.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTING
				|| connec.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTED) {
			// MESSAGE TO SCREEN FOR TESTING (IF REQ)
			// Toast.makeText(this, connec + " connected",
			// Toast.LENGTH_SHORT).show();
			return true;
		} else if (connec.getNetworkInfo(0).getState() == NetworkInfo.State.DISCONNECTED
				|| connec.getNetworkInfo(1).getState() == NetworkInfo.State.DISCONNECTED) {
			// System.out.println(“Not Connected”);
			// Toast.makeText(this, connec + " DISconnected",
			// Toast.LENGTH_SHORT).show();
			return false;
		}
		return false;
	}

	void enable_internet() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		flag_internet = 0;
		builder.setMessage(
				" Internet(Data) is currently disabled! Would you like to enable it?")
				.setCancelable(false)
				.setPositiveButton("Enable Internet",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								showInternetOptions();
								flag_internet = 1;
							}
						});
		builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				flag_internet = 2;
				Toast.makeText(
						getBaseContext(),
						"This application requires Internet Connection.Please Enable it.",
						Toast.LENGTH_SHORT).show();

				dialog.cancel();
			}
		});
		AlertDialog alert = builder.create();
		alert.show();
	}

	void showInternetOptions() {
		try {
			Intent intent = new Intent(Settings.ACTION_DATA_ROAMING_SETTINGS);
			ComponentName cName = new ComponentName("com.android.phone",
					"com.android.phone.Settings");
			intent.setComponent(cName);
			startActivity(intent);
			// Toast.makeText(getBaseContext(),"Internet is now Enabled",Toast.LENGTH_SHORT).show();

		} catch (Exception e) {
			Toast.makeText(getBaseContext(),
					"Error in opening settings for data traffic ",
					Toast.LENGTH_SHORT).show();
			Toast.makeText(getBaseContext(), "Please Enable Data Traffic ",
					Toast.LENGTH_SHORT).show();

		}

	}

}
