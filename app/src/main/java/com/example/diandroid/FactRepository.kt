package com.example.diandroid

import com.example.diandroid.data.ApiInterface
import com.example.diandroid.data.FactData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class FactRepository @Inject constructor(
    private val apiInterface: ApiInterface
) {

    fun getFact(): Flow<FactData> = flow {
        val response = apiInterface.getFact()
        emit(response)
    }.flowOn(Dispatchers.IO)

}