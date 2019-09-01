package com.tuxdev.coroutines.di

import com.tuxdev.coroutines.BuildConfig
import com.tuxdev.coroutines.data.source.rest.CatAPI
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.net.ssl.HostnameVerifier


/**
 **********************************************
 * Created by ukie on 10/4/18 with ♥
 * (>’_’)> email : ukie.tux@gmail.com
 * github : https://www.github.com/tuxkids <(’_’<)
 **********************************************
 * © 2018 | All Right Reserved
 */

val networkModule = module(createdAtStart = true) {
    single { createOkhttpClient() }
    single { createWebService<CatAPI>(get()) }
}

@Suppress("DEPRECATION")
fun createOkhttpClient(): OkHttpClient {
    val loggingInterceptor = HttpLoggingInterceptor()
    loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

    val builder = OkHttpClient.Builder()
    builder.connectTimeout(60, TimeUnit.SECONDS)
    builder.readTimeout(60, TimeUnit.SECONDS)
    builder.writeTimeout(60, TimeUnit.SECONDS)
    builder.hostnameVerifier(HostnameVerifier { _, _ -> true })

    builder.retryOnConnectionFailure(true)
    builder.addInterceptor(loggingInterceptor)
    builder.addInterceptor(object : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val request = chain.request().newBuilder()
                    .addHeader("Accept", "application/json")
                    .addHeader("Content-Type", "application/json")
            return chain.proceed(request.build())
        }
    })
    return builder.build()
}

inline fun <reified T> createWebService(okHttpClient: OkHttpClient): T {
    val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    return retrofit.create(T::class.java)
}
