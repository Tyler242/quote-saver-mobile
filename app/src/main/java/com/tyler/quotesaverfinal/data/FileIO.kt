package com.tyler.quotesaverfinal.data

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.tyler.quotesaverfinal.models.Quote

class FileIO {
//    this shouldn't ever change. This is the file where the quote data is stored.
    private val fileName = "quotes.json"

    fun writeFile(context: Context, quotes: List<Quote>) {
//        configure the quote objects to be written correctly
        val jsonString = Gson().toJson(quotes)

//        write the quote objects to the file
        context.openFileOutput(fileName, Context.MODE_PRIVATE).use {
            output -> output.write(jsonString.toByteArray())
        }
    }

    fun readFile(context: Context): MutableList<Quote> {
        var text: String

//        read the text from the file
        context.openFileInput(fileName).use { stream ->
            text = stream.bufferedReader().use {
                it.readText()
            }
        }
//        translate the text received to quote objects
        return Gson().fromJson(text, object : TypeToken<Collection<Quote>>() {}.type)
    }
}