package com.twlk.nicedialogdemo;

import android.annotation.SuppressLint;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.twlk.nicedialog.BottomDialog;

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
    }
}
