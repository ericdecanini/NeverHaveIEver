package com.ericthecoder.neverhaveiever.data.api

import com.ericthecoder.neverhaveiever.data.model.User
import retrofit2.Response

interface ApiHelper {

    suspend fun getUsers(): Response<List<User>>
}
