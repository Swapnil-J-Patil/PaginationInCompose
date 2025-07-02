package com.swapnil.paginationincompose.presentation.character_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.swapnil.paginationincompose.domain.repostiory.CharacterRepository
import com.swapnil.paginationincompose.domain.use_case.character.GetCharacterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val getCharacterUseCase: GetCharacterUseCase
) : ViewModel() {

    val characters = getCharacterUseCase().cachedIn(viewModelScope)
}
