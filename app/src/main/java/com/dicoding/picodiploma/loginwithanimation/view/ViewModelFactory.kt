package com.dicoding.picodiploma.loginwithanimation.view

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dicoding.picodiploma.loginwithanimation.data.pref.AppRepository
import com.dicoding.picodiploma.loginwithanimation.data.pref.MainRepository
import com.dicoding.picodiploma.loginwithanimation.data.pref.UserRepository
import com.dicoding.picodiploma.loginwithanimation.di.Injection
import com.dicoding.picodiploma.loginwithanimation.di.MockApiService
import com.dicoding.picodiploma.loginwithanimation.view.fitur.home.HomeViewModel
import com.dicoding.picodiploma.loginwithanimation.view.fitur.profile.ProfileViewModel
import com.dicoding.picodiploma.loginwithanimation.view.login.LoginViewModel
import com.dicoding.picodiploma.loginwithanimation.view.search.SearchViewModel
import com.dicoding.picodiploma.loginwithanimation.view.signup.SignupViewModel
import com.dicoding.picodiploma.loginwithanimation.view.welcome.WelcomeViewModel

class ViewModelFactory(context: Context) : ViewModelProvider.NewInstanceFactory() {

    private val userRepository: UserRepository = Injection.provideUserRepository(context)
    private val mainRepository: MainRepository = Injection.provideMainRepository(context)

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {

            modelClass.isAssignableFrom(LoginViewModel::class.java) -> {
                LoginViewModel(userRepository, mainRepository) as T
            }

            modelClass.isAssignableFrom(ProfileViewModel::class.java) -> {
                ProfileViewModel(userRepository, mainRepository) as T
            }


            modelClass.isAssignableFrom(WelcomeViewModel::class.java) -> {
                WelcomeViewModel(userRepository) as T
            }


            modelClass.isAssignableFrom(SignupViewModel::class.java) -> {
                SignupViewModel(mainRepository) as T
            }

            // Integration of code A
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                val appRepository = AppRepository(MockApiService)
                HomeViewModel(appRepository, mainRepository) as T
            }

            modelClass.isAssignableFrom(SearchViewModel::class.java) -> {
                val appRepository = AppRepository(MockApiService)
                SearchViewModel(appRepository) as T
            }

            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }
}
