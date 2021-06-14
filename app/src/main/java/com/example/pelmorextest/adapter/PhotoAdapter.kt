package com.example.pelmorextest.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pelmorextest.R
import com.example.pelmorextest.databinding.ItemPhotoBinding
import com.example.pelmorextest.model.Photo


class PhotoAdapter internal constructor(
    val context: Context
) : ListAdapter<Photo, PhotoAdapter.PhotoViewHolder>(
    PhotoDiffCallback()
) {

    class PhotoViewHolder constructor(private val binding: ItemPhotoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Photo, context: Context) {

            binding.photos = item
            binding.tvPhotoNumber.text = (adapterPosition + 1).toString()

            val imageUrl = item.imageUrl

            Glide.with(context)
                .load(imageUrl)
               // .placeholder(R.mipmap.outline_photo_white_48)
                .into(binding.ivPhoto)

            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): PhotoViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemPhotoBinding.inflate(layoutInflater, parent, false)
                return PhotoViewHolder(
                    binding
                )
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        return PhotoViewHolder.from(
            parent
        )
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, context)
    }


    class PhotoDiffCallback : DiffUtil.ItemCallback<Photo>() {
        override fun areItemsTheSame(
            oldItem: Photo,
            newItem: Photo
        ) = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: Photo,
            newItem: Photo
        ) = oldItem == newItem
    }


}