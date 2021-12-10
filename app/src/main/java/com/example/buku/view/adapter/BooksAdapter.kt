package com.example.buku.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.buku.R
import com.example.buku.model.Books
import com.squareup.picasso.Picasso

class BooksAdapter(val booksListener: BooksListener) :
RecyclerView.Adapter<BooksAdapter.ViewHolder> () {

    var listBooks = ArrayList<Books> ()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_books, parent,false))

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

    fun updateData(data: List<Books>) {
        listBooks.clear()
        listBooks.addAll(data)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNameBook = itemView.findViewById<TextView>(R.id.tvNameBook)
        val tvAuthorBook = itemView.findViewById<TextView>(R.id.tvAuthorBook)
        val tvLocation = itemView.findViewById<TextView>(R.id.tvLocation)
        val ivBookImage = itemView.findViewById<ImageView>(R.id.ivBookImage)
    }

}