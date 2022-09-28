package com.pcitc.richtext.sample.dialog;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListPopupWindow;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xinyu
 * @des list popup window
 * @time 2022/9/25 16:28
 */
public class MyListPopupWindow implements AdapterView.OnItemClickListener {
    private ListPopupWindow listPopupWindow;
    private Context context;
    private View anchorView;
    private MyOnItemClickListener itemClickListener;

    public MyListPopupWindow(Context context, View anchorView, MyOnItemClickListener itemClickListener) {
        this.context = context;
        this.anchorView = anchorView;
        this.itemClickListener = itemClickListener;
        initListPopupWindow();
    }

    private ListPopupWindowAdapter adapter;
    private List<ListPopupWindowAdapter.Bean> dataSource = new ArrayList<>();

    private void initListPopupWindow() {
        if (listPopupWindow == null) {
            listPopupWindow = new ListPopupWindow(context);
            adapter = new ListPopupWindowAdapter(dataSource);
            listPopupWindow.setAdapter(adapter);
            listPopupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
            listPopupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
            listPopupWindow.setModal(true);
            listPopupWindow.setAnchorView(anchorView);
            listPopupWindow.setOnItemClickListener(this);
        }
    }

    public void setDataSource(List<ListPopupWindowAdapter.Bean> dataSource) {
        this.dataSource.clear();
        if (dataSource != null) {
            this.dataSource.addAll(dataSource);
        }
        adapter.notifyDataSetChanged();
    }

    public void show() {
        listPopupWindow.show();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (itemClickListener != null) {
            itemClickListener.onItemClickListener(this, view, position);
        }
    }


    public interface MyOnItemClickListener {
        void onItemClickListener(MyListPopupWindow parent, View view, int position);
    }
}
