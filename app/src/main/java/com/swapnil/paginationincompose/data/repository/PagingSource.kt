package com.swapnil.paginationincompose.data.repository

import com.swapnil.paginationincompose.data.remote.ApiService
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.swapnil.paginationincompose.data.remote.dto.CharacterDto

class CharacterPagingSource(
    private val api: ApiService
) : PagingSource<Int, CharacterDto>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterDto> {
        return try {
            val page = params.key ?: 1
            val response = api.getCharacters(page)
            LoadResult.Page(
                data = response.results,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (response.info.next == null) null else page + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, CharacterDto>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(it)?.nextKey?.minus(1)
        }
    }
}

