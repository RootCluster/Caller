package org.incoder.caller.two;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.Log;

import java.util.Objects;

import static android.content.ContentValues.TAG;

/**
 * PhoneStateReceiver
 *
 * @author Jerry xu
 * @date 2018/3/26 17:16.
 */
public class PhoneStateReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (Objects.requireNonNull(intent.getAction()).equals(TelephonyManager.ACTION_PHONE_STATE_CHANGED)) {
                String phoneNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
                TelephonyManager telephony = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
                int state = 0;
                if (telephony != null) {
                    state = telephony.getCallState();
                }
                switch (state) {
                    case TelephonyManager.CALL_STATE_RINGING:
                        Log.i(TAG, "[Broadcast:]等待接电话=" + phoneNumber);
                        break;
                    case TelephonyManager.CALL_STATE_IDLE:
                        Log.i(TAG, "[Broadcast:]电话挂断=" + phoneNumber);
                        break;
                    case TelephonyManager.CALL_STATE_OFFHOOK:
                        Log.i(TAG, "[Broadcast:]通话中=" + phoneNumber);
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
