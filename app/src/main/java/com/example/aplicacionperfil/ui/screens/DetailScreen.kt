package com.example.aplicacionperfil.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.BrokenImage
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.platform.LocalContext
import com.example.aplicacionperfil.R
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.decode.DataSource
import coil.transform.CircleCropTransformation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    title: String,
    items: List<String>,
    onBackPressed: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(title) },
                navigationIcon = {
                    IconButton(onClick = onBackPressed) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Volver")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(items.size) { index ->
                val item = items[index]
                val imageUrl = getImageUrlForItem(title, item)
                val context = LocalContext.current

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        
                        AsyncImage(
                            model = ImageRequest.Builder(context)
                                .data(imageUrl)
                                .crossfade(true)
                                .error(R.drawable.ic_broken_image)
                                .placeholder(R.drawable.ic_loading)
                                .build(),
                            contentDescription = item,
                            modifier = Modifier
                                .size(60.dp)
                                .clip(RoundedCornerShape(12.dp)),
                            contentScale = ContentScale.Crop
                        )

                        Spacer(modifier = Modifier.width(16.dp))

                        Text(
                            text = item,
                            fontSize = 16.sp,
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            }
        }
    }
}


private fun getImageUrlForItem(title: String, item: String): String {
    val itemLower = item.lowercase()

    return when {
        title.contains("Hobbies") -> getHobbyUrl(itemLower)
        title.contains("Pasatiempos") -> getPasatiempoUrl(itemLower)
        title.contains("Deportes") -> getDeporteUrl(itemLower)
        title.contains("Intereses") -> getInteresUrl(itemLower)
        title.contains("Música") || title.contains("Gustos") -> getMusicaUrl(itemLower)
        else -> "https://picsum.photos/id/20/200/200"
    }
}

private fun getHobbyUrl(item: String): String {
    val noCache = "?random=${System.currentTimeMillis()}"
    return when (item) {
        "montar motocicleta" -> "https://picsum.photos/id/111/200/200$noCache"
        "leer libros de suspenso" -> "https://picsum.photos/id/24/200/200$noCache"
        "entrenar futbol" -> "https://picsum.photos/id/128/200/200$noCache"
        else -> "https://picsum.photos/id/20/200/200$noCache"
    }
}

private fun getPasatiempoUrl(item: String): String {
    val noCache = "?random=${System.currentTimeMillis()}"
    return when (item) {
        "ver series" -> "https://picsum.photos/id/0/200/200$noCache"
        "jugar videojuegos" -> "https://picsum.photos/id/0/200/200$noCache"
        "escuchar música" -> "https://picsum.photos/id/29/200/200$noCache"
        else -> "https://picsum.photos/id/20/200/200$noCache"
    }
}

private fun getDeporteUrl(item: String): String {
    val noCache = "?random=${System.currentTimeMillis()}"
    return when (item) {
        "futbol" -> "https://picsum.photos/id/128/200/200$noCache"
        "motociclismo" -> "https://picsum.photos/id/111/200/200$noCache"
        else -> "https://picsum.photos/id/20/200/200$noCache"
    }
}

private fun getInteresUrl(item: String): String {
    val noCache = "?random=${System.currentTimeMillis()}"
    return when (item) {
        "mecanica de motocicletas" -> "https://picsum.photos/id/111/200/200$noCache"
        "fotografia" -> "https://picsum.photos/id/250/200/200$noCache"
        "aprender a tocar instrumentos" -> "https://picsum.photos/id/29/200/200$noCache"
        else -> "https://picsum.photos/id/20/200/200$noCache"
    }
}

private fun getMusicaUrl(item: String): String {
    val noCache = "?random=${System.currentTimeMillis()}"
    return when (item) {
        "rock", "rock en español" -> "https://picsum.photos/id/29/200/200$noCache"
        "reggaeton" -> "https://picsum.photos/id/29/200/200$noCache"
        "rap" -> "https://picsum.photos/id/29/200/200$noCache"
        else -> "https://picsum.photos/id/20/200/200$noCache"
    }
}