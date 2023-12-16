package com.maxbay.githubuserscompose.data

fun isDifferenceMoreThanHour(startTime: Long, endTime: Long): Boolean {
    return if (endTime > ZERO_LONG_VALUE) {
        val diffMilliSeconds = endTime - startTime
        val diffMinutes = diffMilliSeconds / MILLISECOND_IN_HOURS_COEFF
        diffMinutes >= ONE_HOUR_LONG_VALUE
    }else {
        true
    }
}