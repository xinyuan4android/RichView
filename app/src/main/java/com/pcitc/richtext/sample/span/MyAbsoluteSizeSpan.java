package com.pcitc.richtext.sample.span;

import android.text.style.AbsoluteSizeSpan;

public class MyAbsoluteSizeSpan extends AbsoluteSizeSpan {
    public MyAbsoluteSizeSpan(int size) {
        super(size);
    }

    public MyAbsoluteSizeSpan(int size, boolean dip) {
        super(size, dip);
    }

}
