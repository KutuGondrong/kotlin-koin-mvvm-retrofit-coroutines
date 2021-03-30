package com.kutugondrong.hci.activity.main

import androidx.lifecycle.*
import com.kutugondrong.hci.model.Data
import com.kutugondrong.hci.network.ProgressStatus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(private val repository: MainRepository) : ViewModel() {

    val progressLiveStatus = MutableLiveData<ProgressStatus>()

    fun getData () {
        viewModelScope.launch {
            progressLiveStatus.postValue(ProgressStatus.Loading)
            withContext(Dispatchers.IO) {
                try {
                    val result = repository.getData()
                    progressLiveStatus.postValue(ProgressStatus.Success<Data.DataResponse>(result))
                } catch (throwable: Throwable) {
                    progressLiveStatus.postValue(ProgressStatus.Error(throwable.message.toString()))
                }
            }
        }
    }

}