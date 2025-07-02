package com.swapnil.paginationincompose.data.remote.dto


data class CharacterInfo(
    val count: Int,
    val pages: Int,
    val next: String?,
    val prev: String?
)