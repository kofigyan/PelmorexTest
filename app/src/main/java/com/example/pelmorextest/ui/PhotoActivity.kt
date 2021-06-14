package com.example.pelmorextest.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pelmorextest.R
import com.example.pelmorextest.adapter.PhotoAdapter
import com.example.pelmorextest.constant.RV_NUMBER_OF_COLUMNS
import com.example.pelmorextest.constant.RV_SPACING
import com.example.pelmorextest.constant.RV_SPAN_COUNT
import com.example.pelmorextest.databinding.ActivityPhotosBinding
import com.example.pelmorextest.model.Photo
import com.example.pelmorextest.ui.base.BaseActivity
import com.example.pelmorextest.viewmodel.PhotoViewModel
import com.example.pelmorextest.widget.GridSpacingItemDecoration

class PhotoActivity: BaseActivity<PhotoViewModel, ActivityPhotosBinding>() {

    override val layoutId: Int
        get() = R.layout.activity_photos

    override val viewModelClass: Class<PhotoViewModel>
        get() = PhotoViewModel::class.java

    protected lateinit var photoAdapter: PhotoAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.lifecycleOwner = this

        setupActionbar()

        photoAdapter = PhotoAdapter(this)

        setupRecyclerview()

        observeAllPhotos()

    }

    private fun observeAllPhotos() {
        showPhotos(viewModel.getPhotoList())
    }

    private fun showPhotos(photos: List<Photo>) {
        binding.tvNoPhoto.visibility = View.GONE
        binding.rvPhotos.visibility = View.VISIBLE
        photoAdapter.submitList(photos)
    }

    private fun showPhotosEmpty() {
        binding.rvPhotos.visibility = View.GONE
        binding.tvNoPhoto.visibility = View.VISIBLE
    }



    private fun setupActionbar() {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val ab = supportActionBar
        ab?.setDisplayHomeAsUpEnabled(true)
    }


    private fun setupRecyclerview() {
        with(binding.rvPhotos) {
            layoutManager = GridLayoutManager(this@PhotoActivity, RV_NUMBER_OF_COLUMNS)
            adapter = photoAdapter
            addItemDecoration(
                GridSpacingItemDecoration(
                    RV_SPAN_COUNT,
                    RV_SPACING,
                    true
                )
            )
        }
    }

}