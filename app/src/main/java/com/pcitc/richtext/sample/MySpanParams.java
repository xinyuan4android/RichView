package com.pcitc.richtext.sample;

import android.graphics.Typeface;

import androidx.annotation.ColorInt;

import com.pcitc.richtext.sample.span.MyAbsoluteSizeSpan;
import com.pcitc.richtext.sample.span.MyAddUnderLineSpan;
import com.pcitc.richtext.sample.span.MyBackgroundColorSpan;
import com.pcitc.richtext.sample.span.MyClickableSpan;
import com.pcitc.richtext.sample.span.MyDeleteUnderlineSpan;
import com.pcitc.richtext.sample.span.MyForegroundColorSpan;
import com.pcitc.richtext.sample.span.MyImageSpan;
import com.pcitc.richtext.sample.span.MyStyleSpan;

import java.util.ArrayList;
import java.util.List;

public class MySpanParams {
    private MySpanParamsOption option;
    private int startIndex;
    private int endIndex;
    private String string;
    private List<Object> mSpans = new ArrayList<>();

    private MySpanParams(MySpanParamsOption options) {
        this.option = options;
        initSpans();
    }

    public String getString() {
        return string;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public List<Object> getmSpans() {
        return mSpans;
    }

    private void initSpans() {
        startIndex = option.endIndex;
        endIndex = option.startIndex;
        string = option.text;
        if (option.textSize != null) {
            MyAbsoluteSizeSpan sizeSpan = new MyAbsoluteSizeSpan(option.textSize);
            mSpans.add(sizeSpan);
        }
        if (option.underLine != null) {
            if (option.underLine) {
                MyAddUnderLineSpan addUnderLineSpan = new MyAddUnderLineSpan();
                mSpans.add(addUnderLineSpan);
            } else {
                MyDeleteUnderlineSpan deleteUnderlineSpan = new MyDeleteUnderlineSpan();
                mSpans.add(deleteUnderlineSpan);
            }
        }
        if (option.bgColor != null) {
            MyBackgroundColorSpan backgroundColorSpan = new MyBackgroundColorSpan(option.bgColor);
            mSpans.add(backgroundColorSpan);
        }
        if (option.textColor != null) {
            MyForegroundColorSpan colorSpan = new MyForegroundColorSpan(option.textColor);
            mSpans.add(colorSpan);
        }
        if (option.clickable != null) {
            MyClickableSpan clickableSpan = new MyClickableSpan(option.clickTag, option.clickable,
                    option.clickableListener);
            mSpans.add(clickableSpan);
        }
        if (option.imageType != null) {
            int resourceId = MyImageSpan.imageTypeMaps.get(option.imageType);
            MyImageSpan imageSpan = new MyImageSpan(MyApp.getApp(), resourceId);
            mSpans.add(imageSpan);
        }
        if (option.isBold != null || option.isItalic != null) {
            int styleType;
            if (Boolean.TRUE.equals(option.isBold)
                    && Boolean.FALSE.equals(option.isItalic)) {
                styleType = Typeface.BOLD;
            } else if (Boolean.TRUE.equals(option.isItalic)
                    && Boolean.FALSE.equals(option.isBold)) {
                styleType = Typeface.ITALIC;
            } else if (Boolean.TRUE.equals(option.isItalic)
                    && Boolean.TRUE.equals(option.isBold)) {
                styleType = Typeface.BOLD_ITALIC;
            } else {
                styleType = Typeface.NORMAL;
            }
            MyStyleSpan colorSpan = new MyStyleSpan(styleType);
            mSpans.add(colorSpan);
        }


    }

    public static class Builder {
        private MySpanParamsOption options;

        public Builder(String text) {
            options = new MySpanParamsOption();
            options.text = text;
        }

        public Builder(int startIndex, int endIndex) {
            options = new MySpanParamsOption();
            options.startIndex = startIndex;
            options.endIndex = endIndex;
        }


        public Builder textSize(int textSize) {
            options.textSize = textSize;
            return this;
        }

        public Builder imageType(String imageType) {
            options.imageType = imageType;
            return this;
        }

        public Builder underLine(boolean underLine) {
            options.underLine = underLine;
            return this;
        }

        public Builder bgColor(@ColorInt int bgColor) {
            options.bgColor = bgColor;
            return this;
        }

        public Builder textColor(@ColorInt int textColor) {
            options.textColor = textColor;
            return this;
        }

        public Builder clickable(boolean clickable, String clickTag,
                                 MyClickableSpan.OnClickableListener clickableListener) {
            options.clickable = clickable;
            options.clickTag = clickTag;
            options.clickableListener = clickableListener;
            return this;
        }

        public Builder isBold(boolean isBold) {
            options.isBold = isBold;
            return this;
        }

        public Builder isItalic(boolean isItalic) {
            options.isItalic = isItalic;
            return this;
        }

        public MySpanParams build() {
            return new MySpanParams(options);
        }
    }
}
