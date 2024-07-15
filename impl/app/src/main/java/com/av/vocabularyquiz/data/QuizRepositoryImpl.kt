package com.av.vocabularyquiz.data

import com.av.vocabularyquiz.data.remote.ApiService
import com.av.vocabularyquiz.domain.model.QuizSession
import com.av.vocabularyquiz.domain.repository.QuizRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class QuizRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : QuizRepository {
    override fun joinQuiz(quizId: String): Flow<Result<QuizSession>> = flow {
        try {
            val response = apiService.joinQuiz(quizId)
            emit(Result.success(response))
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }
}