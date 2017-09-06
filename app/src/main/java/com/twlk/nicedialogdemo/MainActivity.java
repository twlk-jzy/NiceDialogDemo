package com.twlk.nicedialogdemo;

import android.annotation.SuppressLint;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.twlk.nicedialog.BottomDialog;
import com.twlk.nicedialog.NiceDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.tv_bottom_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomDialog bottomDialog = new BottomDialog(MainActivity.this);
                bottomDialog.setItems(new String[]{"相机","相册"});
                bottomDialog.showAtLocation(view, Gravity.BOTTOM,0,0);
                bottomDialog.setOnItemClickListener(new BottomDialog.OnItemClickListener() {
                    @Override
                    public void onItemClick(String item, int position) {
                        Toast.makeText(MainActivity.this,item,Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        findViewById(R.id.btn_confirm_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NiceDialog dialog = new NiceDialog();
                dialog.setContent("的都是发顺丰").show(getSupportFragmentManager(),"dialgo");
                dialog.setOnBtnClickListener(new NiceDialog.OnBtnClickListener() {
                    @Override
                    public void confirmClick() {
                        Toast.makeText(MainActivity.this,"确定",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void cancelClick() {
                        Toast.makeText(MainActivity.this,"取消",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
