package com.pcitc.richtext.sample.span;

import android.text.TextPaint;
import android.text.style.UnderlineSpan;

import androidx.annotation.NonNull;

public class MyDeleteUnderlineSpan extends UnderlineSpan {
    @Override
    public void updateDrawState(@NonNull TextPaint ds) {
        super.updateDrawState(ds);
        ds.setUnderlineText(false);
    }
}
