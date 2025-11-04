package com.example.spamsheildai.network

import com.example.spamsheildai.model.MessageRequest
import com.example.spamsheildai.model.MessageResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("/predict")
    fun analyzeMessage(@Body request: MessageRequest): Call<MessageResponse>
}
