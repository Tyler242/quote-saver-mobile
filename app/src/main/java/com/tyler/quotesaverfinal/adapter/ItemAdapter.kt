package com.tyler.quotesaverfinal.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.tyler.quotesaverfinal.R
import com.tyler.quotesaverfinal.fragments.CreateFragment
import com.tyler.quotesaverfinal.fragments.ListFragment
import com.tyler.quotesaverfinal.fragments.QuoteFragment
import com.tyler.quotesaverfinal.models.Quote

class ItemAdapter(
    private val dataset: List<Quote>
//    set the list of quotes
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        create a view object for each quote in our list
        val tvQuoteText: TextView = view.findViewById(R.id.quote_text)
        val tvQuoteSource: TextView = view.findViewById(R.id.quote_source)
        val tvQuoteKeywords: TextView = view.findViewById(R.id.quote_keywords)
        val editButton: ImageButton = view.findViewById(R.id.edit_quote)
        val deleteButton: ImageButton = view.findViewById(R.id.delete_quote)
        val layout: LinearLayout = view.findViewById(R.id.linearLayout2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
//        convert the layout file for each quote into a view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

//        set the content and listeners for each quote view object
        val item = dataset[position]
        holder.tvQuoteText.text = item.text
        holder.tvQuoteSource.text = item.source
        holder.tvQuoteKeywords.text = item.keywords.toString().split("[")[1].split("]")[0]

//        layout listener
        holder.layout.setOnClickListener {
            val quoteFragment = QuoteFragment()
            quoteFragment.quote = item
            val manager = (holder.itemView.context as FragmentActivity).supportFragmentManager.beginTransaction()
            manager.replace(R.id.fragment_container, quoteFragment)
            manager.commit()
        }

//        edit button listener
        holder.editButton.setOnClickListener {
            val createFragment = CreateFragment()
            createFragment.quoteToEdit = item
            val manager = (holder.itemView.context as FragmentActivity).supportFragmentManager.beginTransaction()
            manager.replace(R.id.fragment_container, createFragment)
            manager.commit()
        }

//        delete button listener
        holder.deleteButton.setOnClickListener {
            val listFragment = ListFragment()
            listFragment.quoteToDelete = item
            val manager = (holder.itemView.context as FragmentActivity).supportFragmentManager.beginTransaction()
            manager.replace(R.id.fragment_container, listFragment)
            manager.commit()
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}