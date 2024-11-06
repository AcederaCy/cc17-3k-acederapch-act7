package com.example.baguio

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecommendationAdapter(private var recommendations: List<Recommendation>) :
    RecyclerView.Adapter<RecommendationAdapter.RecommendationViewHolder>() {

    inner class RecommendationViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val title: TextView = view.findViewById(R.id.recommendationTitle)
        private val description: TextView = view.findViewById(R.id.recommendationDescription)
        private val image: ImageView = view.findViewById(R.id.recommendationImage)

        fun bind(recommendation: Recommendation) {
            title.text = recommendation.name
            description.text = recommendation.description
            image.setImageResource(recommendation.imageResId) // Use the image ID from Recommendation class
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendationViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recommendation_item, parent, false)
        return RecommendationViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecommendationViewHolder, position: Int) {
        holder.bind(recommendations[position])
    }

    override fun getItemCount(): Int = recommendations.size

    fun updateRecommendations(newRecommendations: List<Recommendation>) {
        recommendations = newRecommendations
        notifyDataSetChanged()
    }
}
