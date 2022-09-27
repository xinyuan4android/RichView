package com.pcitc.richtext.sample.dialog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.pcitc.richtext.sample.R;

import java.io.Serializable;
import java.util.List;

/**
 * @author xinyu
 * @des list popup window adapter
 * @time 2022/9/25 16:32
 */
public class ListPopupWindowAdapter extends BaseAdapter {
    private List<Bean> dataSource;

    public ListPopupWindowAdapter(List<Bean> dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public int getCount() {
        if (dataSource != null) {
            return dataSource.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        ViewHolder holder = null;
        if (convertView == null) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_popup_window_list, null);
            holder = new ViewHolder();
            holder.textView = view.findViewById(R.id.textView);
            view.setTag(holder);
        } else {
            view = convertView;
            holder = (ViewHolder) view.getTag();
        }
        Bean itemBean = dataSource.get(position);
        holder.textView.setText(itemBean.getKey());
        return view;
    }

    public static class ViewHolder {
        TextView textView;
    }

    public static class Bean implements Serializable {
        private String key;
        private String value;

        public Bean() {
        }

        public Bean(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
