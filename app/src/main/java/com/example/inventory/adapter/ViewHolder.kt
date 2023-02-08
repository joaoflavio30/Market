package com.example.inventory.adapter

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.inventory.databinding.ItemListItemBinding
import com.example.inventory.model.Item
import com.example.inventory.utils.getFormattedPrice

sealed class ViewHolder(_binding: ViewBinding) : RecyclerView.ViewHolder(_binding.root) {

    class ItemListViewHolder(private val binding: ItemListItemBinding) : ViewHolder(binding) {

        fun bind(item: Item) {
            binding.itemName.text = item.itemName
            binding.itemPrice.text = item.getFormattedPrice()
            binding.itemQuantity.text = item.quantityInStock.toString()
        }
    }
}
