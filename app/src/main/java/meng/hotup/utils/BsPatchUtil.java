package meng.hotup.utils;

/**
 * Created by Administrator on 2016/11/28.
 */

public class BsPatchUtil {
    static {
        System.loadLibrary("apkpatch");
    }
    public static native  int patch(String oldApk, String newApk, String patch);
}
