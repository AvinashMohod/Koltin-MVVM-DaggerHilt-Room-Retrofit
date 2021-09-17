package com.app.koltinpoc.utils

sealed class DataHandler<T>(
    val data: T? = null,
    val message: String? = null
) {
    class SUCCESS<T>(data: T) : DataHandler<T>(data)
    class ERROR<T>(data: T? = null, message: String) : DataHandler<T>(data, message)
    class LOADING<T> : DataHandler<T>()

}
