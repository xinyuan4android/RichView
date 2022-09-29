package com.pcitc.richtext.sample.function;

import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.pcitc.richtext.sample.R;
import com.pcitc.richtext.sample.Utils;
import com.pcitc.richtext.sample.dialog.ListPopupWindowAdapter;
import com.pcitc.richtext.sample.dialog.MyListPopupWindow;
import com.pcitc.richtext.sample.span.MyClickableSpan;
import com.pcitc.richtext.sample.span.MyStyleSpan;

public class StyleSpanFunction extends BaseSpanFunction implements MyListPopupWindow.MyOnItemClickListener {

    public StyleSpanFunction() {
        super(R.mipmap.ic_launcher, R.string.function_menu_name_textStyle);
        dataSourceMenuList.add(new ListPopupWindowAdapter.Bean("粗体", ""));
        dataSourceMenuList.add(new ListPopupWindowAdapter.Bean("斜体", ""));
        dataSourceMenuList.add(new ListPopupWindowAdapter.Bean("粗斜体", ""));
        dataSourceMenuList.add(new ListPopupWindowAdapter.Bean("正常", ""));
    }

    @Override
    void onClick(View clickView, View richView, int startIndex, int endIndex) {
        showMenuListPopupWindow(clickView, this);
    }

    @Override
    public void onItemClickListener(MyListPopupWindow parent, View view, int position) {
        ListPopupWindowAdapter.Bean menuBean = dataSourceMenuList.get(position);
        int styleType;
        if (TextUtils.equals(menuBean.getKey(), "粗体")) {
            styleType = Typeface.BOLD;
        } else if (TextUtils.equals(menuBean.getKey(), "斜体")) {
            styleType = Typeface.ITALIC;
        } else if (TextUtils.equals(menuBean.getKey(), "粗斜体")) {
            styleType = Typeface.BOLD_ITALIC;
        } else {
            styleType = Typeface.NORMAL;
        }
        SpannableStringBuilder sb = Utils.checkSpannableStringBuilder(richView);
        if (sb != null) {
            Utils.optimizeSpan(sb, startIndex, endIndex, MyStyleSpan.class);
            sb.setSpan(new MyStyleSpan(styleType), startIndex, endIndex, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        }
    }
}
