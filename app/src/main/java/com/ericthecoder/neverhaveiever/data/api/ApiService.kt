package com.ericthecoder.neverhaveiever.data.api

import com.ericthecoder.neverhaveiever.data.model.User
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getUsers(): Response<List<User>>
}
