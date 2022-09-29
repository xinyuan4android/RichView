package com.pcitc.richtext.sample;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.widget.TextView;

import com.pcitc.richtext.sample.span.MyClickableSpan;
import com.pcitc.richtext.sample.span.MyImageSpan;

import java.util.ArrayList;
import java.util.List;

public class MyRichViewHelper {
    private Context context;

    private MyRichViewHelper(Context context) {
        this.context = context;
    }

    public static MyRichViewHelper with(Context context) {
        return new MyRichViewHelper(context);
    }

    private List<MySpanParams> paramsList = new ArrayList<>();

    public MyRichViewHelper addParams(MySpanParams spanParams) {
        paramsList.add(spanParams);
        return this;
    }

    public void into(TextView textView) {
        SpannableStringBuilder sb = new SpannableStringBuilder();
        for (MySpanParams mySpanParams : paramsList) {
            int start = sb.length();
            sb.append(mySpanParams.getString());
            int end = sb.length();
            List<Object> objects = mySpanParams.getmSpans();
            for (Object object : objects) {
                if (object instanceof MyClickableSpan) {
                    MyClickableSpan clickableSpan = (MyClickableSpan) object;
                    boolean clickable = clickableSpan.isClickable();
                    Utils.optimizeSpan(sb, start, end, MyClickableSpan.class);
                    if (clickable) {
                        sb.setSpan(object, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    }
                } else if (object instanceof MyImageSpan) {
                    sb.setSpan(object, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                } else {
                    Utils.optimizeSpan(sb, start, end, object.getClass());
                    sb.setSpan(object, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                }
            }
        }
        textView.setText(sb);
    }
}
