package com.pcitc.richtext.sample;

import androidx.annotation.ColorInt;

import com.pcitc.richtext.sample.span.MyClickableSpan;

public class MySpanParamsOption {
    /**
     * 目标文本
     */
    public String text;
    /**
     * 开始索引
     */
    public int startIndex;
    /**
     * 结束索引
     */
    public int endIndex;
    /**
     * 字体大小 单位px
     */
    public Integer textSize;
    /**
     * 是否添加下划线
     */
    public Boolean underLine;
    /**
     * 背景颜色
     */
    public @ColorInt
    Integer bgColor;
    /**
     * 字体颜色
     */
    public @ColorInt
    Integer textColor;
    /**
     * 是否可以点击
     */
    public Boolean clickable;
    public String clickTag;
    public MyClickableSpan.OnClickableListener clickableListener;
    /**
     * 是否加粗字体
     */
    public Boolean isBold;
    /**
     * 是否是斜体
     */
    public Boolean isItalic;
}
