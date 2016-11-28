package meng.hotup.activitys;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

import meng.hotup.R;
import meng.hotup.utils.BsPatchUtil;

public class MainActivity extends AppCompatActivity {

    private TextView mUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUp = (TextView) findViewById(R.id.up);
        mUp.setVisibility(View.GONE);
    }

    public void test(View view) {
        Toast.makeText(this, "测试数据2.0", Toast.LENGTH_SHORT).show();
    }

    public static final String PATH = Environment.getExternalStorageDirectory() + File.separator;

    //合成得到的新版apk
    public static final String NEW_APK_PATH = PATH + "newApp.apk";

    //从服务器下载来的差分包
    public static final String PATCH_PATH = PATH + "patch.patch";

    public void up(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int patch1 = BsPatchUtil.patch(getApplication().getApplicationInfo().sourceDir,
                        NEW_APK_PATH, PATCH_PATH);//耗时操作
                if (patch1 == 0) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this, "更新成功", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Intent.ACTION_VIEW);
                            intent.setDataAndType(Uri.parse("file://" + NEW_APK_PATH),
                                    "application/vnd.android.package-archive");

                            startActivity(intent);
                        }
                    });
                }
            }
        }).start();
    }
}
