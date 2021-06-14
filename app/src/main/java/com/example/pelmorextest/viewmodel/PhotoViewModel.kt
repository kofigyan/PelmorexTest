package com.example.pelmorextest.viewmodel

import com.example.pelmorextest.model.Photo
import com.example.pelmorextest.viewmodel.base.BaseViewModel
import javax.inject.Inject

class PhotoViewModel @Inject constructor(): BaseViewModel() {

    fun getPhotoList(): List<Photo> {
        val photos = listOf(
           Photo("1", "https://images.dog.ceo/breeds/retriever-curly/n02099429_935.jpg", "14th June 2021") ,
            Photo("2", "https://images.dog.ceo/breeds/terrier-yorkshire/n02094433_3010.jpg", "14th June 2021") ,
            Photo("3", "https://images.dog.ceo/breeds/hound-afghan/n02088094_7260.jpg", "14th June 2021") ,
            Photo("4", "https://images.dog.ceo/breeds/retriever-curly/n02099429_935.jpg", "14th June 2021") ,
            Photo("5", "https://images.dog.ceo/breeds/terrier-yorkshire/n02094433_3010.jpg", "14th June 2021") ,
            Photo("6", "https://images.dog.ceo/breeds/hound-afghan/n02088094_7260.jpg", "14th June 2021") ,
            Photo("7", "https://images.dog.ceo/breeds/pekinese/n02086079_952.jpg", "14th June 2021") ,
            )
        return photos

    }

}