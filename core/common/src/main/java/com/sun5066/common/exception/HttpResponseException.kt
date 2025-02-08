package com.sun5066.common.exception

import java.io.IOException

class HttpResponseException(val responseCode: Int, override val message: String?) : IOException(message)