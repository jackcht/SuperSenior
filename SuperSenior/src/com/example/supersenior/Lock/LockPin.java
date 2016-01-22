package com.example.supersenior.Lock;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.supersenior.ActivityForFragment;
import com.example.supersenior.R;

public class LockPin extends Activity {

	Button b[]  = new Button[10];
	int b_id[] = {R.id.lock_b0,R.id.lock_b1,R.id.lock_b2,
				  R.id.lock_b3,R.id.lock_b4,R.id.lock_b5,
				  R.id.lock_b6,R.id.lock_b7,R.id.lock_b8,R.id.lock_b9,};
	EditText pw;
	Button left, right;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_lock_pin);
		
		pw = (EditText) findViewById(R.id.lock_pw);
		pw.setCursorVisible(false);
		
		left = (Button)findViewById(R.id.lock_left);
		right = (Button)findViewById(R.id.lock_right);
		//left.getBackground().setAlpha(0);
		
		
		right.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String t_pw = pw.getText().toString() ;
				if(t_pw.length()>0){
					t_pw = t_pw.substring(0, t_pw.length()-1);
					pw.setText(t_pw);
				}
			}
		});
		

		
		for(int i=0; i<=9; i++){
			final int temp = i;
			b[i] = (Button) findViewById(b_id[i]);
			b[i].setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					String t_pw = pw.getText().toString() + String.valueOf(temp);
					pw.setText(t_pw);
					if(t_pw.length() == 4){
						if(t_pw.equals("1234")){
							Toast.makeText(getApplicationContext(), "password Match", Toast.LENGTH_SHORT).show();
							//start the intent to get into the application
							Intent i = new Intent(getApplicationContext(), ActivityForFragment.class);
							startActivity(i);
							finish();
						
						}
						else{
							Toast.makeText(getApplicationContext(), "wrong password!", Toast.LENGTH_SHORT).show();
							t_pw = "";
							pw.setText(t_pw);
						}
						
					}
					
					
					
					
				}
			});
		
		}
		
		
		
		
		
		
	}

}
