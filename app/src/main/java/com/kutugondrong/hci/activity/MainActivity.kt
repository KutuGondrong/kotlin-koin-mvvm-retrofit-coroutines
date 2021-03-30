package com.kutugondrong.hci.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.kutugondrong.hci.R
import com.kutugondrong.hci.activity.main.MainViewModel
import com.kutugondrong.hci.adapter.MainAdapter
import com.kutugondrong.hci.model.Data
import com.kutugondrong.hci.network.ProgressStatus
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val homeViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        homeViewModel.getData()
        homeViewModel.progressLiveStatus.observe(this, Observer {
            when (it) {
                is ProgressStatus.Loading -> displayLoading()
                is ProgressStatus.Success<*> -> displayData(it.data as Data.DataResponse)
                is ProgressStatus.Error -> displayError(it.errorMessage)
            }
        })
    }

    private fun displayError(errorMessage: String) {
        rv_data.visibility = View.VISIBLE
        shimmerLayout.visibility = View.GONE
    }

    private fun displayData(data: Data.DataResponse) {
        rv_data.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = MainAdapter(data, this@MainActivity)
        }
        rv_data.visibility = View.VISIBLE
        shimmerLayout.visibility = View.GONE
    }


    private fun displayLoading() {
        shimmerLayout.visibility = View.VISIBLE
        rv_data.visibility = View.GONE
    }
}