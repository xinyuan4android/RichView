package com.pcitc.richtext.sample.function;

import android.content.Context;
import android.view.PointerIcon;
import android.view.View;

import com.pcitc.richtext.sample.R;
import com.pcitc.richtext.sample.dialog.ListPopupWindowAdapter;
import com.pcitc.richtext.sample.dialog.MyListPopupWindow;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xinyu
 * @des underLineSpan function
 * @time 2022/9/25 15:42
 */
public class UnderLineSpanFunction extends BaseSpanFunction implements MyListPopupWindow.MyOnItemClickListener {
    public UnderLineSpanFunction() {
        this(R.drawable.ic_launcher_background, R.string.function_menu_name_underLine);
    }

    public UnderLineSpanFunction(int iconResId, int titleResId) {
        super(iconResId, titleResId);
        dataSource.add(new ListPopupWindowAdapter.Bean("添加", ""));
        dataSource.add(new ListPopupWindowAdapter.Bean("移除", ""));
    }

    private MyListPopupWindow listPopupWindow;
    private List<ListPopupWindowAdapter.Bean> dataSource = new ArrayList<>();

    @Override
    void onClick(View view) {
        if (listPopupWindow == null) {
            listPopupWindow = new MyListPopupWindow(view.getContext(), view, this);
        }
        listPopupWindow.setDataSource(dataSource);
        listPopupWindow.show();
    }

    @Override
    public void onItemClickListener(MyListPopupWindow parent, View view, int position) {

    }
}
