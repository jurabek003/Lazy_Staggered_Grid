package uz.turgunboyevjurabek.lazystaggeredgrid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridScope
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
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
                    columns = StaggeredGridCells.Fixed(2),
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
    Box(modifier = Modifier
        .background(itemList.color)
        .fillMaxWidth()
        .height(itemList.height)
        .clip(RoundedCornerShape(16.dp))
    )

}

data class ItemList(
    val height:Dp,
    val color:Color
)
