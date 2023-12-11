package com.acmetech.peliharain.data.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import org.json.JSONObject

class ApiChatBot {
    private val client = OkHttpClient()

    suspend fun postMessage(input: String): String {
        val url = "https://chatbot-pet-ewk4drcdjq-et.a.run.app/chat"

        val requestBody = """
            {
                "input": "$input"
            }
        """.trimIndent()

        val mediaType = "application/json; charset=utf-8".toMediaType()
        val request = Request.Builder()
            .url(url)
            .post(requestBody.toRequestBody(mediaType))
            .build()

        val response: Response = withContext(Dispatchers.IO) {
            client.newCall(request).execute()
        }

        val responseBody = response.body?.string() ?: ""

        // Mengambil nilai response dari JSON
        val jsonResponse = JSONObject(responseBody)
        val responseText = jsonResponse.getString("response")

        return responseText
    }
}