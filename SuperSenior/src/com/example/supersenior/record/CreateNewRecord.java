package com.example.supersenior.record;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.supersenior.R;
import com.example.supersenior.backend.AutoMeasureConfig;

public class CreateNewRecord extends Activity{
	
	Button btn_pulse, btn_pressure, btn_temp, btn_auto, btn_ok;
	
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_new_record);
		
		btn_pulse = (Button)findViewById(R.id.record_new_pulse);
		btn_pressure = (Button)findViewById(R.id.record_new_pressure);
		btn_temp = (Button)findViewById(R.id.record_new_temp);
		btn_auto = (Button)findViewById(R.id.menu_new_auto);
		btn_ok = (Button)findViewById(R.id.newrecord_ok);
		
		btn_pulse.setOnClickListener( new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent i = new Intent(CreateNewRecord.this, CreatePulseRecord.class);
				startActivity(i);
				
			}
		});
		
		btn_pressure.setOnClickListener( new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent i = new Intent(CreateNewRecord.this, CreateBodyPressureRecord.class);
				startActivity(i);
				
			}
		});
		
		btn_temp.setOnClickListener( new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent i = new Intent(CreateNewRecord.this, CreateBodyTempRecord.class);
				startActivity(i);
				
			}
		});
		
		btn_auto.setOnClickListener( new OnClickListener() {

			@Override
			public void onClick(View v) {
				if(AutoMeasureConfig.CONNECTED){
					openMeasureResultDialog();
				}
				else{
					Intent i = new Intent(CreateNewRecord.this, ConnectDevices.class);
					AutoMeasureConfig.CONNECTED = true;
					startActivity(i);
				}
				
			}
		});
		
		btn_ok.setOnClickListener( new OnClickListener() {

			@Override
			public void onClick(View v) {
				CreateNewRecord.this.finish();
				
			}
		});
	}
	
	private void openMeasureResultDialog() {
		// TODO Auto-generated method stub
		new AlertDialog.Builder(CreateNewRecord.this)
		.setTitle(R.string.auto_measure)
		.setMessage(R.string.measure_results)
		.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener(){
					public void onClick(DialogInterface dialoginterface, int i){
						Intent intent = new Intent(CreateNewRecord.this, AutoMeasureRecord.class);
						startActivity(intent);
					}
				})
		.show();
	}

}
