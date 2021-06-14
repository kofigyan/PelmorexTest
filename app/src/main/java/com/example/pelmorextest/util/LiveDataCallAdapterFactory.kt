package com.example.pelmorextest.util

import androidx.lifecycle.LiveData
import com.example.pelmorextest.api.ApiResponse
import retrofit2.CallAdapter
import retrofit2.CallAdapter.Factory
import retrofit2.Retrofit
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

class LiveDataCallAdapterFactory : Factory() {

    override fun get(
        returnType: Type,
        annotations: Array<Annotation>,
        retrofit: Retrofit
    ): CallAdapter<*, *>? {

        if (Factory.getRawType(returnType) != LiveData::class.java) {
            return null
        }

        val observableType = Factory.getParameterUpperBound(0, returnType as ParameterizedType)
        val rawObservableType = Factory.getRawType(observableType)

        if (rawObservableType != ApiResponse::class.java) {
            throw IllegalArgumentException("type must be a resource")
        }

//        if (rawObservableType !is ParameterizedType) {
//            throw IllegalArgumentException("resource must be parameterized type")
//        }

        val bodyType = getParameterUpperBound(0, observableType as ParameterizedType)
        return LiveDataCallAdapter<Any>(bodyType)

    }


}