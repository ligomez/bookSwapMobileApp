package com.example.buku.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.buku.R
import com.example.buku.model.Book
import com.squareup.picasso.Picasso

class BooksAdapter(val booksListener: BooksListener) :
RecyclerView.Adapter<BooksAdapter.ViewHolder> () {

    var listBooks = ArrayList<Book> ()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_book, parent,false))

    override fun onBindViewHolder(holder: BooksAdapter.ViewHolder, position: Int) {
        val books = listBooks[position]
        holder.tvNameBook.text = books.name
        holder.tvAuthorBook.text = books.author
        holder.tvLocation.text = books.location
        Picasso.get().load(books.imageUrl).into(holder.ivBookImage)

        holder.itemView.setOnClickListener {
            booksListener.onBooksClick(books, position)
        }
    }

    override fun getItemCount() = listBooks.size

    fun updateData(data: List<Book>) {
        listBooks.clear()
        listBooks.addAll(data)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNameBook: TextView = itemView.findViewById(R.id.tvNameBook)
        val tvAuthorBook: TextView = itemView.findViewById(R.id.tvAuthorBook)
        val tvLocation: TextView = itemView.findViewById(R.id.tvLocation)
        val ivBookImage: ImageView = itemView.findViewById(R.id.ivImageBook)
    }

}