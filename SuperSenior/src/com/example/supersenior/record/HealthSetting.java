package com.example.supersenior.record;


import com.example.supersenior.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class HealthSetting extends Activity{
	
	Button cancel, ok, selectAll;
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_measure_setting);
		
		cancel = (Button) findViewById(R.id.measure_setting_cancel);
		ok = (Button) findViewById(R.id.measure_setting_ok);
		selectAll = (Button) findViewById(R.id.measure_setting_selectall);
		
		cancel.setOnClickListener(cancelListener);
		ok.setOnClickListener(okListener);
		selectAll.setOnClickListener(selectAllListener);
		
		
	}
	
	private OnClickListener selectAllListener = new OnClickListener()
	{
		 public void onClick(View v) {
			 //TODO: SELECT ALL
		 }
	};
	
	private OnClickListener cancelListener = new OnClickListener()
	{
		 public void onClick(View v) {
			 Toast.makeText(HealthSetting.this, "Selection cancelled", Toast.LENGTH_SHORT).show();	
			 HealthSetting.this.finish();
		 }
	};
	
	private OnClickListener okListener = new OnClickListener()
	{
		 public void onClick(View v) {
			 Toast.makeText(HealthSetting.this, "Selection saved", Toast.LENGTH_SHORT).show();	
			 HealthSetting.this.finish();
		 }
	};
	
	

}
