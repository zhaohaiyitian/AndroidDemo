package com.wj.wjnews.view.dialog;

import android.app.Dialog;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by wj on 18-4-18.
 * 封装一个提示的Dialog
 */

public class PromptDialog {
    private static PromptDialog instance;
    private Dialog dialog;
    private TextView title,content;
    private Button ok,cancel;
    private PromptDialog(){}
    public static PromptDialog getInstance() {
        if (instance==null) {
            instance=new PromptDialog();
        }
        return instance;
    }

    public PromptDialog setTitle(CharSequence title) {
        this.title.setText(title);
        return instance;
    }
    public PromptDialog setTitle(int resId) {
        this.title.setText(resId);
        return instance;
    }
    public PromptDialog setContent(CharSequence content) {
        this.content.setText(content);
        return instance;
    }
    public PromptDialog setContent(int resId) {
        this.content.setText(resId);
        return instance;
    }

    public void showDialog() {
        if (dialog!=null) {
            dialog.show();
        }
    }
    public void dismissDialog() {
        if (dialog!=null) {
            dialog.dismiss();
        }
    }

}
