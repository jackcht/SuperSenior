package com.example.supersenior.me;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.supersenior.R;
import com.example.supersenior.reminder.CreateMedicineReminder;

public class Menu extends Activity{
	
	
	Button medicine, appointment, body_check, others;

	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_menu);
		
		//Send_Email email = new Send_Email();
		//email.send("receiver@gmail.com", "testing@testing.com", "My Title", "Testing this Email");
		
		medicine = (Button)findViewById(R.id.menu_btn_medicine);
		appointment = (Button)findViewById(R.id.menu_btn_appointment);
		body_check = (Button)findViewById(R.id.menu_btn_body_check);
		others = (Button)findViewById(R.id.menu_btn_others);
			
		
		medicine.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent i = new Intent(Menu.this, CreateMedicineReminder.class);
				startActivity(i);
				
			}
		});
		
		
		appointment.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent i = new Intent(Menu.this, CreateMedicineReminder.class);
				startActivity(i);
				
			}
		});
		
		
		body_check.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent i = new Intent(Menu.this, CreateMedicineReminder.class);
				startActivity(i);
				
			}
		});	

		others.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent i = new Intent(Menu.this, CreateMedicineReminder.class);
				startActivity(i);
				Toast.makeText(getApplicationContext(), "hello", Toast.LENGTH_SHORT).show();
				
			}
		});
		
		
		
	}
	
	
}
