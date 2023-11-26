package com.example.android_chatbot.ui

import androidx.lifecycle.ViewModel
import com.example.android_chatbot.data.ChatUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

/** Price for a single cupcake */
//private const val PRICE_PER_CUPCAKE = 2.00

/** Additional cost for same day pickup of an order */
//private const val PRICE_FOR_SAME_DAY_PICKUP = 3.00

/**
 * [OrderViewModel] holds information about a cupcake order in terms of quantity, flavor, and
 * pickup date. It also knows how to calculate the total price based on these order details.
 */
class ChatViewModel : ViewModel() {

    /**
     * Cupcake state for this order
     */
    private val _uiState = MutableStateFlow(ChatUiState())
    val uiState: StateFlow<ChatUiState> = _uiState.asStateFlow()

    /**
     * Set the quantity [numberCupcakes] of cupcakes for this order's state and update the price
     */
    fun createChat(chat:String) {
        var temp = _uiState.value.historyChat
        temp.add(chat)
        _uiState.update {
            ChatUiState(temp)
        }
    }

    /**
     * Reset the order state
     */
    fun clearChat() {
        _uiState.value = ChatUiState()
    }

}