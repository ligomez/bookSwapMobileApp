package com.example.buku.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.buku.R
import com.example.buku.model.Category
import com.example.buku.model.CategoryList
import com.squareup.picasso.Picasso

class CategoriesAdapter (
    private val categoriesList: ArrayList<Category>,
    private val onItemClicked: (Category) -> Unit
        ): RecyclerView.Adapter<CategoriesAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = categoriesList[position]
        holder.itemView.setOnClickListener { onItemClicked(categoriesList[position])}
        holder.bind(category)
    }

    override fun getItemCount(): Int = categoriesList.size



    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var tvCategoryName: TextView = itemView.findViewById(R.id.tvCategoryName)
        private var ivCategoryImage: ImageView = itemView.findViewById(R.id.ivCategoryImage)

        fun bind(category: Category) {
            tvCategoryName.text = category.name
            Picasso.get().load(category.imageUrl).into(ivCategoryImage)
        }

    }
}