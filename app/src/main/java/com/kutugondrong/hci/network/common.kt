package com.kutugondrong.hci.network

sealed class ProgressStatus {
    object Loading : ProgressStatus()
    class Success<T>(val data: T) : ProgressStatus()
    class Error(val errorMessage: String) : ProgressStatus()
}