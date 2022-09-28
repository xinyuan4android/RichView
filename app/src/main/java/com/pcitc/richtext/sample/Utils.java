package com.pcitc.richtext.sample;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class Utils {
    public static @Nullable
    SpannableStringBuilder checkSpannableStringBuilder(View richView) {
        if (richView instanceof TextView) {
            TextView tv = (TextView) richView;
            if (tv.getText() instanceof SpannableStringBuilder) {
                return (SpannableStringBuilder) tv.getText();
            }
        }
        return null;
    }

    public static void optimizeSpan(SpannableStringBuilder sb, int startIndex, int endIndex, Class kind) {
        if (sb != null) {
            Object[] spans = sb.getSpans(startIndex, endIndex, kind);
            for (Object span : spans) {
                int spanStart = sb.getSpanStart(span);
                int spanEnd = sb.getSpanEnd(span);
                int spanFlags = sb.getSpanFlags(span);
                if (spanStart == spanEnd) {
                    // 现有span的旧边界如果起始位置一样，直接删除，因为不会对页面有任何改变
                    sb.removeSpan(span);
                }
                if (startIndex <= spanStart && endIndex >= spanEnd) {
                    //现有span的边界被包含在 新设置边界
                    //移除之前的span ，添加新的span
                    sb.removeSpan(span);
                }
                if (startIndex > spanStart && endIndex >= spanEnd) {
                    //现有span的边界 后半部分被包含在新边界
                    // eg:现有span旧边界[1,4) 1,2,3 ，新边界[2,5) 2,3,4 。需要把旧边界改为[1,2) 1。
                    sb.removeSpan(span);
                    sb.setSpan(span, spanStart, startIndex, spanFlags);
                }
                if (startIndex <= spanStart && endIndex < spanEnd) {
                    //现有span的边界 前半部分被包含在新边界
                    // eg:现有span旧边界[2,5) 2,3,4，新边界[1,4) 1,2,3 。需要把旧边界改为[4,5) 4。
                    sb.removeSpan(span);
                    sb.setSpan(span, endIndex, spanEnd, spanFlags);
                }
            }
        }
    }
}
