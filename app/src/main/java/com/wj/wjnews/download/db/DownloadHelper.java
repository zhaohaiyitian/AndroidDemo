package com.wj.wjnews.download.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

/**
 * Created by wj on 18-5-3.
 */

public class DownloadHelper {

    private static DownloadHelper sHelper = new DownloadHelper();
    private DaoMaster mMaster;
    private DaoSession mSession;
    private DownloadEntityDao mDao;


    private DownloadHelper() {
    }

    public static DownloadHelper getInstance() {
        return sHelper;
    }

    public void init(Context context) {
        SQLiteDatabase db = new DaoMaster.DevOpenHelper(context, "download.db", null).getWritableDatabase();
        mMaster=new DaoMaster(db);
        mSession=mMaster.newSession();
        mDao=mSession.getDownloadEntityDao();
    }

    public void insert(DownloadEntity entity) {
        mDao.insertOrReplace(entity);
    }

    public List<DownloadEntity> getAll(String url) {
        return mDao.queryBuilder()
                .where(DownloadEntityDao.Properties.Download_url.eq(url))
                .orderAsc(DownloadEntityDao.Properties.Thread_id).list();

    }
}
