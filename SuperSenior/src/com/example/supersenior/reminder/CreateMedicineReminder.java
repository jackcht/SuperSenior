package com.example.supersenior.reminder;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.supersenior.ActivityForFragment;
import com.example.supersenior.R;

public class CreateMedicineReminder extends Activity {
	
	Button pill[] = new Button[4];
	int pill_id[] = {R.id.pill1,R.id.pill2,R.id.pill3,R.id.pill4};
	int pill_color[] = {1,1,1,1};
	
	Button day[] = new Button[3];
	int day_id[] = {R.id.reminder_form_morning, R.id.reminder_form_noon, R.id.reminder_form_night};
	int day_color[] = {1,1,1,1};
	int day_resource_normal[] = {R.drawable.morning, R.drawable.noon, R.drawable.night};
	int day_resource_color[] = {R.drawable.morning_color, R.drawable.noon_color, R.drawable.night_color};	
	
	Button weekday[] = new Button[7];
	int weekday_id[] = {R.id.mon,R.id.tue,R.id.wed,R.id.thu,R.id.fri,R.id.sat,R.id.sun};
	int weekday_color[] = {1,1,1,1,1,1,1};
	int weekday_resource_normal[] = {R.drawable.mo,R.drawable.tu,R.drawable.we,R.drawable.th,R.drawable.fr,R.drawable.sa,R.drawable.su};
	int weekday_resource_color[] = {R.drawable.mo_color,R.drawable.tu_color,R.drawable.we_color,R.drawable.th_color,R.drawable.fr_color,R.drawable.sa_color,R.drawable.su_color};
	
	EditText et_pill_quantity, et_frequency;
	
	int pill_quantity =0;
	int frequency_num =0;
	
	
	TextView reminder_date_set;

	
	Button setDate, alert_sound, alert_vibrate, save;
	
	int alert_sound_color = 1;
	int alert_vibrate_color = 1;
	
	
	int date_counter = 0;

    private int year;
    private int month;
    private int days;
 
    static final int DATE_DIALOG_ID = 999;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_reminder);
		
		et_pill_quantity = (EditText)findViewById(R.id.reminder_form_et_quantity);
		et_frequency = (EditText)findViewById(R.id.reminder_form_et_frequency);
		et_pill_quantity.setGravity(Gravity.CENTER);
		et_frequency.setGravity(Gravity.CENTER);
		
		reminder_date_set = (TextView) findViewById(R.id.Reminder_date_set);
		reminder_date_set.setText("");
		
		
		setDate = (Button) findViewById(R.id.reminder_form_date);
		setCurrentDateOnView();
		
		save = (Button) findViewById(R.id.reminder_save);
		
		alert_vibrate = (Button)findViewById(R.id.reminder_form_alert_virbate);

		alert_sound = (Button)findViewById(R.id.reminder_form_alert_sound);
		
		
		
		save.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent ii = new Intent(getApplicationContext(), ActivityForFragment.class);
				startActivity(ii);
				Toast.makeText(getApplicationContext(), "ReminderCreated.", Toast.LENGTH_SHORT).show();
				finish();
			}
		});
		
		alert_sound.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				alert_sound_color *= -1;
				if(alert_sound_color ==1){
					alert_sound.setBackgroundResource(R.drawable.sound);
					
				}
				else{
					alert_sound.setBackgroundResource(R.drawable.sound_color);
					Toast.makeText(getApplicationContext(), "Sound alert selected", Toast.LENGTH_SHORT).show();
				}
			}
		});
		
		
		alert_vibrate.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				alert_vibrate_color *= -1;
				if(alert_vibrate_color ==1){
					alert_vibrate.setBackgroundResource(R.drawable.vibrate);
					
				}
				else{
					alert_vibrate.setBackgroundResource(R.drawable.vibrate_color);
					Toast.makeText(getApplicationContext(), "Vibrate alert selected", Toast.LENGTH_SHORT).show();
				}
			}
		});
		
		setDate.setOnClickListener(new View.OnClickListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(date_counter%2==0){
					setDate.setBackgroundResource(R.drawable.calendar_color);
					Toast.makeText(getApplicationContext(), "Set Date", Toast.LENGTH_SHORT).show();
					showDialog(DATE_DIALOG_ID);
					date_counter++;
				}
				else{
					reminder_date_set.setText("");
					date_counter++;
					setDate.setBackgroundResource(R.drawable.calendar);
					Toast.makeText(getApplicationContext(), "Date switched off.", Toast.LENGTH_SHORT).show();
				}
				
			}
		});
		
		
		pill_button_listener();
		day_button_listener();
		weekday_button_listener();
		
	}
	
	public void pill_button_listener(){
		for(int i=0; i<pill_id.length; i++){
			final int temp = i;	
			pill[i] = (Button)findViewById(pill_id[i]);
			pill[i].setOnClickListener(new View.OnClickListener() {
			
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					pill_color[temp] *= -1;
					if(pill_color[temp]==1){
						pill[temp].setBackgroundResource(R.drawable.pill);
						pill_quantity--;
					}
					else{
						pill[temp].setBackgroundResource(R.drawable.pill_color);
						pill_quantity++;
						
					}
					
					et_pill_quantity.setText(""+pill_quantity);
					
				}
			});
		}
	}
	
	public void day_button_listener(){
		
		for(int i=0; i<day_id.length; i++){
			final int temp = i;
			day[i] = (Button)findViewById(day_id[i]);
			day[i].setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					day_color[temp] *=-1;
					// TODO Auto-generated method stub
					if(day_color[temp]==1){
						day[temp].setBackgroundResource(day_resource_normal[temp]);
						frequency_num--;
					}
					else{
						day[temp].setBackgroundResource(day_resource_color[temp]);
						frequency_num++;
						
					}
					et_frequency.setText(""+frequency_num);
				}
			});
		}
	}
	
	public void weekday_button_listener(){
		for(int i =0; i<weekday_id.length; i++){
			final int temp = i;
			weekday[i] = (Button)findViewById(weekday_id[i]);
			weekday[i].setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					weekday_color[temp] *= -1;
					if(weekday_color[temp]==1){
						weekday[temp].setBackgroundResource(weekday_resource_normal[temp]);
					}
					else{
						
						weekday[temp].setBackgroundResource(weekday_resource_color[temp]);
					}
					
					
					
				}
			});
		}
	}
	

	// display current date
    public void setCurrentDateOnView() {
 
        final Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        days = c.get(Calendar.DAY_OF_MONTH);
 
        // set current date into textview
        //Toast.makeText(getApplicationContext(), "Date set: "+ days+"-"+month+"-"+year, Toast.LENGTH_LONG).show();
    }

 
    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
        case DATE_DIALOG_ID:
           // set date picker as current date
           return new DatePickerDialog(this, datePickerListener, year, month,days);
        }
        return null;
    }
 
    private DatePickerDialog.OnDateSetListener datePickerListener 
                = new DatePickerDialog.OnDateSetListener() {
 
        // when dialog box is closed, below method will be called.
        public void onDateSet(DatePicker view, int selectedYear,
                int selectedMonth, int selectedDay) {
            year = selectedYear;
            month = selectedMonth + 1;
            days = selectedDay;
 
            // set selected date into textview
            String t = "Date set: "+ days+"-"+month+"-"+year;
            Toast.makeText(getApplicationContext(), t, Toast.LENGTH_SHORT).show();
            
            reminder_date_set.setText(t);
            
           
 
        }
    };

	
	
	
}
