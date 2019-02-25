package com.ccbcfx.learn.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
    public static boolean jugeLength(String str, int length) {
        if (null != str
                && str.length() > length) {
            return false;
        }
        return true;
    }

    /**
     *
     * @param str
     * @return 如果包含特殊字符返回true
     */
    public static boolean haveSpecialChar(String str){
        String regEx = "[ _`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\n|\r|\t";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.find();
    }
}
