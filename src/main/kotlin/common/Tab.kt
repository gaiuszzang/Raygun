package common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Tab(
    modifier: Modifier = Modifier,
    list: List<String>,
    selectedIndex: Int,
    onSelect: (Int) -> Unit
) {
    Column (
        modifier = modifier
            .verticalScroll(rememberScrollState()),
    ) {
        list.forEachIndexed { index, tabTitle ->
            Text(
                modifier = Modifier
                    .clickable { onSelect(index) }
                    .background(color = if (selectedIndex == index) MaterialTheme.colors.primary else Color.Transparent, shape = RoundedCornerShape(5.dp))
                    .fillMaxWidth()
                    .padding(10.dp),
                color = if (selectedIndex == index) MaterialTheme.colors.onPrimary else MaterialTheme.colors.onBackground,
                text = tabTitle,
            )
        }
    }
}