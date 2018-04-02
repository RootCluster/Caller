package org.incoder.caller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * MainActivity
 *
 * @author Jerry xu
 * @date 2018/3/25 15:31.
 */
public class MainActivity extends AppCompatActivity {

    private TextView mTextView;
    private Button mBtnStartOne;
    private Button mBtnStartTwo;
    private Button mBtnEndOne;
    private Button mBtnEndTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.tv_action);
        mBtnStartOne = findViewById(R.id.btn_start_service_one);
        mBtnEndOne = findViewById(R.id.btn_end_service_one);
        mBtnStartTwo = findViewById(R.id.btn_start_service_two);
        mBtnEndTwo = findViewById(R.id.btn_end_service_two);

        // 方式一：启动监听服务
        mBtnStartOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        // 方式一：关闭监听服务
        mBtnEndOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        // 方式二：启动监听服务
        mBtnStartTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        // 方式二：关闭监听服务
        mBtnEndTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
