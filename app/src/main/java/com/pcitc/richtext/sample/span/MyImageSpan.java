package com.pcitc.richtext.sample.span;

import android.content.Context;
import android.text.style.ImageSpan;

import androidx.annotation.NonNull;

import com.pcitc.richtext.sample.R;

import java.util.HashMap;

public class MyImageSpan extends ImageSpan {


    public MyImageSpan(@NonNull Context context, int resourceId) {
        this(context, resourceId, ALIGN_BASELINE);
    }

    public MyImageSpan(@NonNull Context context, int resourceId, int verticalAlignment) {
        super(context, resourceId, verticalAlignment);
    }

    /**
     * 图片类型
     */
    public static String TYPE_IMAGE_NEW = "[new]";
    public static String TYPE_IMAGE_LOGO = "[logo]";
    public static HashMap<String, Integer> imageTypeMaps = new HashMap<>();

    static {
        imageTypeMaps.put(TYPE_IMAGE_NEW, R.drawable.icon_tag_new);
        imageTypeMaps.put(TYPE_IMAGE_LOGO, R.mipmap.ic_launcher);
    }

}
