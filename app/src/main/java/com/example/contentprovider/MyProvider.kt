package com.example.contentprovider

import android.content.ContentProvider
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.net.Uri

class MyProvider: ContentProvider() {
    //UriMatach类可以帮助我们匹配内容URI
    private val table1Dir=0
    private val table1Item=1
    private val table2Dir=2
    private val table2Item=3
    private val uriMatcher=UriMatcher(UriMatcher.NO_MATCH)
    //初始化
    init {
        uriMatcher.addURI("com.example.app.provider","table1",table1Dir)
        uriMatcher.addURI("com.example.app.provider","table1/#",table1Item)
        uriMatcher.addURI("com.example.app.provider","table2",table2Dir)
        uriMatcher.addURI("com.example.app.provider","table2/#",table2Item)
    }

    //1.初始化ContentProvider，数据库的创建和升级
    override fun onCreate(): Boolean {
        //true创建成功，false创建失败
        TODO("Not yet implemented")
    }

    override fun query(
        uri: Uri,  //确定哪张表
        projection: Array<out String>?,  //哪些列
        selection: String?,
        selectionArgs: Array<out String>?,
        sortOrder: String?  //对结果进行排序
    ): Cursor? {//返回一游标类，cursor.moveToNext遍历返回数据的每一行
        when(uriMatcher.match(uri)){
            table1Dir->{
                //查询table1表中的所有数据
            }
            table1Item->{
                //查询table1表中的单条数据
            }
            table2Dir->{
                //查询table2表中的所有数据
            }
            table2Item->{
                //查询table2表中的单条数据
            }
        }
        return null;//返回游标
    }
    //ContentProvider必须提供的一个方法，用于获取Uri对象的MIME类型
    override fun getType(uri: Uri): String? {
        //根据传入的URI返回相应的MINE类型
        //1.vnd开头：vnd.
        //2.以路径结尾，后接android.cursor.dir/  ：vnd.android.cursor.dir/
        //2.以id结尾，后接android.cursor.item/  : vnd.android.cursor.item/
        //3.最后接上vnd.<authority>.<path>     : vnd.android.cursor.dir/vnd.com.example.contentprovider.table1
        TODO("Not yet implemented")
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        TODO("Not yet implemented")
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?): Int {
        TODO("Not yet implemented")
    }

    override fun update(
        uri: Uri,
        values: ContentValues?,
        selection: String?,
        selectionArgs: Array<out String>?
    ): Int {
        TODO("Not yet implemented")
    }
}