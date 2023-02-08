package com.example.inventory.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.inventory.databinding.ItemListFragmentBinding
import com.example.inventory.databinding.ItemListItemBinding
import com.example.inventory.model.Item

class InventoryAdapter(private val onItemClicked: (Item) -> Unit) :
    ListAdapter<Item, ViewHolder.ItemListViewHolder>(DiffCallback) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder.ItemListViewHolder {
        return ViewHolder.ItemListViewHolder(
            ItemListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder.ItemListViewHolder, position: Int) {
        val current = getItem(position)
        holder.itemView.setOnClickListener {
            onItemClicked(current)
        }
        holder.bind(current)
    }
}
