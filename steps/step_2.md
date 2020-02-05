# Mobile Things - Step 2

# Requirements
Create the following Article.kt file
```
import androidx.compose.Model
import java.util.*

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
```

# Goal
Create our Article card

![image](./images/step_2.png)

# Hints
- Column / Row
- Text
- Card
- Padding
- +imageResource
- DrawImage
- Container
- Modifiers
- +MaterialTheme.typography()

[Next](./step_3.md)
