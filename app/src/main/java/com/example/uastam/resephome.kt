package com.example.uastam

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

data class Recipe(
    val title: String,
    val description: String,
    val imageResId: Int
)

@Composable
fun resephome(navController: NavController) {
    val recipes = listOf(
        Recipe("Nasi Goreng", "Nasi Goreng: A popular Indonesian fried rice dish.", R.drawable.nasgorlignker),
        Recipe("Mie Goreng", "Mie Goreng: Stir-fried noodles with vegetables and protein.", R.drawable.migorlingker),
        Recipe("Soto Ayam", "Soto Ayam: A traditional chicken soup with a rich broth.", R.drawable.soyamlingker),
        Recipe("Rendang", "Rendang: Spicy beef stew slow-cooked in coconut milk.", R.drawable.rendanglingker),
        Recipe("Bakso", "Bakso: Indonesian meatball soup with noodles.", R.drawable.baksolingker),
        Recipe("Mie Ayam", "Mie Ayam: Chicken noodles with savory broth.", R.drawable.miyamlingker),
        Recipe("Sayur Sop", "Sayur Sop: Indonesian vegetable soup.", R.drawable.soplingker)
    )

    val boxColors = listOf(
        Color(0xFFFFCDD2),
        Color(0xFFC8E6C9),
        Color(0xFFBBDEFB),
        Color(0xFFFFF9C4),
        Color(0xFFD1C4E9),
        Color(0xFFFFE0B2),
        Color(0xFFB2DFDB)
    )

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            item {
                Text("Daftar Resep", fontSize = 24.sp, modifier = Modifier.padding(bottom = 16.dp))
            }
            items(recipes.size) { index ->
                val recipe = recipes[index]
                val painter = painterResource(id = recipe.imageResId)
                val backgroundColor = boxColors[index % boxColors.size]

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .background(backgroundColor, shape = RoundedCornerShape(8.dp))
                        .clickable { navController.navigate("resepdetail/$index") }
                        .padding(16.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(recipe.title, fontSize = 18.sp, color = Color.Black)
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(recipe.description, fontSize = 14.sp, color = Color.DarkGray)
                        }
                        Image(
                            painter = painter,
                            contentDescription = null,
                            modifier = Modifier
                                .size(80.dp)
                                .clip(CircleShape)
                                .background(Color.Gray, shape = CircleShape),
                            contentScale = ContentScale.Crop
                        )
                    }
                }
            }
        }
    }
}
