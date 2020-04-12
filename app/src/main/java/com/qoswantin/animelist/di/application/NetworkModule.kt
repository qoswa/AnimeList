package com.qoswantin.animelist.di.application

import com.qoswantin.animelist.common.JIKAN_BASE_URL
import com.qoswantin.animelist.networking.JikanApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

@Module
class NetworkModule {

    @ApplicationScope
    @Provides
    fun provideJikapApi(
        @Named(JIKAN_RETROFIT_CLIENT) jikanRetrofitClient: Retrofit
    ): JikanApi {
        return jikanRetrofitClient.create(JikanApi::class.java)
    }

    @ApplicationScope
    @Provides
    @Named(JIKAN_RETROFIT_CLIENT)
    fun provideJikanRetrofitClient(
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(JIKAN_BASE_URL)
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @ApplicationScope
    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BASIC)
        }
    }

    @ApplicationScope
    @Provides
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    companion object {
        const val JIKAN_RETROFIT_CLIENT = "JIKAN_RETROFIT_CLIENT"
    }


}
