package com.example.supersenior.record;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import android.widget.Button;

import com.example.supersenior.R;

public class ViewHealthRecord extends Activity{
	
	
	Button walkingstepsimg;
	
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_health_status);
		
		walkingstepsimg = (Button) findViewById(R.id.walkingsteps_image);
		
		walkingstepsimg.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				Intent i = new Intent(ViewHealthRecord.this, ViewWalkingstepStatus.class);
				startActivity(i);
			}
		});
		
	}

}
