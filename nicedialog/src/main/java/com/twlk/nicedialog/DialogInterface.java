package com.twlk.nicedialog;

/**
 * Created by xyb on 2017/9/5.
 */

public interface DialogInterface {
    interface setOnItemClicklistener {
        void onItemClick(String item);
    }
    interface setCancelClickListener{
        void onClick();
    }
}
