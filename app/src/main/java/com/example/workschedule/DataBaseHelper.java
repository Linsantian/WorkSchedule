package com.example.workschedule;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {

    //初始创建保存最后结果的room_result表 组成的元素为
    //地方place 开始时begin_hour 开始分begin_min 结束时end_hour 结束分end_min,该时间段下所有被安排的人，人名之间用#分割
    private String create_room_result = "create table room_result(place varchar," +
            "begin_hour integer,begin_min integer,end_hour integer,end_min integer,persons varchar)";


    //构造函数，其中name为数据库的名字，factory为游标工厂（一般为空），version为数据库版本号，用以数据库后续更新或者添加列
    public DataBaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(create_room_result);
        Log.d("DATABASE","创建了room_result表");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.d("DATABASE","数据库版本更新，添加了列");
    }
}
