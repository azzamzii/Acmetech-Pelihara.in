package com.acmetech.peliharain.data.network


import com.acmetech.peliharain.data.response.ResponseCatItem
import com.acmetech.peliharain.data.response.ResponseDogItem
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

object RetroInstance {
    var apiService: NewsApiService? = null
    fun getRetroInstance(): NewsApiService {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BASIC
        apiService = Retrofit.Builder()
            .baseUrl("https://backend-newspet-ewk4drcdjq-et.a.run.app")
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.Builder().addInterceptor(logging).build())
            .build().create(NewsApiService::class.java)

        return apiService!!
    }
}

interface NewsApiService {

    // CAT
    @GET("/Cat")
    suspend fun getNewsCat(): List<ResponseCatItem>
    @GET("/Cat/{id}")
    suspend fun getNewsById(@Path("id") id: Int): ResponseCatItem

    // DOG
    @GET("/Dog")
    suspend fun getNewsDog(): List<ResponseDogItem>

    @GET("/Dog/{id}")
    suspend fun getDogById(@Path("id") id: Int): ResponseDogItem

}
