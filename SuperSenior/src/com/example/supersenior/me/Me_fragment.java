package com.example.supersenior.me;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;     
import java.util.List;
import android.app.AlertDialog;  
import android.app.AlertDialog.Builder;  
import android.app.Dialog;
import android.content.DialogInterface; 
import android.widget.Button;  
import com.example.supersenior.R;


public class Me_fragment extends DialogFragment {
	
    private Button measureTimeButton, saveBtn;
    private List<String> list = new ArrayList<String>();        
    private Spinner genderSelect;     
    private ArrayAdapter<String> adapter; 
	private final int CHOICE = 1;  
	
	private boolean isModal = false;
    
    boolean[] selected = new boolean[]{false,false,false,false,false,false};
	

	
	public Me_fragment(){
		
	}
	
	public static Me_fragment newInstance(int choice) {
		Me_fragment frag = new Me_fragment();
        Bundle args = new Bundle();
        args.putInt("choice", choice);
        frag.setArguments(args);
        frag.isModal = true; 
        return frag;
    }

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
	{
		if(isModal) // AVOID REQUEST FEATURE CRASH
        {
			return super.onCreateView(inflater, container, savedInstanceState);
        }
        else
        {
			View v = inflater.inflate(R.layout.fragment_me, container, false);
			
			setGenderSpinner(v);
			
			measureTimeButton = (Button) v.findViewById(R.id.measure_time_button); 
			measureTimeButton.setOnClickListener(measureTimeSelectListener);
			saveBtn = (Button) v.findViewById(R.id.save_btn); 
			saveBtn.setOnClickListener(meSettingSaveListener);
			return v;
        }
	}
	
	private void setGenderSpinner(View v) {
	    list.add("Male");     
	    list.add("Female");
		list.add("(Optional)");
		genderSelect = (Spinner) v.findViewById(R.id.spinner_gender);
        
        adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item, list);  
        
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);   
        
        genderSelect.setAdapter(adapter);
        
        genderSelect.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){     
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {          
                arg0.setVisibility(View.VISIBLE);     
            }     
            public void onNothingSelected(AdapterView<?> arg0) {          
                arg0.setVisibility(View.VISIBLE);     
            }     
        });
	}
	
	private OnClickListener meSettingSaveListener = new OnClickListener()
	{
		public void onClick(View v) {
			Toast.makeText(getActivity(), "Setting Saved", Toast.LENGTH_SHORT).show();
		 }
	};
	
	private OnClickListener measureTimeSelectListener = new OnClickListener()
	{
		 public void onClick(View v) {
             showDialog(); 
		 }
	};  
	
	void showDialog() {
	    DialogFragment newFragment = Me_fragment.newInstance(CHOICE);
	    newFragment.show(getFragmentManager(), "dialog");
	}
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) { 
		int choice = getArguments().getInt("choice");

        switch(choice) {  
            case CHOICE:  
            	Builder builder = new AlertDialog.Builder(getActivity());  
            	
            	Dialog dialog = null;

            	builder.setTitle("Auto Measure Time Select");
            	
            	DialogInterface.OnMultiChoiceClickListener mutiListener = new DialogInterface.OnMultiChoiceClickListener() 
            	{       
                    @Override  
                    public void onClick(DialogInterface dialogInterface, int which, boolean isChecked) 
                    {
                        selected[which] = isChecked;  
                    }  
                };  
                builder.setMultiChoiceItems(R.array.measure_time, selected, mutiListener); 
            	
                DialogInterface.OnClickListener btnListener = new DialogInterface.OnClickListener() 
                {  
                    @Override  
                    public void onClick(DialogInterface dialogInterface, int which) {  
                        String selectedStr = "";  
                        for(int i=0; i<selected.length; i++) {  
                            if(selected[i] == true) {  
                                selectedStr = selectedStr + " " +  
                                    getResources().getStringArray(R.array.measure_time)[i];  
                            }  
                        }   
                    }  
                }; 
                        
                builder.setPositiveButton("OK", btnListener);
            	
            	dialog = builder.create();
            	
            	return dialog;
        }  
        return null;  
    }  
}
