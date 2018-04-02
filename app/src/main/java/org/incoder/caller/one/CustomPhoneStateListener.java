package org.incoder.caller.one;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;

/**
 * CustomPhoneStateListener
 *
 * @author Jerry xu
 * @date 2018/3/26 17:16.
 */
public class CustomPhoneStateListener extends PhoneStateListener {

    private Context mContext;

    public CustomPhoneStateListener(Context context) {
        mContext = context;
    }

    @Override
    public void onServiceStateChanged(ServiceState serviceState) {
        super.onServiceStateChanged(serviceState);
        /*Log.d(PhoneListenService.TAG, "CustomPhoneStateListener onServiceStateChanged: " + serviceState);*/
    }

    @Override
    public void onCallStateChanged(int state, String incomingNumber) {
        /*Log.d(PhoneListenService.TAG, "CustomPhoneStateListener state: " + state + " incomingNumber: " + incomingNumber);*/
        switch (state) {
            // 电话挂断
            case TelephonyManager.CALL_STATE_IDLE:
                break;
            // 电话响铃
            case TelephonyManager.CALL_STATE_RINGING:
                /*Log.d(PhoneListenService.TAG, "CustomPhoneStateListener onCallStateChanged endCall");*/
                HangUpTelephonyUtil.endCall(mContext);
                break;
            // 来电接通 或者 去电，去电接通  但是没法区分
            case TelephonyManager.CALL_STATE_OFFHOOK:
                break;
            default:
                break;
        }
    }
}
