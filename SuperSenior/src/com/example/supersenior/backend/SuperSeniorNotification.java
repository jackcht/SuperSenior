package com.example.supersenior.backend;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

import com.example.supersenior.R;
import com.example.supersenior.reminder.EditReminder;

public class SuperSeniorNotification {

	public SuperSeniorNotification(){
		
	};
	
	
	public void sendNotification(Context context, int notificationNumber, String NotificationTitle, String NotificationMsg){
		
		String msgString = NotificationMsg;
		
		NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context);
		
		mBuilder.setStyle(new NotificationCompat.BigTextStyle().bigText(msgString));
		mBuilder.setContentTitle(NotificationTitle);
		
		mBuilder.setSmallIcon(R.drawable.super_senior_icon);
		Uri soundUri =  RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
		mBuilder.setSound(soundUri);
		mBuilder.setAutoCancel(true);
		
		long[] pattern = {0, 300, 500, 300, 500, 300, 500, 300, 500, 300, 500, 300, 500, 300, 500};
		mBuilder.setVibrate(pattern);
				
		
		int mNotificationId = notificationNumber;

		Intent resultIntent = new Intent(context, EditReminder.class);
		PendingIntent resultPendingIntent = PendingIntent.getActivity(context, 0, resultIntent, 0);
						
		
		mBuilder.setContentIntent(resultPendingIntent);
		
		NotificationManager notificationManager =  (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
		
		notificationManager.notify(mNotificationId, mBuilder.build());
	}
	
	
}
