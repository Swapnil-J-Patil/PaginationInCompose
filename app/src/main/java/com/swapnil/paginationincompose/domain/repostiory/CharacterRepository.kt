package com.swapnil.paginationincompose.domain.repostiory

import androidx.paging.Pager
import com.swapnil.paginationincompose.data.remote.dto.CharacterDto

interface CharacterRepository {
    fun getCharacters(): Pager<Int, CharacterDto>
}
