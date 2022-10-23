package com.example.diandroid

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.diandroid.data.FactData
import dagger.hilt.android.lifecycle.HiltViewModel

import javax.inject.Inject

@HiltViewModel
class FactViewModel @Inject constructor(
    private val repo: FactRepository
) : ViewModel() {
    fun getFactData(): LiveData<FactData> = repo.getFact().asLiveData()
}