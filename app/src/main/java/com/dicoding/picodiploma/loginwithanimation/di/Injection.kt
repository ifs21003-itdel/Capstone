package com.dicoding.picodiploma.loginwithanimation.di

import android.content.Context
import com.dicoding.picodiploma.loginwithanimation.BuildConfig
import com.dicoding.picodiploma.loginwithanimation.data.model.ApiService
import com.dicoding.picodiploma.loginwithanimation.data.pref.MainRepository
import com.dicoding.picodiploma.loginwithanimation.data.pref.UserPreference
import com.dicoding.picodiploma.loginwithanimation.data.pref.UserRepository
import com.dicoding.picodiploma.loginwithanimation.data.pref.dataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Injection {
    private fun getApiService(token: String): ApiService {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level =
                if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        }
        return Retrofit.Builder()
            .baseUrl(BuildConfig.API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(loggingInterceptor)
                    .addInterceptor { chain ->
                        val request = chain.request()
                        val authenticatedRequest =
                            if (token.isNotEmpty()) {
                                request.newBuilder()
                                    .addHeader("Authorization", "Bearer $token")
                                    .build()
                            } else {
                                request
                            }
                        chain.proceed(authenticatedRequest)
                    }
                    .build())
            .build()
            .create(ApiService::class.java)
    }

    fun provideUserRepository(context: Context): UserRepository {
        val pref = UserPreference.getInstance(context.dataStore)
        return UserRepository.getInstance(pref)
    }

    fun provideMainRepository(context: Context): MainRepository {
        val pref = runBlocking { provideUserRepository(context).getSession().first().token }
        return MainRepository(getApiService(pref))
    }
}