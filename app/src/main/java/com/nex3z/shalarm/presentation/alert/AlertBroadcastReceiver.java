package com.nex3z.shalarm.presentation.alert;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.nex3z.shalarm.presentation.alert.ui.AlertActivity;
import com.nex3z.shalarm.presentation.model.AlarmModel;
import com.nex3z.shalarm.presentation.utility.AlarmScheduleUtility;

public class AlertBroadcastReceiver extends BroadcastReceiver {
    private static final String LOG_TAG = AlertBroadcastReceiver.class.getSimpleName();

    public static final String ALARM = "alarm";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.v(LOG_TAG, "onReceive()");
        AlarmScheduleUtility.triggerAlarmService(context);

        AlertWakeLock.lock(context);

        AlarmModel alarmModel = intent.getParcelableExtra(ALARM);
        Log.v(LOG_TAG, "onReceive(): alarmModel = " + alarmModel);
        if (alarmModel != null) {
            Intent alertIntent = new Intent(context, AlertActivity.class);
            alertIntent.putExtra(AlertActivity.ALARM, alarmModel);
            alertIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(alertIntent);
        }
    }
}