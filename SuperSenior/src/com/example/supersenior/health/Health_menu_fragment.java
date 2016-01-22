package com.example.supersenior.health;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.supersenior.R;
import com.example.supersenior.backend.BodyPressureRecordConfig;
import com.example.supersenior.backend.BodyTempRecordConfig;
import com.example.supersenior.backend.PulseRecordConfig;
import com.example.supersenior.backend.Send_Email;
import com.example.supersenior.record.CreateNewRecord;
import com.example.supersenior.record.EditPulseRecord;
import com.example.supersenior.record.HealthSetting;
import com.example.supersenior.record.ViewHealthRecord;
//import com.example.supersenior.backend.Config;


public class Health_menu_fragment extends Fragment{
	
	Button btn_new, btn_view, btn_upload, btn_setting;
	ListView listView ;
	
	public static int pulseRecordLength = PulseRecordConfig.values.size();

	public Health_menu_fragment(){
		//empty constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v = inflater.inflate(R.layout.fragment_health_menu, container, false);
		btn_new = (Button)v.findViewById(R.id.menu_btn_new);
		btn_view = (Button)v.findViewById(R.id.menu_btn_view);
		btn_upload = (Button)v.findViewById(R.id.menu_btn_upload);
		btn_setting = (Button)v.findViewById(R.id.menu_btn_setting);
		listView = (ListView) v.findViewById(R.id.healthrecord_list);
		

		ArrayList<String> list = new ArrayList<String>();
		list.add(PulseRecordConfig.values.get(0));
		list.add(PulseRecordConfig.values.get(1));
		list.add(BodyPressureRecordConfig.values.get(0));
		list.add(BodyTempRecordConfig.values.get(0));
		list.addAll(PulseRecordConfig.values.subList(2, PulseRecordConfig.values.size()));
		list.addAll(BodyPressureRecordConfig.values.subList(1, BodyPressureRecordConfig.values.size()));
		list.addAll(BodyTempRecordConfig.values.subList(1, BodyTempRecordConfig.values.size()));
		
		
		 ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, list);
		
		 listView.setAdapter(adapter); 
		
		 btn_new.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getActivity(), CreateNewRecord.class);
				startActivity(i);
				
			}
		});
		
		btn_view.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent i = new Intent(getActivity(), ViewHealthRecord.class);
				startActivity(i);
			
			}
		});
		
		
		btn_upload.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				/*
				Intent i = new Intent(getActivity(), UploadHealthRecord.class);
				startActivity(i);
				*/
				
				Send_Email email = new Send_Email();
				email.send(Send_Email.Recipient, "SuperSenior@superSenior.com", "Health Record - 07-07-2014", "Below is the heath record for Alex Lam:\n\nPulse: 70/min \n Blood Pressure: 100/70mmHg\n Temperature: 36.8 C");
				Toast.makeText(getActivity(), "Record for 07-07-2014 was Emailed", Toast.LENGTH_LONG).show();
			}
		});	

		btn_setting.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Log.i("TAG", "inside setting's listener");
				Intent i = new Intent(getActivity(), HealthSetting.class);
				startActivity(i);
			}
		});
		
		
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,long id) 
			{			
				switch(position){
				case 0:
					Intent a = new Intent(getActivity(), EditPulseRecord.class);
					startActivity(a);
					break;
				default:
					break;
				}	
			}	
		} 
		);
		
		
		
		
		return v;
	}
	
	public void onResume(){
		super.onResume();
		
		ArrayList<String> list = new ArrayList<String>();
		if (PulseRecordConfig.values.size() == pulseRecordLength - 1 )
		{
			list.add(PulseRecordConfig.values.get(0));
		}
		else 
		{
			list.add(PulseRecordConfig.values.get(0));
			list.add(PulseRecordConfig.values.get(1));
		}
		list.add(BodyPressureRecordConfig.values.get(0));
		list.add(BodyTempRecordConfig.values.get(0));
		
		list.addAll(PulseRecordConfig.values.subList(2, PulseRecordConfig.values.size()-1));
		list.addAll(BodyPressureRecordConfig.values.subList(1, BodyPressureRecordConfig.values.size()-1));
		list.addAll(BodyTempRecordConfig.values.subList(1, BodyTempRecordConfig.values.size()));
		list.add(PulseRecordConfig.values.get(PulseRecordConfig.values.size()-1));
		list.add(BodyPressureRecordConfig.values.get(BodyPressureRecordConfig.values.size()-1));
			
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, list);
		
		listView.setAdapter(adapter); 
		
	}
	
	
}
