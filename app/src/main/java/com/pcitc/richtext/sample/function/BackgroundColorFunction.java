package com.pcitc.richtext.sample.function;

import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.view.View;

import com.pcitc.richtext.sample.R;
import com.pcitc.richtext.sample.Utils;
import com.pcitc.richtext.sample.dialog.ListPopupWindowAdapter;
import com.pcitc.richtext.sample.dialog.MyListPopupWindow;
import com.pcitc.richtext.sample.span.MyBackgroundColorSpan;

public class BackgroundColorFunction extends BaseSpanFunction implements MyListPopupWindow.MyOnItemClickListener {

    public BackgroundColorFunction() {
        super(R.drawable.ic_launcher_background, R.string.function_menu_name_bgColor);
        dataSourceMenuList.add(new ListPopupWindowAdapter.Bean("红色", "0xFFFF0000"));
        dataSourceMenuList.add(new ListPopupWindowAdapter.Bean("绿色", "0xFF0000FF"));
        dataSourceMenuList.add(new ListPopupWindowAdapter.Bean("蓝色", "0xFF0000FF"));
        dataSourceMenuList.add(new ListPopupWindowAdapter.Bean("黄色", "0xFFFFFF00"));
        dataSourceMenuList.add(new ListPopupWindowAdapter.Bean("紫色", "0xFFFF00FF"));
        dataSourceMenuList.add(new ListPopupWindowAdapter.Bean("青色", "0xFF00FFFF"));

    }

    @Override
    void onClick(View clickView, View richView, int startIndex, int endIndex) {
        showMenuListPopupWindow(clickView, this);
    }

    @Override
    public void onItemClickListener(MyListPopupWindow parent, View view, int position) {
        ListPopupWindowAdapter.Bean bean = dataSourceMenuList.get(position);
        int colorInt = Integer.parseInt(bean.getValue());
        SpannableStringBuilder sb = Utils.checkSpannableStringBuilder(richView);
        if (sb != null) {
            Utils.optimizeSpan(sb, startIndex, endIndex, MyBackgroundColorSpan.class);
            sb.setSpan(new MyBackgroundColorSpan(colorInt), startIndex, endIndex, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        }
    }
}
