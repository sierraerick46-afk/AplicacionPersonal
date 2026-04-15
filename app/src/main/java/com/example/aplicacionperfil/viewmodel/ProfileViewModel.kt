package com.example.aplicacionperfil.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.aplicacionperfil.data.UserProfile
import com.example.aplicacionperfil.data.UserRepository

class ProfileViewModel : ViewModel() {
    private val userRepository = UserRepository

    private val _userProfile = MutableLiveData<UserProfile>()
    val userProfile: LiveData<UserProfile> = _userProfile

    private val _showExtraInfo = MutableLiveData(false)
    val showExtraInfo: LiveData<Boolean> = _showExtraInfo

    private val _showMoreInfo = MutableLiveData(false)
    val showMoreInfo: LiveData<Boolean> = _showMoreInfo

    init {
        loadUserProfile()
    }

    private fun loadUserProfile() {
        _userProfile.value = userRepository.getUserProfile()
    }

    fun toggleExtraInfo() {
        _showExtraInfo.value = _showExtraInfo.value != true
    }

    fun toggleMoreInfo() {
        _showMoreInfo.value = _showMoreInfo.value != true
    }
}