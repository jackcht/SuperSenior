package com.example.supersenior.backend;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.os.AsyncTask;
import android.util.Log;

public class Send_Email {
	
	private static final String TAG = "MyActivity";
	public static final String Recipient = "chen0783@e.ntu.edu.sg";
	
	public boolean send(String recipient, String sender, String title, String message){
		
		String t_data[] =  {recipient, sender, title, message};
		Log.v(TAG, "Now="+recipient);
		Sender email = new Sender();
		email.execute(t_data);
	
		return false;
	}
	
	
	
	public class Sender extends AsyncTask<String, String, String>{

		@Override
		protected String doInBackground(String... data) {
			// TODO Auto-generated method stub
			
			String url = "http://54.187.27.113/pricebankapi/email.php";
	      	
	      	HttpClient httpclient = new DefaultHttpClient();
	        HttpPost httppost = new HttpPost(url);
	        @SuppressWarnings("unused")
			HttpResponse resp = null;
	        
	        try {
	            // Add your data
	            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
	            Log.v(TAG, "recipient ="+data[0]);
	            nameValuePairs.add(new BasicNameValuePair("recipient", data[0]));
	            nameValuePairs.add(new BasicNameValuePair("sender", data[1]));
	            nameValuePairs.add(new BasicNameValuePair("title", data[2]));
	            nameValuePairs.add(new BasicNameValuePair("message", data[3]));
	            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

	            // Execute HTTP Post Request
	            resp = httpclient.execute(httppost);
	            
	        } catch (ClientProtocolException e) {
	            // TODO Auto-generated catch block
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	        }
			
			
			
			
			return null;
		}
		
		@Override
		protected void onPostExecute(String result) {
			
		      
		}		
		
	}
	
	
	
}
