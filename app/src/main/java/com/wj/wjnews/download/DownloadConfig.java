package com.wj.wjnews.download;

/**
 * Created by wj on 18-5-5.
 */

public class DownloadConfig {
    private int coreTHreadSize;
    private int maxThreadSize;
    private int localProgressThreadSize;
    private DownloadConfig(Builder builder) {
        coreTHreadSize=builder.coreTHreadSize==0?DownloadManager.MAX_THREAD:builder.coreTHreadSize;
        maxThreadSize=builder.maxThreadSize==0?DownloadManager.MAX_THREAD:builder.maxThreadSize;
        localProgressThreadSize=builder.localProgressThreadSize==0?DownloadManager.localProgressSize:builder.localProgressThreadSize;

    }
    public static class Builder {
        private int coreTHreadSize;
        private int maxThreadSize;
        private int localProgressThreadSize;

        public Builder setCoreTHreadSize(int coreTHreadSize) {
            this.coreTHreadSize = coreTHreadSize;
            return this;
        }

        public Builder setMaxThreadSize(int maxThreadSize) {
            this.maxThreadSize = maxThreadSize;
            return this;
        }

        public Builder setLocalProgressThreadSize(int localProgressThreadSize) {
            this.localProgressThreadSize = localProgressThreadSize;
            return this;
        }

        public DownloadConfig builder() {
            return new DownloadConfig(this);
        }
    }


}
