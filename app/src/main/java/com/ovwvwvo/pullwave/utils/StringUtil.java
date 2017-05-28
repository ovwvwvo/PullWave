package com.ovwvwvo.pullwave.utils;

import android.support.annotation.Nullable;

/**
 * Copyright ©2017 by rawer
 */

public class StringUtil {

    public static boolean isBlank(String str) {
        return isEmpty(str) || isEmpty(str.trim());
    }

    public static boolean isEmpty(@Nullable CharSequence str) {
        return str == null || str.length() == 0;
    }

}
