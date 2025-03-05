package com.example.presentation.base

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.viewbinding.ViewBinding
import com.example.presentation.R
import kotlinx.coroutines.launch

abstract class BaseActivity<VM : BaseViewModel, VB : ViewBinding> : AppCompatActivity() {

    protected abstract val viewModel: VM
    protected lateinit var binding: VB
    abstract fun getViewBinding(): VB

    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getViewBinding()
        setContentView(binding.root)
        progressBar = findViewById(R.id.progressBar)
        setupObservers()
    }

    private fun setupObservers() {
        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch { observeLoadingState() }
                launch { observeErrorState() }
            }
        }
    }

    private suspend fun observeLoadingState() {
        viewModel.loading.collect { isLoading ->
            showLoadingIndicator(isLoading)
        }
    }

    private suspend fun observeErrorState() {
        viewModel.error.collect { error ->
            showError(error)
        }
    }

    open fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    open fun showLoadingIndicator(isLoading: Boolean) {
        progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

    open fun showError(error: Throwable) {
        Toast.makeText(this, error.localizedMessage, Toast.LENGTH_LONG).show()
    }
}

