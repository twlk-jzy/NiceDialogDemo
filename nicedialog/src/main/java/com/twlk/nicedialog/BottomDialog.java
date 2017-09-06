package com.twlk.nicedialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by xyb on 2017/9/5.
 */

public class BottomDialog extends BaseNicPPW {
    private TextView tvCancel;
    private ListView lvList;
    private String[] items;
    private BottomAdapter bottomAdapter;

    public BottomDialog(Context context) {
        super(context);
    }

    @Override
    public View initLayout() {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_bottom_dialog, null);
        view.findViewById(R.id.rl_top).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        lvList = view.findViewById(R.id.lv_list);
        tvCancel = view.findViewById(R.id.tv_cancel);
        return view;
    }

    @Override
    public void initData() {
        bottomAdapter = new BottomAdapter();
        lvList.setAdapter(bottomAdapter);
        initListener();
    }

    public void setItems(String[] items) {
        this.items = items;
        bottomAdapter.notifyDataSetChanged();
    }

    class BottomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            if (items != null) {
                return items.length;
            }
            return 0;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_bottom, viewGroup, false);
            TextView tvItem = view.findViewById(R.id.tv_item);
            tvItem.setText(items[i]);
            return view;
        }
    }

    private void initListener() {
        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        lvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (items == null || items.length == 0) {
                    return;
                }
                if (onItemClickListener != null) {
                    dismiss();
                    onItemClickListener.onItemClick(items[i], i);
                }
            }
        });
    }

    private OnItemClickListener onItemClickListener = null;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(String item, int position);
    }

}
