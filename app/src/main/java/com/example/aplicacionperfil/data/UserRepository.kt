package com.example.aplicacionperfil.data

import com.example.aplicacionperfil.R

data class UserProfile(
    val nombre: String,
    val programa: String,
    val semestre: Int,
    val edad: Int,
    val ciudad: String,
    val email: String,
    val estatura: String,
    val rh: String,
    val fechaNacimiento: String,
    val nacionalidad: String,
    val sexo: String,
    val descripcion: String,
    val hobbies: List<String>,
    val pasatiempos: List<String>,
    val deportes: List<String>,
    val intereses: List<String>,
    val gustosMusicales: List<String>,
    val imagenPerfil: Int
)

object UserRepository {
    fun getUserProfile(): UserProfile {
        return UserProfile(
            nombre = "Erick Javier Sierra Martinez",
            programa = "Ingeniería de Software",
            semestre = 5,
            edad = 19,
            ciudad = "Chia",
            email = "ejaviersierra@ucundinamarca.edu.co",
            estatura = "1.68",
            rh = "O+",
            fechaNacimiento = "19/12/2006",
            nacionalidad = "Colombiano",
            sexo = "Masculino",
            descripcion = "Estudiante de la Universidad de Cundinamarca, sumamente interesado por la programación, automotriz y tecnologias emergentes dentro del campo",
            hobbies = listOf("Montar motocicleta", "Leer libros de suspenso", "Entrenar futbol"),
            pasatiempos = listOf("Ver series", "Jugar videojuegos", "Escuchar música"),
            deportes = listOf("Futbol", "Motociclismo"),
            intereses = listOf("Mecanica de motocicletas", "Fotografia", "Aprender a tocar instrumentos"),
            gustosMusicales = listOf("Rock", "Rock en Español", "Reggaeton", "Rap"),
            imagenPerfil = R.drawable.foto_perfil
        )
    }
}