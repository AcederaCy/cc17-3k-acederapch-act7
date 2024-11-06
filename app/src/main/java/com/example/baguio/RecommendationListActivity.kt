package com.example.baguio

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecommendationListActivity : AppCompatActivity() {
    private lateinit var recommendationViewModel: RecommendationViewModel
    private lateinit var recommendationRecyclerView: RecyclerView
    private lateinit var categoryTitle: TextView
    private lateinit var adapter: RecommendationAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recommendation_list)

        // Initialize views
        recommendationRecyclerView = findViewById(R.id.recommendationRecyclerView)
        categoryTitle = findViewById(R.id.categoryTitle)

        // Get the category passed to this activity
        val category = intent.getStringExtra("CATEGORY")
        categoryTitle.text = category // Set the title

        // Initialize ViewModel
        recommendationViewModel = ViewModelProvider(this).get(RecommendationViewModel::class.java)

        // Set up RecyclerView
        adapter = RecommendationAdapter(emptyList()) // Initialize with an empty list
        recommendationRecyclerView.adapter = adapter
        recommendationRecyclerView.layoutManager = LinearLayoutManager(this)

        // Observe recommendations
        recommendationViewModel.getRecommendations().observe(this) { recommendations ->
            adapter.updateRecommendations(recommendations) // Update the adapter with new data
        }

        // Load recommendations for the category
        category?.let {
            recommendationViewModel.loadRecommendations(it)
        }
    }
}
