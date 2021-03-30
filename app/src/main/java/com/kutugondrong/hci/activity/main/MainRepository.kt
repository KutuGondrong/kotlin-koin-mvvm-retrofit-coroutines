package com.kutugondrong.hci.activity.main
import com.kutugondrong.hci.network.Services

class MainRepository(private val services: Services){
    suspend fun getData() = services.getData()
}