package com.sun5066.rest_api.util

import java.util.concurrent.TimeUnit

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class Cacheable(val value: Int, val timeUnit: TimeUnit)