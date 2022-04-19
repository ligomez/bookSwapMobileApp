package com.example.buku.view.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.buku.R
import com.example.buku.model.Book
import com.example.buku.view.adapter.BooksAdapter


class HomeFragment : Fragment() {

    private lateinit var listBooks: ArrayList<Book>
    private lateinit var booksAdapter: BooksAdapter
    private lateinit var booksRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)

        booksRecyclerView = requireView().findViewById(R.id.rvBooksHome)
        listBooks = createMockBooks()
        booksAdapter = BooksAdapter(listBooks)

        booksRecyclerView.apply{
            layoutManager = LinearLayoutManager(activity)
            adapter = BooksAdapter(listBooks)
            setHasFixedSize(false)
        }
    }


    private fun createMockBooks(): ArrayList<Book>{
        return arrayListOf(
            Book(name = "Will Smith",
                author = "Will Smith",
                location = "Bogota"
            ),
            Book(name = "100 años de soledad",
                author = "Gabriel Garcia Marquez",
                location = "Suba"
            ),
            Book(name = "Comer Rezar Amar",
                author = "Elizabeth Gilbert",
                location = "Cali")
        )
    }
}