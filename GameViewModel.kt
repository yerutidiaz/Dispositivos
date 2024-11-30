package com.example.unscramble.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.unscramble.data.MAX_NO_OF_WORDS
import com.example.unscramble.data.SCORE_INCREASE
import com.example.unscramble.data.allWords
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
class GameViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(GameUiState())
    val uiState: StateFlow<GameUiState> = _uiState

    var userGuess: String = ""
        private set

    
    fun checkUserGuess() {
        
        if (userGuess.equals(_uiState.value.currentWord, ignoreCase = true)) {
            
            val updatedScore = _uiState.value.score + SCORE_INCREASE
            updateGameState(updatedScore)
        } else {
           
            _uiState.update { currentState ->
                currentState.copy(isGuessedWordWrong = true)
            }
        }
        updateUserGuess("")
    }

    // Actualiza el estado del juego
    private fun updateGameState(updatedScore: Int) {
        _uiState.update { currentState ->
            currentState.copy(
                score = updatedScore,
                currentWordCount = currentState.currentWordCount + 1, 
                isGuessedWordWrong = false
            )
        }
    }

    // para limpiar el guess del usuario
    private fun updateUserGuess(guess: String) {
        userGuess = guess
    }

    // para saltar una palabra
    fun skipWord() {
        _uiState.update { currentState ->
            currentState.copy(currentWordCount = currentState.currentWordCount + 1) 
        }
    }

    // para resetear el juego (cuando termina)
    fun resetGame() {
        _uiState.update { currentState ->
            currentState.copy(
                score = 0,
                currentWordCount = 0,
                isGameOver = false
            )
        }
    }
}
