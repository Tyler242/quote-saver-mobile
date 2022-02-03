package com.tyler.quotesaverfinal.fragments

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.tyler.quotesaverfinal.R
import com.tyler.quotesaverfinal.adapter.ItemAdapter
import com.tyler.quotesaverfinal.data.FileIO

class DashboardFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val quotes = FileIO().readFile(requireContext())
        val lastQuote = quotes.size - 1
        val rQuoteText = view.findViewById<TextView>(R.id.tvQuote)
        val rQuoteSource = view.findViewById<TextView>(R.id.tvSource)
        val rQuoteKeywords = view.findViewById<TextView>(R.id.tvKeywords)

        rQuoteText.text = quotes[lastQuote].text
        rQuoteSource.text = quotes[lastQuote].source
        rQuoteKeywords.text = quotes[lastQuote].keywords.toString()

//        get the search buttons1
        val btnSearchWord = view.findViewById<Button>(R.id.wordSearch)
        val btnSearchSource = view.findViewById<Button>(R.id.sourceSearch)
        val btnSearchKeyword = view.findViewById<Button>(R.id.keywordSearch)

        val searchFragment = SearchFragment()

//        on click listeners
        btnSearchWord.setOnClickListener {
            searchFragment.hint = "Word"
            val manager = parentFragmentManager.beginTransaction()
            manager.replace(R.id.fragment_container, searchFragment)
            manager.commit()
        }
        btnSearchSource.setOnClickListener {
            searchFragment.hint = "Source"
            val manager = parentFragmentManager.beginTransaction()
            manager.replace(R.id.fragment_container, searchFragment)
            manager.commit()
        }
        btnSearchKeyword.setOnClickListener {
            searchFragment.hint = "Keyword"
            val manager = parentFragmentManager.beginTransaction()
            manager.replace(R.id.fragment_container, searchFragment)
            manager.commit()
        }
    }
}