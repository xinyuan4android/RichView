package com.pcitc.richtext.sample.function;

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

public class ClickableFunction extends BaseSpanFunction implements MyListPopupWindow.MyOnItemClickListener {
    private MyClickableSpan.OnClickableListener listener;

    public ClickableFunction(MyClickableSpan.OnClickableListener listener) {
        super(R.drawable.ic_launcher_background, R.string.function_menu_name_clickEvent);
        this.listener = listener;
        dataSourceMenuList.add(new ListPopupWindowAdapter.Bean("添加", ""));
        dataSourceMenuList.add(new ListPopupWindowAdapter.Bean("删除", ""));
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
                Utils.optimizeSpan(sb, startIndex, endIndex, MyClickableSpan.class);
                if (richView instanceof TextView) {
                    TextView tv = (TextView) richView;
                    String substring = tv.getText().toString().substring(startIndex, endIndex);
                    sb.setSpan(new MyClickableSpan(substring, listener), startIndex, endIndex, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
                }
            }
        } else if (TextUtils.equals(menuBean.getKey(), "删除")) {
            SpannableStringBuilder sb = Utils.checkSpannableStringBuilder(richView);
            if (sb != null) {
                Utils.optimizeSpan(sb, startIndex, endIndex, MyClickableSpan.class);
            }
        }
    }

}
