package com.pcitc.richtext.sample.function;

import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;

import com.pcitc.richtext.sample.R;
import com.pcitc.richtext.sample.Utils;
import com.pcitc.richtext.sample.dialog.ListPopupWindowAdapter;
import com.pcitc.richtext.sample.dialog.MyListPopupWindow;
import com.pcitc.richtext.sample.span.MyImageSpan;

public class ImageFunction extends BaseSpanFunction implements MyListPopupWindow.MyOnItemClickListener {

    public ImageFunction() {
        super(R.mipmap.ic_launcher, R.string.function_menu_name_image);
        for (String key : MyImageSpan.imageTypeMaps.keySet()) {
            dataSourceMenuList.add(new ListPopupWindowAdapter.Bean(key, String.valueOf(MyImageSpan.imageTypeMaps.get(key))));
        }
    }

    @Override
    void onClick(View clickView, View richView, int startIndex, int endIndex) {
        showMenuListPopupWindow(clickView, this);
    }

    @Override
    public void onItemClickListener(MyListPopupWindow parent, View view, int position) {
        ListPopupWindowAdapter.Bean itemBean = dataSourceMenuList.get(position);
        String key = itemBean.getKey();
        int iconResourceId = Integer.parseInt(itemBean.getValue());
        SpannableStringBuilder sb = Utils.checkSpannableStringBuilder(richView);
        if (sb != null) {
            sb.delete(startIndex, endIndex);
            sb.insert(startIndex, key);
            sb.setSpan(new MyImageSpan(view.getContext(), iconResourceId),
                    startIndex, startIndex + key.length(), SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
            if (richView instanceof EditText) {
                EditText et = (EditText) richView;
                et.setSelection(startIndex + key.length());
            }
        }
        parent.show();
    }
}
