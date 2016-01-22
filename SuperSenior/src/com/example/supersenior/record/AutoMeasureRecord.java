package com.example.supersenior.record;

import com.example.supersenior.R;
import com.example.supersenior.backend.AutoMeasureConfig;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class AutoMeasureRecord extends Activity{
	
	ListView ls;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_auto_measure_record);
		
		ls = (ListView) findViewById(R.id.list_sync_record);
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, AutoMeasureConfig.RECORDS);
		ls.setAdapter(adapter); 
		
	}
	
	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
		if (keyCode == KeyEvent.KEYCODE_BACK)
		{
			finish();
		}
		return true;
	}

	
}
