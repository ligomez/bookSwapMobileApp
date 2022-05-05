package com.example.buku.view.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.buku.R
import com.example.buku.databinding.FragmentMessagesBinding
import com.example.buku.model.Message
import com.example.buku.model.MessageList
import com.example.buku.view.adapter.MessagesAdapter
import com.google.gson.Gson

class MessagesFragment : Fragment() {

    private lateinit var messagesBinding: FragmentMessagesBinding

    private lateinit var listMessages: ArrayList<Message>
    private lateinit var messagesAdapter: MessagesAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        messagesBinding = FragmentMessagesBinding.inflate(inflater, container, false)
        return messagesBinding.root
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)

        listMessages = loadMockMessagesFromJason()
        messagesAdapter = MessagesAdapter(listMessages, onItemClicked = { onMessageClicked(it)})

        messagesBinding.rvMessages.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = messagesAdapter
            setHasFixedSize(false)
        }
    }

    private fun onMessageClicked(message: Message) {

    }

    private fun loadMockMessagesFromJason(): ArrayList<Message> {
        val messagesString: String =
            context?.assets?.open("messages.json")?.bufferedReader().use { it!!.readText() }
        val gson = Gson()
        return gson.fromJson(messagesString, MessageList::class.java)
    }

}