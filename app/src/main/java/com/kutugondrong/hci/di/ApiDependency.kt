package com.kutugondrong.hci.di

import com.kutugondrong.hci.network.Services
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {
    single(createdAtStart = false) { get<Retrofit>().create(Services::class.java) }
}