package com.ericthecoder.neverhaveiever.data.repository

import com.ericthecoder.neverhaveiever.data.api.ApiHelper
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiHelper: ApiHelper) {

    suspend fun getUsers() = apiHelper.getUsers()
}
