package com.swapnil.paginationincompose.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.swapnil.paginationincompose.data.remote.ApiService
import com.swapnil.paginationincompose.data.remote.dto.CharacterDto
import com.swapnil.paginationincompose.domain.repostiory.CharacterRepository
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val api: ApiService
) : CharacterRepository {

    override fun getCharacters(): Pager<Int, CharacterDto> {
        return Pager(
            config = PagingConfig(pageSize = 20),
            pagingSourceFactory = { CharacterPagingSource(api) }
        )
    }
}
