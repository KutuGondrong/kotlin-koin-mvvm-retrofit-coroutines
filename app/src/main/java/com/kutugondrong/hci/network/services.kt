package com.kutugondrong.hci.network

import com.kutugondrong.hci.model.Data
import retrofit2.http.GET
import retrofit2.http.Headers

interface Services {
    @Headers("Accept: application/json")
    @GET("home")
    suspend fun getData(): Data.DataResponse
}