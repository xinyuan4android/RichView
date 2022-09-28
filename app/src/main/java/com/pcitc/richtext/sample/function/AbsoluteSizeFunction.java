package com.pcitc.richtext.sample.function;

import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.pcitc.richtext.sample.R;
import com.pcitc.richtext.sample.Utils;
import com.pcitc.richtext.sample.dialog.ListPopupWindowAdapter;
import com.pcitc.richtext.sample.dialog.MyListPopupWindow;
import com.pcitc.richtext.sample.span.MyAbsoluteSizeSpan;
import com.pcitc.richtext.sample.span.MyAddUnderLineSpan;

public class AbsoluteSizeFunction extends BaseSpanFunction implements MyListPopupWindow.MyOnItemClickListener {
    public AbsoluteSizeFunction() {
        super(R.drawable.ic_launcher_background, R.string.function_menu_name_textSize);

        dataSourceMenuList.add(new ListPopupWindowAdapter.Bean("15sp", "15"));
        dataSourceMenuList.add(new ListPopupWindowAdapter.Bean("16sp", "16"));
        dataSourceMenuList.add(new ListPopupWindowAdapter.Bean("17sp", "17"));
        dataSourceMenuList.add(new ListPopupWindowAdapter.Bean("18sp", "18"));
        dataSourceMenuList.add(new ListPopupWindowAdapter.Bean("19sp", "19"));
        dataSourceMenuList.add(new ListPopupWindowAdapter.Bean("20sp", "20"));
        dataSourceMenuList.add(new ListPopupWindowAdapter.Bean("21sp", "21"));
        dataSourceMenuList.add(new ListPopupWindowAdapter.Bean("22sp", "22"));
    }

    @Override
    public void onClick(View clickView, View richView, int startIndex, int endIndex) {
        showMenuListPopupWindow(clickView, this);
        Log.d(TAG, "onclick - start = " + startIndex + " end = " + endIndex);
    }

    @Override
    public void onItemClickListener(MyListPopupWindow parent, View view, int position) {
        ListPopupWindowAdapter.Bean bean = dataSourceMenuList.get(position);
        int sizeSp = Integer.parseInt(bean.getValue());
        int textSizePx = (int) (view.getContext().getResources().getDisplayMetrics().density * sizeSp + 0.5);
        SpannableStringBuilder sb = Utils.checkSpannableStringBuilder(richView);
        if (sb != null) {
            Utils.optimizeSpan(sb, startIndex, endIndex, MyAbsoluteSizeSpan.class);
            sb.setSpan(new MyAbsoluteSizeSpan(textSizePx), startIndex, endIndex, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        }
    }
}
