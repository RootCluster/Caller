package org.incoder.caller.one;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;

/**
 * CallerService
 *
 * @author Jerry xu
 * @date 2018/3/26 17:20.
 */
public class CallerService extends Service {

    public static final String ACTION_REGISTER_LISTENER = "action_register_listener";

    public CallerService() {

    }

    /**
     * 当另一个组件想通过调用 bindService() 与服务绑定（例如执行 RPC）时，系统将调用此方法
     *
     * @param intent
     * @return
     */
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * 首次创建服务时，系统将调用此方法来执行一次性设置程序（在调用 onStartCommand() 或 onBind() 之前）
     * 如果服务已在运行，则不会调用此方法。
     */
    @Override
    public void onCreate() {
        super.onCreate();
    }

    /**
     * 当另一个组件（如 Activity）通过调用 startService() 请求启动服务时，系统将调用此方法
     * 一旦执行此方法，服务即会启动并可在后台无限期运行
     *
     * @param intent
     * @param flags
     * @param startId
     * @return
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String action = intent.getAction();
        if (action != null && action.equals(ACTION_REGISTER_LISTENER)) {
            registerPhoneStateListener();
        }
        return super.onStartCommand(intent, flags, startId);
    }

    private void registerPhoneStateListener() {
        CallerStateListener callerStateListener = new CallerStateListener(this);
        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        if (telephonyManager != null) {
            telephonyManager.listen(callerStateListener, PhoneStateListener.LISTEN_CALL_STATE);
        }
    }

    /**
     * 当服务不再使用且将被销毁时，系统将调用此方法。
     * 服务应该实现此方法来清理所有资源，如线程、注册的侦听器、接收器等。
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}
