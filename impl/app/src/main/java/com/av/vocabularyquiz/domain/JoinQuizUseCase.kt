package com.av.vocabularyquiz.domain

import com.av.vocabularyquiz.domain.model.QuizSession
import com.av.vocabularyquiz.domain.repository.QuizRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class JoinQuizUseCase @Inject constructor(
    private val repository: QuizRepository
) {
    fun execute(quizId: String): Flow<Result<QuizSession>> {
        return repository.joinQuiz(quizId)
    }
}