package com.aj.base_module.net.exception

class ApiException(val errorCode: Int, val errorMessage: String) : RuntimeException(errorMessage)