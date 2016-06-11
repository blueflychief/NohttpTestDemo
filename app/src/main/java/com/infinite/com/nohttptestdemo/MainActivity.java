package com.infinite.com.nohttptestdemo;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.infinite.com.nohttptestdemo.nohttp.CallServer;
import com.infinite.com.nohttptestdemo.nohttp.HttpListener;
import com.yolanda.nohttp.Logger;
import com.yolanda.nohttp.RequestMethod;
import com.yolanda.nohttp.rest.Request;

public class MainActivity extends AppCompatActivity {
    private Button bt_method;
    private Button bt_image;
    private Button bt_json;
    private Button bt_post_body;
    private Button bt_fastjson;
    private Button bt_cache;
    private Button bt_redirect;
    private Button bt_uploadfile;
    private Button bt_download;
    private Button bt_cancel;
    private Button bt_sync;
    private Button bt_proxy;
    private TextView tv_text;
    private ImageView iv_image;
    private Request request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_method = (Button) findViewById(R.id.bt_method);
        bt_image = (Button) findViewById(R.id.bt_image);
        bt_json = (Button) findViewById(R.id.bt_json);
        bt_post_body = (Button) findViewById(R.id.bt_post_body);
        bt_fastjson = (Button) findViewById(R.id.bt_fastjson);
        bt_cache = (Button) findViewById(R.id.bt_cache);
        bt_redirect = (Button) findViewById(R.id.bt_redirect);
        bt_uploadfile = (Button) findViewById(R.id.bt_uploadfile);
        bt_download = (Button) findViewById(R.id.bt_download);
        bt_cancel = (Button) findViewById(R.id.bt_cancel);
        bt_sync = (Button) findViewById(R.id.bt_sync);
        bt_proxy = (Button) findViewById(R.id.bt_proxy);
        iv_image = (ImageView) findViewById(R.id.iv_image);
        tv_text = (TextView) findViewById(R.id.tv_text);

        bt_method.setOnClickListener(mClick);
        bt_image.setOnClickListener(mClick);
        bt_json.setOnClickListener(mClick);
        bt_post_body.setOnClickListener(mClick);
        bt_fastjson.setOnClickListener(mClick);
        bt_cache.setOnClickListener(mClick);
        bt_redirect.setOnClickListener(mClick);
        bt_uploadfile.setOnClickListener(mClick);
        bt_download.setOnClickListener(mClick);
        bt_cancel.setOnClickListener(mClick);
        bt_sync.setOnClickListener(mClick);
        bt_proxy.setOnClickListener(mClick);
//        bt_method.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Request<String> request = null;
//                String url = "http://test.kuaikuaikeji.com/kas/appindexv6";
//                request = NoHttp.createStringRequest(url, RequestMethod.GET);
//
////
////                if (request != null) {
//////                    request.add("userName", "yolanda");// String类型
//////                    request.add("userPass", "yolanda.pass");
//////                    request.add("userAge", 20);// int类型
//////                    request.add("userSex", '1');// char类型，还支持其它类型
////
//////        // 添加到请求队列
////                    CallServer.getRequestInstance().add(MainActivity.this, 0, request, httpListener, true, true);
////                }
//                CallServer.getRequestInstance().httpGet(MainActivity.this, 0, httpListener, true, true, url,
//                        "userName", "yolanda",
//                        "userPass", "yolanda.pass",
//                        "userAge", "20",
//                        "userSex", String.valueOf(1));
//
//
//            }
//        });

    }

    private String url = "http://www.baidu.com";
    private View.OnClickListener mClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.bt_method:
                    request = CallServer.getRequestInstance().httpGet(MainActivity.this, 0, httpListener, true, true, url,
                            "userName", "yolanda",
                            "userPass", "yolanda.pass",
                            "userAge", "20",
                            "userSex", String.valueOf(1));
                    break;
                case R.id.bt_image:


                    break;
                case R.id.bt_json:
                    break;
                case R.id.bt_post_body:
                    break;
                case R.id.bt_fastjson:
                    break;
                case R.id.bt_cache:
                    break;
                case R.id.bt_redirect:
                    break;
                case R.id.bt_uploadfile:
                    break;
                case R.id.bt_download:
                    break;
                case R.id.bt_cancel:
                    break;
                case R.id.bt_sync:
                    break;
                case R.id.bt_proxy:
                    request = CallServer.getRequestInstance().httpProxy(MainActivity.this, 0, httpListener, RequestMethod.GET, true, true, "http://www.baidu.com",
                            "119.75.218.70", 80);
                    break;
            }
        }
    };


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        request.cancel();
    }

    private HttpListener<String> httpListener = new HttpListener<String>() {

        @Override
        public void onSucceed(int what, String response) {
            Logger.i("-------response:" + response);
            tv_text.setText(response);
            showMessageDialog("结果", response);
        }

        @Override
        public void onFailed(int what, String url, Object tag, Exception exception, int responseCode, long networkMillis) {
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void showMessageDialog(CharSequence title, CharSequence message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("知道了", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }
}
