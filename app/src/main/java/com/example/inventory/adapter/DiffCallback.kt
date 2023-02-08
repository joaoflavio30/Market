package com.example.inventory.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.inventory.model.Item

object DiffCallback : DiffUtil.ItemCallback<Item>() {
    override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean = oldItem== newItem

    override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean = oldItem.itemName == newItem.itemName
}
