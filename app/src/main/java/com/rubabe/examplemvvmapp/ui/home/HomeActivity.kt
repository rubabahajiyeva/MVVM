package com.rubabe.examplemvvmapp.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.core.os.HandlerCompat
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.rubabe.examplemvvmapp.R
import com.rubabe.examplemvvmapp.data.response.MovieItem
import com.rubabe.examplemvvmapp.databinding.ActivityHomeBinding
import com.rubabe.examplemvvmapp.utils.ResponseResult
import com.rubabe.examplemvvmapp.utils.ResponseResult.Success
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.concurrent.Executors
import java.util.concurrent.ThreadFactory
import java.util.concurrent.ThreadPoolExecutor

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var viewModel: HomeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
//        viewModel.getMovies()
        Executors.newFixedThreadPool(4).run {
            findViewById<TextView>(R.id.tvTitle).text = "asd"
        }

        setupObservers()
    }

    private fun setupObservers() {
        viewModel.result.observe(this@HomeActivity) {
            when (it) {
                is ResponseResult.Loading -> {
                    binding.progressBar.isVisible = true
                }

                is ResponseResult.Error -> {

                }

                is ResponseResult.Success<*> -> {
                    binding.progressBar.isVisible = false
                    binding.tvTitle.text = (it.data as List<MovieItem>).get(0).Title
                }

            }
        }
    }
}