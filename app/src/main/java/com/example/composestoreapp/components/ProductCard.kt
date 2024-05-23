package com.example.composestoreapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.composestoreapp.R
import com.example.composestoreapp.models.Product
import com.example.composestoreapp.models.productList
import com.example.composestoreapp.ui.theme.PurpleGrey80

@Composable
fun ProductCard(
    product: Product,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = PurpleGrey80
        )
    ) {
        Column(
            modifier = Modifier.height(250.dp).padding(5.dp)
        ) {
            AsyncImage(
                model = product.image,
                contentDescription = null,
                modifier = Modifier.fillMaxWidth().weight(3f),
                placeholder = painterResource(R.drawable.ic_launcher_background),
                contentScale = ContentScale.Fit
            )

            Text(
                product.computedTitle,
                modifier = Modifier.fillMaxWidth().weight(0.5f),
                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 16.sp)
            )
            Text(
                product.category,
                modifier = Modifier.fillMaxWidth().weight(0.5f),
                style = TextStyle(fontWeight = FontWeight.W300, fontSize = 12.sp, color = Color.Gray)
            )
            Row(
                modifier = Modifier.fillMaxWidth().weight(1f),
            ) {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = null,
                    tint = Color.Yellow,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
                Text(product.rating.rate.toString(),modifier = Modifier.align(Alignment.CenterVertically))
                Spacer(modifier = Modifier.weight(1f))
                Box(
                    modifier = Modifier
                        .fillMaxWidth() // Para que ocupe todo el ancho disponible
                        .align(Alignment.CenterVertically)
                        .weight(1f)
                        .background(
                            color = Color.Magenta,
                            shape = RoundedCornerShape(8.dp) // Cambia el valor según lo redondeado que quieras los bordes
                        )
                        .padding(5.dp), // Padding interno del Box
                    contentAlignment = Alignment.Center // Alineación central del contenido dentro del Box
                ) {
                    Text(
                        text = product.computedPrice,
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }

            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun ProductCardPreview() {
    ProductCard(productList[0])
}