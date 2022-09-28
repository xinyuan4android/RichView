package com.pcitc.richtext.sample.function;

import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;

import com.pcitc.richtext.sample.R;
import com.pcitc.richtext.sample.Utils;
import com.pcitc.richtext.sample.dialog.ListPopupWindowAdapter;
import com.pcitc.richtext.sample.dialog.MyListPopupWindow;
import com.pcitc.richtext.sample.span.MyAddUnderLineSpan;
import com.pcitc.richtext.sample.span.MyDeleteUnderlineSpan;

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
        dataSourceMenuList.add(new ListPopupWindowAdapter.Bean("添加", ""));
        dataSourceMenuList.add(new ListPopupWindowAdapter.Bean("移除", ""));
    }

    @Override
    void onClick(View clickView, View richView, int startIndex, int endIndex) {
        showMenuListPopupWindow(clickView, this);
    }

    @Override
    public void onItemClickListener(MyListPopupWindow parent, View view, int position) {
        ListPopupWindowAdapter.Bean menuBean = dataSourceMenuList.get(position);
        if (TextUtils.equals(menuBean.getKey(), "添加")) {
            SpannableStringBuilder sb = Utils.checkSpannableStringBuilder(richView);
            if (sb != null) {
                Utils.optimizeSpan(sb, startIndex, endIndex, MyAddUnderLineSpan.class);
                sb.setSpan(new MyAddUnderLineSpan(), startIndex, endIndex, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
            }
        } else if (TextUtils.equals(menuBean.getKey(), "移除")) {
            SpannableStringBuilder sb = Utils.checkSpannableStringBuilder(richView);
            if (sb != null) {
                Utils.optimizeSpan(sb, startIndex, endIndex, MyDeleteUnderlineSpan.class);
                sb.setSpan(new MyAddUnderLineSpan(), startIndex, endIndex, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
            }
        }
    }
}
