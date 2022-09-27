package com.pcitc.richtext.sample.function;

import android.view.View;

import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;

/**
 * @author xinyu
 * @des base span function 基类
 * @time 2022/9/25 15:43
 */
public abstract class BaseSpanFunction implements IBaseSpanFunction {
    private @DrawableRes
    int iconResId;
    private @StringRes
    int titleResId;

    public BaseSpanFunction(int iconResId, int titleResId) {
        this.iconResId = iconResId;
        this.titleResId = titleResId;
    }

    public int getIconResId() {
        return iconResId;
    }

    public int getTitleResId() {
        return titleResId;
    }

    @Override
    public void onFunctionClick(View view) {
        onClick(view);
    }

    abstract void onClick(View view);
}
