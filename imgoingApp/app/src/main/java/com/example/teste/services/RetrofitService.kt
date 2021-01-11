package com.example.teste.services

import com.example.teste.services.ApiEndPoint
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {
        val baseUrl = "http://ec2-18-231-171-129.sa-east-1.compute.amazonaws.com:8080"
    //url base do json
    val api: ApiEndPoint? = criaRetrofit()?.create(ApiEndPoint::class.java)

    // ApiEndPoint é o nome da classe endPoints
    fun criaRetrofit(): Retrofit? {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)
        val gson = GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
            .create()
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(httpClient.build())
            .build()
    }
}