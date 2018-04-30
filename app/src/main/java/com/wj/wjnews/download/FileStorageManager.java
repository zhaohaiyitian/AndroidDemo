package com.wj.wjnews.download;

import android.content.Context;
import android.os.Environment;

import com.wj.wjnews.utils.Md5Util;

import java.io.File;
import java.io.IOException;

/**
 * Created by wj on 18-4-30.
 * 文件存储管理类
 */

public class FileStorageManager {
    private static final FileStorageManager instance=new FileStorageManager();
    private Context mContext;
    private FileStorageManager() {}
    public static FileStorageManager getInstance() {
        return instance;
    }

    public void init(Context context) {
        this.mContext=context;
    }

    public File getFileByName(String url) {
        File parent;
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            parent=mContext.getExternalCacheDir();
        } else {
            parent=mContext.getCacheDir();
        }
        String fileName= Md5Util.generateCode(url);
        File file=new File(parent,fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }
}
