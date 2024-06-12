package com.dicoding.picodiploma.loginwithanimation.data.model

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
//    @POST("login")
//    @FormUrlEncoded
//    suspend fun login(
//        @Field("email") email: String,
//        @Field("password") password: String
//    ): LoginResponse
//
//    @POST("register")
//    @FormUrlEncoded
//    suspend fun register(
//        @Field("name") name: String,
//        @Field("email") email: String,
//        @Field("password") password: String
//    ): RegisterResponse

    @POST("/register")
    suspend fun registerUser(@Body request: RegisterRequest): RegisterResponse

    @POST("/login")
    suspend fun loginUser(@Body request: LoginRequest): LoginResponse

    @GET("/profile")
    suspend fun getProfile(): ProfileResponse
}