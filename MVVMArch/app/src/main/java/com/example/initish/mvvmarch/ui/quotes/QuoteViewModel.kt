package com.example.initish.mvvmarch.ui.quotes

import androidx.lifecycle.ViewModel
import com.example.initish.mvvmarch.data.Quote
import com.example.initish.mvvmarch.data.QuoteRepository

class QuoteViewModel (private val quoteRepository: QuoteRepository)
    : ViewModel() {

    fun getQuotes() = quoteRepository.getQuotes()

    fun addQuote(quote: Quote) = quoteRepository.addQuote(quote)
}