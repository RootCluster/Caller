package org.incoder.caller.one;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import android.widget.Toast;

/**
 * CallerStateListener
 *
 * @author Jerry xu
 * @date 2018/3/26 17:16.
 */
public class CallerStateListener extends PhoneStateListener {

    private Context mContext;

    CallerStateListener(Context context) {
        mContext = context;
    }

    @Override
    public void onServiceStateChanged(ServiceState serviceState) {
        super.onServiceStateChanged(serviceState);
    }

    @Override
    public void onCallStateChanged(int state, String incomingNumber) {
        switch (state) {
            // 电话挂断
            case TelephonyManager.CALL_STATE_IDLE:
                break;
            // 电话响铃
            case TelephonyManager.CALL_STATE_RINGING:
                Toast.makeText(mContext, "服务监听PhoneStateListener\n来电号码" + incomingNumber, Toast.LENGTH_LONG).show();
                break;
            // 来电接通 或者 去电，去电接通  但是没法区分
            case TelephonyManager.CALL_STATE_OFFHOOK:
                break;
            default:
                break;
        }
    }
}
