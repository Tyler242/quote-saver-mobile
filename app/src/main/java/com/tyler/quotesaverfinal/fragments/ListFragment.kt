package com.tyler.quotesaverfinal.fragments

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.tyler.quotesaverfinal.R
import com.tyler.quotesaverfinal.adapter.ItemAdapter
import com.tyler.quotesaverfinal.data.FileIO
import com.tyler.quotesaverfinal.data.Sort
import com.tyler.quotesaverfinal.models.Quote


/**
 * A simple [Fragment] subclass.
 * Use the [ListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListFragment(
) : Fragment() {
    var sortService = Sort()
    var quoteToDelete: Quote? = null
    var searchParam: String? = null
    lateinit var searchString: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val quotes = FileIO().readFile(requireContext())
        var sortedQuotes: MutableList<Quote>

        sortedQuotes = when (searchParam) {
            "Word" -> {
                sortService.sortWord(searchString, quotes)
            }
            "Source" -> {
                sortService.sortSource(searchString, quotes)
            }
            "Keyword" -> {
                sortService.sortKeyword(searchString, quotes)
            }
            else -> quotes
        }

//        delete the quote and reload the file
        if (quoteToDelete != null) {
            quotes.remove(quoteToDelete)
            FileIO().writeFile(requireContext(), quotes)
            sortedQuotes = FileIO().readFile(requireContext())
        }

        val recyclerView = requireView().findViewById<RecyclerView>(R.id.list_quotes)
        recyclerView.adapter = ItemAdapter(sortedQuotes)
    }
}