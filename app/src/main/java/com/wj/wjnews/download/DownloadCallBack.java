package com.wj.wjnews.download;

import java.io.File;

/**
 * Created by wj on 18-4-30.
 */

public interface DownloadCallBack {
    void success(File file);
    void fail(int errorCode,String errorMessage);
    void progress(int progress);
}
