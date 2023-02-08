package com.example.inventory.utils

import com.example.inventory.model.Item
import java.text.NumberFormat

fun Item.getFormattedPrice(): String = NumberFormat.getCurrencyInstance().format(itemPrice)
