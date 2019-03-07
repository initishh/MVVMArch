package com.example.initish.mvvmarch.data

class FakeDatabase private constructor() {

    var quoteDao = FakeQuoteDao()
    private set


    companion object {
        @Volatile private var instance: FakeDatabase? = null

        fun getInstance() =
                instance ?: synchronized(this) {
                    instance ?: FakeDatabase().also { instance = it }
                }
    }
}