package com.twlk.nicedialog;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

/**
 * Created by xyb on 2017/9/5.
 */

public abstract class BaseNicPPW extends PopupWindow {
    protected Context context;

    public abstract View initLayout();

    public abstract void initData();

    public BaseNicPPW(Context context) {
        this(context, null);
    }

    public BaseNicPPW(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BaseNicPPW(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        setPopupWindow();
        initData();
    }

    private void setPopupWindow() {
        this.setContentView(initLayout());
        this.setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
        this.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
        this.setFocusable(true);
        this.setOutsideTouchable(true);
        this.setAnimationStyle(R.style.mypopwindow_anim_style);// 设置动画
        //实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0xb0000000);
        dw.setAlpha(155);
        //设置SelectPicPopupWindow弹出窗体的背景
        this.setBackgroundDrawable(dw);
    }
}
