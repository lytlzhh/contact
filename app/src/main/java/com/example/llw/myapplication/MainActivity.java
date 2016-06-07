package com.example.llw.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnStart;

    private void assignViews() {
        btnStart = (Button) findViewById(R.id.btn_start);
        btnStart.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        assignViews();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start:
                fun();
                break;
        }
    }


    public void fun() {
        /*思路：想要删除联系人中的信息，首先要找到存储联系人的表(问题：要通过什么来找到表Cursor)，
        * 2，我们得到的游标的位置是在表的最初始位置的(问题：如何得到下一行的地址)*//*
        //删除所有的联系人
        ContentResolver contentResolver = getContentResolver();

        //首先要知道联系人的表的最开始游标
        Cursor c1 = contentResolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
        if (c1 != null) {
            while (c1.moveToNext()) {//通过游标对联系人表依次逐行移动
                //这里的rows可以理解为偏移地址
                String rows = c1.getString(c1.getColumnIndex(ContactsContract.Contacts._ID));
                //这里的uri理解为基址+偏移地址——>找到了具体的行地址
                Uri uri = Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_URI, rows);
                // Uri uri = ContactsContract.Contacts.CONTENT_URI;
                contentResolver.delete(uri, null, null);
            }
        }*/


    }
}
