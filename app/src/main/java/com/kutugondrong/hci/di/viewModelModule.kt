package com.kutugondrong.hci.di

import com.kutugondrong.hci.activity.main.MainViewModel
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}

