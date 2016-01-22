package com.example.supersenior.record;

import java.util.Calendar;

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
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.supersenior.R;

public class CreateBodyTempRecord extends Activity{
	
	private Button btn_save, btn_delete,btn_setdate, btn_settime;
	
	private int year;
    private int month;
    private int days;
    private int hour;
    private int minute;
    
	
	private static final int CASE_DATE = 1;
	private static final int CASE_TIME = 2;
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_temp_record);
		
		Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        days = c.get(Calendar.DAY_OF_MONTH);
        hour = c.get(Calendar.HOUR_OF_DAY);
        minute = c.get(Calendar.MINUTE);
			
		btn_save = (Button) findViewById(R.id.temp_save);
		btn_delete = (Button) findViewById(R.id.temp_delete); 
		btn_setdate = (Button) findViewById(R.id.temp_date_button);
		btn_settime = (Button) findViewById(R.id.temp_time_button);
		
		btn_save.setOnClickListener(recordSaveListener);
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
			Toast.makeText(CreateBodyTempRecord.this, "Record Saved", Toast.LENGTH_SHORT).show();	
			
			CreateBodyTempRecord.this.finish();
		}
    	
    };
	private OnClickListener recordDeleteListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			Toast.makeText(CreateBodyTempRecord.this, "Record didn't save", Toast.LENGTH_SHORT).show();	
			CreateBodyTempRecord.this.finish();
		}
    	
    };
    
    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
	        case CASE_DATE:
	           return new DatePickerDialog(this, datePickerListener, year, month,days);
	        case CASE_TIME:
	        	return new TimePickerDialog(this, timePickerListener, hour, minute, true);
        }
        return null;
    }
 
    private DatePickerDialog.OnDateSetListener datePickerListener 
                = new DatePickerDialog.OnDateSetListener() {
 
        public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {
        	String printYear = String.valueOf(selectedYear); 
        	String printMonth = String.valueOf(selectedMonth+1);
        	String printDay = String.valueOf(selectedDay);
        	
        	if (printMonth.length() == 1)
        		printMonth = "0" + printMonth;
			if (printDay.length() == 1)
				printDay = "0" + printDay;
			
            String t = printDay+"-"+printMonth+"-"+printYear;
            Toast.makeText(getApplicationContext(), "Date Set", Toast.LENGTH_SHORT).show();
            
            btn_setdate.setText(t);
        }
    };
    
    private OnTimeSetListener timePickerListener = new OnTimeSetListener() {

		@Override
		public void onTimeSet(TimePicker view, int selectedHourOfDay, int selectedMinute) {
			String printHour = String.valueOf(selectedHourOfDay);
			String printMinute = String.valueOf(selectedMinute); 
			
			if (printHour.length() == 1)
				printHour = "0" + printHour;
			if (printMinute.length() == 1)
				printMinute = "0" + printMinute;
				
			String t = printHour+":"+printMinute;
			Toast.makeText(getApplicationContext(), "Time Set", Toast.LENGTH_SHORT).show();
			
			btn_settime.setText(t);
		}
    };

}
