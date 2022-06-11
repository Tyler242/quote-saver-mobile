package com.tyler.quotesaverfinal.data

import android.util.Log
import com.tyler.quotesaverfinal.models.Quote

class Sort {

    fun sortWord(word: String, quotes: List<Quote>): MutableList<Quote> {
//        sort the quotes by word
        val sortedQuotes = quotes.filter { it.text.contains(word) } as MutableList<Quote>
        return orderByFrequency(word, sortedQuotes)
    }

    fun sortSource(source: String, quotes: List<Quote>): MutableList<Quote> {
//        sort the quotes by source
        return quotes.filter { it.source == source} as MutableList<Quote>
    }

    fun sortKeyword(keyword: String, quotes: List<Quote>): MutableList<Quote> {
        val sortedQuotes: MutableList<Quote> = mutableListOf()
//        sort the quotes by keyword
        for (quote in quotes) {
            quote.keywords.forEach { tag ->
                if (tag == keyword) {
                    sortedQuotes.add(quote)
                    return@forEach
                }
            }
        }
        return sortedQuotes
    }

    private fun orderByFrequency(word: String, quotes: MutableList<Quote>): MutableList<Quote> {
        val sortedQuotes: MutableList<Quote> = mutableListOf()
        val sortedQuotesGroup = quotes.groupBy { quote ->
            getFrequency(word, quote.text)
        }
        val listKeys = sortedQuotesGroup.keys.toMutableList()

        listKeys.sort()
        listKeys.reverse()

        for (key in listKeys) {
            sortedQuotesGroup[key]?.let { sortedQuotes.addAll(it) }
        }
        return sortedQuotes
    }

    private fun getFrequency(word: String, quote: String): Int {
        val wordList = quote.split(" ")
        var count = 0

        wordList.forEach {
            val newWord = it.replace("\\p{Punct}".toRegex(), "")
            if (newWord == word) count += 1
        }
        return count
    }
}