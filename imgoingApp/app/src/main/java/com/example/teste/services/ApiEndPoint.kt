package com.example.teste.services

import com.example.teste.dto.DtoUser
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface ApiEndPoint {
    @GET("usuarios")
    //users é api que está consumindo, por exemplo https://jsonplaceholder.typicode.com/users"
    fun obterUsuarios(): Call<List<DtoUser>>
    //User é o nome da classe, obterUsuario é o nome do metodo, : é mostrando o tipo do return

    @POST("usuarios")
    fun cadastrarUsuario(@Body dtoUser: DtoUser): Call<DtoUser>
}