package com.pcitc.richtext.sample.span;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

import androidx.annotation.NonNull;

import com.pcitc.richtext.sample.function.ClickableFunction;

public class MyClickableSpan extends ClickableSpan {
    private String clickString;
    private OnClickableListener listener;

    public MyClickableSpan(String clickString, OnClickableListener listener) {
        this.listener = listener;
        this.clickString = clickString;
    }

    @Override
    public void onClick(@NonNull View widget) {
        if (listener != null) {
            listener.onClickableViewClick(widget, clickString);
        }
    }

    @Override
    public void updateDrawState(@NonNull TextPaint ds) {
        super.updateDrawState(ds);
        ds.setUnderlineText(false);
    }


    public interface OnClickableListener {
        void onClickableViewClick(View view, String clickString);
    }
}
