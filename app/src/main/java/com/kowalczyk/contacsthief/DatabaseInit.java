package com.kowalczyk.contacsthief;

import android.app.Application;
import com.kowalczyk.contacsthief.model.DaoMaster;
import com.kowalczyk.contacsthief.model.DaoSession;
import org.greenrobot.greendao.database.Database;

/**
 * Created by JKowalczyk on 2017-12-14.
 */
public class DatabaseInit extends Application {



    private static final String DB_SECRET = "123";
    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "secret0.db");
        Database db = devOpenHelper.getEncryptedWritableDb(DB_SECRET);
        daoSession = new DaoMaster(db).newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
