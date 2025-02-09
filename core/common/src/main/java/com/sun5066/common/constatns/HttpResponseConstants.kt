package com.sun5066.common.constatns

import androidx.annotation.IntDef

@Target(AnnotationTarget.TYPE, AnnotationTarget.VALUE_PARAMETER)
@IntDef(
    value = [
        HttpResponseConstants.RESPONSE_CODE_400_BAD_REQUEST,
        HttpResponseConstants.RESPONSE_CODE_401_UNAUTHORIZED,
        HttpResponseConstants.RESPONSE_CODE_403_FORBIDDEN,
        HttpResponseConstants.RESPONSE_CODE_404_NOT_FOUND,
        HttpResponseConstants.RESPONSE_CODE_429_RATE_LIMIT_EXCEEDED,
        HttpResponseConstants.RESPONSE_CODE_500_INTERNAL_SERVER_ERROR,
        HttpResponseConstants.RESPONSE_CODE_503_SERVICE_UNAVAILABLE,
    ]
)
annotation class HttpResponseCode

object HttpResponseConstants {
    const val RESPONSE_CODE_400_BAD_REQUEST = 400
    const val RESPONSE_CODE_401_UNAUTHORIZED = 401
    const val RESPONSE_CODE_403_FORBIDDEN = 403
    const val RESPONSE_CODE_404_NOT_FOUND = 404
    const val RESPONSE_CODE_429_RATE_LIMIT_EXCEEDED = 429
    const val RESPONSE_CODE_500_INTERNAL_SERVER_ERROR = 500
    const val RESPONSE_CODE_503_SERVICE_UNAVAILABLE = 503
}