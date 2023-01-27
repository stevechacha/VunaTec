package com.dev.chacha.vunatec.core.utils

class ApiException(
    val statusCode: Int = 0, val statusMessage: String
) : Throwable(statusMessage)