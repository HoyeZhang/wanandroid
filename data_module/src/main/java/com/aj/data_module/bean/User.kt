package com.aj.data_module.bean

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,

    @ColumnInfo(name = "user_name")
    var username: String? = null,

    @ColumnInfo(name = "pass_word")
    var password: String? = null
)