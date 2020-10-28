package com.tistory.jeongs0222.thingsflow.util

import androidx.lifecycle.LiveData

fun <T : Any> LiveData<T>.requireValue() = requireNotNull(value)
