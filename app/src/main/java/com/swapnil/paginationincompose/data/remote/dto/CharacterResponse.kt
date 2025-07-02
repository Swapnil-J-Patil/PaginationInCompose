package com.swapnil.paginationincompose.data.remote.dto

data class CharacterResponse(
    val info: CharacterInfo,
    val results: List<CharacterDto>
)
