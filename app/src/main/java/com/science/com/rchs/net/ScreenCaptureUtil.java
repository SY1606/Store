package com.science.com.rchs.net;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.view.View;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class ScreenCaptureUtil {
    private static ScreenCaptureUtil instance = null;

    private ScreenCaptureUtil() {
    }

    public static ScreenCaptureUtil getInstance() {
        if (null == instance) {
            instance = new ScreenCaptureUtil();
        }
        return instance;
    }

    public Bitmap getScreen(Activity activity) {
        View dView = activity.getWindow().getDecorView();
        dView.setDrawingCacheEnabled(false);
        dView.buildDrawingCache();
        Bitmap bitmap = Bitmap.createBitmap(dView.getDrawingCache());
        if (bitmap != null) {
            try {
                // 首先保存图片
                String storePath = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "HIS";
                File appDir = new File(storePath);
                if (!appDir.exists()) {
                    appDir.mkdir();
                }
                String fileName = System.currentTimeMillis() + ".jpg";
                File file = new File(appDir, fileName);

                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
                bitmap.compress(Bitmap.CompressFormat.JPEG, 80, bos);
                bos.flush();
                bos.close();

                Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
                Uri uri = Uri.fromFile(file);
                intent.setData(uri);
                activity.sendBroadcast(intent);
                dView.destroyDrawingCache();
                return bitmap;
            } catch (Exception e) {
                return null;
            }
        } else {
            return null;
        }
    }
}
