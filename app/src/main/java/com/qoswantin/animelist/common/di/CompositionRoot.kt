package com.qoswantin.animelist.common.di

import com.qoswantin.animelist.common.JIKAN_BASE_URL
import com.qoswantin.animelist.networking.JikanApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class CompositionRoot {

    private var okHttpClient: OkHttpClient? = null
    private var retrofit: Retrofit? = null
    private var jikanApi: JikanApi? = null
    private var loggingInterceptor: HttpLoggingInterceptor? = null

    fun getJikapAPi(): JikanApi {
        if (jikanApi == null) {
            jikanApi = getJikanRetrofitClient().create(JikanApi::class.java)
        }
        return jikanApi!!
    }


    fun getJikanRetrofitClient(): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(JIKAN_BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(getOkHttpClient())
                .build()
        }
        return retrofit!!
    }

    fun getLoggingInterceptor(): HttpLoggingInterceptor {
        if (loggingInterceptor == null) {
            loggingInterceptor = HttpLoggingInterceptor().apply {
                setLevel(HttpLoggingInterceptor.Level.BASIC)
            }
        }
        return loggingInterceptor!!
    }

    fun getOkHttpClient(): OkHttpClient {
        if (okHttpClient == null) {
            okHttpClient = OkHttpClient.Builder()
                .addInterceptor(getLoggingInterceptor())
                .build()
        }
        return okHttpClient!!
    }

}