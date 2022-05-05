package com.example.buku.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.buku.R
import com.example.buku.model.Message
import com.squareup.picasso.Picasso

class MessagesAdapter (
    private val messagesList: ArrayList<Message>,
    private val onItemClicked: (Message) -> Unit
        ): RecyclerView.Adapter<MessagesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_message, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val message = messagesList[position]
        holder.itemView.setOnClickListener { onItemClicked(messagesList[position])}
        holder.bind(message)
    }

    override fun getItemCount(): Int = messagesList.size


    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        private var ivUserPhoto: ImageView = itemView.findViewById(R.id.ivUserPhoto)
        private var tvUserName: TextView = itemView.findViewById(R.id.tvUserName)
        private var tvNameBook: TextView = itemView.findViewById(R.id.tvNameBook)
        private var tvMessage: TextView = itemView.findViewById(R.id.tvMessage)
        private var tvDate: TextView = itemView.findViewById(R.id.tvDate)

        fun bind(message: Message) {
            Picasso.get().load(message.imageUrl).into(ivUserPhoto)
            tvUserName.text = message.userName
            tvNameBook.text = message.bookName
            tvMessage.text = message.message
            tvDate.text = message.date
        }

    }

}