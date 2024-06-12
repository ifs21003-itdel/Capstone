package com.dicoding.picodiploma.loginwithanimation.data.pref

import androidx.lifecycle.liveData
import com.dicoding.picodiploma.loginwithanimation.data.model.ApiService
import com.dicoding.picodiploma.loginwithanimation.data.model.LoginRequest
import com.dicoding.picodiploma.loginwithanimation.data.model.RegisterRequest
import com.dicoding.picodiploma.loginwithanimation.di.Result
import org.json.JSONException
import org.json.JSONObject
import retrofit2.HttpException

class MainRepository(
    private val apiService: ApiService,
) {
    fun login(loginData : LoginRequest) = liveData {
        emit(Result.Loading)
        try {
            val loginResponse = apiService.loginUser(loginData)
            emit(Result.Success(loginResponse))
        }catch (e: HttpException) {
            val errorJsonString = e.response()?.errorBody()?.string()
            val errorMsg = try {
                val jsonObject = JSONObject(errorJsonString)
                jsonObject.getString("msg")
            } catch (e: JSONException) {
                e.message.toString()
            }
            emit(Result.Error(errorMsg))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(Result.Error(e.message.toString()))
        }
    }

    fun register(
        registerData : RegisterRequest
    ) = liveData {
        emit(Result.Loading)
        try {
            val registerResponse = apiService.registerUser(registerData)
            emit(Result.Success(registerResponse))
        }catch (e: HttpException) {
            val errorJsonString = e.response()?.errorBody()?.string()
            val errorMsg = try {
                val jsonObject = JSONObject(errorJsonString)
                jsonObject.getString("msg")
            } catch (e: JSONException) {
                e.message.toString()
            }
            emit(Result.Error(errorMsg))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(Result.Error(e.message.toString()))
        }
    }

    fun getProfile() = liveData {
        emit(Result.Loading)
        try {
            val profileResponse = apiService.getProfile()
            emit(Result.Success(profileResponse))
        }catch (e: HttpException) {
            val errorJsonString = e.response()?.errorBody()?.string()
            val errorMsg = try {
                val jsonObject = JSONObject(errorJsonString)
                jsonObject.getString("msg")
            } catch (e: JSONException) {
                e.message.toString()
            }
            emit(Result.Error(errorMsg))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(Result.Error(e.message.toString()))
        }
    }
}