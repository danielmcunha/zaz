package com.danielcunha.zaz.data.remote

import com.danielcunha.zaz.data.remote.responses.BaseResponse

sealed class Result<out T, out E> {

    data class Success<out T>(val value: T) : Result<T, Nothing>()
    data class Failure<out E>(val error: E) : Result<Nothing, E>()

    fun <C> fold(success: (T) -> C, failure: (E) -> C, finally: (() -> Unit)? = null) {
        when (this) {
            is Success -> {
                success(value)
                finally?.invoke()
            }
            is Failure -> {
                failure(error)
                finally?.invoke()
            }
        }
    }

    fun takeSuccess(result: ((T) -> Unit)): Result<T, E> {
        return this.apply {
            if (this is Success) {
                result(value)
            }
        }
    }
}

suspend fun <T : BaseResponse> valid(block: suspend (() -> T)): T {
    val result = block()

    if (result.status != "01") {
        throw Exception(result.message)
    }

    return result
}

suspend fun <T : Any> safe(block: suspend (() -> T)): SimpleResult<T> {
    return try {
        Result.Success(block())
    } catch (e: Exception) {
        Result.Failure(e)
    }
}

typealias SimpleResult<T> = Result<T, Throwable>