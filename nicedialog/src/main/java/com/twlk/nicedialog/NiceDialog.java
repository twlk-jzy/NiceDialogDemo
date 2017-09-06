package com.twlk.nicedialog;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by xyb on 2017/9/6.
 */

public class NiceDialog extends BaseNiceDialog implements DialogInterface {

    private TextView tvTitle;
    private TextView tvContent;
    private Button btnCancel;
    private Button btnConfirm;

    private Handler handler = new Handler(Looper.getMainLooper());

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.dialog_confirm, null);
        tvTitle = view.findViewById(R.id.tv_title);
        tvContent = view.findViewById(R.id.tv_content);
        btnCancel = view.findViewById(R.id.btn_cancel);
        btnConfirm = view.findViewById(R.id.btn_confirm);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onBtnClickListener != null){
                    dismiss();
                    onBtnClickListener.cancelClick();
                }
            }
        });
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onBtnClickListener != null){
                    dismiss();
                    onBtnClickListener.confirmClick();
                }
            }
        });
        return new AlertDialog.Builder(getActivity()).setView(view)
                .create();
    }

    public NiceDialog setTitle(String title) {
        tvTitle.setText(title);
        return this;
    }

    public NiceDialog setContent(final String content) {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (tvContent != null) {
                    tvContent.setText(content);
                }
            }
        }, 100);

        return this;
    }

    public NiceDialog setCancelText(final String cancelText) {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (btnCancel != null) {
                    btnCancel.setText(cancelText);
                }
            }
        }, 100);

        return this;
    }

    public NiceDialog setConfirmText(final String confirmText) {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (btnConfirm != null) {
                    btnConfirm.setText(confirmText);
                }
            }
        }, 100);
        return this;
    }



    public NiceDialog setConfirmTextColor(final int confirmTextColor) {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (btnConfirm != null) {
                    btnConfirm.setTextColor(confirmTextColor);
                }
            }
        }, 100);

        return this;
    }

    public NiceDialog setCancelTextColor(final int cancelTextColor) {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (btnCancel != null) {
                    btnCancel.setTextColor(cancelTextColor);
                }
            }
        }, 100);

        return this;
    }

    public NiceDialog setConfirmTextSize(final int confirmTextSize) {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (btnConfirm != null) {
                    btnConfirm.setTextSize(confirmTextSize);
                }
            }
        }, 100);
        return this;
    }

    public NiceDialog setCancelTextSize(final int cancelTextSize) {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (btnCancel != null) {
                    btnCancel.setTextColor(cancelTextSize);
                }
            }
        }, 100);
        return this;
    }
    private OnBtnClickListener onBtnClickListener = null;

    public void setOnBtnClickListener(OnBtnClickListener onBtnClickListener) {
        this.onBtnClickListener = onBtnClickListener;
    }

    public interface OnBtnClickListener{
        void confirmClick();
        void cancelClick();
    }
}
