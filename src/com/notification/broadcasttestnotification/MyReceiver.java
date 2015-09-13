package com.notification.broadcasttestnotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import android.net.Uri;

public class MyReceiver extends BroadcastReceiver {
	NotificationManager mNManager;
	private static final int NOTIFY_ID = 1100;

	@Override
	public void onReceive(Context context, Intent intent) {
		// what happen when the broadcast fire
		// Toast.makeText(context, "hellllo", Toast.LENGTH_SHORT).show();

		mNManager = (NotificationManager) context
				.getSystemService(Context.NOTIFICATION_SERVICE);
		// 1. icon to show like facebook icon
		// 2. the title that show in the first apperance

		final Notification msg = new Notification(R.drawable.ic_launcher,
				"New event of importance", System.currentTimeMillis());

		// title
		CharSequence contentTitle = "hello midooooo";
		// sumary
		CharSequence contentText = "love u toteeee <3";

		// where i go when i press that notification ...
		// Uri.parse("http://www.pearson.com")
		Intent msgIntent = new Intent(Intent.ACTION_VIEW,
				Uri.parse("http://www.facebook.com"));

		PendingIntent intents = PendingIntent.getActivity(context, 0,
				msgIntent, Intent.FLAG_ACTIVITY_NEW_TASK);
		

		msg.defaults |= Notification.DEFAULT_SOUND;
		msg.flags |= Notification.FLAG_AUTO_CANCEL;
		// use the pendingIntent
		msg.setLatestEventInfo(context.getApplicationContext(), contentTitle, contentText, intents);
		// to start the notification
		mNManager.notify(NOTIFY_ID, msg);
	}
}
