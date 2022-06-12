package com.tyler.quotesaverfinal.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.tyler.quotesaverfinal.R
import com.tyler.quotesaverfinal.models.Quote

class QuoteFragment : Fragment() {

    lateinit var quote: Quote

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quote, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        get the text objects
        val textView = view.findViewById<TextView>(R.id.quoteText)
        val sourceView = view.findViewById<TextView>(R.id.quoteSource)
        val keywordView = view.findViewById<TextView>(R.id.quoteKeywords)
        val dateView = view.findViewById<TextView>(R.id.quoteDate)

//        get the button objects
        val editButton = view.findViewById<Button>(R.id.editButton)
        val deleteButton = view.findViewById<Button>(R.id.deleteButton)

//        set text for text objects
        textView.text = quote.text
        sourceView.text = quote.source
        keywordView.text = quote.keywords.toString()
        dateView.text = quote.date.toString()

//        button listeners
        editButton.setOnClickListener{
            val createFragment = CreateFragment()
            createFragment.quoteToEdit = quote
            val manager = parentFragmentManager.beginTransaction()
            manager.replace(R.id.fragment_container, createFragment)
            manager.commit()
        }

        deleteButton.setOnClickListener{
            val listFragment = ListFragment()
            listFragment.quoteToDelete = quote
            val manager = parentFragmentManager.beginTransaction()
            manager.replace(R.id.fragment_container, listFragment)
            manager.commit()
        }
    }
}