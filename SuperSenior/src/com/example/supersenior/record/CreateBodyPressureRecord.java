package com.example.supersenior.record;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.supersenior.R;
import com.example.supersenior.backend.BodyPressureRecordConfig;
import com.example.supersenior.backend.Send_Email;

public class CreateBodyPressureRecord extends Activity{
	
	private Button btn_save, btn_delete, btn_setdate, btn_settime;
    private List<String> locationList = new ArrayList<String>(); 
    private List<String> postureList = new ArrayList<String>();
    private Spinner locationSelect, postureSelect;     
    private ArrayAdapter<String> adapter; 
    private EditText et_systolic_value;
    private EditText et_diastolic_value;
    
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    private String pressureVal;
    
    private String printYear = String.valueOf(year);
    private String printMonth = "0" + String.valueOf(month);
    private String printDay = "0" + String.valueOf(day);
    
    private String printHour = String.valueOf(hour);
    private String printMinute = String.valueOf(minute);
    private String printDate;
    private String printTime;

   
	private static final int CASE_DATE = 1;
	private static final int CASE_TIME = 2;
    
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_pressure_record);
		
		et_systolic_value = (EditText) findViewById(R.id.et_systolic_value);
		et_diastolic_value = (EditText) findViewById(R.id.et_diastolic_value);
		
		
		Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);
        hour = c.get(Calendar.HOUR_OF_DAY);
        minute = c.get(Calendar.MINUTE);
		
		btn_save = (Button) findViewById(R.id.pressure_save);
		btn_delete = (Button) findViewById(R.id.pressure_delete); 
		btn_setdate = (Button) findViewById(R.id.pressure_date_button);
		btn_settime = (Button) findViewById(R.id.pressure_time_button);
		
		btn_save.setOnClickListener(recordSaveListener);
		btn_delete.setOnClickListener(recordDeleteListener);
		btn_setdate.setOnClickListener(setDateListener);
		btn_settime.setOnClickListener(setTimeListener);
		
		setLocationSpinner();
		setPostureSpinner();
		
	}
	
	private OnClickListener setDateListener = new OnClickListener() {

		@SuppressWarnings("deprecation")
		@Override
		public void onClick(View v) {
			showDialog(CASE_DATE);
		}
    	
    };
    
	private OnClickListener setTimeListener  = new OnClickListener() {

		@SuppressWarnings("deprecation")
		@Override
		public void onClick(View v) {
			showDialog(CASE_TIME);
		}
    	
    };
    
    private void setLocationSpinner() {
    	locationList.add("Right Arm");
    	locationList.add("Left Arm");     
    	locationList.add("Right Wrist");
    	locationList.add("Left Wrist");
	    locationSelect = (Spinner) findViewById(R.id.spinner_location);
        
        adapter = new ArrayAdapter<String>(CreateBodyPressureRecord.this,android.R.layout.simple_spinner_item, locationList);  
        
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);   
        
        locationSelect.setAdapter(adapter);
         
        locationSelect.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){     
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {       
                arg0.setVisibility(View.VISIBLE);     
            }     
            public void onNothingSelected(AdapterView<?> arg0) {          
                arg0.setVisibility(View.VISIBLE);     
            }     
        });
	}
    
    private void setPostureSpinner() {
    	postureList.add("Seated");
    	postureList.add("Upright");     
    	postureList.add("Horizontal");
    	postureList.add("Reclined");
	    postureSelect = (Spinner) findViewById(R.id.spinner_posture);
        
        adapter = new ArrayAdapter<String>(CreateBodyPressureRecord.this,android.R.layout.simple_spinner_item, postureList);  
        
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);   
        
        postureSelect.setAdapter(adapter);
         
        postureSelect.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){     
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {       
                arg0.setVisibility(View.VISIBLE);     
            }     
            public void onNothingSelected(AdapterView<?> arg0) {          
                arg0.setVisibility(View.VISIBLE);     
            }     
        });
	}
    
    private OnClickListener recordSaveListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			int pressure = Integer.parseInt(et_systolic_value.getText().toString());
			if(pressure >130){
				Toast.makeText(CreateBodyPressureRecord.this, "Threshold Reached. Email Sent", Toast.LENGTH_SHORT).show();
				Send_Email email = new Send_Email();			
				email.send(Send_Email.Recipient, "superSeniorAlert@superSenior.com", "High Pressure Alert", "Alex Lam has Blood Pressure of "+pressure);
				
			}
			else{
			
				Toast.makeText(CreateBodyPressureRecord.this, "Record Saved", Toast.LENGTH_SHORT).show();
			}
			
			pressureVal = et_systolic_value.getText().toString() +"/"+ et_diastolic_value.getText().toString()+" mmHg";
			String newValue = "Blood Pressure  :        "+pressureVal
					+"\n                                        "
					+printTime+ " , " +printDate;
			BodyPressureRecordConfig.values.add(newValue);
			
			CreateBodyPressureRecord.this.finish();
		}
    	
    };
	private OnClickListener recordDeleteListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			Toast.makeText(CreateBodyPressureRecord.this, "Record didn't save", Toast.LENGTH_SHORT).show();	
			CreateBodyPressureRecord.this.finish();
		}
    	
    };
    
    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
	        case CASE_DATE:
	           return new DatePickerDialog(this, datePickerListener, year, month,day);
	        case CASE_TIME:
	        	return new TimePickerDialog(this, timePickerListener, hour, minute, true);
        }
        return null;
    }
 
    private DatePickerDialog.OnDateSetListener datePickerListener 
                = new DatePickerDialog.OnDateSetListener() {
 
    	public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {
        	printYear = String.valueOf(selectedYear); 
        	printMonth = String.valueOf(selectedMonth+1);
        	printDay = String.valueOf(selectedDay);
        	
        	if (printMonth.length() == 1)
        		printMonth = "0" + printMonth;
			if (printDay.length() == 1)
				printDay = "0" + printDay;
			
            printDate = printDay+"-"+printMonth+"-"+printYear;
            Toast.makeText(getApplicationContext(), "Date Set", Toast.LENGTH_SHORT).show();
            
            btn_setdate.setText(printDate);
        }
    };
    
    private OnTimeSetListener timePickerListener = new OnTimeSetListener() {

		@Override
		public void onTimeSet(TimePicker view, int selectedHourOfDay, int selectedMinute) {
			printHour = String.valueOf(selectedHourOfDay);
			printMinute = String.valueOf(selectedMinute); 
			
			if (printHour.length() == 1)
				printHour = "0" + printHour;
			if (printMinute.length() == 1)
				printMinute = "0" + printMinute;
				
			printTime = printHour+":"+printMinute;
			Toast.makeText(getApplicationContext(), "Time Set", Toast.LENGTH_SHORT).show();
			
			btn_settime.setText(printTime);
		}
    };
}
