package fr.pse.compose

import androidx.compose.Model
import java.util.*

@Model
data class Article(
    private val id: String = UUID.randomUUID().toString(),
    val title: String,
    val imageRes: Int,
    val author: String,
    var isFavorite: Boolean = false
)

val sampleArticle = Article(
    title = "Android Jetpack is awesome",
    imageRes = R.drawable.androidjetpack,
    author = "PSE"
)
