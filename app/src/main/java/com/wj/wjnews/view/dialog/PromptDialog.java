package com.wj.wjnews.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.wj.wjnews.R;

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

    public PromptDialog setOk(CharSequence str, View.OnClickListener listener) {
        ok.setText(str);
        ok.setOnClickListener(listener);
        return instance;
    }

    public PromptDialog setOk(int resId, View.OnClickListener listener) {
        ok.setText(resId);
        ok.setOnClickListener(listener);
        return instance;
    }

    public PromptDialog setCancel(CharSequence str, View.OnClickListener listener) {
        cancel.setText(str);
        cancel.setOnClickListener(listener);
        return instance;
    }

    public PromptDialog setCancel(int resId, View.OnClickListener listener) {
        cancel.setText(resId);
        cancel.setOnClickListener(listener);
        return instance;
    }

    public PromptDialog create(Context context) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View promptView=inflater.inflate(R.layout.prompt_dialog,null);
        title= (TextView) promptView.findViewById(R.id.prompt);
        content=(TextView)promptView.findViewById(R.id.content);
        ok= (Button) promptView.findViewById(R.id.ok);
        cancel= (Button) promptView.findViewById(R.id.cancel);
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
