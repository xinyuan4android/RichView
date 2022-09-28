package com.pcitc.richtext.sample.span;

import android.os.Parcel;
import android.text.style.ForegroundColorSpan;

import androidx.annotation.NonNull;

/**
 * 改变字体颜色的span
 */
public class MyForegroundColorSpan extends ForegroundColorSpan {

    public MyForegroundColorSpan(int color) {
        super(color);
    }

    public MyForegroundColorSpan(@NonNull Parcel src) {
        super(src);
    }
}
