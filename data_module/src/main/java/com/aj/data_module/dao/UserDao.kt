package com.aj.data_module.dao

import androidx.room.*
import com.aj.data_module.bean.User

@Dao
interface  UserDao {

    @Query("SELECT * FROM users WHERE id IN (:userIds)")
    fun loadAllByIds(userIds: IntArray?): List<User?>?

    @Query("select * from users")
    fun queryAll(): List<User?>?

    @Query("select * from users where isLogin=1")
    fun queryLoginUser(): User?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(vararg users: User?)

    @Delete
    fun delete(user: User?)

    @Query("update  users set isLogin = 0 where isLogin=1")
    fun updateAllNoLogin()

}