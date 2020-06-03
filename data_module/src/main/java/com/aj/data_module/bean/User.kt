package com.aj.data_module.bean

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey




@Entity(tableName = "users")
data class User (
   @PrimaryKey
   var id: Int?,

   @ColumnInfo(name = "user_name")
    var username :String


)