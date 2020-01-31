package fr.pse.compose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.core.Alignment
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.core.setContent
import androidx.ui.engine.geometry.Shape
import androidx.ui.foundation.DrawImage
import androidx.ui.foundation.HorizontalScroller
import androidx.ui.foundation.VerticalScroller
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.graphics.Image
import androidx.ui.layout.*
import androidx.ui.material.*
import androidx.ui.material.surface.Card
import androidx.ui.res.imageResource
import androidx.ui.res.stringResource
import androidx.ui.tooling.preview.Preview

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Home()
            }
        }
    }
}

@Composable
fun Home() {
    Column {
        TopAppBar(
            title = { Text(text = +stringResource(R.string.app_name)) }
        )
        HorizontalScroller {
            Row(modifier = Spacing(bottom = 16.dp, left = 16.dp, top = 16.dp)) {
                listOf(
                    sampleArticle,
                    sampleArticle,
                    sampleArticle,
                    sampleArticle,
                    sampleArticle,
                    sampleArticle
                ).forEach {
                    ArticleItem(it)
                    WidthSpacer(width = 16.dp)
                }
            }
        }
    }
}

@Composable
fun ArticleItem(article: Article) {
    val isFavorite = +imageResource(R.drawable.favorite_full_white)
    val isNotFavorite = +imageResource(R.drawable.favorite_border_white)
    val typography = +MaterialTheme.typography()
    Container {
        Card(shape = RoundedCornerShape(8.dp), modifier = Spacing()) {
            Column {
                Container(
                    modifier = Height(100.dp) wraps ExpandedWidth,
                    constraints = DpConstraints.tightConstraintsForWidth(310.dp)
                ) {
                    DrawImage(image = +imageResource(R.drawable.androidjetpack))
                    Align(alignment = Alignment.TopRight) {
                        Padding(padding = 8.dp) {
                            Button(
                                modifier = Size(25.dp, 25.dp),
                                style = ButtonStyle(
                                    color = Color.Transparent,
                                    shape = RoundedCornerShape(8.dp)
                                ),
                                onClick = {
                                    article.isFavorite = !article.isFavorite
                                }
                            ) {
                                DrawImage(
                                    image = if (article.isFavorite)
                                        isFavorite else
                                        isNotFavorite
                                )
                            }
                        }
                    }
                }
                Padding(padding = 8.dp) {
                    Column {
                        Text(text = article.title, style = typography.h6)
                        Text(text = article.author)
                        Container(modifier = ExpandedWidth, alignment = Alignment.BottomRight) {
                            Button(text = "Read", modifier = Spacing(0.dp, 8.dp, 0.dp, 0.dp))
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MaterialTheme {
        Home()
    }
}