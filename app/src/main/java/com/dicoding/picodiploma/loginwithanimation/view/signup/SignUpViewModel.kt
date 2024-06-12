package com.dicoding.picodiploma.loginwithanimation.view.signup

import androidx.lifecycle.ViewModel
import com.dicoding.picodiploma.loginwithanimation.data.model.RegisterRequest
import com.dicoding.picodiploma.loginwithanimation.data.pref.MainRepository

class SignupViewModel(
    private val mainRepository: MainRepository
) : ViewModel() {
    fun register(registerData : RegisterRequest) =
        mainRepository.register(registerData)
}