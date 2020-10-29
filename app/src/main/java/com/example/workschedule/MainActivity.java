package com.example.workschedule;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.style.TtsSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.workschedule.StudentInfo.Student;
import com.example.workschedule.StudentInfo.StudentDay;
import com.example.workschedule.StudentInfo.StudentTime;
import com.example.workschedule.ui.functional_zone;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.leon.lfilepickerlibrary.LFilePicker;
import com.leon.lfilepickerlibrary.utils.Constant;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

//import jxl.Workbook;

public class MainActivity extends AppCompatActivity {
    DataBaseHelper helper;//用来操作数据库对象进行读写

    private static final int REQUEST_CHOOSEFILE =901 ;
    private int mIconType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FloatingActionButton fab=findViewById(R.id.start);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, functional_zone.class);
                startActivity(intent);
            }
        });

        //创建或连接数据库，数据库名字为schedule.db3，游标工厂设置为null，采用默认的游标工厂，数据库当前版本为1，数据库保存的位置为默认的位置下
        helper = new DataBaseHelper(this,"schedule.db3",null,1);
        //接下来通过读取数据库里的内容对对象里的数据进行加载（待完成）
        //开启事务
        //读取操作
        //关闭事务

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        //此处用于关闭数据库的时候把对象组里的数据写回数据库（待完成）
        //开启事务
        //写入操作
        //关闭事务

        //关闭数据库
        if(helper != null){
            helper.close();
        }
    }

}


