package com.example.supersenior.backend;

import java.util.ArrayList;

public class AutoMeasureConfig {
	public static ArrayList<String> values = new ArrayList<String>();
	public static boolean CONNECTED = false;

	static {
		values.add("1. Xiaomi WristBand");
		values.add("2. Android Watch");

	}
	
	
	
	
	public static ArrayList<String> RECORDS = new ArrayList<String>();
	
	static {
		RECORDS.add("Pulse:             70/min     \n            14:30, 07-07-2014");
		RECORDS.add("Blood Pressure:     100/70mmHg \n            14:30, 07-07-2014");
		RECORDS.add("Body Temperature:  36.8 ℃                \n            14:30, 07-07-2014");
		
		RECORDS.add("Pulse:             75/min     \n            21:30, 16-10-2014");
		RECORDS.add("Blood Pressure:     112/76mmHg \n            21:30, 16-10-2014");
		RECORDS.add("Body Temperature:  36.9 ℃                \n            21:30, 16-10-2014");

	}
	
}
