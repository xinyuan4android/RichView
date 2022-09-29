package com.pcitc.richtext.sample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.pcitc.richtext.sample.function.AbsoluteSizeFunction;
import com.pcitc.richtext.sample.function.BackgroundColorFunction;
import com.pcitc.richtext.sample.function.BaseSpanFunction;
import com.pcitc.richtext.sample.function.ClickableFunction;
import com.pcitc.richtext.sample.function.ForegroundColorFunction;
import com.pcitc.richtext.sample.function.ImageFunction;
import com.pcitc.richtext.sample.function.StyleSpanFunction;
import com.pcitc.richtext.sample.function.UnderLineSpanFunction;
import com.pcitc.richtext.sample.span.MyClickableSpan;

import java.util.ArrayList;
import java.util.List;

/**
 * {@docRoot}
 */
public class MainActivity extends AppCompatActivity implements MyFunctionListAdapter.MyOnItemClickListener, MyClickableSpan.OnClickableListener {
    private RecyclerView recyclerView;
    private EditText editText;
    private TextView tvShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        editText = findViewById(R.id.editText);
        tvShow = findViewById(R.id.tvShow);
        initRecyclerView();
        initData();
        editText.setMovementMethod(LinkMovementMethod.getInstance());
        tvShow.setMovementMethod(LinkMovementMethod.getInstance());
        aboutRichTextView();
    }

    private void aboutRichTextView() {
        MyRichViewHelper.with(this)
                .addParams(new MySpanParams.Builder("hxy")
                        .textSize(40)
                        .textColor(0xFFFF00FF)
                        .isBold(true)
                        .build())
                .addParams(new MySpanParams.Builder("18311112222")
                        .textSize(40)
                        .textColor(0xFF0000FF)
                        .clickable(true, "18311112222", this)
                        .build())
                .into(tvShow);
    }

    private void initData() {
        dataSource.add(new UnderLineSpanFunction());
        dataSource.add(new AbsoluteSizeFunction());
        dataSource.add(new StyleSpanFunction());
        dataSource.add(new ForegroundColorFunction());
        dataSource.add(new BackgroundColorFunction());
        dataSource.add(new ClickableFunction(this));
        dataSource.add(new ImageFunction());
        adapter.notifyDataSetChanged();
    }

    private MyFunctionListAdapter adapter;
    private List<BaseSpanFunction> dataSource = new ArrayList<>();

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
        int selectionStart = editText.getSelectionStart();
        int selectionEnd = editText.getSelectionEnd();
        dataSource.get(position).onFunctionClick(view, editText, selectionStart, selectionEnd);
        editText.setSelection(selectionEnd);
    }

    @Override
    public void onClickableViewClick(View view, String clickString) {
        Toast.makeText(this, "clickString : " + clickString, Toast.LENGTH_SHORT).show();
    }
}