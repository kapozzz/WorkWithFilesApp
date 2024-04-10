package com.kapozzz.workwithfiles

interface Сonvertible<T> {

    fun toByteArray(): ByteArray

    fun fromByteArray(): T

}