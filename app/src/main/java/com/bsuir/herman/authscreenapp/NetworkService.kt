package com.bsuir.herman.authscreenapp

import com.bsuir.herman.authscreenapp.api.SaperApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class NetworkService {

        private val BASE_URL = "http://192.168.1.7:8075"
//    private val BASE_URL = "https://httpbin.org/"
    private var mRetrofit: Retrofit? = null
    private var api: SaperApi

    init {
        mRetrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        api = mRetrofit!!.create(SaperApi::class.java)
    }

    fun getApi(): SaperApi {
        return api
    }

//    fun getInstance(): NetworkService? {
//        if (mInstance == null) {
//            mInstance = NetworkService()
//        }
//        return mInstance
//    }

//    fun getJSONApi(): TestApi {
//        return mRetrofit!!.create(TestApi::class.java)
//    }
}