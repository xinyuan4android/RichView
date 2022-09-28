package com.pcitc.richtext.sample.function;

import android.view.View;

import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;

import com.pcitc.richtext.sample.dialog.ListPopupWindowAdapter;
import com.pcitc.richtext.sample.dialog.MyListPopupWindow;

import java.util.ArrayList;
import java.util.List;

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
    public final String TAG = getClass().getSimpleName();

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

    protected int startIndex;
    protected int endIndex;
    protected View richView;

    @Override
    public void onFunctionClick(View clickView, View richView, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            int temp = startIndex;
            startIndex = endIndex;
            endIndex = temp;
        }
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.richView = richView;
        onClick(clickView, richView, startIndex, endIndex);
    }

    private MyListPopupWindow listPopupWindow;
    protected final List<ListPopupWindowAdapter.Bean> dataSourceMenuList = new ArrayList<>();

    protected void showMenuListPopupWindow(View anchorView, MyListPopupWindow.MyOnItemClickListener itemClickListener) {
        if (listPopupWindow == null) {
            listPopupWindow = new MyListPopupWindow(anchorView.getContext(), anchorView, itemClickListener);
        }
        listPopupWindow.setDataSource(dataSourceMenuList);
        listPopupWindow.show();
    }

    abstract void onClick(View clickView, View richView, int startIndex, int endIndex);
}
