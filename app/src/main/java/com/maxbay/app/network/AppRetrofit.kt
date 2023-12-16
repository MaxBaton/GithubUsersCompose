package com.maxbay.app.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object AppRetrofit {
    private var INSTANCE: Retrofit? = null
    private const val BASE_URL = "https://api.github.com"
    // OkHttp
    private const val CONNECT_TIMEOUT: Long = 5
    private const val READ_TIMEOUT: Long = 8
    // Monitor
    private val LOCK = Any()

    fun create(): Retrofit {
        return INSTANCE ?: synchronized(LOCK) {
            val interceptor = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }

            val okHttpClient = OkHttpClient().newBuilder()
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(interceptor = interceptor)
                .build()

            val instance = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()

            INSTANCE = instance

            instance
        }
    }
}