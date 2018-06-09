package com.wj.wjnews.framework.ioc;

import android.app.Activity;
import android.view.View; /**
 * author: jackey
 * date: 18-6-6
 */
public class ViewFinder {
    private Activity mActivity;
    private View mView;
    public ViewFinder(View view) {
        this.mView=view;
    }

    public ViewFinder(Activity activity) {
        this.mActivity=activity;
    }

    public View findViewById(int viewId) {
        return mActivity!=null?mActivity.findViewById(viewId):mView.findViewById(viewId);
    }
}
