package com.aj.data_module.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.aj.data_module.AppContext

import com.aj.data_module.bean.User
import com.aj.data_module.dao.UserDao


@Database(entities = [User::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun userDao(): UserDao?
    companion object {
        @Volatile
        private var instance: AppDataBase? = null

        fun getDBInstance(): AppDataBase {
            if (instance == null) {
                synchronized(AppDataBase::class) {
                    if (instance == null) {
                        instance = Room.databaseBuilder(
                            AppContext.context,
                            AppDataBase::class.java,
                            "User.db"
                        )
                            .allowMainThreadQueries()
                            .build()
                    }
                }
            }
            return instance!!
        }
    }
}