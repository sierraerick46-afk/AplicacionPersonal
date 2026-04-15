package com.example.aplicacionperfil.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.aplicacionperfil.viewmodel.ProfileViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    onNavigateToHobbies: (List<String>) -> Unit,
    onNavigateToPasatiempos: (List<String>) -> Unit,
    onNavigateToDeportes: (List<String>) -> Unit,
    onNavigateToIntereses: (List<String>) -> Unit,
    onNavigateToMusica: (List<String>) -> Unit,
    viewModel: ProfileViewModel = viewModel()
) {

    val userProfile = viewModel.userProfile.value
    val showExtraInfo by remember { mutableStateOf(viewModel.showExtraInfo.value) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Mi Perfil Personal") },
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
            if (userProfile != null) {
                val profile = userProfile


                item {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = profile.imagenPerfil),
                            contentDescription = "Foto de perfil",
                            modifier = Modifier
                                .size(120.dp)
                                .clip(CircleShape)
                        )
                    }
                }


                item {
                    Text(
                        text = profile.nombre,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = androidx.compose.ui.text.style.TextAlign.Center
                    )
                }


                item {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.secondaryContainer
                        )
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text("📚 ${profile.programa}", fontWeight = FontWeight.Medium)
                            Text("Semestre: ${profile.semestre}")
                        }
                    }
                }


                item {
                    Card(modifier = Modifier.fillMaxWidth()) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text("📜 Sobre mí", fontWeight = FontWeight.Bold)
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(profile.descripcion)
                        }
                    }
                }


                item {
                    var showMoreInfo by remember { mutableStateOf(false) }
                    Card(modifier = Modifier.fillMaxWidth()) {
                        Column(modifier = Modifier.padding(16.dp)) {

                            Text("ℹ️ Información", fontWeight = FontWeight.Bold)
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(" Edad: ${profile.edad} años")
                            Text(" Ciudad: ${profile.ciudad}")
                            Text(" Correo: ${profile.email}")


                            Spacer(modifier = Modifier.height(8.dp))
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable { showMoreInfo = !showMoreInfo },
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = if (showMoreInfo) "▲ Ver menos" else "▼ Ver más",
                                    color = MaterialTheme.colorScheme.primary
                                )
                            }


                            if (showMoreInfo) {
                                Spacer(modifier = Modifier.height(8.dp))
                                Divider()
                                Spacer(modifier = Modifier.height(8.dp))
                                Text("📏 Estatura: ${profile.estatura} m")
                                Text("🩸 RH: ${profile.rh}")
                                Text("🎂 Fecha de nacimiento: ${profile.fechaNacimiento}")
                                Text("🌎 Nacionalidad: ${profile.nacionalidad}")
                                Text("⚥ Sexo: ${profile.sexo}")
                            }
                        }
                    }
                }


                item {
                    Button(
                        onClick = { userProfile?.let { onNavigateToHobbies(it.hobbies) } },
                        modifier = Modifier.fillMaxWidth(),
                        shape = MaterialTheme.shapes.medium
                    ) {
                        Text("🎨 Ver Hobbies", fontSize = 18.sp)
                    }
                }


                item {
                    Button(
                        onClick = { userProfile?.let { onNavigateToPasatiempos(it.pasatiempos) } },
                        modifier = Modifier.fillMaxWidth(),
                        shape = MaterialTheme.shapes.medium
                    ) {
                        Text("🎭 Ver Pasatiempos", fontSize = 18.sp)
                    }
                }


                item {
                    Button(
                        onClick = { userProfile?.let { onNavigateToDeportes(it.deportes) } },
                        modifier = Modifier.fillMaxWidth(),
                        shape = MaterialTheme.shapes.medium
                    ) {
                        Text("🏆 Ver Deportes Favoritos", fontSize = 18.sp)
                    }
                }


                item {
                    Button(
                        onClick = { userProfile?.let { onNavigateToIntereses(it.intereses) } },
                        modifier = Modifier.fillMaxWidth(),
                        shape = MaterialTheme.shapes.medium
                    ) {
                        Text("✨ Ver Intereses Adicionales", fontSize = 18.sp)
                    }
                }


                item {
                    Button(
                        onClick = { userProfile?.let { onNavigateToMusica(it.gustosMusicales) } },
                        modifier = Modifier.fillMaxWidth(),
                        shape = MaterialTheme.shapes.medium
                    ) {
                        Text("🎧 Ver Gustos Musicales", fontSize = 18.sp)
                    }
                }


            }
        }
    }
}