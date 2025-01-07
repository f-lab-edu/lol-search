package com.sun5066.config.exception

import java.io.IOException

class ApiException(val responseCode: Int, override val message: String?) : IOException(message)