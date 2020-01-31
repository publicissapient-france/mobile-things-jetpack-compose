package fr.pse.compose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.core.Alignment
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.core.setContent
import androidx.ui.foundation.DrawImage
import androidx.ui.foundation.HorizontalScroller
import androidx.ui.foundation.selection.Toggleable
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Image
import androidx.ui.layout.*
import androidx.ui.material.*
import androidx.ui.material.ripple.Ripple
import androidx.ui.material.surface.Card
import androidx.ui.res.imageResource
import androidx.ui.res.stringResource
import androidx.ui.tooling.preview.Preview

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    GeneralLayout {
        HorizontalScroller {
            Row(modifier = Spacing(16.dp)) {
                repeat(10) {
                    ArticleCard(sampleArticle)
                    WidthSpacer(width = 16.dp)
                }
            }
        }
    }
}

@Composable
fun GeneralLayout(children: @Composable() () -> Unit) {
    MaterialTheme {
        val appName = +stringResource(R.string.app_name)
        FlexColumn {
            inflexible {
                TopAppBar(title = {
                    Text(text = appName)
                })
            }
            flexible(flex = 1f, children = children)
        }
    }
}

@Composable
fun ArticleCard(article: Article) {
    val typography = +MaterialTheme.typography()
    val img = +imageResource(article.imageRes)

    Card(shape = RoundedCornerShape(8.dp)) {
        Column {
            Container(
                modifier = Height(160.dp) wraps ExpandedWidth,
                constraints = DpConstraints.tightConstraintsForWidth(310.dp)
            ) {
                DrawImage(image = img)
                Align(alignment = Alignment.TopRight) {
                    FavoriteIcon(article)
                }
            }
            Column(modifier = Spacing(8.dp) wraps ExpandedWidth) {
                Text(
                    text = article.title,
                    style = typography.h6.withOpacity(0.87f)
                )
                Text(
                    text = article.author,
                    style = typography.body2.withOpacity(0.87f)
                )
                Row(modifier = ExpandedWidth, arrangement = Arrangement.End) {
                    Button(
                        text = "Share",
                        style = TextButtonStyle(),
                        onClick = {}
                    )
                    Button(
                        text = "Read",
                        style = TextButtonStyle(),
                        onClick = {}
                    )
                }
            }
        }
    }
}

@Composable
fun FavoriteIcon(article: Article) {
    val heartIcon = +imageResource(R.drawable.favorite_border_white)
    val heartFullIcon = +imageResource(R.drawable.favorite_full_white)
    ToggleableIcon(
        checked = article.isFavorite,
        unToggledImage = heartIcon,
        toggledImage = heartFullIcon
    ) {
        article.isFavorite = it
    }

}

@Composable
fun ToggleableIcon(
    checked: Boolean,
    unToggledImage: Image,
    toggledImage: Image,
    onToggle: ((Boolean) -> Unit)? = null
) {
    Ripple(bounded = false) {
        Toggleable(
            value = checked,
            onValueChange = onToggle
        ) {
            Container(modifier = Spacing(12.dp) wraps Size(24.dp, 24.dp)) {
                val icon = if (checked) unToggledImage else toggledImage
                DrawImage(icon)
            }
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MaterialTheme {
        App()
    }
}