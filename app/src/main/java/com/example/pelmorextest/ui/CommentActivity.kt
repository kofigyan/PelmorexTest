package com.example.pelmorextest.ui

import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.pelmorextest.R
import com.example.pelmorextest.databinding.ActivityCommentBinding
import com.example.pelmorextest.ui.base.BaseActivity
import com.example.pelmorextest.util.afterTextChanged
import com.example.pelmorextest.viewmodel.CommentViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class CommentActivity : BaseActivity<CommentViewModel, ActivityCommentBinding>() {

    override val layoutId: Int
        get() = R.layout.activity_comment

    override val viewModelClass: Class<CommentViewModel>
        get() = CommentViewModel::class.java


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        setUpListeners()

        setUpObserver()

    }

    private fun setUpListeners() {
        binding.edtName.afterTextChanged { viewModel.setName(it) }
        binding.edtEmail.afterTextChanged { viewModel.setEmail(it) }
        binding.edtPhoneNumber.afterTextChanged { viewModel.setPhoneNumber(it) }
    }


    private fun setUpObserver() {
        lifecycleScope.launch {
            viewModel.isSubmitBtnEnabled.collect {
                binding.btnSubmit.isEnabled = it
            }
        }
    }


}