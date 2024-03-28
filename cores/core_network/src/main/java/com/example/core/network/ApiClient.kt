package com.example.core.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

object ApiClient  {
    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    fun build() : OkHttpClient {
        var okhttpBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
            .addInterceptor { chain ->
                val original  = chain.request()
                val request = original.newBuilder()
                    .method(original.method, original.body)
                    .build()
                chain.proceed(request)
            }
            .addInterceptor { chain ->
                val url = chain.request()
                    .url
                    .newBuilder()
                    .addQueryParameter("api_key", BuildConfig.API_KEY)
                    .addQueryParameter("language", "en-US")
                    .build()
                val request = chain.request().newBuilder().url(url).build()
                chain.proceed(request)
            }

        if (BuildConfig.DEBUG){
            okhttpBuilder = okhttpBuilder.addInterceptor(loggingInterceptor)
        }

        return okhttpBuilder.build()
    }
}