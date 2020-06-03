package com.aj.data_module.dao

import android.util.Log
import androidx.room.*
import com.aj.data_module.bean.User

@Dao
interface  UserDao {
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insertAll(list: MutableList<User>)
//
//    @Delete
//    fun delete(element: User)
//
//    @Delete
//    fun deleteList(elements:MutableList<User>)
//
//    @Delete
//    fun deleteSome(vararg elements:User)
//
//    @Update
//    fun update(element: User)


    @Query("SELECT * FROM users")
    fun getAll(): List<User?>?

    @Query("SELECT * FROM users WHERE id IN (:userIds)")
    fun loadAllByIds(userIds: IntArray?): List<User?>?

//    @Query(
//        "SELECT * FROM user WHERE first_name LIKE :first AND "
//                + "last_name LIKE :last LIMIT 1"
//    )
//    fun findByName(first: String?, last: String?): User?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg users: User?)

    @Delete
    fun delete(user: User?)

}