package com.aj.user_module.ui.login


import com.aj.base_module.net.BaseRepository
import com.aj.base_module.net.RetrofitManager
import com.aj.user_module.apis.WanAndroidApis
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LoginRepository : BaseRepository() {
    suspend fun login(username: String, password: String) = withContext(Dispatchers.IO) {
        val params = hashMapOf<String, String>()
        params["username"] = username
        params["password"] = password
        RetrofitManager.create(WanAndroidApis::class.java).login(params).await()
    }
}