package com.example.inventory.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.inventory.model.Item
import com.example.inventory.model.ItemDao
import kotlinx.coroutines.launch

class InventoryViewModel(private val itemDao: ItemDao) : ViewModel() {

    val items: LiveData<List<Item>> = itemDao.getItems().asLiveData()

    fun insertItem(item: Item) {
        viewModelScope.launch {
            itemDao.addItem(item)
        }
    }

    fun retrieveItem(itemId: Int): LiveData<Item> {
        return itemDao.getItem(itemId).asLiveData()
    }

    private fun getNewItem(itemName: String, itemPrice: String, quantity: String): Item {
        return Item(
            itemName = itemName,
            itemPrice = itemPrice.toDouble(),
            quantityInStock = quantity.toInt()
        )
    }

    fun textNotIsBlank(itemName: String, itemPrice: String, quantity: String): Boolean {
        return !(itemName.isBlank() || itemPrice.isBlank() || quantity.isBlank())
    }

    private fun updateItem(item: Item) {
        viewModelScope.launch {
            itemDao.updateItem(item)
        }
    }

    fun updatedItem(itemId: Int, itemName: String, itemPrice: String, quantity: String) {
        val updatedItem = Item(
            id = itemId,
            itemName = itemName,
            itemPrice = itemPrice.toDouble(),
            quantityInStock = quantity.toInt()
        )
        updateItem(updatedItem)
    }

    fun sellItem(item: Item) {
        if (item.quantityInStock > 0) {
            val newItem = item.copy(quantityInStock = item.quantityInStock - 1)
            updateItem(newItem)
        }
    }

    fun hasStock(item: Item): Boolean {
        return (item.quantityInStock > 0)
    }

    fun delete(item: Item) {
        viewModelScope.launch {
            itemDao.deleteItem(item)
        }
    }
}
