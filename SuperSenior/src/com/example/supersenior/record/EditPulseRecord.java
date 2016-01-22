package com.example.supersenior.record;

import java.util.Calendar;

import com.example.supersenior.R;
import com.example.supersenior.backend.PulseRecordConfig;
import com.example.supersenior.health.Health_menu_fragment;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

public class EditPulseRecord extends Activity{

	private Button btn_save, btn_delete, btn_setdate, btn_back, btn_settime;
	private EditText pulseText;
	
	//Pulse :         70 /min    14.30 ,  07-07-2014
	private int year = 2014;
    private int month = 7;
    private int day = 7;
    private int hour = 14;
    private int minute = 30;
    private String pulseVal = "70";
    
    private String printYear = String.valueOf(year);
    private String printMonth = "0" + String.valueOf(month);
    private String printDay = "0" + String.valueOf(day);
    
    private String printHour = String.valueOf(hour);
    private String printMinute = String.valueOf(minute);
    private String printDate = printDay + "-" + printMonth + "-" + printYear;
    private String printTime = printHour + ":" + printMinute;
	
	private static final int CASE_DATE = 1;
	private static final int CASE_TIME = 2;
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_pulse_record);

		Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);
        hour = c.get(Calendar.HOUR_OF_DAY);
        minute = c.get(Calendar.MINUTE);
        
		btn_save = (Button) findViewById(R.id.pulse_edit_save);
		btn_back = (Button) findViewById(R.id.pulse_edit_back);
		btn_delete = (Button) findViewById(R.id.pulse_edit_delete); 
		btn_setdate = (Button) findViewById(R.id.edit_pulse_date_button);
		btn_settime = (Button) findViewById(R.id.edit_pulse_time_button);
		
		pulseText = (EditText)findViewById(R.id.et_edit_pulse_value);
		
		btn_save.setOnClickListener(recordSaveListener);
		btn_back.setOnClickListener(recordBackListener);
		btn_delete.setOnClickListener(recordDeleteListener);
		btn_setdate.setOnClickListener(setDateListener);
		btn_settime.setOnClickListener(setTimeListener);
		
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
	
    
    private OnClickListener recordSaveListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			Toast.makeText(EditPulseRecord.this, "Record Saved", Toast.LENGTH_SHORT).show();
			//Pulse :         70 /min    14.30 ,  07-07-2014
			pulseVal = pulseText.getText().toString();
			String newValue = "Pulse :         "+pulseVal+" /min    "+printTime+ " ,  " +printDate;
			PulseRecordConfig.values.set(0, newValue);
			EditPulseRecord.this.finish();
		}
    	
    };
	private OnClickListener recordBackListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			Toast.makeText(EditPulseRecord.this, "Record didn't change", Toast.LENGTH_SHORT).show();	
			EditPulseRecord.this.finish();
		}
    	
    };
    private OnClickListener recordDeleteListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			Toast.makeText(EditPulseRecord.this, "Record deleted", Toast.LENGTH_SHORT).show();	
			PulseRecordConfig.values.remove(0);
			EditPulseRecord.this.finish();
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
            Toast.makeText(getApplicationContext(), "Date Set", Toast.LENGTH_SHORT).show();
            printDate = printDay + "-" + printMonth + "-" + printYear;
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
					
			Toast.makeText(getApplicationContext(), "Time Set", Toast.LENGTH_SHORT).show();
			printTime = printHour + ":" + printMinute;
			btn_settime.setText(printTime);
		}
    };
}


//Pulse :         70 /min    14.30 ,  07 - Jul