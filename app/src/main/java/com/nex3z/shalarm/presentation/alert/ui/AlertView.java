package com.nex3z.shalarm.presentation.alert.ui;

import android.content.Context;
import android.net.Uri;

public interface AlertView {

    void setRingtone(Uri uri);

    void startRingtone();

    void pauseRingtone();

    void stopRingtone();

    void startVibrate();

    void stopVibrate();

    void showResult(long time);

    void showMessage(String message);

    Context getContext();

    void finishView();
}