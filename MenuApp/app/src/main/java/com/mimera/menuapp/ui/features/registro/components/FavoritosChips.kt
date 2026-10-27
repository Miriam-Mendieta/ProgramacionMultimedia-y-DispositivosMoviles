package com.mimera.menuapp.ui.features.registro.components

import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun FavoritosChips(
    titulo: String,
    items: List<String>,
    seleccionados: Set<String>,
    onChange: (Set<String>) -> Unit
) {
    Text(
        text = titulo,
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.titleMedium,
        modifier = Modifier.padding(bottom = 5.dp)
    )

    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items.forEach { item ->
            val selected = seleccionados.contains(item)

            FilterChip(
                selected = selected,
                onClick = {
                    onChange(
                        if (selected) seleccionados - item else seleccionados + item
                    )
                },
                label = { Text(item) },
                leadingIcon = if (selected) {
                    { Icon(Icons.Default.Check, contentDescription = null) }
                } else null,
                modifier = Modifier.padding(4.dp)
            )
        }
    }
}
