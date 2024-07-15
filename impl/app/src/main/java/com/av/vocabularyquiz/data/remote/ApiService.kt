package com.av.vocabularyquiz.data.remote

import com.av.vocabularyquiz.domain.model.QuizSession
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("joinQuiz")
    suspend fun joinQuiz(@Body quizId: String): QuizSession
}