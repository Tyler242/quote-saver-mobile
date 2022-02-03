package com.tyler.quotesaverfinal.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.tyler.quotesaverfinal.R

class SearchFragment : Fragment() {
    lateinit var hint: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val searchBtn = view.findViewById<Button>(R.id.search)
        val etSearchKey = view.findViewById<EditText>(R.id.search_key)
        etSearchKey.hint = hint

        searchBtn.setOnClickListener {
//            TODO: create attribute that will call search method from ListFragment
            val listFragment = ListFragment()
//            set the attributes that will sort the quotes correctly
            listFragment.searchParam = hint
            listFragment.searchString = etSearchKey.text.toString()
            val manager = parentFragmentManager.beginTransaction()
            manager.replace(R.id.fragment_container, listFragment)
            manager.commit()
        }
    }
}