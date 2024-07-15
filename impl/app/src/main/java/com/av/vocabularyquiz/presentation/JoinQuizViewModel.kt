package com.av.vocabularyquiz.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.av.vocabularyquiz.domain.JoinQuizUseCase
import com.av.vocabularyquiz.domain.model.QuizSession
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class JoinQuizViewModel @Inject constructor(
    private val joinQuizUseCase: JoinQuizUseCase
) : ViewModel() {

    private val _joinQuizState = MutableStateFlow<Result<QuizSession>?>(null)
    val joinQuizState: StateFlow<Result<QuizSession>?> = _joinQuizState

    fun joinQuiz(quizId: String) {
        viewModelScope.launch {
            joinQuizUseCase.execute(quizId).collect { result ->
                _joinQuizState.value = result
            }
        }
    }
}