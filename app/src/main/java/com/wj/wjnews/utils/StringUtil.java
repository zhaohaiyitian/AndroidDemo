package com.wj.wjnews.utils;

import android.text.TextUtils;

/**
 * Created by wj on 18-4-15.
 */

public class StringUtil {

    /**
     * 判断字符串是否由0~9组成
     */
    public static boolean isAllNumber(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
