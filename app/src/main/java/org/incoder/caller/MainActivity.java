package org.incoder.caller;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.incoder.caller.one.CallerService;
import org.incoder.caller.two.PhoneStateReceiver;

/**
 * MainActivity
 *
 * @author Jerry xu
 * @date 2018/3/25 15:31.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnStartOne;
    private Button mBtnStartTwo;
    private Button mBtnEndOne;
    private Button mBtnEndTwo;
    private PhoneStateReceiver receiver;
    private Intent intent;
    private boolean mReceiverTag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnStartOne = findViewById(R.id.btn_start_service_one);
        mBtnEndOne = findViewById(R.id.btn_end_service_one);
        mBtnStartTwo = findViewById(R.id.btn_start_service_two);
        mBtnEndTwo = findViewById(R.id.btn_end_service_two);

        mBtnStartOne.setOnClickListener(this);
        mBtnEndOne.setOnClickListener(this);
        mBtnStartTwo.setOnClickListener(this);
        mBtnEndTwo.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            // 方式一：启动监听服务
            case R.id.btn_start_service_one:
                intent = new Intent(getApplicationContext(), CallerService.class);
                intent.setAction(CallerService.ACTION_REGISTER_LISTENER);
                startService(intent);
                Toast.makeText(getApplicationContext(), "服务已开启", Toast.LENGTH_SHORT).show();
                break;
            // 方式一：关闭监听服务
            case R.id.btn_end_service_one:
                if (intent != null) {
                    stopService(intent);
                    Toast.makeText(getApplicationContext(), "服务已关闭", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "服务已关闭,请勿重复操作", Toast.LENGTH_SHORT).show();
                }
                break;
            // 方式二：注册广播
            case R.id.btn_start_service_two:
                if (!mReceiverTag) {
                    receiver = new PhoneStateReceiver();
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction(TelephonyManager.ACTION_PHONE_STATE_CHANGED);
                    intentFilter.setPriority(Integer.MAX_VALUE);
                    mReceiverTag = true;
                    registerReceiver(receiver, intentFilter);
                    Toast.makeText(getApplicationContext(), "广播已注册", Toast.LENGTH_SHORT).show();
                }
                break;
            // 方式二：注销广播
            case R.id.btn_end_service_two:
                if (receiver != null && mReceiverTag) {
                    mReceiverTag = false;
                    unregisterReceiver(receiver);
                    Toast.makeText(getApplicationContext(), "广播已注销", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "广播已注销,请勿重复操作", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }
}
