package com.example.codelab4

import android.content.Context
import android.graphics.pdf.PdfDocument.Page
import androidx.compose.runtime.mutableStateOf
import com.example.codelab4.models.Quote
import com.google.gson.Gson

object DataManager {
    var data = emptyArray<Quote>()
    var currPage = mutableStateOf(Pages.LISTING)
    var isDataLoaded = mutableStateOf(false)
    var currQuote : Quote? = null
    fun loadAssetsFromFile(context: Context){
        val inputStream = context.assets.open("quotes.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer,Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(json, Array<Quote>::class.java)
        isDataLoaded.value = true
    }

    fun switchPages(quote: Quote?){
        if(currPage.value == Pages.LISTING){
            currQuote = quote
            currPage.value = Pages.DETAIL
        }else{
            currPage.value = Pages.LISTING
        }
    }
}

