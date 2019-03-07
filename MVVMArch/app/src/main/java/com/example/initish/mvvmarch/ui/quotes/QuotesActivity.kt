 package com.example.initish.mvvmarch.ui.quotes

 import androidx.appcompat.app.AppCompatActivity
 import android.os.Bundle
 import android.view.View
 import androidx.lifecycle.Observer
 import androidx.lifecycle.ViewModelProviders
 import com.example.initish.mvvmarch.R
 import com.example.initish.mvvmarch.data.Quote
 import com.example.initish.mvvmarch.utilities.InjectorUtils
 import kotlinx.android.synthetic.main.activity_quotes.*

 class QuotesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)
        initialiseUi()
    }

     private fun initialiseUi() {
         val factory = InjectorUtils.provideQuotesViewModelFactory()
         val viewModel = ViewModelProviders.of(this,factory).get(QuoteViewModel::class.java)

         viewModel.getQuotes().observe(this, Observer { quotes ->
             val stringBuilder = StringBuilder()

             quotes.forEach { quote ->
                 stringBuilder.append("$quote\n\n")
             }

             textView_quotes.text = stringBuilder.toString()
         })

          button_add_quote.setOnClickListener {
              val quote = Quote(editText_quote.text.toString(), editText_author.text.toString())
              viewModel.addQuote(quote)
              editText_quote.setText("")
              editText_author.setText("")

          }

     }
}
