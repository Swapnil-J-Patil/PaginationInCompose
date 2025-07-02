package com.swapnil.paginationincompose.domain.use_case.character

import androidx.paging.PagingData
import com.swapnil.paginationincompose.data.remote.dto.CharacterDto
import com.swapnil.paginationincompose.domain.repostiory.CharacterRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class GetCharacterUseCase @Inject constructor(
    private val repository: CharacterRepository
) {
    operator fun invoke(): Flow<PagingData<CharacterDto>> {
        return repository.getCharacters().flow
    }
}