
package dev.harryakbar.quran.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dev.harryakbar.quran.SurahsResponse
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET

private const val BASE_URL = "https://api.quran.com/api/v4/"

private val json = Json { ignoreUnknownKeys = true }

private val retrofit = Retrofit.Builder()
    .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()

interface QuranApiService {
    @GET("chapters")
    suspend fun getSurahs(): SurahsResponse
}

object QuranApi {
    val retrofitService: QuranApiService by lazy {
        retrofit.create(QuranApiService::class.java)
    }
}
