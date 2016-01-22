package com.example.supersenior.record;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.supersenior.R;
import com.example.supersenior.backend.AutoMeasureConfig;
import com.example.supersenior.reminder.EditReminder;

public class ConnectDevices extends Activity{
	
	ListView ls;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_connect_android_wear);
		
		ls = (ListView) findViewById(R.id.list_wear_list);
		
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, AutoMeasureConfig.values);
		ls.setAdapter(adapter); 
		
		ls.setOnItemClickListener(new AdapterView.OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				// TODO Auto-generated method stub
				//Toast.makeText(getActivity(), position+"_"+id, Toast.LENGTH_SHORT).show();
				
				switch(position){
					case 0:
						Toast.makeText(getApplicationContext(), "Connected to Xiaomi WristBand", Toast.LENGTH_SHORT).show();
						Intent editeReminder = new Intent(getApplicationContext(), CreateNewRecord.class);
						startActivity(editeReminder);
						break;
					case 1:
						Toast.makeText(getApplicationContext(), "Connected to Android Watch", Toast.LENGTH_SHORT).show();
						Intent i = new Intent(getApplicationContext(), CreateNewRecord.class);
						startActivity(i);
						break;
					case 2:
						//not doing
						break;
				}
				ConnectDevices.this.finish();
			}
		} 
		);
	}
	
	

}
