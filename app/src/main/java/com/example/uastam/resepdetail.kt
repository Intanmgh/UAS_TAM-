package com.example.uastam

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun resepdetail(navController: NavController, resepId: String?) {
    val recipes = listOf(
        "Nasi Goreng",
        "Mie Goreng",
        "Soto Ayam",
        "Rendang",
        "Bakso",
        "Mie Ayam",
        "Sayur Sop"
    )

    val recipeDetails = listOf(
        "Bahan-bahan Nasi Goreng:\n- Nasi\n- Minyak\n- Bawang putih\n- Telur\n- Kecap\n- Garam\n\nTata Cara Masak:\n1. Panaskan minyak di wajan.\n2. Tumis bawang putih hingga harum.\n3. Masukkan telur, buat orak-arik.\n4. Tambahkan nasi dan kecap, aduk rata.\n5. Tambahkan garam, aduk hingga matang.",
        "Bahan-bahan Mie Goreng:\n- Mie\n- Minyak\n- Bawang putih\n- Sayuran\n- Kecap\n- Garam\n\nTata Cara Masak:\n1. Rebus mie hingga matang, tiriskan.\n2. Panaskan minyak di wajan.\n3. Tumis bawang putih hingga harum.\n4. Masukkan sayuran, tumis sebentar.\n5. Tambahkan mie, kecap, dan garam, aduk hingga merata.",
        "Bahan-bahan Soto Ayam:\n- Ayam\n- Bumbu soto\n- Sayuran\n- Santan\n- Garam\n\nTata Cara Masak:\n1. Rebus ayam hingga matang, suwir-suwir.\n2. Tumis bumbu soto hingga harum.\n3. Masukkan sayuran, aduk rata.\n4. Tambahkan santan, masak hingga mendidih.\n5. Tambahkan ayam suwir dan garam, masak hingga bumbu meresap.",
        "Bahan-bahan Rendang:\n- Daging sapi\n- Santan\n- Bumbu rendang\n- Garam\n\nTata Cara Masak:\n1. Potong daging sapi sesuai selera.\n2. Tumis bumbu rendang hingga harum.\n3. Masukkan daging, aduk rata.\n4. Tambahkan santan, masak dengan api kecil.\n5. Tambahkan garam, masak hingga daging empuk dan bumbu meresap.",
        "Bahan-bahan Bakso:\n- Daging sapi\n- Tepung\n- Bumbu bakso\n- Garam\n\nTata Cara Masak:\n1. Giling daging sapi hingga halus.\n2. Campur daging dengan tepung dan bumbu bakso.\n3. Bentuk adonan menjadi bola-bola.\n4. Rebus bola-bola bakso hingga mengapung.\n5. Sajikan bakso dengan kuah kaldu.",
        "Bahan-bahan Mie Ayam:\n- Mie\n- Daging ayam\n- Kaldu ayam\n- Bawang merah\n- Bawang putih\n- Daun bawang\n- Kecap manis\n- Kecap asin\n- Garam\n\nTata Cara Masak:\n1. Rebus mie hingga matang, tiriskan.\n2. Suwir-suwir daging ayam yang telah direbus.\n3. Tumis bawang merah dan bawang putih hingga harum.\n4. Masukkan daging ayam suwir, aduk rata.\n5. Tambahkan kaldu ayam, kecap manis, kecap asin, dan garam, aduk hingga merata.",
        "Bahan-bahan Sayur Sop:\n- Wortel\n- Kentang\n- Buncis\n- Kol\n- Jagung\n- Daun bawang\n- Bawang putih\n- Kaldu ayam\n- Garam\n\nTata Cara Masak:\n1. Potong wortel, kentang, buncis, dan kol sesuai selera.\n2. Rebus air, masukkan kaldu ayam, bawang putih, dan garam.\n3. Masukkan semua sayuran, masak hingga matang.\n4. Taburkan daun bawang sebagai hiasan."
    )

    val recipeImages = listOf(
        R.drawable.nasgor_removebg_preview,
        R.drawable.migor_removebg_preview,
        R.drawable.soyam_removebg_preview,
        R.drawable.ini_resep_bumbu_rendang_daging_sapi_untuk_acara_spesial_removebg_preview,
        R.drawable.resep_bumbu_kuah_bakso_dan_bakso_sapi_enak_buat_kumpul_keluarga_removebg_preview,
        R.drawable.miyam_removebg_preview,
        R.drawable.sop_removebg_preview
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

    val recipeTitle = recipes.getOrNull(resepId?.toIntOrNull() ?: 0)
    val recipeDetail = recipeDetails.getOrNull(resepId?.toIntOrNull() ?: 0)
    val recipeImageResId = recipeImages.getOrNull(resepId?.toIntOrNull() ?: 0)
    val boxColor = boxColors.getOrNull(resepId?.toIntOrNull() ?: 0) ?: Color.Gray

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // AppBar with back button
            TopAppBar(
                title = { Text(text = recipeTitle ?: "Detail Resep") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                item {
                    // Image below title with rounded corners and appropriate size
                    recipeImageResId?.let { imageResId ->
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(boxColor, RoundedCornerShape(15.dp))
                                .padding(16.dp)
                                .align(Alignment.CenterHorizontally)
                        ) {
                            Image(
                                painter = painterResource(id = imageResId),
                                contentDescription = null,
                                modifier = Modifier
                                    .height(250.dp)
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(15.dp))
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Recipe details text with bold sections
                    recipeDetail?.let { detail ->
                        val annotatedDetail = buildAnnotatedString {
                            appendBold("Bahan-bahan")
                            append(detail.substringAfter("Bahan-bahan").substringBefore("Tata Cara Masak"))
                            appendBold("\nTata Cara Masak")
                            append(detail.substringAfter("Tata Cara Masak"))
                        }
                        Text(annotatedDetail, fontSize = 16.sp)
                    } ?: Text("Detail resep tidak ditemukan")
                }
            }
        }
    }
}

private fun AnnotatedString.Builder.appendBold(text: String) {
    pushStyle(SpanStyle(fontWeight = FontWeight.Bold))
    append(text)
    pop()
}