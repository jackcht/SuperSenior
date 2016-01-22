package com.example.supersenior.reminder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import com.example.supersenior.R;
import com.example.supersenior.backend.Config;
import com.example.supersenior.backend.SuperSeniorNotification;

public class Reminder_menu_fragment extends Fragment {
	
	Button medicine, appointment, body_check, others;
	ListView listView ;
	
	public Reminder_menu_fragment(){
		//emtpy constructor
	}
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View v = inflater.inflate(R.layout.fragment_reminder_menu, container, false);
	
	
		
		medicine = (Button)v.findViewById(R.id.menu_btn_medicine);
		appointment = (Button)v.findViewById(R.id.menu_btn_appointment);
		body_check = (Button)v.findViewById(R.id.menu_btn_body_check);
		others = (Button)v.findViewById(R.id.menu_btn_others);
		listView = (ListView) v.findViewById(R.id.reminder_lists);
		

		
		 ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, Config.values);
		
		 listView.setAdapter(adapter); 
		
		medicine.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent i = new Intent(getActivity(), CreateMedicineReminder.class);
				startActivity(i);
				
			}
		});
		
		
		
		
		
		
		
		
		
		
		
		appointment.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent i = new Intent(getActivity(), CreateReminderAppointment.class);
				startActivity(i);
				
			}
		});
		
		
		body_check.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				//Intent i = new Intent(getActivity(), CreateReminder.class);
				//startActivity(i);
				
			}
		});	

		others.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				
				String msgString = "Medicine: Sore throat pill \nQuantity: 2 Capsules.\n";
				String titleString = "Sore Throat Medicine3";
				
				SuperSeniorNotification ntf = new SuperSeniorNotification();
				ntf.sendNotification(getActivity(), 001, titleString, msgString);
							
			}
		});
		
		
		
		
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				// TODO Auto-generated method stub
				//Toast.makeText(getActivity(), position+"_"+id, Toast.LENGTH_SHORT).show();
				
				switch(position){
				case 0:
					Intent editeReminder = new Intent(getActivity(), EditReminder.class);
					startActivity(editeReminder);
					break;
				case 1:
					Intent i = new Intent(getActivity(), EditReminder.class);
					startActivity(i);
					break;
				case 2:
					//not doing
					
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				}
				
			}
			
		} 
		);
		
		
		
		
		return v;
		
	}
	
	
	
	
}
