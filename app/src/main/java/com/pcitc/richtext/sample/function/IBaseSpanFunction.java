package com.pcitc.richtext.sample.function;

import android.view.View;

/**
 * @author xinyu
 * @des base span function interface
 * @time 2022/9/25 15:44
 */
public interface IBaseSpanFunction {
    void onFunctionClick(View clickView, View richView, int startIndex, int endIndex);
}
