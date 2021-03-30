package com.kutugondrong.hci.di

import com.kutugondrong.hci.activity.main.MainRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { MainRepository(get()) }
}