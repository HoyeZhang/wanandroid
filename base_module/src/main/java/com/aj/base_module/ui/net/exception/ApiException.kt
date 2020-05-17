package com.aj.base_module.ui.net.exception

class ApiException(val errorCode: Int, val errorMessage: String) : RuntimeException(errorMessage)