package com.example.baguio

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CategoryViewModel: ViewModel() {
    val categories = MutableLiveData<List<Category>>()

    init {
        categories.value = listOf(
            Category("Coffee Shops"),
            Category("Restaurants"),
            Category("Kid-friendly Places"),
            Category("Parks"),
            Category("Shopping Centers")
        )
    }
}
