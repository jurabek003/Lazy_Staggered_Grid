package uz.turgunboyevjurabek.lazystaggeredgrid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridScope
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.turgunboyevjurabek.lazystaggeredgrid.ui.theme.LazyStaggeredGridTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val items=(1..100).map {
            ItemList(
                height = Random.nextInt(100,300).dp,
                color = Color(
                    Random.nextLong(0xFFFFFFFF)
                ).copy(alpha = 1f)
            )
            
        }
        setContent {
            LazyStaggeredGridTheme {
                LazyVerticalStaggeredGrid(
                    columns = StaggeredGridCells.Fixed(3),
                    contentPadding = PaddingValues(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalItemSpacing = 10.dp
                ){
                    items(items){item ->
                        RandomBoxColor(itemList = item)
                    }
                }
            }
        }
    }
}

@Composable
fun RandomBoxColor(itemList: ItemList) {
    var expandedState  by remember{
        mutableStateOf(false)
    }
    val rotationState  by  animateFloatAsState(label = "",
        targetValue = if (expandedState) 180f else 0f
    )

    Card(modifier = Modifier
        .fillMaxWidth()
        .height(itemList.height)
        .clip(RoundedCornerShape(16.dp))
        .animateContentSize(
            animationSpec = tween(
                durationMillis = 400,
                easing = LinearOutSlowInEasing
            )
        )
        .clickable {
            expandedState = !expandedState
        }
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(itemList.color)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    modifier = Modifier
                        .weight(6f),
                    text = "My title",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.ExtraBold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                IconButton(onClick = {
                        expandedState = !expandedState
                    }, Modifier
                    .alpha(0.8f)
                    .weight(6f)
                    .rotate(rotationState))
                {
                    Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = null)
                }
            }

            if (expandedState){
                Text(text = "21:58:18.201 18614-18614 ViewRootIm...nActivity] uz....oyevjurabek.lazystaggeredgrid  I  ViewPostIme pointer 1" +
                        "2024-02-26 21:58:18.517 18614-18614 ViewRootIm...nActivity] uz....oyevjurabek.lazystaggeredgrid  I  ViewPostIme pointer 0" +
                        "2024-02-26 21:58:18.617 18614-18614 ViewRootIm...nActivity] uz....oyevjurabek.lazystaggeredgrid  I  ViewPostIme pointer 1" +
                        "2024-02-26 21:58:19.084 18614-18614 ViewRootIm...nActivity] uz....oyevjurabek.lazystaggeredgrid  I  ViewPostIme pointer 0" +
                        "2024-02-26 21:58:19.145 18614-18614 ViewRootIm...nActivity] uz....oyevjurabek.lazystaggeredgrid  I  ViewPostIme pointer 1" +
                        "2024-02-26 21:58:19.284 18614-18614 ViewRootIm...nActivity] uz....oyevjurabek.lazystaggeredgrid  I  ViewPostIme pointer 0" +
                        "2024-02-26 21:58:19.525 18614-18614 ViewRootIm...nActivity] uz....oyevjurabek.lazystaggeredgrid  I  ViewPostIme pointer 1" +
                        "2024-02-26 21:58:19.634 18614-18614 ViewRootIm...nActivity] uz....oyevjurabek.lazystaggeredgrid  I  ViewPostIme pointer 0" +
                        "2024-02-26 21:58:19.733 18614-18614 ViewRootIm...nActivity] uz....oyevjurabek.lazystaggeredgrid  I  ViewPostIme pointer 1" +
                        "2024-02-26 21:58:19.980 18614-18614 ViewRootIm...nActivity] uz....oyevjurabek.lazystaggeredgrid  I  ViewPostIme pointer 0" +
                        "2024-02-26 21:58:20.075 18614-18614 ViewRootIm...nActivity] uz....oyevjurabek.lazystaggeredgrid  I  ViewPostIme pointer 1" +
                        "2024-02-26 21:58:20.567 18614-18614 ViewRootIm...nActivity] uz....oyevjurabek.lazystaggeredgrid  I  ViewPostIme pointer 0" +
                        "2024-02-26 21:58:20.658 18614-18614 ViewRootIm...nActivity] uz....oyevjurabek.lazystaggeredgrid  I  ViewPostIme pointer 1 "
                , fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    maxLines = 4,
                    overflow = TextOverflow.Ellipsis
                )
            }

        }
    }

}

data class ItemList(
    val height:Dp,
    val color:Color
)
