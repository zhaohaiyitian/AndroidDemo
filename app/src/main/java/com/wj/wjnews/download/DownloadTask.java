package com.wj.wjnews.download;

/**
 * Created by wj on 18-4-30.
 */

public class DownloadTask {
    private String mUrl;
    private DownloadCallBack mCallBack;

    public DownloadTask(String mUrl, DownloadCallBack mCallBack) {
        this.mUrl = mUrl;
        this.mCallBack = mCallBack;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String mUrl) {
        this.mUrl = mUrl;
    }

    public DownloadCallBack getCallBack() {
        return mCallBack;
    }

    public void setCallBack(DownloadCallBack mCallBack) {
        this.mCallBack = mCallBack;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DownloadTask that = (DownloadTask) o;

        if (mUrl != null ? !mUrl.equals(that.mUrl) : that.mUrl != null) return false;
        return mCallBack != null ? mCallBack.equals(that.mCallBack) : that.mCallBack == null;
    }

    @Override
    public int hashCode() {
        int result = mUrl != null ? mUrl.hashCode() : 0;
        result = 31 * result + (mCallBack != null ? mCallBack.hashCode() : 0);
        return result;
    }
}
