package com.example.baguio

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RecommendationViewModel : ViewModel() {

    private val recommendations = MutableLiveData<List<Recommendation>>() // Declare this property

    fun loadRecommendations(category: String) {
        recommendations.value = when (category) {
            "Coffee Shops" -> listOf(
                Recommendation("Café by the Ruins", "Known for its ambiance and local delicacies.", R.drawable.cafe_by_the_ruins),
                Recommendation("Arca's Yard", "Cozy coffee shop with a mountain view.", R.drawable.arcas_yard),
                Recommendation("Choco-late de Batirol", "Famous for its traditional hot chocolate.", R.drawable.choco_late_de_batirol)
            )
            "Restaurants" -> listOf(
                Recommendation("Good Taste", "Popular for budget-friendly meals.", R.drawable.good_taste),
                Recommendation("Cafe by the Ruins", "Offers a great view and delicious dishes.", R.drawable.cafe_by_the_ruins1),
                Recommendation("The Hill Station", "Fusion cuisine with local ingredients.", R.drawable.hill_station)
            )
            "Kid-friendly Places" -> listOf(
                Recommendation("Burnham Park", "Activities like boating and biking.", R.drawable.burnham_park),
                Recommendation("Baguio Botanical Garden", "A beautiful garden to explore.", R.drawable.baguio_botanical_garden),
                Recommendation("Camp John Hay", "Outdoor activities and scenic walks.", R.drawable.camp_john_hay)
            )
            "Parks" -> listOf(
                Recommendation("Burnham Park", "Great for picnics and leisure.", R.drawable.burnham_park1),
                Recommendation("Wright Park", "Horseback riding and lovely scenery.", R.drawable.wright_park),
                Recommendation("Botanical Garden", "Peaceful spot with diverse plants.", R.drawable.botanical_garden)
            )
            "Shopping Centers" -> listOf(
                Recommendation("SM City Baguio", "A large mall with shopping and dining.", R.drawable.sm_city_baguio),
                Recommendation("Session Road", "Main street with various shops and boutiques.", R.drawable.session_road),
                Recommendation("Baguio Public Market", "Local crafts and fresh produce.", R.drawable.baguio_public_market)
            )
            else -> emptyList()
        }
    }

    fun getRecommendations(): MutableLiveData<List<Recommendation>> {
        return recommendations
    }
}
