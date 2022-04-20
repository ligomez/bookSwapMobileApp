package com.example.buku.view.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.buku.R
import com.example.buku.model.Book
import com.example.buku.model.Category
import com.example.buku.view.adapter.BooksAdapter
import com.example.buku.view.adapter.CategoriesAdapter
import com.google.gson.Gson


class HomeFragment : Fragment() {

    private lateinit var listBooks: ArrayList<Book>
    private lateinit var booksAdapter: BooksAdapter
    private lateinit var booksRecyclerView: RecyclerView

    private lateinit var listCategories: ArrayList<Category>
    private lateinit var categoriesAdapter: CategoriesAdapter
    private lateinit var categoriesRecyclerView: RecyclerView

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
//        listBooks = createMockBooks()
        listBooks = loadMockBooksFromJason()
        booksAdapter = BooksAdapter(listBooks)

        booksRecyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = BooksAdapter(listBooks)
            setHasFixedSize(false)
        }

        categoriesRecyclerView = requireView().findViewById(R.id.rvCategoriesHome)
        listCategories = createMockCategories()
        categoriesAdapter = CategoriesAdapter(listCategories)

        categoriesRecyclerView.apply {
            layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
            adapter = CategoriesAdapter(listCategories)
            setHasFixedSize(false)
        }
    }

    private fun loadMockBooksFromJason(): ArrayList<Book> {
        val booksString: String =
            activity.applicationContext.assets.open("books.json").bufferedReader()
                .use { it.readText() }
        val gson = Gson()
        val data = gson.fromJson(booksString, Book::class.java)
        return data

    }


    private fun createMockBooks(): ArrayList<Book> {
        return arrayListOf(
            Book(
                name = "Will",
                author = "Will Smith with Mark Manson",
                location = "Bogota",
                imageUrl = "https://markmanson.net/wp-content/uploads/2021/11/will-book-cover.png"
            ),
            Book(
                name = "One Hundred Years of Solitude",
                author = "Gabriel Garcia Marquez",
                location = "Suba",
                imageUrl = "https://www.jmichaelsbooks.com/pictures/900662.jpg"
            ),
            Book(
                name = "Eat Pray Love",
                author = "Elizabeth Gilbert",
                location = "Cali",
                imageUrl = "https://images.squarespace-cdn.com/content/v1/56b1196f37013bf2902300c6/1550101007941-GNR0VNCUICFWVV8C2MEY/IMG_8767.jpg"
            ),
            Book(
                name = "The Subtle Art of Not Giving a F*ck",
                author = "EMark Manson",
                location = "Bogota",
                imageUrl = "https://miro.medium.com/max/1400/1*qXp9MemqNmYwhoNptxeflg.jpeg"
            ),
        )
    }


    private fun createMockCategories(): ArrayList<Category> {
        return arrayListOf(
            Category(name = "Novels"),
            Category(name = "Comics"),
            Category(name = "Statistics"),
            Category(name = "Thriller"),
            Category(name = "Science Fiction"),
            Category(name = "Kids"),
        )
    }
}