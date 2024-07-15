package com.av.vocabularyquiz.domain.repository

import com.av.vocabularyquiz.domain.model.QuizSession
import kotlinx.coroutines.flow.Flow

interface QuizRepository {
    fun joinQuiz(quizId: String): Flow<Result<QuizSession>>
}