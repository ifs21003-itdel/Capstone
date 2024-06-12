package com.dicoding.picodiploma.loginwithanimation.view.welcome

import androidx.lifecycle.*
import com.dicoding.picodiploma.loginwithanimation.data.model.LoginRequest
import com.dicoding.picodiploma.loginwithanimation.data.model.ProfileResponse
import com.dicoding.picodiploma.loginwithanimation.data.pref.MainRepository
import com.dicoding.picodiploma.loginwithanimation.data.pref.UserModel
import com.dicoding.picodiploma.loginwithanimation.data.pref.UserRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class WelcomeViewModel(
    private val repository: UserRepository) : ViewModel() {

    private val _userSession = MutableLiveData<UserModel>()
    val userSession: LiveData<UserModel> get() = _userSession

    fun getSession() {
        viewModelScope.launch {
            repository.getSession().collect { user ->
                _userSession.postValue(user)
            }
        }
    }


}
