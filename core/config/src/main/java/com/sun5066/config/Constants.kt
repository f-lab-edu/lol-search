package com.sun5066.config

object Constants {
    const val TIME_OUT = 30L
    const val INJECT_NAMED_KOTLINX_SERIALIZATION = "kotlinx"

    const val RESPONSE_CODE_BAD_REQUEST = 400
    const val RESPONSE_CODE_UNAUTHORIZED = 401
    const val RESPONSE_CODE_FORBIDDEN = 403
    const val RESPONSE_CODE_NOT_FOUND = 404
    const val RESPONSE_CODE_UNSUPPORTED_MEDIA_TYPE = 415
    const val RESPONSE_CODE_RATE_LIMIT_EXCEEDED = 429
    const val RESPONSE_CODE_INTERNAL_SERVER_ERROR = 500
    const val RESPONSE_CODE_SERVICE_UNAVAILABLE = 503

    const val INJECT_NAMED_RIOT_TOKEN = "riot_token"

    const val MVI_VIEW_MODEL_STATE_KEY = "mvi_state"
}