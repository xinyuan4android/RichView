package com.pcitc.richtext.sample.span;

import android.os.Parcel;
import android.text.style.BackgroundColorSpan;

import androidx.annotation.NonNull;

public class MyBackgroundColorSpan extends BackgroundColorSpan {
    public MyBackgroundColorSpan(int color) {
        super(color);
    }

    public MyBackgroundColorSpan(@NonNull Parcel src) {
        super(src);
    }
}
