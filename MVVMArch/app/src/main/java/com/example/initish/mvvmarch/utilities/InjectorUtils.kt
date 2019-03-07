package com.example.initish.mvvmarch.utilities

import com.example.initish.mvvmarch.data.FakeDatabase
import com.example.initish.mvvmarch.data.QuoteRepository
import com.example.initish.mvvmarch.ui.quotes.QuoteViewModel
import com.example.initish.mvvmarch.ui.quotes.QuoteViewModelFactory

object InjectorUtils {

    fun provideQuotesViewModelFactory(): QuoteViewModelFactory {

        val quoteRepository = QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return QuoteViewModelFactory(quoteRepository)
    }

}