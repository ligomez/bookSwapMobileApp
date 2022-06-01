package com.example.buku.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.buku.R
import com.example.buku.data.local.BookLocal
import com.squareup.picasso.Picasso

class FavoritesAdapter(
    private val booksList: ArrayList<BookLocal>,
    private val onItemClicked: (BookLocal) -> Unit,
) : RecyclerView.Adapter<FavoritesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_book, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val book = booksList[position]
        holder.itemView.setOnClickListener { onItemClicked(booksList[position]) }
        holder.bind(book)
    }

    override fun getItemCount(): Int = booksList.size

    fun appendItems(newItems: ArrayList<BookLocal>) {
        booksList.clear()
        booksList.addAll(newItems)
        notifyDataSetChanged()
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var tvNameBook: TextView = itemView.findViewById(R.id.tvNameBook)
        private var tvAuthorBook: TextView = itemView.findViewById(R.id.tvAuthorBook)
        private var tvLocation: TextView = itemView.findViewById(R.id.tvLocation)
        private var ivBookImage: ImageView = itemView.findViewById(R.id.ivBookImage)

        fun bind(book: BookLocal) {
            tvNameBook.text = book.name
            tvAuthorBook.text = book.author
            tvLocation.text = book.location
            Picasso.get().load(book.imageUrl).into(ivBookImage)
        }
    }
}