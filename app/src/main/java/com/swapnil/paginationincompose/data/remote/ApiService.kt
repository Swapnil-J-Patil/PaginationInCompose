package com.swapnil.paginationincompose.data.remote

import com.swapnil.paginationincompose.data.remote.dto.CharacterResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("character")
    suspend fun getCharacters(@Query("page") page: Int): CharacterResponse
}
