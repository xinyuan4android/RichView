package com.pcitc.richtext.sample.function;

import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.view.View;

import com.pcitc.richtext.sample.R;
import com.pcitc.richtext.sample.Utils;
import com.pcitc.richtext.sample.dialog.ListPopupWindowAdapter;
import com.pcitc.richtext.sample.dialog.MyListPopupWindow;
import com.pcitc.richtext.sample.span.MyForegroundColorSpan;

public class ForegroundColorFunction extends BaseSpanFunction implements MyListPopupWindow.MyOnItemClickListener {

    public ForegroundColorFunction() {
        super(R.drawable.ic_launcher_background, R.string.function_menu_name_textColor);
        dataSourceMenuList.add(new ListPopupWindowAdapter.Bean("红色", "#FFFF0000"));
        dataSourceMenuList.add(new ListPopupWindowAdapter.Bean("绿色", "#FF0000FF"));
        dataSourceMenuList.add(new ListPopupWindowAdapter.Bean("蓝色", "#FF0000FF"));
        dataSourceMenuList.add(new ListPopupWindowAdapter.Bean("黄色", "#FFFFFF00"));
        dataSourceMenuList.add(new ListPopupWindowAdapter.Bean("紫色", "#FFFF00FF"));
        dataSourceMenuList.add(new ListPopupWindowAdapter.Bean("青色", "#FF00FFFF"));
    }


    @Override
    public void onClick(View clickView, View richView, int startIndex, int endIndex) {
        showMenuListPopupWindow(clickView, this);

    }

    @Override
    public void onItemClickListener(MyListPopupWindow parent, View view, int position) {
        ListPopupWindowAdapter.Bean bean = dataSourceMenuList.get(position);
        int colorInt = Color.parseColor(bean.getValue());
        SpannableStringBuilder sb = Utils.checkSpannableStringBuilder(richView);
        if (sb != null) {
            Utils.optimizeSpan(sb, startIndex, endIndex, MyForegroundColorSpan.class);
            sb.setSpan(new MyForegroundColorSpan(colorInt), startIndex, endIndex, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        }
    }
}
