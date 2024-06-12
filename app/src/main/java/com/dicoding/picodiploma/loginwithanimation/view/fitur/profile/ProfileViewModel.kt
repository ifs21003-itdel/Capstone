package com.dicoding.picodiploma.loginwithanimation.view.fitur.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dicoding.picodiploma.loginwithanimation.data.pref.MainRepository
import com.dicoding.picodiploma.loginwithanimation.data.pref.UserRepository
import kotlinx.coroutines.launch

class ProfileViewModel(private val repository: UserRepository, private val mainRepository: MainRepository) : ViewModel() {

    fun getUser() = mainRepository.getProfile()

    fun logout() {
        viewModelScope.launch {
            repository.logout()
        }
    }
}
