package com.twlk.nicedialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by xyb on 2017/9/5.
 */

public class BaseNiceDialog extends DialogFragment {

    private int mGravity = Gravity.CENTER;//对话框的位置
    private boolean mCanceledOnTouchOutside = true;//是否触摸外部关闭
    private boolean mCanceledBack = true;//是否返回键关闭
    private float mWidth = 0.9f;//对话框宽度，范围：0-1；1整屏宽
    private int[] mPadding;//对话框与屏幕边缘距离
    private int mAnimStyle;//显示动画
    private boolean isDimEnabled = true;
    protected int mBackgroundColor = Color.TRANSPARENT;//对话框的背景色
    protected float mAlpha = 1f;//对话框透明度，范围：0-1；1不透明
    private int mX, mY;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setStyle(DialogFragment.STYLE_NO_TITLE,0);
    }


    @Override
    public void onStart() {
        Dialog dialog = getDialog();
        if(dialog != null){
            dialog.setCanceledOnTouchOutside(mCanceledOnTouchOutside);
            dialog.setCancelable(mCanceledBack);
            setDialogGravity(dialog);
        }
        super.onStart();
    }

    private void setDialogGravity(Dialog dialog) {
        // 设置宽度为屏宽、靠近屏幕底部。
        Window window = dialog.getWindow();
        window.setBackgroundDrawableResource(android.R.color.transparent);
        WindowManager.LayoutParams wlp = window.getAttributes();
        DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);//获取屏幕宽
        wlp.width = dm.widthPixels;//宽度按屏幕大小的百分比设置
        wlp.gravity = mGravity;
        wlp.x = mX;
        wlp.y = mY;
        //边距
        if (mPadding != null) {
            wlp.width = WindowManager.LayoutParams.MATCH_PARENT;
            window.getDecorView().setPadding(30,30,30,30);
        }
        //动画
        if (mAnimStyle != 0) window.setWindowAnimations(mAnimStyle);

        if (isDimEnabled) window.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        else window.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        window.setAttributes(wlp);
    }

    public int getmGravity() {
        return mGravity;
    }

    public void setmGravity(int mGravity) {
        this.mGravity = mGravity;
    }

    public boolean ismCanceledOnTouchOutside() {
        return mCanceledOnTouchOutside;
    }

    public void setmCanceledOnTouchOutside(boolean mCanceledOnTouchOutside) {
        this.mCanceledOnTouchOutside = mCanceledOnTouchOutside;
    }

    public boolean ismCanceledBack() {
        return mCanceledBack;
    }

    public void setmCanceledBack(boolean mCanceledBack) {
        this.mCanceledBack = mCanceledBack;
    }

    public float getmWidth() {
        return mWidth;
    }

    public void setmWidth(float mWidth) {
        this.mWidth = mWidth;
    }

    public int[] getmPadding() {
        return mPadding;
    }

    public void setmPadding(int[] mPadding) {
        this.mPadding = mPadding;
    }

    public int getmAnimStyle() {
        return mAnimStyle;
    }

    public void setmAnimStyle(int mAnimStyle) {
        this.mAnimStyle = mAnimStyle;
    }

    public boolean isDimEnabled() {
        return isDimEnabled;
    }

    public void setDimEnabled(boolean dimEnabled) {
        isDimEnabled = dimEnabled;
    }

    public int getmBackgroundColor() {
        return mBackgroundColor;
    }

    public void setmBackgroundColor(int mBackgroundColor) {
        this.mBackgroundColor = mBackgroundColor;
    }

    public float getmAlpha() {
        return mAlpha;
    }

    public void setmAlpha(float mAlpha) {
        this.mAlpha = mAlpha;
    }

    public int getmX() {
        return mX;
    }

    public void setmX(int mX) {
        this.mX = mX;
    }

    public int getmY() {
        return mY;
    }

    public void setmY(int mY) {
        this.mY = mY;
    }
    @Override
    public void show(FragmentManager manager, String tag) {
        if (!isAdded()) {
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            transaction.add(this, tag);
            transaction.commitAllowingStateLoss();
        }
    }

    public void remove() {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.remove(this);
        ft.addToBackStack(null);
    }
}
