package com.example.baguio

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: CategoryViewModel
    private lateinit var adapter: CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[CategoryViewModel::class.java]

        adapter = CategoryAdapter(viewModel.categories.value ?: emptyList()) { categoryName ->
            Log.d("MainActivity", "Category clicked: $categoryName")
            val intent = Intent(this, RecommendationListActivity::class.java).apply {
                putExtra("CATEGORY_NAME", categoryName)
            }
            startActivity(intent)
        }

        val recyclerView: RecyclerView = findViewById(R.id.categoryRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
}
