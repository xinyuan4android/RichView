package com.pcitc.richtext.sample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

/**
 * {@docRoot}
 */
public class MainActivity extends AppCompatActivity implements MyFunctionListAdapter.MyOnItemClickListener {
    private RecyclerView recyclerView;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        editText = findViewById(R.id.editText);
        initRecyclerView();
        initData();
    }

    private void initData() {
        dataSource.add("字体大小");
        dataSource.add("字体颜色");
        dataSource.add("下划线");
        adapter.notifyDataSetChanged();
    }

    private MyFunctionListAdapter adapter;
    private List<String> dataSource = new ArrayList<>();

    private void initRecyclerView() {
        recyclerView.setLayoutManager(new GridLayoutManager(this, 5));
        adapter = new MyFunctionListAdapter(dataSource, this);
        recyclerView.setAdapter(adapter);
        SpannableStringBuilder sb = new SpannableStringBuilder();
        sb.append("");
        editText.setText(sb);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SpannableStringBuilder sb = (SpannableStringBuilder) editText.getText();
        UnderlineSpan[] spans = sb.getSpans(2, 2, UnderlineSpan.class);
    }

    @Override
    public void onFunctionItemClick(View view, int position) {
        UnderlineSpan underlineSpan = new UnderlineSpan();
        SpannableStringBuilder sb = (SpannableStringBuilder) editText.getText();
        sb.setSpan(underlineSpan, 2, 2, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        editText.setText(sb);
        editText.setSelection(2);
    }
}